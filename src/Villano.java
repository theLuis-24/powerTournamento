class Villano {
    String nombre;
    int fuerza;
    int velocidad;
    int vida_hp;
    String ataqueEspecial;
    int cooldownEspecial = 0;

    public Villano(String nombre, int fuerza, int velocidad, int vida_hp, String ataqueEspecial) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
        this.ataqueEspecial = ataqueEspecial;
    }

    public void atacar(Heroe heroe) {
        System.out.println(nombre + " ataca a " + heroe.nombre + " y causa " + fuerza + " de daño.");
        heroe.vida_hp -= fuerza;
    }

    public void ataqueFuerte(Heroe heroe) {
        int danio = fuerza + 10;
        System.out.println(nombre + " usa un ataque fuerte y causa " + danio + " de daño.");
        heroe.vida_hp -= danio;
    }

    public void ataqueEspecial(Heroe heroe) {
        int danio = fuerza + 20;
        System.out.println(nombre + " usa su ataque especial y causa " + danio + " de daño.");
        heroe.vida_hp -= danio;
        cooldownEspecial = 2;
    }

    public void reducirCooldown() {
        if (cooldownEspecial > 0) cooldownEspecial--;
    }

    public void recibirDanio(int danio) {
        vida_hp -= danio;
        System.out.println(nombre + " recibe " + danio + " de daño. Vida restante: " + vida_hp);
    }

    public boolean esVivo() {
        return vida_hp > 0;
    }
}
