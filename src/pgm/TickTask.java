package src.pgm;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TickTask extends TimerTask {
	private final int DELAY = 800;
	private int frequency;
	private File file;
	
	public void setFile(String filePathName) {
		file = new File(filePathName);
	}
	
	public void setFrequency(int bpm) {
		//set the tick frequency in milliseconds; 60000 / BPM = frequency
		frequency = 60000 / bpm;
	}
	
	public File getFile() {
		return file;
	}
	
	public int getFrequency() {
		//return the tick frequency in milliseconds; 1000 msecs = 1 sec
		return frequency;
	}
	
	public int getDelay() {
		return DELAY;
	}

	public void playTick(String filePathName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setFile(filePathName);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	
	public void run() {
		System.out.println("Tick");
		//play a metrognome tick using Clip
		try {
			playTick("Metronome\\src\\NewTickSoundEffect.wav");
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//class constructor
	TickTask(int bpm) {
		setFrequency(bpm);
	}
}
