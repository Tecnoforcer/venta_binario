package ejBinario;

import java.io.*;
import java.util.Scanner;

public class Iodato_b {
	private final static String directorio = "datos_venta/ventas.dat";

	public static Venta[] cargarDisco() {
		File file = new File(directorio);
		Venta[] venta = new Venta[20];
		FileInputStream fis = null;
		DataInputStream dis = null;
		String nombre = "";
		int codProd = 0;
		int unidades = 0;
		double precioUnidad = 0;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {

			fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			while (true) {
				nombre = dis.readUTF();
				codProd = dis.readInt();
				unidades = dis.readInt();
				precioUnidad = dis.readDouble();

				Venta v = new Venta(nombre, codProd, unidades, precioUnidad);
				for (int i = 0; i < venta.length; i++) {
					if (venta[i] == null) {
						venta[i] = v;
						break;
					}

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("fin de lectura" + "\n" + "\n" + "\n");
		}

		return venta;
	}

	public static void guardarDisco(Venta v[]) {
		File file = new File(directorio);
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			for (int i = 0; i < v.length; i++) {
				if (v[i] != null) {
					dos.writeUTF(v[i].getNombre());
					dos.writeInt(v[i].getCodProd());
					dos.writeInt(v[i].getUnidades());
					dos.writeDouble(v[i].getPrecioUnidad());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static double calcularFacturaCliente(Venta v[], String nomCliente) {
		double total = 0;

		for (int i = 0; i < v.length; i++) {
			if (v[i] != null && v[i].getNombre().equalsIgnoreCase(nomCliente)) {
				total += (v[i].getPrecioUnidad() * v[i].getUnidades());
			}
		}

		return total;
	}

	public static void calcularClientesDiferentes(Venta v[]) {
		Venta[] vent = v;
		int clientes_total = v.length;
		int repeticiones_cliente = 0;

		for (int i = 0; i < vent.length; i++) {
			repeticiones_cliente = 0;
			
			if (vent[i]!=null) {
				for (int j = 0; j < v.length; j++) {
					if ((vent[j] != null && vent[i] != null )&& (vent[i].getNombre().equalsIgnoreCase(vent[j].getNombre())&& (i!=j))) {
					
						
						vent[i]=null;
						
						repeticiones_cliente++;
						
					}
			}
			}
				
			System.out.println(repeticiones_cliente);
		}

	}

}
