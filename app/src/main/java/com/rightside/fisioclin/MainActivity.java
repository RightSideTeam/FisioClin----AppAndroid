package com.rightside.fisioclin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.rightside.fisioclin.adapter.HorarioAdapter;
import com.rightside.fisioclin.model.Horario;
import com.rightside.fisioclin.ws.SetupREST;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        toolbar.setTitle("Horarios disponiveis:");
        toolbar.setTitleTextColor(Color.WHITE);

        RecyclerView recyclerViewHorarios = findViewById(R.id.recyclerview_horarios);
        recyclerViewHorarios.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewHorarios.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        final HorarioAdapter horarioAdapter = new HorarioAdapter(getApplicationContext(), MainActivity.this);

        recyclerViewHorarios.setAdapter(horarioAdapter);

        SetupREST.apiREST.listHorarios().enqueue(new Callback<List<Horario>>() {
            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                horarioAdapter.atualiza(response.body());
                Log.d("certo", call.toString());
            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {
                Log.d("erro", call.toString());
                t.printStackTrace();
            }
        });
    }
}
