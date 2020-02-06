package ejBinario;

import java.util.Scanner;

public class MainBinario {

	public static void main(String[] args) {
		Venta ventasAleer[] = new Venta[5];
		ventasAleer[0] = new Venta("pako", 1, 3, 10);
		ventasAleer[1] = new Venta("kagasawa", 1, 2, 10);
		ventasAleer[2] = new Venta("mohamed", 3, 4, 9.99);
		ventasAleer[3] = new Venta("pako", 2, 1, 19.95);
		ventasAleer[4] = new Venta("wissin esneider", 2, 1, 19.95);

		///
		Iodato_b.guardarDisco(ventasAleer);

		////////////////////////

		Venta ventas[] = null;
		double total = 0;
		String nomCliente = "";
		boolean correcto = false;
		Scanner read = new Scanner(System.in);

		///
		ventas = Iodato_b.cargarDisco();

		for (int i = 0; i < ventas.length; i++) {
			if (ventas[i] != null)
				System.out.println(ventas[i].getNombre());
		}

		///
		System.out.println("que cliente quieres facturar");
		do {
			try {
				correcto = true;
				nomCliente = read.nextLine();
			} catch (Exception e) {
				correcto = false;
			}
		} while (!correcto);
		total = Iodato_b.calcularFacturaCliente(ventas, nomCliente);

		System.out.println("el cliente " + nomCliente + " tiene que pagar " + total + " euros");

		
		///
		
		
		
		
	}

}
