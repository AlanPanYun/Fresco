package alanpan.gbi.com.frescodemo.custonview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import alanpan.gbi.com.frescodemo.R;

/**
 * Created by alan.pan on 2016/10/21.
 */
public class CustomViewDemo extends View{


    private String mTitle;
    private int mTitleColor;
    private int mTitleSize;

    private Rect mBound;
    private Paint mPaint;

    public CustomViewDemo(Context context) {
        super(context);
    }

    public CustomViewDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, 0);

        int n = typedArray.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);

            switch (attr){
                case R.styleable.CustomView_titleText:
                    mTitle = typedArray.getString(attr);
                    break;
                case R.styleable.CustomView_titleCustomTextColor:
                    mTitleColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomView_titleTextSize:
                    mTitleSize = typedArray.getDimensionPixelSize(attr,DRAWING_CACHE_QUALITY_AUTO);
                    break;
            }
        }

        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTitleSize);
        mPaint.setColor(mTitleColor);

        mBound = new Rect();

        mPaint.getTextBounds(mTitle,0,mTitle.length(),mBound);
    }

    public CustomViewDemo(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTitleColor);
        canvas.drawText(mTitle, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);

    }
}
