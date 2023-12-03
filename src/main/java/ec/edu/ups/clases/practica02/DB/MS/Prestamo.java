package ec.edu.ups.clases.practica02.DB.MS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestamo {
	//Relacion por asociación
	private Libro libro;
	private Usuario usuario;
	//otros atrbutos
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	
	//Contructor vacio 
	public Prestamo() {
		
	}
	//Constructor con todos los atributos
	public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {

		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}
	//Constrcutor con fechaPrestamo y fechaDevolucion
	public Prestamo(Date fechaPrestamo, Date fechaDevolucion) {
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}
	//Contructor con el el atributo libro 
	public Prestamo(Libro libro) {
		this.libro = libro;
	}
	//Creacion de getters y setters 
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	//Instanciar el SimpleDateFormat en el formato
	SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
	//Creación de el metodo calcular días del prestamo
	public int calcularDiasPrestamo(Date fechaPrestamo, Date fechaDevolucion) {
		int dias =(int) ((fechaDevolucion.getTime() - fechaPrestamo.getTime())/ (24 * 60 * 60 * 1000));
		
		return dias;
	}
	//Creación del metodo si es prestamo vigente 
	public boolean esPrestamoVigente(boolean estado) {
		if (estado == true) {
			System.out.println("No existe un prestamo vigente, puede continuar.\n");
			return true;
		}
		else {
			System.out.println("El prestamo sigue vigente");
			return false;
		}
		
	}
	//Creación del toString 
	@Override
	public String toString() {
            return "Prestamo [libro=" + libro + ", \nusuario=" + usuario +
                    ", \nfechaPrestamo=" + fecha.format(fechaPrestamo) +
                    ", fechaDevolucion=" + fecha.format(fechaDevolucion) + "]";
    }

}
