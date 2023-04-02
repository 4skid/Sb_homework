package ru.skillbox;

public class Country {
    private String name;
    private int popSize;
    private int countryArea;
    private String capitalName;
    private Boolean SeaAccess;


    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopSize() {
        return popSize;
    }

    public void setPopSize(int popSize) {
        this.popSize = popSize;
    }

    public int getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(int countryArea) {
        this.countryArea = countryArea;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public Boolean getSeaAccess() {
        return SeaAccess;
    }

    public void setSeaAccess(Boolean seaAccess) {
        SeaAccess = seaAccess;
    }

    public void print () {
        System.out.println("Страна: " + getName());
        System.out.println("Население: " + getPopSize());
        System.out.println("Площадь страны: " + getCountryArea());
        System.out.println("Столица: " + getCapitalName());
        System.out.println("Граница с морем: " + getSeaAccess() );
    }
}

