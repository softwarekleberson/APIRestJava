package br.com.fatecmogidascruzes.topicos.common.domain.humanresource;

import java.util.Objects;

import br.com.fatecmogidascruzes.topicos.common.ServiceLocator;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.validator.customer.ItinValidator;

public class Itin {

	private final String number;

	public Itin(String number) {

		String tempNumber = Objects.requireNonNull(number, "The ITIN cannot be null");

		ItinValidator itinValidator = ServiceLocator.getItinValidator();

		if (itinValidator.isValid(tempNumber)) {
			this.number = tempNumber.replace("[^\\d]", "");

		} else {
			throw new IllegalArgumentException("The provided ITIN is invalid.");
		}
	}

	public String getNumber() {
		return number;
	}
}
