package it.unibo.nestedenum;

import java.lang.reflect.AnnotatedTypeVariable;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    public enum Month {
        GENNAIO("Gennaio",31),
        FEBBRAIO("Febbraio",28),
        MARZO("Marzo",31),
        APRILE("Aprile",30),
        MAGGIO("Maggio",31),
        GIUGNO("Giugno",30),
        LUGLIO("Luglio",31),
        AGOSTO("Agosto",31),
        SETTEMBRE("Settembre",30),
        OTTOBRE("Ottobre",31),
        NOVEMBRE("Novembre",30),
        DICEMBRE("Dicembre",31);

        private final String name;
        private final int days;

        private Month(final String name,final int days){
            this.name=name;
            this.days=days;
        }

        public Month fromString(final String stringa){

        }
   }
}
