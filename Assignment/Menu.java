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
	public static final int[][] VERTICAL_KERNEL =
						{
							{1, 0, -1},
							{1, 0, -1},
							{1, 0, -1}
						};

	public static final int[][] HORIZONTAL_KERNEL =
						{
							{1, 1, 1},
							{0, 0, 0},
							{-1, -1, -1}
						};

    public static void main(String[] args)
    {
        menu();
    }

    /*************************************************************************
     * NAME: Menu
     * IMPORTS: none
     * EXPORTS: none
     * PURPOSE: A top level menu in which smaller sub-menus are called. There are
     *          7 options and will loop until user selects zero to exit
     * **********************************************************************/
    public static void menu()
    {

        // reference variables that will be updated by the user through the menu
        Image currentImage = null;                 
        int[][] kernel = null;
        
        // Short Welcome Message
        displayWelcome();

        // Initial menu, users will get access to full menu once they have imported a valid image.
        boolean close = false;
        do
        {
            String prompt = "\nPlease select an option:\n1. Import Image:\n";
            int choice = UserInterface.userInput(prompt, 1, 1);
            switch(choice)
            {
                case 1:
                    // read can select file path or manual entry
                    currentImage = new Image(readImageSubMenu());
                    break;
            }
        }while((currentImage == null));
        
        do
        {
            // tells the user the dimension (resolution) of currently stored image and kernel
            displayInformation(currentImage, kernel);

            // Top level/super menu
            String prompt = "\nPlease select an option:\n1. Import Image\n2. Import Kernel\n3. Convolution\n4. Detect Vertical Lines\n5. Detect Horizontal Lines\n6. Smoothing\n7. Export Image\n0. Exit\n";
            int choice = UserInterface.userInput(prompt, 0, 7);
            switch(choice)
            {
                case 1:                                  // Import Image
                    int[][] temp = readImageSubMenu();
                    currentImage = new Image(temp);
                    break;

                case 2:                                  // Import Kernel
                    kernel = readKernelSubMenu();
                    break;
                
                case 3:                                  // Convolution
                    if((currentImage != null) && (kernel != null))
                    {
                        currentImage.convolution(kernel);
                    }
                    else
                    {
                        UserInterface.println("ERROR: please ensure you have supplied a valid Image or Kernel! (Kernel may be missing)"); 
                    }
                    break;
                // Detect Vertical Lines
                case 4:
                    currentImage.convolution(VERTICAL_KERNEL);
                    break;
                 
                case 5:
                    currentImage.convolution(HORIZONTAL_KERNEL);
                    break;
                 
                case 6:                                   // Smoothing
                    smoothingMenu(currentImage);
                    break;
                
                case 7:                                   // Export
                    exportImage(currentImage);
					UserInterface.println("Sucessfully exported image.");
                    break;

                case 0:
                    UserInterface.println("Goodbye!"); 
                    close = true;
                    break;
            }
        }while(!close);
    }

    /*************************************************************************
     * NAME: displayWelcome
     * IMPORTS: none
     * EXPORTS: none
     * PURPOSE: prints a welcome message to the user
     * **********************************************************************/
    public static void displayWelcome()
    {
        UserInterface.println("|---------------------------|"); 
        UserInterface.println("| PDI Assignment Sem 1 2020 |"); 
        UserInterface.println("| Connor Kuljis, 19459138   |"); 
        UserInterface.println("|---------------------------|"); 
    }

    /*************************************************************************
     * NAME: displayInformation
     * IMPORTS: currentImage(Image), kernel (2D ARRAY OF Integer)
     * EXPORTS: none
     * PURPOSE: will print current information about the stored image and kernel to the user
     * **********************************************************************/
    public static void displayInformation(Image currentImage, int[][] kernel)
    {
        try
        {
            int[][] myArray = currentImage.getOriginalImage();
            int length = myArray.length;
            int width = myArray[0].length;
            UserInterface.println("\n\tCurrently stored image = [" + length + " x " + width + "]" ); 
        }
        catch(Exception e)
        {
            UserInterface.println(e.getMessage());
        }

        if(kernel == null)
        {
            UserInterface.println("\n\tNo Kernel has been imported"); 
        }
        else
        {
            UserInterface.println("\n\tCurrently stored kernel = [" + kernel.length + " x " + kernel[0].length + "]" ); 
        }
    }

    /*************************************************************************
     * NAME: smoothingMenu
     * IMPORTS: imageObj (Image)
     * EXPORTS: imageObj (Image)
     * PURPOSE: sub-menu that calls the inObj.smoothing method after accepting user input 
     * **********************************************************************/
    public static void smoothingMenu(Image imageObj)
    {
        boolean everythingIsValid = false;
        do
        {
            UserInterface.println("### Smoothing Operation ###");
            String errorMsg = "";
            int surfaceSize = 0;
            int odd = 0;
            do
            {
                // getting surface size
                System.out.println(errorMsg); 
                surfaceSize = UserInterface.userInput("Please enter a smoothing surface: ", 1, Integer.MAX_VALUE);
                errorMsg = "ERROR: Please double check you have entered an ODD surface size to perfectly surround the target";
            }while(surfaceSize % 2 == odd);

            boolean valid = false;
            int x_target = 0;
            int y_target = 0;
            do
            {
                try
                {
                    String coordinates = UserInterface.userInput("Please enter a pixel to smooth (x,y): ");
                    String[] arrOfCoordinates = coordinates.split(",");
                    x_target = Integer.parseInt(arrOfCoordinates[0]);
                    y_target = Integer.parseInt(arrOfCoordinates[1]);
                    valid = true;
                } 
                catch(Exception e)
                {
                    UserInterface.displayError("Invalid (x,y) format, please enter values x separated by a ',' followed by y (no spaces)");
                }
            }while(!valid);

            double smoothingFactor = UserInterface.userInput("Please enter a smoothness factor: ", 0.0, 1.0);

            try
            {
                imageObj.smoothing(surfaceSize, x_target, y_target, smoothingFactor); 
                everythingIsValid = true;
            }
            catch(Exception e)
            {
                UserInterface.displayError(e.getMessage()); 
            }
        }while(!everythingIsValid);
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
                String matrixFile = UserInterface.userInput("Please enter the filename of the kernel: ");
                matrix = FileIO.readKernel(matrixFile); // this is where the exception is thrown
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
                UserInterface.println("File (" + filename + ")"); 
                break;

            case 'C':
                extension = ".csv";
                filename = FileIO.fileNamingConvention(filename, extension);
                FileIO.writeFile(filename, rawImage);
                UserInterface.println("File (" + filename + ")"); 
                break;
        }
    }

}
