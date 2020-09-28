
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase tiene métodos para validar entrada
 */
public class Validador {

    //// Constructores
    /**
     * Constructor por defecto de la clase Validador
     */
    public Validador() {
    }

    //// Métodos
    /**
     * Verifica que un String ingresado puede ser convertido a int sin tirar ninguna excepción
     * @param entrada String que contiene la entrada del usuario
     * @return Boolean que indica si la entrada es int (true) o no (false)
     */
    public boolean esInt(String entrada) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un int
                int i = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica que el String ingresado es un int, y se asegura de que esté dentro de un cierto rango
     * @param entrada String que contiene la entrada del usuario
     * @param min Valor mínimo que se acepta como válido
     * @param max Valor máximo que se acepta como válido
     * @return Boolean que indica si la entrada es int y está entre los valores (true) o no (false)
     */
    public boolean esInt(String entrada, int min, int max){
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            // Primero revisa si se puede convertir a int
            try {
                // Intenta convertir el String a un int
                int i = Integer.parseInt(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        // Retorna true si el int está entre los números ingresados
        return Integer.parseInt(entrada)>=min && Integer.parseInt(entrada)<=max;
    }

    /**
     * Verifica que un String ingresado puede ser convertido a long sin tirar ninguna excepción
     * @param entrada String que contiene la entrada del usuario
     * @return Boolean que indica si la entrada es long (true) o no (false)
     */
    public boolean esLong(String entrada) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un long
                long l = Long.parseLong(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica que el String ingresado es un long, y se asegura de que esté dentro de un cierto rango
     * @param entrada String que contiene la entrada del usuario
     * @param min Valor mínimo que se acepta como válido
     * @param max Valor máximo que se acepta como válido
     * @return Boolean que indica si la entrada es long y está entre los valores (true) o no (false)
     */
    public boolean esLong(String entrada, long min, long max) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un long
                long l = Long.parseLong(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return Long.parseLong(entrada)>=min && Long.parseLong(entrada)<=max;
    }

    /**
     * Verifica que un String ingresado puede ser convertido a float sin tirar ninguna excepción
     * @param entrada String que contiene la entrada del usuario
     * @return Boolean que indica si la entrada es float (true) o no (false)
     */
    public boolean esFloat(String entrada) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un float
                float f = Float.parseFloat(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica que el String ingresado es un float, y se asegura de que esté dentro de un cierto rango
     * @param entrada String que contiene la entrada del usuario
     * @param min Valor mínimo que se acepta como válido
     * @param max Valor máximo que se acepta como válido
     * @return Boolean que indica si la entrada es float y está entre los valores (true) o no (false)
     */
    public boolean esFloat(String entrada, float min, float max) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un float
                float f = Float.parseFloat(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return Float.parseFloat(entrada)>=min && Float.parseFloat(entrada)<=max;
    }

    /**
     * Verifica que un String ingresado puede ser convertido a double sin tirar ninguna excepción
     * @param entrada String que contiene la entrada del usuario
     * @return Boolean que indica si la entrada es double (true) o no (false)
     */
    public boolean esDouble(String entrada) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un double
                double d = Double.parseDouble(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica que el String ingresado es un double y se asegura de que esté dentro de un cierto rango
     * @param entrada String que contiene la entrada del usuario
     * @param min Valor mínimo que se acepta como válido
     * @param max Valor máximo que se acepta como válido
     * @return Boolean que indica si la entrada es double y está entre los valores (true) o no (false)
     */
    public boolean esDouble(String entrada, double min, double max) {
        // Si la entrada es nula, retornar false automáticamente
        if(entrada == null){
            return false;
        }

        else {
            try {
                // Intenta convertir el String a un double
                double d = Double.parseDouble(entrada);
            } catch (NumberFormatException nfe) {
                // Si la conversión tira un error
                return false;
            }
        }

        return Double.parseDouble(entrada)>=min && Double.parseDouble(entrada)<=max;
    }

    /**
     * Revisa si la entrada un número de teléfono válido
     * @param entrada String que representa la entrada del usuario
     * @return Boolean que indica si el número es un número de teléfono válido o no
     */
    public boolean esNumeroTelefonico(String entrada){
        if (entrada == null){
            return false;
        }

        // El patrón es: puede tener "+" en la primera posición + entre 1 y 15 dígitos, en una sola línea
        Pattern pattern = Pattern.compile("^[+]?[0-9]{1,15}$");
        Matcher matcher = pattern.matcher(entrada);
        return matcher.matches();
    }

    /**
     * Este método verifica que el String del parámetro es un email válido
     * @param entrada Email que se quiere verificar
     * @return Retorna un boolean que indica si el email ingresado es válido (true) o no (false)
     */
    public Boolean esEmail (String entrada) {
        if(entrada == null){
            return false;
        }

        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(entrada);
        return matcher.matches();
    }
}
