import java.util.*;
import java.io.*;

public class SearchAndSort
{
    public static void main(String[] args)
    {
        String filename = "students7000.csv";
        Student[] stArr = FileIO.readStudentFile(filename);

        // linearSearch("Lawrence Cherry", stArr);
        
        // bubbleSort(stArr);
        
        insertionSort(stArr);
        
        // selectionSort(stArr);
    }

    public static void linearSearch(String target, Student[] myArr)
    {
        int ii = 0;
        int matchIdx = -1;
        while((ii < myArr.length) && (matchIdx == -1))
        {
            if(myArr[ii].getName().compareToIgnoreCase(target) == 0)  // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#compareTo-java.lang.String-
            {
                matchIdx = ii;
            }
            else
            {
                ii++;
            }
        }
        System.out.println("Found: " + target + " at index: " + matchIdx + "\n\t" + myArr[matchIdx]); 
    }

    public static Student[] bubbleSort(Student[] myArray)
    {
        int pass = 0;
        boolean sorted;
        do
        {
            sorted = true;
            for(int ii = 0; ii < (myArray.length - 1 - pass); ii++)
            {
                if (myArray[ii].getName().compareTo(myArray[ii+1].getName()) > 0) // < 0 will sort in descending order (Z - A) 
                {
                    Student temp = myArray[ii];
                    myArray[ii] = myArray[ii+1];
                    myArray[ii+1] = temp;
                    sorted = false;
                }
            }
            pass++;
        }while(!sorted);
        return myArray;
    }

    public static void insertionSort(Student[] myArray)
    {
        for (int nn = 1; nn < myArray.length; nn ++) // had .length -1 causing last number to not be sorted 
        {
            int ii = nn;
            while (ii > 0 && myArray[ii - 1].getName().compareTo(myArray[ii].getName()) > 0)
            {
                Student temp = myArray[ii];
                myArray[ii] = myArray[ii - 1];
                myArray[ii - 1] = temp;
                ii--;
            }
        }
        UserInterface.printArray(myArray);
    }

    public static Student[] selectionSort(Student[] myArray)
    {
        for (int n = 0; n < myArray.length - 1; n++)
        {
            int minIdx = n;
            for (int j = n + 1; j < myArray.length; j++)
            {
                if (myArray[j].getName().compareTo(myArray[minIdx].getName()) < 0)
                {
                    minIdx = j;
                }
            }
            Student temp = myArray[minIdx];
            myArray[minIdx] = myArray[n];
            myArray[n] = temp;
        }
        return myArray;
    }
}
