import java.util.*;
import java.io.*;

public class Menu
{
    public static void main(String[] args)
    {
        menu();
    }

    public static void menu()
    {

        Image currentImage = null;                 // REFERENCE TO THE MAIN IMAGE OBJECT
        int[][] kernel = null;

        System.out.println("|---------------------------|"); 
        System.out.println("| PDI Assignment Sem 1 2020 |"); 
        System.out.println("| Connor Kuljis, 19459138   |"); 
        System.out.println("|---------------------------|"); 

        boolean close = false;
        do
        {
            String prompt = "\nPlease select an option:\n1. Import Image:\n";
            int choice = UserInterface.userInput(prompt, 1, 1);
            switch(choice)
            {
                case 1:
                    currentImage = new Image(readImageSubMenu());
                    System.out.println(currentImage.toString()); 
                    break;
            }
        }while((currentImage == null));
        
        do
        {
            String prompt = "\nPlease select an option:\n1. Import Image:\n2. Import Kernel:\n3. Convolution:\n4. Export Image:\n5. Smoothing:\n0. Exit:\n";
            int choice = UserInterface.userInput(prompt, 0, 5);
            switch(choice)
            {
                case 1:                                  // Import Image
                    currentImage = new Image(readImageSubMenu());
                    System.out.println(currentImage.toString()); 
                    break;

                case 2:                                  // Import Kernel
                    kernel = readKernelSubMenu();
                    break;
                
                case 3:                                  // Convolution
                    if((currentImage != null) && (kernel != null))
                    {
                        currentImage = new Image(currentImage.convolution(kernel));
                        System.out.println(currentImage.toString()); 
                    }
                    else
                    {
                        System.out.println("Hey there is no Image or Kernel!"); 
                    }
                    break;
                 
                case 4:                                   // Exporting
                    System.out.println(currentImage.toString()); 
                    break;
                
                case 5:                                   // Smoothing
                    if(currentImage != null)
                    {
                        currentImage = new Image(smoothingMenu(currentImage));
                        System.out.println(currentImage.toString()); 
                    }
                    else
                    {
                        System.out.println("Hey there is no Image!"); 
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!"); 
                    close = true;
                    break;
            }
        }while(!close);
    }


    public static int[][] validMatrix(String type)
    {
        int[][] matrix = null;
        boolean valid = false;
        while(!valid)
        {
            try
            {
                String matrixFile = UserInterface.userInput("Please enter the filename of the " + type + ": ");
                matrix = FileIO.readFile(matrixFile); // this is where the exception is thrown
                valid = true;
            }
            catch(IllegalArgumentException e)
            {
                UserInterface.displayError(e.getMessage());
            }
            catch(FileNotFoundException e)
            {
                UserInterface.displayError(e.getMessage());
            }
        }
        UserInterface.printTwoDArray(matrix);
        return matrix;
    }

    public static Image smoothingMenu(Image imageObj)
    {
        boolean valid = false;
        do
        {
            try
            {
                int surfaceSize = UserInterface.userInput("Please enter a smoothing surface: ", 1, Integer.MAX_VALUE);
                int x_target = UserInterface.userInput("Please enter the pixel x-coordinate: ", 1, Integer.MAX_VALUE);
                int y_target = UserInterface.userInput("Please enter pixel y-coordinate: ", 1, Integer.MAX_VALUE);
                double smoothingFactor = UserInterface.userInput("Please enter a smoothness factor: ", 0.0, 1.0);
                
                imageObj.smoothing(surfaceSize, x_target, y_target, smoothingFactor); 
                valid = true;
            }
            catch(Exception e)
            {
                System.out.println(e); 
            }
        }while(!valid);
        return imageObj;
    }

    public static int[][] readImageSubMenu()
    {
        int[][] theImage = null;

        int choice = UserInterface.userInput("\nPlease select and option to import file:\n1. File\n2. User Input\n", 1, 2);
        switch(choice)
        {
            case 1:
                theImage = DetectEdges.imageTypeSubMenu();
                break;
            case 2:
                theImage = UserInterface.create2DArray();
                break;
        }
        return theImage;
    }

    public static int[][] readKernelSubMenu()
    {
        int[][] kernel = null;

        int choice = UserInterface.userInput("\nPlease select and option to import file:\n1. File\n2. User Input\n", 1, 2);
        switch(choice)
        {
            case 1:
                kernel = validMatrix("kernel");
                break;
            case 2:
                kernel = UserInterface.createKernel();
                break;
        }
        return kernel;
    }

}
