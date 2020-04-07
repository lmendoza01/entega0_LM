package entrega0;

public class Articulo extends Item{
	
	public Articulo(String nombreItem, double valorItem) {
		this.nombreItem = nombreItem;
		valor = valorItem;
	}

	@Override
	public boolean esDeTipo(String tipo) {
		return tipo == "articulo";
	}
		
}
