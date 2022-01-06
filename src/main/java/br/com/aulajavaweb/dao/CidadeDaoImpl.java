package br.com.aulajavaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.aulajavaweb.model.Cidade;
import br.com.aulajavaweb.entity.DBConnectionUTIL;


import br.com.aulajavaweb.entity.GenerateUniqueIDUtil;

public class CidadeDaoImpl implements CidadeDao {

	Connection connection = null;
	ResultSet resultset = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<Cidade> get() {
		List<Cidade> list = null;
		Cidade cidade = null;
		try {
			list = new ArrayList<Cidade>();
			String sql = "SELECT * FROM cidade";
			connection = DBConnectionUTIL.openConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			while (resultset.next()) {
				cidade = new Cidade();
				cidade.setId(resultset.getInt("CID_CODIGO"));
				cidade.setCidade(resultset.getString("CID_DESCRICAO"));
				cidade.setEstado(resultset.getString("CID_UF"));
				list.add(cidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Cidade get(int id) {
		Cidade cidade = null;
		try {
			cidade = new Cidade();
			String sql = "SELECT * FROM cidade where CID_CODIGO=" + id;
			connection = DBConnectionUTIL.openConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);
			if (resultset.next()) {
				cidade.setId(resultset.getInt("CID_CODIGO"));
				cidade.setCidade(resultset.getString("CID_DESCRICAO"));
				cidade.setEstado(resultset.getString("CID_UF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cidade;
	}

	@Override
	public boolean save(Cidade cidade) {
		boolean flag = false;
		GenerateUniqueIDUtil uniqid = new GenerateUniqueIDUtil();
		try {
			String sql = "INSERT INTO cidade (CID_CODIGO, CID_DESCRICAO, CID_UF) VALUES"
					+"('"+uniqid.GetRandomNumber()+"','"+cidade.getCidade()+"', '"+cidade.getEstado()+"')";
			connection = DBConnectionUTIL.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = false;
		try {
			String sql = "DELETE FROM cidade where CID_CODIGO="+id;
			connection = DBConnectionUTIL.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean update(Cidade cidade) {
		boolean flag = false;
		try {
			String sql = "UPDATE cidade SET CID_DESCRICAO = '"+cidade.getCidade()+"', "
					+ "CID_UF = '"+cidade.getEstado()+"' where CID_CODIGO="+cidade.getId();
			connection = DBConnectionUTIL.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
