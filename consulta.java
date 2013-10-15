
import java.util.*;
public class consulta {
	LinkedList<Nodovariable> l1 = new LinkedList<Nodovariable>();


	boolean consultar(String sentencia, ListaDobleHechos lh,ListaDobleReglas lr ){
		Analizadores an = new Analizadores();
		NodosListaDobleReglas auxR = lr.PrimerNodo;
		NodosListaDobleHechos auxH= lh.PrimerNodo;
		String sub1;
		String sub2;
		int x,i,j;
		int index1,index2;
		index1=0;
		index2=1;
		x=sentencia.indexOf("(");
		sub1=sentencia.substring(0,(x-1));
		sub2=sentencia.substring(x+1, (sentencia.length()-1));
		i=an.aridad(sub2);
		while (auxH!=null){
			if (auxH.Functor.equals(sub1)==true){
				if (auxH.Aridad==i){
					while(sub2.isEmpty()==false){
						if(sub2.substring(0,1).equals(",")==false){
							l1.add(new Nodovariable(sub2.substring(index1,index2),auxH.Argumentos.substring(index1, index2)));
						}
						if(sub2.isEmpty()==false){
							sub2=sub2.substring(1);
						}
					}
					return (true);
				}
			}
		}
		while(auxR!=null){
			if (auxR.Functor.equals(sub1)==true){
				if (auxR.Aridad==i){
					LinkedList<String> l2 = new LinkedList<String>();

			}
				}
		}
		return (false);
		}
}
