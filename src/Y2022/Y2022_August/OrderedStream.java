package Y2022.Y2022_August;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedStream {

    String[] values;
    int ptr;

    public OrderedStream(int n) {
        values = new String[n];
        Arrays.fill(values, null);
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        int index = idKey - 1;
        values[index] = value;
        List<String> res = new ArrayList<>();
        if (index != ptr) return res;
        while (ptr < values.length && values[ptr] != null) res.add(values[ptr++]);
        return res;
    }
}
