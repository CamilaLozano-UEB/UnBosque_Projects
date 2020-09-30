package co.edu.unbosque.controller;

import co.edu.unbosque.model.Model;
import co.edu.unbosque.view.View;

public class Controller {

	private View gui;
	private Model model;

	public Controller() {
		gui = new View();
		model = new Model();
		inicializar();

	}

	public void inicializar() {
		this.model.gestionarPropiedades();

		this.model.getArchivo().leerDatos(this.model.getProps().getDataPrincipal());

		this.model.procesarNomina();
		
		gui.escribirDato(model.ImprimirDatos(this.model.getArchivo().getIdentificacion(),
				this.model.getArchivo().getNombre(), this.model.getArchivo().getSalario()), this.model.getProps().getProyectoEncabezado());
		
		this.model.getArchivo().generarNomina(this.model.getSueldoNeto(), this.model.getProps().getNomina1(),
				this.model.getProps().getNomina2(), this.model.getProps().getNomina3(),
				this.model.getProps().getMaestro(), this.model.getProps().getSueldoNomina());

	}

}
