package agency.controllers;

import agency.entity.Usuario;
import java.util.ArrayList;

public class CtrUsuario {
    //<editor-fold defaultstate="collapsed" desc="ENTITY VARS">
    //private int cod, permissao;
    //private String nome, cpf, rg, fone, login, senha;
    //</editor-fold>    

    public CtrUsuario() {
    }

    public boolean gravar(int permissao, String nome, String cpf, String rg,
            String fone, String login, String senha) {
        Usuario u = new Usuario(permissao, nome, cpf, rg, fone, login, senha);
        return u.gravar();
    }

    public boolean alterar(int cod, int permissao, String nome, String cpf, String rg,
            String fone, String login, String senha) {
        Usuario u = new Usuario(cod, permissao, nome, cpf, rg, fone, login, senha);
        return u.alterar();
    }

    public boolean excluir(int cod) {
        Usuario u = new Usuario();
        return u.excluir(cod);
    }

    public boolean verificaUsuárioSenha(String login, String senha) {
        Usuario u = new Usuario();
        u = u.getByLogin(login);
        if (u == null || u.getSenha().compareTo(senha) != 0) {
            return false;
        }
        return true;
    }

    public int getPermissao(String login) {
        return new Usuario().getByLogin(login).getPermissao();
    }

    public int getCod(String login) {
        return new Usuario().getByLogin(login).getCod();
    }

    public ArrayList<Usuario> getUsuarios(String filtro) {
        return new Usuario().get(filtro);
    }
}
