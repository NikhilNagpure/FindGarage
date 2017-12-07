package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.os.Bundle;

public class CustomTimePickerFragment extends DialogFragment
{
	OnTimeSetListener onTimeSet;

	private int hour, minute;

	public CustomTimePickerFragment()
	{
	}

	public void setCallBack(OnTimeSetListener ontime)
	{
		onTimeSet = ontime;
	}

	@SuppressLint("NewApi")
	@Override
	public void setArguments(Bundle args)
	{
		super.setArguments(args);
		hour = args.getInt("HOUR");
		minute = args.getInt("MINUTE");
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		TimePickerDialog dialog = new TimePickerDialog(getActivity(), onTimeSet, hour, minute, true);

		dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int which)
			{
				if (which == DialogInterface.BUTTON_NEGATIVE)
				{
					dialog.dismiss();
				}
			}
		});
		return dialog;
	}

}
