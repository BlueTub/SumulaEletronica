package com.projeto.sumula.sumulaeletronica.fragments.arbitro;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.fragments.arbitro.FragmentArbitroInformacoes;
import com.projeto.sumula.sumulaeletronica.fragments.arbitro.FragmentArbitroPartidas;
import com.projeto.sumula.sumulaeletronica.fragments.arbitro.FragmentArbitroSentencas;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTabsArbitro extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;


    public FragmentTabsArbitro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_arbitro_tabs, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter( new CustomAdapter(getActivity().getSupportFragmentManager(), getActivity().getApplicationContext()));

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });


        return view;
    }

    private class CustomAdapter extends FragmentPagerAdapter {

        private String fragments[] = {"Partidas",
                "Sentenças",
                "Informações"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new FragmentArbitroPartidas();
                case 1:
                    return new FragmentArbitroSentencas();
                case 2:
                    return new FragmentArbitroInformacoes();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }
}
