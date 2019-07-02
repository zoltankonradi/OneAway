import java.util.HashMap;
import java.util.Map;

public class Main {

    /*

     Cracking the Coding Interview - Arrays and Strings

     1.5 - One Away:
     There are three types of edits that can be performed on strings: insert a character,
     remove a character, or replace a character. Given two strings, write a function to check if they are
     one edit (or zero edits) away.

     */

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "bake"));
    }

    public static boolean oneAway(String s1, String s2) {
        if (s1.equals(s2)) { return true; }
        Map<String, Integer> characters = new HashMap<>();
        brakeStringDownToCharacters(characters, s1);
        brakeStringDownToCharacters(characters, s2);
        int edits = 0;
        for (Map.Entry<String, Integer> character : characters.entrySet()) {
            if (character.getValue()%2 != 0) {
                if (edits > 2) {
                    return false;
                }
                edits++;
            }
        }
        return true;
    }

    private static Map<String, Integer> brakeStringDownToCharacters(Map<String, Integer> map, String string) {
        for (int i = 0; i < string.length(); i++) {
            String character = Character.toString(string.charAt(i));
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        return map;
    }
}
