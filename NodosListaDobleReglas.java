
// Clase NodosListaD
class NodosListaDobleReglas {
 // datos amigables para que la Clase Lista Tenga un acceso directo
     String Functor;
     int Aridad;
     String Argumentos;
     String Antecedentes;
     NodosListaDobleReglas siguiente;
     NodosListaDobleReglas anterior;

//Construtor  Crea un nodo del tipo Object
 NodosListaDobleReglas (String functor,int aridad,String argumentos,String antecedentes)
  {
	 Functor =functor;
  	 Aridad=aridad;
  	 Antecedentes=antecedentes;
  	 Argumentos=argumentos;
     siguiente = null;  //siguiente con valor de nulo
     anterior = null;
  }

// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
NodosListaDobleReglas (String functor,int aridad,String argumentos,String antecedentes, NodosListaDobleReglas signodo)
{
	Functor =functor;
	Aridad=aridad;
	Argumentos=argumentos;
	Antecedentes=antecedentes;
    siguiente = signodo; //siguiente se refiere al siguiente nodo
}

}//Final de la Clase NodosLista
