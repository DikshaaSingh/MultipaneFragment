package com.example.multipanefragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment {
    Button b1;
FragmentListenerInterface listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fragment1,container,false);
       b1=v.findViewById(R.id.btnfrag1);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.OnButtonClick();
           }
       });



        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(FragmentListenerInterface)context;


    }
    public interface FragmentListenerInterface{
        void OnButtonClick();
    }
}
