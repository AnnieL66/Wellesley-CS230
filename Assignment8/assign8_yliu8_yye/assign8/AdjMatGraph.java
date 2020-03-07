
/**
 * AdjMatGraph.java
 * Implementation of the Graph.java interface.
 * KNOWN FEATURES/BUGS: 
 * It handles unweighted graphs only, but it can be extended
 * It does not handle operations involving non-existing vertices
 *
 * @author (Yaxin Liu)
 * @version (2018)
 */
import java.io.*;
import java.util.*;

public class AdjMatGraph<T> implements Graph<T>{
    // instance variables - replace the example below with your own
    private final int NOT_FOUND = -1;
    private final int DEFAULT_CAPACITY = 1;
    
    private int n;  // number of vertices in the graph
    private boolean[][] arcs;   // adjacency matrix of arcs
    private T[] vertices;
    private int count;

    /**
     * Constructor for objects of class AdjMatGraph without arguments that 
     * initializes an empty graph and allocate by default space for the 
     * vertices and arcs arrays.
     */
    public AdjMatGraph(){
        // initialise instance variables
        n = 0;
        arcs = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        vertices = (T[])(new Object[DEFAULT_CAPACITY]);
    }
    
    /**
     * Second constructor take as input a file with an extension .tgf and 
     * read it as follows:
     * The file has two parts separated by a sharp symbol (#). 
     * The first part lists all the vertices, one per line. 
     * A vertex is described by two items: a vertex number and a String 
     * label. The second part lists all the arcs, as a pair of vertex 
     * numbers separated by space.
     */
    public AdjMatGraph(String inFileName){
        vertices = (T[]) (new Object[DEFAULT_CAPACITY]); 
        arcs = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        n = 0;
        
        try{
            Scanner scan = new Scanner(new File(inFileName));
            while (!scan.next().equals("#")){
                T line = (T) scan.next();
                addVertex(line);
            }
      
            while (scan.hasNext()){
                int arcVertex1 = scan.nextInt();
                int arcVertex2 = scan.nextInt();
                // System.out.println ("Arc Vertex 1: " + arcVertex1);
                // System.out.println ("Arc Vertex 2: " + arcVertex2);
                addArc(vertices[arcVertex1-1], vertices[arcVertex2-1]);
            }
            scan.close();
        } catch (IOException ex) {
            System.out.println(" The file was not found: " + ex);
        }
    }

    /** 
     * Returns true if this graph is empty, false otherwise. 
     */
     public boolean isEmpty(){
       return (n == 0);
    }
    
    /** 
     * Returns the number of vertices in this graph.
     */
     public int getNumVertices(){
       return n;
    }

