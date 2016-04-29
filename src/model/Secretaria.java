package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@SuppressWarnings("unused")
@Entity
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Secretaria extends Pessoa {

}
