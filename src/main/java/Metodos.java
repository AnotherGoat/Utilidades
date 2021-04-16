import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Metodos {

    /**
     * Revisa si un número es par.
     * @param a Número a revisar.
     * @return true si es par, false si no lo es.
     */
    public boolean esPar(int a){
        return a%2==0;
    }

    /**
     * Revisa si un número es impar.
     * @param a Número a revisar.
     * @return true si es impar, false si no lo es.
     */
    public boolean esImpar(int a) {
        return a % 2 != 0;
    }

    /**
     * Recibe entrada del usuario como un String.
     * Muestra el mensaje entregado antes de pedir la entrada.
     * @param mensaje Mensaje a mostrar antes de pedir entrada.
     * @return Entrada que envió el usuario.
     */
    public String recibirString(String mensaje) {
        Scanner s = new Scanner(System.in);
        System.out.print(mensaje);
        return s.nextLine();
    }

    /**
     * Convierte una cadena a un boolean.
     * Las palabras "true", "t" "verdadero", "v", "1", "yes" y "on" se convierten a true.
     * Cualquier otra entrada se convierte a false.
     * Se acepta cualquier combinación de mayúsculas y minúsculas en la entrada.
     * @return
     */
    public boolean aBoolean(String cadena) {
        cadena = cadena.toLowerCase();
        String[] truthy = {"true", "t", "verdadero", "v", "1", "yes", "on"};

        for (var verdad: truthy) {
            if (cadena.equals(verdad)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Recibe entrada del usuario y la convierte a un int.
     * Si no se le entrega un int válido, se repite hasta que lo sea.
     * @param mensaje Mensaje a mostrar antes de pedir entrada.
     * @return Primer int válido ingresado por el usuario.
     */
    public int recibirInt(String mensaje) {
        Scanner s = new Scanner(System.in);
        int entrada = 0;

        while (true) {
            try {
                System.out.print(mensaje);
                entrada = Integer.parseInt(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }

        return entrada;
    }

    /**
     * Recibe entrada del usuario y la convierte a un double.
     * Si no se le entrega un int válido, se repite hasta que lo sea.
     * @param mensaje Mensaje a mostrar antes de pedir entrada.
     * @return Primer double válido ingresado por el usuario.
     */
    public double recibirDouble(String mensaje) {
        Scanner s = new Scanner(System.in);
        double entrada = 0.0;

        while (true) {
            try {
                System.out.print(mensaje);
                entrada = Double.parseDouble(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }

        return entrada;
    }

    /**
     * Retorna un int al azar.
     * @return Número int al azar.
     */
    public int intRandom(){
        Random r = new Random();
        return r.nextInt();
    }

    /**
     * Retorna un int al azar dentro del rango especificado.
     * @param min Número mínimo, inclusivo.
     * @param max Número máximo, inclusivo.
     * @return Número int al azar.
     */
    public int intRandomEntre(int min, int max){
        Random r = new Random();
        return min + r.nextInt(max - min + 1);
    }

    /**
     * Calcula el promedio de un arreglo de ints.
     * @param arr Arreglo de tipo int[].
     * @return Promedio de los contenidos del arreglo.
     */
    public double promedio(int[] arr){
        double suma = 0.0;

        for(int n : arr){
            suma += n;
        }

        return suma / arr.length;
    }

    /**
     * Calcula la varianza de un arreglo de ints.
     * @param arr Arreglo de tipo int[].
     * @return Varianza de los contenidos del arreglo.
     */
    public double varianza(int[] arr){
        double promedio = promedio(arr);
        double suma = 0.0;

        for(int n: arr){
            suma += Math.pow((n - promedio), 2);
        }

        return suma / arr.length;
    }

    /**
     * Calcula la desviación estándar de un arreglo de ints.
     * @param arr Arreglo de tipo int[].
     * @return Desviación estándar de los contenidos del arreglo.
     */
    public double desviacionEstandar(int[] arr) {
        return Math.sqrt(varianza(arr));
    }

    /**
     * Muestra los elementos de un arreglo de ints.
     * @param arr Arreglo de tipo int[].
     */
    public void verArreglo(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Retorna un arreglo de ints al azar dentro del rango especificado.
     * @param largo Cantidad de números a generar.
     * @param min Número mínimo, inclusivo.
     * @param max Número máximo, inclusivo.
     * @return Arreglo con ints generados al azar.
     */
    public int[] llenarArreglo(int largo, int min, int max){
        int[] arr = new int[largo];

        for (int i = 0; i < largo; i++) {
            arr[i] = intRandomEntre(min, max);
        }

        return arr;
    }

    /**
     * Ordena un arreglo usando el ordenamiento burbuja.
     * @param arr
     * @return
     */
    static int[] ordenarBurbuja(int[] arr){
        if(arr!=null) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int aux = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = aux;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * Muestra los elementos de una matriz de ints.
     * @param arr Arreglo de tipo int[].
     */
    public void verMatriz(int[][] mat){
        for (int[] fila : mat) {
            System.out.println(Arrays.toString(fila));
        }
    }


    /**
     * Retorna una matriz de ints al azar dentro del rango especificado.
     * @param filas Número de filas.
     * @param columnas Número de columnas.
     * @param min Número mínimo, inclusivo.
     * @param max Número máximo, inclusivo.
     * @return Arreglo con ints generados al azar.
     */
    public int[][] llenarMatriz(int filas, int columnas, int min, int max){
        int[][] mat = new int[filas][columnas];

        int[] arr = new int[largo];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mat[i][j] = intRandomEntre(min, max);
            }
        }

        return mat;
    }

    /**
     * Enumera las cadenas de un arreglo.
     * @param lista Lista de cadenas.
     * @return Cadena con los elementos de la lista enumerados.
     */
    public String enumerar(String[] lista){
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= lista.length; i++) {
            sb.append(i).append(".- ").append(lista[i - 1]);

            if (i != lista.length) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    /**
     * Enumera las cadenas de un arreglo, con un separador.
     * @param lista Lista de cadenas.
     * @param separador Separador entre los números y cada cadena.
     * @return Cadena con los elementos de la lista enumerados.
     */
    public String enumerar(String[] lista, String separador){
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= lista.length; i++) {
            sb.append(i).append(separador).append(lista[i - 1]);

            if (i != lista.length) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    // Remueve los espacios un String
    public String removerEspacios(String palabra){
        return palabra.replace(" ","");
    }

    // Retorna una palabra con la primera letra en mayúsculas y el resto en minúsculas
    public String mayusculaInicial(String palabra) {
        return palabra.toUpperCase().charAt(0) + palabra.substring(1).toLowerCase();
    }

    // Remueve los tildes de un String
    public String removerTildes(String palabra){
        String conTildes="ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
        String sinTildes="AAAAAAACEEEEIIIIDNOOOOOOUUUUYBaaaaaaaceeeeiiiionoooooouuuuyy";
        for(int i=0; i<conTildes.length(); i++){
            palabra = palabra.replace(conTildes.charAt(i), sinTildes.charAt(i));
        }

        return palabra;
    }

    // Verifica si la palabra ingresada es un palindromo
    public boolean esPalindromo(String palabra){
        palabra = removerEspacios(palabra);
        palabra = minusculas(palabra);
        palabra = removerTildes(palabra);

        if(palabra.equals("")){ // Caso de String vacío
            return false;
        }
        else if(palabra.length()==1){ // En caso de ingresar solo 1 caracter
            return false;
        }
        else {
            StringBuilder sb = new StringBuilder();

            for (int i = palabra.length()-1; i>=0; i--) {
                char caracter = palabra.charAt(i);
                sb.append(caracter);
            }

            return palabra.equals(sb.toString());
        }
    }

    // Remueve un caracter de un String
    public String removerCaracter(String palabra, char caracter){
        String aux = ""+caracter;
        return palabra.replace(aux, "");
    }

    // Valida el rut ingresado
    public boolean validarRut(String rut) {

        boolean validacion = false;

        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char digitoVerificador = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (digitoVerificador == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }

        return validacion;
    }

    // Verifica que el correo ingresado sea válido
    public boolean validarEmail (String email) {
        if(email != null) {
            Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        else{
            return false;
        }
    }

}
