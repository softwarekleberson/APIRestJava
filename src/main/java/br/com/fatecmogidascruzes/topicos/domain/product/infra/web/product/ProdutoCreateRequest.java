package br.com.fatecmogidascruzes.topicos.domain.product.infra.web.product;


import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Codigo;
import br.com.fatecmogidascruzes.topicos.domain.product.entity.Produto;

public class ProdutoCreateRequest {

	private String codigo;
	
	private String nome;
	
	private String descricao;
	
	private float precoUnitario;
	
	private int quantidadeEstoque;
	
	private boolean perecivel;
	
	public ProdutoCreateRequest() {

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

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precounitario) {
		this.precoUnitario = precounitario;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public boolean isPerecivel() {
		return perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	
	public Produto toDomain() {
		return new Produto(new Codigo(codigo), nome,
							descricao, precoUnitario,
							quantidadeEstoque, perecivel);
	}
	
}
