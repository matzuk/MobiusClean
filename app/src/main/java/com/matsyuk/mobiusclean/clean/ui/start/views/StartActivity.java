package com.matsyuk.mobiusclean.clean.ui.start.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.matsyuk.mobiusclean.R;

/**
 * @author e.matsyuk
 */
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_start);
        setTitle(getString(R.string.ac_start_wizard_title));
    }

}
