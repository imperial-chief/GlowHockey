package com.example.glowhockey;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import static com.example.glowhockey.GameActivity.deviceWidth;
import static com.example.glowhockey.GameActivity.deviceHeight;

import java.util.Random;

public class Ball extends CircularObjects implements Runnable {

    private float dx, dy;
    private Table table;
    private boolean goal;

    Ball(float x, float y, Table table) {
        super(x, y, 0.5f, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.ball), (int) ((deviceWidth) * 100.0 / 1080.0), (int) ((deviceWidth) * 100.0 / 1080.0), false));
        Thread thread = new Thread(this, "BallThread");
        goal = false;
        this.table = table;
        dx = 0;
        dy = 0;
        thread.start();
    }

    public void run() {


        while (!table.player1.isWinner() && !table.player2.isWinner()) {
            if (!goal) {
                Player p1 = table.player1;
                Player p2 = table.player2;
                Canvas canvas = new Canvas(table.background);
                if (p1 != null && p2 != null) {
                    if ((x >= table.goalStart) && ((x + radius * 2) <= table.goalEnd) && (y <= table.UpperBoundary)) {
                        p1.incScore();
                        dx = 0;
                        dy = 0;
                        centerPointX = deviceWidth / 2;
                        x = centerPointX;
                        centerPointY = table.mid - (((float) (50) / (float) 640) * deviceHeight);
                        y = centerPointY;
                        this.setX(x);
                        this.setY(y);
                        if (p1.getScore() < 7) {
                            goal = true;
                        } else {
                            p1.win();
                            canvas.drawBitmap(p1.getVictoryBitmap(), table.LeftBoundary + table.player1.radius, table.mid - 200, null);
                        }
                    } else if ((x >= table.goalStart) && ((x + radius * 2) <= table.goalEnd) && (y + (radius * 2) >= table.LowerBoundary)) {

                        p2.incScore();
                        dx = 0;
                        dy = 0;
                        centerPointX = deviceWidth / 2;
                        x = centerPointX;
                        centerPointY = table.mid + (((float) (50) / (float) 640) * deviceHeight);
                        y = centerPointY;
                        this.setX(x);
                        this.setY(y);
                        if (p2.getScore() < 7) {
                            goal = true;
                        } else {
                            p2.win();
                            canvas.drawBitmap(p2.getVictoryBitmap(), table.LeftBoundary + table.player1.radius, table.mid - 200, null);
                        }
                    }
                }

                if (x < table.LeftBoundary) {
                    x = table.LeftBoundary;
                    dx = -dx;
                    dx = 9999 * dx / 10000;
                }
                if (x + (radius * 2) > table.RightBoundary) {
                    x = table.RightBoundary - radius * 2;
                    dx = -dx;
                    dx = 9999 * dx / 10000;
                }
                if (y < table.UpperBoundary) {
                    y = table.UpperBoundary;
                    dy = -dy;
                    dy = 9999 * dy / 10000;
                }
                if (y + radius * 2 > table.LowerBoundary) {
                    y = table.LowerBoundary - radius * 2;
                    dy = -dy;
                    dy = 9999 * dy / 10000;
                }

                // Collision with Player1
                if (p1 != null) {
                    if (this.distanceFrom(p1) <= radius + p1.radius) {
//                        table.player1.setBitmap(p1.getGlowBitmap());
//                        p1.draw(canvas);
                        if (dx == 0 && dy == 0) {
                            if (centerPointX > p1.getCenterPointX())
                                dx += (centerPointX - p1.getCenterPointX()) / 20;
                            else if (centerPointX == p1.getCenterPointX()) dx = 0;
                            else dx -= (centerPointX - p1.getCenterPointX()) / 20;

                            if (centerPointY > p1.getCenterPointY()) dy -= (centerPointY - p1.getCenterPointY()) / 30;
                            else if (centerPointY == p1.getCenterPointY()) dy = 0;
                            else dy += (centerPointY - p1.getCenterPointY()) / 30;
                        } else {
                            dx = -dx;
                            dy = -dy;
                            if (centerPointX > p1.getCenterPointX()) dx += 0.1;
                            else if (centerPointX == p1.getCenterPointX()) dx = 0;
                            else dx -= 0.1;

                            if (centerPointY > p1.getCenterPointY()) dy -= 0.1;
                            else if (centerPointY == p1.getCenterPointY()) dy = 0;
                            else dy += 0.1;
                        }
                        while (distanceFrom(p1) <= radius + p1.radius) {
                            x += dx;
                            centerPointX = x + radius;
                            y += dy;
                            centerPointY = y + radius;
                        }
                    }
                }

                // Collision with Player2
                if (p2 != null) {
                    if (this.distanceFrom(p2) <= radius + p2.radius) {
//                        table.player2.setBitmap(p2.getGlowBitmap());
//                        p2.draw(canvas);
                        if (dx == 0 && dy == 0) {
                            if (centerPointX > p2.getCenterPointX())
                                dx += (centerPointX - p2.getCenterPointX()) / 20;
                            else if (centerPointX == p2.getCenterPointX()) dx = 0;
                            else dx -= (centerPointX - p2.getCenterPointX()) / 20;

                            if (centerPointY > p2.getCenterPointY())
                                dy += (centerPointY - p2.getCenterPointY()) / 30;
                            else if (centerPointY == p2.getCenterPointY()) dy = 0;
                            else dy -= (centerPointY - p2.getCenterPointY()) / 30;
                        } else {
                            dx = -dx;
                            dy = -dy;

                            if (centerPointX > p2.getCenterPointX()) dx += 0.1;
                            else if (centerPointX == p2.getCenterPointX()) dx = 0;
                            else dx -= 0.1;

                            if (centerPointY > p2.getCenterPointY()) dy += 0.1;
                            else if (centerPointY == p2.getCenterPointY()) dy = 0;
                            else dy -= 0.1;
                        }
                        while (distanceFrom(p2) <= radius + p2.radius) {
                            x += dx;
                            centerPointX = x + radius;
                            y += dy;
                            centerPointY = y + radius;
                        }
                    }
                }

                x += dx;
                centerPointX += dx;
                y += dy;
                centerPointY += dy;
            } else goal = false;

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}