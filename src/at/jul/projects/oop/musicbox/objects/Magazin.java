package at.jul.projects.oop.musicbox.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Magazin {
    private String name;

    private List<Plate> plates;

    public Magazin(String name) {
        this.name = name;
        this.plates = new ArrayList<>();
    }

    public void addRecord(Plate plate) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Neue Platte designen = 1; Vorhandene einsetzten = 2");
        int desideWhichWay = scanner.nextInt();

        if (desideWhichWay == 1) {
            Plate selfDesign = designNewPlate(scanner);
            plates.add(selfDesign);
            getPlateInfo(selfDesign);

        } else if (desideWhichWay == 2) {
            plates.add(plate);
            getPlateInfo(plate);
        } else {
            System.out.println("Fehler");
            return;
        }

    }

    public void removePlate(Plate plate) {
        plates.remove(plate);
        System.out.println("Platte wurde gelöscht oder nicht gefunden.");
    }

    public void searchPlate(Plate plate) {
        for (int i = 0; i < plates.size(); i++) {
            if (plate.getTitle() == plates.get(i).getTitle() || plate.getId() == plates.get(i).getId()) {
                System.out.println("Platte wurde gefunden.");
                plate.getPlateInfo();
            } else {
                System.out.println("Platte nicht vorhanden");
            }
        }
    }

    public double getSumOfMusic() {
        double lenghtOfMagazin = 0;
        for (int i = 0; i < plates.size(); i++) {
            lenghtOfMagazin += plates.get(i).getSumOfMusic();
        }
        return lenghtOfMagazin;
    }

    private void getPlateInfo(Plate plate) {
        plate.getPlateInfo();
    }


    private Plate designNewPlate(Scanner scanner) {
        System.out.println("name");
        String plateName = scanner.next();
        System.out.println("id");
        String plateId = scanner.next();

        Plate selfDesign = new Plate(plateName, plateId);

        System.out.println("Wie viele Titel hat die Platte?");
        int amountOfTitles = scanner.nextInt();
        for (int i = 0; i < amountOfTitles; i++) {
            System.out.println("Name");
            String nameOfTitle = scanner.next();
            System.out.println("Länge");
            double lenghtOfTitle = scanner.nextDouble();

            Title title = new Title(nameOfTitle, lenghtOfTitle);
            selfDesign.addTitle(title);
        }
        return selfDesign;
    }
}