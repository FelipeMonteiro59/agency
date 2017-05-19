package agency.entity;

import agency.db.Banco;
import java.sql.ResultSet;

public class Pais {

    private int cod;
    private String nome, sigla;

    public Pais() {
    }

    public Pais(int cod, String nome, String sigla) {
        this.cod = cod;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Pais get(int cod) {
        String sql = "select *from pais where pais_cod=" + cod;
        Pais p = null;
        ResultSet rs = Banco.con.consultar(sql);
        try {
            if (rs.next()) {
                p = new Pais(cod, rs.getString("pais_nome"), rs.getString("pais_sgl"));
            }
        } catch (Exception ex) {
        }
        return p;
    }
}
