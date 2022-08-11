package Y2022.Y2022_August;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class No1417_Reformat {
    public String reformat(String s) {
        List<Character> digit = new ArrayList<>();
        List<Character> letter = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) digit.add(s.charAt(i));
            else letter.add(s.charAt(i));
        }
        if (Math.abs(digit.size() - letter.size()) > 1) return "";
        StringBuilder sb = new StringBuilder();
        List<Character> first = digit.size() >= letter.size() ? digit : letter;
        List<Character> second = digit.size() < letter.size() ? digit : letter;
        int i = 0, j = 0;
        while (sb.length() < s.length()) {
            sb.append(first.get(i++));
            sb.append(second.get(j++));
        }
        if (i < first.size()) sb.append(first.get(i));
        return sb.toString();

    }
}
