package com.ingesup.project.judo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.ingesup.project.judo.R;
import com.ingesup.project.judo.beans.Strike;
import com.ingesup.project.judo.database.DatabaseManager;

/**
 * Created by Changeform on 27/03/2015.
 */
public class StrikeActivity extends YouTubeBaseActivity{

    public static final String EXTRA_STRIKE_ID = "EXTRA_STRIKE_ID";

    private Strike mStrike;

    private TextView mTextViewStrikeName;
    private TextView mTextViewCategoryName;
    private YouTubePlayerFragment youTubePlayerFragment_1;
    private YouTubePlayerFragment youTubePlayerFragment_2;
    private String mVideoUrl_1;
    private String mVideoUrl_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strike);

        int strikeId = getIntent().getIntExtra(EXTRA_STRIKE_ID, -1);

        if(strikeId == -1)
            finish();

        mStrike = DatabaseManager.getInstance(this).getStrike(strikeId);
        mVideoUrl_1 = mStrike.getLink_1();
        //mVideoUrl_2 = mStrike.getLink_2();

        mTextViewStrikeName = (TextView) findViewById(R.id.tv_strike_name);
        mTextViewCategoryName = (TextView) findViewById(R.id.tv_category_name);

        mTextViewStrikeName.setText(mStrike.getName());
        mTextViewCategoryName.setText(mStrike.getCategory().getName());

        youTubePlayerFragment_1 = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubeplayerfragment_1);
        youTubePlayerFragment_1.initialize(getString(R.string.youtube_api_key), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    youTubePlayer.loadVideo(mVideoUrl_1);
                    youTubePlayer.pause();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(StrikeActivity.this, getString(R.string.youtube_error), Toast.LENGTH_LONG).show();
            }
        });

        /*youTubePlayerFragment_2 = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubeplayerfragment_2);
        youTubePlayerFragment_2.initialize(getString(R.string.youtube_api_key), new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    youTubePlayer.loadVideo(mVideoUrl_2);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(StrikeActivity.this, getString(R.string.youtube_error), Toast.LENGTH_LONG).show();
            }
        });*/
    }
}
