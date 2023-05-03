package br.com.fatecmogidascruzes.topicos.domain.customers.infra.persistencia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecmogidascruzes.topicos.domain.customers.entity.Customer;

import java.util.Optional;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    Optional<Customer> findByItin(String itin);

}
