public class TablosAF extends Villano {
    private boolean ataqueFinalUsado;

    public TablosAF() {
        super("Tablos AF", 30, 18, 150, "Cañón de Esencia"); // Especificaciones del villano TablosAF
        this.ataqueFinalUsado = false;
    }

    public String getNombre() {
        return nombre;
    }

    // Ataque básico
    @Override
    public void atacar(Heroe heroe) {
        System.out.println(nombre + " ataca a " + heroe.nombre + " y causa " + fuerza + " de daño.");
        heroe.vida_hp -= fuerza;
    }

    // Ataque fuerte
    @Override
    public void ataqueFuerte(Heroe heroe) {
        int daño = fuerza + 5;
        System.out.println(nombre + " usa Devora Tripas y causa " + daño + " de daño.");
        heroe.vida_hp -= daño;
    }

    // Ataque especial personalizado para TablosAF
    public void ataqueCañonEsencia(Heroe heroe) {
        int daño = fuerza + 10;
        System.out.println(nombre + " lanza su Cañón de Esencia y causa " + daño + " de daño.");
        heroe.vida_hp -= daño;
    }

    // Ataque final "A Callar Nenaza", solo se puede usar una vez
    public void ataqueACallarNenaza(Heroe heroe) {
        if (!ataqueFinalUsado) {
            int daño = fuerza + 25;
            System.out.println(nombre + " usa su ataque definitivo ¡A Callar Nenaza! causando " + daño + " de daño.");
            heroe.vida_hp -= daño;
            ataqueFinalUsado = true;  // Marca el ataque final como usado
        } else {
            System.out.println(nombre + " ya ha usado su ataque definitivo y no puede usarlo de nuevo.");
        }
    }

    // Método para seleccionar el ataque en función de la situación
    public void seleccionarAtaque(Heroe heroe) {
        if (!ataqueFinalUsado && heroe.vida_hp < 50) {
            ataqueACallarNenaza(heroe);  // Usar ataque final si la vida del héroe es baja
        } else if (cooldownEspecial == 0) {
            ataqueCañonEsencia(heroe);   // Usar Cañón de Esencia si el cooldown permite
            cooldownEspecial = 3;        // Asigna el cooldown al ataque especial
        } else {
            ataqueFuerte(heroe);         // Alterna entre ataque fuerte y básico
        }
    }

    // Método para reducir el cooldown después de cada turno
    @Override
    public void reducirCooldown() {
        if (cooldownEspecial > 0) cooldownEspecial--;
    }
}
