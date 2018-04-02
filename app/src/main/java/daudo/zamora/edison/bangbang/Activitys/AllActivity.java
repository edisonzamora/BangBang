package daudo.zamora.edison.bangbang.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import daudo.zamora.edison.bangbang.R;

public class AllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
            Intent intent=new Intent(this, AllActivity.class);
            startActivity(intent);
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
}
