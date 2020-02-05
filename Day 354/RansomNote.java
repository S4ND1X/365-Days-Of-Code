import java.util.HashMap;
import java.util.Map;

public class RansomNote{
    /**
     * Se crea un map, se guarda el numero de ocurrencias de las letras de magazine
     * y al final se le resta las ocurrencias de las notas, si en algun momento es negativo regresa false
     * @param note es el string que necistas saber si es posible construirse
     * @param magazine es el string con el que debes de construir la nota 
     */
    private static boolean canConstruct(String note, String magazine) {
        Map<Character, Integer> magazineCharacters = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            char magChar = magazine.charAt(i);
            //Si no encuentra valor, se crea el valor con 0
            int count = magazineCharacters.containsKey(magChar) ? magazineCharacters.get(magChar) : 0;
            magazineCharacters.put(magChar, count + 1);
        }
        //Se recorre la nota y si no encuentra alguna letra, regresa falso o si es negativo
        for (int i = 0; i < note.length(); i++) {
            char noteChar = note.charAt(i);
            //Se obtiene el numero de ocurrencias de esa letra
            int count = magazineCharacters.containsKey(noteChar) ? magazineCharacters.get(noteChar) : 0;
            if(count == 0 || count-1 < 0){
                return false;
            }
            magazineCharacters.put(noteChar, count - 1);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("aab", "baa"));
    }
}