package br.edu.ifms.sistemaacademico.dao;

import java.util.ArrayList;

import br.edu.ifms.sistemaacademico.models.Curso;

/**
 * 
 * 
 * @author Gabriellen Vitorio
 * 
 */
public interface InterfaceDaoCurso {
	public void cadastrar ();
	public Curso buscar(int codigo);
	public ArrayList<Curso> buscarCursos();
	public void atualizar();
	public void excluir();
}
