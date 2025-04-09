package com.example.trabwebservice;

import com.example.trabwebservice.DTO.CadastroPacienteRequestDTO;
import com.example.trabwebservice.Exceptions.BusinessException;
import com.example.trabwebservice.Interfaces.PacienteWS;
import com.example.trabwebservice.Repositories.PacienteRepository;
import com.example.trabwebservice.Service.PacienteService;
import com.example.trabwebservice.domain.Paciente;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "com.example.trabwebservice.Interfaces.PacienteWS")
public class PacienteWSImp implements PacienteWS {
    private PacienteService pacienteService = new PacienteService();


    @Override
    public Paciente insert(CadastroPacienteRequestDTO dto) throws BusinessException {
        Paciente paciente = new Paciente(dto);
        return pacienteService.insert(paciente);
    }
    @Override
    public List<Paciente> listarTodos() throws BusinessException {
        return pacienteService.findAll();
    }
    @Override
    public Paciente buscarPorId(int id) throws BusinessException {
        return pacienteService.findById(id);
    }
    @Override
    public Paciente atualizar(Paciente paciente) throws BusinessException {
        return pacienteService.update(paciente);
    }

    @Override
    public void deletar(int id) throws BusinessException {
        pacienteService.delete(id);
    }

}
