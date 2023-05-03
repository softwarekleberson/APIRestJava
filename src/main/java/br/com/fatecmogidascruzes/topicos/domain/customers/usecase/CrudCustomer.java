package br.com.fatecmogidascruzes.topicos.domain.customers.usecase;

import java.util.List;
import java.util.Optional;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Email;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Phone;
import br.com.fatecmogidascruzes.topicos.domain.customers.entity.Customer;
import br.com.fatecmogidascruzes.topicos.domain.customers.infra.persistencia.jpa.CustomerRepository;

public class CrudCustomer {

	private CustomerRepository customerRepository;
	
	public CrudCustomer (CustomerRepository customerRepository) {
		
		this.customerRepository = customerRepository;
	}
	
	public void executeCreate(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> executeAllListCustomer(){
		return customerRepository.findAll();
	}

	public boolean executeDelete(String itin) {
		Optional<Customer> customer = customerRepository.findByItin(itin);
        if(customer.isPresent()) {
            customerRepository.delete(customer.get());
            return true;
        }
        return false;
	}

	public boolean executeUpdate(Customer customer) {
		
		Optional<Customer> opDatabaseCustomer = customerRepository.
		findByItin(customer.getItin());
				
        if(opDatabaseCustomer.isPresent()) {
            Customer databaseCustomer = opDatabaseCustomer.get();
            databaseCustomer.setName(customer.getName());
            databaseCustomer.setEmail(new Email(customer.getEmail()));
            databaseCustomer.setPhone(new Phone(customer.getPhone()));
            customerRepository.save(databaseCustomer);
            return true;
        }
        return false;
        
	}

	public Optional<Customer> executeFindByItin(String itin) {
		return customerRepository.findByItin(itin);
	}
	
	
}
