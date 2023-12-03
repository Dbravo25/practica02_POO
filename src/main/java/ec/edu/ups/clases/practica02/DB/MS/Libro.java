package ec.edu.ups.clases.practica02.DB.MS;

import java.util.Objects;

public class Libro implements IPrestable { //Implementacion de la interfaz prestable 
	//Creación de atributos private
	private String titulo;
	private String autor;
	private int año;
	private boolean disponible;
	//Constructor vacio
	public Libro() {

	}
	//Constructor del metodo con todos los atributos 
	public Libro(String titulo, String autor, int año, boolean disponible) {

		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.disponible = disponible;
	}
	// Constructor con los atributos
	public Libro(String titulo, String autor, int año) {
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
	}
	//Creación de getters y setters 
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	//Sobreescritura del metodo mostrar informacion
	public void mostrarInformacion() {
		System.out.println("Información sober el libro: ");
		System.out.println("Titulo: "+ titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Año publicación: " + año);
		System.out.println("Disponible: " + disponible);
	
	}
	//Llamado del de hashCode y equal con el atributo titulo
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(titulo, other.titulo);
	}
	//Sobreescritura de los metodos prestar y devolver de la interfaz IPrestable
	@Override
	public void prestar() {
		System.out.println("\nEl libro se ha prestado correctamente!");
	
	}
	@Override
	public void devolver() {
		System.out.println("\nEl libro se ha devuelto correctamente!");
		
	}
	//Creación del toString 
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", año=" + año + ", disponible=" + disponible + "]";
	}
	

	
}