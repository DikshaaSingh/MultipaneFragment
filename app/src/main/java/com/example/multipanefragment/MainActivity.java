package com.example.multipanefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment1.FragmentListenerInterface{

    Fragment1 fragment1=new Fragment1();
    Fragment2 fragment2=new Fragment2();
    FrameLayout f1,f2;
    FragmentManager manager;
    FragmentTransaction transaction;


    boolean isRunningOnTablet=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* TextView textView=findViewById(R.id.txtPhone);
        if (textView.getTag().equals("phone"))
        {
            isRunningOnTablet=false;
        }
        else if (textView.getTag().equals("tablet"))
        {
            isRunningOnTablet=true;
        }*/
       manager=getSupportFragmentManager();
       f1=findViewById(R.id.frag_container);
       f2=findViewById(R.id.container_a);



       if (f2!=null)
       {
           isRunningOnTablet=true;
       }
else {
    isRunningOnTablet=false;
       }



        if (isRunningOnTablet==true){
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.frag_container,fragment1);
            transaction.add(R.id.container_a,fragment2);
            transaction.commit();

        }
        else {
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.frag_container,new Fragment1());
            transaction.commit();
        }
    }



    @Override
    public void OnButtonClick() {

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.frag_container,fragment2);
        transaction.commit();

    }
}
