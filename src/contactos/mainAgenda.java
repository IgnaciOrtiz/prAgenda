
package contactos;

public class mainAgenda {
	public static void main(String[] args) {
// Creamos un array con contactos
		Contacto[] contactos = { new Contacto("Pepe", "Montes", "jmontes@gmail.com", "111222333"),
				new Contacto("Jose", "Llanos", "jllanos@hotmail.com", "666777888"),
				new Contacto("Fefi", "Ríos", "mjrios@gmail.com", "333444555"),
				new Contacto("Pepi", "Colinas", "jcolinas@uma.es", "222333444") };
// Creamos un contacto
		Contacto contacto = new Contacto("Pepito", "Arroyo", "ja@gmail.com", "444555666");
// Añadimos a una agenda los cuatro contactos del array anterior
		Agenda agenda = new Agenda(100);
		for (Contacto c : contactos)
			agenda.agregaContacto(c);
// Agregamos contacto ya existente (aunque con diferente email).
// No debería añadirse
		agenda.agregaContacto(new Contacto("Pepe", "Montes", "pepe.montes@hotmail.com", "111222333"));
// Agregamos un contacto que no está en la agenda. Debería añadirse
		agenda.agregaContacto(contacto);
// Visualizamos la agenda. Debería incluir cinco contactos
		System.out.println("La agenda debe incluir cinco contactos: \n\t" + agenda);
// Imprimimos el número de contactos con correo electrónico en gmail.com: 3
		System.out.println(
				"El número de contactos con dirección en gmail.com es: " + agenda.nroContactosConEMail("gmail.com"));
// Eliminamos la agenda
		agenda.eliminaTodos();
// Visualizamos la agenda, que debería estar vacía
		System.out.println("La agenda debe estar vacía: \n\t" + agenda);
	}
}