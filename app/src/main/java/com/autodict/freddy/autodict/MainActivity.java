package com.autodict.freddy.autodict;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.autodict.freddy.autodict.com.autodict.freddy.reVerb.Activity.ReVerbMain;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view
     */
    public void lanzarActividadDictado(View view) {
        Intent intension = new Intent(this, DictadoIntro.class);
        startActivity(intension);
    }

    /**
     *
     * @param view
     */
    public void lanzarActividadVerbos(View view) {
        Intent intension = new Intent(this, ReVerbMain.class);
        startActivity(intension);
    }
}
