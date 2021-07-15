package com.christianhur.myfavoriteactivities.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.christianhur.myfavoriteactivities.R;
import com.christianhur.myfavoriteactivities.models.User;

public class UserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        int id = (int)Math.floor(Math.random() * User.users.length);

        ((TextView)view.findViewById(R.id.txt_fullname))
                .setText(User.users[id].getFirstName() + " " + User.users[id].getLastName() );
        ((TextView)view.findViewById(R.id.txt_username))
                .setText(User.users[id].getUserName() );
        ((TextView)view.findViewById(R.id.txt_email))
                .setText(User.users[id].getEmail());
    }
}