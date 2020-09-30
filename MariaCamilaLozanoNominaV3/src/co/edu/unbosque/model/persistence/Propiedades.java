package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class Propiedades {
	
	private Properties prop;
	private String archivoprop = "./Data/Propiedades.properties";
	private String proyectoEncabezado;
	private String numMaxRegistro;
	private String dataPrincipal;
	private String nomina1;
	private String nomina2;
	private String nomina3;
	private String maestro;
	private String sueldoNomina;
	private String inicioArchivo;

	public Propiedades() {
		prop = new Properties();
	}

	public int escribirPropiedades() {
		
		try {
			prop.setProperty("proyecto", "MariaCamilaLozanoGutiérrezNominaV3");
			prop.setProperty("numMaxRegistros", "26");
			prop.setProperty("dataPrincipal", "./Data/datosprincipales.csv");
			prop.setProperty("nomina1", "./Data/Nomina1.txt");
			prop.setProperty("nomina2", "./Data/Nomina2.txt");
			prop.setProperty("nomina3", "./Data/Nomina3.txt");
			prop.setProperty("maestro", "./Data/Maestro.txt");
			prop.setProperty("salarioNomina", "./Data/sueldoNomina.txt");
			prop.setProperty("inicio", "N° de \n Identificación        ~      Nombre         ~        Salario\n");
			prop.store(new FileOutputStream(archivoprop), null);
			
		} catch (IOException ex) {
			return -1;
		}
		
		return 0;
	}

	public void crearAtributosNuevos() {
		
		this.escribirPropiedades();
		proyectoEncabezado = prop.getProperty("proyecto");
		numMaxRegistro = prop.getProperty("numMaxRegistros");
		dataPrincipal = prop.getProperty("dataPrincipal");
		nomina1 = prop.getProperty("nomina1");
		nomina2 = prop.getProperty("nomina2");
		nomina3 = prop.getProperty("nomina3");
		maestro = prop.getProperty("maestro");
		sueldoNomina = prop.getProperty("salarioNomina");
		inicioArchivo = prop.getProperty("inicio");

	}

	public String getProyectoEncabezado() {
		return proyectoEncabezado;
	}

	public void setProyectoEncabezado(String proyectoEncabezado) {
		this.proyectoEncabezado = proyectoEncabezado;
	}

	public String getNumMaxRegistro() {
		return numMaxRegistro;
	}

	public void setNumMaxRegistro(String numMaxRegistro) {
		this.numMaxRegistro = numMaxRegistro;
	}

	public String getDataPrincipal() {
		return dataPrincipal;
	}

	public void setDataPrincipal(String dataPrincipal) {
		this.dataPrincipal = dataPrincipal;
	}

	public String getNomina1() {
		return nomina1;
	}

	public void setNomina1(String nomina1) {
		this.nomina1 = nomina1;
	}

	public String getNomina2() {
		return nomina2;
	}

	public void setNomina2(String nomina2) {
		this.nomina2 = nomina2;
	}

	public String getNomina3() {
		return nomina3;
	}

	public void setNomina3(String nomina3) {
		this.nomina3 = nomina3;
	}

	public String getMaestro() {
		return maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	public String getSueldoNomina() {
		return sueldoNomina;
	}

	public void setSueldoNomina(String sueldoNomina) {
		this.sueldoNomina = sueldoNomina;
	}

	public String getInicioArchivo() {
		return inicioArchivo;
	}

	public void setInicioArchivo(String inicioArchivo) {
		this.inicioArchivo = inicioArchivo;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getArchivoprop() {
		return archivoprop;
	}

	public void setArchivoprop(String archivoprop) {
		this.archivoprop = archivoprop;
	}

}
