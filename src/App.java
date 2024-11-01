import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MusicPlayer.playSound("songs\\Touhou 19 UDoALG OST - Title Screen Theme - Intelligence of Beast.wav");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\u001B[34m" + "--------------------------------------------------------------------------------");
            System.out.println("\u001B[34m" + "                               My Hero Battle Ultimate");
            System.out.println("\u001B[34m" + "--------------------------------------------------------------------------------");
            System.out.println("                                 1. Iniciar juego");
            System.out.println("                                     2. Salir");
            System.out.println("                                  "); // Opción para el combate secreto
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica del combate normal (sin cambios)
                    MusicPlayer.stopMusic();
                    MusicPlayer.playSound("songs\\Touhou 19 UDoALG OST - Reimu & Early Story Theme - The World is Made From Cuteness.wav");
                    Heroe heroe = seleccionarHeroe(scanner);
                    Villano villano1 = new Villano("casalander", 15, 8, 100, "Ataque Especial Villano 1");
                    Villano villano2 = new Villano("N-E-O", 20, 10, 120, "Ataque Especial Villano 2");

                    Combate combate1 = new Combate(heroe, villano1);
                    combate1.iniciar();

                    if (heroe.esVivo()) {
                        System.out.println("Así que lograste vencer a mi compañero, eh... no importa, ahora verás el poder de N-E-O.");
                        heroe.restaurarVidaCompleta();
                        Combate combate2 = new Combate(heroe, villano2);
                        combate2.iniciar();

                        if (heroe.esVivo()) {
                            MusicPlayer.stopMusic();
                            MusicPlayer.playSound("songs\\EoSD Credits Theme - Crimson Belvedere ~ Eastern Dream....wav");
                            narrar("El mundo ahora está en paz, los héroes lograron vencer un gran mal antiguo de todos, NEO y su secuaz casalander, ahora los guerreros descansan... "
                                    + "pero ahora un nuevo mal esta por surgir, El rey demonio WOLF-ESTEIN, conocido también como el programador del cosmos.");
                        } else {
                            mostrarMensajeDerrota();
                        }
                    } else {
                        mostrarMensajeDerrota();
                    }
                    break;

                case 2:
                    System.out.println("Saliendo del juego...");
                    break;

                case 7:
                    // Iniciar combate secreto contra Tablos AF
                    MusicPlayer.playSound("ESCENCIA\\fakeyou_rvc_v7akyd7czwyapddxzxc2pqvgw3j2teeh.wav");
                    Heroe heroeSecreto = seleccionarHeroe(scanner);
                    TablosAF tablosAF = new TablosAF();
                    CombateSecreto combateSecreto = new CombateSecreto(heroeSecreto, tablosAF);
                    combateSecreto.iniciar();
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 2);
    }

    public static Heroe seleccionarHeroe(Scanner scanner) {
        System.out.println("Selecciona tu héroe:");
        System.out.println("1. El Mostacho Solar (Transformación)");
        System.out.println("2. genji (Maxi Curación)");
        System.out.println("3. gonzalo el mago (Kamehameha)");
        System.out.println("4. magnus el rojo (Cargar ataque)");

        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                return new Heroe("El Mostacho Solar", 25, 15, 110, "Transformación");
            case 2:
                return new Heroe("genji", 20, 10, 90, "Maxi Curación");
            case 3:
                return new Heroe("gonzalo el mago", 30, 12, 100, "Kamehameha");
            case 4:
                return new Heroe("magnus el rojo", 26, 14, 120, "Cargar Ataque");
            default:
                System.out.println("Opción no válida. Seleccionando El Mostacho Solar por defecto.");
                return new Heroe("El Mostacho Solar", 25, 15, 100, "Transformación");
        }
    }

    public static void narrar(String mensaje) {
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

    public static void mostrarMensajeDerrota() {
        MusicPlayer.stopMusic();
        String mensajeDerrota = "Los héroes han caído ante la oscuridad, "
                              + "ahora nadie podrá detener a los grandes villanos y el futuro de la humanidad habrá acabado, "
                              + "¡sálvanos, Goku!";
        MusicPlayer.playSound("songs\\Deltarune OST： 39 - Laura Shigihara - Don't Forget.wav");
        narrar(mensajeDerrota);
    }
}
