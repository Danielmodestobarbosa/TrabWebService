package com.example.trabwebservice.DTO;

import com.example.trabwebservice.domain.MedicoEspecialidade;

public class ListMedicoRequestDTO {

    private String nome;
    private String email;
    private String CRM;
    private MedicoEspecialidade especialidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public MedicoEspecialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(MedicoEspecialidade especialidade) {
        this.especialidade = especialidade;
    }
}
