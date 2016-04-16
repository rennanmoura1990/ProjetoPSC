package model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Pessoa {
	@Id
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private List<Telefones> telefones;
	@Temporal(TemporalType.DATE)
	private Calendar dtnasc;
	
}
