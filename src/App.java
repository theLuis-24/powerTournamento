import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MusicPlayer.playSound("songs\\Touhou 19 UDoALG OST - Reimu & Early Story Theme - The World is Made From Cuteness.wav");
        System.out.println("Bienvenido a My Hero Battle Ultimate");
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("1. Iniciar juego");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Heroe heroe = seleccionarHeroe(scanner);
                    Villano villano1 = new Villano("Villano 1", 15, 8, 100, "Ataque Especial Villano 1");
                    Villano villano2 = new Villano("N-E-O", 20, 10, 120, "Ataque Especial Villano 2");

                    Combate combate1 = new Combate(heroe, villano1);
                    combate1.iniciar();

                    if (heroe.esVivo()) {
                        System.out.println("Así que lograste vencer a mi compañero, eh... no importa, ahora verás el poder de N-E-O.");
                        heroe.restaurarVidaCompleta(); // Restaurar vida del héroe
                        Combate combate2 = new Combate(heroe, villano2);
                        combate2.iniciar();

                        if (heroe.esVivo()) {
                            // Reproducir la canción de victoria
                            MusicPlayer.stopMusic();
                            MusicPlayer.playSound("songs\\EoSD Credits Theme - Crimson Belvedere ~ Eastern Dream....wav"); // Cambia la ruta a tu canción de victoria
                            // Mostrar el mensaje final letra por letra
                            narrar("El mundo ahora está en paz, los héroes lograron vencer al mal más antiguo de todos, NEO, ahora los guerreros descansan... "
                                    + "Los combates seguirán hasta que logren vencer al rey demonio WOLF-ESTEIN, conocido también como el programador del cosmos.");
                        } else {
                            // Si el héroe es derrotado en el segundo combate
                            mostrarMensajeDerrota();
                        }
                    } else {
                        // Si el héroe es derrotado en el primer combate
                        mostrarMensajeDerrota();
                    }
                    break;

                case 2:
                    System.out.println("Saliendo del juego...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 2);
    }

    public static Heroe seleccionarHeroe(Scanner scanner) {
        System.out.println("Selecciona tu héroe:");
        System.out.println("1. El Mostacho Solar (Transformación)");
        System.out.println("2. Curador (Maxi Curación)");
        System.out.println("3. Guerrero (Kamehameha)");
        System.out.println("4. Cargador (Cargar ataque)");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                return new Heroe("El Mostacho Solar", 25, 15, 100, "Transformación");
            case 2:
                return new Heroe("Curador", 20, 10, 90, "Maxi Curación");
            case 3:
                return new Heroe("Guerrero", 30, 12, 80, "Kamehameha");
            case 4:
                return new Heroe("Cargador", 18, 14, 85, "Cargar Ataque");
            default:
                System.out.println("Opción no válida. Seleccionando El Mostacho Solar por defecto.");
                return new Heroe("El Mostacho Solar", 25, 15, 100, "Transformación");
        }
    }

    public static void narrar(String mensaje) {
        for (char letra : mensaje.toCharArray()) {
            System.out.print(letra);
            try {
                Thread.sleep(100); // Espera 100 ms entre cada letra para simular la escritura
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // Nueva línea al final del mensaje
    }

    public static void mostrarMensajeDerrota() {
        // Detener cualquier música actual
        MusicPlayer.stopMusic();

        // Definir el mensaje de derrota
        String mensajeDerrota = "Los héroes han caído ante la oscuridad, "
                              + "ahora nadie podrá detener a los grandes villanos y el futuro de la humanidad habrá acabado, "
                              + "¡sálvanos, Goku!";

        // Reproducir la música de derrota
        MusicPlayer.playSound("songs\\Deltarune OST： 39 - Laura Shigihara - Don't Forget.wav"); // Cambia la ruta a tu canción de derrota

        // Mostrar el mensaje de derrota letra por letra
        narrar(mensajeDerrota);
    }
}
