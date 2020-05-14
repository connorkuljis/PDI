import java.util.*;
public class FileIOTestHarness
{
    public static void main(String[] args)
    {
        int[][] myArray = FileIO.readFile("HorizontalKernel.csv");
        for(int i = 0; i < myArray.length; i++)
        {
            for(int j = 0; j < myArray[0].length; j++)
            {
                // System.out.print(myArray[i][j] + " "); 
            }
            // System.out.println(" "); 
        }

        FileIO.writeFile("test.csv", myArray);
    }
}
