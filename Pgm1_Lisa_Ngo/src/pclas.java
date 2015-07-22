/*
 *  This program assignment is provided to let the students know how to handle threads and enhance system availability on a multiprocessor or multicore environment. A single process is supposed to create multiple threads with runner functions which include individual threads roles. 
 *  Threads can be created by using Pthreads API, Win32 API, or Java API. on Unix/Linux or Windows platform environment.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

//Will be using STF algorithm.
public class pclas {
	static int numberOfProcesses;
	static Scanner aScan;
	static Date dTime;
	static Process[] p;
	
	private static void output(Process bNum){
		System.out.format("Process:%s    Burst Time:%d    Start Time:%d", bNum.returnNum(), bNum.returnBurstTime(), bNum.returnStartTime());
		System.out.println("");
	}
	
	private static void bubbleSort(Process[] p){
		Process temp;
        for(int i=0; i < p.length-1; i++){
 
            for(int j=1; j < p.length-i; j++){
                if(p[j-1].returnBurstTime() > p[j].returnBurstTime()){
                	temp = p[j-1];
                	p[j-1] = p[j];
                	p[j] = temp;
                }
            }
        }
	}
	
	private static void createChart(){		
		int k = 0;
		int i = 0;
		System.out.println("This is the Gantt Chart.");
		System.out.println("-------------------------------------------");

		
		bubbleSort(p);

		while(i<p.length){
			String space = "";
			while(k<p[i].returnBurstTime()){
				space+="*";
				k++;
			}
			k=0;
			System.out.print("| Slice "+ p[i].returnNum() + space + "|");
			i++;

		}
			
	}
	
	public static void main(String[] args){
		int counter = 0;
		aScan = new Scanner(System.in);
		dTime = new Date();
		
		System.out.println("---------------Shortest Time First Example---------------");
		System.out.println("Number of files to determine the character length of:");
		numberOfProcesses = aScan.nextInt();
		p = new Process[numberOfProcesses];
			
		while(counter<numberOfProcesses){
			long timeStart;
			
			System.out.println("What is file #"+ Integer.toString(counter+1)+"? Please input the full path.");
			
			try {
				timeStart = System.currentTimeMillis();
				p[counter] = new Process(Integer.toString(counter+1));
				p[counter].run(aScan.next());
				System.out.println();
				System.out.println();
				p[counter].setStartTime((int)timeStart/1000);
			} catch (Exception e){
				System.out.println("Error occurred");
				e.printStackTrace();
			}

			counter++;
		}

		
		for(int k=0;k<numberOfProcesses;k++){
			output(p[k]);
		}
		System.out.println();
		System.out.println();
		createChart();
		System.out.println();
		System.out.println("---------------End of Shortest Time First Example---------------");
	}

}

class Process extends Thread
{
	private int burstTime=0;
	private int startTime;
	private String processNum = "";

	public Process(String process){
		processNum = process;
	}
	
	public String returnNum(){
		return processNum;
	}

	public int returnBurstTime(){
		return burstTime;
	}

	public int returnStartTime(){
		return startTime;
	}
	
	public void setStartTime(int time){
		startTime = time;
	}
	
	public void run(String s) throws IOException{
		BufferedReader read = new BufferedReader(new FileReader(s));
		startTime = 0;
		while(read.readLine()!=null){
			System.out.print("Line read. ");
			burstTime++;
		}
		System.out.println();
		read.close();
	
	}
}

	