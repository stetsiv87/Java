package auto;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Yuriy_Stetsiv on 10/13/2016.
 */
public class Main
{
    public static void main(String[] args) {

        TreeSet<String> ts = new TreeSet<>();
        ts.add("a");
        ts.add("z");
        ts.add("g");
        ts.add("a");


        for(String e:ts) {
            System.out.println(e);
        }
    }
}
