package entrega0;

import entrega0.exceptions.*;

public abstract class Item {
	
	String nombreItem;
	
	Double valor;
	
	boolean fijado = false;
	
	public Double getValor() {
		return valor;
	}
	
	public void fijarValor() {
		fijado = true;
	}
	
	public void setValor(Double valor) {
		if(!fijado && valor > 0)
		this.valor = valor;
	}
	
	public abstract boolean esDeTipo(String tipo);
	
}
