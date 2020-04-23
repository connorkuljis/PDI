import java.util.*;
public class PondCalculator
{
    public static void main(String[] args)
    {
        String[] names = {"Joey", "Corey", "Rachel"};
        String[] animals = {"Sting Rays", "Arowana", "Koi", "Puffer Fish", "Turtles", "Frogs"};
        int[] volumes = new int[3];
        double[] ratios = {0.5, 0.4, 0.6, 0.8, 1.2, 4.5};

        for(int i=0; i < volumes.length; i++)
        {
            System.out.println(names[i] + "'s pool");
            volumes[i] = calcVolume();
        }
        
        int person, pond, volume;  
        double howManyAnimals;
        String opt1, opt2, name;
        
        boolean close = false;
        int roundedAnimals = 0;

        do
        {
            person = inputInt("\nChoose a person:\n1. Joey\n2. Corey\n3. Rachel ", 0, 3);
            switch(person)
            {
                case 1:
                    name = names[person - 1];
                    volume = volumes[person - 1];

                    pond = inputInt("Pick a pond:\n1. Sting Rays\n2. Arowana ", 1, 2);

                    if (pond == 1)
                    {
                        opt1 = animals[person - 1]; // 0
                        howManyAnimals = (double) (volume) / 0.5;
                        roundedAnimals = (int)(Math.floor(howManyAnimals));
                    }
                    else
                    {
                        opt1 = animals[person];     // 1
                        howManyAnimals = (double) (volume) / 0.4;
                        roundedAnimals = (int)(Math.floor(howManyAnimals));
                    }

                    System.out.println("\n\t" + name + " can store " + roundedAnimals + " " +  opt1 + " in his " + volume + "m^3 pond.");
                    break;

                case 2:
                    name = names[person - 1];
                    volume = volumes[person - 1];

                    pond = inputInt("Pick a pond:\n1. Koi\n2. Puffer Fish", 1, 2);

                    if (pond == 1)
                    {
                        opt1 = animals[person - 1]; // 0
                        howManyAnimals = (double) (volume) / 0.6;
                        roundedAnimals = (int)(Math.floor(howManyAnimals));
                    }
                    else
                    {
                        opt1 = animals[person];     // 1
                        howManyAnimals = (double) (volume) / 0.8;
                        roundedAnimals = (int)(Math.floor(howManyAnimals));
                    }
                    System.out.println("\n\t" + name + " can store " + roundedAnimals + " " +  opt1 + " in his " + volume + "m^3 pond.");
                    break;

                case 3:
                    name = names[person - 1];
                    volume = volumes[person - 1];

                    pond = inputInt("Pick a pond:\n1. Turtles\n2. Frogs", 1, 2);

                    if (pond == 1)
                    {
                        opt1 = animals[person - 1]; // 0
                        howManyAnimals = (double) (volume) / 1.2;
                        roundedAnimals = (int)(Math.floor(howManyAnimals));
                    }
                    else
                    {
                        opt1 = animals[person];     // 1
                        howManyAnimals = (double) (volume) / 4.5;
                        roundedAnimals = (int)(Math.floor(howManyAnimals));
                    }
                    System.out.println("\n\t" + name + " can store " + roundedAnimals + " " +  opt1 + " in her " + volume + "m^3 pond.");
                    break;

                case 0:
                    close = true;
                    break;
            } 
        } while(!close);
    }


    public static int inputInt(String prompt, int min, int max)
    {
        Scanner sc = new Scanner(System.in);
        String outPrompt, errorPrompt;
        int integerValue;

        outPrompt = prompt;
        errorPrompt = "Error value must be between " + min + " and " + max + "\n";
        do
        {
            System.out.print(outPrompt);
            integerValue = sc.nextInt();
            outPrompt = errorPrompt + prompt;
        } while ((integerValue < min) || (integerValue > max));

        return integerValue;
    }

    public static int calcVolume()
    {
        int lengthOfPool, depthOfPool, widthOfPool, volumeOfPool;

        lengthOfPool = inputInt("Length: ", 0, 10); 
        widthOfPool = inputInt("Width: " , 0 , 10);
        depthOfPool = inputInt("Depth: ", 0, 10);

        return volumeOfPool = lengthOfPool * widthOfPool * depthOfPool;
    }
}
