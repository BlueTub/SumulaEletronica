package com.projeto.sumula.sumulaeletronica;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pedro on 22/09/2016.
 */

public class Teste {

    private List<String> lista;

    public void teste () {
        lista = new ArrayList<String>();

        lista.stream().count();

        lista.add("aa");


    }
}
