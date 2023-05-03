package br.com.fatecmogidascruzes.topicos.domain.customers.infra.web.customers;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Itin;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Phone;
import br.com.fatecmogidascruzes.topicos.domain.customers.entity.Customer;

public class CustomerCreateRequest {
	
	@NotEmpty
	@Size(min = Customer.ITIN_LENGTH, max = Customer.ITIN_LENGTH)
	private String itin;
	
	@NotEmpty
	@Size(max = Customer.MAX_NAME_LENGTH)
	private String name;
	
	@NotEmpty
	@Size(min = Customer.MIN_PHONE_LENGTH, max = Customer.MAX_PHONE_LENGTH)
	private String phone;
	
	@Email
	@Size(max = Customer.MAX_EMAIL_LENGTH)
	private String email;
	
	public CustomerCreateRequest() {}

	public String getItin() {
		return itin;
	}

	public void setItin(String itin) {
		this.itin = itin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Customer toDomain() {
		return new Customer(new Itin(itin), name, new Phone(phone), 
				new br.com.fatecmogidascruzes.topicos.common.domain.humanresource.Email(email)
				);
	}
}
