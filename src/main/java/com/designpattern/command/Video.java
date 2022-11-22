package com.designpattern.command;

public class Video {

    private String text;
    private float contrast;

    public void removeText() {
         this.text="";
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getContrast() {
        return contrast;
    }

    public void setContrast(float contrast) {
        this.contrast = contrast;
    }
}
