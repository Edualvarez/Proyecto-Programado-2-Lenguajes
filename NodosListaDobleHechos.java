
// Clase NodosListaD
class NodosListaDobleHechos {
 // datos amigables para que la Clase Lista Tenga un acceso directo
     String Functor;
     int Aridad;
     String Argumentos;
     NodosListaDobleHechos siguiente;
     NodosListaDobleHechos anterior;

//Construtor  Crea un nodo del tipo Object
 NodosListaDobleHechos (String functor,int aridad,String argumentos)
  {
	 Functor =functor;
  	 Aridad=aridad;
  	 Argumentos=argumentos;
     siguiente = null;  //siguiente con valor de nulo
     anterior = null;
  }

// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
NodosListaDobleHechos (String functor,int aridad,String argumentos, NodosListaDobleHechos signodo)
{
	Functor =functor;
	Aridad=aridad;
	Argumentos=argumentos;
    siguiente = signodo; //siguiente se refiere al siguiente nodo
}

}//Final de la Clase NodosLista

