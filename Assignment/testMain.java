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

         int[][] hor =
            {
                    { 1,  1,  1},
                    { 0,  0,  0},
                    {-1, -1, -1}
            }; 
            /*
             * VERTICAL - A kernel that detects vertical lines.
             */
        int[][] ver =
            {
                    { 1,  0, -1},
                    { 1,  0, -1},
                    { 1,  0, -1}
            }; 


        int[][] a =
            {
                    {10, 10, 10,  0,  0,  0},
                    {10, 10, 10,  0,  0,  0},
                    {10, 10, 10,  0,  0,  0},
                    {10, 10, 10,  0,  0,  0},
                    {10, 10, 10,  0,  0,  0},
                    {10, 10, 10,  0,  0,  0}
            }; 
            /*
             * ARRAY_B contains a 6x6 matrix
             */
        int[][] b =
            {
                    {3, 0, 1, 2, 7, 4},
                    {1, 5, 8, 9, 3, 1},
                    {2, 7, 2, 5, 1, 3},
                    {0, 1, 3, 1, 7, 8},
                    {4, 2, 1, 6, 2, 8},
                    {2, 4, 5, 2, 3, 9}
            };
            /*
             * ARRAY_C contains a 11x6 matrix
             */
        int[][] c =
            {
                    {3, 0, 1, 2, 7, 4},
                    {1, 5, 8, 9, 3, 1},
                    {2, 7, 2, 5, 1, 3},
                    {0, 1, 3, 1, 7, 8},
                    {3, 0, 1, 2, 7, 4},
                    {4, 2, 1, 6, 2, 8},
                    {2, 7, 2, 5, 1, 3},
                    {2, 7, 2, 5, 1, 3},
                    {2, 7, 2, 5, 1, 3},
                    {2, 7, 2, 5, 1, 3},
                    {2, 7, 2, 5, 1, 3},
                    {2, 4, 5, 2, 3, 9}
            };
            /*
             * ARRAY_D contains a 6x9 matrix
             */
        int[][] d =
            {
                    {3, 0, 1, 2, 7, 4, 4, 4, 4},
                    {1, 5, 8, 9, 3, 1, 1, 1, 1},
                    {2, 7, 2, 5, 1, 3, 3, 3, 3},
                    {0, 1, 3, 1, 7, 8, 8, 8, 8},
                    {3, 0, 1, 2, 7, 4, 4, 4, 4},
                    {4, 2, 1, 6, 2, 8, 8, 8, 8}
            };




        Image image = new Image(c);
        System.out.println(image.toString()); 

        // Image convolute = new Image(image.convolution(hor));
        // System.out.println(convolute.toString()); 

        /*
        try
        {
            Image test = new Image(image.smoothing(3,2,5,0.089));
            System.out.println(test.toString()); 
        }
        catch (Exception e)
        {
            System.out.println(e); 
        }
        */

        Image xx = new Image(DetectEdges.imageTypeSubMenu());
        System.out.println(xx.toString()); 




        
        // int[][] x = UserInterface.create2DArray();
        // int[][] test = ValidKernel.smoothing(k);
        // UserInterface.printTwoDArray(test);
    }
}
