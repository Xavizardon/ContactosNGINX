package com.example.deryancruz.contactosnginx;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter{

   private final List<Fragment> FragmentosAgregados = new ArrayList<>();
   private final List<String> TitulosColumnas = new ArrayList<>();

   public ViewPagerAdapter(FragmentManager fm){
       super(fm);
   }

   @Override
    public Fragment getItem(int position){
       return FragmentosAgregados.get(position);
   }

   @Override
    public int getCount(){
       return TitulosColumnas.size();
   }

   @Override
    public CharSequence getPageTitle(int position){
       return TitulosColumnas.get(position);
   }

   public void AddFragment (Fragment fragment, String title){
       FragmentosAgregados.add(fragment);
       TitulosColumnas.add(title);
   }



}