    /**
     * Returns the number of arcs in this graph. 
     */
     public int getNumArcs(){
        int total = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(arcs[i][j]){
                    total++; 
                }
            }
        }
        return total;
    }  
   
    /** 
     * Returns true iff a directed edge exists b/w given vertices 
     */
     public boolean isArc (T vertex1, T vertex2){
       if(indexIsValid(getIndex(vertex1)) && indexIsValid(getIndex(vertex2))){
          return arcs[getIndex(vertex1)][getIndex(vertex2)];
        }else{
        return false;
       }
    }
    
    /** 
     * Returns true iff an edge exists between two given vertices
     * which means that two corresponding arcs exist in the grap
     */
     public boolean isEdge (T vertex1, T vertex2){
        return (isArc(vertex1, vertex2) && isArc(vertex2, vertex1));
    }

    /** 
     * Adds a vertex to this graph, associating object with vertex.
     * If the vertex already exists, nothing is inserted. 
     */
     public void addVertex (T vertex){
         if(getIndex(vertex) == -1){
           if (n == vertices.length){
               expandCapacity();
           }
           vertices[n] = vertex;
           for (int i = 0; i < n; i++){
               arcs[n][i] = false;
               arcs[i][n] = false;
           }
           n++;
        }
    }

    /** 
     * Removes a single vertex with the given value from this graph.
     * If the vertex does not exist, it does not change the graph. 
     */ 
     public void removeVertex (T vertex){ 
        int index = getIndex(vertex);
        
       while(getIndex(vertex) != -1){
        n--;

        for (int i = index; i < n; i++){
                vertices[i] = vertices[i+1];
            }
        
        for (int i = 0; i <= n; i++){
            for(int j = 0; j < n; j++){
                arcs[i][j] = arcs[i][j+1]; 
            }
        }
        
        for (int i = 0; i <= n; i++){
            for(int j = 0; j < n; j++){
                arcs[i][j] = arcs[i+1][j]; 
            }
        }
       
    }
    }
  
    /**
     * Returns the index value of the first occurrence of the vertex.
     * Returns -1 if the key is not found.
     */
    public int getIndex(T vertex){
        for (int i = 0; i < n; i++){
            if (vertices[i] == vertex){
               return i;
            }
        }
        return -1;
    }
    
    /**
     * Returns true if the given index is valid
     */
    private boolean indexIsValid(int index){  
        return ((index < n) && (index >= 0));  
    }
    
    /**
    * Inserts an arc between two vertices of this graph,
    * if the vertices exist. Else it does not change the graph. 
    */
    public void addArc (T vertex1, T vertex2){
       if(!isArc(vertex1,vertex2)){
          arcs[getIndex(vertex1)][getIndex(vertex2)] = true;
     }
    }

   /**
    * Removes an arc between two vertices of this graph,
    * if the vertices exist. Else it does not change the graph. 
    */
   public void removeArc (T vertex1, T vertex2){
       if(isArc(vertex1, vertex2)){
          arcs[getIndex(vertex1)][getIndex(vertex2)] = false;
    }
    }
   
   /** 
    * Inserts an edge between two vertices of this graph,
    * if the vertices exist. Else does not change the graph. 
    */
   public void addEdge (T vertex1, T vertex2){
        if (!(isEdge(vertex1, vertex2))){
             addArc (vertex1, vertex2);
             addArc (vertex2, vertex1);
        }
    }
    
   /** 
    * Removes an edge between two vertices of this graph
    * if the vertices exist, else does not change the graph. 
    */
   public void removeEdge (T vertex1, T vertex2){
       if (isEdge(vertex1, vertex2)){
            removeArc (vertex1, vertex2);
            removeArc (vertex2, vertex1);
        }
    }
    
   /**
    * Creates new arrays to store the contents of the graph with
    * twice the capacity.
    */
    public void expandCapacity()
    {
        T[] newVertices = (T[])(new Object[vertices.length*2]);
        boolean[][] newArcs = 
                        new boolean[vertices.length*2][vertices.length*2];

        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                newArcs[i][j] = arcs[i][j];
            }
            newVertices[i] = vertices[i];
        }

        vertices = newVertices;
        arcs = newArcs;
    }

   
   /** 
    * Returns a string representation of the adjacency matrix. 
    */
   public String toString(){
       if (n == 0){
           return "Graph is empty.";
       }

        String str = "";
        str += "Arcs\n";
        str += "-----\n";
        str += "i" + " ";
        for (int i = 0; i < n; i++){
            str += "" + vertices[i];
            if (i < 10){
                str += " ";
            }
        }
        str += "\n";
         
        for (int i = 0; i < n; i++){
            str += "" + vertices[i] + " ";
            for (int j = 0; j < n; j++){
                if (arcs[i][j]){
                str += "1 ";
                }else{
                str += "- ";
               }
            }
         str += "\n";
       }
        return str;
  }
  
   /** 
    * Saves the current graph into a .tgf file. 
    * If it cannot write the file, a message is printed. 
    */
   public void saveTGF(String tgf_file_name){
       try{
           PrintWriter printers = new PrintWriter(new File(tgf_file_name));
           //prints vertices by iterating through array "vertices"
           for(int i = 0; i < n; i++){
               if (vertices[i] == null){
                    break;
                 }else{
                printers.println((i+1) + " " + vertices[i]);
             }
           }
           printers.println("#");
           for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if (arcs[i][j]){
                        printers.println((i+1) + " " + (j+1));
                    }
                }
            }
            printers.close();
        }catch(IOException ex){
        System.out.println("File cannot be created.");
    }
}

