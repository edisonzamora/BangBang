package daudo.zamora.edison.bangbang;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import daudo.zamora.edison.bangbang.fragmentos.Ajustes_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.GridEventos_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.ListaEventos_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.ListaReservas_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.LoginFragment;
import daudo.zamora.edison.bangbang.fragmentos.Registro_Fragment;


public class Home extends AppCompatActivity
        implements ListaEventos_Fragment.OnFragmentInteractionListener, ListaReservas_Fragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener, GridEventos_Fragment.OnFragmentInteractionListener, LoginFragment.OnFragmentInteractionListener, Registro_Fragment.OnFragmentInteractionListener {

    private Fragment fragment;
    private Toolbar toolbar;
    private NavigationView navigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.Principal));
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Fragment fragment=new SelectorModelos_Fragment()
        //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_barbusqueda,fragment).commit();
        fragment = new GridEventos_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main, fragment).commit();

    }

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
        getMenuInflater().inflate(R.menu.home, menu);
        menu.removeItem(R.id.login);
        menu.removeItem(R.id.registrar);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.login) {
            fragment = new LoginFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main, fragment).commit();
            toolbar.setTitle(item.getTitle());
            return true;
        } else if (id == R.id.registrar) {
            fragment = new Registro_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main, fragment).commit();
            toolbar.setTitle(item.getTitle());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean fragment_select = false;
        if (id == R.id.principal_nav) {
            fragment = new GridEventos_Fragment();
            fragment_select = true;
        } else if (id == R.id.lista_nav) {
            fragment = new ListaReservas_Fragment();
            fragment_select = true;
        } else if (id == R.id.cerrar_secion_nav) {
            //navigationView.getMenu().getItem(R.id.cerrar_secion_nav).setVisible(false);
            //navigationView.getMenu().getItem(R.id.iciar_nav).setVisible(true);
            //navigationView.getMenu().getItem(R.id.registrar_nav).setVisible(true);
            //navigationView.getMenu().getItem(R.id.iciar_nav).setIcon(R.drawable.ic_sentiment_satisfied_black_24dp);
            //avigationView.getMenu().getItem(R.id.registrar_nav).setIcon(R.drawable.ic_mood_black_24dp);

        } else if (id == R.id.iciar_nav) {
            fragment = new LoginFragment();
            fragment_select = true;
        } else if (id == R.id.registrar_nav) {
            fragment = new Registro_Fragment();
            fragment_select = true;
        } else if (id == R.id.ajustes_nav) {
            fragment = new Ajustes_Fragment();
            fragment_select = true;
        } else if (id == R.id.info_nav) {
            fragment_select = true;
        }
        if (fragment_select == true) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main, fragment).commit();
            toolbar.setTitle(item.getTitle());
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //@Override
    /*public void recogeInformacion(int num) {
        boolean fragment_select=false;
        if (num==2) {
            fragment1=new GridEventos_Fragment();
            fragment_select=true;
        }
        if (num==1) {
            fragment1 = new ListaEventos_Fragment();
            fragment_select = true;
        }
        if(fragment_select==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment1).commit();
        }
    }*/
}
