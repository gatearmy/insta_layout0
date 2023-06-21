package com.example.combo_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Knvdrawerfragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_knvdrawerfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView bnview=view.findViewById(R.id.bnvieww);

        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int iid=item.getItemId();
                if (iid==R.id.fbnitems) {
                    loadFrag(new Fbnfragment(),false);
                }

                else if (iid==R.id.gbnitems) {
                     loadFrag(new Gbnfragment(),false);
                 }
                 else if (iid==R.id.hbnitems) {
                     loadFrag(new Hbnfragment(),false);
                 }
                 else if (iid==R.id.ibnitems) {
                     loadFrag(new Ibnfragment(),false);
                 }
                 else {
                     loadFrag(new Jbnfragment(),false);
                 }


                return true;
            }
        });



    }

    public void loadFrag(Fragment fragment,boolean abc){
        FragmentManager fmt= getActivity().getSupportFragmentManager();
        FragmentTransaction ft= fmt.beginTransaction();

        if(abc){
            ft.add(R.id.container1,fragment);
        }
        else{
            ft.replace(R.id.container1,fragment);

            if(fragment instanceof Fbnfragment){
                ft.replace(R.id.container,new Knvdrawerfragment());
            }

        }
        ft.commit();

    }
}