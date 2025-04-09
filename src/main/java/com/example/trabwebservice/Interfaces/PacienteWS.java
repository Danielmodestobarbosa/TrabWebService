package com.example.trabwebservice.Interfaces;

import com.example.trabwebservice.DTO.CadastroPacienteRequestDTO;
import com.example.trabwebservice.Exceptions.BusinessException;
import com.example.trabwebservice.domain.Paciente;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface PacienteWS {

        @WebMethod
        Paciente insert(CadastroPacienteRequestDTO paciente) throws BusinessException;

        @WebMethod
        List<Paciente> listarTodos() throws BusinessException;

        @WebMethod
        Paciente buscarPorId(int id) throws BusinessException;

        @WebMethod
        Paciente atualizar(Paciente paciente) throws BusinessException;

        @WebMethod
        void deletar(int id) throws BusinessException;
    }


