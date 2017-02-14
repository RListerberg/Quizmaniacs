package se.quizmaniacs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import se.quizmaniacs.Jdo.Room;
import se.quizmaniacs.R;

/**
 * Created by LeoAsp on 2017-02-13.
 */

public class RoomAdapter extends ArrayAdapter {
    public RoomAdapter(Context context, ArrayList<Room> rooms) {
        super(context, 0, rooms);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Room room = (Room) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_room, parent, false);
        }
        // Lookup view for data population
        TextView roomName = (TextView) convertView.findViewById(R.id.roomName);
        TextView roomPlayers = (TextView) convertView.findViewById(R.id.roomPlayers);
        // Populate the data into the template view using the data object
        roomName.setText(room.getName());
        roomPlayers.setText(room.getConnectedPlayers() + "/" + room.getMaxPlayers());
        // Return the completed view to render on screen
        return convertView;
    }
}
