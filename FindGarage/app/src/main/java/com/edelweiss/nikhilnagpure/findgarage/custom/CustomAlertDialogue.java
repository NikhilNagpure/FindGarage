package com.edelweiss.nikhilnagpure.findgarage.custom;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.edelweiss.nikhilnagpure.findgarage.R;


public class CustomAlertDialogue
{
    static Handler mHandler;

    private Context context;



    public static void showAlertDialogueToast(final Context context,final String message)
    {

        if (mHandler==null)
        {
            mHandler =new Handler();
        }

        mHandler.post(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public enum AlertDialogueType
    {
        info, warning, error, success
    };

    public interface IDialogListener
    {
        void onPositiveButtonClick();

        void onNegativeButtonClick();
    }

	private static Dialog getDialog(Context context)
	{
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.colorWhite)));

        return dialog;

    }

    public static void show(Context context, String title, String message)
    {
        Typeface buttonFont = Typeface.createFromAsset(context.getAssets(), "fonts/helveticaneue_ltstd_bd.otf");
        final Dialog dialog = getDialog(context);
        dialog.setCancelable(false);

        // LogOut
        TextView tvDialogTitle = (TextView) dialog.findViewById(R.id.tvDialogTitle);
        TextView tvDialogContent = (TextView) dialog.findViewById(R.id.tvDialogContent);
        Button btNoDialog = (Button) dialog.findViewById(R.id.btNoDialog);
        btNoDialog.setTypeface(buttonFont);
        Button btYesDialog = (Button) dialog.findViewById(R.id.btYesDialog);
        btYesDialog.setTypeface(buttonFont);
        btYesDialog.setText("Ok");
        if (title == null || "".equals(title))
            tvDialogTitle.setVisibility(View.GONE);
        tvDialogTitle.setText(title);
        tvDialogContent.setText(message);
        btYesDialog.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });
        btNoDialog.setVisibility(View.GONE);
        dialog.show();

    }

    public static Dialog showAlertDialogue(Context context, String title, String message, String positiveButtonLabel,
                                         final IDialogListener dialogListener)
    {
        final Dialog dialog = getDialog(context);


        dialog.setCancelable(false);
       // dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        // LogOut
        TextView tvDialogTitle = (TextView) dialog.findViewById(R.id.tvDialogTitle);
        TextView tvDialogContent = (TextView) dialog.findViewById(R.id.tvDialogContent);
        Button btNoDialog = (Button) dialog.findViewById(R.id.btNoDialog);
        Button btYesDialog = (Button) dialog.findViewById(R.id.btYesDialog);
        if (positiveButtonLabel!=null)
        {
            btYesDialog.setText(positiveButtonLabel);
        }
        if (title == null || "".equals(title))
            tvDialogTitle.setVisibility(View.GONE);
        tvDialogTitle.setText(title);
        tvDialogContent.setText(message);
        btYesDialog.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (dialogListener != null)
                {
                    dialogListener.onPositiveButtonClick();
                }
                dialog.dismiss();
            }
        });
        btNoDialog.setVisibility(View.GONE);
        dialog.show();
        return dialog;

    }

    public static void showConfirmationDialog(final Context context, final String title,final String message,final String positiveButtonLabel,
                                              final String negativeButtonLabel, final IDialogListener dialogListener)
    {
        Typeface buttonFont = Typeface.createFromAsset(context.getAssets(), "fonts/helveticaneue_ltstd_bd.otf");
        final Dialog dialog = getDialog(context);
        dialog.setCancelable(false);
        //dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        // LogOut
        TextView tvDialogTitle = (TextView) dialog.findViewById(R.id.tvDialogTitle);
        TextView tvDialogContent = (TextView) dialog.findViewById(R.id.tvDialogContent);
        Button btNoDialog = (Button) dialog.findViewById(R.id.btNoDialog);
        btNoDialog.setText(negativeButtonLabel);
        btNoDialog.setTypeface(buttonFont);
        Button btYesDialog = (Button) dialog.findViewById(R.id.btYesDialog);
        btYesDialog.setTypeface(buttonFont);
        btYesDialog.setText(positiveButtonLabel);
        if (title == null || "".equals(title))
            tvDialogTitle.setVisibility(View.GONE);
        tvDialogTitle.setText(title);
        tvDialogContent.setText(message);
        btYesDialog.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (dialogListener != null)
                {
                    dialogListener.onPositiveButtonClick();
                }
                dialog.dismiss();
            }
        });
        btNoDialog.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (dialogListener != null)
                {
                    dialogListener.onNegativeButtonClick();
                }
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}