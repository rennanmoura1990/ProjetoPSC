package beans;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import model.enums.TiposUsuarios;

/**
 * Servlet Filter implementation class UsuarioFilter
 */
@WebFilter(filterName = "Authentication")
public class UsuarioFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UsuarioFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String redireciona = null;
		HttpSession sessao = req.getSession(false);
		if (sessao == null || sessao.getAttribute("usuario") == null) {
			// RequestDispatcher dis =
			// request.getRequestDispatcher("/index.xhtml");
			// dis.forward(request, response);
			if (uri.contains("/secretaria") || uri.contains("/professor") || uri.contains("/coordenador")
					|| uri.contains("/aluno") || uri.contains("/adm")) {
				redireciona = req.getContextPath() + "/index.xhtml";
				// se eu acessar qualquer página dentro dessas pastas,se a
				// sessão tiver nula,volta pra tela de login :)
			}
		} else {
			if (uri.contains("/coordenador") && (!UsuarioBean.temPapel(TiposUsuarios.COORDENADOR))) {
				res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}
		if (redireciona != null) {
			res.sendRedirect(redireciona);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
