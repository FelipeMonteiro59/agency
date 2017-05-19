package agency.controllers;

import agency.entity.Pais;

public class CtrPais {

    public CtrPais() {
    }

    public Pais get(int cod) {
        Pais p = new Pais();
        return p.get(cod);
    }
}
