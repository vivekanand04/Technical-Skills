package VivekPackage;
import java.util.Scanner;
public class Lec06_Marks_percentage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int sum=0;
for(int i=0;i<5;i++) {
	
	System.out.println("enter the "+ (i+1)+"th subject marks");
	int val=sc.nextInt();
	if(val>100) {
		System.out.println("marks cant be greater than 100");
		i--;
		continue;
	}
	sum+=val;
}

float perc=((float)sum*100)/500;
System.out.println("The percentage marks are "+perc+"%");


	}

}
