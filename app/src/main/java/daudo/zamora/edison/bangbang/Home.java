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
import android.widget.Toast;

import daudo.zamora.edison.bangbang.fragmentos.GridEventos_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.ListaEventos_Fragment;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ListaEventos_Fragment.OnFragmentInteractionListener,GridEventos_Fragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /**barra de opciones **/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /** drawer **/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        /** refereccia navegacion **/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /** fragmento inicial **/
        Fragment  fragment=new GridEventos_Fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_main,fragment).commit();

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
    /**--------------------------------------------------------------------------------------
     ** acciones del toolbar
     ** en estos metodos definims las acciones que realizaan los items de de la barra**/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.login) {
            Toast.makeText(getApplicationContext(),"opcion1",Toast.LENGTH_LONG).show();
            return true;
        }else if(id == R.id.filtrar){
            Toast.makeText(getApplicationContext(),"opcion2",Toast.LENGTH_LONG).show();
            return true;
        }else if(id == R.id.buscar){
            Toast.makeText(getApplicationContext(),"opcion3",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**--------------------------------------------------------------------------------------
     ** acciones del navegation drawer
     ** en estos metodos definims las acciones que realizaan los items de de la navegacion**/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment  fragment=null;
        boolean fragment_select=false;
        if (id == R.id.principal) {
            fragment=new GridEventos_Fragment();
            fragment_select=true;
        } else if (id == R.id.lista) {
            fragment=new ListaEventos_Fragment();
            fragment_select=true;
        } else if (id == R.id.promociones) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.ayuda) {

        }
        if(fragment_select==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
