//Jorge Sanchez Diaz A01635375
// EjemploWildCard

import java.util.ArrayList;

public class EjemploWildCard {

    public static double suma(ArrayList<? extends Number> numero) {
        double suma = 0.0;
        for (int i = 0; i < numero.size(); i++) {
            suma += numero.get(i).doubleValue();
        }
        return suma;
    }

    public static void main(String[] args) {
        ArrayList<Number> arrList1 = new ArrayList<Number>();
        for (int i = 0; i < 15; i++) {
            arrList1.add(i);
        }
        System.out.println(suma(arrList1));
        ArrayList<Integer> arrList2 = new ArrayList<Integer>();
        for (int i = 0; i < 15; i++) {
            arrList2.add(i);
        }
        System.out.println(suma(arrList2));
    }
}