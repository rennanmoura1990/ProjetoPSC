package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Secretaria extends Pessoa {
	
}
