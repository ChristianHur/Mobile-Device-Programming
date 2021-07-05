package com.christianhur.myfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

interface Listener{
    void itemClicked(int id);
}

public class WorkListFragment extends ListFragment {

    private Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Build the list
        int len = Workout.workouts.length;
        String [] names = new String[len];
        for(int i=0;i<len;i++){
            names[i] = Workout.workouts[i].getName();
        }

        //Populate the list fragment
        setListAdapter(new ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1,names));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

//        Intent intent = new Intent(v.getContext(), WorkoutActivity.class);
//        intent.putExtra("WORK_ID",position);
//        startActivity(intent);

        listener.itemClicked(position);

    }
}