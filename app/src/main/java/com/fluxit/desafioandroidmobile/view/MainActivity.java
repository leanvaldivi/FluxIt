package com.fluxit.desafioandroidmobile.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.fluxit.desafioandroidmobile.model.Persona;
import com.fluxit.desafiotecnicoandroid.R;

public class MainActivity extends AppCompatActivity implements FragmentListaDePersonas.ListenerDeFragment{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pegarFragment(new FragmentListaDePersonas());

    }

    private void pegarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_contenedorFragment, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void recibirPersona(Persona persona) {
        Toast.makeText(this, persona.getName().getFirst(), Toast.LENGTH_LONG).show();
        FragmentDetallePersona fragmentDetallePersona = new FragmentDetallePersona();
        Bundle bundle = new Bundle();
        bundle.putSerializable(fragmentDetallePersona.CLAVE_PERSONA,persona);
        fragmentDetallePersona.setArguments(bundle);
        pegarFragment(fragmentDetallePersona);
    }
}
