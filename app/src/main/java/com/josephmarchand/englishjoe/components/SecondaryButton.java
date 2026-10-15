
package com.josephmarchand.englishjoe.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.josephmarchand.englishjoe.R;

public class SecondaryButton extends AppCompatButton {

    public SecondaryButton(Context context) {
        super(context);
        init();
    }

    public SecondaryButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SecondaryButton(
            Context context,
            @Nullable AttributeSet attrs,
            int defStyleAttr
    ) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundResource(R.drawable.bg_secondary_button);
        setTextColor(getResources().getColor(R.color.jo_blue));
        setTextSize(16);
        setAllCaps(false);
        setGravity(Gravity.CENTER);

        float density = getResources().getDisplayMetrics().density;

        setMinHeight((int) (52 * density));
        setPadding(
                (int) (20 * density),
                0,
                (int) (20 * density),
                0
        );
    }
}
