import java.util.*;
import java.io.*;

public class SearchAndSort
{
    public static void main(String[] args)
    {
        String filename = "students7000.csv";
        Student[] stArr = FileIO.readStudentFile(filename);

        linearSearch("Lawrence Cherry", stArr);

        System.out.println(""); 

        bubbleSort(stArr);

        System.out.println(""); 

        Student[] sortedArray = insertionSort(stArr);

        System.out.println(""); 
        
        selectionSort(stArr);

        System.out.println(""); 
        
        binarySearch("Julio Degroat", sortedArray);
    }

    /* NAME: linearSearch
     * IMPORTS: target (String), myArr (ARRAY OF Student Objects)
     * EXPORTS: none
     * PURPOSE: search through each element starting from index 0 and looping untill matchIdx is flagged
     */
    public static void linearSearch(String target, Student[] myArr)
    {
        long startTime = System.nanoTime();
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

        long endTime = System.nanoTime();
        int total = (int)((double)(endTime - startTime) / 1000.0);
        System.out.println("LINEAR SEARCH: " + total); 
    }

    /* NAME: bubbleSort
     * IMPORTS: myArray(ARRAY of Student Objects)
     * EXPORTS: myArray(ARRAY OF Student Objects) - sorted in alphabetical order
     * PURPOSE: sorts an array by swapping values that are out of place on each pass
     */
    public static Student[] bubbleSort(Student[] myArray)
    {
        long startTime = System.nanoTime();
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
        long endTime = System.nanoTime();
        int total = (int)((double)(endTime - startTime) / 1000.0);
        System.out.println("BUBBLE SORT: " + total); 
        return myArray;
    }

    /* NAME: insertionSort
     * IMPORTS: myArray(ARRAY OF STUDENT OBJECTS)
     * EXPORTS: myArray(ARRAY OF Student Objects) - sorted in alphabetical order
     * PURPOSE: left (sorted) vs right (unsorted)
     */
    public static Student[] insertionSort(Student[] myArray)
    {
        long startTime = System.nanoTime();
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
        long endTime = System.nanoTime();
        int total = (int)((double)(endTime - startTime) / 1000.0);
        System.out.println("INSERTION SORT: " + total); 
        return myArray;
    }

    /* NAME: selectionSort
     * IMPORTS: myArray(ARRAY OF Student Objects)
     * EXPORTS: myArray(ARRAY OF Student Objects) - sorted in alphabetical order
     * PURPOSE: sorting by scanning the array for the smallest value and sorting them that way
     */
    public static Student[] selectionSort(Student[] myArray)
    {
        long startTime = System.nanoTime();
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
        long endTime = System.nanoTime();
        int total = (int)((double)(endTime - startTime) / 1000.0);
        System.out.println("SELECTION SORT: " + total); 
        return myArray;
    }

    /* NAME: binarySearch
     * IMPORTS: target (String), myArr (ARRAY OF Student Objects)
     * EXPORTS: none
     * PURPOSE: search through each element starting from index 0 and looping untill matchIdx is flagged
     */
    public static void binarySearch(String target, Student[] myArray)
    {
        long startTime = System.nanoTime();
        int left = 0;
        int right = myArray.length;
        boolean found = false;

        while(left <= right && !found)
        {
            int middle = (left + right) / 2;
            if(myArray[middle].getName().compareToIgnoreCase(target) < 0) // string is greater than
            {
                left = middle + 1;
            }
            else if(myArray[middle].getName().compareToIgnoreCase(target) > 0) // string is less than
            {
                right = middle - 1;
            }
            else
            {
                System.out.println("Found: " + target + " at index: " + middle + "\n\t" + myArray[middle]); 
                found = true;
            }
        }

        long endTime = System.nanoTime();
        int total = (int)((double)(endTime - startTime) / 1000.0);
        System.out.println("BINARY SEARCH: " + total); 
    }
}
