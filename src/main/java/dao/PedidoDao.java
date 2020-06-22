package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.Pedido;

public class PedidoDao {
	public void incluir(Pedido pedido) {
		try {
			Connection conexao = Conexao.getConectar();
			PreparedStatement stm = conexao.prepareStatement(
					"insert into pedido(data_pedido,total,id_cliente) values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stm.setString(1, pedido.getDataPedido().toString());
			stm.setFloat(2, pedido.getTotal());
			stm.setInt(3, pedido.getCliente().getId());
			stm.executeUpdate();
			
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			pedido.setId(rs.getInt(1));
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}