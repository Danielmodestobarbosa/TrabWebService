package com.example.trabwebservice;

import com.example.trabwebservice.DTO.CadastroMedicoRequestDTO;
import com.example.trabwebservice.Exceptions.BusinessException;
import com.example.trabwebservice.Interfaces.MedicoWS;
import com.example.trabwebservice.Service.MedicoService;
import com.example.trabwebservice.domain.Medico;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "com.example.trabwebservice.Interfaces.MedicoWS")
public class MedicoWSImp implements MedicoWS {

    @Override
    public Medico insert(CadastroMedicoRequestDTO medicoDTO) throws BusinessException {
        MedicoService service = new MedicoService();
        Medico medico = new Medico(medicoDTO);
        return service.insert(medico);
    }

    @Override
    public Medico update(Medico medico) throws BusinessException {
        MedicoService service = new MedicoService();
        return service.update(medico);
    }

    @Override
    public void delete(int id) throws BusinessException {
        MedicoService service = new MedicoService();
        service.delete(id);
    }

    @Override
    public Medico findById(int id) throws BusinessException {
        MedicoService service = new MedicoService();
        return service.findById(id);
    }

    @Override
    public List<Medico> getAll() throws BusinessException {
        MedicoService service = new MedicoService();
        return service.findAll();
    }
}
