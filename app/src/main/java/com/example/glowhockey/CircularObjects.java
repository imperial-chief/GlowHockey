package com.example.glowhockey;

import android.graphics.Bitmap;

public abstract class CircularObjects extends Objects {

    float centerPointX, centerPointY, radius;

    float mass;

    CircularObjects(float x, float y, float mass, Bitmap bmp) {
        super(x - (float) bmp.getWidth() / 2, y - (float) bmp.getHeight() / 2, bmp);
        this.mass = mass;
        radius = (float) bmp.getWidth() / 2;
        centerPointX = x + radius;
        x -= radius;
        centerPointY = y + radius;
        y -= radius;
    }

    float getCenterPointX() {
        return centerPointX;
    }
    public float getCenterPointY() {
        return centerPointY;
    }

    @Override
    public void setX(float x) {
        super.setX(x - radius);
        centerPointX = x + radius;
    }

    @Override
    public void setY(float y) {
        super.setY(y - radius);
        centerPointY = y + radius;
    }

    float distanceFrom(CircularObjects other) {
        centerPointX = this.getX() + this.radius;
        centerPointY = this.getY() + this.radius;
        other.centerPointX = other.getX() + other.radius;
        other.centerPointY = other.getY() + other.radius;
        return (float) Math.sqrt(
                (centerPointX - other.centerPointX) *
                        (centerPointX - other.centerPointX)
                        + (centerPointY - other.centerPointY) *
                        (centerPointY - other.centerPointY));
    }

}


