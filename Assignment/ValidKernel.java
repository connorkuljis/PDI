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
        System.out.println(ceilAvg);
        return ceilAvg;
    }


    /* Name: smoothing
     * IMPORTS: image (2DARRAY OF Integers)
     * EXPORTS: image (2D ARRAY OF INTEGERS) - that has been smoothed around a given pixel
     * Purpose: constructs a 2D array of integers from a csvfile (String)
     * Assertion: a kernel is valid if the file it is reading from exists, each element is an integer and the size is square
     * Created: 20 May 2020 */
    public static int[][] smoothing(int[][] image)
    {
        int[][] smoothingKernel = null;
        int surfaceSize, surfaceRange, x_target, y_target; 
        double smFactor;
        boolean valid  = false;

        do
        {
            do
            {
                surfaceSize = UserInterface.userInput("Please enter a smoothing surface (must be odd): ", 1, image.length);

            }while(surfaceSize % 2 == 0); // is not an odd integer

            surfaceRange = (surfaceSize - 1) / 2; 

            x_target = UserInterface.userInput("Please enter x-coordinate of pixel to smooth (x): ", 1, image.length);
            y_target = UserInterface.userInput("Please enter y-coordinate of pixel to smooth (y): ", 1, image.length);

            smFactor = UserInterface.userInput("Please enter a smoothness factor: ", 0.0, 1.0);

            smoothingKernel = new int[surfaceSize][surfaceSize];

            // accounting for 0 index not included for user
            x_target--;
            y_target--;

            try
            {
                int n = -1;        // creating index which will allow me to store values starting from 0,0
                int m;             // because the for loop does not start at 0 and varies depending on starting location
                for (int i = (x_target - surfaceRange); i <= (x_target + surfaceRange); i++)
                {
                    n++;
                    m = -1; // resetting value
                    for (int j = (y_target - surfaceRange); j <= (y_target + surfaceRange); j++)
                    {
                        m++;
                        smoothingKernel[n][m] = image[i][j];        // exceptions thrown here
                        // System.out.println("(" + i + ", " + j + ")"); 
                    }
                }

                int average = avgArray(smoothingKernel, smFactor);
                for (int i = (x_target - surfaceRange); i <= (x_target + surfaceRange); i++)
                {
                    for (int j = (y_target - surfaceRange); j <= (y_target + surfaceRange); j++)
                    {
                        // swapping [x][y] to [y][x] = [j][i]
                        image[j][i] = average;                      // exceptions could be thrown here as well
                        valid = true;
                    }
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                UserInterface.displayError("Smoothing surface goes out of bounds of the image array.");
            }
        }while(!valid);
        return image;
    }
}
