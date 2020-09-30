package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.Propiedades;

public class Model {
	private Propiedades props;
	private Archivo archivo;
	private double sueldoNeto[];

	public Model() {
		props = new Propiedades();
		props.crearAtributosNuevos();
		archivo = new Archivo(Integer.parseInt(this.props.getNumMaxRegistro()));
		sueldoNeto = new double[Integer.parseInt(this.props.getNumMaxRegistro())];

	}

	public String ImprimirDatos(String[] identificacion, String[] nombre, double[] salario) {

		String cadena = this.props.getInicioArchivo();
		for (int var = 0; var < salario.length; var++) {
			cadena += identificacion[var] + " ~ " + nombre[var] + " ~ " + salario[var] + "\n";
		}

		return cadena;

	}

	public String procesarNomina() {
		double salario[] = this.archivo.getSalario();

		for (int var = 0; var < salario.length; var++) {
			if (salario[var] <= 2000) {
				sueldoNeto[var] = salario[var] - (salario[var] * 0.1);
			} else if (salario[var] > 2000 && salario[var] < 5000) {
				sueldoNeto[var] = salario[var] - (salario[var] * 0.15);
			} else if (salario[var] > 5000) {
				sueldoNeto[var] = salario[var] - (salario[var] * 0.20);
			}
		}

		return "";

	}

	public void gestionarPropiedades() {
		props.escribirPropiedades();

	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public double[] getSueldoNeto() {
		return sueldoNeto;
	}

	public void setSueldoNeto(double[] sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

	public Propiedades getProps() {
		return props;
	}

	public void setProps(Propiedades props) {
		this.props = props;
	}

}
