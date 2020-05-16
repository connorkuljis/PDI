import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class v2Reader
{
    public static void main(String[] args) throws Exception
    {
        // get the file name
        // String fileName = UserInterface.userInput("Enter the file name: ");
        // Student[] studentArray = readFile(fileName);
        // calcAverage(studentArray);
        // viewStudents(studentArray);

        boolean close = false;
        do
        {


        }while(!close);
    }

    public static void menu()
    {
        System.out.println("### Student CSV Reader ###\n"); 
        boolean close = false;
        do
        {
            int choice = UserInterface.userInput("\nEnter Select an option:\n1. Import Students's\n2. Calculate assesments average\n3. View all students\n0. Exit", 0, 3);
            switch(choice)
            {
                case 1:
                    String fileName = UserInterface.userInput("Enter the file name: ");
                    Student[] studentArray = readFile(fileName);
                    break;
                case 2:
                    // calculate average assessment mark
                    // calcAverage(studentArray);
                    break;
                case 3:
                    // studentArray = readFile("students.csv");
                    // viewStudents(studentArray);
                    break;
                case 0:
                    close = true;
                    break;
            }
        } while(!close);
    }

    private static Student[] readFile(String inFileName) 
    {
        int lineNum;
        String line;
        String[] stringArray = new String[20];

        try
        {
            FileInputStream fileStream = new FileInputStream(inFileName);
            InputStreamReader reader = new InputStreamReader(fileStream);
            BufferedReader bufReader = new BufferedReader(reader);
            lineNum = 0;
            line = bufReader.readLine();
            while(line != null)
            {
                lineNum++;
                line = bufReader.readLine();
                processLine(line, lineNum, stringArray);
            }
            fileStream.close();
            System.out.println("Succesfully Imported the File!"); 
        }
        catch(IOException e)
        {
            System.out.println("Error in file processing: " + e); 
        }

        Student[] studentArray = storeObjects(stringArray);
        return studentArray;
    }

    public static void processLine(String csvRow, int lineNum, String[] stringArray)
    {
        lineNum -= 1;
        stringArray[lineNum] = csvRow;
    }

    public static Student[] storeObjects(String[] stringArray)
    {
        Student[] studentArray = new Student[20];

        String name;
        int studentID;
        double mark;

        String[] splitLine;

        for(int i = 0; i < stringArray.length; i++)
        {
            if (stringArray[i] != null)
            {
                splitLine = stringArray[i].split(",");
                name = splitLine[0];
                studentID = Integer.parseInt(splitLine[1]);
                mark = Double.parseDouble(splitLine[2]);

                if(validStudent(name, studentID, mark))
                {
                    Student tempStudent = new Student(name, studentID, mark); 
                    studentArray[i] = tempStudent;
                }
            }
        }
        return studentArray;
    }

    public static boolean validStudent(String name, int studentID, double mark)
    {
        boolean validName = !(name.equals(""));
        boolean validStudentID = ((studentID >= 10000000) && (studentID <= 99999999));
        boolean validMark = ((mark >= 0.0) && mark <= 100.0);
        return ((validName) && (validStudentID) && (validMark));
    }

    public static double calcAverage(Student[] studentArray)
    {
        int count = 0;

        for(int i = 0; i < studentArray.length; i++)
        {
            if(studentArray[i] != null)
            {
                count++;
            }
        }

        double[] results = new double[count];
        for(int i = 0; i < studentArray.length; i++)
        {
            if(studentArray[i] != null)
            {
                results[i] = studentArray[i].getMark();
            }
        }
        System.out.println("Average mark is : " + PDIMath.average(results));
        return PDIMath.average(results);
    }

    public static void viewStudents(Student[] studentArray)
    {
        for(int i = 0; i < studentArray.length; i++)
        {
            if(studentArray[i] != null)
            {
                Student temp = studentArray[i];
                System.out.println(temp.getName() + " (" + temp.getStudentID() + ") scored " + temp.getMark() + "%");
            }
        }

    }
}



















