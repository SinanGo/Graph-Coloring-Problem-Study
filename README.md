# Graph-Coloring-Problem
What is graph coloring problem ?

Graph Coloring (or Vertex Coloring) problem is defined as assignment of smallest number
of colors to the vertices of an undirected graph, such that no adjacent vertices are of the same
color. A coloring using at most k colors is called a (proper) k-coloring. The smallest number
of colors needed to color a graph G is called its chromatic number and is often denoted χ(G).
The goal is to color all vertices of the graph, such that number of colors used (k) is as close as
possible to the optimal result, i.e. χ(G). Since this problem is NP-Hard, it is very difficult to
find the optimal solution especially for large instances.
Graph Coloring can be used to model many practical problems, such as event scheduling.

Project Specification : 

Input format: Inputs will always be given as a text file. Input file format should be as
follows:
The first line is the problem line which indicates the number of vertices and the number of
edges. It starts with “p”, and there is only one such line.
p <NumVertices> <NumEdges>
The rest of the lines are edge lines. Each line starts with “e” and indicates an edge between
two vertices.
e <VertexNumber1> <VertexNumber2>
The above line means that there is an edge between VertexNumber1 and VertexNumber2.
Here is a sample graph:
  


![Screenshot_6](https://user-images.githubusercontent.com/105942580/197558210-e10b1a80-3fb5-4a69-82a5-7b4ff6879dd7.png)
  


  Vertices should always be numbered from 1 to n, where n is the number of vertices.
  
  
  Output format: The output should be a text file that consists of two lines:
  - The first line should include a single integer value, the number of colors used (k).
  - The second line should include the labels of the colors used for all vertices, from
  vertex 1 to vertex n. Label values are integers between zero and k-1 and they are
  separated by a space character.
  A possible coloring for the above graph is as follows:

  
  ![Screenshot_7](https://user-images.githubusercontent.com/105942580/197559267-f39c939b-6b18-41ad-848f-b695480f18eb.png)

  
  If the labels of the colors are assigned as: Red: 0; Blue: 1; Yellow: 2
  
  Then the output would be as following:
  3
  0 1 2 0 2

  
  ![Screenshot_8](https://user-images.githubusercontent.com/105942580/197559907-ba2bf3e7-e022-46bf-bcab-0f4a4ebf1031.png)

  
Our Algorithm :
  
    Before searching graph coloring solutions, we wanted to try to solve this problem with
  matrices. The idea was simple: We are using a square matrix because if we have an edge
  between vertex 1 and vertex 2, also we can write it as 2 1, so we need to hold 2 types. Because
  there is no edge between same vertices (1 and 1), diagonal of the matrix always be zero. So, we
  choose the diagonal elements (i’th row i’th column ) to store the color code of the corresponding
  vertex (0 means no edge, 1 means there is an edge between given vertices). Also, we just take
  the lower triangular of the matrix because we do not need to compare same vertices 2 times.
  After we finish the code, we searched if there is a matrix solution to graph coloring problem
  and we found someone tried but never used diagonals or upper/lower triangular to calculate the
  colors. So, we think our code is unique. Although it is not too close to the optimal solution, it 
  worth working on.
  
  There is a sample which includes 10 vertices and adjacency information. Let’s show how our code works on this:
  
  ![image](https://user-images.githubusercontent.com/105942580/197561856-5c51fe25-395d-4c96-a524-482c319da77e.png)

  
  ![image](https://user-images.githubusercontent.com/105942580/197561861-2b786959-e618-45a9-b0fe-e789f2dcd9d6.png)
  

  Implementation
  
                                    figure - 1 : Basic Structure
  
  ![image](https://user-images.githubusercontent.com/105942580/197561927-2c4263b8-def0-48f5-8c8c-2610f893e94c.png)
  
  
                                    figure – 2 : set diagonal algorithm
  
  ![image](https://user-images.githubusercontent.com/105942580/197561975-a201af52-542b-47b1-9e86-74a05e68ad37.png)
  

  
    In this function, we first assign color-code as 0. For each row (index i), starting from 
  the first, ended at the i’th column, we check the two conditions to determine the color code: 
  
  1) are these vertices adjacent? 
  
  2) do they have the same color code?
  
  If both conditions hold, we increment color-code by 1 and start from the beginning to check the conditions again by assigning j as 0.
  
    The reason why we do not check after the i’th column is that we will already check 
  them at the symmetrical cell. In this way, we do not have to spend exertion for half of the 
  matrix (upper right of the matrix is not used).
  When we reach the i’th column, we store the color code in m[i][i] to determine the 
  remaining vertices’ color codes and in an array to reach the color codes easily.
  As it is seen, just this function is enough to get a solution for graph coloring problem.
  
  How to run the code ?
  
      I use Windows command promp. Firstly change the current directory to the location of installed .java file.
  
  
  ![Screenshot_9](https://user-images.githubusercontent.com/105942580/197566116-436690ed-d49b-4a63-8fe1-eedd07d46f42.png)
  
  
  Then type javac Test.java to compile the code.
  
  
  ![Screenshot_10](https://user-images.githubusercontent.com/105942580/197566298-563b0519-294c-4b16-8ea8-064ca1283e31.png)
  

  If there are no error , type java Test to run the code.
  
  
  ![Screenshot_11](https://user-images.githubusercontent.com/105942580/197566460-e7d928fc-624e-480c-9c53-72f64ddf64d5.png)

  
  The code will ask you to enter the name of input and output txt files.
  
  
  ![Screenshot_13](https://user-images.githubusercontent.com/105942580/197566708-c7d6effc-e35c-46a1-9495-fcf1a4c8ac5d.png)
  

  After typing the file names , the output file will create at the location of installed .java file. And it will look like this:
  
  
  ![Screenshot_14](https://user-images.githubusercontent.com/105942580/197566936-9604457f-f058-4108-a872-4fe81378d763.png)

 
  
  
                                                    The group members are Evren Koymat and Sinan Göçmen.
                                                The teacher is Assoc. Prof. ÖMER KORÇAK , TA is Kübra Uludağ.
