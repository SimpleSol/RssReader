package com.example.leon.rssreader.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.leon.rssreader.R;
import com.example.leon.rssreader.fragments.ChannelsList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment, new ChannelsList())
                    .commit();
        }

    }

    @Override // my changes
    public void onBackPressed() {
        if (getFragmentManager().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }


}
