import java.util.*;
public class PDIMathTestHarness
{
    public static void main(String[] args)
    {
        System.out.println("approx of e: " + PDIMath.e(100));
        System.out.println("approx of pi: " + PDIMath.pi(50)); 
        System.out.println("min 10, 15: " + PDIMath.min(10,15)); 
        System.out.println("max 10, 15: " + PDIMath.max(10,15)); 
        System.out.println("abs 2.15: " + PDIMath.abs(2.15)); 
        System.out.println("floor -0.8: " + PDIMath.floor(-0.8)); 
        System.out.println("ceil -0.8: " + PDIMath.ceil(-0.8)); 
        System.out.println("pow 3^4: " + PDIMath.pow(3,4)); 
    }
}
