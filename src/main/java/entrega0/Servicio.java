package entrega0;

public class Servicio extends Item {
	
	public Servicio(String nombreItem, double valorItem) {
		this.nombreItem = nombreItem;
		valor = valorItem;
	}
	
	@Override
	public boolean esDeTipo(String tipo) {
		return tipo == "servicio";
	}
}
