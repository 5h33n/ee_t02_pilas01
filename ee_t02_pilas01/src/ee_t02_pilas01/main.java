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
	/** Este método determina si las cadenas están balanceadas o no**/
	public void Determinar(Integer n,String...cad){
		/** Primero se comprueba que el entero instroducido coincida con las
		 *  cadenas enviadas, de no ser así, se notifica**/
		if(n != cad.length){

			System.out.println("El número especificado no coincide con la cantidad"
					+ " de cadenas introducidas");
		}else {
			
		String d;boolean flag;
		/** Se llama al método "restricciones" para comprobar que los números estén
		 *  dentro del rango 1 y 10^3 **/
		if (restricciones(n,cad)){
			/** Se inicia un ciclo para cada cadena enviada **/
			for (int i=0;i < n; i++){
				/** Si la cadena es impar, de inmediato se envía un "No", pues no es
				 *  posible que esté balanceada
				 */
				if (cad[i].length() % 2 == 0){
					/** Se crea la pila**/
					Pila p = new Pila(cad[i].length());
					int j=0;
					/** En este ciclo se hace la comparación para identificar
					 *  los signos que abren y los que cierran **/
					flag=true;
					while(flag){
						if(cad[i].charAt(j) == '{' || cad[i].charAt(j) =='[' || cad[i].charAt(j)=='('){
							p.push(cad[i].charAt(j)+"");
						}else{
							d= p.pop() + cad[i].charAt(j);
							if( d.equals("[]") || d.equals("()") || d.equals("{}")) {
								
								flag=true;
							}else{
								System.out.println("No");
								break;
							}
						}
						/** Al final si ocurre un desbordamiento, se envía un "Sí"
						 *  pues todos los elementos encontraron su par**/
						if(p.peek().equals("Subdesbordamiento")){
							flag=false;
							System.out.println("Sí");
						}
						j++;
					}
				}else{
					System.out.println("No");
				}
			}
		}else{
			System.out.println("Valores demasiado grandes.");
		}
		}
	}
	/** Este método solamente evalúa que las cadenas se encuentren en el rango
	 *  especificado y devuelve una respuesta booleana**/
	public boolean restricciones(Integer n, String...args){
		boolean r=true;
		if(n>=1 && n<=(10*10*10)){
			for (int i=0;i < n; i++){
				if(args[i].length()>=1 && args[i].length()<=(10*10*10)){
					r=true;
				}else{
					r=false;
					break;
				}
			}
		}else{
			r=false;
		}
		return r;
	}
}