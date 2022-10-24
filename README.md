# Graph-Coloring-Problem
This is a project that we designed and implement algorithm for the optimal solution to Graph Coloring Problem.

What is graph coloring problem ?
              Graph Coloring (or Vertex Coloring) problem is defined as assignment of smallest number
          of colors to the vertices of an undirected graph, such that no adjacent vertices are of the same
          color. A coloring using at most k colors is called a (proper) k-coloring. The smallest number
          of colors needed to color a graph G is called its chromatic number and is often denoted χ(G).
          The goal is to color all vertices of the graph, such that number of colors used (k) is as close as
          possible to the optimal result, i.e. χ(G). Since this problem is NP-Hard, it is very difficult to
          find the optimal solution especially for large instances.
          Graph Coloring can be used to model many practical problems, such as event scheduling.


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











The group members are Evren Koymat and Sinan Göçmen.
