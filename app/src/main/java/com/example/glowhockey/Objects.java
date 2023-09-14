package com.example.glowhockey;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class Objects {

    float x, y;
    private Bitmap bitmap;

    Objects(float x, float y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setBitmap(Bitmap bmp) { this.bitmap = bmp; }
    void draw(Canvas c) {
        c.drawBitmap(bitmap, x, y, null);
    }
}

