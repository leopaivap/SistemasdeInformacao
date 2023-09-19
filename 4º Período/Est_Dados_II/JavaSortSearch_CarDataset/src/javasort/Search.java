package javasort;

import java.util.ArrayList;

public class Search {

    static int compLinear = 0, compBinaria = 0;

    public static int linearSearchCarName(ArrayList<Dados> carList, String search) {
        int comparsons = 0;
        for (Dados d : carList) {
            comparsons++;
            if (d.getName().equals(search)) 
                return comparsons;
        }
        return -1;
    }

    public static int linearSearchCarOrigin(ArrayList<Dados> carList, String search) {
        int comparsons = 0;
        for (Dados d : carList) {
            comparsons++;
            if (d.getOrigin().equals(search)) {
                return comparsons;
            }
        }
        return -1;
    }
    
    public static int binarySearchCarName(ArrayList<Dados> carList, String search){
        int ini = 0, fim, meio, comparsons = 0;
        fim = carList.size() - 1;
        
        while (ini <= fim) {
            meio = (ini + fim) / 2;
            comparsons++;
            if (carList.get(meio).getName().equals(search)) {
                return comparsons;
            } else if (carList.get(meio).getName().compareTo(search) < 0) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
    
    public static int binarySearchCarOrigin(ArrayList<Dados> carList, String search){
        int ini = 0, fim, meio, comparsons = 0;
        fim = carList.size() - 1;
        
        while (ini <= fim) {
            meio = (ini + fim) / 2;
            comparsons++;
            if (carList.get(meio).getOrigin().equals(search)) {
                return comparsons;
            } else if (carList.get(meio).getOrigin().compareTo(search) < 0) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static boolean linearSearch(int array[], int x) {
        for (int i = 0; i < array.length; i++) {
            compLinear++;
            if (x == array[i]) {
                return true;
            }
        }
        return false;
    }
    //-------------------

    public static boolean binarySearch(int array[], int x) {
        int ini, fim, meio;
        ini = 0;
        fim = array.length - 1;
        while (ini <= fim) {
            meio = (ini + fim) / 2;
            compBinaria++;
            if (x == array[meio]) {
                return true;
            } else if (x > array[meio]) {
                ini = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return false;
    }

    //-------------------
}
