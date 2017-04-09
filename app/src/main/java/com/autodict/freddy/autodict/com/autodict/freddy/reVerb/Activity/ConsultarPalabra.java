package com.autodict.freddy.autodict.com.autodict.freddy.reVerb.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.autodict.freddy.autodict.R;
import com.autodict.freddy.autodict.com.autodict.freddy.reVerb.DTO.VerboDTO;
import com.autodict.freddy.autodict.com.autodict.freddy.reVerb.persistencia.AlmacenVerbosSQLite;

import java.util.List;

/**
 * Created by Freddy on 15/01/2017.
 */

public class ConsultarPalabra extends Activity {

    private List<VerboDTO> lista ;

    private int posicion;

    private boolean bandera=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.re_verb_consultar_palabra);
        AlmacenVerbosSQLite almacen = new AlmacenVerbosSQLite(this);
        lista = almacen.consultarListaVerbos();
    }

    public void siguiente(View view){
        if(bandera){

            TextView infinitivo = (TextView)findViewById(R.id.textInfinitivo);
            TextView lableParticipio = (TextView)findViewById(R.id.textRespuestaParticipio);
            TextView lableSimple = (TextView)findViewById(R.id.textRespuestaSimple);
            TextView lableSignificado = (TextView)findViewById(R.id.textSignificado);
            EditText edicionSimple = (EditText)findViewById(R.id.editSimple);
            EditText edicionParticipio = (EditText)findViewById(R.id.editParticipio);

            lableParticipio.setText("");
            lableSimple.setText("");
            lableSignificado.setText("");
            infinitivo.setText("");
            edicionSimple.setText("");
            edicionParticipio.setText("");

            int numeroVerbos = lista.size();
            if (numeroVerbos != 0) {
                posicion = (int) (Math.random() * numeroVerbos);
                VerboDTO verbo = lista.get(posicion);
                infinitivo.setText(verbo.getInfinitivo());
            }else {
                lableSignificado.setText("Se ha terminado la lista de verbos!!!");
            }
            bandera=false;
        }

    }

    public void validarRespuesta(View view){
        if(!bandera && lista.size() > 0){

            VerboDTO verbo = lista.get(posicion);
            TextView lableParticipio = (TextView)findViewById(R.id.textRespuestaParticipio);
            TextView lableSimple = (TextView)findViewById(R.id.textRespuestaSimple);
            TextView lableSignificado = (TextView)findViewById(R.id.textSignificado);

            lableParticipio.setText(verbo.getPasadoParticipio());
            lableSimple.setText(verbo.getPasadoSimple());
            lableSignificado.setText(verbo.getSignificado());

            lista.remove(posicion);
            bandera=true;
        } else if (lista.size() <= 0) {
            Log.i("verb.validarRespuesta","lista vacia");
        }

    }
}
