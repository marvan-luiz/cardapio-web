package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoDao {
	public Produto buscarID(int id) {
		Produto p = new Produto();
		try {
			Connection conexao = Conexao.getConectar();
			PreparedStatement pst = conexao.prepareStatement("select * from produto where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getFloat("preco"));
			}
			pst.close();
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return p;
	}
	
	public List<Produto> buscarTudo() {
		List<Produto> ls = new ArrayList<Produto>();
		try {
			Connection conexao = Conexao.getConectar();
			PreparedStatement pst = conexao.prepareStatement("select * from produto");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getFloat("preco"));
				ls.add(p);
			}
			pst.close();
			conexao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ls;
	}

}