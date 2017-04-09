package com.autodict.freddy.autodict.com.autodict.freddy.dto;

import com.autodict.freddy.autodict.com.autodict.freddy.enumeration.EnumTipoDivision;

import java.io.Serializable;

/**
 * Created by Freddy on 13/01/2017.
 */

public class DictadoDTO implements Serializable {

    public static final String ATRIBUTE_NAME = "DICTADO_DTO";

    /** */

    /** */
    private String textoOriginal;

    /** */
    private String[] textoParaLectura;

    /** */
    private String textoDictado;

    /** */
    private EnumTipoDivision enumTipoDivision;

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String[] getTextoParaLectura() {
        return textoParaLectura;
    }

    public void setTextoParaLectura(String[] textoParaLectura) {
        this.textoParaLectura = textoParaLectura;
    }

    public String getTextoDictado() {
        return textoDictado;
    }

    public void setTextoDictado(String textoDictado) {
        this.textoDictado = textoDictado;
    }

    public EnumTipoDivision getEnumTipoDivision() {
        return enumTipoDivision;
    }

    public void setEnumTipoDivision(EnumTipoDivision enumTipoDivision) {
        this.enumTipoDivision = enumTipoDivision;
    }
}
