package com.example.trabwebservice.Interfaces;

import com.example.trabwebservice.DTO.CadastroMedicoRequestDTO;
import com.example.trabwebservice.Exceptions.BusinessException;
import com.example.trabwebservice.domain.Medico;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface MedicoWS {

    @WebMethod
    Medico insert(CadastroMedicoRequestDTO medico) throws BusinessException;

    @WebMethod
    Medico update(Medico medico) throws BusinessException;

    @WebMethod
    void delete(int id) throws BusinessException;

    @WebMethod
    Medico findById(int id) throws BusinessException;

    @WebMethod
    List<Medico> getAll() throws BusinessException;
}


