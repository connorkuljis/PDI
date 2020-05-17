import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StudentReader
{
    public static void main(String[] args)
    {
        /*
        Student[] st = readFile("invalid.csv");
        calcAverage(st);
        viewStudents(st); */
        boolean close = false;
        Student[] studentArray = null;
        do
        {
            int choice = UserInterface.userInput("\nSelect an option:\n1. Import Students's\n2. Calculate assesments average\n3. View all students\n0. Exit", 0, 3);
            switch(choice)
            {
                case 1:
                    String filename = UserInterface.userInput("Enter the file name: ");
                    studentArray = readFile(filename);
                    break;
                case 2:
                    if(studentArray != null)
                    {
                        calcAverage(studentArray);
                    }
                    else
                    {
                        System.out.println("Error! Empty file."); 
                    }
                    break;
                case 3:
                    if(studentArray != null)
                    {
                        viewStudents(studentArray);
                    }
                    else
                    {
                        System.out.println("Error! Empty file."); 
                    }
                    break;
                case 0:
                    System.out.println("Goodbye"); 
                    close = true;
                    break;
            }
        }while(!close);
    }

    public static Student[] readFile(String filename)
    {
        Student[] studentArray = new Student[20];
        String[] stringArray = null;

        try
        {
            int count = 0;
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) // error will be thrown here
            {
                String data = scan.nextLine();
                count++;
                createStudent(data, count, studentArray);
                System.out.println("constructed!"); 
            }
            scan.close();
        }
        catch (IOException e)
        {
            System.out.println(e); 
        }
        catch(Exception e)
        {
            System.out.println("Error constructing student! " ); 
        }
        return studentArray;
    }

    // void so we can update the studentArray
    public static void createStudent(String line, int count, Student[] studentArray) throws Exception
    {
        Student studentObj = null;
        String[]sLine = line.split(",");
        String name = sLine[0];
        int studentID = Integer.parseInt(sLine[1]);
        double mark = Double.parseDouble(sLine[2]);
        try
        {
            studentObj = new Student(name, studentID, mark);
            studentArray[count] = studentObj;
        }
        catch(Exception e)
        {
            throw new Exception(e);
        }
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

   
