package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Assistant {
    Scanner scanner = new Scanner(System.in);

    Location home;
    Location work;
    List<Location> otherLocations;


    Map<String, Location> locations = new HashMap<>();

    public void addLocations() throws IOException {

        System.out.println("Which location you want to add? (home, work)");
        String decision = scanner.nextLine();
        System.out.println(decision);
         if(this.otherLocations == null){
            this.otherLocations = new ArrayList<>();
         }

         System.out.println("Define your location (eg. by address)");

         String query = scanner.nextLine();
         query = query.replaceAll(" ", "%20");

        String API_URL = "https://nominatim.openstreetmap.org/search/" + query + "?format=json&limit=1";
        JSONArray jsonar = Forecast.readJsonArrayFromUrl(API_URL);
        JSONObject json = jsonar.getJSONObject(0);
        //System.out.println(json.toString()); //wypisuje calego

        Location temp = new Location(json.getString("display_name"), json.getDouble("lat"), json.getDouble("lon"));
        System.out.println("Wybrano " + temp.name);

        if (decision.equals("work")) {
            this.work = temp;

        } else if (decision.equals("home")) {
            this.home = temp;

        } else {
            this.otherLocations.add(temp);
        }

    }



    public void whatWearNow() throws IOException {

        System.out.println("Where are you? ");
        String locationName = scanner.nextLine();
        Location chosenLocation = findLocation(locationName);
        Forecast forecast = new Forecast(chosenLocation, new Date());
        //List<Clothing> clothing = forecast.getClothingList();

        System.out.println("You should wear:");
      /*  for (Clothing cloth : clothing) {
            System.out.println(cloth);
        }*/
    }

    private Location findLocation(String locationName) {
        switch (locationName) {
            case "home":
                return home;
            case "work":
                return work;
            default:
                for (Location l : otherLocations) {
                    if (l.name.equals(locationName)) {
                        return l;
                    }
                }
        }
        return null;
    }



    public void whatWearTomorrow() throws IOException {

        Location work = findLocation("work");
        if (work == null) {
            System.out.println("Sorry you should define work first");
            addLocations();
        } else {
            Date date = new Date();
            //add one day
            Forecast forecast;
            forecast = new Forecast(work);

            // List<Clothing> clothing = forecast.getClothingList();

            System.out.println("You should wear:");
           /* for (Clothing cloth : clothing) {
                System.out.println(cloth);
            }*/

        }

    }

    public void whatWearSomewhere() {
    }

    public void planTrip() {
    }
}
