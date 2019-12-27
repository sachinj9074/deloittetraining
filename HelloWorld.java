

public class HelloWorld
{
public static void main(String[] args) {
  Greeting g=new Greeting();
  g.greet();  
  //System.out.println(g);
}
}

class Greeting{
    public void greet(){
        System.out.println("Hello world from java");
    }
}