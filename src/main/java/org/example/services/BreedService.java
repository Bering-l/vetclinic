package org.example.services;

import org.example.entity.Breed;
import org.example.entity.Color;
import org.example.repository.BreedRepository;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BreedService {

    private final BreedRepository breedRepository;
    private final ColorService colorService;

    public BreedService(BreedRepository breedRepository, ColorService colorService) {
        this.breedRepository = breedRepository;
        this.colorService = colorService;
    }

    public void addCatBreedsFromInput() {
        Scanner scanner = new Scanner(System.in);
        String continueInput;

        do {
            System.out.print("Введите название породы кошки: ");
            String breedName = scanner.nextLine();

            Breed newBreed = new Breed();
            newBreed.setBreedName(breedName);

            System.out.print("Введите количество окрасов для этой породы: ");
            int numberOfColors = Integer.parseInt(scanner.nextLine());
            Set<Color> colors = new HashSet<>();

            for (int i = 0; i < numberOfColors; i++) {
                System.out.print("Введите окрас #" + (i + 1) + ": ");
                String colorName = scanner.nextLine();
                Color color = new Color();
                color.setColorName(colorName);
                colors.add(color);
                colorService.addColor(color);
            }

            newBreed.setColors(colors);
            breedRepository.save(newBreed);
            System.out.println("Порода " + breedName + " успешно добавлена с окрасками.");

            System.out.print("Хотите добавить еще одну породу? (да/нет): ");
            continueInput = scanner.nextLine().trim().toLowerCase();
        } while (continueInput.equals("да"));

        scanner.close();
    }
}