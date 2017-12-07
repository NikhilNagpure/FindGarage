package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class CustomDatePickerFragment extends DialogFragment
{
	OnDateSetListener onDateSet;

	private int year, month, day;

	boolean onlyPrevious;

	private DatePickerDialog dialog;

	private Long minDate, maxdate;


	public CustomDatePickerFragment(boolean onlyPrevious)
	{
		this.onlyPrevious = onlyPrevious;
	}

	public CustomDatePickerFragment(Long minDate, Long maxdate)
	{
		this.minDate = minDate;
		this.maxdate = maxdate;
	}
	public CustomDatePickerFragment()
	{
	}

	public void setCallBack(OnDateSetListener onDate)
	{
		onDateSet = onDate;
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
		dialog = new DatePickerDialog(getActivity(), onDateSet, year, month, day);

		if (onlyPrevious == true)
		{
			dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
		}

		if (minDate != null &&  minDate>0)
		{
			dialog.getDatePicker().setMinDate(minDate);
		}

		if (maxdate != null && maxdate>0)
		{
			dialog.getDatePicker().setMaxDate(maxdate);
		}

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

	public DatePickerDialog getDatePiker()
	{
		return dialog;
	}
}