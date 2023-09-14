package com.example.glowhockey;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import static com.example.glowhockey.GameActivity.deviceWidth;
import static com.example.glowhockey.GameActivity.deviceHeight;
public class Player extends CircularObjects {

    private Table table;
    private Bitmap glowBitmap, regularBitmap, victoryBitmap;
    private boolean isWinner;
    private int score;
    Player(float x, float y, Table table, int colour) {
        super(x, y, 2.5f,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.player2), (int) ((deviceWidth)*200.0/1080.0), (int) ((deviceWidth)*200.0/1080.0), true));
        this.table = table;
        this.score = 0;
        this.isWinner = false;
        this.glowBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.player2glow), (int) ((deviceWidth)*220.0/1080.0), (int) ((deviceWidth)*220.0/1080.0), true);
        this.regularBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.player2), (int) ((deviceWidth)*200.0/1080.0), (int) ((deviceWidth)*200.0/1080.0), true);
        this.victoryBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.p2wins), (int) ((deviceWidth)*282.0/360.0), (int) ((deviceHeight)*100.0/640.0), true);
    }
    Player(float x, float y, Table table) {
        super(x, y, 2.5f,Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.player1), (int) ((deviceWidth)*200.0/1080.0), (int) ((deviceWidth)*200.0/1080.0), true));
        this.table = table;
        this.score = 0;
        this.isWinner = false;
        this.glowBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.player1glow), (int) ((deviceWidth)*220.0/1080.0), (int) ((deviceWidth)*220.0/1080.0), true);
        this.regularBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.player1), (int) ((deviceWidth)*200.0/1080.0), (int) ((deviceWidth)*200.0/1080.0), true);
        this.victoryBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.p1wins), (int) ((deviceWidth)*282.0/360.0), (int) ((deviceHeight)*100.0/640.0), true);
    }

    Bitmap getGlowBitmap(){ return this.glowBitmap ;}

    Bitmap getRegularBitmap(){ return this.regularBitmap ;}
    Bitmap getVictoryBitmap() { return this.victoryBitmap; }
    void incScore(){ score++; }
    int getScore() {
        return score;
    }
    boolean isWinner() {
        return isWinner;
    }

    void win() {
        isWinner = true;
    }
}
