import java.util.*;
public class variables
{
    public static void main(String[] args)
    {
        String animal = "Elephant";
        double food = 8.684, space = 24.45;
        int staff = 162, cage = 17;

        System.out.println();
        System.out.println((int) food + staff / 100); // 9
        // 

        System.out.println(staff + animal + cage); 
        // 162Elephant17

        System.out.println((int)(space + (double)cage) * 5 - staff % 5);
        // 24.45 + 17.0 = 41.45
        // 41
        // 41 x 5 = 205
        // 205 - 162 % 5
        // 205 - 2 = 203

        System.out.println((cage % 2 == 0) && (staff / 10 < 11) || (food < 7.89));
        // false

        final double TOL = 0.01;
        String apple = "name";
        double banana, cherry, date;
        int eggplant, fig;

        System.out.println(apple.equals("name"));
        // false

        
    }
}
