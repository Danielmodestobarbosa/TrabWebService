package com.example.trabwebservice.Repositories;

import com.example.trabwebservice.Infraestructure.ConnectionFactory;
import com.example.trabwebservice.domain.Consulta;
import com.example.trabwebservice.domain.Medico;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {

    private static final String INSERT = "INSERT INTO consulta (id_paciente, id_medico, data_hora," +
            "                             motivo_cancelamento, status) VALUES(?, ?, ?, ?, ?)";

    private static final String DELETE = "UPDATE consulta SET cancelada = true, motivo_cancelamento = ? WHERE id = ?";

    private static final String FIND_ALL = "SELECT * FROM consulta";

    public Consulta insert(Consulta consulta) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, consulta.getIdMedico());
            preparedStatement.setInt(2, consulta.getIdPaciente());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));
            preparedStatement.setString(4, "");
            preparedStatement.setBoolean(5, false);

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao inserir consulta: " + e.getMessage());
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }

            if(connection != null){
                connection.close();
            }

            if(resultSet != null){
                resultSet.close();
            }
        }

        return consulta;
    }

    public void delete(int id, String motivo) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, motivo);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao deletar consulta: " + e.getMessage());
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }

            if(connection != null){
                connection.close();
            }
        }
    }

    public List<Consulta> findAll() throws SQLException, NamingException {
        List<Consulta> listaConsultas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Consulta consulta = new Consulta();

                consulta.setId(resultSet.getInt("id"));
                consulta.setIdMedico(resultSet.getInt("medico_id"));
                consulta.setIdPaciente(resultSet.getInt("paciente_id"));
                consulta.setDataHora(resultSet.getTimestamp("data").toLocalDateTime());
                listaConsultas.add(consulta);
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao buscar consultas: " + e.getMessage());
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }

            if(connection != null){
                connection.close();
            }

            if(resultSet != null){
                resultSet.close();
            }
        }
        return listaConsultas;
    }

    public Consulta findById(int id) throws SQLException, NamingException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Consulta consulta = null;

        try{
            connection = new ConnectionFactory().getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                consulta = new Consulta();
                consulta.setId(resultSet.getInt("id"));
                consulta.setIdMedico(resultSet.getInt("medico_id"));
                consulta.setIdPaciente(resultSet.getInt("paciente_id"));
                consulta.setDataHora(resultSet.getTimestamp("data").toLocalDateTime());
                consulta.setMotivoCancelamento(resultSet.getString("motivo_cancelamento"));
                consulta.setConsultaCancelada(resultSet.getBoolean("cancelada"));
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Erro ao buscar consultas: " + e.getMessage());
        }
        return consulta;
    }

    }

