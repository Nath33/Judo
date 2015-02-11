package com.ingesup.project.judo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ingesup.project.judo.R;
import com.ingesup.project.judo.beans.Takedown;
import com.ingesup.project.judo.database.DatabaseManager;
import com.ingesup.project.judo.list.PriseAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listeDesPrises = (ListView) findViewById(R.id.lv_prises);
        PriseAdapter maPriseAdapter = new PriseAdapter(this, R.layout.item_prise, DatabaseManager.getInstance(this).getAllTakedowns());
        listeDesPrises.setAdapter(maPriseAdapter);

    }
}
