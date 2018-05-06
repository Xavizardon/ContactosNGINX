package com.example.deryancruz.contactosnginx;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    private TabLayout EspacioParaMenu;
    private ViewPager EspacioParaFragmentos;
    private ViewPagerAdapter AdaptadorParaFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EspacioParaMenu = (TabLayout) findViewById(R.id.tablayout_contact_nginx);
        EspacioParaFragmentos = (ViewPager) findViewById(R.id.viewpager_nginx);
        AdaptadorParaFragmentos = new ViewPagerAdapter(getSupportFragmentManager());

        AdaptadorParaFragmentos.AddFragment(new FragmentoContactos(),"Contactos");
        //AdaptadorParaFragmentos.AddFragment(new FragmentoLlamadas(),"Llamadas");
        AdaptadorParaFragmentos.AddFragment(new FragmentoFavoritos(),"Favoritos");
        EspacioParaFragmentos.setAdapter(AdaptadorParaFragmentos);
        EspacioParaMenu.setupWithViewPager(EspacioParaFragmentos);

        EspacioParaMenu.getTabAt(0).setIcon(R.drawable.ic_people_black_24dp);
        //EspacioParaMenu.getTabAt(1).setIcon(R.drawable.ic_local_phone_black_24dp);
        EspacioParaMenu.getTabAt(1).setIcon(R.drawable.ic_star_black_24dp);

        ActionBar BarraDeAccion = getSupportActionBar();
        BarraDeAccion.setElevation(0);
    }


}
