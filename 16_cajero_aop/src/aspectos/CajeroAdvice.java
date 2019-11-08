package aspectos;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CajeroAdvice {
	private int ingresos;
	private int extracciones;
	
	@After (value = "execution(* service.ServiceCajero.ingreso(..))")
	public void registroIngresos(JoinPoint jp) {
		ingresos++;
		System.out.println("Numero de ingresos totales:" +  ingresos + " ultimo a las " + new Date() );
	}
	
	@Before (value = "execution(* service.ServiceCajero.extraccion(..))")
	public void registroExtracciones(JoinPoint jp) {
		double cantidad = (Double)jp.getArgs()[1];
		extracciones++;
		System.out.println("Numero de extracciones totales:" +  extracciones + " ultimo a las " + new Date() + " por una cantidad de: " + cantidad );
	}
	
	// Si la cantidad a extraer es mayor de 1000, entonces no dejamos realizar la operacion.
	// Si se lanza la excepcion entonces, ya no se ejecuta ningun aspecto aplicado a service.ServiceCajero.extraccion 
	// El Around se ejecuta antes de que se ejecuta el jointponit 
	@Around (value = "execution(* service.ServiceCajero.extraccion(..))")
	public void registroControlExtraccion(ProceedingJoinPoint pjp) throws Throwable {
		double cantidad = (Double)pjp.getArgs()[1];
		if (cantidad <= 1000) {
			pjp.proceed();
		} else {
			System.out.println("¡¡¡¡¡ Limite excedido !!!!!");
		}
		extracciones++;
		System.out.println("Numero de extracciones totales:" +  extracciones + " ultimo a las " + new Date() + " por una cantidad de: " + cantidad );
	}
}
