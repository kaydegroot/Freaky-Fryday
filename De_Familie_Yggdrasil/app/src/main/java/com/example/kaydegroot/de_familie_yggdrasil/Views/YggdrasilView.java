package com.example.kaydegroot.de_familie_yggdrasil.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kay de groot on 9-10-2015.
 */
public class YggdrasilView extends View {

    private Paint paint = new Paint();
    ;

    public YggdrasilView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);
        Rect r = new Rect(0, 0, (int) (canvas.getWidth() * 2), (int) (canvas.getHeight() * 2));
        canvas.drawRect(r, paint);
        paint.setColor(Color.GREEN);

        canvas.drawLine(0, 0, canvas.getWidth(), canvas.getHeight(), paint);
        canvas.drawLine(canvas.getWidth(), 0, 0, canvas.getHeight(), paint);
        invalidate();
    }

    private String TAG = YggdrasilView.class.getSimpleName();
    float initialX, initialY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        Boolean stateDown = false;
        switch (action) {

            case MotionEvent.ACTION_DOWN:
                initialX = event.getX();
                initialY = event.getY();
                stateDown = true;
                Log.d(TAG, "Action was DOWN");
                break;

            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Action was MOVE");
                stateDown = true;
                break;

            case MotionEvent.ACTION_UP:
                float finalX = event.getX();
                float finalY = event.getY();
                stateDown = false;
                Log.d(TAG, "Action was UP");
                this.scrollBy((int)(initialX-finalX),(int)(initialY-finalY));
                break;

            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "Action was CANCEL");
                stateDown = false;
                break;

            case MotionEvent.ACTION_OUTSIDE:
                Log.d(TAG, "Movement occurred outside bounds of current screen element");
                break;
        }
        return stateDown;
    }

}
