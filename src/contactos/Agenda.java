package contactos;
/**
 * Clase para almacenar una colección de contactos. Los contactos se van incluyendo en la colección (array) conforme se 
 * añaden. No se organizan siguiendo ningún orden.
 * 
 * @author POO
 *
 */
public class Agenda {
	/**
	 * Array para almacenar los contactos. No se organizarán siguiendo ningún tipo de orden.
	 */
	private Contacto[] contactos;
	
	/**
	 * Variable para almacenar el número de contactos del array. También indicará la siguiente posición disponible en el array.
	 */
	private int numContactos;
	
	/**
	 * Constante que define la capacidad máxima de la agenda por defecto
	 */
	final static int MAX_CONTACTOS = 500;
	
	/**
	 * Crea una agenda con un número máximo de contactos establecido por parámetro
	 * @param maxContactos	Capacidad máxima de la agenda
	 */
	public Agenda(int maxContactos) {
		numContactos = 0;
		contactos = new Contacto[maxContactos];
	}
	
	/**
	 * Crea una agenda con 500 contactos como máximo 
	 */
	public Agenda() {
		this(MAX_CONTACTOS);
	}
	
	/**
	 * Devuelve el contacto cuyo nombre y apellidos coincidan (indpendientemente de mayúsculas y minúsculas)
	 * con los proporcionados como argumentos
	 * @param nombre	Nombre del contacto a localizar
	 * @param apellidos	Apellidos del contacto a localizar
	 * @return	Contacto de la agenda coincidente en nombre y apellidos
	 */
	public Contacto buscaContacto(String nombre, String apellidos) {
		// Se crea un contacto con nombre y apellidos, y una dirección de correo que incluye @, para evitar la excepción
		// Este contacto será equals que cualquier contacto que aparezca en la agenda con esos nombre y apellidos.
		Contacto contacto = new Contacto(nombre,apellidos,"@","");
		return buscaContacto(contacto); // Usamos el método auxiliar que utiliza un Contacto como argumento
	}
	
	/**
	 * Método auxiliar para localizar un contacto en la agenda. El contacto que se devuelve no tiene que ser exactamente 
	 * el mismo. Por ejemplo, puede tener distinto correo electrónico y distinto teléfono. Éste es el criterio de igualdad
	 * definido en la clase Contacto.
	 * @param contacto	Contacto a localizar
	 * @return			Contacto almacenado en la agenda igual al que se pasa como argumento
	 */
	public Contacto buscaContacto(Contacto contacto) {
		int i = 0;
		while (i<numContactos && ! contactos[i].equals(contacto))
			i++;
		return i<numContactos ? contactos[i] : null;
	}
		
	/**
	 * Añade un contacto (el que se pasa como argumento) a la agenda. En caso de que el contacto (uno con mismo nombre
	 * y apellidos) ya esté en la agenda, no se añade el que se pasa como argumento.
	 * @param c	Contacto a añadir a la agenda
	 */
	public void agregaContacto(Contacto c) {
		if (buscaContacto(c.getNombre(),c.getApellidos()) == null) {
			contactos[numContactos] = c;
			numContactos++;
		}
	}
	
	/**
	 * Elimina todos los contactos de la agenda
	 */
	public void eliminaTodos() {
		// Basta con poner a cero el contador del número de contactos. En realidad los contactos 
		// se mantienen en el array, pero no serán accesibles a partir de este momento.
		numContactos = 0;
	}
	
	/** 
	 * Elimina el contacto que se pasa como argumento. Obsérvese que al utilizar el equals de la clase Contacto para
	 * realizar la comparación con cada uno de los contactos, se eliminará el contacto que coincida en nombre y apellidos
	 * (sin tener en cuenta mayúsculas y minúsculas). Además de eliminar el contacto, se devuelve como resultado.
	 * En caso de que el contacto no esté en la agenda, no se hace nada sobre el array y se devuelve null.
	 * @param contacto	Contacto a eliminar de la agenda
	 * @return			Contacto realmente eliminado. Null si no aparece el contacto a eliminar.
	 */
	public Contacto eliminaContacto(Contacto contacto) {
		Contacto resultado = null;
		int i = 0;
		while (i < numContactos && ! contactos[i].equals(contacto)) 
			i++;
		if (i<numContactos) { // Si se encuentra el contacto a eliminar, éste se almacena en resultado
			resultado = contactos[i];
			numContactos--;
		}
		// Una vez eliminado el contacto, desplazamos todos los contactos restantes para no dejar huecos en el array
		for (int j = i; j < numContactos; j++)
			contactos[j] = contactos[j+1];
		return resultado;
	}
	
	/**
	 * Devuelve el número de contactos que tienen una dirección de correo electrónico perteneciente al dominio que
	 * se pasa como argumento. Se supone que el dominio de una dirección de correo será el que aparece tras el símbolo @.
	 * @param dominio	Dominio de correo electrónico
	 * @return			Número de contactos con una dirección de correo perteneciente a determinado dominio
	 */
	public int nroContactosConEMail(String dominio) {
		int res = 0;
		for (int i = 0; i < numContactos; i++) {
			String email = contactos[i].getEmail();
			// Comparamos la subcadena que va desde la aparición de @ con el dominio
			if (email.substring(email.lastIndexOf('@')+1).equalsIgnoreCase(dominio))
				res++;
		}
		return res;
	}
	
	/**
	 * Representación textual de una agenda, determinada por la secuencia de contactos separados por un guión ('-'), 
	 * y encerrada entre corchetes.
	 * 		[contactos[0] - contactos[1] - ... - contactos[numContactos-1]]
	 */
	public String toString() {
		String resultado = "[";
		for (int i = 0; i < numContactos; i++) 
			resultado += contactos[i] + (i==numContactos-1 ? "" : " - ");
		return resultado + "]";
	}
}
