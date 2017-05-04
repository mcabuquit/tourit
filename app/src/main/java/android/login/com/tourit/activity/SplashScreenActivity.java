package android.login.com.tourit.activity;

import android.app.Activity;
import android.content.Intent;
import android.login.com.tourit.R;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Denzel on 05/01/2017.
 */

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            }
        }, 2000);
    }


}
