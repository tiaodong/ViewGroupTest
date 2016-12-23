package com.ren.jiemei.viewgrouptest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/12/22 0022.
 */

public class MyviewGroup extends ViewGroup {
    private final Context context;
    private View view;

    public MyviewGroup(Context context) {
        super(context,null);
        this.context = context;
    }

    public MyviewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        removeAllViews();
        this.setFocusable(false);
        this.setClickable(false);
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        initview();
    }

    private void initview() {
        if (null == view){
            view = LayoutInflater.from(context).inflate(R.layout.itme, null, true);
        }

        addView(view);
        LinearLayout.LayoutParams params =
                new android.widget.LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        params.width = 200;
        params.height = 200;
        view.setLayoutParams(params);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        Log.e("tag", "onLayout: "+childCount );
        int top = 0;
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);

            view.layout(l+top,t,top+l+60,t+60);
            top = top+70;
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
// TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            //这个很重要，没有就不显示
            getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
