//Ignacio Ortiz Alonzua.Desarrollo de Aplicaciones Multiplataforma.Modalidad:Online.
package contactos;

public class Contacto {
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	
	public Contacto (String nombre, String apellidos, String email, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString() {
		return apellidos.toUpperCase() + ", " + nombre.toUpperCase() + " <" + email + "> " + "(" + telefono + ")";
	}
	
	public boolean equals(Object o) {
		boolean res = o instanceof Contacto;
		Contacto c = res ? (Contacto) o : null;
		return res && nombre.equalsIgnoreCase(c.nombre)
		&& apellidos.equalsIgnoreCase(c.apellidos);
		}
	
	public int hashCode() {
		return nombre.toUpperCase().hashCode() + 
		apellidos.toUpperCase().hashCode();
		}
}