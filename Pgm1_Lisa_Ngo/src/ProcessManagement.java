/*
 Objective: This program assignment is given to the Operating Systems course to allow the students to figure out how a single 
 process (parent process) creates a child process and how they work on Unix/Linux(/Mac OS X/Windows) environment. Additionally, 
 student should combine the code for describing inter-process communication into this assignment. Both parent and child processes  
 interact with each other through shared memory-based communication scheme or message passing scheme.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ProcessManagement {
//final Process childProcess = Runtime.getRuntime().exec("notepad.exe test.txt");
//final Process parentProcess;

	public static void run(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			java.lang.Process parent = Runtime.getRuntime().exec("tasklist"); //some sort of command
			System.out.println("Creating Child Process.");
			final InputStream is = parent.getInputStream();
			//is this the parent process running the child process now?
			Thread t = new Thread(new Runnable() {
				public void run() {
					InputStreamReader isr = new InputStreamReader(is);
					int ch;
					try{
						while ((ch = isr.read()) != -1){
							System.out.print((char) ch);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		t.start();
		parent.waitFor();
		t.join();
		System.out.println("Completed Child Process.");
		}
		catch (Exception e){
			System.out.println("Error was found:");
			e.printStackTrace();
		}
	}

}
