/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_annuel_code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

class MapUtil {
    // Program to print all values in a Map using values() in Java

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        // 1. using Iterator
        Iterator<String> itr = map.values().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 2. For-each Loop
        for (String key : map.values()) {
            System.out.println(key);
        }

        // 3. Java 8 - Collection.iterator() + Iterator.forEachRemaining()
        map.values().iterator()
                .forEachRemaining(System.out::println);

        // 4. Java 8 - Collection.stream() + Stream.forEach()
        map.values().stream()
                .forEach(System.out::println);

        // Java 8 - Stream.of() + Collection.toArray() + Stream.forEach()
        Stream.of(map.values().toArray())
                .forEach(System.out::println);

        // 5. Convert to String
        System.out.println(map.values().toString());

        // Java 8
        Stream.of(map.values().toString())
                .forEach(System.out::println);
    }
}