public static void main(String[] args){
    AdjMatGraph g = new AdjMatGraph();
    System.out.println("New graph created.");
    System.out.println(g.toString());
    System.out.println("isEmpty is TRUE: " + g.isEmpty());
    System.out.println("An empty graph has: " + g.getNumVertices() + "(0) vertices and "
        + g.getNumArcs() + "(0) arcs");
    System.out.println("Adding 6 vertices: A, B, C, D, E, F");
    g.addVertex('A');
    g.addVertex('B');
    g.addVertex('C');
    g.addVertex('D');
    g.addVertex('E');
    g.addVertex('F');
    
    System.out.println("After adding 6 vertices, it has: " + g.getNumVertices() 
    + "(6) vertices and " + g.getNumArcs() + "(0) arcs");
    System.out.println("isArc between A and B is FALSE: " + g.isArc('A', 'B')
    + "\n");
    
    System.out.println("Test Edge Case");
    // Test Edge Case: Add an Vertex that already exist
    System.out.println("Test adding an Vertex that alredy exist. Add F");
    g.addVertex('F');
    System.out.println("Now it has: " + g.getNumVertices() 
    + "(6) vertices and " + g.getNumArcs() + "(0) arcs");
    
    // Test Edge Case: Remove an Vertex that doesn't exist
    System.out.println("Test removing an Vertex that doesn't exist. Remove H");
    g.removeVertex('H');
    System.out.println("Now it has: " + g.getNumVertices() 
    + "(6) vertices and " + g.getNumArcs() + "(0) arcs\n");
    
    System.out.println("Added A->B, B--C, C--D.");
    g.addArc('A', 'B');
    g.addEdge('A', 'B');
    g.addEdge('B', 'C');
    g.addEdge('C', 'D');
    g.addEdge('A', 'F');
    g.addEdge('A', 'D');
    System.out.println("After adding edges AB, BC, CD, AF, AD, \nthe graph has: "
    + g.getNumVertices() + "(6) vertices and " + g.getNumArcs() + "(10) arcs.");
    System.out.println(g.toString());
    
    System.out.println("Test Edge Case");
    // Test Edge Case: Remove an Edge that doesn't exist
    System.out.println("Test removing an Edge that doesn't exist. Remove A-C");
    g.removeEdge('A', 'C');
    System.out.println("Now it has: " + g.getNumVertices() 
    + "(6) vertices and " + g.getNumArcs() + "(10) arcs");
    
    // Test Edge Case: Add an Edge that already exist
    System.out.println("Test adding an Edge that already exist. Add A-B");
    g.addEdge('A', 'B');
    System.out.println("Now it has: " + g.getNumVertices() 
    + "(6) vertices and " + g.getNumArcs() + "(10) arcs");
    
    // Test Edge Case: Remove an Arc that doesn't exist
    System.out.println("Test removing an arc that doesn't exist. Remove B-F");
    g.removeArc('A', 'C');
    System.out.println("Now it has: " + g.getNumVertices() 
    + "(6) vertices and " + g.getNumArcs() + "(10) arcs");
    
    // Test Edge Case: Add an Arc that already exist
    System.out.println("Test adding an Arc that already exist. Add C-D");
    g.addArc('C', 'D');
    System.out.println("Now it has: " + g.getNumVertices() 
    + "(6) vertices and " + g.getNumArcs() + "(10) arcs\n");
    
    g.addArc('B', 'E');
    g.removeVertex('A');
    System.out.println("A removed; B->E added; Draph has now: " + g.getNumVertices() 
    + "(5) vertices and " + g.getNumArcs() + "(5) arcs.");
    System.out.println(g.toString());
    
    System.out.println("Test saveTGF");
    g.saveTGF("newTGF.tgf");
    
    System.out.println("Test read from TGF");
    AdjMatGraph g1 = new AdjMatGraph("Graph.tgf");
    System.out.println(g1.toString());
}
}
