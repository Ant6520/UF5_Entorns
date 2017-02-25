package primerosN;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Pruevas Unitarias con Junit
 * 
 * @author Antonio
 *@version 12/02/2017
 */
@RunWith(Parameterized.class)
public class GarbellTest {
	/**
	 * Atributos de la clase
	 * 
	 */
	
	private int max;
	private int[] arrayEsperat;
	private int[] ArrayPrimersTrobats;

/**
 * Parametres utilizats en les proves
 * @return parametres utilitzats en les proves
 */
	@Parameters
    public static Collection<Object[]> setParameters() { 
        
    	  Collection<Object[]> params = new ArrayList<>();

        // Carregarem els paràmetres externs aquí:
    	params.add(new Object[] { 6,  new int[] {2,3,5}});
        params.add(new Object[] { 24, new int[] {2,3,5,7,11,15}});
        params.add(new Object[] { 20, new int[]{2,3,5,7,11,13,17,19}});
        params.add(new Object[] { 24, new int[]{2,8,5,7,11,13,17,19,23}});
        params.add(new Object[] { 6,  new int[] {2,3,530}});
        return params;
        }
    /**
     * omple de parametres lesvariables de les proves
     * @param max nombre maxim de valors
     * @param arrayEsperat array de resultats 
     */
    
	public GarbellTest(int max, int[] arrayEsperat)
	{
	   // Afegiu el codi que omplirà els atributs amb el valor dels paràmetres;
		this.max = max;
		this.arrayEsperat = arrayEsperat;
		this.ArrayPrimersTrobats=Primeros.obtenirPrimers(this.max);
	}
 /**
  * executa les comprovacions dels resultats esperats i els optinguts 
  */
	@Test
	public void test() {
		 assertEquals(arrayEsperat.length, ArrayPrimersTrobats.length);
		 assertArrayEquals(arrayEsperat, ArrayPrimersTrobats);

			//fail("Not yet implemented");   Aquesta línia també la deixarem comentada
	}

	

	

}
