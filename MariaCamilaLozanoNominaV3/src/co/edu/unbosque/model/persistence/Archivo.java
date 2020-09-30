package co.edu.unbosque.model.persistence;

import java.io.*;

public class Archivo {

	private String nombre[];
	private String identificacion[];
	private double salario[];

	public Archivo(int numMaxRegistro) {

		nombre = new String[numMaxRegistro];
		identificacion = new String[numMaxRegistro];
		salario = new double[numMaxRegistro];

	}

	public String leerDatos(String dataPrincipal) {

		String lineaA = "";
		String cadenaA = "";

		File archivo = new File(dataPrincipal);

		try {

			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			lineaA = br.readLine();
			lineaA = br.readLine();
			int cont = 0;
			String letras = "";

			while (lineaA != null) {

				String[] separardata = lineaA.split(";");
				this.identificacion[cont] = separardata[0].replace("Â", "").replace((char) 160, (char) 0).trim();

				letras = separardata[1].replace("Â", "").replace("Ã‘", "Ñ").replace(" ' ", " Ñ ").trim();
				if (letras.contains("Ã")) {
					letras = letras.substring(0, letras.indexOf("Ã"))  + "Á"
							+ letras.substring(letras.indexOf("Ã") + 2, letras.length());
				}
				this.nombre[cont] = letras;
				this.salario[cont] = Double.parseDouble(separardata[2].trim());
				cadenaA += lineaA;
				lineaA = br.readLine();
				cont++;
			}
			fr.close();

		} catch (IOException e) {
			return "No se puede leer";
		}

		return cadenaA;
	}

	public String generarNomina(double[] sueldoNeto, String nomina1, String nomina2, String nomina3, String maestro,
			String sueldoNomina) {
		String n1 = "";
		String n2 = "";
		String n3 = "";

		for (int var = 0; var < salario.length; var++) {

			if (salario[var] <= 2000) {

				n1 += this.identificacion[var].trim() + "   ~   " + sueldoNeto[var] + "\n";

			} else if (salario[var] > 2000 && salario[var] < 5000) {

				n2 += this.identificacion[var].trim() + "   ~   " + sueldoNeto[var] + "\n";

			} else if (salario[var] > 5000) {

				n3 += this.identificacion[var].trim() + "   ~   " + sueldoNeto[var] + "\n";
			}

		}

		File nu = new File(nomina1);

		try {

			FileWriter fw = new FileWriter(nu);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Identificación~Retención del 10% \n" + n1);
			fw.close();

		} catch (IOException e) {

			return "El archivo no existe";

		}

		File nd = new File(nomina2);

		try {

			FileWriter fw = new FileWriter(nd);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Identificación~Retención del 15% \n" + n2);

			fw.close();

		} catch (IOException e) {

			return "El archivo no existe";

		}

		File nt = new File(nomina3);

		try {

			FileWriter fw = new FileWriter(nt);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Identificación~Retención del 20% \n" + n3);
			fw.close();

		} catch (IOException e) {
			return "El archivo no existe";
		}

		String sT = "";

		for (int var = 0; var < salario.length; var++) {
			sT += this.identificacion[var].trim() + "   ~   " + this.salario[var] + "   ~   " + sueldoNeto[var] + "\n";
		}

		File sAcumulado = new File(sueldoNomina);

		try {

			FileWriter fw = new FileWriter(sAcumulado);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Identificación ~ Salario ~ Retenciones totales \n" + sT);
			fw.close();

		} catch (IOException e) {
			return "El archivo no existe";
		}

		String maestroArchivo = "";

		for (int var = 0; var < salario.length; var++) {

			maestroArchivo += this.identificacion[var].trim() + "   ~   " + this.nombre[var] + "\n";
		}

		File m = new File(maestro);

		try {
			FileWriter fw = new FileWriter(m);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Identificación ~ Nombre \n" + maestroArchivo);
			fw.close();
		} catch (IOException e) {

			return "El archivo no existe";
		}

		return "";

	}

	public String[] getNombre() {
		return nombre;
	}

	public void setNombre(String[] nombre) {
		this.nombre = nombre;
	}

	public String[] getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String[] identificacion) {
		this.identificacion = identificacion;
	}

	public double[] getSalario() {
		return salario;
	}

	public void setSalario(double[] salario) {
		this.salario = salario;
	}

}
