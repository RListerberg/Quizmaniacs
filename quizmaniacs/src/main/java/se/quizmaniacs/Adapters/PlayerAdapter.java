package se.quizmaniacs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import se.quizmaniacs.Jdo.SimpleUser;
import se.quizmaniacs.R;

/**
 * Created by LeoAsp on 2017-03-01.
 */

public class PlayerAdapter extends ArrayAdapter {
    public PlayerAdapter(Context context, ArrayList<SimpleUser> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SimpleUser simpleUser = (SimpleUser) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_player_in_room, parent, false);
        }

        //RadioButton playerReady = (RadioButton) convertView.findViewById(R.id.playerReady);
        TextView playerName = (TextView) convertView.findViewById(R.id.playerName);

        //playerReady.setChecked(simpleUser.getPlayerData().isReady());
        playerName.setText(simpleUser.getNickname());


        return convertView;
    }
}
