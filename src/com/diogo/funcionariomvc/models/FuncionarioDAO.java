package com.diogo.funcionariomvc.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.diogo.funcionariomvc.vos.Funcionario;
import com.diogo.funcionariomvc.vos.Professor;
import com.diogo.funcionariomvc.vos.Secretario;

public class FuncionarioDAO implements IFuncionarioDAO {

	@Override
	public boolean incluir(Funcionario funcionario) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "aluno", "aluno");

			PreparedStatement sttm = connection.prepareStatement("insert into funcionarios values(?,?,?)");
			sttm.setString(1, funcionario.getNome());
			sttm.setDouble(2, funcionario.getSalario());
			sttm.setInt(3, (funcionario instanceof Professor ? 3 : (funcionario instanceof Secretario ? 2 : 1)));

			sttm.executeUpdate();
			
			if (sttm != null)
				sttm.close();

			sttm = null;

			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException Except) {
			Except.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return false;
	}

	@Override
	public List<Funcionario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
