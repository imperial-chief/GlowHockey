//package com.example.glowhockey;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.media.AudioAttributes;
//import android.media.AudioManager;
//import android.media.SoundPool;
//import android.os.Build;
//import android.view.MotionEvent;
//import android.view.SurfaceView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class GameView extends SurfaceView implements Runnable {
//
//    private Thread thread;
//    private boolean isPlaying = true, isGameOver = false;
//    private int screenX, screenY, score = 0;
//    public static float screenRatioX, screenRatioY;
//    private Paint paint;
//    private SharedPreferences prefs;
//    private Random random;
//    private int sound;
//    private GameActivity activity;
//    private Table table;
//
//    public GameView(GameActivity activity, int screenX, int screenY) {
//
//        super(activity);
//
//        this.activity = activity;
//
//        this.screenX = screenX;
//        this.screenY = screenY;
//        screenRatioX = 1080f / screenX;
//        screenRatioY = 2220f / screenY;
//        table = new Table(getContext(), screenX, screenY, getResources());
//
//        paint = new Paint();
//        paint.setTextSize(128);
//        paint.setColor(Color.WHITE);
//
//
//        random = new Random();
//
//    }
//
//    @Override
//    public void run() {
//
//        while (isPlaying) {
//
////            update ();
//            draw ();
////            sleep ();
//
//        }
//
//    }
//
//    private void update () {
//
//    }
//
//    private void draw () {
//
//        if (getHolder().getSurface().isValid()) {
//
//            Canvas canvas = getHolder().lockCanvas();
//            canvas.drawBitmap(table.background, table.x, table.y, paint);
//
//
//
//            getHolder().unlockCanvasAndPost(canvas);
//
//        }
//
//    }
//
//    private void waitBeforeExiting() {
//
//        try {
//            Thread.sleep(3000);
//            activity.startActivity(new Intent(activity, MainActivity.class));
//            activity.finish();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private void saveIfHighScore() {
//
//        if (prefs.getInt("highscore", 0) < score) {
//            SharedPreferences.Editor editor = prefs.edit();
//            editor.putInt("highscore", score);
//            editor.apply();
//        }
//
//    }
//
//    private void sleep () {
//        try {
//            Thread.sleep(17);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void resume () {
//
//        isPlaying = true;
//        thread = new Thread(this);
//        thread.start();
//
//    }
//
//    public void pause () {
//
//        try {
//            isPlaying = false;
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                if (event.getX() < screenX / 2) {
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//
//        return true;
//    }
//
//}
