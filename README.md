# Captain Catalog

As a curious UCSD undergrad, I always wanted to try out new courses across 
different areas of knowledge. 
As a headstarter, I always wanted to plan out the future.
As a realistic dude, I hope to graduate on time. 

Have you ever had this Lost moment on WebReg (UCSD's course registration site),
where you really liked a course, but haven't completed all its prerequisites?
You dig deeper, only to realize that the prerequisite courses also have their
own prerequistes that you haven't completed...

## Prerequisites
We can model the prerequisite relationship with a Directed Acyclic Graph (DAG),
where each vertex is a course, and each edge (u,v) represents course u is a prerequisite of v.

## Approach
### Scraping
Scrap the UCSD course catalog (courses' description and prerequisites) using
Selenium. 
### Student's Input
*Theoretically: Build a Directed Acyclic Graph. (deprecated, waste space)*
Take in student's "Done" courses
Take in student's "Wanna" courses
### Build Subgraph of Interest
Run reverse BFS on each vertex in {"Wanna" courses} to build the subgraph. 
Turn back when we searched a vertex that's "Done"
### Topology Sort
Use a Hashtable to keep track of all vertices' indegrees (during BFS).
For all outgoing vertices of the "Done" vertices', decrement indegree by 1.


## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

Referenced Library: Selenium (https://www.selenium.dev/) for web scraping.

2022/1/16: Working in Python now. Life is short. 