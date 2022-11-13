package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>(){
            @Override
            public int compare(final String s1, final String s2) {
                final var month1 = Month.fromString(s1);
                final var month2 = Month.fromString(s2);
                return Integer.compare(month1.days, month2.days);
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>(){
            @Override
            public int compare(final String s1, final String s2) {
                return Month.fromString(s1).compareTo(Month.fromString(s2));
            }
        };
    }

    private enum Month {

        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;
        
        Month(final int days) {
            this.days = days;
        }

        public static Month fromString(final String input) {
            try {
                //control if the input matches exactly an identifier used
                return Month.valueOf(input);
            } catch (IllegalArgumentException e) {
                Month match = null;
                int matchCounter = 0;
                for (final Month m : Month.values()) {
                    if (m.name().toLowerCase().startsWith(input.toLowerCase())) {
                        match = m;
                        matchCounter++;
                    }
                }
                switch (matchCounter) {
                    case 0:
                        throw new IllegalArgumentException("No match found with the input insered " + input, e);
                    case 1:
                        return match;
                    default:
                        throw new IllegalArgumentException(
                            input + "is ambiguos ",e 
                        );
                }
        }
    }
}
}