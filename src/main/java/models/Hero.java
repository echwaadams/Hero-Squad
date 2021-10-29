package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private int id;

    public Hero(String name) {
        this.name = name;
        this.id = instances.size();
    }

    public String getName(){
        return name;
    }
    public static ArrayList<Hero> getAll(){
        return instances;
    }
}
