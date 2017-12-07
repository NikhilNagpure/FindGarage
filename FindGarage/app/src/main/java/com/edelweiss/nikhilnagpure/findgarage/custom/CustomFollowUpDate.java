package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class CustomFollowUpDate extends DialogFragment
{
	OnDateSetListener onFollowUpDateSet;

	private int year, month, day;

	public CustomFollowUpDate()
	{
	}

	public void setCallBack(OnDateSetListener followUpDate)
	{
		onFollowUpDateSet = followUpDate;
	}

	@SuppressLint("NewApi")
	@Override
	public void setArguments(Bundle args)
	{
		
		super.setArguments(args);
		year = args.getInt("year");
		month = args.getInt("month");
		day = args.getInt("day");
		
	}
 
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		DatePickerDialog dialog = new DatePickerDialog(getActivity(), onFollowUpDateSet, year, month, day);

		dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{
				if (which == DialogInterface.BUTTON_NEGATIVE)
				{
					//						dialog.dismiss();

				}
			}
		});
		return dialog;
	}
}