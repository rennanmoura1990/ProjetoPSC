package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import exception.GeralException;
import fachada.IFachada;
import model.Horarios;
import model.enums.Dias_semana;


@ManagedBean
public class disciplinaBean {
	Horarios disciplina = new Horarios();
	IFachada fachada;
	List<Dias_semana> dias_Semana;
	Horarios[] horarios;
	Horarios horario;
	
	
	
	
	
	/**
	 * @return the horario
	 */
	public Horarios getHorario() {
		return horario;
	}
	/**
	 * @param horario the horario to set
	 */
	public void setHorario(Horarios horario) {
		this.horario = horario;
	}
	/**
	 * @return the disciplina
	 */
	public Horarios getDisciplina() {
		return disciplina;
	}
	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(Horarios disciplina) {
		this.disciplina = disciplina;
	}
	/**
	 * @return the fachada
	 */
	public IFachada getFachada() {
		return fachada;
	}
	/**
	 * @param fachada the fachada to set
	 */
	public void setFachada(IFachada fachada) {
		this.fachada = fachada;
	}
	/**
	 * @return the dias_Semana
	 */
	public List<Dias_semana> getDias_Semana() {
		return dias_Semana;
	}
	/**
	 * @param dias_Semana the dias_Semana to set
	 */
	public void setDias_Semana(List<Dias_semana> dias_Semana) {
		this.dias_Semana = dias_Semana;
	}
	/**
	 * @return the horarios
	 */
	public Horarios[] getHorarios() {
		Horarios[] horarios = null;
		
		try {
			horarios = (Horarios[]) fachada.horarios().toArray();
			System.out.println("leu horarios" + horarios.toString());
			
		} catch (GeralException e) {
			
			 FacesContext.getCurrentInstance().addMessage("horario",
					 new FacesMessage("horario não encontrada"));
		}
		System.out.println("leu horarios" + horarios.toString());
		return horarios;
	}
	/**
	 * @param horarios the horarios to set
	 */
	public void setHorarios(Horarios[] horarios) {
		this.horarios = horarios;
	}

}
