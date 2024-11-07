package utils;

import java.util.List;

public class Utilities {
    private Utilities() {
    }

    public static boolean ignoreCaseContainsForLoop(List<String> list, String value) {
        for (String e : list) {
            if (e.contains(value)) {
                return true;
            }
        }
        return false;
    }
}
