/**
 * IntStream
 * .range()
 * .sum()
 * Stream
 * .of()
 * 
 */

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream; 

class StreamInteger{
    public static void main(String[] args) {
        int sum = IntStream.range(1, 10)
                    .filter(i -> i > 2 )
                    .sum();
        System.out.println(sum);

        List<Integer> marks = Arrays.asList(new Integer[]{35, 40, 50, 60, 77, 80});

        System.out.println("Original marks: \t" + marks);

        List<Integer> marksWithGrace = marks.stream()
        .map(i -> i + 5)
        .collect(Collectors.toList());

        System.out.println("Marks with grace: \t" + marksWithGrace);


        Stream<Integer> stream = Stream.of(1,10,100,1000,10000);
        Integer[] arr = stream.toArray(Integer[]::new);
        // Integer[] arr = stream.toArray(size -> new Integer[size]);
        System.out.println(Arrays.toString(arr) );
    }
}

