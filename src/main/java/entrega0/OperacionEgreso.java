package entrega0;

import java.util.ArrayList;
import java.util.List;

import entrega0.exceptions.*;

public class OperacionEgreso {
	
	boolean operacionAbierta = true;
	List<Item> listaObjetos = new ArrayList<Item>();
	String documentoAsociado;
	
	public void cerrarOperacion() {
		operacionAbierta = false;
		listaObjetos.stream().forEach(item -> item.fijarValor());
	}
	
	public void setItem(Item nuevo_item) {
		if(operacionAbierta) {
			listaObjetos.add(nuevo_item);
		}
	}
	
	public void removeFirstItem() {
			listaObjetos.remove(0); //remueve el primer elemento
	}
	
	public Double calcularValor() {	
		return listaObjetos.stream().map(item -> item.getValor()).reduce(0.0,(a,b)-> a + b);
	}
	
	public boolean puedeGenerarRemito() {
		return listaObjetos.stream().allMatch(item -> item.esDeTipo("articulo"));
	}
	
	public void generarRemito() throws OperacionSinRemitoException {
		if(this.puedeGenerarRemito())
			documentoAsociado = "Remito";
		else
	    throw new OperacionSinRemitoException("No puede generar remito, no todos los ítems son artículos");
		
	}
}
