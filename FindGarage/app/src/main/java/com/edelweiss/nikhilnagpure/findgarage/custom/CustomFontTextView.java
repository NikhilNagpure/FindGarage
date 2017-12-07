package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import com.edelweiss.nikhilnagpure.findgarage.R;


public class CustomFontTextView extends TextView {
    public CustomFontTextView(final Context context) {
        super(context);
    }

    public CustomFontTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
        setMandatory(context, attrs);
    }

    public CustomFontTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
        setMandatory(context, attrs);
    }


    private void setCustomFont(final Context context, final AttributeSet attrs) {
        if (isInEditMode()) {
            // Ignore if within Eclipse
            return;
        }
        String font = "helveticaneue_ltstd_bd.otf";

        if (attrs != null) {
            // Look up any layout-defined attributes
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontTextView);

            for (int i = 0; i < a.getIndexCount(); i++) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case R.styleable.FontTextView_customFont:

                        font = a.getString(attr);
                        break;
                }
            }
            a.recycle();
        }
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + font);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setTypeface(tf);
    }


    private void setMandatory(final Context context, final AttributeSet attrs) {
        boolean mandatory = false;
        if (isInEditMode()) {
            // Ignore if within Eclipse
            return;
        }
        if (attrs != null) {
            // Look up any layout-defined attributes
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontTextView);
            for (int i = 0; i < a.getIndexCount(); i++) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case R.styleable.FontTextView_Mandatory:
                        mandatory = a.getBoolean(attr, false);
                        break;
                }
            }

        }
        try {

            if (mandatory) {

        /*       super.setText(Html.fromHtml(" <b><font color="+getCurrentTextColor()+">" + getText() + "</b> <b><font color=#e63636>*</b>"
                        ));*/


              super.setText(Html.fromHtml(" <b><font color=#8e8e8e>" + getText() + "</b> <b><font color=#e63636>*</b>"
                ));
                //super.setText(Html.fromHtml(context.getString(R.string.client_name_mandatory)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}