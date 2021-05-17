/**
 * Programa que simula un juego de 3 en raya.
 * @author Emma
 * @version (1)
 */


import java.util.Random;
import java.util.Scanner;


public class Main {

    static Scanner sc;
    static Tablero tablero;
    static Jugador j1;
    static Jugador j2;
    static ArchivoLog log;
    static int turno;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        start();
        loop();
    }

    /**
     * Método para empezar el juego. Introducimos los nombre de los jugadores.
     */
    private static void start() {
        // Inicializamos variables
        log = new ArchivoLog();
        log.addLine(true, "Partida empezada");
        turno = 1;
        tablero = new Tablero();

        // Recogemos informaciÃ³n de los usuarios y lanzamos el dado
        sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador 1");
        j1 = new Jugador(sc.nextLine(), "X");
        System.out.println("Introduce el nombre del jugador 2");
        j2 = new Jugador(sc.nextLine(), "0");
        log.addLine(true, "Van a jugar " + j1.getNombre() + " y " + j2.getNombre());
        lanzarDados();

    }
    
    /**
     * Método que genera un dado para seleccionar el jugador que empieza el juego.
     */
    private static void lanzarDados() {
        Random rnd = new Random();
        int dado1 = 0, dado2 = 0;
        while (dado1 == dado2) {
            dado1 = rnd.nextInt(6) + 1;
            log.addLine(true, j1.getNombre() + " ha tirado el dado y ha sacado un " + dado1);
            dado2 = rnd.nextInt(6) + 1;
            log.addLine(true, j2.getNombre() + " ha tirado el dado y ha sacado un " + dado2);
            if (dado1 == dado2) {
                log.addLine(true, j1.getNombre() + " y " + j2.getNombre() + " han sacado el mismo número, se repetirá el lanzamiento");
            } else {
                if (dado2 > dado1) {
                    Jugador jugadorAux = j1;
                    j1 = j2;
                    j2 = jugadorAux;
                }
                log.addLine(true, j1.getNombre() + " va a tirar primero");
            }
        }
    }
    
    /**
     * Método que genera un bucle para que siga saliendo el tablero después de cada movimiento. Si el juego queda en empate o gana alguien en lopp se para.
     */
    private static void loop() {
        while (tablero.getGanador() == null && turno <= 9) {
            realizarMovimiento(j1);
            if (turno <= 9) {
                realizarMovimiento(j2);
            }
        }
        log.addTablero(tablero.getStringCasillas());
        if (turno > 9) {
            log.addLine(true, "Juego finalizado en empate");
        } else {
            log.addLine(true, "Juego finalizado, Ganador => " + tablero.getGanador().getNombre() + " con símbolo " + tablero.getGanador().getSimbolo());
        }
    }
    
    /**
     * Método que realiza los movimientos de los jugadores.
     * @param j Nombre del jugador
     */
    private static void realizarMovimiento(Jugador j) {
        if (tablero.getGanador() == null) {
            recogerResultados(j);
        }
    }
    
    /**
     * Método que recoge los movimientos de los jugadores. Les pide que introduzacan las cordenadas cada vez que es su turno, e indica cuáles han seleccionado.
     * En caso de que la cordenada no sea válida les sale un mensaje de error, y hasta que no metan de manera correcta la coordenada no podrán jugar, y volverá a saltar el mensaje.
     * @param j Nombre del jugador
     */
    private static void recogerResultados(Jugador jugador) {
        //sc = new Scanner(System.in);
        boolean movimientoValido = false;
        log.addTablero(tablero.getStringCasillas());
        System.out.println("Turno de " + jugador.getNombre() + ". Introduce las coordenadas separadas por espacio");
        while (!movimientoValido) {
            try {
                int fila = -1, columna = -1;
                String[] coordenadas = sc.nextLine().split(" ");
                if (coordenadas.length == 2) {
                    switch (coordenadas[0].toUpperCase()) {
                        case "A":
                            fila = 0;
                            break;
                        case "B":
                            fila = 1;
                            break;
                        case "C":
                            fila = 2;
                            break;
                        default:
                            break;
                    }
                    columna = Integer.valueOf(coordenadas[1])-1;
                }

                movimientoValido = tablero.addFicha(jugador, fila, columna);
                if (!movimientoValido) {
                    System.out.println("Movimiento incorrecto, por favor " + jugador.getNombre() + " repite las coodenadas");
                } else {
                    log.addLine(false, "Turno " + turno + ": " + jugador.getNombre() + " ha seleccionado las coordenadas " + coordenadas[0] + " y " + coordenadas[1]);
                    turno++;
                }
            } catch (Exception e) {
                System.out.println("Error a la hora de recoger el movimiento, " + jugador.getNombre() + " vuelve a poner las coordenadas");
            }
        }
    }
}
