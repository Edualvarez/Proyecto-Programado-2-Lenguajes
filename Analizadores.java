import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analizadores {

	// M�todo que calcula la aridad de los argumentos. Devuelve un entero
	public int aridad(String argumento){
		int i=0;
		StringTokenizer st = new StringTokenizer(argumento, ",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			i++;
		}
		System.out.println("La aridad es "+i);
		return i;
	}
	
	public void write(String X){
		System.out.println("X");
	}

	// M�todo que recibe un string, el cual corresponde a los antecedentes que se deben cumplir para legar a una meta,
	//  y separa el string y lo mete en un arreglo para facilitar su manipulaci�n a la hora de realizar consultas.
public String[] identificador(String hilera){ 
	String [] array= new String[50]; 
	int len,cont,cont2, rec; 
	len=hilera.length(); 
	cont=0; cont2=0; 
	rec=0; 
	boolean bandera=true; 
	while (rec<len){ 
		if(hilera.charAt(rec)=='('){ 
			bandera=false; 
			} 
		if(hilera.charAt(rec)==')'){ 
			bandera=true; 
			} 
		if (bandera){ 
			if (hilera.charAt(rec)==',' | hilera.charAt(rec)==';'| hilera.charAt(rec)=='.' ){ 
				array[cont2]=hilera.substring(cont, rec); 
				cont2++; 
				cont=rec; 
				array[cont2]=Character.toString(hilera.charAt(rec)); 
				cont2++;
				cont++;
				} 
			} 
		rec++; 
		} 
	return array; 
	}

// Metodo para imprimir un arreglo
public String ImprimirArreglo(String [] array){
	int i=0;
	int len=array.length;
	String cuerpo = "";
	while (i!=len){
		if (array[i]==null)
			i=50;
		else{
			cuerpo=cuerpo+array[i];
			i++;
		}
	}
	System.out.println(cuerpo);
	return cuerpo;
	
	
}

// M�todo que recibe el string que ingresa el usuario y lo analiza metiendo en un arreglo �nicamente los caracteres que son
// permitidos, para luego realizar una comparaci�n.
public String[] analizador_lexico(String usuario){
	String [] resultado= new String[50];
	int i=0;
	String patron=("([a-zA-Z]+)|([,|;|[:-]|.]+)|([(|)]+)|([0-9])");
	Pattern p= Pattern.compile(patron);
	Matcher matcher=p.matcher(usuario);

	 while(matcher.find()){
		 String tokenTipo1=matcher.group(1);
		 String tokenTipo2=matcher.group(2);
		 String tokenTipo3=matcher.group(3);
		 String tokenTipo4=matcher.group(4);
		 if(tokenTipo1!=null){
			// System.out.println("Letra " + tokenTipo1);
			 resultado[i]=tokenTipo1;
			 i++;
			 
		 }
		 else{
			 if(tokenTipo2!=null){
				// System.out.println("Signo de puntuacion: "+tokenTipo2);
				 resultado[i]=tokenTipo2;
				 i++;
			 }
			 else{
				 if(tokenTipo3!=null){
				//	 System.out.println("Parentesis: "+tokenTipo3);
					 resultado[i]=tokenTipo3;
					 i++;
				 }
				 else{
					 if(tokenTipo4!=null){
							//System.out.println("Numero"+tokenTipo4);
							 resultado[i]=tokenTipo4;
							 i++;
						}
				 }	 
			 }
		 }
		 
	 }
	 
	return resultado;
}

//M�todo que recibe el string que ingresa el usuario y mete en un arreglo todos los caracteres ingresados por el usuario
//ya sean estos permitidos o no.
public String[] expresi�n_usuario(String usuario){
	String [] result= new String[50];
	int i=0;
	String patron2=("([a-zA-Z]+)|([(|)]+)|([:-]+)|([fail|nl|write]+)|([,|;]+)|(.)");
	Pattern p2= Pattern.compile(patron2);
	Matcher matcher2=p2.matcher(usuario);

	while(matcher2.find()){
		
		String tokenTipo1=matcher2.group(1);
		if(tokenTipo1!=null){
			//System.out.println("Letra minuscula: " + tokenTipo1);
			result[i]=tokenTipo1;
			i++;
			}
		
		String tokenTipo2=matcher2.group(2);
	    if(tokenTipo2!=null){
	    	//System.out.println("Parentesis: " + tokenTipo2);
	    	result[i]=tokenTipo2;
	    	i++;
		 
	    }
	    
	    
	    String tokenTipo3=matcher2.group(3);
	    if(tokenTipo3!=null){
	    	//System.out.println("Separador: " + tokenTipo3);
	    	result[i]=tokenTipo3;
	    	i++;
	    	}
	    
	    String tokenTipo4=matcher2.group(4);
		 if(tokenTipo4!=null){
			 //System.out.println("Palabra: " + tokenTipo4);
			 result[i]=tokenTipo4;
		     i++;	 
		 }
		 
		 String tokenTipo5=matcher2.group(5);
		 if(tokenTipo5!=null){
			// System.out.println("Puntuaci�n: " + tokenTipo5);
			 result[i]=tokenTipo5;
		     i++; 
		 }
		 String tokenTipo6=matcher2.group(6);
		 if(tokenTipo6!=null){
		//	 System.out.println("Fin: " + tokenTipo6);
			 result[i]=tokenTipo6;
		     i++; 
		 }
	    
	    }
	return result;
}

// M�todo que recorre un arreglo hasta encontrar una posici�n nula
public int compararString (String [] array){
	int i=0;
	int len=array.length;
	while (i!=len){
		if (array[i]==null)
			return i;
		else
			i++;
		
	}
	return i;
	
}


public boolean verificar(String [] array){
	int i=0;
	int len=array.length;
	while(i!=len & array[i]!=null){
		if (array[i].equals(":-")){
			//System.out.println("true");
			return true;
	}else{
			i++;
		}
			
	}
	//System.out.println("false");
	return false;
	
}

// Metodo que valida la estructura valida de las reglas, es decir se le aplica el analisis sintactico

public boolean analizadorsintacticoreglas(String [] array){
	int i=1;
	int len=array.length;
	String minuscula=array[0].toLowerCase();
	if ((array[0].equals(minuscula)==true) && (validaNumeros(array[0])==false)){
		if (array[i].equals("(")==true){
			i++;
			String mayuscula=array[i].toUpperCase();
			if ((array[i].equals(mayuscula)==true) && (validaNumeros(array[i])==false)){
				i++;
				if (array[i].equals(",")==true){
					i++;
					mayuscula=array[i].toUpperCase();
					if ((array[i].equals(mayuscula)==true) && (validaNumeros(array[i])==false)){
						i++;
						if(array[i].equals(")")==true){
							i++;
							if (array[i].equals(":-")==true){
								i++;
								if(array[i]!=null){
									System.out.println("Correcto2");
									if(analizadorantecedentes(i, array)==true){
										return true;
									}else{
										return false;
									}
								}else{
									System.out.println("Error, la regla no tiene antecedentes");
									return false;
								}
							}else{
								System.out.println("Error, debe ir :- antes de los antecedentes");
								return false;
							}
						}else{
							System.out.println("Error, al terminar los argumentos debe ir un )");
							return false;
						}
					}else{
						System.out.println("Error, las variables deben ser en mayusculas");
						return false;
					}
				}else{
					if (array[i].equals(")")==true){
						i++;
						if(array[i].equals(":-")==true){
							i++;
							if(array[i]!=null){
								System.out.println("Correcto2");
								if(analizadorantecedentes(i, array)==true){
									return true;
								}else{
									return false;
								}
							}else{
								System.out.println("Error, la regla no tiene antecedentes");
								return false;
							}
						}else{
							System.out.println("Error, antes de los antecedentes debe ir un :-");
							return false;
						}
					}else{
						System.out.println("Error, el terminar los argumentos debe ir un )");
						return false;
					}
				}
					
			}else{
				System.out.println("Error, las variables van en mayuscula");
				return false;
			}
				
		}else{
			System.out.println("Error, antes de los argumentos debe ir un (");
			return false;
		}
	}else{
		System.out.println("El functor debe ir en minuscula");
		return false;
	}
	
		
}

// Metodo que revisa la estructrutura sintactica de los n antecedentes.

public boolean analizadorantecedentes(int i,String [] array){
	if (array[i]!=null){
		String minuscula=array[i].toLowerCase();
		if ((array[i].equals(minuscula)==true) && (validaNumeros(array[i])==false)){
			i++;
			if (array[i].equals("(")==true){
				i++;
				String mayuscula=array[i].toUpperCase();
				System.out.println(array[i]);
				if ((array[i].equals(mayuscula)==true) && (validaNumeros(array[i])==false)){
					i++;
					if (array[i].equals(",")==true){
						i++;
						mayuscula=array[i].toUpperCase();
						if((array[i].equals(mayuscula)==true) && (validaNumeros(array[i])==false)){
							i++;
							if (array[i].equals(")")==true){
								i++;
								if (array[i].equals(",")==true || array[i].equals(";")==true ){
									i++;
									analizadorantecedentes(i,array);	
								}else{
									if (array[i].equals(".")==true){
										System.out.println("Correcto");
										return true;
									}else{
										System.out.println("Error,falta . al final de la regla");
										return false;
									}
								}
							}else{
								System.out.println("Error, al terminar los argumentos debe ir )");
								return false;
							}
						
						}else{
							System.out.println("Error, las variables van en mayuscula2");
							return false;
						}
					
					}else{
						if (array[i].equals(")")==true){
							i++;
							if ((array[i].equals(",")==true) || (array[i].equals(";")==true) ){
								i++;
								analizadorantecedentes(i,array);
							
							}else{
								if (array[i].equals(".")==true){
									System.out.println("correcto:)");
									return true;
								}else{
									System.out.println("Error,falta . al final de la regla");
									return false;
								}
							}
						
						}else{
							System.out.println("Error, al terminar los argumentos debe ir )");
							return false;
						}
					}
				
				}else{
					System.out.println("Error, las variables van en mayuscula1");
					return false;
				}
			
			}else{
				i--;
				if ((array[i].equals("fail")==true) ||(array[i].equals("nl")==true)){
					i++;
					if ((array[i].equals(",")==true) || (array[i].equals(";")==true )){
						i++;
						analizadorantecedentes(i,array);
					
					}else{
						if (array[i].equals(".")==true){
							System.out.println("correcto :)");
							return true;
						}else{
							System.out.println("Error,falta . al final de la regla");
							return false;
						}
					}
				
				}else{
					System.out.println("Error, todo functor debe tener argumentos");
					return false;
				}
			}
		
		}else{
			System.out.println("Error,el funtor va en minuscula");
			return false;
		}
	}else{
		System.out.println("Correcto:)");
		return true;
	}
	return false;
}	

// Metodo que recorre el arreglo y une los argumentos del fuctor para meterlos en la lista
		
public String argumentos(String [] array){
	int i=2;
	String argumentos = "";
	while(array[i].equals(")")==false){
		argumentos=argumentos+array[i];
		i++;
	}
	//System.out.println("Argumentos"+argumentos);
	return argumentos;
		
}

//Metodo que recorre el arreglo y une los antecedentes para meterlos en la lista

public String cuerpo(String [] array){
	int i=0;
	int len=array.length;
	String cuerpo = "";
	while(array[i].equals(":-")==false){
		i++;
	}
	i++;
	while(array[i]!=null){
		cuerpo=cuerpo+array[i];
		i++;
	}
//	System.out.println("cuerpo"+cuerpo);
	return cuerpo;
	
}

// Metdodo que valida si los argumentos o parametroso son numeros

public boolean validaNumeros(String valor){
	try {
		int num = Integer.parseInt(valor);
		//System.out.println("true");
		return true;
	} catch (Exception e) {
		//System.out.println("false");
		return false;
	}
}

// Metodo que revisa sintacticamente los hechos que ingresa los usuarios.

public boolean analizadorSintacticoHechos(String [] array){
	int i=0;
	int len = array.length;
//	System.out.println("largo arreglo"+ len);
	String minuscula = array [0].toLowerCase();
	if (array[0].equals(minuscula)==true && validaNumeros(array[0])==false) {
		while (array[i]!=null) {
			if ((array[1]!=null)&&(array[1].equals("("))) {
				minuscula = array [2].toLowerCase();
				if ((array[3]!=null)&&(array[2].equals(minuscula)==true|| validaNumeros(array[2])==true)&&(array[3].equals(","))) {
				//	System.out.println("ENTRO");
				//	System.out.println(minuscula +" Minuscula");
					minuscula = array [4].toLowerCase();
					if ((array[4]!=null)&&(array[4].equals(minuscula)==true || validaNumeros(array[4])==true)) {
					//	System.out.println(array[4]+ " array");
						if ((array[5]!=null)&&(array[5].equals(")"))) {
					//		System.out.println(array[6]+" ARRAYYYYYYYYYYYYY");
							if ((array[6]!=null) & (array[6].equals(".")))
								i++;
							else {
								System.out.println("Error, el hecho debe terminar en punto");
								return false;
							}
						} else {
							System.out.println("Error, los argumentos deben de cerrar con )");
							return false;
						}
					} else {
						System.out.println("Error,el functor debe ser minuscula o n�mero");
						return false;
					}
				} else {
					minuscula = array [2].toLowerCase();
					if ((array[2]!=null)&& (array[2].equals(minuscula)==true || validaNumeros(array[2])==true)) {
						if ((array[3]!=null)&&(array[3].equals(")"))) {
							if ((array[4]!=null)&&(array[4].equals("."))) {
								i++;
							} else {
								System.out.println("Error, el hecho debe terminar en punto");
								return false;
							}
						} else {
							System.out.println("Error, los argumentos deben terminar en )");
							return false;

						}
					} else {
						//System.out.println(array [i]+ "ARREGLO EN LA POS I");
						System.out.println("Error, el argumento debe ser en minuscula o numero");
						return false;
					}
				}
			} else {
				System.out.println("Error, los argumentos inician con (");
				return false;
			}
		}
		return true;
	} else {
		System.out.println("Error, el functor debe ser en minuscula");
		return false;

	}
	
}
	
}


