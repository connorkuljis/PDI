public class testMain
{
    public static void main(String[] args)
    {
        // int[][] k = UserInterface.create2DArray();
        
        int[][] k = {{0,0,0,0,0,0},
                     {0,1,1,1,1,0},
                     {0,1,2,2,1,0},
                     {0,1,2,10,1,0},
                     {0,1,1,1,1,0},
                     {0,0,0,0,0,0}
                    };
        int[][] test = ValidKernel.getSmoothingKernel(k);
        UserInterface.printTwoDArray(test);

        double smoothingValue = 0.7;
        int avg = ValidKernel.avgArray(test, smoothingValue);
        System.out.println(avg); 

    }
}
