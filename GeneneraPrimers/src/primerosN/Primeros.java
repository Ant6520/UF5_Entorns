package primerosN;
import java.util.Arrays;
/**
* Classe que utilitzar� el garbell d'Erast�tenes per trobar els nombres primers.
* Veure el comportament gr�ficament aqu� de l'algorisme:
* @author Antonio Exposito UF5
http://blocs.xtec.cat/ceipcirera6/2014/10/08/garbell-derastostenes
*/

public class Primeros {
	
	/**  
	   * Generar nombres primers de 2 fins a max
	   * @param max es el valor m�xim
	   * @return un array de enters amb els nombres primers
	   */
	
	public static int[] obtenirPrimers (int max) {   

		
	     if (max >= 2) { //control de minims	    	 
	             return retornaPrimers(max); 
	      } else  return new int[0];   // Vector buit
	              
	 }

	/**  
	   * calcula els nomvers primers
	   * @param max es el valor m�xim
	   * @return Vector de nombres primers
	   */

	private static int[] retornaPrimers(int max) {
		boolean[] bEsPrimer = inicial(max); 
		int comptador = eliminarLosElementosNoPrimeros(max, bEsPrimer); 
		int[] VectorPrimers = new int[comptador]; 
		
		for (int i=0, j=0; i<max; i++) {    
		    if (bEsPrimer[i])
		       VectorPrimers[j++] = i; // valor de nombre primer en la seva posicio dins el vector 
		}     
		return VectorPrimers;
	}
	/**  
	   * elimina els mombres que no sigin primers
	   * @param max es el valor m�xim
	   * @param bEsPrimers vector boleano que almacena si los numeros son primeros
	   * @return comptador que es un enter i el numero total de primeros entre el 0 y max
	   */

	private static int eliminarLosElementosNoPrimeros(int max, boolean[] bEsPrimer) {
		
		double totalMaximPrimers = Math.sqrt(max)+1;
		int comptador = 0; 

		for (int i=2; i<totalMaximPrimers; i++) {// marquem com no primers tots els m�ltiples de i
			   if (bEsPrimer[i]){
					for (int j=2*i; j<max; j+=i) {
		        		bEsPrimer[j] = false; // Eliminar els m�ltiples de i
					
					}
					
				}
			}

		for(int i=0; i<bEsPrimer.length; i++)
			if(bEsPrimer[i])
				comptador++;//numero total de valores encontrados
		
		return comptador;
	}
	/**  
	   * inicializa los valores del array boleano para su utilizacion
	   * @param max es el valor m�xim
	   * @return bEsPrimers vector boleano que almacena si los numeros son primeros
	   */

	private static boolean[] inicial(int max) {
		boolean[] bEsPrimer = new boolean[max]; 
		for (int i=2; i<max; i++)    
			bEsPrimer[i] = true; 
		return bEsPrimer;
	}

	
    public static void main (String args[]) {
        System.out.println("Generaci� de nombres primers amb Garbell d'Erast�tenes:");
        System.out.println("-------------------------------------------------------");
        int[] VectorFinalPrimers;
        VectorFinalPrimers = obtenirPrimers (120);
        System.out.println(VectorFinalPrimers.length + " nombres primers trobats en el interval [1-120]");
        System.out.println(Arrays.toString(VectorFinalPrimers));
    }
	
}
	        
	        


