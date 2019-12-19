package com.example.y.drawerlayout_demo;

import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout mDrawerLayout;
    private LinearLayout mDrawer;
    private Button mBtnOne;
    private Button mBtnTwo;
    private Button mBtnThr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawer = findViewById(R.id.drawer);
        mBtnOne = findViewById(R.id.btn_one);
        mBtnTwo = findViewById(R.id.btn_two);
        mBtnThr = findViewById(R.id.btn_three);

        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
        mBtnThr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                replaceFragment(1);
                break;
            case R.id.btn_two:
                replaceFragment(2);
                break;
            case R.id.btn_three:
                replaceFragment(3);
                break;
        }
    }

    /**
     * 切换fragment
     */
    private void replaceFragment(int id){
        FragmentManager fm = getSupportFragmentManager();
        switch (id){
            case 1:
                fm.beginTransaction().replace(R.id.fragment_container,new FirstFragment()).commit();
                break;
            case 2:
                fm.beginTransaction().replace(R.id.fragment_container,new SecondFragment()).commit();
                break;
            case 3:
                fm.beginTransaction().replace(R.id.fragment_container,new ThirdFragment()).commit();
                break;
        }
        mDrawerLayout.closeDrawer(mDrawer);
    }
}
