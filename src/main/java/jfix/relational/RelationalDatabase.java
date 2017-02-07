package jfix.relational;

import java.util.List;

/**
 * Created by mghasemy on 2/7/17.
 */
public class RelationalDatabase {
    public <E> List<E> query(String TableN) {
        return null;
    }
    public <E> List<E> query(String TableN, String Query) {
     return null;
    }
    public <E> E queryUnique(String TableN, String Query) {
        return null;
    }
    public <E> boolean isUnique(String TableN, String Query) {
        try {
            List<E> result = query(TableN,Query);
            if (result == null) {
                return true;
            }
            if (result.size() == 1 ) {
                return false;
            }
            if (result.size() > 1) {
                return false;
            }
            return true;
        } finally {

        }
    }
    public boolean isStored(String userid) {
        return false;
    }
}
