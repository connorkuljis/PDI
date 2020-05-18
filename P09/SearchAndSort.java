import java.util.*;
import java.io.*;

public class SearchAndSort
{
    public static void main(String[] args)
    {
        linearSearch("Lawrence Cherry", "students7000.csv");
    }
    public static void linearSearch(String target, String filename)
    {
        Student[] stArr = FileIO.readStudentFile(filename);

        int ii = 0;
        int matchIdx = -1;
        while((ii < stArr.length) && (matchIdx == -1))
        {
            if(stArr[ii].getName().equals(target)) // https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#compareTo-java.lang.String-
            {
                matchIdx = ii;
            }
            else
            {
                ii++;
            }
        }
        System.out.println("Found: " + target + " at index: " + matchIdx + "\n\t" + stArr[matchIdx]); 
    }
}
