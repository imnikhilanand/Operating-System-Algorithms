import java.lang.*;
import java.io.*;

class process{
	int serial;
	int burst;
	process(int serial,int burst){
	this.serial = serial;
	this.burst = burst;
	}
	int show_serial(){
	return serial; 
	}
	int show_burst(){
	return burst;	
	}
}

class fcfs{
	public static void main(String[] args){
		process[] p = new process[3];
		p[0] = new process(1,10);
		p[1] = new process(2,5);
		p[2] = new process(3,8);
		int turn_around = 0,turn_around_f = 0;
		int wait = 0; 
		float wait_f = 0;		
		System.out.println("S NO."+"\t"+"Burst Time"+"\t"+"Waiting Time"+"\t"+"Turn Around Time");		
		for(int i=0; i<p.length; i++){			
			turn_around = p[i].show_burst() + wait;			
			System.out.println(p[i].show_serial()+"\t"+p[i].show_burst()+"\t"+wait+"\t"+turn_around);
			wait_f = wait_f + wait;
			wait = wait + p[i].show_burst();
			turn_around_f = turn_around_f + turn_around; 			
		}
		System.out.println("Average Turn Around Time "+turn_around_f/p.length);
		System.out.println("Average Waitng Time "+wait_f/p.length);			
	}
}
