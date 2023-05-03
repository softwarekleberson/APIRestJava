package br.com.fatecmogidascruzes.topicos.domain.product.infra.web.product;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Produto;

public class ProdutoPM {

	private String codigo;
	private String nome;
	private String descricao;
	private String precoUnitario;
	private String quantidadeEstoque;
	private String perecivel;
	
	public ProdutoPM(Produto produto) {
		
		setCodigo(produto.getCodigo());
		setNome(produto.getNome());
		setDescricao(produto.getDescricao());
		setPrecoUnitario(produto.getPrecoUnitario());
		setQuantidadeEstoque(produto.getQuantidadeEstoqueString());
		setPerecivel(produto.isPerecivelString());
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(String precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(String quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getPerecivel() {
		return perecivel;
	}
	
	public void setPerecivel(String perecivel) {
		this.perecivel = perecivel;
	}
	
}
