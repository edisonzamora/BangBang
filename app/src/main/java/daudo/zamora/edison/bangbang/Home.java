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
import daudo.zamora.edison.bangbang.interfases.Opciones;

     public class Home extends AppCompatActivity
        implements Opciones ,LoginFragment.OnFragmentInteractionListener,Registro_Fragment.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener,ListaEventos_Fragment.OnFragmentInteractionListener,GridEventos_Fragment.OnFragmentInteractionListener{
                private NavigationView navigationView;
                private Fragment fragment;
                private Toolbar toolbar;
                private DrawerLayout drawer;
                private ActionBarDrawerToggle toggle;


        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
                toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                drawer.addDrawerListener(toggle);
                toggle.syncState();
                navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(this);
                fragment=new GridEventos_Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
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
        getMenuInflater().inflate(R.menu.home, menu);
<<<<<<< HEAD
        menu.removeItem(R.id.registrar);
=======
>>>>>>> 5189e4606102ee640df8b07437825b5763b836be
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.login) {
            fragment=new LoginFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
            return true;
        }else if(id == R.id.registrar){
<<<<<<< HEAD
            Toast.makeText(getApplicationContext(),"opcion2",Toast.LENGTH_LONG).show();
=======
            fragment=new Registro_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
>>>>>>> 5189e4606102ee640df8b07437825b5763b836be
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean fragment_select=false;
        if (id == R.id.principal_nav) {
            fragment=new GridEventos_Fragment();
            fragment_select=true;
        } else if (id == R.id.lista_nav) {
            fragment=new ListaReservas_Fragment();
            fragment_select=true;
        } else if (id == R.id.iciar_nav) {
            fragment=new LoginFragment();
            fragment_select=true;
        } else if (id == R.id.registrar_nav) {
            fragment=new Registro_Fragment();
            fragment_select=true;
        }else if (id == R.id.ajustes_nav){
            fragment=new Ajustes_Fragment();
            fragment_select=true;
        }else if(id == R.id.info_nav) {
            fragment = new Ajustes_Fragment();
            fragment_select = true;
        }else if(id == R.id.cerrar_secion_nav){
            fragment = new Ajustes_Fragment();
            fragment_select = true;
        }
        if(fragment_select==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onDestroy() { super.onDestroy(); }

    @Override
    public void recogeInformacion(int num) {
        boolean fragment_select=false;
        if (num==1) {
            fragment = new Registro_Fragment();
            fragment_select = true;
        }
        if (num==2) {
            fragment=new GridEventos_Fragment();
            fragment_select=true;
        }
        if(fragment_select==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
        }
    }
}
