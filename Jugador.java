/**
 * Programa que simula un juego de 3 en raya.
 * @author Emma
 * @version (1)
 */


public class Jugador {

	/**
	 * Creamos los atributos del nombre, del jugador y el símbolo que va a usar para jugar.
	 */
    private String nombre;
    private String simbolo;
    
   
    /**
     * Método para crear al jugador, introduciendo el nombre y el símbolo.
     * @param nombre Nombre del jugador.
     * @param simbolo Símbolo del jugador.
     */
    public Jugador(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    /**
     * Método para obtener el nombre.
     * @return nombre Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método para settear el nombre.
     * @param nombre Nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Método para obtener el símbolo del jugador.
     * @return simbolo Símbolo del jugador.
     */
    public String getSimbolo() {
        return simbolo;
    }
    
    /**
     * Método para settear el símbolo del jugador.
     * @param simbolo Símbolo del jugador.
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    /**
     * Método para imprimir la información que hemos proporcionado anteriormente sobre el jugador.
     *      
     */
    public void imprimirInfo() {
        System.out.println("Jugador:" + nombre + " con símbolo " + simbolo);
    }
}
