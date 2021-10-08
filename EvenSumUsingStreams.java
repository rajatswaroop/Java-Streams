import java.util.Arrays;
import java.util.List;
/*
Find the sum of all the even numbers using streams?

using mapToInt method and sum method to return the sum .
 */
public class EvenSumUsingStreams {

    public static void main(String [] args)
    {
        List<Integer> list = Arrays.asList(2,4,7,8,9,6,3);
        int value= list.stream().filter(i -> i%2==0).mapToInt(i -> i.intValue()).sum();
        System.out.println(value);
    }
}
