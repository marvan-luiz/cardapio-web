package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.Cliente;

public class ClienteDao {

	public void incluir(Cliente cliente) {
		try {
			Connection conexao = Conexao.getConectar();
			PreparedStatement stm = conexao.prepareStatement(
					"insert into cliente(nome,cidade,endereco,telefone) values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCidade());
			stm.setString(3, cliente.getEndereco());
			stm.setString(4, cliente.getTelefone());
			
			stm.executeUpdate();
			
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			cliente.setId(rs.getInt(1));
			stm.close();
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}