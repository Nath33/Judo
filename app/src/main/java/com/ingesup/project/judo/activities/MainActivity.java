package com.ingesup.project.judo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ingesup.project.judo.R;
import com.ingesup.project.judo.beans.Takedown;
import com.ingesup.project.judo.list.PriseAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Takedown> liste_genre = new ArrayList<Takedown>();
        Takedown prise1 = new Takedown();
        prise1.setName("Prise1");
        liste_genre.add(prise1);
        Takedown prise2 = new Takedown();
        prise2.setName("Prise2");
        liste_genre.add(prise2);

        ListView listeDesPrises = (ListView) findViewById(R.id.lv_prises);
        PriseAdapter maPriseAdapter = new PriseAdapter(this,R.layout.item_prise,liste_genre);
        listeDesPrises.setAdapter(maPriseAdapter);

    }
}
