package Y2022.Y2022_November;

public class No1678_Interpret {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i++;
                } else {
                    sb.append("al");
                    i += 3;
                }
            }
        }
        return new String(sb);
    }
}
