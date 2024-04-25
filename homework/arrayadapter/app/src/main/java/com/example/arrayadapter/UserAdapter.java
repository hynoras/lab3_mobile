package com.example.arrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    UserAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_user, parent, false);
        }

        TextView nameTextView = convertView.findViewById(R.id.userNameTextView);
        TextView locationTextView = convertView.findViewById(R.id.userLocationTextView);

        nameTextView.setText(user.name);
        locationTextView.setText("from: " + user.location);

        return convertView;
    }
}
