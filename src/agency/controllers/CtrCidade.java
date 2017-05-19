package agency.controllers;

import agency.entity.Cidade;
import java.util.ArrayList;


public class CtrCidade {

    public CtrCidade() {
    }
    
    public int getCod(Cidade c){
        return c.getCod();
    }
    
    public String getNome(Cidade c){
        return c.getNome();
    }
    
     public Cidade get(int cod) {
         Cidade c = new Cidade();
         return c.get(cod);
     }
     
     public ArrayList<Cidade> get(String filtro){
         Cidade c = new Cidade();
         return c.get(filtro);
     }
    
}
