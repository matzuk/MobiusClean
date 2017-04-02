package com.matsyuk.mobiusclean.clean.ui.app_lock.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.matsyuk.mobiusclean.R;

/**
 * @author e.matsyuk
 */
public class AppLockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_app_lock);
        setTitle(getString(R.string.ac_app_lock_wizard_title));
    }

}
