// FILE     : Image.java
// AUTHOR   : Connor Kuljis
// USERNAME : 19459138
// UNIT     : PDI
// PURPOSE  : class of an image object
// REFERENCE: 
// COMMENTS : 
// REQUIRES : Convolute.java, Kernel.java
// LAST MOD : 02/05/2020
import java.util.*;

public class Image
{
    // class fields
    int[][] originalImage;
    
    // NAME: default constructor
    // IMPORT: none
    // EXPORT: none
    // ASSERTION: valid default array should be a empty array, array must not be null
    public Image()
    {
        originalImage = new int[1][1];
    }


    // NAME: alternate constructor
    // IMPORT: inOriginalImage (2D ARRAY OF Integers)
    // EXPORT: none
    // ASSERTION: assume the array is valid
    public Image(int[][] inOriginalImage)
    {
        setOriginalImage(inOriginalImage);
    }

    // NAME: copy constructor
    // IMPORT: Image inImage
    // EXPORT: 
    // ASSERTION: creates an object with an identical object state as the import 
    public Image(Image inImage)
    {
        originalImage = inImage.getOriginalImage();
    }

    // MUTATORS:
    // SUBMODULE: setOriginalImage
    // IMPORT: inOriginalImage(2D ARRAY OF Integer)
    // EXPORT: none
    // ASSERTION:
    public void setOriginalImage(int[][] inOriginalImage)
    {
        originalImage = inOriginalImage;
    }

    // ACCESSORS:
    // SUBMODULE: getOriginalImage
    // IMPORT: none
    // EXPORT: originalImage
    public int[][] getOriginalImage()
    {
        return originalImage;
    }

    // SUBMODULE: equals
    // IMPORT: inObj (Object)
    // EXPORT: same (boolean)
    // ASSERTION: two objects are the same if the two dimentional arrays are both the same size and for each position 
    //            the values are the same
    public boolean equals(Object inObj)
    {
        boolean same = false;
        int count = 0;
        if(inObj instanceof Image)
        {
            Image inImage = (Image) inObj;
            // same = (Arrays.DeepEquals(originalImage, inImage.getOriginalImage()));
            int[][] comparisonArray = inImage.getOriginalImage();
            if(originalImage.length == comparisonArray.length && originalImage[0].length == comparisonArray[0].length); // check if they are the same length
            {
                for(int i=0; i < originalImage.length; i++)
                {
                    for(int j=0; j < originalImage[0].length; j++)
                    {
                        if(originalImage[i][j] != comparisonArray[i][j])
                        {
                            count += 1;
                        }
                    }
                }
            }
            if(count == 0)
            {
                same = true;
            }
        }
        return same;
    }

    // SUBMODULE: clone
    // IMPORT: none
    // EXPORT: cloneImage (Object)
    // ASSERTION: returns a closed objet of the current object
    public Image clone()
    {
        return new Image(this);
    }

    // SUBMODULE: toString
    // IMPORT: none
    // EXPORT: str (String)
    // ASSERTION: 
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

    // SUBMODULE: convolution
    // IMPORT: kernel (2D array of integers)
    // EXPORT: resultArray (2D array of integers)
    // ASSERTION: assume the kernel is valid and is n*n in size
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
                resultArray[i][j] = calcConvolute(i, j, kernel); 
            }
        }
        return resultArray;
    }

    /*
     * SUBMODULE: calcConvolute
     * IMPORT: i (integer), j (integer), kernel (2D array of integers)
     * EXPORT: result (integer)
     * ASSERTION: this submodule performs the convolution operation
     */
    private int calcConvolute(int i, int j, int[][] kernel)
    {
        int result = 0;

        // we are going to multiply everything in the kernel by the given convolute positions (x,y) <-- how much we are going to shift the kernel overlay
        for(int a = 0; a < kernel.length; a++)
        {
            for(int b = 0; b < kernel[0].length; b++)
            {
                result += originalImage[a + i][b + j] * kernel[a][b];
            }
        }
        return result;
    }
}
