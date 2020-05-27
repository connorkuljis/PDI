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

        // reference variables that will be updated by the user through the menu
        Image currentImage = null;                 
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
                    break;

                case 2:                                  // Import Kernel
                    kernel = readKernelSubMenu();
                    break;
                
                case 3:                                  // Convolution
                    if((currentImage != null) && (kernel != null))
                    {
                        currentImage = new Image(currentImage.convolution(kernel));
                    }
                    else
                    {
                        System.out.println("Hey there is no Image or Kernel!"); 
                    }
                    break;
                 
                case 4:                                   // Exporting
                    exportImage(currentImage);
                    
                    break;
                
                case 5:                                   // Smoothing
                    currentImage = new Image(smoothingMenu(currentImage));
                    System.out.println(currentImage.toString()); 
                    break;

                case 0:
                    System.out.println("Goodbye!"); 
                    close = true;
                    break;
            }
        }while(!close);
    }

    public static void exportImage(Image currentImage)
    {
        int[][] rawImage = currentImage.getOriginalImage();
        String filename = UserInterface.userInput("\nPlease enter the File Name: ");
        char choice = UserInterface.userInput("\nWhat filetype would you like to save with? (C)SV or (P)NG", 'A', 'z');
        char upperChoice = Character.toUpperCase(choice);
        String extension = "";

        switch(upperChoice)
        {
            case 'P':
                extension = ".png";
                filename = fileNamingConvention(filename, extension);
                FileIO.writePNG(filename, rawImage);
                System.out.println("File (" + filename + ")"); 
                break;

            case 'C':
                extension = ".csv";
                filename = fileNamingConvention(filename, extension);
                FileIO.writeFile(filename, rawImage);
                System.out.println("File (" + filename + ")"); 
                break;
        }
    }

    /*************************************************************************
     * NAME: fileNamingConvention
     * IMPORTS:
     * EXPORTS
     * PURPOSE
     * **********************************************************************/
    public static String fileNamingConvention(String filename, String extension)
    {
        boolean valid = false;
        int digit;
        Date newDate = null;
        do
        {
            try
            {
                digit = UserInterface.userInput("Please enter an 8 digit Date to save with: ", 1000000, 99999999);
                newDate = new Date(digit);
                valid = true;
            }
            catch (Exception e)
            {
                UserInterface.displayError(e.getMessage());
            }
        }while(!valid);

        String day = Integer.toString(newDate.getDay());
        String month = Integer.toString(newDate.getMonth());
        String year = Integer.toString(newDate.getYear());

        String concatenatedFilename = (year + "-" + month + "-" + day + "_Processed_" + filename + extension ); 

        return concatenatedFilename;

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

        int choice = UserInterface.userInput("\nPlease select and option to import file:\n1. CSV File\n2. User Input\n", 1, 2);
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
