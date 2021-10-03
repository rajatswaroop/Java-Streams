/*
****************************************Program to print the first unique character in a String using Streams? ***********************************

Why input.chars()?
Ans- it returns integer value of char streams.

Why mapToOb()?
Ans- I need to convert int stream of char to Character.

Why am i using Collectors.groupingBy??
Ans- https://stackoverflow.com/questions/25441088/how-can-i-count-occurrences-with-groupby

Why LinkedHashMap?
Ans- It maintains the order of insertion.

Why Function.Identity() ?
Ans - https://stackoverflow.com/questions/28032827/java-8-lambdas-function-identity-or-t-t/28041480

After this i need to convert LinkedHashMap to stream of values and filter the records with count 1.

map(entry -> entry.getKey()) ?
Ans- It will convert every entry-set values into key .

The first key is the required output ...


*/

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueChar {

    private static Character logic(String input) {
        Character result =  input.chars()      //int stream of characters
                .mapToObj(i -> Character.valueOf((char) i)) //convert to lowercase & then to Character object
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //store in a map with the count
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst().get();

        return result;
    }
    public static void main(String [] args){

        String str = "tenant";
        ArrayList<String> al = new ArrayList<>();
        al.add(str);

        Character firstNonRepeatedChar = logic(str);
        System.out.println(firstNonRepeatedChar);
    }
}
