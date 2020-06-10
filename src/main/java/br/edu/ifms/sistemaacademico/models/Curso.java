package br.edu.ifms.sistemaacademico.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 * @author Gabriellen Vitorio
 * 
 */

@Entity
@Table(name="cursos")
public class Curso {
	@Id
	private int codigo;
	private int nivel;
	private String nome;
	private String campus;
	private int cargaHoraria;
	private String coordenador;
	private boolean situacao;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
		
	public String toString() {
		
		switch(nivel) {
		case 1:
			System.out.println("Nivel Fundamental");
			break;
		case 2:
			System.out.println("Nivel Medio");
			break;
		case 3:
			System.out.println("Nivel Superior");
			break;
		}
		
		int opcao = 0;
		if (opcao == 1) {
			situacao = true;
		}else if(opcao == 2) {
			situacao = false;
		}
		
		return String.format("Codigo: %d\nNivel: %s\nNome: %s\nCampus: %s\nCarga Horaria: %s\nCoordenador: %s\nSituacao: %s\n", this.codigo, this.nivel, this.nome, this.campus, this.cargaHoraria, this.coordenador, this.situacao?"Ativo":"Inativo");
	}
	
	
}
