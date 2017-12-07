package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CustomProgressWebView extends WebView
{
	private int PIC_WIDTH = 100; //Loading image width

	public CustomProgressWebView(final Context context)
	{
		super(context);
		WebSettings settings = this.getSettings();
		settings.setUseWideViewPort(true);
		settings.setLoadWithOverviewMode(true);
		String imagePath = "file:///android_asset/loading.gif";
		String html = "<html><head></head><body><img src=\"" + imagePath + "\"></body></html>";
		loadUrl("file:///android_asset/loading.gif");
		//loadUrl("file:///android_asset/newloading.gif");

	}

	public CustomProgressWebView(final Context context,final AttributeSet attrs)
	{
		super(context, attrs);
		WebSettings settings = this.getSettings();
		settings.setUseWideViewPort(true);
		settings.setLoadWithOverviewMode(true);
		String imagePath = "file:///android_asset/loading.gif";
		String html = "<html><head></head><body><img src=\"" + imagePath + "\"></body></html>";
		loadUrl("file:///android_asset/loading.gif");
		//loadUrl("file:///android_asset/newloading.gif");

	}

	public CustomProgressWebView(final Context context,final AttributeSet attrs,final int defStyle)
	{
		super(context, attrs, defStyle);
		WebSettings settings = this.getSettings();
		settings.setUseWideViewPort(true);
		settings.setLoadWithOverviewMode(true);
		String imagePath = "file:///android_asset/loading.gif";
		String html = "<html><head></head><body><img src=\"" + imagePath + "\"></body></html>";
		loadUrl("file:///android_asset/loading.gif");
		//loadUrl("file:///android_asset/newloading.gif");

	}

	private int setScaleForGif(final Context context)
	{
		Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		int width = display.getWidth();
		Double val = new Double(width) / new Double(PIC_WIDTH);
		return val.intValue();
	}
}
