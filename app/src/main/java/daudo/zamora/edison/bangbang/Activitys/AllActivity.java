package daudo.zamora.edison.bangbang.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;
import daudo.zamora.edison.bangbang.fragmentos.LoginFragment;
import daudo.zamora.edison.bangbang.fragmentos.Registro_Fragment;
import daudo.zamora.edison.bangbang.interfases.Opciones;

public class AllActivity extends AppCompatActivity implements Opciones , LoginFragment.OnFragmentInteractionListener,Registro_Fragment.OnFragmentInteractionListener{
    private Fragment fragment;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }// cambios en el layout
        });
        fragment=new LoginFragment();
        FragmentManager manager=getSupportFragmentManager();
       FragmentTransaction transaction= manager.beginTransaction();
       transaction.add(R.id.contenedor_main,fragment).commit();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(R.id.filtrar);
        menu.removeItem(R.id.buscar);
        return true;
    }

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
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
            toolbar.setTitle(R.string.layout_login);
            return true;
        }else if(id == R.id.registrar) {
            Fragment fragment2 = new Registro_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main, fragment2).commit();
            toolbar.setTitle(R.string.registrate);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void recogeInformacion(int num) {
        boolean fragment_select=false;
        if (num==1) {
            fragment = new Registro_Fragment();
            fragment_select = true;
        }
        if(fragment_select==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
        }
    }
}
