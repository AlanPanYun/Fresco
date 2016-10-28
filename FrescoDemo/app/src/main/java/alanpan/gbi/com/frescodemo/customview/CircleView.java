package alanpan.gbi.com.frescodemo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import alanpan.gbi.com.frescodemo.R;

/**
 * Created by alan.pan on 2016/10/27.
 */
public class CircleView extends View {

    private int mFristClor;
    private int mSecondColor;
    private int mSpead;
    private int mCircleWidth;
    private Paint mPaint;
    private boolean isNext = false;
    private int mProgress;


    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CircleView,
                0,
                0
        );

        int count = a.length();
        for (int i = 0; i < count; i++) {
            int index = a.getIndex(i);
            switch (index) {
                case R.styleable.CircleView_circleWidth:
                    mCircleWidth = a.getDimensionPixelSize(index, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CircleView_fristColor:
                    mFristClor = a.getColor(index, Color.RED);
                    break;
                case R.styleable.CircleView_secondColor:
                    mSecondColor = a.getColor(index, Color.GREEN);
                    break;
                case R.styleable.CircleView_spead:
                    mSpead = a.getInt(index, 20);
                    break;
            }
        }
        a.recycle();
        mPaint = new Paint();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    mProgress++;
                    if (mProgress == 360) {
                        mProgress = 0;
                        if (isNext) {
                            isNext = false;
                        } else {
                            isNext = true;
                        }
                        postInvalidate();
                        try {
                            Thread.sleep(mSpead);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centre = getWidth() / 2;// 圆心坐标
        int radius = centre - mCircleWidth / 2;
        mPaint.setStrokeWidth(mCircleWidth);// 设置圆圈的半径
        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.STROKE);
        RectF rectF = new RectF(centre - radius, centre - radius, centre + radius, centre + radius);

        if (isNext){
            mPaint.setColor(mSecondColor);
            canvas.drawCircle(centre,centre,radius,mPaint);
            mPaint.setColor(mFristClor);
            canvas.drawArc(rectF,-90,mProgress,false,mPaint);
        }else {
            mPaint.setColor(mFristClor);
            canvas.drawCircle(centre,centre,radius,mPaint);
            mPaint.setColor(mSecondColor);
            canvas.drawArc(rectF,-90,mProgress,false,mPaint);
        }
    }
}
