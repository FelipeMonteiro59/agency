package agency.controllers;

import agency.entity.Cidade;
import agency.entity.Local;

public class CtrLocal {

    public CtrLocal() {
    }

    public boolean gravar(String nome,String endereco,String bairro,String numero,String cep, Cidade cidade) {
        Local l = new Local(nome, endereco, bairro, numero, cep, cidade);
        return l.gravar();
    }

    public boolean alterar(int cod, String nome,String endereco,String bairro,String numero,String cep, Cidade cidade) {
        Local l = new Local(cod, nome, endereco, bairro, numero, cep, cidade);
        return l.alterar();
    }

    public boolean excluir(int cod) {
        return new Local().excluir(cod);
    }

}
