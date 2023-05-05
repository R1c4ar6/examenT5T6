package organizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class GestionTorneos {

//    private String nombre;NO TENIA QUE PONER EL NOMBRE, PUES NO LO PEDIA
    private HashMap<String, Torneo> gestor=new HashMap<>();
    
    //Constructor
    public GestionTorneos() {
//        this.nombre=nombre;NO ERA NECESARIO, SOLO PEDIA EL HASHMAP
        this.gestor=new HashMap<>();
    }
    

    //metodo buscar torneos DESCOMENTAR
    private Torneo encontrarTorneo(String nombre) {
        return this.gestor.get(nombre);
    }

    //Añado Torneo
    public void añadirTorneo(String nombre, char ambito, double premio, int dia, int mes, int anio) {//NO ERA NECESARIO CAMBIAR EL ORDEN DE LOS PARAMETROS
        Torneo buscar, nuevo;                                                                        
        buscar=this.encontrarTorneo(nombre);
        if (buscar==null) {
            nuevo=new Torneo(nombre,ambito,dia, mes, anio, premio);//SOLO CAMBIAR EL ORDEN EN QUE ENTRAN EN EL OBJETO NUEVO
            this.gestor.put(nombre, nuevo);
        }else{
            System.out.println("Ya está en el sistema");
        }
    }

    //toString
    @Override
    public String toString() {
        String res = "";
//        ArrayList<Torneo> si = new ArrayList<>(this.gestor.values());NO ERA NECESARIO
        if (this.gestor.isEmpty()) {
            res+="No existe ningun torneo en el sistema";
        } else {
            for (Torneo tor : this.gestor.values()) {
                res += tor.toString();
            }
        }
        return res;
    }

    //filtrar torneos
    public String filtrarTorneos() {
        String res = "";
        for (Torneo tor : this.gestor.values()) {
            if (tor.getAmbito()=='N' || tor.getPremio()>50.000) {
                res+=tor.toString();
            }
        }
        if (res.equals("")) {
            res+="No existen torneos con las caracteristicas requeridas";//NO HACERLO CON UN SOUT INDEPENDIENTE, SINO CONCATERNARLO CON NUESTRO STRING
        }
        return res;
    }

    //metodo subirpremio
    public void subirPremio(String nombre, double porcentaje) {
        Torneo buscar=this.encontrarTorneo(nombre);
        if (buscar==null) {
            System.out.println("Torneo no encontrado");
        }else{
            double suma=buscar.getPremio()+buscar.getPremio()*porcentaje/100;//ERA NECESARIO HACER ESTO ANTES DE REEMPLAZAR EL VALOR DEL PREMIO
            buscar.setPremio(suma);
        }
    }
    
    //borrar poco rentables
    public void borrarPocoRentables() {
        ArrayList<Torneo> listado = new ArrayList<>(this.gestor.values());
        Iterator<Torneo> tor = listado.iterator();
        Torneo objeto;
        boolean eliminado = false;
        while (tor.hasNext()) {
            objeto = tor.next();
            if (objeto.getPremio() <= 3000) {
                tor.remove();
                eliminado = true;
            }
        }
        if (eliminado) {
            System.out.println("Torneo borrado exitosamente");
        } else {
            System.out.println("No se encontraron torneos a borrar");
        }
    }

    
    
    //Menor premio tipo
    public String menorPremioAmbito(char ambito) {
        String menor = "";
        ArrayList<Torneo> lista= new ArrayList<>();
        for (Torneo tor : this.gestor.values()) {
            if (tor.getAmbito()==ambito) {
                lista.add(tor);
            }
        }
        lista.sort((a,b)-> Double.compare(a.getPremio(), b.getPremio()));
        return menor+=lista.get(0);
    }
    
    private HashMap <Character,Double> sumaPorAmbito(){//ESTO ES LO QUE NO PUDE HACER EN EL EXAMEN
        HashMap<Character, Double> res=new HashMap<>();
        for (Torneo tor : this.gestor.values()) {
            double premios=res.getOrDefault(tor.getAmbito(), 0.0);
            res.put(tor.getAmbito(), premios+tor.getPremio());
        }
        return res;
    }
            
    //sumar premio por tipo
    public String sumarPremiosPorAmbito() {
        String res = "";
        HashMap<Character, Double> sum=this.sumaPorAmbito();
        for (Entry<Character, Double> tor : sum.entrySet()) {
            String ambito=Torneo.getAmbitoCompleto(tor.getKey());
            double premio=tor.getValue();
            res+=ambito+"->"+premio+"\n";
        }
        return res;
    }

    //Ambito que genera mejores premios
    public String ambitoMasRentable() {
        String res = "";
            HashMap<Character, Double> sum=this.sumaPorAmbito();
            ArrayList<Entry<Character, Double>> orden=new ArrayList<>(sum.entrySet());
            orden.sort((a,b)-> Double.compare(b.getValue(), a.getValue()));
            res+=Torneo.getAmbitoCompleto(orden.get(0).getKey());
        return res;
    }
}
