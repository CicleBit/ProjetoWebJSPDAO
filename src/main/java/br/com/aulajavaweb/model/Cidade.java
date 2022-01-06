package br.com.aulajavaweb.model;
import java.sql.*;

public class Cidade {

	private int id;
	private String cidade;
	private String estado;
	
	public int getId() {
		return id;
	}


	public String getCidade() {
		return cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Cidade [id=" + id + ", cidade=" + cidade + ", estado=" + estado + ", getId()=" + getId()
				+ ", getCidade()=" + getCidade() + ", getEstado()=" + getEstado() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
		
}
