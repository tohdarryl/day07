package day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class storeSort {

    public static void main(String[] args) throws Exception{
        
        String fileName = args[0];

        FileReader fr = new FileReader(fileName);
        BufferedReader bfr = new BufferedReader(fr);

        List <App> apps = bfr.lines()
            //skip first line
            .skip(1)
            // String -> String[]
            .map(l -> l.split(","))
            //filter for columns with length <= 13
            .filter(cols -> cols.length<=14)
            //filter out column 2 with lines = "nan"
            .filter(cols -> !cols[2].trim().toLowerCase().equals(("nan")))
            

            // .map(cols ->{
            //     if(cols.length<=14)
            //     return cols;
            //     cols[1]="%s %s".formatted(cols[0],cols[1]);
            //     String[] dest = new String[cols.length-1];
            //     System.arraycopy(cols, 1, dest, 0, dest.length);
            //     return dest;
            // })

            .map(cols-> {
                App app = new App();
                app.setName(cols[0]);
                app.setCategory(cols[1]);
                app.setRating(Float.parseFloat(cols[2]));
                return app;
            })
            .toList();
            ;

            bfr.close();
            
            //System.out.println(apps);

            //converting List<App> to Map<String, List<App> using .stream()
             Map<String, List<App>> groupByCategory = apps.stream()
            .collect(
            //calling for cols [1] 'category'
            Collectors.groupingBy(app -> app.getCategory())
            );

            //for each key in Category
            for (String c: groupByCategory.keySet()) {
            //reference List<App> for list pertaining to key    
            List<App> listOfApps = groupByCategory.get(c);
            //print categories with no. of app based on category
            System.out.printf("Categories: %s - %d\n", c, listOfApps.size());
            }

            //calling for App class's method .toString(), for all lists with key: 'EVENTS'
            for (App a: groupByCategory.get("EVENTS"))
            System.out.println(a.toString());


        // String line;
        // Map <String,List<Float>> genreMap = new HashMap<>(); 
        
        // while(null != (line = bfr.readLine())){
            
        //    String [] array = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
      

            
        //     List<Float> genreList = new LinkedList<>();
        //     String genre = array[9];
        //     if(array[2].equalsIgnoreCase("rating")){
        //     System.out.println("Non decimal found");}
        //     else{
        //         Float rating = Float.parseFloat(array[2]);
        //         if(!genreMap.containsKey(genre)){
        //         genreList.add(rating);
        //         genreMap.put(genre, genreList);
        //         } else {
        //         genreMap.get(genre).add(rating);
        //         }
        //     }

        //     }

        //     bfr.close();
            
        //     Set <String> uniqueKey = genreMap.keySet();
        //     for (String uniqueGenre : uniqueKey)
        //     System.out.println(uniqueGenre);
            

        }




    }
    

