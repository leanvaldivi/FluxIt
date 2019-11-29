package com.fluxit.desafioandroidmobile.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fluxit.desafioandroidmobile.model.Persona;
import com.fluxit.desafiotecnicoandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePersona extends Fragment {

    public static final String CLAVE_PERSONA = "clavePersona";

    private TextView nombre, apellido, edad, email;
    private ImageView imagen;
    private View view;
    private Persona personaSeleccionada;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detalle_persona, container, false);
        buscarVariables();
        Bundle bundle = getArguments();
        personaSeleccionada = (Persona) bundle.getSerializable(CLAVE_PERSONA);
        setearVariables();
       return view;
    }

    public void buscarVariables(){
        nombre = view.findViewById(R.id.textViewNombreFragmentDetalle);
        apellido = view.findViewById(R.id.textViewApellidoFragmentDetalle);
        edad = view.findViewById(R.id.textViewEdadFragmentDetalle);
        email = view.findViewById(R.id.textViewMailFragmentDetalle);
        imagen = view.findViewById(R.id.imagen_ImageView_fragmentDetallePersona_ImageView_foto);
    }

    public void setearVariables() {
        Glide.with(imagen.getContext()).load(personaSeleccionada.getPicture().getLarge())
                .placeholder(R.drawable.loading).into(imagen);
        nombre.setText(personaSeleccionada.getName().getFirst());
        apellido.setText(personaSeleccionada.getName().getLast());
        edad.setText(personaSeleccionada.getEdad().getEdad());
        email.setText(personaSeleccionada.getEmail());
    }
}
