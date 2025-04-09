package com.example.trabwebservice.DTO;

import com.example.trabwebservice.domain.Medico;
import com.example.trabwebservice.domain.Paciente;

import java.time.LocalDateTime;

public class AgendaConsultaRequestDTO {

    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
