/* FILE: FileIO.java
 * AUTHOR: Connor Kuljis 
 * STUDENT ID: 19459138
 * UNIT: COMP 1007 Programming Design and Implementation (PDI) Sem 1 2020
 * PURPOSE: class of methods to read/write and name csv/png's
 * REQUIRES:
 * REFERENCE: SELF REFERENCE NOTICE - this is an updated version of FileIO from P08
 * COMMENTS: 
 * LAST MOD: 27/05/2020
 */ 
import java.util.*;
import java.io.*;
import java.awt.*; 
import java.awt.image.*; 
import javax.imageio.*;
 
public class FileIO
{
    
    /* Name: readFile
     * IMPORTS: fileName of a csv file
     * EXPORTS: multidimenstional array of csv file
     * Purpose: constructs a 2D array of integers from a csvfile (String)
     * Assertion: if the csv is ragged it will throw an IllegalArgument Exception
     * Created: 14th May 2020 */
    public static int[][] readFile(String fileName) throws FileNotFoundException, IllegalArgumentException, NumberFormatException
    {
        FileInputStream fileStream = null;
        InputStreamReader reader;
        BufferedReader bufReader;
        String line = "";
        int lineNum = 0, totalRows;
        int[][] parsedArray = null;

        try
        {
            totalRows = getNumRowsInFile(fileName); // get number of lines in file
            String[] stringArray = new String[totalRows]; // making a right sized array to number of lines
            // reading the text to a String array
            fileStream = new FileInputStream(fileName);
            reader = new InputStreamReader(fileStream);
            bufReader = new BufferedReader(reader);
            line = bufReader.readLine();
            while(line != null)
            {
                lineNum++;
                stringArray[lineNum - 1] = line;
                line = bufReader.readLine(); // NOTE: this must be the last line in the loop
            }
            fileStream.close();

            if(!arrayIsRectangle(stringArray))
            {
                throw new IllegalArgumentException("Invalid file/filetype: dimensions are not n x n ");
            }
            parsedArray = parseStringToInt(stringArray, totalRows); // error could be throw here if string array has non ints
        }
        catch(NumberFormatException e) // catching the non-ints
        {
            throw new NumberFormatException("Matrix has a non-integer element in it.");
        }
        catch(FileNotFoundException e)
        {
            throw new FileNotFoundException("Could not find file.");
        }
        catch(IOException e) // general exception for readLine()
        {
            if(fileStream != null)
            {
                try
                {
                    fileStream.close();
                }
                catch(IOException ex2)
                {
                }
            }
            UserInterface.displayError(e.getMessage());
        }
        return parsedArray;
    }

    /* Name: getNumRowsInFile
     * IMPORTS: fileName as a string
     * EXPORTS: multidimenstional array of csv file
     * Purpose: constructs a 2D array of integers from a csvfile (String)
     * Assertion: if the csv is ragged it will throw an IllegalArgument Exception
     * Created: 14th May 2020 */
    private static int getNumRowsInFile(String fileName) throws IOException 
    {
        int lineNum = 0;
        String line = "";
        FileInputStream fileStream = new FileInputStream(fileName);
        InputStreamReader reader = new InputStreamReader(fileStream);
        BufferedReader bufReader = new BufferedReader(reader);
        line = bufReader.readLine();
        while(line != null)
        {
            lineNum++;
            line = bufReader.readLine();
        }
        fileStream.close();
        return lineNum;
    }

    /*************************************************************************
     * NAME: arrayIsRectangle
     * IMPORTS: stringArray(ARRAY OF Strings)
     * EXPORTS: valid (Boolean)
     * PURPOSE: returns true if a string array is perfectly rectanglar
     * **********************************************************************/
    private static boolean arrayIsRectangle(String[] stringArray)
    {
        // scan the first line and get the number of elements "size"
        // if the next lines do not equals the size return false

        boolean valid = true;

        StringTokenizer tokenizer = new StringTokenizer(stringArray[0], ",");
        int maxLength = tokenizer.countTokens(); 

        int length;
        int lineMismatch = 0;
        for(int i = 1; i < stringArray.length - 1; i++)
        {
            StringTokenizer st = new StringTokenizer(stringArray[i], ",");
            length = st.countTokens();
            if(length != maxLength)
            {
                lineMismatch++;
            }
        }
        if(lineMismatch != 0)
        {
            valid = false;
        }
        return valid;
    }

    /*************************************************************************
     * NAME: parseStringToInt
     * IMPORTS: stringArray(ARRAY OF String), totalRows (Integer)
     * EXPORTS: parsedArray (Integer)
     * PURPOSE: converts a String Array of numbers separated by commas to a
     *          2D integer array
     * **********************************************************************/
    private static int[][] parseStringToInt(String[] stringArray, int totalRows)
    {
        int cols = stringArray.length;
        int rows = totalRows;

        int[][] parsedArray = new int[rows][cols];

        int count = -1;
        int element;
        for(int i = 0; i < rows; i++)
        {
            StringTokenizer tokenizer = new StringTokenizer(stringArray[i], ",");
            while(tokenizer.hasMoreTokens())
            {
                count++;
                element = Integer.parseInt(tokenizer.nextToken());
                parsedArray[i][count] = element;
            }
            count = -1; // resetting the count
        }
        return parsedArray;
    }

