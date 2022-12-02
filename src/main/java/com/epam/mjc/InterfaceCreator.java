package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String e : list) {
                if (!Character.isUpperCase(e.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) % 2 == 0) {
                    list.add(list.get(i));
                }
            }
            System.out.println(list);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String item : values) {
                String[] words = item.split(" ");
                if ((Character.isUpperCase(item.charAt(0)))
                        && (words[words.length - 1].endsWith("."))
                        && (words.length > 3)) {
                    result.add(item);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String item : x) {
                map.put(item, item.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> concatList = new ArrayList<>();
            concatList.addAll(list1);
            concatList.addAll(list2);
            return concatList;
        };
    }
}
