package br.com.fatecmogidascruzes.topicos.domain.product.infra.web.product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fatecmogidascruzes.topicos.domain.product.entity.Produto;
import br.com.fatecmogidascruzes.topicos.domain.product.infra.persistencia.jpa.ProdutoRepository;
import br.com.fatecmogidascruzes.topicos.domain.product.usecase.CrudProduto;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	public void create (@RequestBody @Valid ProdutoCreateRequest produtoCreationRequest,
            			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		new CrudProduto(produtoRepository).executeCreate(produtoCreationRequest.toDomain());
	}
	
    @GetMapping
	public List<ProdutoPM> getAll(){
		return new CrudProduto(produtoRepository).
				executeAllListProduto().
				stream().
				map(ProdutoPM::new).
				collect(Collectors.toList());	
	}
    
    @GetMapping("/{codigo}")
    public Optional<ProdutoPM> getByCodigo(@PathVariable String codigo){
    	Optional<Produto> optProduto = produtoRepository.findByCodigo(codigo);
    	if(optProduto.isPresent()) {
    		return Optional.of(new ProdutoPM(optProduto.get()));
    	}
    	
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{codigo}")
    public void deleteByCodigo(@PathVariable String codigo) {
    	boolean found = new CrudProduto(produtoRepository).executeDelete(codigo);
    	
    	 if(!found) {
         	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         }
    }
    
    @PutMapping("/{codigo}")
    public void updateByCodigo(@PathVariable String codigo, @RequestBody Produto produto){ {
    	boolean found = new CrudProduto(produtoRepository).executeUpdate(produto);
    	if(!found) {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
    }
    	
  }
    
}
