package com.edelweiss.nikhilnagpure.findgarage.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.edelweiss.nikhilnagpure.findgarage.R;
import com.edelweiss.nikhilnagpure.findgarage.pojo.details.IDetails;

import java.util.ArrayList;
import java.util.List;

////import static com.mobicule.android.component.logging.MobiculeLogger.debug;

public class AdapterAutoComplete extends ArrayAdapter<IDetails>
{
	private int suggetionCount;

	private Context context;

	private int resource, textViewResourceId;

	private LayoutInflater inflater;

	private List<IDetails> items, tempItems, suggestions;

	private String TAG= AdapterAutoComplete.class.getSimpleName();

	public AdapterAutoComplete(Context context, int resource, int textViewResourceId, List<IDetails> list)
	{
		super(context, resource, textViewResourceId, list);
		this.context = context;
		this.resource = resource;
		this.textViewResourceId = textViewResourceId;
		this.items = list;
		tempItems = new ArrayList<IDetails>(list);
		suggestions = new ArrayList<IDetails>();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
		{
			if (inflater == null )
			{
				inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			}
			convertView = inflater.inflate(resource, parent, false);
		}
		IDetails iAutocompleteNameIdPair = items.get(position);
		if (iAutocompleteNameIdPair != null)
		{
			TextView tvCustomCompName = (TextView) convertView.findViewById(R.id.ctvDropDown);

			if (tvCustomCompName != null)
				tvCustomCompName.setText(iAutocompleteNameIdPair.getName());

		}
		return convertView;
	}

	@Override
	public Filter getFilter()
	{
		return nameFilter;
	}

	/**
	 * Custom Filter implementation for custom suggestions we provide.
	 */
	Filter nameFilter = new Filter()
	{
		@Override
		public CharSequence convertResultToString(Object resultValue)
		{
			String str = ((IDetails) resultValue).getName();
////			debug(TAG,"str "+str);
			return str;
		}

		@Override
		protected FilterResults performFiltering(CharSequence constraint)
		{
			//debug(TAG,"constraint :"+constraint);
			if (constraint != null && !constraint.toString().equals(""))
			{
				try
				{
					suggestions.clear();
					if (constraint.toString().toLowerCase().equals(""))
					{

						suggestions = new ArrayList<>(tempItems);
						/*for (IDetails autoCompleteDetails : tempItems) {
////                            debug("autoCompleteDetails.getName().toString().toLowerCase()  " +autoCompleteDetails.getName().toString().toLowerCase());
							suggestions.add(autoCompleteDetails);

						}*/
					}
					else
					{
						for (IDetails iAutocompleteNameIdPair : tempItems)
						{
							if (iAutocompleteNameIdPair.getName()!=null?iAutocompleteNameIdPair.getName().toLowerCase()
									.startsWith(constraint.toString().toLowerCase()):false)
							{
								suggestions.add(iAutocompleteNameIdPair);
							}
						}
					}

					FilterResults filterResults = new FilterResults();
					filterResults.values = suggestions;
					filterResults.count = suggestions.size();
					return filterResults;
				}
				catch (Exception e)
				{
					e.printStackTrace();
					return new FilterResults();
				}

			}
			else
			{
				return new FilterResults();
			}
		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results)
		{
			final List<IDetails> filterList = (ArrayList<IDetails>) results.values;

			suggetionCount = results.count;

			if (results != null && results.count > 0)
			{
				clear();
				try
				{
	/*				Thread thread = new Thread(new Runnable() {
						@Override
						public void run() {*/
							for (IDetails iaAutocompleteNameIdPair : filterList)
							{
								add(iaAutocompleteNameIdPair);
							}
							notifyDataSetChanged();
			/*			}
					});*/

				//	thread.start();

				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

			}
			else
			{
				if ((constraint != null && constraint.toString().equals("")) || constraint == null)
				{
					clear();
					items.addAll(tempItems);
					notifyDataSetChanged();
				}
				else
				{
					clear();
					notifyDataSetChanged();
				}
			}
		}
	};
}