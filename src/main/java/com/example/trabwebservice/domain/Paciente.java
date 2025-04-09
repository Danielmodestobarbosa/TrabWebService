package com.example.trabwebservice.domain;

import com.example.trabwebservice.DTO.CadastroPacienteRequestDTO;

public class Paciente {


    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String endereco_logradouro;
    private String endereco_numero;
    private String endereco_complemento;
    private String endereco_bairro;
    private String endereco_cidade;
    private String endereco_uf;
    private String endereco_cep;
    private boolean ativo;

    public Paciente() {

    }

    public Paciente(CadastroPacienteRequestDTO cadastroPacienteRequestDTO){
        this.nome = cadastroPacienteRequestDTO.getNome();
        this.email = cadastroPacienteRequestDTO.getEmail();
        this.telefone = cadastroPacienteRequestDTO.getTelefone();
        this.cpf = cadastroPacienteRequestDTO.getCpf();
        this.endereco_logradouro = cadastroPacienteRequestDTO.getEndereco().getLogradouro();
        this.endereco_cidade = cadastroPacienteRequestDTO.getEndereco().getCidade();
        this.endereco_numero = cadastroPacienteRequestDTO.getEndereco().getNumero();
        this.endereco_bairro = cadastroPacienteRequestDTO.getEndereco().getBairro();
        this.endereco_uf = cadastroPacienteRequestDTO.getEndereco().getUf();
        this.endereco_cep = cadastroPacienteRequestDTO.getEndereco().getCep();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEndereco_cidade() {
        return endereco_cidade;
    }

    public void setEndereco_cidade(String endereco_cidade) {
        this.endereco_cidade = endereco_cidade;
    }

    public String getEndereco_uf() {
        return endereco_uf;
    }

    public void setEndereco_uf(String endereco_uf) {
        this.endereco_uf = endereco_uf;
    }

    public String getEndereco_cep() {
        return endereco_cep;
    }

    public void setEndereco_cep(String endereco_cep) {
        this.endereco_cep = endereco_cep;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
