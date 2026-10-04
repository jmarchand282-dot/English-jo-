package com.josephmarchand.englishjoe.components;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.josephmarchand.englishjoe.R;

public class PrimaryButton extends AppCompatButton {

    public PrimaryButton(Context context) {
        super(context);
        init();
    }

    public PrimaryButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PrimaryButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundResource(R.drawable.bg_primary_button);
        setTextColor(getResources().getColor(R.color.jo_text_white));
        setTextSize(16);
        setAllCaps(false);
        setGravity(android.view.Gravity.CENTER);
        setMinHeight((int) (52 * getResources().getDisplayMetrics().density));
        setPadding(
                (int) (20 * getResources().getDisplayMetrics().density),
                0,
                (int) (20 * getResources().getDisplayMetrics().density),
                0
        );
    }
}
