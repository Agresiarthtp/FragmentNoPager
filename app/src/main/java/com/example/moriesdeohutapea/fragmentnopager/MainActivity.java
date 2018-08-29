package com.example.moriesdeohutapea.fragmentnopager;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private Button btnA, btnB, btnC, btnExit, btntabbawah;
    private FragmentA classFragmentA;
    private FragmentB classFragmentB;
    private FragmentC classFragmentC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = (Button) findViewById(R.id.keA);
        btnB = (Button) findViewById(R.id.keB);
        btnC = (Button) findViewById(R.id.keC);
        btnExit = (Button) findViewById(R.id.exit);
        btntabbawah = (Button) findViewById(R.id.btntabbawah);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btntabbawah.setOnClickListener(this);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        FragmentA mFragmentA = new FragmentA();
        mFragmentTransaction.add(R.id.container, mFragmentA);
        mFragmentTransaction.commit();
        Log.d("MyFlexibleFragment", "Fragment Name : " + FragmentA.class.getSimpleName());
    }

    void mA() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        classFragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.container, classFragmentA);
        fragmentTransaction.commit();
    }

    void mB() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        classFragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.container, classFragmentB);
        fragmentTransaction.commit();
    }

    void mC() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        classFragmentC = new FragmentC();
        fragmentTransaction.replace(R.id.container, classFragmentC);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.animation);

        if (v == btnA)
            mA();
        if (v == btnB)
            mB();
        if (v == btnC)
            mC();
        if (v == btnExit)
            finish();
        if (v == btntabbawah) {
            Toast.makeText(this, "TAB BAWAH", Toast.LENGTH_SHORT).show();
//            Snackbar.make(v, "Belum Tersedia", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
        }
        v.startAnimation(myAnim);
    }
}
