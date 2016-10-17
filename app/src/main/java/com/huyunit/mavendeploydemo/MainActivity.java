package com.huyunit.mavendeploydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huyunit.bintrayaar.BintrayaarUtil;
import com.huyunit.bintrayjar.BintrayjarUtil;
import com.huyunit.localrepodemo.LocalRepoUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalRepoUtil.d("Testing Local repo...");
        BintrayaarUtil.d("Testing Bintray aar Repo...");

        BintrayjarUtil.d("Testing Bintray jar Repo...");
    }
}
