/** Programa realizado por: Oscar Eduardo Lopez Guzmán
 *  Para la clase "Estructura de datos"  08/09/2016
 *  
 *  
 */

package ee_t02_pilas01;

public class main {
	public static void main(String...args){
		main x = new main();
		/** Aquí se lee la cadena inicial, con todo y el número entero**/
		x.Determinar(3,"{[()]}","{[(])}","{{[[(())]]}}");
	}
	/** Este método separa las n cadenas en dos y las pone en pilas diferentes**/
	public void Determinar(Integer n,String...cad){
		if (n == cad.length){
			for (int i=0;i < n; i++){
				/** primero se comprueba que la cadena tenga un número par de caractéres
				 *  de no ser así, se envía de inmediato un "No", pues no es posible que
				 *  la cadena esté balanceada
				 */
				if (cad[i].length() % 2 == 0){
					int mitad = (cad[i].length())/2;
					/** Aquí se crean y se llenan las pilas **/
					Pila p1 = new Pila(mitad);
					Pila p2 = new Pila(mitad);
					for (int j = 0; j<mitad; j++ ){
						p1.push(cad[i].charAt(j)+"");
					}
					for (int f = (mitad*2)-1;f>=mitad;f--){
						p2.push(cad[i].charAt(f)+"");
					}
					/** Se envían las dos pilas para compararlas **/
					Comparar(p1,p2);
				}else{
					System.out.println("No");
				}
			}
		}else{
			System.out.println("El número especificado no coincide con la cantidad"
					+ " de cadenas introducidas");
		}
	}
	/** Este método compara dos pilas para saber si sus elementos coinciden dígito
	 * por dígito
	 */
	public void Comparar(Pila p1, Pila p2){
		String a , b ;
		boolean r;
		/** Este ciclo se detiene cuando uno de los caracteres de las pilas
		 *  sea diferente, o cuando haya un subdesbordamiento
		 */
		do{
			a = p1.pop();
		    b = p2.pop();
		    if ((a.equals("[") && b.equals("]"))){
		    	r=true;
		    }else if((a.equals("(") && b.equals(")"))){
		    	r=true;
		    }else if((a.equals("{") && b.equals("}"))){
		    	r=true;
		    }else{r=false;}
		    if(a.equals("Subdesbordamiento")){
		    	r=false;
		    }
		}while(r);
		/** Si al final ocurre un subdesbordamiento, significa que la cadena
		 * está balanceada y se imprime ese caso o el contrario.
		 */
		if (a.equals("Subdesbordamiento")){
			System.out.println("Sí");
		}else{
			System.out.println("No");
		}
	}
}