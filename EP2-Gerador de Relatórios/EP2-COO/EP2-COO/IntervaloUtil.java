import java.util.*;

public class IntervaloUtil {
    public static Set<Double> leIntervalo(String intervalo) {
        String[] partes = intervalo.split("_");

        if (partes.length != 2) {
            throw new IllegalArgumentException("Intervalo inválido: " + intervalo);
        }
        Set<Double> conjunto = new TreeSet<>();

        try {
            conjunto.add(Double.parseDouble(partes[0]));
            conjunto.add(Double.parseDouble(partes[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número inválido no intervalo: " + intervalo, e);
        }

        return conjunto;
    }
}