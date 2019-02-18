import java.util.*;

public class HashMapSort {
    public static void main(String[] args){
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        users.put(1, new User("Amy", 25));
        users.put(2, new User("David", 22));
        users.put(3, new User("Zoey", 74));
        System.out.println(users);
        HashMap<Integer, User> sortedHashMap = sortHashMap(users);
        System.out.println(sortedHashMap);
    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map){
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<Map.Entry<Integer, User>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, User> entry: list)
        {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;

    }
}
