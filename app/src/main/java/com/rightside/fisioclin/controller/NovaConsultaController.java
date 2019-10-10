package com.rightside.fisioclin.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.rightside.fisioclin.fragment.MarcarConsultaDialogFragment;
import com.rightside.fisioclin.model.Horario;

import org.w3c.dom.Text;

public class NovaConsultaController {

    public static void alertaDeNovaConsulta(final FragmentActivity activity, final Horario horario) {
        final AlertDialog.Builder alerta = new AlertDialog.Builder(activity);

        alerta.setTitle("Deseja marcar uma consulta?").setPositiveButton("Avançar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MarcarConsultaDialogFragment.novaInstancia(horario).show(activity.getSupportFragmentManager(), "novaConsulta");
            }
        }).setNegativeButton("Cancelar", null).show();
    }

}


