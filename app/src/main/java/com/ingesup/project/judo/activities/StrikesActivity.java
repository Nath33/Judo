package com.ingesup.project.judo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.ingesup.project.judo.R;
import com.ingesup.project.judo.adapters.StrikeAdapter;
import com.ingesup.project.judo.beans.Strike;
import com.ingesup.project.judo.beans.Strikes;
import com.ingesup.project.judo.database.DatabaseManager;


public class StrikesActivity extends Activity {

    private Strikes mDisplayedStrikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strikes);

        Strikes strikes = new Strikes();
        Strike strike1 = new Strike("a", 1, "");
        Strike strike2 = new Strike("b", 3, "");
        Strike strike3 = new Strike("c", 2, "");
        strike1.setId(3);
        strike2.setId(1);
        strike3.setId(2);
        strikes.add(strike2);
        strikes.add(strike1);
        strikes.add(strike3);
        strikes.orderByProperty("mName");
        strikes.orderByProperty("mId");
        strikes.orderByProperty("mCategory");

        SearchView searchViewStrikes = (SearchView) findViewById(R.id.sv_strikes);
        ListView listViewStrikes = (ListView) findViewById(R.id.lv_strikes);

        final Strikes allStrikes = DatabaseManager.getInstance(this).getAllStrikes();
        mDisplayedStrikes = new Strikes();
        mDisplayedStrikes.addAll(allStrikes);

        final StrikeAdapter strikeAdapter = new StrikeAdapter(this, mDisplayedStrikes);
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

        searchViewStrikes.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mDisplayedStrikes.clear();
                mDisplayedStrikes.addAll(allStrikes.search(s));
                strikeAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
