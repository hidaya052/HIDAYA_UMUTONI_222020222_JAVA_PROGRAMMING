package Com.clearn;

import java.util.Scanner;

public class Allinone {


	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	//step 1: Get number of student
	System.out.println("how many are you in your class?");
	int numstd= sc.nextInt();
	sc.nextLine();//Get names of student
	String [] studentsnames=new String[numstd];
	for(int i=0; i<numstd;i++)  {
		System.out.println("Enter the name of student "+(i+1);
		studentsnames[i]=sc.nextLine();
	}
	//step 2: get courses
	System.out.println("\nhow many courses do you study");
	int numcaourse=sc.nextInt();
	sc.nextLine();
	//populate the array with the name of courses;
	int numcourse;
	String [] courses=new String [numcourse];
	for(int i=0;i<numcourse;i++) {
		System.out.println("Enter the name of course");
		courses[i]=sc.nextLine();
		
		}
        //step 3: for each student, enter the marks and calculate 
	    double [] marks=new double [numcourse];
	    System.out.println("========REPORT CARD =======");
	    for(String name:studentsnames) {
	    	System.out.println("\nstudent: "+name);
	    	System.out.println("-----------------------");
	    	System.out.println("course\t\tmarks");
	    	double totalmarks =0;
	    	for(int i=0;i<numcourse;i++); int i;
			{
	    		System.out.println("Enter the marks in "+courses[i]+":");
	    		marks[i]=sc.nextDouble();
	    		totalmarks+=marks[i];
	    	}
	    	//display
	    	for(int i=0;i<numcourse;i++);
	    	    System.out.println(courses[i]+"\t\t"+marks[i]);
	    }
	    int numcourses;
		int totalmarks;
		double average=totalmarks/numcourses;
		char category='A';
		if(average>=80) {
			char category = 'A';
		}else if(average>=70) {
			='B';
		}else if(average>=60){
			category='C';
		}else if(average>=50){
			category='D';
		}else {
			category='f';
		}
		double percentage = (totalmarks*100)/(numcourse*100);
		System.out,prinrln("-----------------------------------");
		System.out.println("total marks: '+ total marks+"(" +percentage");
		System.out,println("average: "+ average);
		System.out.println("grade: "+ category):
	}
	sc.close();
		
			
	
	    	
	    	
	    
	

	}

}
