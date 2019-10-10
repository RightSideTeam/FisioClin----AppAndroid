package com.rightside.fisioclin.fragment;


import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rightside.fisioclin.R;
import com.rightside.fisioclin.model.Consulta;
import com.rightside.fisioclin.model.Horario;
import com.rightside.fisioclin.model.Paciente;
import com.rightside.fisioclin.ws.SetupREST;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarcarConsultaDialogFragment extends DialogFragment {

    private TextView textViewHorarioData, textViewHorarioHora, textViewHorarioDiaSemana;
    private TextView textViewPacienteNome, textViewPacienteSobrenome, textViewPacienteEmail, textViewPacienteDataNascimento, textViewPacienteTelefone;
    private Button buttonSalvarConsulta;

    public static MarcarConsultaDialogFragment novaInstancia(Horario horario) {
        MarcarConsultaDialogFragment marcarConsultaDialogFragment = new MarcarConsultaDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("horario", horario);
        marcarConsultaDialogFragment.setArguments(bundle);
        // Required empty public constructor
        return marcarConsultaDialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.dialog_fragment_marcar_consulta,container,false);
        Horario horario = (Horario) getArguments().getSerializable("horario");
      textViewHorarioHora = view.findViewById(R.id.textView_hora_consulta);
      textViewHorarioData = view.findViewById(R.id.textView_data_consulta);
      textViewHorarioDiaSemana = view.findViewById(R.id.textView_dia_consulta);
      textViewPacienteDataNascimento = view.findViewById(R.id.textView_nascimento_paciente);
      textViewPacienteEmail = view.findViewById(R.id.textView_email_paciente);
      textViewPacienteNome = view.findViewById(R.id.textView_nome_paciente);
      textViewPacienteSobrenome = view.findViewById(R.id.textView_sobrenome_paciente);
      textViewPacienteTelefone = view.findViewById(R.id.textView_telefone_paciente);
      buttonSalvarConsulta  = view.findViewById(R.id.button_salvar_consulta);

      textViewHorarioHora.setText(horario.getHora());
      textViewHorarioDiaSemana.setText(horario.getDiaSemana());
      textViewHorarioData.setText(horario.getData());

        Paciente paciente = new Paciente();
        paciente.setNome("Matheus");
        paciente.setEmail("matheusldasilva20088@gmail.com");
        paciente.setDataDeNascimento("07/01/1997");
        paciente.setId(7);
        paciente.setSobrenome("Lima");
        paciente.setUrlFoto("url");
        paciente.setTelefone("321301203");

        textViewPacienteNome.setText(paciente.getNome());
        textViewPacienteSobrenome.setText(paciente.getSobrenome());
        textViewPacienteEmail.setText(paciente.getEmail());
        textViewPacienteDataNascimento.setText(paciente.getDataDeNascimento());
        textViewPacienteTelefone.setText(paciente.getTelefone());

        Toolbar toolbar = view.findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Confira os dados da consulta:");
        toolbar.setTitleTextColor(Color.WHITE);

        buttonSalvarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Consulta consulta = new Consulta("Dor na lombar", horario, paciente);
                SetupREST.apiREST.consulta(consulta).enqueue(new Callback<Consulta>() {
                    @Override
                    public void onResponse(Call<Consulta> call, Response<Consulta> response) {
                        Toast.makeText(getContext(), "Sua consulta foi marcada", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Consulta> call, Throwable t) {

                    }
                });
            }
        });


      return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }
}
