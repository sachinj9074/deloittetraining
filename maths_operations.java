public class maths_operations {
 	public int add(int a,int b)
	{
		return(a+b);
	}
	
	public int sub(int a,int b)
	{
		return(a-b);
	}
	
	public int mul(int a,int b)
	{
		return(a*b);
	}
	
	public float div(float a,float b)
	{  float c=(a/b);
		return(c);
		
	}
	
	public static void main(String[] args) 
	{
	maths_operations c1=new maths_operations();
	
	int r1=c1.add(50,7);
	int r2=c1.sub(50,7);
	int r3=c1.mul(50,7);
	float r4=c1.div(50,7);
	
	System.out.println("a+b="+r1);
	System.out.println("a-b="+r2);
	System.out.println("a*b="+r3);
	System.out.println("a/b="+r4);
	
	
    }
}



