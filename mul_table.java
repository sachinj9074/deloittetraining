import java.util.*;

public class mul_table {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	
	System.out.println("Enter the number you want a table for");
	int number=in.nextInt();
	
	for(int i=0;i<10;i++)
	{
		System.out.println( number+"x"+(i+1)+"="+(number*(i+1)));
	}
	in.close();
}
}
