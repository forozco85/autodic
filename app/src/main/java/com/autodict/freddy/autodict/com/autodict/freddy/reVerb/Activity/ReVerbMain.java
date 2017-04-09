package com.autodict.freddy.autodict.com.autodict.freddy.reVerb.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.autodict.freddy.autodict.R;

/**
 * Created by Freddy on 15/01/2017.
 */

public class ReVerbMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstaceState) {

        super.onCreate(savedInstaceState);
        setContentView(R.layout.re_verb_main);
    }

    /**
     *
     * @param view
     */
    public void lanzarInsertarPalabra(View view) {
        Intent i = new Intent(this, IngresarPalabra.class);
        startActivity(i);
    }

    /**
     *
     * @param view
     */
    public void lanzarJugar(View view) {
        Intent i = new Intent(this, ConsultarPalabra.class);
        startActivity(i);
    }
}
