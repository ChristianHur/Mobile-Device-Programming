package com.christianhur.dynamicfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.christianhur.dynamicfragments.models.User;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        //TextView txt_name = (TextView) view.findViewById(R.id.txt_username);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView txt_name = (TextView) view.findViewById(R.id.txt_username);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        TextView txt_email = (TextView) view.findViewById(R.id.txt_email);

        txt_name.setText(User.users[id].getName());
        txt_title.setText(User.users[id].getTitle());
        txt_email.setText(User.users[id].getEmail());

        Button btn_remove = (Button) view.findViewById(R.id.btn_remove);
        btn_remove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction()
                        .remove(FirstFragment.this)
                        .commit();
            }
        });
    }

}