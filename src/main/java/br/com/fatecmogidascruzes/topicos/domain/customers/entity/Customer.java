package br.com.fatecmogidascruzes.topicos.domain.customers.entity;

import javax.persistence.*;

import org.apache.logging.log4j.util.Strings;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Email;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Itin;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Phone;

import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public static final int ITIN_LENGTH = 11;
    @Column(length = ITIN_LENGTH, nullable = false)
    private String itin;
    
    public static final int MAX_NAME_LENGTH = 100;
    @Column(length = MAX_NAME_LENGTH, nullable = false)
    private String name;
    
    public static final int MIN_PHONE_LENGTH = 10;
    public static final int MAX_PHONE_LENGTH = 11;
    @Column(length = MAX_PHONE_LENGTH)
    private String phone;
    
    public static final int MAX_EMAIL_LENGTH = 100;
    @Column(length = MAX_EMAIL_LENGTH)
    private String email;
    
    public Customer() {}
    
    public Customer(Itin itin ,String name) {
    	this.setItin(itin);
    	this.setName(name);
    }
    
    public Customer(Itin itin, String name, Phone phone, Email email) {
    	setItin(itin);
    	setName(name);
    	setPhone(phone);
    	setEmail(email);
    }
    
    public String getItin() {
        return itin;
    }

    public void setItin(Itin itin) {
    	 this.itin = Objects.requireNonNull(itin, "The ITIN is required").getNumber();
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
    	
		String tempName = Objects.requireNonNull(Strings.trimToNull(name), "The name is required");
		
		if (tempName.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("The name cannot have more than " + MAX_NAME_LENGTH + " chars.");
		}
		
		this.name = tempName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
    	 this.phone = phone == null ? null : phone.getNumber();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email == null ? null : email.getAddress();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
