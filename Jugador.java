/**
 * Programa que simula un juego de 3 en raya.
 * @author Emma
 * @version (1)
 */


public class Jugador {

	/**
	 * Creamos los atributos del nombre, del jugador y el s�mbolo que va a usar para jugar.
	 */
    private String nombre;
    private String simbolo;
    
   
    /**
     * M�todo para crear al jugador, introduciendo el nombre y el s�mbolo.
     * @param nombre Nombre del jugador.
     * @param simbolo S�mbolo del jugador.
     */
    public Jugador(String nombre, String simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    /**
     * M�todo para obtener el nombre.
     * @return nombre Nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * M�todo para settear el nombre.
     * @param nombre Nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * M�todo para obtener el s�mbolo del jugador.
     * @return simbolo S�mbolo del jugador.
     */
    public String getSimbolo() {
        return simbolo;
    }
    
    /**
     * M�todo para settear el s�mbolo del jugador.
     * @param simbolo S�mbolo del jugador.
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    /**
     * M�todo para imprimir la informaci�n que hemos proporcionado anteriormente sobre el jugador.
     *      
     */
    public void imprimirInfo() {
        System.out.println("Jugador:" + nombre + " con s�mbolo " + simbolo);
    }
}
