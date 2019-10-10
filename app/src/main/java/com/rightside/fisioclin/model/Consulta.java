package com.rightside.fisioclin.model;

import java.io.Serializable;

public class Consulta implements Serializable {

    private String descricao;
    private Horario horario;
    private Paciente paciente;
    private int id;

    public Consulta(String descricao, Horario horario, Paciente paciente) {
        setDescricao(descricao);
        setHorario(horario);
        setPaciente(paciente);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
