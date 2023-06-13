package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import menu.empresa.Empresa;
import menu.util.Cores;
import menu.controller.ClienteController;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		Set<String> carrinhoRetirada = new HashSet<String>();
		

		List<String> produtosGeral = new ArrayList<String>();

		List<Empresa> empresas = new ArrayList<>();
		ClienteController Cliente = new ClienteController(null, null, null);
		int opcao, numero = 0, cnpj, opcao2, cnpjSelecionado;
		String nome, endereco, produto, telefone, produtoDesejado;

		Empresa empresa1 = new Empresa("Padaria Gen ", "Rua 22 - \nHorário para retirada 19:30hrs ás 20hrs ", 40028922);
		Empresa empresa2 = new Empresa("Padaria Americanas", "Rua São João  \nHorário para retirada 20:30hrs ás 21hrs",
				40028923);
		Empresa empresa3 = new Empresa("Padaria +Doce", "Rua 50 - \nHorário para retirada 23:40hrs ás 23:55hrs",
				40028921);
		Empresa empresaSelecionada = new Empresa(null, null, 0);

		empresas.add(empresa1);
		empresas.add(empresa2);
		empresas.add(empresa3);

		while (true) {

			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGTH + Cores.ANSI_BLACK_BLACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("             SEJA BEM VINDO(A) A MAGNIFOOD!          ");
			System.out.println("                      MENU                           ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("           1 - Cadastro de Usuário                   ");
			System.out.println("           2 - Listar Empresas                       ");
			System.out.println("           3 - Buscar Produtos                       ");
			System.out.println("           4 - Login Empresa                         ");
			System.out.println("           0 - Sair                                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("           Entre com a opção desejada:               ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Operação finalizada!!");
				if (carrinhoRetirada.isEmpty()) {
					System.out.println("Obrigada por utilizar nosso Sistema!");
				} else {
					System.out.println("Retire seus seguintes produtos: " + carrinhoRetirada + "\nEstabelecimento: "
							+ empresaSelecionada.getNomeEmpresa() + "\nRetire no Endereço: "
							+ empresaSelecionada.getEnderecoEmpresa());

					System.out.println("Obrigada por utilizar nosso Sistema!");
				}

				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Usuário:\n\n");

				System.out.println("Digite seu Nome: ");
				leia.skip("\\R?");
				nome = leia.nextLine();

				System.out.println("Digite seu Endereço: ");
				endereco = leia.nextLine();

				System.out.println("Digite seu Telefone: ");
				telefone = leia.nextLine();

				Cliente.cadastrar(new ClienteController(nome, endereco, telefone));

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Empresas:\n\n ");

				for (Empresa empresa : empresas) {
					empresa.visualizar();
				}

				keyPress();
				break;

			case 3:

				System.out.println(Cores.TEXT_WHITE_BOLD + "Buscar produtos: ");
				
				
				for (var item : produtosGeral) {
					System.out.println(item);
				} 
				
				// empresaSelecionada.exibirProdutos();
				
				do {
					System.out.println("Digite o produto que você deseja: ");
					produtoDesejado = leia.next();

					List<String> produtos = empresaSelecionada.getProdutos();

	
					produtosGeral.addAll(produtos);

					if (produtosGeral.contains(produtoDesejado)) {
						System.out.println("Produto adicionado ao carrinho " + produtoDesejado);
						carrinhoRetirada.add(produtoDesejado);
						produtosGeral.remove(produtoDesejado);
					} else {
						System.out.println("Produto não encontrado! Digite um produto da nossa lista");

					}

					System.out.println("Deseja finalizar o carrinho? (1)SIM /(2)NÃO");
					opcao2 = leia.nextInt();

				} while (opcao2 == 2);

				System.out.println("Carrinho finalizado!");
				keyPress();
				break;

			case 4:

				System.out.println("Coloque o CNPJ do estabelecimento para validação: ");
				cnpjSelecionado = leia.nextInt();

				empresaSelecionada = Empresa.buscarEmpresa(empresas, cnpjSelecionado);

				if (empresaSelecionada != null) {
					System.out.println(Cores.TEXT_WHITE_BOLD + "Seja Bem-Vindo " + empresaSelecionada.getNomeEmpresa()
							+ " ao Menu de Produtos para empresas:\n\n ");

					System.out.println(Cores.TEXT_WHITE_BOLD + " 1 - Cadastrar Produto");
					System.out.println(Cores.TEXT_WHITE_BOLD + " 2 - Deletar Produto");
					opcao2 = leia.nextInt();

					switch (opcao2) {

					case 1 -> {
						System.out.println(Cores.TEXT_WHITE_BOLD + "Digite o nome do produto ");
						produto = leia.next();
						
				
						produtosGeral.add(produto);
						
						empresaSelecionada.adicionarProduto(produto);
						System.out.println("Produto adicionado: " + produto);

					}

					case 2 -> {
						System.out.println(Cores.TEXT_WHITE_BOLD + "Digite o nome do produto ");
						produto = leia.next();
					
						produtosGeral.remove(produto);
						
						empresaSelecionada.deletarProduto(produto);
						System.out.println("Produto removido: " + produto);

					}
					}
				} else
					System.out.println("CNPJ não cadastrado no nosso sistema!!");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}

	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}
