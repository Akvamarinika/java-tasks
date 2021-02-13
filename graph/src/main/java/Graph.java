import java.io.*;
import java.util.*;

public class Graph {
    private Map<Integer, Set<Integer>> graph;
    private List<Integer> searchedVertex;
    private Deque<Integer> deque;
    private int countGraph;
    private  int graphSize;

    public Graph() {
        graph = new HashMap<>();
        searchedVertex = new ArrayList<>();
        countGraph = -1;

    }

    public int getCountGraph() {
        return countGraph;
    }

    public void initGraph(String filePatch){
        int keyVertex;
        int valueVertex;
        try {
            File file = new File(filePatch);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            graphSize = Integer.parseInt(reader.readLine());
            System.out.println(graphSize);
            while ((line = reader.readLine()) != null) {
                if (line.matches("^\\d+\\s+\\d+$")){
                    String[] arrayStr =  line.split("\\s+");
                    keyVertex = Integer.parseInt(arrayStr[0]);
                    valueVertex = Integer.parseInt(arrayStr[1]);

                    checkKeyInMap(keyVertex, valueVertex);
                    checkKeyInMap(valueVertex, keyVertex);

                } else {
                    //System.out.println(line);
                    keyVertex = Integer.parseInt(line);
                    if (!graph.containsKey(keyVertex)){
                        graph.put(keyVertex, new HashSet<>());
                    }
                }
            }

           System.out.println(graph);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void checkKeyInMap(int key, int value){
        if (graph.containsKey(key)){
            graph.get(key).add(value);
        } else {
            graph.put(key, new HashSet<>());
            graph.get(key).add(value);
        }
    }

    public void numberOfGraphEdgesToAdd(){
       for (int key : graph.keySet()){
            if (!searchedVertex.contains(key)){
                widthGraphTraversal(key);

            }
       }

    }

 public void gaps(){
        for (int i=1; i<graphSize; i++){
            if (!graph.containsKey(i)){
                //System.out.println(i);
                countGraph++;
            }
        }

    }

    private void widthGraphTraversal(int startVertex) {
        deque = new ArrayDeque<>(graph.get(startVertex));
        while (!deque.isEmpty()) {
            int vertex = deque.pollFirst();
            if (!searchedVertex.contains(vertex)) {
                for (int otherVertex : graph.get(vertex)) {
                    deque.addFirst(otherVertex);
                }

                searchedVertex.add(vertex);
            }
        }
        countGraph++;
    }
}
