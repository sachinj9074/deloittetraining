import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner in=new Scanner(System.in);
		
		int p,d,m,r;
		double v;
		
		System.out.println("Enter the principle amount");
		p=in.nextInt();
		
		System.out.println("Enter the down payment");
		d=in.nextInt();
		
		System.out.println("Enter the years");
		m=in.nextInt();
		
		System.out.println("Enter the rate");
		r=in.nextInt();
		
		EMIcal e=new EMIcal(p,d,m,r);
		v=e.EMI();
		
		System.out.println("EMI="+v+" for "+(m*12)+" months");
		
	}
}

class EMIcal
{
	private int principle;
	private int DP;
	private int months;
	private final double rate;
	
	
	public EMIcal(int principle,int DP,int months,double rate)
	{
		this.principle=principle;
		this.rate=rate;
		this.DP=DP;
		this.months=months;
	}
	
	public double EMI()
	{
		double interest=((principle-DP)*months*rate)/100;
		
		double EMI_value=(principle-DP)/(months*12)+interest/(months*12);
		
		return EMI_value;
	}
	
	
}