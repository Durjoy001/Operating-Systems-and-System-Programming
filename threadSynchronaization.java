
package javaapplication2;
class  counter{
    int count;
    public synchronized void increement()
    {
        count = count+1;
    }
}
public class JavaApplication2 {

 
    public static void main(String[] args) throws Exception
    {
        
        counter c = new counter();
        
       Thread t1 = new Thread(new Runnable(){
            public void run()
            {
                for(int i=0;i<1000;i++)
                {
                    c.increement();
                }
            }
        });
       Thread t2 = new Thread(new Runnable()
       {
           public void run()
           {
               for(int i=0;i<1000;i++)
               {
                   c.increement();
               }
           }
       });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count"+c.count);
        
       
    }
    
}
