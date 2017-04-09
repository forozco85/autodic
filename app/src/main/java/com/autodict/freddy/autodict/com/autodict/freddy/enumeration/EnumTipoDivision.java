package com.autodict.freddy.autodict.com.autodict.freddy.enumeration;

/**
 * Created by Freddy on 13/01/2017.
 */

public enum EnumTipoDivision {
    SIGNO_PUNTUACION("[,.;?:]",1L),
    PARRAFO("[.\n]",2L),
    SIMBOLO_PERSONALIZADO("",3L);

    private final String expresionRegular;
    private final Long codigo;

    public static EnumTipoDivision[] ENUM_VALUES = EnumTipoDivision.values();

    private EnumTipoDivision(String expresionRegular, Long codigo){
        this.expresionRegular = expresionRegular;
        this.codigo = codigo;
    }
    public static EnumTipoDivision getEnum(String codigo){
        for (EnumTipoDivision tipo : EnumTipoDivision.ENUM_VALUES) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
    /**
     * @return the expresionRegular
     */
    public final String getExpresionRegular() {
        return expresionRegular;
    }

    /**
     * @return the codigo
     */
    public final Long getCodigo() {
        return codigo;
    }

}
