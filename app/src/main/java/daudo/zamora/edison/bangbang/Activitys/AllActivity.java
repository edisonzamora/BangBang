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

public class AllActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener,Registro_Fragment.OnFragmentInteractionListener{
Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
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
            Toast.makeText(getApplicationContext(),"opcion1",Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment).commit();
            return true;
        }else if(id == R.id.registrar) {
            Toast.makeText(getApplicationContext(), "opcion2", Toast.LENGTH_LONG).show();
            Fragment fragment2 = new Registro_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main, fragment2).commit();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}