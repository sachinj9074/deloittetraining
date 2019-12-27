import java.util.*;

public class grade {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter marks");
	int m=in.nextInt();
	
	if(m>=75)
	{
		System.out.println("Distinction");
	}
	else if(m>=70 && m<75)
	{
		System.out.println("First class");
	}
	else if(m>=60 && m<70)
	{
		System.out.println("Second class");
	}
	else if(m>=50 && m<60)
	{
		System.out.println("Third class");
	}
	else
	{
		System.out.println("Fail");
	}
	
	in.close();
}
}
