import java.util.*;
public class Reader
{
    public static void main(String[] args) throws Exception
    {
        java.io.File file = new java.io.File("students.csv");
        
        Scanner input = new Scanner(file);

        while(input.hasNext())
        {
            String name = input.next();
            String studentID = input.next();
            String mark = input.next();
            System.out.println(name + ", " + studentID + ", " + mark); 
        }
        input.close();
    }
}
