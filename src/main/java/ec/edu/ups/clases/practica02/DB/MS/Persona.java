package ec.edu.ups.clases.practica02.DB.MS;

public abstract class Persona {//abstract para definir como clase abstracta 
	//Protected para poder usar en la clase hija Usuario
	protected String nombre;
	protected String identificacion;
	//Constructor vacio
	public Persona() {
		
	}
	//Constructor con todos los atributos 
	public Persona(String nombre, String identificacion) {
		this.nombre = nombre;
		this.identificacion = identificacion;
	}
	//Creacion de los getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	//Creacion del metodo abstract 
	public abstract void mostrarInfromacion();
	//Creacion del toString
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}
	
}

