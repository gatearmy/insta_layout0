package com.example.combo_app;

import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bn_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =findViewById(R.id.toobar_main);
        drawerLayout=findViewById(R.id.drawer_layout_id);
        navigationView =findViewById(R.id.navigation_view);


        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_nv_drawer,R.string.close_nv_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        loadFrag(new Knvdrawerfragment(),true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if(id==R.id.knvdarwer){
                    loadFrag(new Knvdrawerfragment(),false);

                }
                else if(id==R.id.lnvdrawer){
                    loadFrag(new Lnvdrawerfragment(),false);

                }
                else if(id==R.id.mnvdrawer){
                    loadFrag(new Mnvdrawerfragment(),false);

                }
                else if(id==R.id.nnvdrawer){
                    loadFrag(new Nnvdrawerfragment(),false);

                }
                else if(id==R.id.onvdrawer){
                    loadFrag(new Onvdrawerfragment(),false);

                }
                else  {
                    loadFrag(new Pnvdrawerfragment(),false);

                }

              drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });





    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    public  void loadFrag(Fragment fragment, boolean abc){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(abc){
            ft.add(R.id.container,fragment);
        }
        else{
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }



}