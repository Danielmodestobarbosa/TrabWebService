package com.example.trabwebservice.Repositories;

import com.example.trabwebservice.Infraestructure.ConnectionFactory;
import com.example.trabwebservice.domain.Medico;
import com.example.trabwebservice.domain.MedicoEspecialidade;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {

    private static final String INSERT =
            "INSERT INTO medicos (nome, email, telefone, crm, especialidade, ufEndereco, cepEndereco, " +
            "endereco_logradouro, numeroEndereco, complementoEndereco, bairroEndereco, cidadeEndereco) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE =
            "UPDATE medico SET " + "nome = ?, " + "email = ?, " + "telefone = ?, " + "crm = ?, " +
            "especialidade = ?, " + "ufEndereco = ?, " + "cepEndereco = ?, " + "logradouroEndereco = ?, " +
            "numeroEndereco = ?, " + "complementoEndereco = ?, " + "bairroEndereco = ?, " + "cidadeEndereco = ?, " +
            "ativo = ? " + "WHERE id = ?";

    private static final String DELETE_BY_ID = "DELETE FROM medico WHERE id = ?";

    private static final String FIND_ALL = "SELECT * FROM medico";

    private static final String FIND_BY_ID = "SELECT * FROM medico WHERE id = ?";

    public Medico insert(Medico medico) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getTelefone());
            preparedStatement.setString(4, medico.getCrm());
            preparedStatement.setString(5, medico.getEspecialidade().toString());
            preparedStatement.setString(8, medico.getEndereco_logradouro());
            preparedStatement.setString(9, medico.getEndereco_numero());
            preparedStatement.setString(10, medico.getEndereco_complemento());
            preparedStatement.setString(11, medico.getEndereco_bairro());

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                medico.setId(resultSet.getInt(1));
            }

        }finally{
            if (preparedStatement != null)
                preparedStatement.close();

            if(resultSet != null)
                resultSet.close();

            if(connection != null)
                connection.close();
        }

        return medico;
    }


    public void update(Medico medico) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getEmail());
            preparedStatement.setString(3, medico.getTelefone());
            preparedStatement.setString(4, medico.getCrm());
            preparedStatement.setString(5, medico.getEspecialidade().toString());
            preparedStatement.setString(8, medico.getEndereco_logradouro());
            preparedStatement.setString(9, medico.getEndereco_numero());
            preparedStatement.setString(10, medico.getEndereco_complemento());
            preparedStatement.setString(11, medico.getEndereco_bairro());


        }finally{
            if(preparedStatement != null)
                preparedStatement.close();

            if(connection != null)
                connection.close();
        }
    }

    public List<Medico> findAll() throws SQLException, NamingException{
        List<Medico> listaMedicos = new ArrayList<Medico>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Medico medico = new Medico();
                medico.setId(resultSet.getInt("id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEmail(resultSet.getString("email"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setEspecialidade(MedicoEspecialidade.valueOf(resultSet.getString("especialidade").toUpperCase()));
                medico.setEndereco_logradouro(resultSet.getString("Endereco_logradouro"));
                medico.setEndereco_numero(resultSet.getString("Endereco_numero"));
                medico.setEndereco_complemento(resultSet.getString("Endereco_complemento"));
                medico.setEndereco_bairro(resultSet.getString("Endereco_bairro"));

                listaMedicos.add(medico);
            }
        }finally{
            if(preparedStatement != null)
                preparedStatement.close();

            if(resultSet != null)
                resultSet.close();

            if(connection != null)
                connection.close();
        }
        return listaMedicos;
    }

    public void delete(int id) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }finally {
            if(preparedStatement != null)
                preparedStatement.close();

            if(connection != null)
                connection.close();
        }

    }

    public Medico findById(int id) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Medico medico = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                medico = new Medico();

                medico.setId(resultSet.getInt("id"));
                medico.setNome(resultSet.getString("nome"));
                medico.setEmail(resultSet.getString("email"));
                medico.setTelefone(resultSet.getString("telefone"));
                medico.setCrm(resultSet.getString("crm"));
                medico.setEspecialidade(MedicoEspecialidade.valueOf(resultSet.getString("especialidade").toUpperCase()));
                medico.setEndereco_logradouro(resultSet.getString("Endereco_logradouro"));
                medico.setEndereco_numero(resultSet.getString("Endereco_numero"));
                medico.setEndereco_complemento(resultSet.getString("Endereco_complemento"));
                medico.setEndereco_bairro(resultSet.getString("Endereco_bairro"));
            }


        }finally{
            if(preparedStatement != null)
                preparedStatement.close();

            if(resultSet != null)
                resultSet.close();

            if(connection != null)
                connection.close();
        }
        return medico;
    }

    public List<Medico> findMedicosDisponiveisNaDataHora(LocalDateTime dataHoraConsulta) {
        // Simula a busca de médicos disponíveis para o horário
        return List.of(new Medico()); // Retorna um médico fictício disponível
    }

}
