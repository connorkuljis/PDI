import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader
{
    public static void main(String[] args) throws Exception
    {
        menu();
    }

    public static void menu()
    {
        System.out.println("### Student CSV Reader ###\n"); 
        boolean close = false;
        do
        {
            int choice = UserInterface.userInput("Enter Select an option:\n1. Import Students's\n2. Calculate assesments average\n3. View all students\n0. Exit", 0, 3);
            switch(choice)
            {
                case 1:
                    readFile("students.csv");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    close = true;
                    break;
            }
        } while(!close);
    }

    private static void readFile(String inFileName) 
    {
        File file = new File(inFileName);    // creating a new file object
        String[] fileString = new String[20]
        try
        {
            Scanner inputStream = new Scanner(file); // creating a scanner object called inputStream from the file object
            while(inputStream.hasNext())   // its it not the end of the file
            {
                String data = inputStream.nextLine(); // scan in the data of the line
                //processLine(data);                    // and send it to processing 

            }
            inputStream.close();
        }
        catch(FileNotFoundException e)
        {
           System.out.println("Error! File not found: " + e);
        }
    }

    private static void processLine(String csvRow)
    {
        String name;
        int studentID;
        double mark;

        // System.out.println(csvRow); 
        String[] splitLine;
        splitLine = csvRow.split(",");

        name = splitLine[0];
        studentID = Integer.parseInt(splitLine[1]);
        mark = Double.parseDouble(splitLine[2]);

        createStudent(name, studentID, mark);
    }

    public static void createStudent(String name, int studentID, double mark)
    {
        Student[] studentArray = new Student[20];
    }



}



















