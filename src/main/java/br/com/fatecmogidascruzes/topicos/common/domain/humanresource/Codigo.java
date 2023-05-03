package br.com.fatecmogidascruzes.topicos.common.domain.humanresource;

public class Codigo {

	private String codigo;
	
	public Codigo(String codigo) {
		if(codigo.trim().length() != 6 ) {
			throw new IllegalArgumentException("Codigo de barra incorreto");
		}
		
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
}
