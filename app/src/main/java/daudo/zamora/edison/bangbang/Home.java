package daudo.zamora.edison.bangbang;


import android.content.Context;
import android.content.SharedPreferences;
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
<<<<<<< HEAD
import android.widget.Toast;

=======
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import daudo.zamora.edison.bangbang.beans.UsuarioBean;
>>>>>>> 716cc349b1bc8fb808ad702c3aa1bb6b766b5643
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
        private ArrayList<Fragment>listafragmentod;
        private SharedPreferences preferences;
         private SharedPreferences.Editor editorprefs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().removeItem(R.id.cerrar_secion_nav);
        listafragmentod=new ArrayList<>();
        listafragmentod.add(new LoginFragment());
        listafragmentod.add(new Registro_Fragment());
        listafragmentod.add(new Ajustes_Fragment());
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,new GridEventos_Fragment()).commit();
        preferences=getSharedPreferences(getString(R.string.datosusuario), Context.MODE_PRIVATE);
        comfiguracion(preferences.getBoolean("registrado",false));
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
            menu.removeItem(R.id.login);
            menu.removeItem(R.id.registrar);
>>>>>>> 716cc349b1bc8fb808ad702c3aa1bb6b766b5643
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.login) {
            fragment=listafragmentod.get(0);
            toolbar.setTitle(R.string.inciar);
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
            return true;
        }else if(id == R.id.registrar){
<<<<<<< HEAD

            Toast.makeText(getApplicationContext(),"opcion2", Toast.LENGTH_LONG).show();

            fragment=new Registro_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();

=======
            fragment=listafragmentod.get(1);
            toolbar.setTitle(R.string.registrar_);
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
>>>>>>> 716cc349b1bc8fb808ad702c3aa1bb6b766b5643
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        boolean fragment_select=false;
        if (id == R.id.principal_nav) {
            fragment=new GridEventos_Fragment();
            toolbar.setTitle(R.string.principal);
            fragment_select=true;
        } else if (id == R.id.lista_nav) {
            fragment=new ListaReservas_Fragment();
            toolbar.setTitle(R.string.lista);
            fragment_select=true;
        } else if (id == R.id.iciar_nav) {
            fragment=listafragmentod.get(0);
            toolbar.setTitle(R.string.inciar);
            fragment_select=true;
        } else if (id == R.id.registrar_nav) {
            fragment=listafragmentod.get(1);
            toolbar.setTitle(R.string.registrar_);
            fragment_select=true;
        }else if (id == R.id.ajustes_nav){
            fragment=listafragmentod.get(2);
            toolbar.setTitle(R.string.ajustes);
            fragment_select=true;
        }else if(id == R.id.info_nav) {
            fragment=listafragmentod.get(2);
            toolbar.setTitle(R.string.informacion);
            fragment_select = true;
        }else if(id == R.id.cerrar_secion_nav){
            editorprefs=preferences.edit();
            editorprefs.remove("registrado");
            editorprefs.commit();
            fragment=new GridEventos_Fragment();
            finish();
            fragment_select=true;
        }
        if(fragment_select==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
        }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onFragmentInteraction(Uri uri) {}

    @Override
    protected void onDestroy() { super.onDestroy(); }
//cambio2
    @Override
    public void  selectFragmrnt(int num) {
        boolean fragment_select=false;
        if (num==1) {
            fragment = listafragmentod.get(1);
            fragment_select = true;
        }
        if (num==2) {
            fragment=new ListaReservas_Fragment();
            fragment_select=true;
        }
        if(fragment_select==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
        }
    }

         @Override
         public void configUser(UsuarioBean usuario) {
             editorprefs=preferences.edit();
             editorprefs.putBoolean("registrado",true);
             editorprefs.putString(getString(R.string.nombreUsuario),usuario.getNombre().toString());
             editorprefs.putString(getString(R.string.correoUsuario),usuario.getCorreo().toString());
             editorprefs.putString(getString(R.string.passUsuario),usuario.getPass().toString());
             editorprefs.putString(getString(R.string.idusuario),Integer.toString(usuario.getId()).toString());
             editorprefs.commit();
             comfiguracion(preferences.getBoolean("registrado",false));
         }
         protected void  comfiguracion(boolean valor){
                 if (valor==true) {
                     onCreateOptionsMenu(toolbar.getMenu());
                     View view = navigationView.getHeaderView(0);
                     ImageView imagenuser = (ImageView) view.findViewById(R.id.image_usuario);
                     imagenuser.setImageResource(R.drawable.clave2);
                     TextView nombre = (TextView) view.findViewById(R.id.texto_usuario);
                     nombre.setText(preferences.getString(getString(R.string.nombreUsuario), ""));
                     TextView correo = (TextView) view.findViewById(R.id.correo_usuario);
                     correo.setText(preferences.getString(getString(R.string.correoUsuario), ""));
                     navigationView.getMenu().removeItem(R.id.iciar_nav);
                     navigationView.getMenu().removeItem(R.id.registrar_nav);
                     navigationView.getMenu().add(R.id.itemss,R.id.cerrar_secion_nav,5,getString(R.string.cerrar) );


                 }
         }
     }
