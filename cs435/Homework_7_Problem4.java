package com.pragati.cs435;

import java.util.*;

/**
 * Created by pragati on 16/11/19.
 */
public class Homework_7_Problem4 {


    public static void main(String[] args){

        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int numberCitzen = sc.nextInt();
        for(int i=0;i<numberCitzen;i++){
            vertices.add(sc.next());
        }

        int numberServices = sc.nextInt();
        ArrayList<String> services = new ArrayList<>();


        
        for(int i=0;i<numberServices;i++){
            String place=sc.next();
            services.add(place);
            vertices.add(place);
        }

        Collections.sort(services);

        int edgeCount = sc.nextInt();
        for(int i=0;i<edgeCount;i++){
            
            String input = sc.next();
            String []str = input.split(",");

            String startPoint = str[0];
            String endPoint = str[1];
            int distance = Integer.parseInt(str[2]);
            
            Edge edge1 = new Edge(startPoint,endPoint,distance);
            Edge edge2 = new Edge(endPoint,startPoint,distance);
            
            edges.add(edge1);
            edges.add(edge2);
        }

        ArrayList<ArrayList<Edge>> paths = new ArrayList<>();

        for(int i=0;i<numberServices;i++){
            ArrayList<Edge> path = dijkstra(services.get(i),vertices,edges,services);

            path.sort(Comparator.comparing(Edge::getDest));

            paths.add(path);
            System.out.print(services.get(i)+" ");
        }

        System.out.println();

        String output="";
        for(int i=0;i<numberCitzen;i++){

            int j;
            for(j=0;j<numberServices;j++){
                output += paths.get(j).get(i).distance+" ";
            }

            output += paths.get(j-1).get(i).getDest();
            output += "\n";
        }

        System.out.println(output);
    }

    private static ArrayList<Edge> dijkstra(String src, ArrayList<String> vertices, ArrayList<Edge> edges,ArrayList<String> services) {

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<vertices.size();i++){
            if(vertices.get(i).equals(src)){
                map.put(src,0);
            }
            else{
                map.put(vertices.get(i),Integer.MAX_VALUE);
            }
        }

        ArrayList<Edge> paths = new ArrayList<>();
       while(map.size()!=0){

          String minKey = getMin(map);

          if(!services.contains(minKey))
            paths.add(new Edge(src,minKey,map.get(minKey)));

           for(int i=0;i<edges.size();i++){

               if(edges.get(i).src.equals(minKey) && map.containsKey(edges.get(i).dest) ){
                   int localDistance = edges.get(i).distance;

                   int totalDistance = map.get(minKey)+localDistance;

                   if(totalDistance<map.get(edges.get(i).dest)){
                       map.replace((edges.get(i).dest),totalDistance);
                   }
               }
           }
           map.remove(minKey);
       }
        return paths;
    }


    private static String getMin(HashMap<String, Integer> map) {

        String key = null;
        int min = Integer.MAX_VALUE;

        for(Map.Entry<String,Integer> entry: map.entrySet() ){
            if( entry.getValue()<min){
                key = entry.getKey();
                min = entry.getValue();
            }
        }

        return key;
    }

}

class Edge{

    String src;
    String dest;
    int distance;
    
    public Edge(String src, String dest, int distance){
        this.src = src;
        this.dest = dest;
        this.distance = distance;
    }

    public String getDest(){
        return this.dest;
    }
}
