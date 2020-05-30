// FILE     : Image.java
// AUTHOR   : Connor Kuljis
// USERNAME : 19459138
// UNIT     : PDI
// PURPOSE  : Class of an image object
// REFERENCE: SELF REFERENCE NOTICE This is an updated version of the P06 Image class
// COMMENTS : 
// REQUIRES :
// LAST MOD : 27/05/2020
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
                str += originalImage[i][j] + " ";
            }
        }
        return str;
    }

    // SUBMODULE: convolution
    // IMPORT: kernel (2D array of integers)
    // EXPORT: resultArray (2D array of integers)
    // ASSERTION: assume the kernel is valid and is n*n in size
    public void convolution(int[][] kernel)
    { 
        try
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
            originalImage = resultArray;
        }
        catch(NegativeArraySizeException e)
        {
            UserInterface.displayError("You may be trying to convolute an image that is smaller than the kernel.");
        }
        catch(Exception e)
        {
            UserInterface.displayError(e.getMessage());
        }
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

    /* ***********************************************************************
     * NAME: smoothing
     * PURPOSE: smooths out surrounding areas of a target element in a multidementional array
     * IMPORTS: surfaceSize (Integer), x (Integer), y (Integer), smoothingFactor (Real)
     * EXPORTS: image (2D ARRAY OF INTEGERS) - that has been smoothed around a given pixel
     * EXPLANATION: creates a new array of select values and finds the average * smoothing value and updates the current image object
     * **********************************************************************/
    public void smoothing(int surfaceSize, int x, int y, double smoothingFactor) throws ArrayIndexOutOfBoundsException
    {
        int x_target = y - 1;    // accounting for 0 index not included for user
        int y_target = x - 1;    // flipping x and y coordinates in matrix
        
        int surfaceRange = (surfaceSize - 1) / 2; // maximum boundary size at any point from the target pixel

        int[][] smoothingKernel = new int[surfaceSize][surfaceSize]; // creating new array to store values in smoothing area

        // domain of all array positions within the surface range around the target pixel
        int x_min = (x_target - surfaceRange), x_max = (x_target + surfaceRange);
        int y_min = (y_target - surfaceRange), y_max = (y_target + surfaceRange);
        
        try
        {
            int n = -1;        // creating index which will allows to store values starting from 0,0
            int m;             // because the for loop does not start at 0 and varies depending on starting location
            for (int i = x_min; i <= x_max; i++)
            {
                n++;
                m = -1; // resetting value
                for (int j = y_min; j <= y_max; j++)
                {
                    m++;
                    // filling a new array of values within the smoothing surface area
                    smoothingKernel[n][m] = originalImage[i][j];        // possible exception
                }
            }

            // average is the ceil'd average of all elements (sxs) * smoothingFactor
            int average = PDIMath.avgArray(smoothingKernel, smoothingFactor);

            for (int i = (x_target - surfaceRange); i <= (x_target + surfaceRange); i++)
            {
                for (int j = (y_target - surfaceRange); j <= (y_target + surfaceRange); j++)
                {
                    originalImage[i][j] = average;                      // possible exceptions 
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new ArrayIndexOutOfBoundsException("Out of bounds");
        }
    }

}
