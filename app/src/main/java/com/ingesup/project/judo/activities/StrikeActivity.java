package com.ingesup.project.judo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ingesup.project.judo.R;
import com.ingesup.project.judo.beans.Strike;
import com.ingesup.project.judo.database.DatabaseManager;

/**
 * Created by Changeform on 27/03/2015.
 */
public class StrikeActivity extends Activity {

    public static final String EXTRA_STRIKE_ID = "EXTRA_STRIKE_ID";

    private Strike mStrike;

    private TextView mTextViewStrikeName;
    private TextView mTextViewCategoryName;
    private Button mButtonYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strike);

        int strikeId = getIntent().getIntExtra(EXTRA_STRIKE_ID, -1);

        if(strikeId == -1)
            finish();

        mStrike = DatabaseManager.getInstance(this).getStrike(strikeId);

        mTextViewStrikeName = (TextView) findViewById(R.id.tv_strike_name);
        mTextViewCategoryName = (TextView) findViewById(R.id.tv_category_name);
        mButtonYoutube = (Button) findViewById(R.id.b_youtube);

        mTextViewStrikeName.setText(mStrike.getName());
        mTextViewCategoryName.setText(mStrike.getCategory().getName());
        mButtonYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
