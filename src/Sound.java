import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundurl[] = new URL[30];


    public Sound(){
        soundurl[0] = getClass().getResource("/sound/gameover.wav");
        soundurl[1] = getClass().getResource("/sound/fuelCollect.wav");
        soundurl[2] = getClass().getResource("/sound/crash.wav");
        soundurl[3] = getClass().getResource("/sound/win.wav");
    }
    public void setFile(int i){
     try {
         AudioInputStream ais = AudioSystem.getAudioInputStream(soundurl[i]);
         clip = AudioSystem.getClip();
         clip.open(ais);


     } catch (Exception e) {

     }
    }
    public void play(){
    clip.start();
    }
    public void loop(){
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
