import java.util.*;

public class largest {
public int largestNumber(int a ,int b, int c)
	   {
		
		if(a>b && a>c)
		{
			return a;
		}
		else if(b>c)
		{
			return b;
		}
		else
		{
			return c;
		}
	}


public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	
	int x=in.nextInt();
	int y=in.nextInt();
	int z=in.nextInt();
	
	largest c1=new largest();
	
	int ret=c1.largestNumber(x,y,z);
	
	System.out.println("Largest Number is="+ret);

	in.close();
}
}


