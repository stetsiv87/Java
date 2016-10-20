package auto;

import java.util.*;

class Sort implements Comparator<String> {
    public int compare(String a,String b) {
        return new Integer(b).compareTo(new Integer(a));
    }
}