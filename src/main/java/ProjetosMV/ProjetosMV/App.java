package ProjetosMV.ProjetosMV;

import java.util.Scanner;

//import dao.HibernateUtil;
import dao.SorveteDAO;
import dao.impl.SorveteDAOImpl;
import util.JpaUtil;

public class App {
	public static void main(String[] args) {
		SorveteDAO ss = new SorveteDAOImpl();
		// Variaveis
		int i = 0;
		String sabor, calda, numero, casca;
		// Scanner
		Scanner ler = new Scanner(System.in);

		System.out.println("-----------------------------------");
		System.out.println("Gerenciamento de Sorvetes");
		System.out.println("-----------------------------------");
		System.out.println("Seja bem-vindo!! ");
		System.out.println("-----------------------------------");
		// While para fazer o loop do menu.
		while (true) {

			System.out.println("Escolha alguma das opções a baixo." + "\n1: Adicionar Sorvete" + "\n2: Remover Sorvete"
					+ "\n3: Ver os Sorvete" + "\n0: Sair");
			System.out.println("-----------------------------------");
			System.out.println("Digite o numero da opção: ");
			System.out.println("-----------------------------------");
			// Try / Catch para poder fazer o isolamento de futuros erros do usuario.
			try {
				// Aqui faz a conversão do tipo String para o tipo int
				numero = ler.nextLine();

				i = Integer.parseInt(numero);
				if (i == 0) {
					System.out.println("Sessão encerrada.");
					break;
				}
				// O isolamento do erro.
			} catch (NumberFormatException e) {
				System.out.println("-----------------------------------");
				System.out.println("Número inválido!");
				System.out.println("-----------------------------------");

			}
			// Switch para seleção dos menus
			switch (i) {
			// Adição dos sorvetes a lista
			case 1:
				ss.salvar(null);

				break;
			// Remoção dos sorvete da lista
			case 2:
				ss.remover(null);

				break;
			// Visualização dos sorvetes.
			case 3:
				ss.lista();
				break;

			default:

				System.err.println("A operação não foi concluida.");
				break;

			}
			System.out.println("---------------");
			System.out.println("Voltar ao menu: \n 0: Menu");
			numero = ler.nextLine();
			i = Integer.parseInt(numero);
		}
	}

}
