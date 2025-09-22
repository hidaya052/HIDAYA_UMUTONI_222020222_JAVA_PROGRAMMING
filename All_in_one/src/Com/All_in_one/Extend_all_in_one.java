package Com.All_in_one;

import java.util.Scanner;

public class Extend_all_in_one {


	private static String Totalmarks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("how many courses do you study per semester?");
		int numcourse=sc.nextInt();
		String [] courses= new String[numcourse];
		double marks[]= new double[numcourse];
		double totalmarks=0;
		double average=0;
		double overhundred=0;
		char category='A';
		//Add data into the array
		for (int i=0;i<numcourse;i++) {
			System.out.println("Enter the marks for : "+courses[i]);
		    courses[i]=sc.next();
		//Add marks into the array of marks
		for(int i1=0;i1<numcourse;i1++) {
		    System.out.println("Enter marks for : "+courses[i]);
		    	marks[i]=sc.nextDouble();
		}    	
		//Now we perform the summation
		System.out.println("courses name\tmarks");
		System.out.println("---------------------------------------");
		}
		average=totalmarks/numcourse;
		
		if(average>=80) {
			category='A';
		}else if (average>=70) {
			category='B';
		}else if (average>=60) {
			category='C';
		}else if(average>=50) {
			category='D';
		}else {
			category='f';
		}
		overhundred=(totalmarks*100)/(numcourse*100);
	}
	    System.ouy.println("Total marks: "+Totalmarks+ " which is "+overhundred+"%");
		}
		for(int i1=0;i1<numcourse;i1++) {
			totalmarks+=marks[i];
		    average=totalmarks/numcourse;
			overhundred=("Total marks: "+Totalmarks+ " which is "+overhundred+"%");
		    System.out.println("average: "+average);
		    }
		}
		
		
				
		

	}

}
