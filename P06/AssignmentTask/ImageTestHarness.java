import java.util.*;

public class ImageTestHarness
{
    public static void main(String[] args)
    {
        try
        {
            Image[] image = new Image[4];

            //object creation
            image[0] = new Image();
            image[1] = new Image(Convolute.MATRIX_A);
            image[2] = new Image(image[1]);
            image[3] = image[1].clone();
            Image convolution = new Image(image[1].convolution(Kernel.VERTICAL));

            //print out created objects
            System.out.println("CONSTRUCTOR TESTS:");
            for(int i = 0; i < image.length; i++)
            {
                System.out.println("Image[" + i + "]: " + image[i].toString());
            }

            //equals method
            System.out.println("\nEQUALS METHOD TESTS:");
            System.out.println("Equals (object) expected TRUE: " + image[1].equals(image[3]));
            System.out.println("Equals (object) expected FALSE: " + image[0].equals(image[3]));
   
            //getters and setters
            System.out.println("\nGETTERS AND SETTERS:");
            image[0].setOriginalImage(image[1].getOriginalImage());
            System.out.println(image[0].getOriginalImage() + " = " + image[1].getOriginalImage());

            // testing convolutions
            System.out.println("\nTESTING CONVOLUTION:"); 
            System.out.println(convolution.toString());
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
