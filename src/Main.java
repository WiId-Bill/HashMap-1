import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Main {
    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        char[] elements = TEXT.toLowerCase().toCharArray();
        Map<Character, Integer> results = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {
            if (Character.isLetter(elements[i])) {
                Integer count = results.get(elements[i]);
                if (count == null) {
                    results.put(elements[i], 1);
                } else {
                    results.put(elements[i], count + 1);
                }
            }

        }
        System.out.println(results);
        Integer max = getMax(results);
        Integer min = getMin(results);

        MaxLetter(results, max);
        MinLetter(results, min);

    }

    private static void MinLetter(Map<Character, Integer> results, Integer min) {
        System.out.println();
        System.out.println("Минимальное количество букв: ");
        for (Map.Entry<Character, Integer> result : results.entrySet()) {
            if (Objects.equals(result.getValue(), min)) {
                System.out.print("[" + result.getKey() + " : " + result.getValue() + "] ");
            }
        }
    }

    private static void MaxLetter(Map<Character, Integer> results, Integer max) {
        System.out.println("Максимальное количество букв: ");
        for (Map.Entry<Character, Integer> result : results.entrySet()) {
            if (Objects.equals(result.getValue(), max)) {
                System.out.print("[" + result.getKey() + " : " + result.getValue() + "] ");
            }
        }
    }

    private static Integer getMax(Map<Character, Integer> results) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> result : results.entrySet()) {
            if (result.getValue() > max) {
                max = result.getValue();
            }
        }
        return max;
    }

    private static Integer getMin(Map<Character, Integer> results) {
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> result : results.entrySet()) {
            if (result.getValue() < min) {
                min = result.getValue();
            }
        }
        return min;
    }
}