package com.autodict.freddy.autodict.com.autodict.freddy.reVerb.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.autodict.freddy.autodict.R;
import com.autodict.freddy.autodict.com.autodict.freddy.reVerb.DTO.VerboDTO;
import com.autodict.freddy.autodict.com.autodict.freddy.reVerb.persistencia.AlmacenVerbosSQLite;

/**
 * Created by Freddy on 15/01/2017.
 */

public class IngresarPalabra extends Activity {


    public static final String NOMBRE_CLASE = "IngresarPalabra";

    private VerboDTO verbo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.re_verb_ingresar_palabra);

    }

    public VerboDTO getVerboDTO(){
        verbo = new VerboDTO();
        EditText infinitivo = (EditText)findViewById(R.id.editSimple);
        EditText simple = (EditText)findViewById(R.id.editText2);
        EditText participio = (EditText)findViewById(R.id.editText3);
        EditText significado = (EditText)findViewById(R.id.editText4);
        verbo.setInfinitivo(infinitivo.getText().toString());
        verbo.setPasadoSimple(simple.getText().toString());
        verbo.setPasadoParticipio(participio.getText().toString());
        verbo.setSignificado(significado.getText().toString());
        return verbo;
    }

    public void guardarVerbo(View view){
        AlmacenVerbosSQLite almacenVerbos = new AlmacenVerbosSQLite(this);
        String resultado = almacenVerbos.guardarVerbo(getVerboDTO());
        TextView mensaje = (TextView)findViewById(R.id.resultadoInsersion);
        mensaje.setText(resultado);

        EditText infinitivo = (EditText)findViewById(R.id.editSimple);
        EditText simple = (EditText)findViewById(R.id.editText2);
        EditText participio = (EditText)findViewById(R.id.editText3);
        EditText significado = (EditText)findViewById(R.id.editText4);

        infinitivo.setText("");
        simple.setText("");
        participio.setText("");
        significado.setText("");

        System.out.println("palabra ingresa correctamente");
    }

    public void volver (View view){
        Intent i = new Intent(this, ReVerbMain.class);
        startActivity(i);
    }
}
