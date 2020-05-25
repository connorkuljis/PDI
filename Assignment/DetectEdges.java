/* FILE: DetectEdges.java
 * PURPOSE: a method for detecting edges in png's/csv files
 * AUTHOR: Connor Kuljis 19459138
 * UNIT: PDI Sem 1 2020
 * LAST MOD: 16th May 2020  */

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class DetectEdges
{
    /*
     * Name: detectEdges
     * Purpose: can detect edges in csv or png files, by performing matrix operations
     * IMPORTS: nothing
     * EXPORTS: 
     * Created: 15/05/2020
     */
    public static int[][] imageTypeSubMenu()
    {

        boolean valid = false;
        int[][] image = null;

        String imageFilename = "";

        boolean close = false;

        boolean done = false;
        do
        {
            char ch = UserInterface.userInput("Would you like to perform on (C)SV or (P)NG: ", 'A', 'z');
            char choice = Character.toUpperCase(ch);
            switch(choice)
            {
                // READ CSV
                case 'C':
                    done = false;
                    while(!done)
                    {
                        try
                        {
                            imageFilename = UserInterface.userInput("Please enter the filename of the CSV: ");
                            image = FileIO.readFile(imageFilename);
                            done = true;
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
                    close = true;
                    break;

                // READ PNG
                case 'P':
                    done = false;
                    while(!done)
                    {
                        try
                        {
                            imageFilename = UserInterface.userInput("Please enter the filename of the PNG: ");
                            image = FileIO.readPNG(imageFilename);
                            done = true;
                        }
                        catch(NullPointerException e)
                        {
                            UserInterface.displayError(e.getMessage());
                        }
                        catch(IOException e)
                        {
                            UserInterface.displayError(e.getMessage());
                        }
                    } 
                    close = true;
                    break;
            }
        } while(!close);


        // appending to filename
        // String newImageFilename = imageFilename + "_Converted.png";

        // confirmation message, error handing is done inside the method writeFile
        // FileIO.writePNG(newImageFilename, convoluteArray);
        // System.out.println("File (" + newImageFilename + ") written. Goodbye!"); 
        return image;
    }
}
