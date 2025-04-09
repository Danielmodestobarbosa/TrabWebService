package com.example.trabwebservice;


import com.example.trabwebservice.DTO.AgendaConsultaRequestDTO;
import com.example.trabwebservice.Exceptions.BusinessException;
import com.example.trabwebservice.Interfaces.ConsultaWS;
import com.example.trabwebservice.Service.ConsultaService;
import com.example.trabwebservice.domain.Consulta;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@WebService(endpointInterface = "com.example.trabwebservice.Interfaces.ConsultaWS")
public class ConsultaWSImp implements ConsultaWS {
    @Override
    public Consulta insert(AgendaConsultaRequestDTO dto) throws BusinessException, NamingException {
        Consulta consulta = new Consulta();
        ConsultaService consultaService = new ConsultaService();
        return consultaService.insert(consulta);
    }

    @Override
    public List<Consulta> findAll() throws BusinessException, NamingException {
        ConsultaService consultaService = new ConsultaService();
        return consultaService.findAll();
    }

    @Override
    public void delete(int id, String motivo) throws BusinessException, NamingException, SQLException {
        ConsultaService consultaService = new ConsultaService();
        consultaService.delete(id, motivo);
    }
}




