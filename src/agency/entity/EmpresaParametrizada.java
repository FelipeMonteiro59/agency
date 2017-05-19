package agency.entity;

import agency.controllers.CtrCidade;
import agency.db.Banco;

public class EmpresaParametrizada {

    int cod;
    String nome, razao, cnpj, fone, email, endereco, bairro, cep;
    Cidade cidade;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public EmpresaParametrizada() {
    }

    public EmpresaParametrizada(String nome, String razao, String cnpj, String fone, String email, String endereco, String bairro, String cep, Cidade cidade) {
        this.nome = nome;
        this.razao = razao;
        this.cnpj = cnpj;
        this.fone = fone;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    public EmpresaParametrizada(int cod, String nome, String razao, String cnpj, String fone, String email, String endereco, String bairro, String cep, Cidade cidade) {
        this.cod = cod;
        this.nome = nome;
        this.razao = razao;
        this.cnpj = cnpj;
        this.fone = fone;
        this.email = email;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    //</editor-fold>

    public boolean gravar() {
        String sql = "insert into empresaparametrizada (empp_nome, empp_razao, "
                + "empp_cnpj, empp_fone, empp_email, empp_endereco, empp_bairro,"
                + " empp_cep, cid_cod) values ('$1','$2','$3','$4','$5','$6',"
                + "'$7','$8',$9)";
        sql = sql.replace("$1", nome);
        sql = sql.replace("$2", razao);
        sql = sql.replace("$3", cnpj);
        sql = sql.replace("$4", fone);
        sql = sql.replace("$5", email);
        sql = sql.replace("$6", endereco);
        sql = sql.replace("$7", bairro);
        sql = sql.replace("$8", cep);
        sql = sql.replace("$9", new CtrCidade().getCod(cidade) + "");
        return Banco.con.manipular(sql);
    }

    public boolean alterar() {
        String sql = "update empresaparametrizada set empp_nome='$1', "
                + "empp_razao='$2', empp_cnpj='$3', empp_fone='$4', "
                + "empp_email='$5', empp_endereco='$6', empp_bairro='$7',"
                + " empp_cep='$8', cid_cod=$9 where emppcod=" + cod;

        sql = sql.replace("$1", nome);
        sql = sql.replace("$2", razao);
        sql = sql.replace("$3", cnpj);
        sql = sql.replace("$4", fone);
        sql = sql.replace("$5", email);
        sql = sql.replace("$6", endereco);
        sql = sql.replace("$7", bairro);
        sql = sql.replace("$8", cep);
        sql = sql.replace("$9", new CtrCidade().getCod(cidade) + "");

        return Banco.con.manipular(sql);
    }

    public boolean excluir(int cod) {
        String sql = "delete * from empresaparametrizada where cod="+cod;
        return Banco.con.manipular(sql);
    }

    public EmpresaParametrizada get() {
        return null;
    }
}
