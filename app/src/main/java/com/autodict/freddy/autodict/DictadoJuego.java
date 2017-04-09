package com.autodict.freddy.autodict;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.autodict.freddy.autodict.R;
import com.autodict.freddy.autodict.com.autodict.freddy.dto.DictadoDTO;
import com.autodict.freddy.autodict.com.autodict.freddy.enumeration.EnumTipoDivision;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.autodict.freddy.autodict.com.autodict.freddy.enumeration.EnumTipoDivision.SIMBOLO_PERSONALIZADO;

/**
 * Created by Freddy on 13/01/2017.
 */

public class DictadoJuego extends Activity  implements TextToSpeech.OnInitListener{
    private DictadoDTO dictadoDTO;
    private List<String> listaFrases;
    //	private String [] textoEnFrases;
    private int indice;

    private static final int MY_DATA_CHECK_CODE = 1;
    private TextToSpeech mTts;

    private boolean interruptor = true;

    private EditText textoAyuda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictado_juego);

        textoAyuda = (EditText)findViewById(R.id.textoAyuda);

        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);

        dictadoDTO = (DictadoDTO) getIntent().getSerializableExtra(DictadoDTO.ATRIBUTE_NAME);
        procesarTextoParaLectura();
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if(requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                mTts = new TextToSpeech(this, this);
            } else {
                Intent installIntent = new Intent();
                installIntent.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
    }

    private void procesarTextoParaLectura() {
        if (dictadoDTO != null) {
            EnumTipoDivision tipoDivision = dictadoDTO.getEnumTipoDivision();
            indice = 0;
            String [] textoParaLectura ;
            switch (tipoDivision) {
                case SIGNO_PUNTUACION:
                    textoParaLectura = dictadoDTO.getTextoOriginal().split(tipoDivision.getExpresionRegular());
                    dictadoDTO.setTextoParaLectura(textoParaLectura);
                    listaFrases = new ArrayList<String>();
                    for (int i = 0; i < dictadoDTO.getTextoParaLectura().length; i++) {
                        listaFrases.add(dictadoDTO.getTextoParaLectura()[i]);
                    }
                    break;
                case PARRAFO:
                    textoParaLectura = dictadoDTO.getTextoOriginal().split(tipoDivision.getExpresionRegular());
                    dictadoDTO.setTextoParaLectura(textoParaLectura);
                    listaFrases = new ArrayList<String>();
                    for (int i = 0; i < dictadoDTO.getTextoParaLectura().length; i++) {
                        listaFrases.add(dictadoDTO.getTextoParaLectura()[i]);
                    }
                    break;

                case SIMBOLO_PERSONALIZADO:

                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Método para reproducir audio asociado al evento del boton
     * @param view
     */
    public void reproducir(View view) {
        if(interruptor){
            mTts.speak(listaFrases.get(indice), TextToSpeech.QUEUE_FLUSH, null);
            interruptor = !interruptor;
        }else {
            mTts.speak(listaFrases.get(indice), TextToSpeech.QUEUE_ADD, null);
            interruptor = !interruptor;
        }
    }
    /**
     * Método para regresar a la frase anterior
     * @param view
     */
    public void anteriorReproduccion(View view) {
        indice--;
        if (indice >= 0) {
            reproducir(view);
        }else {
            indice = 0;
            reproducir(view);
        }
    }

    public void siguienteReproduccion(View view) {
        indice++;
        if(indice < listaFrases.size()){
            reproducir(view);
        }else {
            indice = listaFrases.size()-1;
            reproducir(view);
        }
    }

    public void mostrarAyuda(View view) {
        String ayuda = listaFrases.get(indice);
        if (ayuda != null){
            textoAyuda.setText(ayuda.trim());
        }else {
            Log.i("DictadoJuego","ayuda es nulo.");
        }
    }

    @Override
    public void onInit(int i) {

        mTts.setLanguage(Locale.UK);
    }

    public void comparar(View view ) {
        Log.i("Dictation ","método comparar");
    }
}
