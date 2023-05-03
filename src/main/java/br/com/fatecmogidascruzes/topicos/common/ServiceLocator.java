package br.com.fatecmogidascruzes.topicos.common;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresource.validator.customer.ItinValidator;
import br.com.fatecmogidascruzes.topicos.common.impl.CaelumStellaITINValidator;

public class ServiceLocator {

	public static ItinValidator getItinValidator() {
		
		return new CaelumStellaITINValidator();
	}
}
