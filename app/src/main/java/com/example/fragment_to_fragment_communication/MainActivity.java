package com.example.fragment_to_fragment_communication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private static final String TAG = "MainActivity";

    //wigdet

    private TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbarTitle = findViewById(R.id.toolbar_title);
        init();

    }
    private void init() {
        SelectorFragment fragment = new SelectorFragment();
        doFragmentTransaction(fragment, getString(R.string.fragment_selector), false, "");
    }

    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack, String message){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment, tag);
        if(addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
        }


    @Override public void setToolbarTitle(String fragmentTag) {
        mToolbarTitle.setText(fragmentTag);
    }
}

