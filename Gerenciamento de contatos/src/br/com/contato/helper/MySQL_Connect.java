package br.com.contato.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL_Connect {
	public static Connection conectar_db(){

		Connection con = null;

		try {
			//Especificando o driver de conex�o MYSQL
			Class.forName("com.mysql.jdbc.Driver");

			//String de conex�o com o ip do banco, o banco de dados usados, usuario e senha
			con = DriverManager.getConnection("jdbc:mysql://10.107.134.57/contatos", "root", "root");

		} catch (ClassNotFoundException | SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
