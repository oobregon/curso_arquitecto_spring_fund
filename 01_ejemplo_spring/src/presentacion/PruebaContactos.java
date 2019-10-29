package presentacion;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import daos.DaoContactos;
import model.Contacto;

// Esta clase PruebaContactos no es un bean de spring, por lo tanto, no podemos usar las anotaciones de spring.
public class PruebaContactos {

	public static void main(String[] args) {
		// Iniciar spring
		// Al leer el fichero de configuracion, 
		BeanFactory factoria = new ClassPathXmlApplicationContext("spring-config.xml");
		
		// Solicitamos a spring una implementación del dao contactos.
		// En lugar de pasar la Clase.class, le podemos pasar el id de la implementación que quiero que me entregue.
		// Aquí no estamos usando inyección de dependencias; simplemente le hemos pedido a spring una implementación.
		// No podemos usar inyección de dependencias para obtener una implementaicón de DaoContactos porque en esta
		// clase PruebaContactos no podemos usar inyección.
		DaoContactos dao = factoria.getBean(DaoContactos.class);
		dao.altaContacto(new Contacto("Pedro Menendez de Aviles","pedroaviles@gmail.com",515));
		List<Contacto> contactos = dao.dameContactos();
		for(Contacto c:contactos) {
			System.out.println(c.getNombre());
		}
	}
}
