import java.util.*;
import java.io.*;
import java.awt.*; 
import java.awt.image.*; 
import javax.imageio.*;
 
public class FileIO
{
    
    public static int[][] readFile(String fileName)
    {
        // Attempts to open the file and read its contents into a 2D array and return that to the caller
        // we know to construct the 2d array IF
        //     I want to scan through each line and check that each row has the same amount of elements, this will give me the number of columns. 
        //     If the amount of elements are different (ragged) do not construct the array
        //     Then to get the number of rows count each row 

        String line = "";
        int lineNum = 0, totalRows;
        int[][] parsedArray = null;

        try
        {
            totalRows = getNumRowsInFile(fileName); // get number of lines in file

            String[] stringArray = new String[totalRows]; // making a right sized array to number of lines

            // reading the text to a String array
            FileInputStream fileStream = new FileInputStream(fileName);
            InputStreamReader reader = new InputStreamReader(fileStream);
            BufferedReader bufReader = new BufferedReader(reader);
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
                throw new IllegalArgumentException("Array rows differ in size!");
            }
            // int[][] testArray = parseStringToInt(stringArray, totalRows);

            parsedArray = parseStringToInt(stringArray, totalRows);
        }
        catch(IOException e)
        {
            System.out.println("Error in file processing " + e);
        }
        return parsedArray;
    }

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
                // System.out.println(i + ", " + count + "= " + element); 
            }
            count = -1;
        }
        return parsedArray;
    }

    /*
     * attempts to write a 2D array to a file
     *
     *
     */
    public static void writeFile(String fileName, int[][] writeArray)
    {
        String[] stringArray = new String[writeArray.length];
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
                    if(j == writeArray[0].length - 1)
                    {
                        line += String.valueOf(writeArray[i][j]);
                    }
                    else
                    {
                        line += String.valueOf(writeArray[i][j] + ",");
                    }
                }
                pw.println(line); 
                line = "";
            }
            // pw.println(id + "," + name + "," + assign + "," + test + "," + exam + "," + overall); 
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
































}
