package ec.edu.ups.clases.practica02.DB.MS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Usuario extends Persona{//Usuario hereda de la clase Persona
	private String correo;
	//atributo de composición
	private List<Prestamo> listaPrestamos;
	
	//Contructor vacio
	public Usuario() {
		this.listaPrestamos = new ArrayList<>();
	}
	//Constructor con el atributo correo
	public Usuario(String correo) {
		this.correo = correo;
		this.listaPrestamos = new ArrayList<>();
	}
	//Constructor con  los atributos de la clase padre
	public Usuario(String nombre, String identificacion, String correo) {
		super(nombre, identificacion);
		this.correo = correo;
		this.listaPrestamos = new ArrayList<>();
	}
	//Creacion de los getters y setters
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	//Creacion del metodo solicitar prestamo
	public void solicitarPrestamo(Libro libro,Usuario usuario, Date fechaPrestamo, Date fechaDevolcion) {
		listaPrestamos.add(new Prestamo(libro,usuario,fechaPrestamo, fechaDevolcion));
		
	}
	//Retornar la lista listaPrestamos
	public List<Prestamo> getListasPrestamos(){
		return listaPrestamos;
	}
	
	//Creacion del metodo devolver libro
	public Libro devolverLibro(String titulo) {
		for(Prestamo prestamo: listaPrestamos ) {
			if (prestamo.getLibro().getTitulo().equals(titulo)){
				return prestamo.getLibro();
			}	
		}
		
		return null;
	}
	//Sobreescritura del metodo mostrar informacion 

	@Override
	public void mostrarInfromacion() {
		System.out.println("\nUsuario: ");
		System.out.println("Nombre: " + nombre);
		System.out.println("Identificación: " + identificacion);
		System.out.println("Correo: " + correo);
		System.out.println("Libros Pedidos: " + listaPrestamos);
			
	}
	//Creacion del toString con super
	@Override
	public String toString() {
		return super.toString()+ "Usuario [correo=" + correo + "]";
	}
	
}