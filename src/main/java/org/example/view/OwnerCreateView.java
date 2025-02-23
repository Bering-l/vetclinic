package org.example.view;

import java.util.Scanner;

public class OwnerCreateView {
    private final Scanner scanner;

    public OwnerCreateView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String promptForOwnerRegion() {
        System.out.println("Укажите регион: ");
        return scanner.nextLine();
    }

    public String promptForPostalCode() {
        updateInput();
        System.out.println("Индекс: ");
        return scanner.nextLine();
    }

    public String promptForOwnerCity() {

        System.out.println("Город: ");
        return scanner.nextLine();
    }

    public String promptForOwnerStreet() {
        updateInput();
        System.out.println("Улица: ");
        return scanner.nextLine();
    }

    public int promptForOwnerHouse() {
        System.out.println("Номер дома: ");
        return scanner.nextInt();
    }

    public Integer promptForOwnerBuilding() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return null;
    }

    public Integer promptForOwnerFlat() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return null;
    }

    private void updateInput() {
        scanner.skip(".*\\n");
    }
}
