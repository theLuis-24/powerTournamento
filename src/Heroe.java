public class Heroe {
    String nombre;
    int fuerza;
    int velocidad;
    int vida_hp;
    String habilidadEspecial; // Representa la habilidad especial del héroe
    boolean transformado = false; // Estado de transformación
    int maxCuras = 3; // Número máximo de curas

    public Heroe(String nombre, int fuerza, int velocidad, int vida_hp, String habilidadEspecial) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
        this.habilidadEspecial = habilidadEspecial;
    }

    public void atacar(Villano villano) {
        System.out.println(nombre + " ataca a " + villano.nombre + ".");
        villano.recibirDaño(fuerza);
    }

    public void usarSuperAtaque(Villano villano) {
        switch (habilidadEspecial) {
            case "Transformación":
                if (!transformado) {
                    System.out.println(nombre + " se transforma en Super Saiyan, aumentando sus estadísticas.");
                    fuerza += 25;
                    velocidad += 10;
                    vida_hp += 50;
                    transformado = true;
                } else {
                    System.out.println(nombre + " ya está transformado.");
                }
                break;

            case "Maxi Curación":
                if (maxCuras > 0) {
                    System.out.println(nombre + " usa Maxi Curación y recupera 60 puntos de vida.");
                    vida_hp += 50;
                    maxCuras--;
                } else {
                    System.out.println("Ya no quedan usos de Maxi Curación.");
                }
                break;

            case "Kamehameha":
                System.out.println(nombre + " lanza un Kamehameha kaioken x3 que causa gran daño.");
                villano.recibirDaño(fuerza * 3);
                habilidadEspecial = "Usado"; // Marcar habilidad como utilizada
                break;

            case "Cargar Ataque":
                System.out.println(nombre + " comienza a cargar un ataque poderoso. Necesitará un turno más.");
                habilidadEspecial = "Cargando"; // Cambiar estado a Cargando
                break;

            case "Cargando":
                System.out.println(nombre + " lanza su ataque cargado con gran potencia, toma el poder de la genkidama.");
                villano.recibirDaño(fuerza * 10);
                habilidadEspecial = "Usado"; // Marcar habilidad como utilizada
                break;

            default:
                System.out.println("Ataque especial no disponible.");
        }
    }

    public void curarse() {
        if (habilidadEspecial.equals("Maxi Curación") && maxCuras > 0) {
            System.out.println(nombre + " usa curación y recupera 10 puntos de vida.");
            vida_hp += 10;
            maxCuras--;
        } else if (habilidadEspecial.equals("Transformación") && transformado) {
            System.out.println(nombre + " recupera su ki y gana 10 puntos de vida.");
            vida_hp += 10;
        } else {
            System.out.println("Curación no disponible.");
        }
    }

    public void restaurarVidaCompleta() {
        this.vida_hp = 100; // Ajusta según el máximo de vida del héroe
        System.out.println(nombre + " ha restaurado toda su vida.");
    }

    public boolean esVivo() {
        return vida_hp > 0;
    }
}
