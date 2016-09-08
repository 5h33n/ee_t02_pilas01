package ee_t02_pilas01;

public class Pila {
	private String[] pila;
	private Integer tope;
	private Integer tam;
	
	/** Constructor de la pila **/
	
	public Pila(Integer tamano){
		pila = new String[tamano];
		tope = -1;
		tam  = tamano;
	}
	/** Método push para ingresar datos a la pila **/
	
	public void push(String dato){
		if(tope < (tam-1)){
			tope++;
			pila[tope] = dato;
		}else{
			System.out.println("Desbordamiento");
		}
	}
	
	/** Método pop para eliminar datos **/
	
	public String pop(){
		String resultado="";
		if(tope > -1){
			resultado = pila[tope];
			pila[tope] = null;
			tope--;
		}else{
			resultado = "Subdesbordamiento";
		}
		return resultado;
	}
	
	/** Método peek para consultar el ultimo dato **/
	
	public String peek(){
		String resultado="";
		if(tope > -1){
			resultado = pila[tope];
		}else{
			resultado = "Subdesbordamiento";
		}
		return resultado;
	}
}