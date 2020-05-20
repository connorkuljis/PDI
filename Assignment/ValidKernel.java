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
}
