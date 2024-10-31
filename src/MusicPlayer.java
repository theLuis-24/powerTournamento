import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private static Clip clip; // Variable a nivel de clase para controlar el audio

    public static void playSound(String filePath) {
        new Thread(() -> {
            try {
                // Cargar el archivo de audio
                File audioFile = new File(filePath);
                if (!audioFile.exists()) {
                    System.out.println("Archivo de audio no encontrado: " + filePath);
                    return;
                }

                // Detener cualquier audio que esté sonando
                stopMusic();

                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

                // Configurar el reproductor
                clip = AudioSystem.getClip();
                clip.open(audioStream);

                // Iniciar reproducción
                clip.start();
                clip.loop(0); // Reproducir una vez

                // Esperar hasta que el clip termine
                Thread.sleep(clip.getMicrosecondLength() / 1000);

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();    // Detener la reproducción
            clip.close();   // Liberar recursos
        }
    }
}