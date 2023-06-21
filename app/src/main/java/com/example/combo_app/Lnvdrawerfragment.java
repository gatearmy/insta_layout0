package com.example.combo_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;


public class Lnvdrawerfragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lnvdrawerfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout=view.findViewById(R.id.tablayout);
        ViewPager viewpager=view.findViewById(R.id.viewpager);

        viewPagerAdapter adapter=new viewPagerAdapter(getActivity().getSupportFragmentManager());
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);




    }
}