import java.util.Scanner;

class Combate {
    private Heroe heroe;
    private Villano villano;
    private Scanner scanner;

    public Combate(Heroe heroe, Villano villano) {
        this.heroe = heroe;
        this.villano = villano;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("¡El combate ha comenzado!");
        while (heroe.esVivo() && villano.esVivo()) {
            if (heroe.velocidad >= villano.velocidad) {
                heroeTurno();
                if (villano.esVivo()) villanoTurno();
            } else {
                villanoTurno();
                if (heroe.esVivo()) heroeTurno();
            }
            villano.reducirCooldown();
            mostrarEstadisticas();  // Mostrar estadísticas después de cada turno
        }
        mostrarResultado();
    }

    private void heroeTurno() {
        System.out.println("Turno de " + heroe.nombre);
        System.out.println("Elige tu acción: ");
        System.out.println("1. Atacar");
        System.out.println("2. Super Ataque");
        System.out.println("3. Curarse");

        if (heroe.habilidadEspecial.equals("Transformación") && !heroe.transformado) {
            System.out.println("4. Transformarse");
        }

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
            case 4:
                if (heroe.habilidadEspecial.equals("Transformación") && !heroe.transformado) {
                    heroe.usarSuperAtaque(villano);
                } else {
                    System.out.println("Opción no válida.");
                }
                break;
            default:
                System.out.println("Opción no válida. Pasas el turno.");
        }
    }

    private void villanoTurno() {
        System.out.println("Turno de " + villano.nombre);
        if (villano.cooldownEspecial == 0) {
            villano.ataqueEspecial(heroe);
        } else {
            villano.atacar(heroe);
        }
    }

    private void mostrarEstadisticas() {
        System.out.println("\n--- Estadísticas ---");
        System.out.println("Héroe: " + heroe.nombre + " | Vida: " + heroe.vida_hp + " | Fuerza: " + heroe.fuerza + " | Velocidad: " + heroe.velocidad);
        System.out.println("Villano: " + villano.nombre + " | Vida: " + villano.vida_hp + " | Fuerza: " + villano.fuerza + " | Velocidad: " + villano.velocidad);
        System.out.println("----------------------\n");
    }

    private void mostrarResultado() {
        if (heroe.esVivo()) {
            System.out.println("¡" + heroe.nombre + " ha vencido a " + villano.nombre + "!");
        } else {
            System.out.println("El mal ha vencido, ¡date prisa Goku y sálvanos!");
        }
    }
}
