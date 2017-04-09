package com.autodict.freddy.autodict.com.autodict.freddy.reVerb.DTO;

/**
 * Created by Freddy on 15/01/2017.
 */

public class VerboDTO {

    /**	*/
    private String infinitivo;
    /**	*/
    private String pasadoSimple;
    /**	*/
    private String pasadoParticipio;
    /**	*/
    private String significado;

    public String getInfinitivo() {
        return infinitivo;
    }
    public void setInfinitivo(String infinitivo) {
        this.infinitivo = infinitivo;
    }
    public String getPasadoSimple() {
        return pasadoSimple;
    }
    public void setPasadoSimple(String pasadoSimple) {
        this.pasadoSimple = pasadoSimple;
    }
    public String getPasadoParticipio() {
        return pasadoParticipio;
    }
    public void setPasadoParticipio(String pasadoParticipio) {
        this.pasadoParticipio = pasadoParticipio;
    }
    /**
     * @return the significado
     */
    public final String getSignificado() {
        return significado;
    }
    /**
     * @param significado the significado to set
     */
    public final void setSignificado(final String significado) {
        this.significado = significado;
    }
}
