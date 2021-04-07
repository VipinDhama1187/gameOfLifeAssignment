# gameOfLife Assignment
A simple java console implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life)

# How to execute?
java com.charge.point.Game <width> <height> <seed alive cells in the format x,y>

##Example:
25x25 world with the ‘Glider’ pattern :- https://en.wikipedia.org/wiki/Gun_(cellular_automaton)
java com.charge.point.Game 25 25 1,5 2,5 3,5 3,4 2,3 7,5 8,5 9,5 9,4 6,3 22,4 22,5 23,2 23,6 25,1 25,2 25,6 25,7

# Output example:

-: 0
   |  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 0 |                                                                            
 1 |                                                                            
 2 |                                                                       *    
 3 |        *           *                                                       
 4 |           *                 *                                      *       
 5 |     *  *  *           *  *  *                                      *       
 6 |                                                                       *    
 7 |                                                                            
 8 |                                                                            
 9 |                                                                            
10 |                                                                            
11 |                                                                            
12 |                                                                            
13 |                                                                            
14 |                                                                            
15 |                                                                            
16 |                                                                            
17 |                                                                            
18 |                                                                            
19 |                                                                            
20 |                                                                            
21 |                                                                            
22 |                                                                            
23 |                                                                            
24 |

-: 1
   |  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 0 |                                                                            
 1 |                                                                          * 
 2 |                                                                          * 
 3 |                                                                            
 4 |     *     *           *     *                                              
 5 |        *  *              *  *                                      *  *    
 6 |        *                 *                                               * 
 7 |                                                                          * 
 8 |                                                                            
 9 |                                                                            
10 |                                                                            
11 |                                                                            
12 |                                                                            
13 |                                                                            
14 |                                                                            
15 |                                                                            
16 |                                                                            
17 |                                                                            
18 |                                                                            
19 |                                                                            
20 |                                                                            
21 |                                                                            
22 |                                                                            
23 |                                                                            
24 |                                                                            
-: 2
   |  0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 0 |                                                                            
 1 |                                                                            
 2 |                                                                            
 3 |                                                                            
 4 |           *                 *                                              
 5 |     *     *           *     *                                         *    
 6 |        *  *              *  *                                            * 
 7 |                                                                            
 8 |                                                                            
 9 |                                                                            
10 |                                                                            
11 |                                                                            
12 |                                                                            
13 |                                                                            
14 |                                                                            
15 |                                                                            
16 |                                                                            
17 |                                                                            
18 |                                                                            
19 |                                                                            
20 |                                                                            
21 |                                                                            
22 |                                                                            
23 |                                                                            
24 |                                                                                                                                                                                                   

