package com.company;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static String GEO_DECODE_API_KEY;
    public static String OPEN_WEATHER_API_KEY;


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Assistant assistant = new Assistant();


       int option;
       do{

           System.out.println("Hi here is your Clothing Assistant");
           System.out.println("You have that options: ");
           System.out.println("1 - Add locations");
           System.out.println("2 - Check what you should wear now");
           System.out.println("3 - Check what you should wear tomorrow");
           System.out.println("4 - What should you wear in some other location");
           System.out.println("5 - plan a trip");
           System.out.println("0 - exit");

           option =scanner.nextInt();

           switch (option){

               case 1: assistant.addLocations(); break;
               case 2: assistant.whatWearNow(); break;
               case 3: assistant.whatWearTomorrow();break;
               case 4: assistant.whatWearSomewhere(); break;
               case 5: assistant.planTrip(); break;
               case 0: break;
               default:
                   System.out.println("It's not a valid option");
           }


       }while (option!=0);

    }
}
