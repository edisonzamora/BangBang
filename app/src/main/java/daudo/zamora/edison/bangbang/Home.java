package daudo.zamora.edison.bangbang;


import android.content.Intent;
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
import daudo.zamora.edison.bangbang.Activitys.AllActivity;
import daudo.zamora.edison.bangbang.fragmentos.Ajustes_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.GridEventos_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.ListaEventos_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.LoginFragment;
import daudo.zamora.edison.bangbang.fragmentos.Registro_Fragment;
import daudo.zamora.edison.bangbang.fragmentos.SelectorModelos_Fragment;
import daudo.zamora.edison.bangbang.interfases.Opciones;

public class Home extends AppCompatActivity
        implements Opciones , NavigationView.OnNavigationItemSelectedListener,ListaEventos_Fragment.OnFragmentInteractionListener,GridEventos_Fragment.OnFragmentInteractionListener{

      Fragment fragment1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /**barra de opciones **/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
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
        navigationView.getMenu().removeItem(R.id.cerrar_secion);
        /** fragmento seleccion de modelo **/
        Fragment fragment=new SelectorModelos_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_barbusqueda,fragment).commit();
        /** fragmento podor defecto **/
        Fragment fragment1=new GridEventos_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment1).commit();

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
     ** items del toolbar
     ** en estos metodos definims los items de la barra**/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        menu.removeItem(R.id.registrar);
        menu.removeItem(R.id.buscar);
        return true;
    }
    /**
     * define la acciones del menu, de cada item
     *
     * **/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.login) {
            Intent intent=new Intent(this, AllActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.filtrar){
            Toast.makeText(getApplicationContext(),"opcion2",Toast.LENGTH_LONG).show();
            return true;
        }else if(id == R.id.buscar){
           /* Fragment fragment = null;
            if(mostrarbarrabuscar==false) {
                Toast.makeText(getApplicationContext(), "opcion3", Toast.LENGTH_LONG).show();
                fragment=new Buscador_Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_barbusqueda, fragment).commit();
                mostrarbarrabuscar=false;
                return true;
            }
           else if(mostrarbarrabuscar==true){
                fragment=new SelectorModelos_Fragment();
                Toast.makeText(getApplicationContext(), "opcion4", Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_barbusqueda,fragment).commit();
                mostrarbarrabuscar=true;
                return true;
            }*/

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
        } else if (id == R.id.ajustes) {
            fragment=new Ajustes_Fragment();
            fragment_select=true;
        } else if (id == R.id.cerrar_secion) {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void recogeInformacion(int num) {
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
    }
}
