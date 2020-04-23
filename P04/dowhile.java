import java.util.*;
public class dowhile
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String prompt, errorMsg, out;
        double value;
  
        prompt = "Please enter a value: ";
        errorMsg = "Error. ";
        out = prompt;
        do 
        {
            System.out.println(out); 
            value = in.nextDouble();
            out = errorMsg + prompt;    // out is assigned a new string 

        } while((value > 10) || (value < 1));
    }
}
