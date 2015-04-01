package com.ingesup.project.judo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ingesup.project.judo.R;
import com.ingesup.project.judo.adapters.StrikeAdapter;
import com.ingesup.project.judo.beans.Strike;
import com.ingesup.project.judo.database.DatabaseManager;


public class StrikesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strikes);

        ListView listViewStrikes = (ListView) findViewById(R.id.lv_strikes);
        final StrikeAdapter strikeAdapter = new StrikeAdapter(this, DatabaseManager.getInstance(this).getAllStrikes());
        listViewStrikes.setAdapter(strikeAdapter);

        listViewStrikes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Strike strike = (Strike) strikeAdapter.getItem(position);

                Intent detailIntent = new Intent(StrikesActivity.this, StrikeActivity.class);
                detailIntent.putExtra(StrikeActivity.EXTRA_STRIKE_ID, strike.getId());
                startActivity(detailIntent);
            }
        });
    }
}
