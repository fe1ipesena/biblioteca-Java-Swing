package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {   
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;   
    
    public ConexaoBanco() {
        this.servidor = "200.195.171.122";
        this.banco = "grupo11_yuto";
        this.usuario = "grupo11";
        this.senha = "9agmsegriCatwXLH";
    }

    public boolean conectar(){
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.usuario, this.senha);
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
            return false;
        }
    }

    public Connection getConnection() {
        if (this.conexao == null) {
            if (!conectar()) {
                throw new RuntimeException("Não foi possível conectar ao banco de dados.");
            }
        }
        return conexao;
    }

    public void desconectar() {
        if (this.conexao != null) {
            try {
                this.conexao.close();
            } catch (SQLException ex) {
                System.err.println("Erro ao desconectar do banco de dados: " + ex.getMessage());
            }
        }
    }
}
