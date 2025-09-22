package Com.All_in_one;

public class All_in_one {

	public static void main(String[] args) {
		String [] courses= {"programming with java","Research methodology"};
		double marks[]= {87.5,605};
		double totalmarks=0;
		double average=0;
		double overhundred=0;
		//System.out.println("size: "+marks.length-1);
		System.out.println("courses \t\t marks");
		for(int i=0; i<=marks.length-1;i++) {
		    totalmarks+=marks[i];
			System.out.println("----------------------");
		    int i1 = 0;
			System.out.println("|"+courses[i1]+"|\t"+marks[i1]);
		}
		System.out.println("------------------------------------------");
		average=totalmarks/marks.length;
		overhundred = (totalmarks*10)/200;
		System.out.println("total marks: "+totalmarks+" which is "+overhundred+"%");
		System.out.println("average marks: "+average);
			
		    
		    
		    
	    }
	
	
}	
