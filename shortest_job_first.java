import java.io.*;
import java.lang.*;
import java.util.*;

class sortbyburst implements Comparator<process>{
public int compare(process p1,process p2){
return p1.burst - p2.burst;
}
}

class shortest_job_first{
public static void main(String[] args){

ArrayList<process> ar = new ArrayList<process>();

ar.add(new process(1,6));
ar.add(new process(2,8));
ar.add(new process(3,7));
ar.add(new process(4,3));


Collections.sort(ar, new sortbyburst());

/*for(process proc : ar){
System.out.println(proc.show_burst());
}*/

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