    /*************************************************************************
     * NAME: writeFile
     * IMPORTS: fileName (String), writeArray (2D Array of Integers)
     * EXPORTS: none
     * PURPOSE: writes a mulidimensional array of integers to a .csv file
     * **********************************************************************/
    public static void writeFile(String fileName, int[][] writeArray)
    {
        String[] stringArray = new String[writeArray.length]; // temp array to hold string data
        // try catch initialisation
        String line = "";
        FileOutputStream fileStrm = null; 
        PrintWriter pw;
        try
        {
            fileStrm = new FileOutputStream(fileName, false); // true will append the file, false overwrites.
            pw = new PrintWriter(fileStrm);
            for(int i = 0; i < writeArray.length; i++)
            {
                for(int j = 0; j < writeArray[0].length; j++)
                {
                    if(j == writeArray[0].length - 1) // check if the it is the last element in the row
                    {
                        line += String.valueOf(writeArray[i][j]); // this is the last element so dont put an ',' at the end
                    }
                    else
                    {
                        line += String.valueOf(writeArray[i][j] + ","); // append ',' to the end
                    }
                }
                pw.println(line); 
                line = "";
            }
            pw.close();
        }
        catch(IOException e) {
            if (fileStrm != null) {
                try
                {
                    fileStrm.close();
                    
                }
                catch(IOException ex2) {}
                
            }
            System.out.println("Error in writing to file: " + e.getMessage()); 
        }
    }

    /*************************************************************************
     * NAME: readPNG
     * IMPORTS: filename (String)
     * EXPORTS: image (2D Array of Integers)
     * PURPOSE: reads a .png file to a multidimensional array of integer values
     * ASSERTION: exceptions are re-thrown to the called of the method
     * **********************************************************************/
    public static int[][] readPNG(String fileName) throws IOException, NullPointerException
    {
        BufferedImage img; 
        File inputFile; 
        int[][] image = null;

        try
        {
            inputFile = new File(fileName); 
            
            // Turn file into an Image
            img = ImageIO.read(inputFile); 

            // Construct array to hold image
            image = new int[img.getHeight()][img.getWidth()];

            // Loop through each pixel
            for (int y = 0; y < img.getHeight(); y++) 
            {
                for (int x = 0; x < img.getWidth(); x++) 
                {
                    // Turn the pixel into a Color object.
                    Color pixel = new Color(img.getRGB(x, y), true);
                    // Converts each pixel to a grayscale equivalent // using weightings on each colour. 
                    image[y][x] = (int)((pixel.getRed() * 0.299) + (pixel.getBlue() * 0.587) + (pixel.getGreen() * 0.114));
                } 
            }
        }
        catch(NullPointerException e)
        {
            throw new NullPointerException("Are you sure its a .png file?");
        }
        catch(IOException e) 
        {
            throw new IOException("Error with .png reading!" );
        }
        return image; 
    }

    /*************************************************************************
     * NAME: writePNG
     * IMPORTS: filename (String), writeArray (2D Array of Integers)
     * EXPORTS: none
     * PURPOSE: writes a 2D Array of Integers to a file with the given filename
     * **********************************************************************/
    public static void writePNG(String fileName, int[][] writeArray) 
    {
        // The following is very Java specific and is implemented in a way to 
        // // reconstruct a colour image from a set of 8bit colours. 
        BufferedImage theImage;
        File outputfile;
        try
        {
            // Open the file
            outputfile = new File(fileName);

            // Construct a BufferedImage, with dimensions and of type RGB
            theImage = new BufferedImage(writeArray[0].length, writeArray.length, BufferedImage.TYPE_INT_RGB);

            // This will step through each element of our "writeArray"
            for(int y = 0; y < writeArray.length; y++) 
            {
                for (int x = 0; x < writeArray[0].length; x++) 
                {
                    // This will ensure that we are only putting a value into // our png, between 0 and 255. (8bit colour depth) 
                    int value = Math.abs(writeArray[y][x] % 256);
                    // Turns the greyscale pixel to a "colour" representation
                    Color newColor = new Color(value, value, value);
                    // This will set the value of the pixel within the .png
                    theImage.setRGB(x, y, newColor.getRGB()); }
                }
        // Write the image to a .png
        ImageIO.write(theImage,"png",outputfile); 
        }
        catch(IOException e) 
        {
            UserInterface.displayError("Error with .png reading: " + e.getMessage());
            // Alternatively you could rethrow an IllegalArgumentException
                
        }
    }

    /*************************************************************************
     * NAME: fileNamingConvention
     * IMPORTS: filename (String), extension(String)
     * EXPORTS: concatenatedFileName (String)
     * PURPOSE: uses the Date class, a user entered base filename, and filetype
     *          extension string to concatenate a new filename
     * ASSERTION: will loop until if an invalid date is entered
     * **********************************************************************/
    public static String fileNamingConvention(String filename, String extension)
    {
        boolean valid = false;
        int digit;

        // new date object
        Date newDate = null;
        do
        {
            try
            {
                // although 8 digits asked a user might enter something like 01xxxxxx, which as an integer is the same as 1xxxxxxxx
                digit = UserInterface.userInput("Please enter an 8 digit Date to save with: ", 1000000, 99999999);
                newDate = new Date(digit);
                valid = true; // if the date is invalid an exception will be thrown and do while will loop again
            }
            catch(Exception e)  // illegalArgument exception
            {
                UserInterface.displayError(e.getMessage());
            }
        }while(!valid);

        // accesing Date classfields(Integers) and storing them as Strings
        String day = Integer.toString(newDate.getDay());
        String month = Integer.toString(newDate.getMonth());
        String year = Integer.toString(newDate.getYear());

        // processing the string
        String concatenatedFilename = (year + "-" + month + "-" + day + "_Processed_" + filename + extension ); 
        return concatenatedFilename;
    }
}
