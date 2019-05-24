package com.example.fragmentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener, Fragment2.Fragment2Listener {
    private MyFragment myFragment;
    private Fragment2 fragment2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       myFragment=new MyFragment();
       fragment2=new Fragment2();

   getSupportFragmentManager().beginTransaction().replace(R.id.container_a, myFragment)
           .replace(R.id.container_b,fragment2 )
            .commit();

    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragment2.updateEditText(input);

    }

    @Override
    public void onInputASent(CharSequence input) {
        myFragment.updateEditText(input);

    }
}
