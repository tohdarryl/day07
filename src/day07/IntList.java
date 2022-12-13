package day07;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;





public class IntList {

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
        map(numList);

        }

        public static void map (List<Integer> numList) {

            System.out.println("============== MAP ==============");
    
            // filter
            List <Integer> resultList = new LinkedList<>();
            for (Integer n : numList){
                if(0 == (n % 3))
                resultList.add(n);
            }
            System.out.println(">>> resultList: " + resultList);
    
            List<Integer> intList = numList.stream()
                //map: String apply(Integer i)
                .map(n -> "%d%d".formatted(n,n))
                //map: Integer apply (String i)
                .map(n -> Integer.parseInt(n)) //method reference //I
                //.map(Integer::parseInt) same as .map(n -> Integer.parseInt(n))
                .toList(); //Terminating expression
                    //return 0 != (n % 3); //condition expression
                System.out.println(">>> stream intList: "+ intList);
    
    
             }

        public static void filter (List<Integer> numList) {

        System.out.println("============== FILTER ==============");

        // filter
        List <Integer> resultList = new LinkedList<>();
        for (Integer n : numList){
            if(0 == (n % 3))
            resultList.add(n);
        }
        System.out.println(">>> resultList: " + resultList);

        resultList = numList.stream()
            //Predicate: boolean test (Integer i)
            // (n) parameter, ()body
            .filter((n) -> 0 == (n % 3))
            .distinct()
            .sorted()
            .limit(5)
            .toList(); //Terminating expression
                //return 0 != (n % 3); //condition expression
            System.out.println(">>> stream resultList: "+ resultList);


         }

         
            



    
    
}
