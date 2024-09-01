/*
 * Devlyn Galvan
 * SDEV200
 * 08/26/2024
 * Module 1 Coding assignment 1
 */

public class Main {
    public static void main(String [] args) {

        // Creating variables used in main
       int counter = 1;
       double foot = 1;
       double meter = 20;
       double convertedFoot = 0;
       double convertedMeter = 0;

       //Creating top of table
       System.out.println("Feet     Meters |   Meters    Feet");
       System.out.println("----------------|-------------------");

       while (counter <= 10){
        
        convertedFoot = footToMeter(foot);
        convertedMeter = meterToFoot(meter);
        System.out.printf("%-8.1f %-7.3f|   %-9.1f %-6.3f\n", foot, convertedFoot, meter, convertedMeter);
        foot++;
        meter = meter + 5;
        counter++;
       }

    }

    //module to conver a foot to meter
    public static double footToMeter(double foot){
        double meter = 0;

        meter = 0.305 * foot;

        return meter;
    }

    //module to converte meter to foot
    public static double meterToFoot(double meter){
        double foot = 0;

        foot = 3.279 * meter;

        return foot;
    }
}

