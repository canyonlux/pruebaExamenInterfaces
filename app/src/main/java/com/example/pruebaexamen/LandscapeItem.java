package com.example.pruebaexamen;

public class LandscapeItem {
    private final int imageResourceId;
    private final String name;

    public LandscapeItem(int imageResourceId, String name) {
        this.imageResourceId = imageResourceId;
        this.name = name;
    }

    // Método para obtener el ID del recurso de la imagen
    public int getImageResourceId() {
        return imageResourceId;
    }

    // Método para obtener el nombre del paisaje
    public String getName() {
        return name;
    }
}
