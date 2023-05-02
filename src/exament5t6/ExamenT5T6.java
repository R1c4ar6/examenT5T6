package exament5t6;

import java.util.Scanner;
import organizador.GestionTorneos;

public class ExamenT5T6 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestionTorneos torneos = new GestionTorneos();
        int opcion, dia, mes, anyo;
        String nombre;
        char ambito;
        double premio, aumento;

        torneos.añadirTorneo("Open De Australia", 'I', 17000, 1, 12, 2022);
        torneos.añadirTorneo("Open De Motril", 'L', 1000, 15, 3, 2023);
        torneos.añadirTorneo("Roland Garros", 'I', 1, 12, 2022, 80000);
        torneos.añadirTorneo("Master 1000 Madrid", 'N', 5000.5, 15, 3, 2023);
        torneos.añadirTorneo("Campeonato Andaluz", 'A', 3200, 30, 6, 2022);
        torneos.añadirTorneo("Master Del Pais Vasco", 'A', 3000, 30, 6, 2022);
        
        do {
            System.out.println("0.Salir");
            System.out.println("1.Añadir torneo");
            System.out.println("2.Ver todos los torneos (toString)");
            System.out.println("3.Torneos nacionales o de más de 50000€");
            System.out.println("4.Subir premio torneo");
            System.out.println("5.Borrar torneos poco rentables");
            System.out.println("6.Torneo de menor premio en un ámbito");
            System.out.println("7.Suma de premios por ámbitos");
            System.out.println("8.Ámbito con mas dinero en juego");
            System.out.println("Elige una opción:");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Adios");
                    break;
                case 1:
                    System.out.println("Dime el nombre del torneo:");
                    nombre = teclado.nextLine();
                    System.out.println("Dime el ambito (L,A,N,I):");
                    ambito = teclado.nextLine().charAt(0);
                    System.out.println("Dime el premio:");
                    premio = teclado.nextDouble();
                    System.out.println("Día del torneo:");
                    dia = teclado.nextInt();
                    System.out.println("Mes del torneo:");
                    mes = teclado.nextInt();
                    System.out.println("Año del torneo:");
                    anyo = teclado.nextInt();
                    torneos.añadirTorneo(nombre, ambito, premio, dia, mes, anyo);
                    break;
                case 2:
                    System.out.println("Todos los torneos:\n" + torneos.toString());
                    break;
                case 3:
                    System.out.println("Torneos filtrados:\n" + torneos.filtrarTorneos());
                    break;
                case 4:
                    System.out.println("Dime el nombre:");
                    nombre = teclado.nextLine();
                    System.out.println("Dime el aumento de premio:");
                    aumento = teclado.nextDouble();
                    torneos.subirPremio(nombre, aumento);
                    break;
                case 5:
                    //llamar a borrarPocoRentables
                    torneos.borrarPocoRentables();
                    break;
                case 6:
                    System.out.println("Dime el ambito (L,A,N,I):");
                    ambito = teclado.next().charAt(0);
                    System.out.println("Torneo menos rentable:\n" + torneos.menorPremioAmbito(ambito));
                    break;
                case 7:
                    System.out.println("Resumen de premios por ámbito:\n" + torneos.sumarPremiosPorAmbito());
                    break;
                case 8:
                    System.out.println("Ámbito más rentable:\n" + torneos.ambitoMasRentable());
                    break;
                default:
                    System.out.println("Opcion erronea¡¡¡");
            }
        } while (opcion != 0);
    }

}
