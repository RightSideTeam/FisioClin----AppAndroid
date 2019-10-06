package com.rightside.fisioclin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.fisioclin.R;
import com.rightside.fisioclin.model.Horario;

import java.util.ArrayList;
import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder> {

    private List<Horario> listHorarios;
    private Context context;


    public HorarioAdapter(Context context) {
        this.context = context;
        this.listHorarios = new ArrayList<>();
    }

    @NonNull
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_horario, parent, false);
        return new HorarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder holder, int position) {
        Horario horario = listHorarios.get(position);
        holder.textViewData.setText(horario.getData());
        holder.textViewHora.setText(horario.getHora());
        holder.textViewDiaSemana.setText(horario.getDiaSemana());
    }

    @Override
    public int getItemCount() {
        if(listHorarios == null) {
            return 0;
        }
        return listHorarios.size();
    }

    public void atualiza(List<Horario> listHorarios) {
        this.listHorarios = listHorarios;
        notifyDataSetChanged();

    }


    class HorarioViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewData, textViewDiaSemana, textViewHora;

        public HorarioViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewData = itemView.findViewById(R.id.textView_data);
            textViewDiaSemana = itemView.findViewById(R.id.textView_dia_semana);
            textViewHora = itemView.findViewById(R.id.textView_hora);
        }
    }
}
