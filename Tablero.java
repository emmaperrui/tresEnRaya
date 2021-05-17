/**
 * Programa que simula un juego de 3 en raya.
 * @author Emma
 * @version (1)
 */


public class Tablero {

    private static final String CASILLA_VACIA = "_";
    
    /**
     * Atributos para las casillas del tablero y el jugador que gana.
     */
    private String[][] casillas;
    private Jugador ganador;
    
    /**
     * Método para crear el tablero.
     */
    public Tablero() {
        casillas = new String[][]{
            {CASILLA_VACIA, CASILLA_VACIA, CASILLA_VACIA},
            {CASILLA_VACIA, CASILLA_VACIA, CASILLA_VACIA},
            {CASILLA_VACIA, CASILLA_VACIA, CASILLA_VACIA}
        };
        ganador = null;
    }
    
    /**
     * Método para obtener las casillas.
     * @return casillas.
     */
    public String[][] getCasillas() {
        return casillas;
    }
    
    /**
     * Método para settear las casillas.
     * @param casillas.
     */
    public void setCasillas(String[][] casillas) {
        this.casillas = casillas;
    }
    
    /**
     * Método para obtener el ganador.
     * @return ganador.
     */
    public Jugador getGanador() {
        return ganador;
    }
    
    /**
     * Método para settear el ganador.
     * @param ganador.
     */
    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    /**
     * Método para imprimri por pantalla las casiilas y las posiciones.
     */
    public void imprimirCasillas() {
        String[] nombreFilas = {"A", "B", "C"};
        System.out.println("    1   2   3  ");
        for (int i = 0; i < casillas.length; i++) {
            System.out.print(nombreFilas[i] + " | ");
            for (int j = 0; j < casillas[0].length; j++) {
                System.out.print(casillas[i][j] + " | ");
            }
            System.out.println("");
        }
    }
    
    /**
     * Método para obtener las casillas.
     * @return resultado.
     */
    public String getStringCasillas() {
        String[] nombreFilas = {"A", "B", "C"};
        String resultado = "    1   2   3  \n";
        for (int i = 0; i < casillas.length; i++) {
            resultado = resultado + (nombreFilas[i] + " | ");
            for (int j = 0; j < casillas[0].length; j++) {
                resultado = resultado + casillas[i][j] + " | ";
            }
            resultado = resultado + "\n";
        }
        return resultado;
    }
    
    /**
     * Método para añadir la ficha.
     * @param jugador.
     * @param fila.
     * @param columna.
     * @return resultado.
     */
    public boolean addFicha(Jugador jugador, int fila, int columna) {
        boolean resultado = false;
        if (casillas[fila][columna].equals(CASILLA_VACIA)) {
            casillas[fila][columna] = jugador.getSimbolo();
            resultado = true;
        }
        comprobarGanador(jugador);
        return resultado;
    }
    
    /**
     * Método para comprobar el ganador.
     * @param jugador.
     * @return resultado.
     */
    public boolean comprobarGanador(Jugador jugador) {
        boolean resultado = true;
        if (!comprobarFilas(jugador)) {
            if (!comprobarColumnas(jugador)) {
                if (!comprobarDiagonales(jugador)) {
                    resultado = false;
                }
            }
        }
        return resultado;
    }
    
    /**
     * Método para comprobar las fichas.
     * @param jugador.
     * @return resultado.
     */
    private boolean comprobarFilas(Jugador jugador) {
        boolean resultado = false;
        int fila = 0;
        while (!resultado && fila < casillas.length) {
            if (!casillas[fila][0].equals(CASILLA_VACIA)) {
                if ((casillas[fila][0].equals(casillas[fila][1]) && casillas[fila][0].equals(casillas[fila][2]))) {
                    resultado = true;
                    ganador = jugador;
                }
            }
            fila++;
        }
        return resultado;
    }
    
    /**
     * Método para comprobar las columnas.
     * @param jugador.
     * @return resultado.
     */
    private boolean comprobarColumnas(Jugador jugador) {
        boolean resultado = false;
        int columna = 0;
        while (!resultado && columna < casillas.length) {
            if (!casillas[0][columna].equals(CASILLA_VACIA)) {
                if ((casillas[0][columna].equals(casillas[1][columna]) && casillas[0][columna].equals(casillas[2][columna]))) {
                    resultado = true;
                    ganador = jugador;
                }
            }
            columna++;
        }
        return resultado;
    }
    
    /**
     * Método para comprobar las diagonales.
     * @param jugador.
     * @return resultado.
     */
    private boolean comprobarDiagonales(Jugador jugador) {
        boolean resultado = false;
        if (!casillas[1][1].equals(CASILLA_VACIA)) {
            if ((casillas[0][0].equals(casillas[1][1]) && casillas[0][0].equals(casillas[2][2]))) {
                resultado = true;
                ganador = jugador;
            } else if ((casillas[2][0].equals(casillas[1][1]) && casillas[2][0].equals(casillas[0][2]))) {
                resultado = true;
                ganador = jugador;
            }
        }
        return resultado;
    }
}
