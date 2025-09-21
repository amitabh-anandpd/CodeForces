import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapSort {
    //From GeeksForGeeks
    static HashMap<Long, Integer> sortByValue(HashMap<Long, Integer> hm) {
        List<Map.Entry<Long, Integer> > list =
               new LinkedList<Map.Entry<Long, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Long, Integer> >() {
            public int compare(Map.Entry<Long, Integer> o1, 
                               Map.Entry<Long, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        HashMap<Long, Integer> temp = new LinkedHashMap<Long, Integer>();
        for (Map.Entry<Long, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    
}
