import java.io.PushbackInputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Main
{
	static ListaDobleReglas ListaReglas = new ListaDobleReglas();
	static ListaDobleHechos ListaHechos=new ListaDobleHechos();
	static Analizadores aridad=new Analizadores();
	
 public static void main (String [] args)
	{ 
		System.out.println("BIENVENIDO AL PROGRAMA DE SIMULACIÓN DE PROLOG.");
		System.out.println();
		System.out.println("Dígite 1 si quiere agregar hechos o reglas a la base de conocimientos. ");
		System.out.println();
		System.out.println("Dígite 2 si desea realizar una consulta.");
		System.out.println();
		System.out.println("Dígite 3 si desea salir.");
		Scanner opcion=new Scanner(System.in);
		String eleccion=opcion.next();
		if (eleccion.equals("1")){
			System.out.println("Ingrese la regla o hecho: ");
			Scanner stringrh=new Scanner(System.in);
			String usuario=stringrh.next();
			String [] arreglo=aridad.analizador_lexico(usuario);
			String[] array=aridad.expresión_usuario(usuario);;
			int i=aridad.compararString(arreglo);
			if(arreglo[i]!=array[i]){
				System.out.println("Error léxico");
				main(array);
			}else{
				if(aridad.verificar(arreglo)==true){
					//aridad.analizadorsintacticoreglas(arreglo);
					if (aridad.analizadorsintacticoreglas(arreglo)==true){
						//aridad.argumentos(arreglo);
						//aridad.cuerpo(arreglo);
						ListaReglas.InsertaFinal(arreglo[0], aridad.aridad(aridad.argumentos(arreglo)), aridad.argumentos(arreglo), aridad.cuerpo(arreglo));
						System.out.println("Lista reglas");
						ListaReglas.Imprimir();
						main(array);
					}else{
						System.out.println("Error sintactico, favor verifique que la estructura sea la adecuada.");
						main(array);
					}
				}else{
					boolean sinta= aridad.analizadorSintacticoHechos(arreglo);
					if(sinta==true){
						aridad.argumentos(arreglo);
						ListaHechos.InsertaFinal(arreglo[0], aridad.aridad(aridad.argumentos(arreglo)), aridad.argumentos(arreglo));
						System.out.println("Lista hechos");
						ListaHechos.Imprimir();
						main(array);
					}else{
						System.out.println("Error sintactico, favor verifique que la estructura sea la adecuada.");
						main(array);
					}
				}
			}
		}else
			if (eleccion.equals("2")) {
				System.out.println("Quiero hacer una consulta :P");
			} else {
				if (eleccion.equals("3")) {
					System.out.println("FIN");
				} else {
					System.out.println("Elija solo una de las opciones permitidas (1,2,3)");
				}
			}
			
	

			
	

	}
}

