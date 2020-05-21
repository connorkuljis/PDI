public class testMain
{
    public static void main(String[] args)
    {
        // int[][] k = UserInterface.create2DArray();
        
        int[][] k = {{0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                     {0,1,2,3,4,5,6,7,8,9},
                    };
        
        // int[][] x = UserInterface.create2DArray();
        int[][] test = ValidKernel.smoothing(k);
        UserInterface.printTwoDArray(test);
    }
}
