package org.RickAndMorty.Steps;

import java.util.List;

public class StepsUtils {

    public static void printList(String title, List<String> list) {
        System.out.println("=== " + title + " ===");
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty or null");
        } else {
            list.forEach(System.out::println);
        }
        System.out.println("=== end of " + title + " ===\n");
    }
}