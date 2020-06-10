package br.edu.ifms.sistemaacademico.app;

import java.util.Scanner;

import br.edu.ifms.sistemaacademico.dao.DaoCurso;
import br.edu.ifms.sistemaacademico.models.Curso;

public class Main {
	
/**
 * 
 * 
 * @author Gabriellen Vitorio
 * 
 */

	public static void main(String[] args) {
		
		Curso curso = new Curso();
		DaoCurso daocurso = new DaoCurso();
		Scanner sc = new Scanner(System.in);
		int op;
		
		do {
			System.out.println("Digite o número correspondente a opção desejada:");
			System.out.println("1 - Cadastrar curso");
			System.out.println("2 - Editar curso");
			System.out.println("3 - Excluir curso");
			System.out.println("4 - Listar todos os cursos");
			System.out.println("5 - Buscar curso");
			System.out.println("0 - Finalizar programa");
	
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				daocurso.cadastrar();
				break;
			case 2:
				daocurso.atualizar();
				break;
			case 3:
				daocurso.excluir();
				break;
			case 4:
				daocurso.buscarCursos();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Opção Invalida");
			}
		}while(op!=0);
	}

}
