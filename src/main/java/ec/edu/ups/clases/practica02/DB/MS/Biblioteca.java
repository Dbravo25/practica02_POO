package ec.edu.ups.clases.practica02.DB.MS;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	//Atributos de la clases Biblioteca
	private String nombre;
	private String direccion;
	//atributo de agregación 
	private List<Libro> listaLibros;
	private List<Usuario> listaUsuarios;
	//Constructor vacio
	public Biblioteca() {
		this.listaLibros = new ArrayList<>();
		this.listaUsuarios = new ArrayList<>();
	}
	//Constructor con los atributos
	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibros = new ArrayList<>();
		this.listaUsuarios = new ArrayList<>();
	}
	//Creacion de los getters y setters 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	//Creacion del metodo agregarLibro
	public void agregarLibro(Libro libro) {
		listaLibros.add(libro);
	}
	//Creacion del metodo para registrar Usuario 
	public void registrarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	//Creacion del metodo buscarLibro
	public boolean buscarLibro(String titulo) {
		for(Libro libro: listaLibros ) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)){
				libro.mostrarInformacion();
				return true;
			}	
		}
		return false;
			
		}
	//Sobrecarga del metodo buscarlibro
	public boolean buscarLibro(String autor, int año) {
		for(Libro libro: listaLibros ) {
			if ((libro.getAutor().equalsIgnoreCase(autor)) && (libro.getAño() == año)){
				libro.mostrarInformacion();
				return true;
			}	
		}
		return false;
		}

	//Creacion del metodo prestarLibro
	public void prestarLibro(Libro libro, Usuario usuario){
	    //Removemos al libro de la listalibros
	    listaLibros.remove(libro);
	    //prestamos el libro
	    libro.prestar();
	    
		
		}
	//Creacion del metodo devolver
	public void devolverLibro(Libro libro,Usuario usuario) {
		//Cambiamos el estado del libro 
		libro.setDisponible(true);
		//Añadimos de nuevo a la lista de libros
		listaLibros.add(libro);
		//Devolvemos el libro
		libro.devolver();
	}
	//Creacion de un metodo para buscar por el titulo y retornar el objeto libro
	public Libro buscarrLibro(String titulo) {
		//Buscamos entre todos los objetos de la lista
		for(Libro libro: listaLibros ) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)){
				//retornamos el libro
				return libro;
			}	
		}
		return null;
	}
	//Creacion de un metodo para buscar por el idUsuario y retornar el objeto usuario
	public Usuario buscarUsuario(String idUsuario) {
		//Buscamos entre todos los objetos de la lista
		for(Usuario usuario: listaUsuarios ) {
			if (usuario.getIdentificacion().equalsIgnoreCase(idUsuario)){
				//retornamos el usuario
				return usuario;
			}	
		}
		return null;
	}
	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", listaLibros=" + listaLibros
				+ ", listaUsuarios=" + listaUsuarios + "]";
	}

		
	}