package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.edelweiss.nikhilnagpure.findgarage.R;


/**
 * Created by NikhilNagpure on 17-08-2016.
 */
public class CustomButton extends Button {
    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(final Context context, final AttributeSet attrs) {
        if (isInEditMode()) {
            // Ignore if within Eclipse
            return;
        }
        String font = "helveticaneue_ltstd_bd.otf";

        if (attrs != null) {
            // Look up any layout-defined attributes
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAutocompleteTextView);

            for (int i = 0; i < a.getIndexCount(); i++) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case R.styleable.FontButton_customFontButton:
                        font = a.getString(attr);
                        break;
                }
            }
            a.recycle();
        }
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+ font);
        } catch (Exception e) {

        }
        super.setTypeface(tf);
    }


}