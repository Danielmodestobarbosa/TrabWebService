package com.example.trabwebservice.Interfaces;


import com.example.trabwebservice.DTO.AgendaConsultaRequestDTO;
import com.example.trabwebservice.Exceptions.BusinessException;
import com.example.trabwebservice.domain.Consulta;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@WebService
public interface ConsultaWS {

    @WebMethod
    Consulta insert(AgendaConsultaRequestDTO dto) throws BusinessException, NamingException;

    @WebMethod
    List<Consulta> findAll() throws BusinessException, NamingException;

    @WebMethod
    void delete(int id, String motivo) throws BusinessException, NamingException, SQLException;
}
