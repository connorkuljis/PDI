import java.util.*;

public class Image
{
    // class fields
    int[][] originalImage;

    // default constructor
    public Image()
    {
        originalImage = new int[1][1];
    }


    // alternate constructor
    public Image(int[][] inOriginalImage)
    {
        setOriginalImage(inOriginalImage);
    }

    // copy constructor
    public Image(Image inImage)
    {
        originalImage = inImage.getOriginalImage();
    }

    // mutators
    public void setOriginalImage(int[][] inOriginalImage)
    {
        originalImage = inOriginalImage;
    }

    // accessors
    public int[][] getOriginalImage()
    {
        return originalImage;
    }

    // clone
    public Image clone()
    {
        return new Image(this);
    }

    // equals
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if(inObj instanceof Image)
        {
            Image inImage = (Image) inObj;
            same = (Arrays.equals(originalImage, inImage.getOriginalImage()));
        }
        return same;
    }
 
    public String toString()
    {
        String str = "";
        for(int i=0; i < originalImage.length; i++)
        {
            str += "\n";
            for(int j=0; j < originalImage[0].length; j++)
            {
                str += originalImage[i][j] + "\t";
            }
        }
        return str;
    }

    public int[][] convolution(int[][] kernel)
    {
        int[][] resultArray;
        int n, m, k;

        // getting dimentions of the convolute array
        n = originalImage.length;        // rows
        m = originalImage[0].length;     // columns

        // getting dimensions of kernel assuming it is k by k
        k = kernel.length;    

        resultArray = new int[(n - k + 1)][(m - k + 1)];

        // looping through the result array
        for(int i = 0; i < resultArray.length; i++)
        {
            for(int j = 0; j < resultArray[0].length; j++)
            {
                resultArray[i][j] = calcConvolute(i, j, originalImage, kernel); 
            }
        }
        return resultArray;
    }

    /*
     * Name: calcConvolute
     * Date: 23/04/2020
     * Import: i (integer), j (integer), convolute (2D array of integers), kernel (2D array of integers)
     * Export: result (integer)
     * Purpose: this submodule performs the convolution operation
     */
    private int calcConvolute(int i, int j, int[][] convolute, int[][] kernel)
    {
        int result = 0;

        // we are going to multiply everything in the kernel by the given convolute positions (x,y) <-- how much we are going to shift the kernel overlay
        for(int a = 0; a < kernel.length; a++)
        {
            for(int b = 0; b < kernel[0].length; b++)
            {
                result = result + convolute[a + i][b + j] * kernel[a][b];
            }
        }
        return result;
    }
}
