// FILE: PondCalculator
// AUTHOR: Connor Kuljis
// ID: 1945138
// UNIT: PDI
// PURPOSE: calculating how many animals can be stored based on the volume of water
// LAST MOD: 26/04/2020

import java.util.*;
public class PondCalculator
{
    public static void main(String[] args)
    {
        String[] names = getNames();     // lets get the names
        int[] volumes = calcVolumes(names); // lets calculate the volumes of the pool for each person/names

        menu(volumes);
    }

    /* NAME: inputInt
     * IMPORT: prompt, min, max
     * EXPORT: integerValue
     * PURPOSE: returns a valid integer*/
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

    /* NAME: calcVolumes
     * IMPORT: names
     * EXPORT: volumes
     * PURPOSE: gathers the volumes for each person's pool and stores it in an array*/
    public static int[] calcVolumes(String[] names)
    {
        int lengthOfPool, depthOfPool, widthOfPool, volumeOfPool;
        
        int[] volumes = new int[3];
        for(int i=0; i < volumes.length; i++)
        {
            System.out.println(names[i] + "'s pool"); // getting the volume of each persons pool
            lengthOfPool = inputInt("Length: ", 0, 10); 
            widthOfPool = inputInt("Width: " , 0 , 10);
            depthOfPool = inputInt("Depth: ", 0, 10);
            volumeOfPool = lengthOfPool * widthOfPool * depthOfPool;
            volumes[i] = volumeOfPool;
        }
        return volumes;
    }

    // NAME: getNames
    // IMPORT: nothing
    // EXPORT: names
    public static String[] getNames()
    {
        String[] names = {"Joey", "Corey", "Rachel"};
        return names;
    }

    // NAME: getAnimals
    // IMPORT: nothing
    // EXPORT: animals
    public static String[] getAnimals()
    {
        String[] animals = {"Sting Rays", "Arowana", "Koi", "Puffer Fish", "Turtles", "Frogs"};
        return animals;
    }

    // NAME: getRatios
    // IMPORT: nothing
    // EXPORT: ratios
    public static double[] getRatios()
    {
        double[] ratios = {0.5, 0.4, 0.6, 0.8, 1.2, 4.5};
        return ratios;
    }

    // NAME: menu
    // IMPORT: nothing
    // EXPORT: nothing
    // PURPOSE: looping menu for each persons pool
    public static void menu(int[] volumes)
    {
        boolean close = false;
        int person, pondChoice;  
        do
        {
            person = inputInt("\nChoose a person:\n1. Joey\n2. Corey\n3. Rachel\n0. Exit\n", 0, 3);
            switch(person)
            {
                case 1:
                    pondChoice = inputInt("Pick a pond:\n1. Sting Rays\n2. Arowana\n", 1, 2);
                    pondMenu(person, pondChoice, volumes, "his");
                    break;

                case 2:
                    pondChoice = inputInt("Pick a pond:\n1. Koi\n2. Puffer Fish\n", 1, 2);
                    pondMenu(person, pondChoice, volumes, "his");
                    break;

                case 3:
                    pondChoice = inputInt("Pick a pond:\n1. Turtles\n2. Frogs\n", 1, 2);
                    pondMenu(person, pondChoice, volumes, "her");
                    break;

                case 0:
                    close = true;
                    break;
            } 
        } while(!close);
    }

    // NAME: pondMenu
    // IMPORT: person, pondChoice, volumes, pronoun
    // EXPORT: nothing
    // 
    public static void pondMenu(int person, int pondChoice, int[] volumes, String pronoun)
    {
        String[] names = getNames();
        String[] animals = getAnimals();
        double[] ratios = getRatios();

        person = person - 1; // going to decrement by 1 here so person 1 = 0, person 2 = 1, person 3 = 2
        int volume = volumes[person];
        
        String animal, name;
        double numberOfAnimals, ratio;
        int roundedAnimals = 0;
        switch(pondChoice)
        {

            case 1:
                name = names[person];
                animal = animals[person + person];
                ratio = ratios[person + person];
                numberOfAnimals = (double) (volume) / ratio;
                roundedAnimals = (int)(Math.floor(numberOfAnimals));
                System.out.println("\n\t" + name + " can store " + roundedAnimals + " " + animal + " in " + pronoun + " " + volume + "m^3 pond.");
                break;

            case 2:
                name = names[person];
                animal = animals[person * 2 + 1];
                ratio = ratios[person * 2 + 1];
                numberOfAnimals = (double) (volume) / ratio;
                roundedAnimals = (int)(Math.floor(numberOfAnimals));
                System.out.println("\n\t" + name + " can store " + roundedAnimals + " " + animal+ " in " + pronoun + " " + volume + "m^3 pond.");
                break;

            default:
                System.out.println("Error");
        }
    }
}
