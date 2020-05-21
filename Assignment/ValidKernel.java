// ValidKernel
import java.io.*;

public class ValidKernel
{
    public static void main(String[] args)
    {
        validKernel();
    }

    /* Name: validKernel
     * IMPORTS: none
     * EXPORTS: kernel (2D ARRAY OF Integer) --it has been validated
     * Purpose: constructs a 2D array of integers from a csvfile (String)
     * Assertion: a kernel is valid if the file it is reading from exists, each element is an integer and the size is square
     * Created: 20 May 2020 */
    public static int[][] validKernel()
    {
        int[][] kernel = null;
        boolean valid = false;
        while(!valid)
        {
            try
            {
                String kernelFile = UserInterface.userInput("Please enter the filename of the kernel: ");
                kernel = FileIO.readFile(kernelFile); // this is where the exception is thrown
                valid = true;
            }
            catch(IllegalArgumentException e)
            {
                UserInterface.displayError(e.getMessage());
            }
            catch(FileNotFoundException e)
            {
                UserInterface.displayError(e.getMessage());
            }
        }
        UserInterface.printTwoDArray(kernel);
        return kernel;
    }

    /* Name: avgArray
     * IMPORTS: image (2DARRAY OF Integers)
     * EXPORTS: avg (integer) - average of all integers in the array
     * Purpose: constructs a 2D array of integers from a csvfile (String)
     * Assertion: a kernel is valid if the file it is reading from exists, each element is an integer and the size is square
     * Created: 20 May 2020 */
    public static int avgArray(int[][] image, double smValue)
    {
        int total = 0;
        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j < image[0].length; j++)
            {
                total += image[i][j];
            }
        }

        int numRows = image.length;
        int numCols = image[0].length;
        int numElements = numRows * numCols; // because it will be square
        System.out.println("numRows " + numRows); 
        System.out.println("numCols " + numCols); 

        double avg = (double) total / (double) numElements; 
        System.out.println("raw avg: " + avg); 
        avg *= smValue;
        int ceilAvg = PDIMath.ceil(avg);
        System.out.println(avg + ", " + ceilAvg); 

        return ceilAvg;
    }

    public static int[][] getSmoothingKernel(int[][] image)
    {
        int surfaceSize = 3; // this must be odd, an integer is odd if the value % 2 != 0
        int[][] smoothingKernel = new int[surfaceSize][surfaceSize];

        int x_target = 3;
        int y_target = 3;

        int targetValue = image[x_target][y_target];
        System.out.println("target value: " + targetValue); 

        int surfaceRange = (surfaceSize - 1) / 2; // 2

        for (int i = (x_target - surfaceRange); i <= (x_target + surfaceRange); i++)
        {
            // System.out.println(""); 
            for (int j = (y_target - surfaceRange); j <= (y_target + surfaceRange); j++)
            {
                // System.out.println("(" + i + ", " + j + ")"); 
                // System.out.println("(" + (i - surfaceRange - 1) + ", " + (j - surfaceRange - 1) + ")"); 
                smoothingKernel[i - surfaceRange - 1][j - surfaceRange - 1] = image[i][j];
            }
        }
        return smoothingKernel;
    }



}
