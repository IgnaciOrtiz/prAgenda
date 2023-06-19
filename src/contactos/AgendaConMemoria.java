package contactos;

/**
 * Clase para representar una agenda con memoria, capaz de almacenar el último contacto buscado.
 * Utilizamos herencia ya que AgendaConMemoria no es más que una Agenda con una funcionalidad añadida, 
 * donde redefinimos el método buscaContacto() de forma adecuada.
 * Si se quisiera también actualizar el último contacto cuando se agrega un nuevo contacto, sería 
 * necesario redefinir también el método agregaContacto(). Obsérvese que el último contacto se
 * mantiene incluso después de invocar eliminaTodos() y eliminaContacto(Contacto). Una alternativa
 * sería redefinir ambos métodos para actualizar a null ultimoContacto, cuando se invocan estos métodos.
 * 
 * @author POO
 *
 */
public class AgendaConMemoria extends Agenda {
	/**
	 * Variable para almacenar el último contacto buscado o agregado
	 */
	private Contacto ultimoContacto;
	
	/** 
	 * Crea agendas con memoria, indicando una capacidad máxima
	 * @param max	Capacidad máxima de la agenda
	 */
	public AgendaConMemoria(int max) {
		super(max);
		ultimoContacto = null; // No es necesario, pero lo indicamos explícitamente
	}
	
	/**
	 * Crea agendas con memoria, considerando como capacidad máxima 500
	 */
	public AgendaConMemoria() {
		this(MAX_CONTACTOS);
	}
	
	/**
	 * Devuelve el último contacto tratado (buscado o agregado)
	 * @return	Último contacto consultado
	 */
	public Contacto ultimoContacto() {
		return ultimoContacto;
	}
	
	/**
	 * Redefine el método buscaContacto, de forma que en caso de que el contacto buscado exista en la
	 * agenda, considera a este como último contacto memorizado.
	 * Obsérvese que buscaContacto es invocado también cuando se agrega un contacto. 
	 * Por lo tanto, la memoria se activa tanto cuando se busca como cuando se agrega un contacto existente.
	 */
	public Contacto buscaContacto(String nombre, String apellidos) {
		Contacto busqueda = super.buscaContacto(nombre,apellidos);
		if (busqueda != null) ultimoContacto = busqueda;
		return busqueda;
	}
}
