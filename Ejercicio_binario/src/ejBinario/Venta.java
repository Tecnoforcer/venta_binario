package ejBinario;

public class Venta {
	private String nombre;
	private int codProd;
	private int unidades;
	private double precioUnidad;

	public Venta(String nombre, int codProd, int unidades, double precioUnidad) {
		this.nombre = nombre;
		this.codProd = codProd;
		this.unidades = unidades;
		this.precioUnidad = precioUnidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodProd() {
		return codProd;
	}

	public int getUnidades() {
		return unidades;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

}
