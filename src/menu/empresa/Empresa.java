package menu.empresa;

import java.util.ArrayList;
import java.util.List;
import menu.repository.ProdutoRepository;


public class Empresa implements ProdutoRepository{
	List<String> produtos = new ArrayList<String>();
	 
	private int numero;

	private String nomeEmpresa;
	private String enderecoEmpresa;
	private int cnpj;

	public Empresa(String nomeEmpresa, String enderecoEmpresa, int cnpjEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
		this.enderecoEmpresa = enderecoEmpresa;
		this.cnpj = cnpjEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	public void visualizar() {
		System.out.println("Empresa: " + getNomeEmpresa());
	} 

	@Override
	public void adicionarProduto(String produto) {
		produtos.add(produto);
		
	}

	@Override
	public void deletarProduto(String produto) {
		produtos.remove(produto);
		
	}
	
	public String buscaNomeEmpresa(int cnpj){
		if (cnpj == this.cnpj) {
			return this.nomeEmpresa;
		}
		return null;
		
	}
	public String exibirProdutos() {
		System.out.println(produtos);
		return nomeEmpresa;
	}
	
	
	public int gerarNumero() {
		return ++numero;
	}
	
	public void getNumero(int numero) {
		this.numero = numero;
	}
	
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	public List<String> getProdutos() {
		return produtos;
	}
	
	public static Empresa buscarEmpresa(List<Empresa> empresas, int cnpj) {
		for (Empresa empresa : empresas) {
			if (empresa.getCnpj() == cnpj) {
				return empresa;
			}
		}
		return null;
	}

	
	
}	
