package at.jul.projects.oop.carsnew.objects;

public class Producer {

    private String country;
    private String name;

    private double rabatt;

    public Producer(String country, String name, double rabatt) {
        this.country = country;
        this.name = name;
        this.rabatt = rabatt;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public double getRabatt() {
        return rabatt;
    }
}
