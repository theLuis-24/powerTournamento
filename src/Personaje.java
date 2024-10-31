
public abstract class Personaje {
    protected String nombre;
    protected int vida;
    protected int fuerza;
    protected int velocidad;
    protected int cooldownEspecial;

    public Personaje(String nombre, int vida, int fuerza, int velocidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.cooldownEspecial = 0;


        
    }

    public boolean esVivo() {
        return vida > 0;
    }

    public void recibirDanio(int danio) {
        vida -= danio;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void reducirCooldown() {
        if (cooldownEspecial > 0) {
            cooldownEspecial--;
        }
    }

    public abstract void atacar(Personaje objetivo);
    public abstract void ataqueEspecial(Personaje objetivo);
}
