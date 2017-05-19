package agency.entity;

import agency.controllers.CtrEstado;
import agency.db.Banco;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cidade {

    private int cod;
    private Estado estado;
    private String nome;

    public Cidade() {
    }

    public Cidade(int cod, Estado estado, String nome) {
        this.cod = cod;
        this.estado = estado;
        this.nome = nome;
    }

    //<editor-fold defaultstate="collapsed" desc="GETTER AND SETTER">
    public String getNome() {
        return nome;
    }
    
    public int getCod(){
        return cod;
    }

    //</editor-fold>
    public Cidade get(int cod) {
        String sql = "select * from Cidade where cid_cod=" + cod;
        Cidade c = null;
        CtrEstado ctre = new CtrEstado();
        ResultSet rs = Banco.con.consultar(sql);
        try {
            if (rs.next()) {
                c = new Cidade(cod, ctre.get(rs.getInt("est_cod")), rs.getString("cid_nome"));
            }
        } catch (Exception ex) {
        }
        return c;
    }

    public ArrayList<Cidade> get(String filtro) {
        String sql = "select * from Cidade";
        if (!filtro.isEmpty()) {
            sql += " where " + filtro;
        }
        ArrayList<Cidade> Cidade = new ArrayList();
        Cidade c = null;
        CtrEstado ctre = new CtrEstado();
        ResultSet rs = Banco.con.consultar(sql);
        try {
            while (rs.next()) {
                c = new Cidade(rs.getInt("cid_cod"), ctre.get(rs.getInt("est_cod")), rs.getString("cid_nome"));
                Cidade.add(c);
            }
        } catch (Exception ex) {
        }
        return Cidade;
    }

    @Override
    public String toString() {
        return nome;
    }
}
