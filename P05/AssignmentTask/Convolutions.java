import java.util.*;
public class Convolutions
{
    public static void main(String[] args)
    {
        int resultArray[][];
        int[][] convolute = Convolute.MATRIX_D;
        int[][] kernel = Kernel.VERTICAL;

        resultArray = createResultArray(convolute, kernel);  // this is going to give us a correctly sized resultArray
        calcResult(resultArray, convolute, kernel);          // filling this correctly sized array with the convolute algorithm

        printArray("Convolute", convolute);

        printArray("Kernel", kernel);

        printArray("Result", resultArray);
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

    public static void printArray(String name, int[][] pArray)
    {
        System.out.println(name + ":");
        for(int i = 0; i < pArray.length; i++)
        {
            // System.out.print();
            for(int ii = 0; ii < pArray[0].length; ii++)
            {
                System.out.printf("%4d", pArray[i][ii]);
            }
            System.out.println();
        }
    }
}
