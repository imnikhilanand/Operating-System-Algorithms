import java.lang.*;
import java.util.*;
import java.io.*;

class sortbyserial implements Comparator<process>{
public int compare(process p1, process p2){
return p2.serial - p1.serial;
}
}

class priority_scheduling{
public static void main(String[] args){

ArrayList<process> ar = new ArrayList<process>();

ar.add(new process(2,10));
ar.add(new process(0,5));
ar.add(new process(1,8));

Collections.sort(ar, new sortbyserial());

int turn_around = 0,turn_around_f = 0;
int wait = 0; 
float wait_f = 0;		
System.out.println("S NO."+"\t"+"Burst Time"+"\t"+"Waiting Time"+"\t"+"Turn Around Time");		
		
for(int i=0; i<ar.size(); i++){			
	turn_around = ar.get(i).show_burst() + wait;			
	System.out.println(ar.get(i).show_serial()+"\t"+ar.get(i).show_burst()+"\t"+wait+"\t"+turn_around);
	wait_f = wait_f + wait;
	wait = wait + ar.get(i).show_burst();
	turn_around_f = turn_around_f + turn_around; 			
}

System.out.println("Average Turn Around Time "+turn_around_f/ar.size());
System.out.println("Average Waitng Time "+wait_f/ar.size());	

}
}
