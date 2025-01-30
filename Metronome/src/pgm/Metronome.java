package src.pgm;
import java.util.Timer;
import java.util.Scanner;

public class Metronome {
	static Timer metroTimer;
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Select the desired bpm, maximum of 350: ");
		int response = scnr.nextInt();
		
		TickTask task = new TickTask(response);
		
		metroTimer = new Timer();
		metroTimer.schedule(task, task.getDelay(), task.getFrequency());
		scnr.close();
	}
}
