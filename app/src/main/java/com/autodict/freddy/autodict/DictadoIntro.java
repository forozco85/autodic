package com.autodict.freddy.autodict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.autodict.freddy.autodict.com.autodict.freddy.dto.DictadoDTO;
import com.autodict.freddy.autodict.com.autodict.freddy.enumeration.EnumTipoDivision;

/**
 * Created by Freddy on 13/01/2017.
 */

public class DictadoIntro extends Activity {

    private DictadoDTO dictadoDTO;
    private EditText areaTexto;
    private RadioButton radioSignificado ;
    private RadioButton radioParrafo ;
    private RadioButton radioPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.dictado_intro);

        areaTexto = (EditText) findViewById(R.id.editText1);
        radioSignificado = (RadioButton)findViewById(R.id.radioSigPuntua);
        radioParrafo = (RadioButton)findViewById(R.id.radioParrafos);
        radioPersonalizado = (RadioButton)findViewById(R.id.radioPersonalizado);
    }

    public void lanzarActividadDictadoJuego(View view) {
        dictadoDTO = new DictadoDTO();
        if (radioSignificado.isChecked()) {
            dictadoDTO.setEnumTipoDivision(EnumTipoDivision.SIGNO_PUNTUACION);
        } else if (radioParrafo.isChecked()) {
            dictadoDTO.setEnumTipoDivision(EnumTipoDivision.PARRAFO);
        } else if (radioPersonalizado.isChecked()) {
            dictadoDTO.setEnumTipoDivision(EnumTipoDivision.SIMBOLO_PERSONALIZADO);
        } else {
            //no se seleccionó ninguna no se puede continuar
        }
        dictadoDTO.setTextoOriginal(areaTexto.getText() != null ? areaTexto.getText().toString() : null);

        if (dictadoDTO.getTextoOriginal() != null && !dictadoDTO.getTextoOriginal().isEmpty()) {
            Intent intension = new Intent(this, DictadoJuego.class);
            intension.putExtra(DictadoDTO.ATRIBUTE_NAME, dictadoDTO);
            startActivity(intension);
        } else {

        }
    }


}
