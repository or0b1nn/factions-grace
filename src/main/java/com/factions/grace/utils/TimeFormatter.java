package com.factions.grace.utils;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TimeFormatter {
    public static String format(long value) {
        if (value <= 0L) {
            return "0 s";
        } else {
            long days = TimeUnit.MILLISECONDS.toDays(value);
            long hours = TimeUnit.MILLISECONDS.toHours(value) - days * 24L;
            long minutes = TimeUnit.MILLISECONDS.toMinutes(value) - TimeUnit.MILLISECONDS.toHours(value) * 60L;
            long second = TimeUnit.MILLISECONDS.toSeconds(value) - TimeUnit.MILLISECONDS.toMinutes(value) * 60L;
            long[] times = new long[]{days, hours, minutes, second};
            String[] names = new String[]{" d,", " h,", " m e", " s"};
            List<String> values = Lists.newArrayList();

            for(int index = 0; index < times.length; ++index) {
                long time = times[index];
                if (time > 0L) {
                    String name = text(times[index], names[index]);
                    values.add(name);
                }
            }

            if (values.size() == 1) {
                return values.get(0);
            } else {
                return String.join(" ", values);
            }
        }
    }

    public static String text(long quantity, String message) {
        return quantity + message;
    }
}