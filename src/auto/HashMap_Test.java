package auto;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy_Stetsiv on 10/12/2016.
 */
public class HashMap_Test
{
    public String name;

    public int hashCode(){
        return name.hashCode();
    }



    public boolean equals(Object o){
        if(o instanceof HashMap_Test){
            return name.equals( ((HashMap_Test)o).name );
        }
        return false;
    }

    public static void main(String[] args) {
        Map<HashMap_Test, Integer> map = new HashMap<HashMap_Test, Integer>();
        HashMap_Test a1 = new HashMap_Test();
        a1.name="one";

        System.out.println(a1.hashCode());

        map.put(a1, 1);

        a1.name="two";
        HashMap_Test a2=new HashMap_Test();
        a2.name="one";

        System.out.println(map.get(a1));
        System.out.println(map.get(a2));
    }
}
