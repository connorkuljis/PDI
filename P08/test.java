import java.util.*;
public class test
{
    public static void main(String[] args)
    {
        Student st1 = new Student("Joe", 19459138, 99.9);
        System.out.println(st1.toString()); 

        double[] myArray = new double[] {75.0, 25.5, 30.0};
        System.out.println(PDIMath.average(myArray));
    }
}
