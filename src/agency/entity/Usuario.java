package agency.entity;

import agency.db.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {

    private int cod, permissao;
    private String nome, cpf, rg, fone, login, senha;

    //<editor-fold defaultstate="collapsed" desc="CONSTRUCTORS">
    public Usuario() {
    }

    public Usuario(int cod, int permissao, String nome, String cpf, String rg, String fone, String login, String senha) {
        this.cod = cod;
        this.permissao = permissao;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int permissao, String nome, String cpf, String rg,
            String fone, String login, String senha) {
        this.permissao = permissao;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.fone = fone;
        this.login = login;
        this.senha = senha;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET SET">
    public String getSenha() {
        return this.senha;
    }

    public int getPermissao() {
        return this.permissao;
    }

    public int getCod() {
        return this.cod;
    }
    
    public String getLogin(){
        return this.login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="gravar()">
    public boolean gravar() {
        String sql = "insert into usuario (usu_permissao, usu_nome, usu_cpf,"
                + " usu_rg, usu_fone, usu_login, usu_senha) values "
                + "($0,'$1','$2','$3','$4','$5','$6')";
        sql = sql.replace("$0", permissao + "");
        sql = sql.replace("$1", nome);
        sql = sql.replace("$2", cpf);
        sql = sql.replace("$3", rg);
        sql = sql.replace("$4", fone);
        sql = sql.replace("$5", login);
        sql = sql.replace("$6", senha);

        return Banco.con.manipular(sql);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="alterar()">
    public boolean alterar() {
        String sql = "update usuario set usu_permissao=$1, usu_nome='$2', "
                + "usu_cpf='$3', usu_rg='$4', usu_fone='$5', usu_login='$6',"
                + " usu_senha='$7' where usu_cod=$0";
        sql = sql.replace("$0", cod + "");
        sql = sql.replace("$1", permissao + "");
        sql = sql.replace("$2", nome);
        sql = sql.replace("$3", cpf);
        sql = sql.replace("$4", rg);
        sql = sql.replace("$5", fone);
        sql = sql.replace("$6", login);
        sql = sql.replace("$7", senha);
        return Banco.con.manipular(sql);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="excluir()">
    public boolean excluir(int cod) {
        String sql = "delete from usuario where usu_cod = " + cod;
        return Banco.con.manipular(sql);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get(int cod)">
    public Usuario get(int cod) {
        String sql = "select * from usuario where usu_cod=" + cod;
        ResultSet rs = Banco.con.consultar(sql);
        try {
            if (rs.next()) {
                return new Usuario(rs.getInt("usu_cod"),
                        rs.getInt("usu_permissao"), rs.getString("usu_nome"),
                        rs.getString("usu_cpf"), rs.getString("usu_rg"),
                        rs.getString("usu_fone"), rs.getString("usu_login"),
                        rs.getString("usu_senha"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="public Usuario get(String login)">
    public Usuario getByLogin(String login) {
        String sql = "select * from usuario where usu_login='" + login + "'";
        if (login.isEmpty()) //login vazio
        {
            return null;
        }
        ResultSet rs = Banco.con.consultar(sql);
        try {
            if (rs.next()) {
                return new Usuario(rs.getInt("usu_cod"),
                        rs.getInt("usu_permissao"), rs.getString("usu_nome"),
                        rs.getString("usu_cpf"), rs.getString("usu_rg"),
                        rs.getString("usu_fone"), rs.getString("usu_login"),
                        rs.getString("usu_senha"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //</editor-fold>
    
    public ArrayList<Usuario> get(String filtro) {
        String sql = "select * from usuario";
        if (!filtro.isEmpty()) {
            sql += " where " + filtro;
        }
        ArrayList<Usuario> a = new ArrayList();
        ResultSet rs = Banco.con.consultar(sql);
        try {
            while (rs.next()) {
                a.add(new Usuario(rs.getInt("usu_cod"),
                        rs.getInt("usu_permissao"), rs.getString("usu_nome"),
                        rs.getString("usu_cpf"), rs.getString("usu_rg"),
                        rs.getString("usu_fone"), rs.getString("usu_login"),
                        rs.getString("usu_senha")));
            }
            if (!a.isEmpty()) {
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
