// FILE: Menu.java
// AUTHOR: Connor Kuljis
// STUDENT ID: 19459138
// UNIT: COMP1007 - Programming Design and Implementation (PDI) sem 1 2020
// PURPOSE: A user menu for the PDI Assignment
// REFERENCE:
// REQUIRES: Image, Date, UserInterface, FileIO, PDIMath, DetectEdges
// LAST MOD: 27/05/2020
import java.util.*;
import java.io.*;

public class Menu
{
    public static void main(String[] args)
    {
        menu();
    }

    /*************************************************************************
     * NAME: Menu
     * IMPORTS: none
     * EXPORTS: none
     * PURPOSE: A top level menu in which smaller sub-menus are called
     * **********************************************************************/
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

    /*************************************************************************
     * NAME: exportImage
     * IMPORTS: currentImage (Image)
     * EXPORTS: none
     * PURPOSE: writes currently stored Image to a csv or png file
     * **********************************************************************/
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
                filename = FileIO.fileNamingConvention(filename, extension);
                FileIO.writePNG(filename, rawImage);
                System.out.println("File (" + filename + ")"); 
                break;

            case 'C':
                extension = ".csv";
                filename = FileIO.fileNamingConvention(filename, extension);
                FileIO.writeFile(filename, rawImage);
                System.out.println("File (" + filename + ")"); 
                break;
        }
    }


    /*************************************************************************
     * NAME: smoothingMenu
     * IMPORTS: imageObj (Image)
     * EXPORTS: imageObj (Image)
     * PURPOSE: sub-menu that calls the inObj.smoothing method after accepting user input 
     * **********************************************************************/
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

    /*************************************************************************
     * NAME: readImageSubMenu
     * IMPORTS: none
     * EXPORTS: theImage (2D Array of Integers)
     * PURPOSE: sub-menu for reading in an image from a file or from user input
     * **********************************************************************/
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

    /*************************************************************************
     * NAME: readKernelSubMenu
     * IMPORTS: none
     * EXPORTS: kernel (2D Array of Integers)
     * PURPOSE: sub-menu for reading in an image from a file or from user input
     * **********************************************************************/
    public static int[][] readKernelSubMenu()
    {
        int[][] kernel = null;

        int choice = UserInterface.userInput("\nPlease select and option to import file:\n1. CSV File\n2. User Input\n", 1, 2);
        switch(choice)
        {
            case 1:
                kernel = readKernel();
                break;
            case 2:
                kernel = UserInterface.createKernel();
                break;
        }
        return kernel;
    }

    /*************************************************************************
     * NAME: readKernel
     * IMPORTS: type (String)
     * EXPORTS: matrix (2D ARRAY OF Integers)
     * PURPOSE: reads a single CSV file and returns a mutlidementional array of integers 
     * **********************************************************************/
    public static int[][] readKernel()
    {
        int[][] matrix = null;
        boolean valid = false;
        while(!valid)
        {
            try
            {
                String matrixFile = UserInterface.userInput("Please enter the filename of the kernel :");
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
        return matrix;
    }

}
