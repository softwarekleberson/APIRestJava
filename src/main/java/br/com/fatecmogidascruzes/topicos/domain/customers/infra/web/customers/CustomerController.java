package br.com.fatecmogidascruzes.topicos.domain.customers.infra.web.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.fatecmogidascruzes.topicos.domain.customers.entity.Customer;
import br.com.fatecmogidascruzes.topicos.domain.customers.infra.persistencia.jpa.CustomerRepository;
import br.com.fatecmogidascruzes.topicos.domain.customers.usecase.CrudCustomer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public void create(@RequestBody @Valid CustomerCreateRequest customerCreationRequest,
                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        
        new CrudCustomer(customerRepository).executeCreate(customerCreationRequest.toDomain());
    }

    @GetMapping
    public List<CustomerPM> getAll() {
        return new CrudCustomer(customerRepository).
        					    executeAllListCustomer()
        					    .stream()
        					    .map(CustomerPM::new)
        					    .collect(Collectors.toList());
    }

    @GetMapping("/{itin}")
    public Optional<CustomerPM> getByItin(@PathVariable String itin) {
    	Optional<Customer> opCustomer = customerRepository.findByItin(itin);
    	if(opCustomer.isPresent()) {
    		return Optional.of(new CustomerPM(opCustomer.get()));
    	}
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{itin}")
    public void deleteByItin(@PathVariable String itin) {
    	boolean found = new CrudCustomer(customerRepository).executeDelete(itin);
        new CrudCustomer(customerRepository).executeDelete(itin);
        
        if(!found) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{itin}")
    public void updateByItin(@PathVariable String itin,
                             @RequestBody Customer customer) {
    	
        boolean found = new CrudCustomer(customerRepository).executeUpdate(customer);
        if(!found) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
