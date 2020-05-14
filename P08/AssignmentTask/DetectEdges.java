// note from last night: you need to refactor to accept USER INPUT and do some validation and error handling eg only print sign off message if the convolute has not failed

public class DetectEdges
{
    public static void main(String[] args)
    {
        detectEdges();
    }
    public static void detectEdges()
    {
        String kernelFile = "Supplementary_Files/VerticalKernel.csv"; // UserInterface.userInput("Please enter the filename of the kernel: ");
        // UserInterface.printTwoDArray(FileIO.readFile(kernelFile));
        int[][] kernel = FileIO.readFile(kernelFile);
        int[][] image = null;
        String imageFilename = "";

        // get the 
        char ch = UserInterface.userInput("Would you like to perform on (C)SV or (P)NG: ", 'A', 'z');
        char choice = Character.toUpperCase(ch);
        // do while here
        if(choice == 'C')
        {
            imageFilename = UserInterface.userInput("Please enter the filename of the CSV: ");
            image = FileIO.readFile("Supplementary_Files/Image_B.csv");// (csvFileName);
        }
        if(choice == 'P')
        {
            imageFilename = UserInterface.userInput("Please enter the filename of the PNG: ");
            image = FileIO.readPNG(imageFilename);
        }

        int[][] resultArray = createResultArray(image, kernel);
        int[][] tempArray = calcResult(resultArray, image, kernel);

        UserInterface.printTwoDArray(tempArray);

        String newImageFilename = imageFilename + "_Converted.png";
        FileIO.writeFile(newImageFilename, tempArray);
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
