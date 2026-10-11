package aed;

class Funciones {

/***  Primera parte: Funciones en java ***/

    int cuadrado(int x) {
        int res = x * x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.pow(x*x + y*y, 0.5);
        return res;
    }

    boolean esPar(int n) {
        boolean res = n%2 == 0;
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res = ((n%4==0) && (n%100!=0))||(n%400==0);
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i = 0; i<n; i++){
            res *= n-i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n==0 || n==1){ 
            return 1;
        } else{
            return n*factorialRecursivo(n-1);
        }
    }

    boolean esPrimo(int n) {
        if (n>3){
            for (int i = 1; i<(int) Math.floor(n/2); i++){
                if (n%(i+1)==0){
                    return false;
                }
            }
            return true;
        } else if (n>1){
            return true;
        } else {
            return false;
        }
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i:numeros) {
            res += i;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]==buscado){
                return i;
            }
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int n : numeros){
            if (esPrimo(n)){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int n : numeros){
            if (!esPar(n)){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        int lens1 = s1.length();
        if (lens1>s2.length()){
            return false;
        }
        else{
            for (int j = 0; j<s1.length(); j++){
                if (s2.charAt(j)!=s1.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }
    boolean esSufijo(String s1, String s2) {
        int lens1 = s1.length();
        int lens2 = s2.length();
        if (lens1>lens2){
            return false;
        }
        else{
            for (int j = 1; j<=s1.length(); j++){
                if (s2.charAt(lens2-j)!=s1.charAt(lens1-j)){
                    return false;
                }
            }
            return true;
        }
    }

/***  Segunda parte: Debugging ***/

    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;
        int xslength = xs.length;
        if (xslength!=ys.length){
            return false;
        }
        for (int i = 0; i < xslength; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length; i++) {
            if (i==0){
                res = true;
            }
            else if (xs[i-1] > xs [i]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];
        for (int i = 1; i < xs.length; i++) {
            if (xs[i] >= res) res = xs[i];
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int x : xs) {
            if (x <= 0) {
                res = false;
            }
        }
        return res;
    }

}
