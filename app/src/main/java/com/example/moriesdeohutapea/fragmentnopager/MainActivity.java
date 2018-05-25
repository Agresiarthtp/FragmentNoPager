package com.example.moriesdeohutapea.fragmentnopager;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private Button btnA, btnB, btnC, btnExit;
    private A classA;
    private B classB;
    private C classC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = (Button) findViewById(R.id.keA);
        btnB = (Button) findViewById(R.id.keB);
        btnC = (Button) findViewById(R.id.keC);
        btnExit = (Button) findViewById(R.id.exit);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnExit.setOnClickListener(this);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();

        A mA = new A();
        mFragmentTransaction.add(R.id.container, mA, A.class.getSimpleName());

        //ini hanya sebuah nama saja
        Log.d("MyFlexibleFragment", "Fragment Name : " + A.class.getSimpleName());
        mFragmentTransaction.commit();
    }

    void mA() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        classA = new A();
        fragmentTransaction.replace(R.id.container, classA);
        fragmentTransaction.commit();
    }

    void mB() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        classB = new B();
        fragmentTransaction.replace(R.id.container, classB);
        fragmentTransaction.commit();
    }

    void mC() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        classC = new C();
        fragmentTransaction.replace(R.id.container, classC);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

        if (v == btnA)
            mA();
        if (v == btnB)
            mB();
        if (v == btnC)
            mC();
        if (v == btnExit)
            finish();
    }
}
