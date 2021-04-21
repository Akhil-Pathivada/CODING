/*
Check if a given sequence of moves for a robot is circular or not

Given a sequence of moves for a robot, check if the sequence is circular or not. 
A sequence of moves is circular if first and last positions of robot are same. 
A move can be on of the following :
				    G - Go one unit
  				    L - Turn left
  				    R - Turn right 
 
Time Complexity : O(n)  				    
*/

#include<stdio.h>
#include<string.h>
#include<stdbool.h>

#define N 0
#define E 1
#define S 2
#define W 3

bool checkCircular(char *path)
{
	int x = 0, y = 0; // initial stating coordinates of robot is (0,0)
	
	int dir = N; // initialising initial direction as 'North'
	
	for(int i=0; path[i]; ++i)
	{
		char move = path[i];
		
		if(path[i] == 'G') // if the move is 'G' 
		{
			if(dir == N)
				++y;
				
			else if(dir == E)
				++x;
				
			else if(dir == S)
				--y;
			
			else
				--x;
		}
		
		else
		{
			if(move == 'R')
				dir = (dir + 1) % 4;
			else
				dir = (4 + dir - 1) % 4; 
		}
	}
	
	return (x==0 && y==0);
	
}

void main()
{
	char str[] = "GLGLGLG";
	
	printf(checkCircular(str) ? "Circular" : "Not Circular");
}  				   
