package com.fluxit.desafioandroidmobile.controller;

import com.fluxit.desafioandroidmobile.model.Persona;
import com.fluxit.desafioandroidmobile.model.PersonaDao;
import com.fluxit.desafioandroidmobile.utils.ResultListener;

import java.util.List;

public class ControllerPersona {

    public void traerListaDePersonas(final ResultListener<List<Persona>> listenerDeLaVista){
        PersonaDao personaDao = new PersonaDao();

        personaDao.traerListaPersonas(new ResultListener<List<Persona>>() {
            @Override
            public void finish(List<Persona> result) {
                if (result != null) {
                    listenerDeLaVista.finish(result);
                }
            }
        });
    }
}
