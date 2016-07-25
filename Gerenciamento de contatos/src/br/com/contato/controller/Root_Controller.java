package br.com.contato.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.com.contato.helper.MySQL_Connect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class Root_Controller implements Initializable{

	@FXML TextField txt_nome, txt_tel;
	@FXML Button btn_inserir;
	@FXML ListView<String> lst_contatos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML public void inserir_contato() {
		//Conectando com o banco de dados atraves de uma class
		Connection con = MySQL_Connect.conectar_db();

		String sql = "insert into contact(name, phone) values(?, ?);";

		//Passando os valores atraves dos programas
		PreparedStatement parametros;
		try {
			parametros = con.prepareStatement(sql);

			//Passando o parametro atraves da posicao do valor
			parametros.setString(1, txt_nome.getText());
			parametros.setString(2, txt_tel.getText());

			//Executando o insert no banco
			parametros.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(sql);
		}


		String contato = txt_nome.getText() + " - " + txt_tel.getText();

		lst_contatos.getItems().add(contato);

		txt_nome.clear();
		txt_tel.clear();
	}

	private void preencher_lista(){

	}

}
