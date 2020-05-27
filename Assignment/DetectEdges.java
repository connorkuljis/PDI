/* FILE: DetectEdges.java
 * AUTHOR: Connor Kuljis 
 * STUDENT ID: 19459138
 * PURPOSE: a static class for reading in png's/csv files and exporting their integer array format
// REFERENCE: SELF REFERENCE NOTICE This is an updated version of the P08 DetectEdges class
 * UNIT: PDI Sem 1 2020
 * LAST MOD: 27th May 2020  */

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class DetectEdges
{
    /*
     * Name: imageTypeSubMenu
     * Purpose: a sub menu for reading in a file from .csv or .png files
     * IMPORTS: none
     * EXPORTS: image (2D Array of Inteers)
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
        return image;
    }
}
