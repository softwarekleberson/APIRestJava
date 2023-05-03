package br.com.fatecmogidascruzes.topicos.domain.product.usecase;

import java.util.List;
import java.util.Optional;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Produto;
import br.com.fatecmogidascruzes.topicos.domain.product.infra.persistencia.jpa.ProdutoRepository;

public class CrudProduto {

	private ProdutoRepository produtoRepository;
	
	public CrudProduto(ProdutoRepository produtoRepository) {
		
		this.produtoRepository = produtoRepository;
	}

	public void executeCreate(Produto produto) {
		produtoRepository.save(produto);
	}

	public List<Produto> executeAllListProduto() {
		return produtoRepository.findAll();
	}

	public boolean executeDelete(String codigo) {
		Optional<Produto> produto = produtoRepository.findByCodigo(codigo);
		if(produto.isPresent()) {
			produtoRepository.delete(produto.get());
			return true;
		}
		return false;
	}

	public boolean executeUpdate(Produto produto) {
		
		Optional<Produto> optProduto = produtoRepository.findByCodigo(produto.getCodigo());
		
		if(optProduto.isPresent()) {
			Produto database = optProduto.get();
			database.setNome(produto.getNome());
			database.setDescricao(produto.getDescricao());
			database.setPrecoUnitario(produto.getPrecoUnitarioFloat());
			database.setQuantidadeEstoque(produto.getQuantidadeEstoque());
			database.setPerecivel(produto.isPerecivel());
			produtoRepository.save(database);
			return true;
		}
		return false;
	}
	
}
