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
import android.widget.Toast;

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
        setSupportActionBar(toolbar);
        fragment=new LoginFragment();
        FragmentManager manager=getSupportFragmentManager();
       FragmentTransaction transaction= manager.beginTransaction();
       transaction.add(R.id.contenedor_main,fragment).commit();
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
        }else if(id == R.id.filtrar){
            Toast.makeText(getApplicationContext(),"opcion2",Toast.LENGTH_LONG).show();
            Fragment fragment2=new Registro_Fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_main,fragment2).commit();

            return true;
        }else if(id == R.id.buscar){
            Toast.makeText(getApplicationContext(),"opcion3",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
