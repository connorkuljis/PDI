/*****************************************************************************
 * FILE: Student.java
 * AUTHOR: Connor Kuljis 19459138
 * UNIT: PDI Sem 1 2020
 * PURPOSE: a "Student" Class that will be able to store a
 * students name, as well as 1 of their Test Marks
 * DATE: 11th May 2020
 *****************************************************************************/

import java.util.*;

public class Student
{
    // class fields
    private String name;
    private int studentID;
    private double mark;

    // default constructor
    public Student()
    {
        name = "John Smith";
        studentID = 0;
        mark = 0.0;
    }

    // alternate constructor
    public Student(String inName, int inStudentID, double inMark)
    {
        setName(inName);
        setStudentID(inStudentID);
        setMark(inMark);
    }

    // copy constructor
    public Student(Student inStudent)
    {
        name = inStudent.getName();
        studentID = inStudent.getStudentID();
        mark = inStudent.getMark();
    }

    // mutators
    public void setName(String inName)
    {
        if (validString(inName))
        {
            name = inName;
        }
        else
        {
            throw new IllegalArgumentException("Not a valid name, it cannot be empty");
        }
    }

    public void setStudentID(int inStudentID)
    {
        if (validStudentID(inStudentID))
        {
            studentID = inStudentID;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid StudentID");
        }
    }

    public void setMark(double inMark)
    {
        if (validMark(inMark))
        {
            mark = inMark;
        }
        else 
        {
            throw new IllegalArgumentException("Invalid Mark");
        }
    }

    // accessors
    public String getName()
    {
        return name;
    }

    public int getStudentID()
    {
        return studentID;
    }

    public double getMark()
    {
        return mark;
    }

    // toString
    public String toString()
    {
        return ("Name: " + name + ", StudentID: " + studentID + ", Mark: " + mark);
    }
    // equals
    // two objects are the same if their name, studentID and 
    public boolean equals(Object inObj)
    {
        boolean same = false;
        if (inObj instanceof Student)
        {                          
            Student inStudent = (Student) inObj;
            same = (name.equals(inStudent.getName()) 
                    && studentID == inStudent.getStudentID()
                    && mark == inStudent.getMark());
        }
        return same;
    }
    // clone
    public Student clone()
    {
        return new Student(this);
    }

    // String getGrade() - returns grade of mark
    public String getGrade()
    {
        String grade;
        int roundedMark;

        roundedMark = (int) mark / 10;
        switch(roundedMark)
        {
            case 10: case 9: case 8:
                grade = "H";
                break;
            case 7:
                grade = "D";
                break;
            case 6:
                grade = "C";
                break;
            case 5:
                grade = "P";
                break;
            default:
                grade = "F";
                break;
        }
        return grade;
    }
    // String toFileString() - returns the object reconstructed into its CSV equivalent
    public String toFileString()
    {
        return (name + "," + studentID + "," + mark);
    }
    // validString
    public boolean validString(String inName)
    {
        return ((inName == null) || (inName.equals("")));
    }
    
    public boolean validStudentID(int inStudentID)
    {
        return ((inStudentID >= 10000000) && (inStudentID <= 99999999));
    }

    public boolean validMark(double inMark)
    {
        return ((inMark >= 0.0) && (inMark <= 100.0));
    }
}
