import java.util.*;
public class ImageTestHarness
{
    public static void main(String[] args)
    {
        Image a = new Image();
        System.out.println(a.toString());

        Image b = new Image(Convolute.MATRIX_B, Kernel.VERTICAL);
        System.out.println(b.toString());
        System.out.println(b.getOriginalImage());

    }
}
