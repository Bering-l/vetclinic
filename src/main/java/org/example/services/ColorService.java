package org.example.services;

import org.example.entity.Color;
import org.example.repository.ColorRepository;

public class ColorService {
    private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public void addColor(Color color) {
        colorRepository.save(color);
    }
}
