package daudo.zamora.edison.bangbang.Activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import daudo.zamora.edison.bangbang.Home;
import daudo.zamora.edison.bangbang.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intento3 = new Intent(SplashActivity.this, Home.class);
                startActivity(intento3);
            }
        },4000);
    }
}
