import java.util.Scanner;

public class CombateSecreto {
    private Heroe heroe;
    private TablosAF villano;
    private Scanner scanner;

    public CombateSecreto(Heroe heroe, TablosAF villano) {
        this.heroe = heroe;
        this.villano = villano;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("¡El combate secreto contra " + villano.getNombre() + " ha comenzado!");
        MusicPlayer.stopMusic();
        MusicPlayer.playSound("ESCENCIA\\Goku vs Broly  - Bring me to Life HD.wav");

        System.out.println("7 palabras, escencia muajajajajajaja!");

        while (heroe.esVivo() && villano.esVivo()) {
            // Mostrar estadísticas
            mostrarEstadisticas();
            // Turno del héroe
            realizarTurnoHeroe();
            if (!villano.esVivo()) {
                mostrarMensajeVictoria(); // Llama al mensaje de victoria aquí
                return; // Termina el combate si el villano ha sido derrotado
            }

            // Turno del villano
            villano.seleccionarAtaque(heroe);
            if (!heroe.esVivo()) {
                mostrarMensajeDerrota();
            }
        }
    }

    private void mostrarEstadisticas() {
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Héroe: " + heroe.nombre + " | Vida: " + heroe.vida_hp + " | Fuerza: " + heroe.fuerza + " | Velocidad: " + heroe.velocidad);
        System.out.println("Villano: " + villano.getNombre() + " | Vida: " + villano.vida_hp + " | Fuerza: " + villano.fuerza + " | Velocidad: " + villano.velocidad);
        System.out.println("----------------------\n");
    }

    private void realizarTurnoHeroe() {
        System.out.println("Turno de " + heroe.nombre);
        System.out.println("Elige tu acción: ");
        System.out.println("1. Atacar");
        System.out.println("2. Super Técnica");
        System.out.println("3. Curarse");
        
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                heroe.atacar(villano);
                break;
            case 2:
                heroe.usarSuperAtaque(villano);
                break;
            case 3:
                heroe.curarse();
                break;
            default:
                System.out.println("Opción no válida. El héroe pierde su turno.");
        }
    }

    private void mostrarMensajeVictoria() {
        String mensajeVictoria = "¡Felicidades nenaza, eres alguien fuerte con escencia, no me comeré tus entrañas solo por hoy muajajajajaja!";
        MusicPlayer.playSound("ESCENCIA\\Victory! Touhou Series - Super Smash Bros. Ultimate.wav");
        narrar(mensajeVictoria);
    }

    private void mostrarMensajeDerrota() {
        String mensajeDerrota = "NENAZA SIN ESCENCIA!";
        MusicPlayer.playSound("songs\\Deltarune OST： 39 - Laura Shigihara - Don't Forget.wav");
        narrar(mensajeDerrota);
    }

    private void narrar(String mensaje) {
        for (char letra : mensaje.toCharArray()) {
            System.out.print(letra);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
