package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.android.quakereport.R.id.date;
import static com.example.android.quakereport.R.id.location;
import static com.example.android.quakereport.R.id.magnitude;
import static com.example.android.quakereport.R.id.offset_location;
import static com.example.android.quakereport.R.id.time;


public class EarthquakeAdapter extends ArrayAdapter {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list_item, parent, false);
        }

        // get the Attraction object located at this position in the list
        Earthquake currentEarthquake = (Earthquake) getItem(position);

        // set the magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthquake.getMagnitude());


        String location = currentEarthquake.getLocationName();
        String locationOffset;
        String primaryLocation;
        if (location.contains(LOCATION_SEPARATOR)) {
            String[] parts = location.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = location;
        }

        // set location, divided in offset and primary location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);
        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        // create date object to format time and date
        Date dateObject = new Date(currentEarthquake.getTimeInMiliseconds());

        // format date, set in TextView
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        // format time and set up in TextView
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
