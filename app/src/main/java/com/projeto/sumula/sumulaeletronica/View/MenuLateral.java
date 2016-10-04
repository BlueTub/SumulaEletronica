package com.projeto.sumula.sumulaeletronica.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import com.projeto.sumula.sumulaeletronica.R;
import com.projeto.sumula.sumulaeletronica.control.AdaptadorGridViewClube;
import com.projeto.sumula.sumulaeletronica.model.Clube;
import com.projeto.sumula.sumulaeletronica.model.ListaClubes;
import com.projeto.sumula.sumulaeletronica.persistence.JogadorJson;

import java.util.ArrayList;

public class MenuLateral extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    Toolbar toolbar;
    public static ListaClubes listaClubes;
    public static ListaClubes listaPesquisa = new ListaClubes();
    private ImageButton imageButton;
    private EditText etPesquisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);

        //clube
        imageButton = (ImageButton) findViewById(R.id.imPesquisaClube);
        etPesquisa = (EditText) findViewById(R.id.etPesquisaClube);

        construirGrid(listaClubes);

        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listaPesquisa.clube = new ArrayList<Clube>();
                if (!listaPesquisa.clube.isEmpty()){
                    listaPesquisa.clube.clear();
                }

                pesquisa(etPesquisa.getText().toString());
                construirGrid(listaPesquisa);
            }
        }); //fim clube

        FragmentClube fragmentClube = new FragmentClube();
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragmentClube);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Não faz nada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //clube
    public void construirGrid(final ListaClubes listaClubes){
        GridView gv = (GridView) findViewById(R.id.gvClubes);

        try {
            if (listaClubes != null) {
                gv.setAdapter(new AdaptadorGridViewClube(this, listaClubes));
                gv.setOnItemClickListener(new GridView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        Log.i("LISTA", String.valueOf(listaClubes.clube.get(position).getId()).toString());
                        JogadorJson json = new JogadorJson();
                        json.pesquisaJogadorClube(listaClubes.clube.get(position).getId());

                        Intent intent = new Intent(MenuLateral.this, ViewJogador.class);
                        startActivity(intent);
                    }
                });
            }
        } catch (NullPointerException e) {
            Log.i("catch", "NULA");
        }
    }

    public void pesquisa(String param){
        Clube c = new Clube();

        for (Clube clube : listaClubes.clube) {
            if (clube.getNome().startsWith(param) || clube.getNome().endsWith(param)) {
                c = clube;
                listaPesquisa.clube.add(c);
            }
        }

    }
//fim clube
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_estadio) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
