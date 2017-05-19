package agency.entity;

import agency.controllers.CtrPais;
import agency.db.Banco;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Estado {

    private int cod;
    private Pais pais;
    private String nome, sigla;

    public Estado() {
    }

    public Estado(int cod, Pais pais, String nome, String sigla) {
        this.cod = cod;
        this.pais = pais;
        this.nome = nome;
        this.sigla = sigla;
    }
//<editor-fold defaultstate="collapsed" desc="GETTER AND SETTER">

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

///</editor-fold>    
    public Estado get(int cod) {
        String sql = "select * from estado where est_cod=" + cod;
        Estado e = null;
        CtrPais ctrp = new CtrPais();
        ResultSet rs = Banco.con.consultar(sql);
        try {
            if (rs.next()) {
                e = new Estado(cod, ctrp.get(rs.getInt("pais_cod")),
                        rs.getString("est_nome"), rs.getString("est_sgl"));
            }
        } catch (Exception ex) {
        }
        return e;
    }

    public ArrayList<Estado> get(String filtro) {
        String sql = "select * from estado";
        if (!filtro.isEmpty()) {
            sql += " where " + filtro;
        }
        ArrayList<Estado> estados = new ArrayList();
        CtrPais ctrp = new CtrPais();
        ResultSet rs = Banco.con.consultar(sql);
        try {
            while (rs.next()) {
                estados.add(new Estado(rs.getInt("est_cod"),
                        ctrp.get(rs.getInt("pais_cod")),
                        rs.getString("est_nome"), rs.getString("est_sgl")));
            }
        } catch (Exception ex) {
        }
        return estados;
    }

    @Override
    public String toString() {
        return sigla;
    }
}
