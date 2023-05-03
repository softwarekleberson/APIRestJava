package br.com.fatecmogidascruzes.topicos.common.impl;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.validator.customer.ItinValidator;

public class CaelumStellaITINValidator implements ItinValidator {

	@Override
	public boolean isValid(String itin) {
		
		CPFValidator cpfValidator = new CPFValidator();
		
		try {
			cpfValidator.assertValid(itin);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

}
