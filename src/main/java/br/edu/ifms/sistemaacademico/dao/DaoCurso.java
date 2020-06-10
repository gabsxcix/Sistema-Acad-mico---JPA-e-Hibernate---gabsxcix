package br.edu.ifms.sistemaacademico.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifms.sistemaacademico.models.Curso;

/**
 * 
 * 
 * @author Gabriellen Vitorio
 * 
 */
public class DaoCurso implements InterfaceDaoCurso{

	
	//Insert
	public void cadastrar() {
		Curso curso = new Curso();
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cursos-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		int opcao = 0;
		
		System.out.println("Digite o codigo do curso: ");
		curso.setCodigo(sc.nextInt());
		limparBuffer(sc);
		System.out.println("Digite o nivel do curso:\n 1 - Ensino Fundamental"
				+ "\n2 - Ensino Médio\n 3 - Ensino Superior");
		curso.setNivel(sc.nextInt());
		limparBuffer(sc);
		System.out.println("Digite o nome do curso: ");
		curso.setNome(sc.nextLine());
		System.out.println("Digite o nome do campus: ");
		curso.setCampus(sc.nextLine());
		System.out.println("Digite a carga horaria: ");
		curso.setCargaHoraria(sc.nextInt());
		limparBuffer(sc);
		System.out.println("Digite o nome do coordenador: ");
		curso.setCoordenador(sc.nextLine());
		System.out.println("Informe se o curso está ativo ou inativo"
				+ "\n1 - Ativo \n2 - Inativo");
		curso.setSituacao(sc.hasNextInt());
		
		curso.setNivel(curso.getNivel());
		curso.setNome(curso.getNome());
		curso.setCampus(curso.getCampus());
		curso.setCargaHoraria(curso.getCargaHoraria());
		curso.setCoordenador(curso.getCoordenador());
		curso.setSituacao(curso.isSituacao());
		
		entityManager.persist(curso);
		
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		
		if(curso != null) {
			System.out.println("Curso cadastrado.");
		}
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	//Find All
	public ArrayList<Curso> buscarCursos(){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cursos-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Curso> cursos = entityManager.createQuery("from Curso", Curso.class).getResultList();
		cursos.forEach(curso -> {
			System.out.println(curso.toString());
		});
		
		entityManager.close();
		entityManagerFactory.close();
		
		return null;
	}
	
	//Update
	public void atualizar() {
		Curso curso = new Curso();
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cursos-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("Digite o codigo do curso que deseja atualizar");
		curso.setCodigo(sc.nextInt());
		
		curso = entityManager.find(Curso.class, curso.getCodigo());
		
		if(curso!=null) {
			System.out.println("Digite o codigo do curso: ");
			curso.setCodigo(sc.nextInt());
			limparBuffer(sc);
			System.out.println("Digite o nivel do curso:\n 1 - Ensino Fundamental"
					+ "\n2 - Ensino Médio\n 3 - Ensino Superior");
			curso.setNivel(sc.nextInt());
			limparBuffer(sc);
			System.out.println("Digite o nome do curso: ");
			curso.setNome(sc.nextLine());
			System.out.println("Digite o nome do campus: ");
			curso.setCampus(sc.nextLine());
			System.out.println("Digite a carga horaria: ");
			curso.setCargaHoraria(sc.nextInt());
			limparBuffer(sc);
			System.out.println("Digite o nome do coordenador: ");
			curso.setCoordenador(sc.nextLine());
			System.out.println("Informe se o curso está ativo ou inativo"
					+ "\n1 - Ativo \n2 - Inativo");
			curso.setSituacao(sc.hasNextInt());
			
			curso.setNivel(curso.getNivel());
			curso.setNome(curso.getNome());
			curso.setCampus(curso.getCampus());
			curso.setCargaHoraria(curso.getCargaHoraria());
			curso.setCoordenador(curso.getCoordenador());
			curso.setSituacao(curso.isSituacao());
			
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
		}else {
			System.out.println("Curso não encontrado.");
		}
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	//Delete
	public void excluir() {
		Curso curso = new Curso();
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cursos-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("Digite o codigo do curso que deseja exluir: ");
		curso.setCodigo(sc.nextInt());
		
		curso = entityManager.find(Curso.class, curso.getCodigo());
		
		if(curso!=null) {
			entityManager.remove(curso);
			
			entityManager.getTransaction().begin();
			entityManager.getTransaction().commit();
			
			System.out.println("Curso removido do banco");
		}else {
			System.out.println("Curso não encontrado");
		}
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	//Find
	public Curso buscar(int codigo) {
		Scanner sc = new Scanner(System.in);
		Curso curso = new Curso();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cursos-mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("Digite o codigo do curso que deseja buscar: ");
		curso.setCodigo(sc.nextInt());
		
		curso = entityManager.find(Curso.class, curso.getCodigo());
		
		if(curso != null) {
			System.out.println(curso.toString());
		}else {
			System.out.println("Tarefa não encontrada.");
		}
		
		entityManager.close();
		entityManagerFactory.close();
		
		return null;
	}
	
	private static void limparBuffer(Scanner sc) {
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
	}
	
}
