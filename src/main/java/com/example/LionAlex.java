package com.example;

import java.util.List;

public class LionAlex extends Lion{

    private final List<String> friends = List.of("Марти", "Глория", "Мелфан");
    final String placeOfLiving = "Нью-Йоркский зоопарк";
    private final Feline feline;

    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
        this.feline = feline;
    }

    public List<String> getFriends(){
        return friends;
    }

    public String getPlaceOfLiving(){
        return placeOfLiving;
    }

    @Override
    public int getKittens() {
        return feline.getKittens(0);
    }


}
