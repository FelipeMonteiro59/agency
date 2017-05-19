package agency.entity;

import agency.controllers.CtrCidade;
import agency.db.Banco;

public class Local {

    int cod;
    String nome, endereco, bairro, numero, cep;
    Cidade cidade;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Local() {
    }

    public Local(String nome, String endereço, String bairro, String numero,
            String cep, Cidade cidade) {
        this.nome = nome;
        this.endereco = endereço;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Local(int cod, String nome, String endereço, String bairro,
            String numero, String cep, Cidade cidade) {
        this.cod = cod;
        this.nome = nome;
        this.endereco = endereço;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }
    //</editor-fold>

    public boolean gravar() {
        String sql = "insert into local (loc_nome,loc_endereco,loc_bairro,"
                + "Loc_numero,loc_cep,cid_cod) values ('$1','$2','$3','$4','$5'"
                + ",$6)";
        sql = sql.replace("$1", nome);
        sql = sql.replace("$2", endereco);
        sql = sql.replace("$3", bairro);
        sql = sql.replace("$4", numero);
        sql = sql.replace("$5", cep);
        sql = sql.replace("$6", new CtrCidade().getCod(cidade) + "");
        return Banco.con.manipular(sql);
    }

    public boolean alterar() {
        String sql = "update local set loc_nome='$1',loc_endereco='$2',"
                + "loc_bairro='$3',Loc_numero='$4',loc_cep='$5',cid_cod=$6 "
                + "where loc_cod=" + cod;
        sql = sql.replace("$1", nome);
        sql = sql.replace("$2", endereco);
        sql = sql.replace("$3", bairro);
        sql = sql.replace("$4", numero);
        sql = sql.replace("$5", cep);
        sql = sql.replace("$6", new CtrCidade().getCod(cidade) + "");
        return Banco.con.manipular(sql);
    }

    public boolean excluir(int cod) {
        String sql = "delete * from local where loc_cod=" + cod;
        return Banco.con.manipular(sql);
    }

    public Local get() {
        return null;
    }
}
