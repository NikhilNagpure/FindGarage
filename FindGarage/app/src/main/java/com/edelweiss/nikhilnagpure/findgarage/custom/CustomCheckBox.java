package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.edelweiss.nikhilnagpure.findgarage.R;


public class CustomCheckBox extends CheckBox {

    public CustomCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        if (checked) {
            this.setButtonDrawable(R.drawable.check_box_selected);
        } else {
            this.setButtonDrawable(R.drawable.check_box);

        }
    }

}
