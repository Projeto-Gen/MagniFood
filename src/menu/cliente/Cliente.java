package menu.cliente;


public abstract class Cliente {

	private String nome;
	private String endereco;
	private String telefone;

	public Cliente(String nome, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//public String toString() {
		//return "Nome: " + nome + "\nEndereço: " + endereco + "\nTelefone: " + telefone;
	}


