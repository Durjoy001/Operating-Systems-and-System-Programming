
package javaapplication1;
class hi extends Thread
{
    @Override
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("hi");
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e){}
        }
    }
}
class hello extends Thread
{
    @Override
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("hello");
            try{
                Thread.sleep(100);
            }
            catch(Exception e){}
        }
    }
}

public class JavaApplication1 {
    public static void main(String[] args) {
     
        hi obj1 = new hi();
        hello obj2 = new hello();
        obj1.start();
        obj2.start();
    }
    
}
