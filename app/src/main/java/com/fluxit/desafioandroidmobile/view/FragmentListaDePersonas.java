package com.fluxit.desafioandroidmobile.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fluxit.desafioandroidmobile.controller.ControllerPersona;
import com.fluxit.desafioandroidmobile.model.Persona;
import com.fluxit.desafioandroidmobile.utils.ResultListener;
import com.fluxit.desafiotecnicoandroid.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaDePersonas extends Fragment implements AdapterPersona.ListenerDeAdapter {

    private ListenerDeFragment listenerDeFragment;
    private RecyclerView contenedorRecyclerview;
    private AdapterPersona adapterPersona;
    private ControllerPersona controllerPersona;
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista_de_personas, container, false);

        contenedorRecyclerview = view.findViewById(R.id.contenedor_recycler_fragmentLista);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        adapterPersona = new AdapterPersona(this);
        controllerPersona = new ControllerPersona();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


        llamarLista();

        contenedorRecyclerview.setLayoutManager(linearLayoutManager);
        contenedorRecyclerview.setAdapter(adapterPersona);



        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                llamarLista();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        return view;
    }


    public void llamarLista(){
        controllerPersona.traerListaDePersonas(new ResultListener<List<Persona>> () {
            @Override
            public void finish(List<Persona> result) {
                adapterPersona.setPersonaList(result);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDeFragment = (ListenerDeFragment) context;
    }


    @Override
    public void informarConsulta(Persona persona) {
        listenerDeFragment.recibirPersona(persona);
    }

    public interface ListenerDeFragment {
        public void recibirPersona(Persona persona);
    }
}
