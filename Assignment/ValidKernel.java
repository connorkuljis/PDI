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

        double avg = (double) total / (double) numElements; 
        avg *= smValue;
        int ceilAvg = PDIMath.ceil(avg);
        return ceilAvg;
    }

    public static int[][] smoothing(int[][] image)
    {
        int[][] smoothingKernel = null;
        int surfaceSize; // this must be odd, an integer is odd if the value % 2 != 0
        int x_target;
        int y_target;
        double smFactor;
        int surfaceRange;
        String err = "";
        boolean isValid;

        do
        {
            System.out.print(err); 
            do
            {
                surfaceSize = UserInterface.userInput("Please enter a smoothing surface (must be odd): ", 1, image.length);
            }while(surfaceSize % 2 == 0); // is not an odd integer

            smoothingKernel = new int[surfaceSize][surfaceSize];

            surfaceRange = (surfaceSize - 1) / 2; 

            x_target = UserInterface.userInput("Please enter x-coordinate of pixel to smooth (x): ", 1, image.length);
            y_target = UserInterface.userInput("Please enter y-coordinate of pixel to smooth (y): ", 1, image.length);

            isValid = checkBounds(image, smoothingKernel, x_target, y_target, surfaceRange); // returns true if smoothingKernel is within image

            err = "\nError: the smoothing surface goes out of bounds of the array.\nPlease enter new values:\n";

        }while(!isValid);

        smFactor = UserInterface.userInput("Please enter a smoothness factor: ", 0.0, 1.0);

        // accounting for 0 index not included for user
        x_target--;
        y_target--;

        int x_diff = x_target - surfaceRange;
        int y_diff = y_target - surfaceRange;
        for (int i = (x_target - surfaceRange); i <= (x_target + surfaceRange); i++)
        {
            System.out.println(""); 
            for (int j = (y_target - surfaceRange); j <= (y_target + surfaceRange); j++)
            {
                // System.out.println("(" + i + ", " + j + ")"); 
                System.out.println("(" + (i + x_diff) + ", " + (j + y_diff) + ")"); 

                 
                // smoothingKernel[i - x_target + 1][j - y_target + 1] = image[i][j];
            }
        }

        // #### APPENDING AVERAGES
        int average = avgArray(smoothingKernel, smFactor);

        for (int i = (x_target - surfaceRange); i <= (x_target + surfaceRange); i++)
        {
            for (int j = (y_target - surfaceRange); j <= (y_target + surfaceRange); j++)
            {
                // swapping [x][y] to [y][x] = [j][i]
                image[j][i] = average;
            }
        }
        return image;
    }

    public static boolean checkBounds(int[][] image, int[][] surface, int x, int y, int surfaceRange) // do i need surface matrix?
    {
        boolean isValid = true;
        if((x + surfaceRange > image.length) || (y + surfaceRange > image.length) || (x - surfaceRange < 0) || (y - surfaceRange < 0))
        {
            isValid = false;
        }
        return isValid;
    }
}
