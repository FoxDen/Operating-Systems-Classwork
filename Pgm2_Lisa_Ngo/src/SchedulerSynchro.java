import java.util.Timer;
import java.util.Scanner;

//Will be using RR algorithm.
public class SchedulerSynchro {
	static int numberOfProcesses;
	static Scanner aScan;
	private static int timeQuantum;
	private final int totalTime = 5000;
	Process[] p;
	
	private static int setTimeQuantum(){
		return 0;
	}
	
	private static void runTime(){
		
	}
	
	private static void output(int bNum, int bTime){
		System.out.format("Process %d:    Burst Time:%d", bNum, bTime);
	}
	
	private static void ganttChart(){
		
	}
	
	
	//maybe prompt the input of a file?
	public static void main(String[] args){
		int counter = 0;
		aScan = new Scanner(System.in);
		System.out.println("Number of processes:");
		numberOfProcesses = aScan.nextInt();
		//p = new Array[numberOfProcesses];
		
		while(numberOfProcesses>counter){
			System.out.println("What is the burst time of process "+ Integer.toString(counter+1)+"?");
		//	p[counter] = new Process(aScan.nextInt());
			counter++;
		}
		
		System.out.println("---------------Round Robin Example---------------");
		System.out.println("---------------End of Round Robin Example---------------");
	}

}

class Process {
	int burstTime;
	public Process(int i){
		burstTime = i;
	}
}