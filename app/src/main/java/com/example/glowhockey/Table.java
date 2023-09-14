package com.example.glowhockey;

import static com.example.glowhockey.GameActivity.deviceHeight;
import static com.example.glowhockey.GameActivity.deviceWidth;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class Table extends View {
    private static final float goalStartRatio = (float)(114)/360, goalEndRatio = (float)(360 - 120)/360, thicknessHeightRatio = (float)(9)/640, thicknessWidthRatio = (float)(9)/360;
    public float goalStart, goalEnd, mid, LeftBoundary, RightBoundary, UpperBoundary, LowerBoundary;
    public int x = 0, y = 0;
    Bitmap background;
    public Player player1, player2;
    public Ball ball;
    Paint paint;
    public Table(Context context){
        super(context);

        paint = new Paint();

        background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.table),(int) deviceWidth, (int) deviceHeight, false);

        goalStart = goalStartRatio * deviceWidth;
        goalEnd = goalEndRatio * deviceWidth;
        mid = deviceHeight / 2;
        LeftBoundary = thicknessWidthRatio * deviceWidth;
        RightBoundary = deviceWidth - thicknessWidthRatio * deviceWidth;
        UpperBoundary = thicknessHeightRatio * deviceHeight;
        LowerBoundary = deviceHeight - thicknessHeightRatio * deviceHeight;

        player1 = new Player(deviceWidth / 2, 7 * deviceHeight / 8, this);
        player2 = new Player(deviceWidth / 2, deviceHeight / 8,this, 2);
        ball = new Ball(deviceWidth / 2, deviceHeight / 2, this);
    }

    protected void onDraw(Canvas c) {
        super.onDraw(c);
        c.drawBitmap(background, 0, 0, null);
        player1.setBitmap(player1.getRegularBitmap());
        player2.setBitmap(player2.getRegularBitmap());
        player1.draw(c);
        player2.draw(c);
        ball.draw(c);
        paint.setTextSize(100);
        paint.setColor(Color.WHITE);
        c.drawText(Integer.toString(player1.getScore()),
                LeftBoundary + 10, mid + 110, paint);
        c.drawText(Integer.toString(player2.getScore()),
                LeftBoundary + 10, mid - 60, paint);

        invalidate();
    }

}
