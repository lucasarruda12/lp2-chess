package com.example.gamerules;

public enum Color {
    BLACK, WHITE;

    public Color opositeColor(){
        if (this == Color.WHITE){
            return Color.BLACK;
        }

        if (this == Color.BLACK){
            return Color.WHITE;
        }

        return Color.WHITE;
    }
}
