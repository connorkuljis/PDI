import java.util.*;
public class Convolutions
{
    public static void main(String[] args)
    {
        int resultArray[][];
        int convolute[][] = Convolute.MATRIX_A;
        int kernel[][] = Kernel.VERTICAL;

        resultArray = createResultArray(Convolute.MATRIX_A, Kernel.VERTICAL);

        // simply loops through each position in the result array
        for(int i = 0; i < resultArray.length; i++)
        {
            System.out.print("| ");
            for(int j = 0; j < resultArray[0].length; j++)
            {
                resultArray[i][j] = calcConvolute(i, j, Convolute.MATRIX_A, Kernel.VERTICAL);
                System.out.print(resultArray[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static int[][] createResultArray(int[][] convoluteArray, int[][] kernelArray)
    {
        int n, m, k;
        int[][] resultArray;

        // getting dimentions of the convolute array
        n = convoluteArray.length;        // rows
        m = convoluteArray[0].length;     // columns

        k = kernelArray.length;    // getting dimensions of kernel assuming it is k by k

        // producing a valid result array
        resultArray = new int[(n - k + 1)][(m - k + 1)];
        
        return resultArray;
    }

    public static int calcConvolute(int x, int y, int[][] convolute, int[][] kernel)
    {
        int result = 0;

        for(int a = 0; a < kernel.length; a++)
        {
            for(int b = 0; b < kernel.length; b++)
            {
                result = result + convolute[a + x][b + y] * kernel[a][b];
            }
        }

        return result;
    }
}
