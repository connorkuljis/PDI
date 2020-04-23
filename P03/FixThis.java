/*********************************************************
 * Author: Curtin University                             *
 * Purpose: To calculate the final grade of a student    *
 * Last Modified: 7th March. 2020                        *
 *********************************************************/

// Dear future developer, I am not sure what is going wrong with my code.
// can you please fix my errors for me?

import java.util.*;

public class FixThis
{
    // Constants, declared so that I have easy access to them.
    public static final double ASSI_WEIGHT = 0.3;
    public static final double TEST_WEIGHT = 0.3;
    public static final double EXAM_WEIGHT = 0.4;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double testMark, assiMark, examMark, finalGrade, newMark;

        // Prompting the user for their Mark for their Test
        System.out.print("Please enter the mark for your test out of 100: ");
        testMark = sc.nextInt();

        // Prompting the user for their Mark for their Assignment
        System.out.print("Please enter the mark for your assignment out of 100: ");
        assiMark = sc.nextDouble();

        // Prompting the user for their Mark for their Exam
        System.out.print("Please enter the mark for your exam out of 100: ");
        examMark = sc.nextDouble();

        // Calculating each inividual assessment mark based on the Weightings in the Unit Outline
        testMark *= ASSI_WEIGHT;
        assiMark *= TEST_WEIGHT;
        examMark *= EXAM_WEIGHT;

        // Adding each mark together
        finalGrade = testMark + assiMark + examMark;

        //If the user has entered in a total that doesn't calculate correctly
        if(finalGrade > 100.0 || finalGrade < 0.0)
        {
            System.out.println("Error: Invalid Mark");
        }
        else
        {
            //This calculation should get the total mark divided by ten
            newMark = (double)finalGrade / 10;
            int tier = (int)newMark;
            
            //This checks what the final grade is for the student's mark
            String grade;
            switch(tier)
            {
                case 8: case 9: case 10:
                    grade = "HD";
                // missing break
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
            }

            // Prints out the final result to the user.
            System.out.println("Your final mark is: " + finalGrade + " with a grade of " + grade + "-" + tier);
        }
    }
}
