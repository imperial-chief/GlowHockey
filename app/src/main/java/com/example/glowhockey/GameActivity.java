package com.example.glowhockey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    public static final float deviceWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final float deviceHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    Table table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        table = new Table(this);

        setContentView(table);
    }

    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setCoordinates(float xCord, float yCord){
        if(yCord > (table.mid)){
            if((xCord >= (table.LeftBoundary + table.player1.radius)) && (xCord <= (table.RightBoundary - table.player1.radius))){
                table.player1.x = xCord;
                table.player1.setX(xCord);
            }
            if(yCord >= (table.mid + table.player1.radius) && ((yCord + table.player1.radius) <= table.LowerBoundary)){
                table.player1.y = yCord;
                table.player1.setY(yCord);
            }
        }
        else if(yCord < table.mid){
            if((xCord >= (table.LeftBoundary + table.player2.radius)) && (xCord <= (table.RightBoundary - table.player2.radius))){
                table.player2.x = xCord;
                table.player2.setX(xCord);
            }
            if(yCord < (table.mid - table.player2.radius) && (yCord > (table.UpperBoundary + table.player2.radius))){
                table.player2.y = yCord ;
                table.player2.setY(yCord);
            }
        }
    }


    public boolean onTouchEvent(MotionEvent event){
        int action = event.getActionMasked();

        switch (action){

            case MotionEvent.ACTION_DOWN:
            {
                float xCord = event.getX();
                float yCord = event.getY();

                setCoordinates(xCord, yCord);

                return true;
            }
            case MotionEvent.ACTION_POINTER_DOWN:
            {
                float xCord = event.getX(1);
                float yCord = event.getY(1);

                setCoordinates(xCord, yCord);

                return true;
            }
            case MotionEvent.ACTION_MOVE:
            {
                if(event.getPointerCount() == 2){
                    for (int j = 0; j < 2; ++j){
                        float xCord = event.getX(j);
                        float yCord = event.getY(j);
                        setCoordinates(xCord, yCord);
                    }
                }
                else{
                    float xCord = event.getX();
                    float yCord = event.getY();

                    setCoordinates(xCord, yCord);
                }
                return true;
            }
        }
        return true;
    }
}