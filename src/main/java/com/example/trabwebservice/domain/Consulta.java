package com.example.trabwebservice.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;


//Nesta classe trazemos o paciente, o médico a data e a hora da consulta.
public class Consulta {
    private int id;
    private int idPaciente;
    private int idMedico;
    private LocalDateTime dataHora;
    private String motivoCancelamento;
    private boolean consultaCancelada;



    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public boolean isConsultaCancelada() {
        return consultaCancelada;
    }

    public void setConsultaCancelada(boolean consultaCancelada) {
        this.consultaCancelada = consultaCancelada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
