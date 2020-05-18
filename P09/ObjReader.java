import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ObjReader
{
    public static Student[] readFile(String filename)
    {
        Student[] studentArray = null; // studentArray must be the size of all valid students, cannot exceed 20
        String[] stringArray = null;
        int validCount = 0; 

        // ### COUNTING THE NUMBER OF VALID STUDENTS ###
        // pre-read the file and construct the object, if it is valid increment the count, use this count to construct the array of objects
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) // error will be thrown here
            {
                String line = scan.nextLine();

                String[]sLine = line.split(",");
                String name = sLine[0];
                int studentID = Integer.parseInt(sLine[1]);
                double mark = Double.parseDouble(sLine[2]);
                try
                {
                    Student studentObj = new Student(name, studentID, mark);
                    validCount++;
                }
                catch(Exception e)
                {
                    System.out.println("Could not contruct student: " + e.getMessage()); 
                }
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println(e); 
        }

        // ### CREATING THE STUDENT ARRAY (ARRAY OF STUDENTS OF SIZE validCount)
        studentArray = new Student[validCount];

        // ## INSERTING THE VALID STUDENTS INTO THE ARRAY
        int index = 0;
        try
        {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) // error will be thrown here
            {
                String line = scan.nextLine();

                String[]sLine = line.split(",");
                String name = sLine[0];
                int studentID = Integer.parseInt(sLine[1]);
                double mark = Double.parseDouble(sLine[2]);
                try
                {
                    Student studentObj = new Student(name, studentID, mark);
                    studentArray[index] = studentObj;
                    index++;
                }
                catch(Exception e)
                {
                }
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println(e); 
        }

        return studentArray;
    }

    public static void calcAverage(Student[] studentArray)
    {
        double avg = 0;
        int count = 0;
        for(int i = 0; i < studentArray.length; i++)
        {
            if(studentArray[i] != null)
            {
                avg += studentArray[i].getMark();
                count ++;
            }
        }
        avg = avg / count;
        System.out.println("Average: " + avg); 
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

   
