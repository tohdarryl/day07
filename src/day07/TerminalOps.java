package day07;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class TerminalOps {
    
    public static void main(String[] args) {
        //Randomly generate a list
        Integer max = 200;
        Integer range = 100;
        Random rand = new SecureRandom();

        List<Integer> numList = new LinkedList<>();
        for (Integer i = 0; i < max; i++)
        numList.add((rand.nextInt(range)));

        System.out.println(">>> numList: " + numList);
        
        //filter(numList);
        //joining(numList);
       //reducing(numList);
        //joiningAsReducing(numList);
        reducing2(numList);
    }
    public static void reducing2(List<Integer> numList) {
        System.out.println("============== REDUCING2 ==============");

        Integer result = numList.stream()
            .map(n -> "%d%d".formatted(n,n))
            .map(Integer::parseInt)
            .collect(
                Collectors.reducing(
                    0 , (total, i) -> { //parameters
                        System.out.printf("total: %d, i: %d\n", total, i);
                        return total + i;
                    }
                )
            );
    } 

        public static void joiningAsReducing (List<Integer> numList) {
            System.out.println("============== JOINING AS REDUCING ==============");
    
            Optional<String> opt = numList.stream()
                //map: String apply(Integer i)
                .map(n -> "%d%d".formatted(n,n))
                .collect(
                    //Integer apply (Integer total, Integer i)
                    Collectors.reducing((total, i) -> {
                        System.out.printf("total: %s, i: %s\n", total, i);
                        return "%s, %s".formatted(total,i);
                    })
                );
                //check if we have any answer
                if (opt.isPresent())
                 //Getting the answer
                System.out.println(">>> total: "+ opt.get());
                else
                System.out.println("Reducing produces no result");
        }

        public static void reducing (List<Integer> numList) {

            System.out.println("============== REDUCING ==============");
    
            Optional<Integer> opt = numList.stream()
                //map: String apply(Integer i)
                .map(n -> "%d%d".formatted(n,n))
                //.map(Convert to Integer)
                .map(Integer::parseInt)
                .collect(
                    //Integer apply (Integer total, Integer i)
                    Collectors.reducing((total, i) -> {
                        System.out.printf("total: %d, i: %d\n", total, i);
                        return total + i;
                    })
                );
                //check if we have any answer
                if (opt.isPresent())
                 //Getting the answer
                System.out.println(">>> total: "+ opt.get());
                else
                System.out.println("Reducing produces no result");
    
    
             }

             public static void joining (List<Integer> numList) {

            System.out.println("============== JOINING ==============");
    
            String listOfNums = numList.stream()
                //map: String apply(Integer i)
                .map(n -> "%d%d".formatted(n,n))
                .collect(Collectors.joining("\n"));
                 //Terminating expression
                System.out.println(">>> stream listOfNums: "+ listOfNums);
    
    
             }

}
