package ec.edu.ups.test.practica02.DB.MS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import ec.edu.ups.clases.practica02.DB.MS.Biblioteca;
import ec.edu.ups.clases.practica02.DB.MS.Libro;
import ec.edu.ups.clases.practica02.DB.MS.Prestamo;
import ec.edu.ups.clases.practica02.DB.MS.Usuario;


public class Principal {
	//Creacion del metodo main 
	public static void main(String[] args) throws ParseException {
		//Intanciar la clase biblioteca
		Biblioteca biblioteca = new Biblioteca("Biblioteca Central","123 Calle Principal");
		//Instanciar la clase Scanner para ingresar desde consola
		Scanner sc = new Scanner(System.in);
		//Instaniar el SimpleDateFormat para el formato de la fecha
		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		//Variable para ingresar a la opcion deseada
		int opcion;
		System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
		do {
			//Creacion del menú
			 System.out.println("\n1. Agregar Libro");
			 System.out.println("2. Registrar Usuario");
			 System.out.println("3. Buscar Libro");
			 System.out.println("4. Prestar Libro");
			 System.out.println("5. Devolver Libro");
			 System.out.println("6. Salir");
			 System.out.println("Ingrese una opción: ");
			 opcion  = sc.nextInt();
			 sc.nextLine();
			 switch(opcion) {
			 case 1:
				 //Pregunta sobre el titulo y se guarda en dicha variable 
				 System.out.println("Ingrese el titulo del Libro: ");
				 String titulo = sc.next();
				 //Pregunta sobre el autor y se guarda en dicha variable 
				 System.out.println("Ingrese el autor: ");
				 String autor = sc.next();
				 //Pregunta sobre el año y se guarda en dicha variable 
				 System.out.println("Ingrese el año del libro: ");
				 int año = sc.nextInt();
				 //Intancio la clase Libro y guardo todos los datos
				 Libro libro = new Libro(titulo,autor,año,true);
				 //agrego el libro a la biblioteca
				 biblioteca.agregarLibro(libro);
				 break;
			 case 2:
				 //Pregunta sobre el nombre y se guarda en dicha variable 
				 System.out.println("Ingrese el nombre: ");
				 String nombre = sc.next();
				 //Pregunta sobre la identificacion y se guarda en dicha variable 
				 System.out.println("Ingrese la idetificación: ");
				 String identificacion = sc.next();
				 //Pregunta sobre el correo y se guarda en dicha variable 
				 System.out.println("Ingrese el correo: ");
				 String correo = sc.next();
				 //Instanciar la clase Usuario y guardas los datos 
				 Usuario usuario = new Usuario(nombre,identificacion,correo);
				 //Realizar el registro de usuario en biblioteca
				 biblioteca.registrarUsuario(usuario);
				 break;
			 case 3:
				 //Pregunta sobre las formas de busquedad
				 System.out.println("Con que información desea buscar: "
						 + "\n1. TituLo" + "\n2.Autor y año" + "\nIngrese la opción: ");
				int op = sc.nextInt();
				if (op==1) {
					//Pregunta sobre el titulo y realiza la comparación con la respuesta
				System.out.println("Ingrese le titulo del libro a buscar: ");
				 titulo = sc.next();
				//Llamamos al método buscarLibro y con la respuesta verifams su existencia.
				 boolean respuesta = biblioteca.buscarLibro(titulo);
				 if (respuesta == true) {
					 System.out.println("Estos son los resultados...");
				 }else {
					 System.out.println("Lo sentimos!, el libro no se encuentra disponible");
				 }
				}
				else if(op==2) {
					//Pregunta sobre el autor y año y realiza la comparación con la respuesta
					System.out.println("Ingrese el autor");
					autor = sc.next();
					System.out.println("Ingrese el año");
					año = sc.nextInt();
					//Llamamos al método buscarLibro y con la respuesta verifams su existencia. 
					 boolean respuesta = biblioteca.buscarLibro(autor,año);
					 if (respuesta == true) {
						 System.out.println("Estos son los resultados...");
					 }else {
						 System.out.println("Lo sentimos!, el libro no se encuentra disponible");
					 }
				}else {
					System.out.println("La opcion es incorrecta");
				}
				
				 break;
			 case 4:
				//Pregunta sobre el titulo 
				 System.out.println("Que libro desea: ");
				 titulo = sc.next();
				 Prestamo prestamodos = new Prestamo();
				//If para confirmar que el libro este disponible o existe en la biblioteca
				 if (prestamodos.esPrestamoVigente(biblioteca.buscarLibro(titulo))==true) {
				 
					 //Creamos libro1 donde se guarda el objeto con respecto a titulo
					 Libro libro1 = biblioteca.buscarrLibro(titulo);
					 System.out.println("Ingrese la identificación del usuario: ");
					 identificacion = sc.next();
					 //If para confirmar que le usuario este registrado
					 if(biblioteca.buscarUsuario(identificacion) != null) {
						 //En usuario1 guardamos al objeto usuario con respecto a la identificacion
						Usuario usuario1 =  biblioteca.buscarUsuario(identificacion);
						//Intanciamos la clase Date para trabajar con fechas
						 Date fechaPrestamo = new Date();
						 System.out.println("Ingrese la fecha de Devolución del libro");
						 //La fecha guardamos en String
						 String fechaDevolucion1 = sc.next();
						 //Pasamos la fecha de String a Date
						 Date fechaDevolucion = fecha.parse(fechaDevolucion1);
						 Prestamo prestamo1 = new Prestamo(libro1,usuario1,fechaPrestamo,fechaDevolucion);
						//Solicita el prestamo
						usuario1.solicitarPrestamo(libro1, usuario1, fechaPrestamo, fechaDevolucion);
						 //Mostramos infromacion del usuario
						 usuario1.mostrarInfromacion();
						 //Desde biblioteca prestamos el libro
						 biblioteca.prestarLibro(libro1, usuario1);
						 //Damos a conocer los dias que tiene para devolver el libro
						 System.out.println("\nEstimado " +usuario1.getNombre() + " tiene " + 
						 prestamo1.calcularDiasPrestamo(fechaPrestamo, fechaDevolucion) + " dias para devolver el libro");
						
					 }else {
						 System.out.println("El usuario no se encuentra el registrado");
					 }
				 }
				 break;
			 case 5: 
				 System.out.println("Ingrese la identificación del usuario: ");
				 identificacion = sc.next();
				 //Verificamos que el usuario exista en nuestros registros
				 if(biblioteca.buscarUsuario(identificacion) != null) {
					 System.out.println("Que libro desea: ");
					 titulo = sc.next();
					 //Verificamos que el libro no este en biblioteca para que se pueda devolver
					 if ((biblioteca.buscarLibro(titulo)) == false) {
						 //usuario2 guarda el usuario
						 Usuario usuario2 = biblioteca.buscarUsuario(identificacion);
						 //Libro2 obtiene el libro prestado
						 Libro libro2 = usuario2.devolverLibro(titulo);
						 //verificamos que el libro no sea nulo
						 if (libro2 != null) {
							 //Devolvemos el libro a bibloteca 
						 biblioteca.devolverLibro(libro2, usuario2);
						 }else {
							 System.out.println("El libro no existe");
						 }
						 
					 }else {
						 System.out.println("El libro no existe en su lista de prestamos");
					 }
				 }else {
					 System.out.println("El usuario no esta registrado");
				 	}
				}
		}while(opcion !=6);
			sc.close();
		System.out.println( biblioteca.getNombre() + " " + 
				biblioteca.getDireccion());
	}
}
