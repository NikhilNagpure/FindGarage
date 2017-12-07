package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;


import com.edelweiss.nikhilnagpure.findgarage.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vaibhav Mandale on 18-10-2016.
 */
public class CustomAutocompleteTextView extends AutoCompleteTextView {

    private String validation;

    public CustomAutocompleteTextView(Context context) {
        super(context);
    }

    public CustomAutocompleteTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
        setRegularString(context, attrs);
        init(context);
    }

    public CustomAutocompleteTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
        setRegularString(context, attrs);

    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }

    private void init(final Context context) {
        //setTextColor(context.getResources().getColor(R.color.colorThemeBlue));
    }

    private void setCustomFont(final Context context, final AttributeSet attrs) {
        if (isInEditMode()) {
            // Ignore if within Eclipse
            return;
        }
        String font = "helveticaneue_ltstd_lt_.otf";

        if (attrs != null) {
            // Look up any layout-defined attributes
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAutocompleteTextView);

            for (int i = 0; i < a.getIndexCount(); i++) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case R.styleable.FontAutocompleteTextView_customFontAutocompleteTextView:
                        font = a.getString(attr);
                        break;
                }
            }
            a.recycle();
        }
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/"

                    + font);
        } catch (Exception e) {

        }
        super.setTypeface(tf);
    }

    public void setRegularString(final Context context, final AttributeSet attrs) {

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontAutocompleteTextView);
            for (int i = 0; i < a.getIndexCount(); i++) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case R.styleable.FontAutocompleteTextView_customRegularString:
                        validation = a.getString(attr);
                        break;
                }
            }
            a.recycle();
        }

    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {

        if (validation != null && !validation.equals("")) {
            if (!IsMatch(text.toString(), validation)/*text.toString().matches(validation)*/) {
                try {
                    text = text.subSequence(0, text.length() - 1);
                    setText(text);
                    setSelection(text.length());
                } catch (Exception e
                        ) {
                    e.printStackTrace();
                }

            }
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);

    }

    private boolean IsMatch(String s, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(s);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }

}