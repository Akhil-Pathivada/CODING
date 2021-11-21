/*
Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. 
It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. 
How to maximize total profit if only one job can be scheduled at a time.

Time Complexity : O(n ^ 2)
Space Complexity : O(1)
*/

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>

struct Job
{
	char id;
	int profit;
	int deadline;
};

int compareTo(const void *job1 ,const void *job2)
{
	return (*(struct Job*)job1).profit < (*(struct Job*)job2).profit; 
}

void getMaxProfitSequence( struct Job jobs[], int size)
{
	// sorting the jobs based on max.profits
	qsort( jobs,size,sizeof(*jobs),compareTo); 
	
	int maxDeadline = INT_MIN;
	
	// getting max. deadline
	for(int i=0; i<size; ++i) 
		maxDeadline = (jobs[i].deadline > maxDeadline) ? jobs[i].deadline : maxDeadline;
	
	char slot[maxDeadline];
	
	for(int i=0; i<maxDeadline ;++i)
		slot[i]='0';
		
	for(int i=0; i<size; ++i)
	{
		int deadline = jobs[i].deadline-1;
		
		if(slot[deadline]=='0')
			slot[deadline] = jobs[i].id;
			
		else
		{
			for(int j=deadline-1; j>=0; --j)
			{	
				if(slot[j]=='0')
				{
					slot[j] = jobs[i].id;
					break;
				}
			}
		}
	}
	
	printf(" Max. profit Job Sequence : ");
	
	for(int i=0; i<maxDeadline ;++i)
		printf(" %c,",slot[i]);
}

void main()
{
	struct Job jobs[] = { {'a', 200, 5},
			      {'b', 180, 3}, 
			      {'c', 190, 3}, 
                 	      {'d', 300, 2},
                 	      {'e', 120, 4},
                 	      {'f', 100, 2}  }; 
       
       int size = sizeof(jobs)/sizeof(*jobs); 
               	 
       getMaxProfitSequence(jobs,size);   
}
