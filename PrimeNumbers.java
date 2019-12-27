import java.util.*;

public class PrimeNumbers {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the lower limit");
		int number1=in.nextInt();
		
		System.out.println("Enter the upper limit");
		int number2=in.nextInt();
		
	    int sum=0;
		while(number1<=number2)
		{
			boolean flag=false;
			
			for(int i=2;i<=number1/2;i++)
			{
				if(number1%i==0)
				{
		           flag=true;
		           break;
				}
			}
			
			if(flag==false)
			{
				sum=sum+number1;
			}
			
			number1++;
		}
		
		System.out.println("Sum="+sum);
		
		in.close();
		}
		
	}


