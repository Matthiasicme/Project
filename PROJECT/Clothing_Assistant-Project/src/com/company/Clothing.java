package com.company;

public class Clothing {
    double minTemp;
    double maxTemp;
    boolean isGoodForRain;
    boolean isGoodForSnow;
    boolean isGoodForWind;
    boolean isGoodForSunshine;
    String name;
    private Type type;

    public Clothing() {

    }

    public enum Type{
        HEADGEAR,TORSO,OUTER,GLOVES,LEGS,SHOES,UMBRELLA,
    }

    public Clothing(Type type) {




        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.isGoodForRain = isGoodForRain;
        this.isGoodForSnow = isGoodForSnow;
        this.isGoodForWind = isGoodForWind;
        this.isGoodForSunshine = isGoodForSunshine;
        this.name = name;
        this.type = type;
    }



}
