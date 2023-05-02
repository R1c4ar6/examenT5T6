
package organizador;

import java.util.HashMap;


public class Torneo {
    private int orden, dia, mes, anio;
    private String nombre;
    private char ambito;
    private double premio;
    
    private static int contador=1;
    
    private static HashMap<Character, String> AmbitoCompleto=new HashMap<>(){
        {
            put('L',"Local");
            put('A',"Autonomico");
            put('N',"Nacional");
            put('I',"Internacional");
        }
    };
    
    public Torneo(String nombre, char ambito, int dia, int mes, int anio, double premio) {
        this.nombre = nombre;
        this.ambito = ambito;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.premio = premio;
        this.orden = this.contador;
        this.contador++;
    }

    public int getOrden() {
        return orden;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public String getNombre() {
        return nombre;
    }

    public char getAmbito() {
        return ambito;
    }
    public static String getAmbitoCompleto(char ambito){
        return AmbitoCompleto.get(ambito);
    }

    public void setAmbito(char ambito) {//correccion, había comparado cada char con la variable ambito uno a uno
        if (AmbitoCompleto.containsKey(ambito)) {
            this.ambito = ambito;
        }
    }
    

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        if (premio>0) {
            this.premio = premio;
        }
    }
    
    public int getContador() {
        return contador;
    }

    @Override
    public String toString() {
        String res="";
        res+="=================="+"\n";
        res+="Orden: "+this.orden+"\n"+
            "Nombre: "+this.nombre+"\n"+
            "Premio: "+this.premio+"\n"+
            "Ambito: "+this.AmbitoCompleto.get(this.ambito)+"\n"+
            "Fecha: "+this.dia+"/"+this.mes+"/"+this.anio+"\n"+
            "==================";
        return res;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
