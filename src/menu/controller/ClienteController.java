package menu.controller;

import java.util.ArrayList;

import menu.cliente.Cliente;
import menu.repository.ContaRepository;

public class ClienteController extends Cliente implements ContaRepository {
	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

	int numero = 0;

	public ClienteController(String nome, String endereco, String telefone) {
		super(nome, endereco, telefone);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public void cadastrar(Cliente conta) {
		listaClientes.add(conta);

		if (listaClientes != null) {
			gerarNumero();
			System.out.println("\nCadastro concluido com sucesso!\n");
			System.out.println("\n**************************************");
			System.out.println("Dados da Conta:            ");
			System.out.println("Nome do Usuário: " + conta.getNome());
			System.out.println("Endereço: " + conta.getEndereco());
			System.out.println("Telefone: " + conta.getTelefone());

		} else {
			System.out.println("Lista de clientes vazia!!");
		}

	}
	public int gerarNumero() {
		return ++numero;
	}


}
