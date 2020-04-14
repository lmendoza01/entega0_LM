package entrega0;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entrega0.exceptions.*;

public class OperacionEgresoTest {

	Articulo artPrueba = new Articulo("articulo",10.5);
	
	Servicio serPrueba = new Servicio("servicio",25.5);
	
	OperacionEgreso operacionPrueba = new OperacionEgreso();

	@Before
	public void before() {
		
		operacionPrueba.setItem(artPrueba);
		operacionPrueba.setItem(serPrueba);	
	}
	
	@Test
	public void testCalculaValorCorrecto() {
		Assert.assertEquals(operacionPrueba.calcularValor(),artPrueba.getValor()+serPrueba.getValor(),0);
	}
	
	@Test
	
	public void testOperacionVacia() {
		operacionPrueba.removeFirstItem();
		operacionPrueba.removeFirstItem();
		
		Assert.assertEquals(operacionPrueba.calcularValor(),0.0,0);
	}
	
	
	@Test
	public void testCerradaNoCambiaPrecio() {
		operacionPrueba.cerrarOperacion();
		artPrueba.setValor(10.0);
		Articulo artPrueba2 = new Articulo("articulo",15.5);
		operacionPrueba.setItem(artPrueba2);
		Assert.assertEquals(operacionPrueba.calcularValor(),36.0,0);
	}
		
	@Test
	public void testItemValorFijado() {
		double valorActual = serPrueba.getValor();
		serPrueba.fijarValor();
		serPrueba.setValor(13.5);
		Assert.assertEquals(valorActual,serPrueba.getValor(),0);
	}
	
	@Test
	public void testItemValorCero() {
		artPrueba.setValor(0.0);
		Assert.assertNotEquals(0.0, artPrueba.getValor(), 0);
	}
	
	@Test
	public void testAbiertaCambiaPrecio() {
		artPrueba.setValor(10.0);
		Assert.assertEquals(operacionPrueba.calcularValor(),35.5,0);
	}
	
	@Test
	public void testOperacionVaciaNoGeneraRemito() {
		
		operacionPrueba.removeFirstItem();
		operacionPrueba.removeFirstItem();
		
		try {
			 operacionPrueba.generarRemito();
		  } catch (OperacionSinRemitoException e) {
		    }	
	}
	
	
	@Test
	public void testOperacionNoGeneraRemito() {
		 try {
			 operacionPrueba.generarRemito();
		  } catch (OperacionSinRemitoException e) {
		    }
	}
	
	
}
