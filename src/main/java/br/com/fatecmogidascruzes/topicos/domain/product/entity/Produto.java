package br.com.fatecmogidascruzes.topicos.domain.product.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Codigo;

@Entity
public class Produto {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 public static final int CODIGO_LENGTN = 6;
	 @Column(length = CODIGO_LENGTN, nullable = false)
	 private String codigo;
	 
	 public static final int NOME_LENGTN = 100;
	 @Column(length = NOME_LENGTN, nullable = false)
	 private String nome;
	 
	 public static final int DESCRICAO_LENGTN = 200;
	 @Column(length = DESCRICAO_LENGTN, nullable = false)
	 public String descricao;
	 
	 @Column(nullable = false)
	 public float precoUnitario;
	 
	 @Column(nullable = false)
	 public int quantidadeEstoque;
	 
	 @Column(nullable = false)
	 public boolean perecivel;
	 
	 public Produto() {}
	 
	 public Produto(Codigo codigo, String nome, String descricao, 
			 		float precoUnitario, int quantidadeEstoque,
			 		boolean perecivel) {
		 
		 this.setCodigo(codigo);
		 this.setNome(nome);
		 this.setDescricao(descricao);
		 this.setPrecoUnitario(precoUnitario);
		 this.setQuantidadeEstoque(quantidadeEstoque);
		 this.setPerecivel(perecivel);
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = Objects.requireNonNull(codigo, "O codigo é necessario").getCodigo();
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
		return Double.toString(precoUnitario);
	}
	
	public float getPrecoUnitarioFloat() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String getQuantidadeEstoqueString() {
		return Integer.toString(quantidadeEstoque);
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
	
	public String isPerecivelString() {
		return Boolean.toString(perecivel);
	}
	
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	 
}
