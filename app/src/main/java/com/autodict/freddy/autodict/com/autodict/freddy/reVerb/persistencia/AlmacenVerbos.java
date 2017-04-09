package com.autodict.freddy.autodict.com.autodict.freddy.reVerb.persistencia;

import com.autodict.freddy.autodict.com.autodict.freddy.reVerb.DTO.VerboDTO;

import java.util.List;

/**
 * Created by Freddy on 15/01/2017.
 */

public interface AlmacenVerbos {

    /**
     *
     * @param verbo
     * @return
     */
    public String guardarVerbo(VerboDTO verbo);

    /**
     *
     * @param cantidad
     * @return
     */
    public List<VerboDTO> listaVerbos (int cantidad);
}
