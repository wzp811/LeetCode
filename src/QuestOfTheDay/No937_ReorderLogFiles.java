package QuestOfTheDay;

import java.util.Arrays;
import java.util.Comparator;

public class No937_ReorderLogFiles {
    class Log {
        String log;
        boolean type;
        String tag;
        String content;
        int index;
        Log(String log, int index) {
            this.log = log;
            String[] k = log.split(" ");
            content = "";
            this.index = index;
            if (Character.isDigit(k[1].charAt(0))) {
                type = true;
                tag = k[0];
            } else {
                type = false;
                tag = k[0];
            }
            for (int i = 1; i < k.length; i++) content.concat(k[i] + " ");
        }

        @Override
        public String toString() {
            return "Log{" +
                    "log='" + log + '\'' +
                    ", type=" + type +
                    ", tag='" + tag + '\'' +
                    ", content='" + content + '\'' +
                    ", index=" + index +
                    '}';
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        Log[] logClass = new Log[logs.length];
        for (int i = 0; i < logs.length; i++) {
            logClass[i] = new Log(logs[i], i);
        }
        for (Log cur : logClass) System.out.println(cur);
        Arrays.sort(logClass, new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                if (o1.type && o2.type) {
                    return o1.content.equals(o2.content) ? o1.tag.compareTo(o2.tag) : o1.content.compareTo(o2.content);
                } else if (!(o1.type || o2.type)) {
                    return o1.index - o2.index;
                } else {
                    return o1.type ? 1 : -1;
                }
            }
        });
        for (int i = 0; i < logs.length; i++) logs[i] = logClass[i].log;
        return logs;
    }
}
