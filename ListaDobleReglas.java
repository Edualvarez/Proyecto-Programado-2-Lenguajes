
//Definición de la Clase Lista
 public class ListaDobleReglas
{
  public NodosListaDobleReglas  PrimerNodo;
  public NodosListaDobleReglas  UltimoNodo;
  

//Constructor construye una lista vacia con un nombre s

//Retorna True si Lista Vacía
 public boolean VaciaLista () {
	 return PrimerNodo == null;
	 }

// Imprime el contenido de la lista
 public void Imprimir()
 { if (VaciaLista())
   {
     System.out.println( "vacia" +"Lista");
   }
   //fin del primer if
  else
  {
	  System.out.print( "La  " +  "Lista" +"  es:  ");
      NodosListaDobleReglas  Actual = PrimerNodo;

     while (Actual != null)
	 {
      System.out.print (Actual.Functor + "-"+Actual.Aridad+"-"+Actual.Argumentos +"-"+Actual.Antecedentes+"-->");
      Actual=Actual.siguiente;
     }

     System.out.println();
     System.out.println();
   }
 }

 


//Inserta un Elemento al Frente de la Lista
//Si esta vacía PrimerNodo y UltimoNodo se refieren al nuevo nodo. Si no PrimerNodo se refiere al nuevo nodo.

public void InsertaInicio (String functor,int aridad,String argumentos,String antecedentes)
{ if (VaciaLista())
   PrimerNodo = new NodosListaDobleReglas  (functor,aridad,argumentos,antecedentes);
  else{
   PrimerNodo = new NodosListaDobleReglas  (functor,aridad,argumentos,antecedentes, PrimerNodo);
   PrimerNodo.siguiente.anterior =PrimerNodo;
  }
}


//Inserta al Final de la Lista
//Si la lista se encuentra vacía, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo.
public void InsertaFinal(String functor,int aridad,String argumentos,String antecedentes)
{ if ( VaciaLista())
     PrimerNodo = new NodosListaDobleReglas  (functor,aridad,argumentos,antecedentes);
  else
     {
      NodosListaDobleReglas  aux= PrimerNodo;
      while (aux.siguiente != null)
         aux = aux.siguiente;
      /* Primera Forma
         aux.siguiente = new NodosListaDobleReglas  (ElemInser);
         aux.siguiente.anterior =aux;
     */
     //Segunda Forma
      NodosListaDobleReglas  Nuevo = new NodosListaDobleReglas  (functor,aridad,argumentos,antecedentes);
      aux.siguiente= Nuevo;
      Nuevo.anterior= aux;
     
    }
}




//Eliminar al Inicio
//Debe tomar en cuenta si la lista se encuentra vacía y producir una excepción, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  primernodo será igual a PrimerNodo.siguiente

public void EliminaInicio()
{ 
  if  ( VaciaLista()) 
     System.out.println ("No hay elementos");  
  else 
    {
       // Restablecer  las referencias de PrimerNodo y UltimoNodo
       if (PrimerNodo.siguiente== null)
          PrimerNodo = null;
       else
          PrimerNodo = PrimerNodo.siguiente;
          PrimerNodo.anterior=null;
      }
}

//Eliminar al Final
//Debe tomar en cuenta si la lista se encuentra vacía y producir una excepción, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  ultimonodo en el campo siguiente será nulo

public void EliminaFinal ()
{ 
  if  ( VaciaLista())
    System.out.println ("No hay elementos");
  else
   {
    // Restablecer  las referencias de PrimerNodo y UltimoNodo
     if (PrimerNodo.siguiente== null)
        PrimerNodo =  null;
      else
      { 
       // Primera Forma
        NodosListaDobleReglas  Actual =PrimerNodo;
        
         while (Actual.siguiente.siguiente != null)
            Actual = Actual.siguiente;

          Actual.siguiente = null;
       
        /* Segunda Forma
        NodosListaDobleReglas  Actual =PrimerNodo;
        
         while (Actual.siguiente != null)
            Actual = Actual.siguiente;

       Actual.anterior.siguiente = null;
       */

      }
   }

 }

}

