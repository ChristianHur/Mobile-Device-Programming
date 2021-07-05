package com.christianhur.dynamicfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.christianhur.dynamicfragments.models.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onDefaultFragment();

        ListView listView = (ListView) findViewById(R.id.lst_user);
        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, User.USER_NAMES));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FirstFragment fragment = new FirstFragment();
                fragment.setId(position);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.framelayout1, fragment,null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public void onDefaultFragment(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout1, new DefaultFragment(),null)
                .addToBackStack(null)
                .commit();
    }
}