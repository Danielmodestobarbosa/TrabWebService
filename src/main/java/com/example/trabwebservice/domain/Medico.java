package com.example.trabwebservice.domain;

import com.example.trabwebservice.DTO.CadastroMedicoRequestDTO;

public class Medico {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private MedicoEspecialidade especialidade;
    private String endereco_logradouro;
    private String endereco_numero;
    private String endereco_complemento;
    private String endereco_bairro;
    private boolean ativo;

    public Medico() {

    }

    public Medico(CadastroMedicoRequestDTO cadastroMedicoRequestDTO) {
        this.nome = cadastroMedicoRequestDTO.getNome();
        this.email = cadastroMedicoRequestDTO.getEmail();
        this.telefone = cadastroMedicoRequestDTO.getTelefone();
        this.crm = cadastroMedicoRequestDTO.getCrm();
        this.especialidade = cadastroMedicoRequestDTO.getEspecialidade();
        this.endereco_logradouro = cadastroMedicoRequestDTO.getEndereco().getLogradouro();
        this.endereco_numero = cadastroMedicoRequestDTO.getEndereco().getNumero();
        this.endereco_complemento = cadastroMedicoRequestDTO.getEndereco().getComplemento();
        this.endereco_bairro = cadastroMedicoRequestDTO.getEndereco().getBairro();
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public MedicoEspecialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(MedicoEspecialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getEndereco_logradouro() {
        return endereco_logradouro;
    }

    public void setEndereco_logradouro(String endereco_logradouro) {
        this.endereco_logradouro = endereco_logradouro;
    }

    public String getEndereco_numero() {
        return endereco_numero;
    }

    public void setEndereco_numero(String endereco_numero) {
        this.endereco_numero = endereco_numero;
    }

    public String getEndereco_complemento() {
        return endereco_complemento;
    }

    public void setEndereco_complemento(String endereco_complemento) {
        this.endereco_complemento = endereco_complemento;
    }

    public String getEndereco_bairro() {
        return endereco_bairro;
    }

    public void setEndereco_bairro(String endereco_bairro) {
        this.endereco_bairro = endereco_bairro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
