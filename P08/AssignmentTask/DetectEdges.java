// note from last night: you need to refactor to accept USER INPUT and do some validation and error handling eg only print sign off message if the convolute has not failed
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class DetectEdges
{
    public static void main(String[] args)
    {
        detectEdges();
    }
    public static void detectEdges()
    {
        int[][] kernel = null;
        boolean valid = false;
        while(!valid)
        {
            try
            {
                String kernelFile = "Supplementary_Files/" + UserInterface.userInput("Please enter the filename of the kernel: ");
                kernel = FileIO.readFile(kernelFile); // this is where the exception is thrown
                valid = true;
            }
            catch(IOException e)
            {
                UserInterface.displayError(e.getMessage());
            }
        }
        // UserInterface.printTwoDArray(FileIO.readFile(kernelFile));
        int[][] image = null;
        String imageFilename = "Supplementary_Files/";

        boolean close = false;
        boolean done = false;
        do
        {
            char ch = UserInterface.userInput("Would you like to perform on (C)SV or (P)NG: ", 'A', 'z');
            char choice = Character.toUpperCase(ch);
            switch(choice)
            {
                // READ CSV
                case 'C':
                    done = false;
                    while(!done)
                    {
                        try
                        {
                            imageFilename += UserInterface.userInput("Please enter the filename of the CSV: ");
                            image = FileIO.readFile(imageFilename);
                            done = true;
                        }
                        catch(IOException e)
                        {
                            UserInterface.displayError(e.getMessage());
                        }
                    }
                    close = true;
                    break;

                // READ PNG
                case 'P':
                    done = false;
                    while(!done)
                    {
                        try
                        {
                            imageFilename += UserInterface.userInput("Please enter the filename of the PNG: ");
                            image = FileIO.readPNG(imageFilename);
                            done = true;
                        }
                        catch(IOException e)
                        {
                            UserInterface.displayError(e.getMessage());
                        }
                    } 
                    close = true;
                    break;

                // DEFAULT
                default:
                    System.out.println("Please select a valid option: "); 
                    break;
            }
        } while(!close);

        // convoluting the array
        int[][] resultArray = createResultArray(image, kernel);
        int[][] tempArray = calcResult(resultArray, image, kernel);

        // appending to filename
        String newImageFilename = imageFilename + "_Converted.png";

        // confirmation message, error handing is done inside the method writeFile
        FileIO.writePNG(newImageFilename, tempArray);
        System.out.println("File (" + newImageFilename + ") written. Goodbye!"); 
    }

    public static int[][] createResultArray(int[][] convolute, int[][] kernel)
    {
        int n, m, k;
        int[][] resultArray;

        // getting dimentions of the convolute array
        n = convolute.length;        // rows
        m = convolute[0].length;     // columns

        k = kernel.length;    // getting dimensions of kernel assuming it is k by k

        // producing a valid result array
        resultArray = new int[(n - k + 1)][(m - k + 1)];
        
        return resultArray;
    }

    /*
     * Name: calcResult
     * Date: 23/04/2020
     * Import: resultARray (2D array of integers), convolute (2D array of integers), kernel (2D array of integers)
     * Export: resultArray (2D array of integers)
     * Purpose: returns a populated sized result array
     */
    public static int[][] calcResult(int[][] resultArray, int[][] convolute, int[][] kernel)
    {
        // simply loops through each position in the result array
        for(int i = 0; i < resultArray.length; i++)
        {
            for(int j = 0; j < resultArray[0].length; j++)
            {
                resultArray[i][j] = calcConvolute(i, j, convolute, kernel); 
            }
        }
        return resultArray;
    }

    /*
     * Name: calcConvolute
     * Date: 23/04/2020
     * Import: x (integer), y (integer), convolute (2D array of integers), kernel (2D array of integers)
     * Export: result (integer)
     * Purpose: this submodule performs the convolution operation
     */
    public static int calcConvolute(int x, int y, int[][] convolute, int[][] kernel)
    {
        int result = 0;

        // we are going to multiply everything in the kernel by the given convolute positions (x,y) <-- how much we are going to shift the kernel overlay
        for(int a = 0; a < kernel.length; a++)
        {
            for(int b = 0; b < kernel[0].length; b++)
            {
                result = result + convolute[a + x][b + y] * kernel[a][b];
            }
        }
        return result;
    }
}
