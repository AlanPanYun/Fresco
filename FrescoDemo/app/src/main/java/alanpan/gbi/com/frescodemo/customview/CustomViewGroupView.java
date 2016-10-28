package alanpan.gbi.com.frescodemo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alan.pan on 2016/10/26.
 */
public class CustomViewGroupView extends ViewGroup {
    public CustomViewGroupView(Context context) {
        super(context);
    }

    public CustomViewGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroupView(Context context, AttributeSet attrs, int defStyleAttr) {


        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int withModel = MeasureSpec.getMode(widthMeasureSpec);
        int withSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightModel = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        // 计算出所有child view的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int width = 0;
        int height = 0;

        int cCount = getChildCount();
        int cWidth = 0;
        int cHeight = 0;
        MarginLayoutParams cParams = null;

        // 用于计算左边两个childView的高度
        int lHeight = 0;
        // 用于计算右边两个childView的高度，最终高度取二者之间大值
        int rHeight = 0;

        // 用于计算上边两个childView的宽度
        int tWidth = 0;
        // 用于计算下面两个childiew的宽度，最终宽度取二者之间大值
        int bWidth = 0;


        for (int i = 0; i < cCount; i++) {
            View chidView = getChildAt(i);
            cWidth = chidView.getMeasuredWidth();
            cHeight = chidView.getMeasuredWidth();

            cParams = (MarginLayoutParams) chidView.getLayoutParams();

            if (i == 0 || i == 1) {
                tWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }
            if (i == 2 || i == 3) {
                bWidth += cWidth + cParams.leftMargin + cParams.rightMargin;
            }

            if (i == 0 || i == 2) {
                lHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }

            if (i == 1 || i == 3) {
                rHeight += cHeight + cParams.topMargin + cParams.bottomMargin;
            }

            width = Math.max(tWidth, bWidth);
            height = Math.max(lHeight, rHeight);

            setMeasuredDimension(
                    (withModel == MeasureSpec.EXACTLY) ? withSize : width,
                    (heightModel == MeasureSpec.EXACTLY) ? heightSize : height
            );

        }


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
