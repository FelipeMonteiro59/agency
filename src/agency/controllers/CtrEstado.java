package agency.controllers;

import agency.entity.Estado;
import agency.entity.Pais;
import java.util.ArrayList;

public class CtrEstado {

    public CtrEstado() {
    }

    //<editor-fold defaultstate="collapsed" desc="GETTER AND SETTER">
    public int getCod() {
        Estado e = new Estado();
        return e.getCod();
    }

    public int getCod(Estado e) {
        return e.getCod();
    }

    public void setCod(int cod) {
        Estado e = new Estado();
        e.setCod(cod);
    }

    public Pais getPais() {
        Estado e = new Estado();
        return e.getPais();
    }

    public void setPais(Pais pais) {
        Estado e = new Estado();
        e.setPais(pais);
    }

    public String getNome() {
        Estado e = new Estado();
        return e.getNome();
    }

    public void setNome(String nome) {
        Estado e = new Estado();
        e.setNome(nome);
    }

    public String getSigla() {
        Estado e = new Estado();
        return e.getSigla();
    }

    public String getSigla(Estado e) {
        return e.getSigla();
    }

    public void setSigla(String sigla) {
        Estado e = new Estado();
        e.setSigla(sigla);
    }

///</editor-fold>
    public Estado get(int cod) {
        Estado e = new Estado();
        return e.get(cod);
    }

    public ArrayList<Estado> get(String filtro) {
        Estado e = new Estado();
        return e.get(filtro);
    }

}
