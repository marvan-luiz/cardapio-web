package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.ListaProduto;

public class ListaProdutoDao {
	public void incluir(ListaProduto lsProduto) {
		try {
			Connection conexao = Conexao.getConectar();
			PreparedStatement stm = conexao.prepareStatement(
					"insert into lista_produto(id_produto,id_pedido,quantidade,total) values(?,?,?,?)");
			stm.setInt(1, lsProduto.getIdProduto());
			stm.setInt(2, lsProduto.getIdPedido());
			stm.setInt(3, lsProduto.getQuantidade());
			stm.setFloat(4, lsProduto.getTotal());
			stm.executeUpdate();
			stm.close();
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}