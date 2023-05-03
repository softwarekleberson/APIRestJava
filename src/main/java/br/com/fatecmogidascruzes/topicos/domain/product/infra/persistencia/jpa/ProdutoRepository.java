package br.com.fatecmogidascruzes.topicos.domain.product.infra.persistencia.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Optional<Produto> findByCodigo(String codigo);
}
