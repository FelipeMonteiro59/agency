package agency.controllers;

import agency.entity.Usuario;

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

    public int verificaUsuárioSenha(String login, String senha) {
        Usuario u = new Usuario();
        int flag;
        u = u.getByLogin(login);
        if (u == null) {
            flag = 1;
        } else if (u.getSenha().compareTo(senha) != 0) {
            flag = 2;
        } else {
            flag = 0;
        }
        return flag;
    }

    public int getPermissao(String login){
        return new Usuario().getByLogin(login).getPermissao();
    }
    
    public int getCod(String login){
        return new Usuario().getByLogin(login).getCod();
    }
}
