//package com.example.glowhockey;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import static com.example.glowhockey.GameActivity.deviceWidth;
//
//
//class Goal extends Objects {
//    private int score;
//
//    Goal(float x, float y, Table table) {
//        super(x, y, Bitmap.createScaledBitmap(BitmapFactory.decodeResource(table.getResources(), R.drawable.ball),(int) deviceWidth / 2, 10, true));
//        score = 0;
//    }
//
//    int getScore() {
//        return score;
//    }
//
//    /**
//     * Increase the score by 1
//     */
//    void incScore() {
//        score++;
//    }
//
//}
//
