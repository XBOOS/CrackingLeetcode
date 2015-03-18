/*DP summary
summary of dynamic programming
1.weighed compatible intervals


2.longest increasing subsequences

3.knapsack

4.matrix chain multiplication

5. shoretest path  Dijkstra's algorithm doeasnt work in the presence of -ve edges'
dijsktra's 'algorthim is using Greedy algorithm, it cannot see the things happen later, just using present information to  make decision



Dynamic Programming | Set 1 (Overlapping Subproblems Property)
Dynamic Programming is an algorithmic paradigm that solves a given complex problem by breaking it into subproblems and stores the results of subproblems to avoid computing the same results again. Following are the two main properties of a problem that suggest that the given problem can be solved using Dynamic programming.

1) Overlapping Subproblems
2) Optimal Substructure
----------------------------------------
1) Overlapping Subproblems:


There are following two different ways to store the values so that these values can be reused.

a) Memoization (Top Down): 
b) Tabulation (Bottom Up):
*/
int lookup[MAX];
 
/* Function to initialize NIL values in lookup table */
void _initialize()
{
  int i;
  for (i = 0; i < MAX; i++)
    lookup[i] = NIL;
}
 
/* function for nth Fibonacci number */
int fib(int n)
{
   if(lookup[n] == NIL)
   {
    if ( n <= 1 )
      lookup[n] = n;
    else
      lookup[n] = fib(n-1) + fib(n-2);
   }
 
   return lookup[n];
}
 
int main ()
{
  int n = 40;
  _initialize();
  printf("Fibonacci number is %d ", fib(n));
  getchar();
  return 0;
}

Both tabulated and Memoized store the solutions of subproblems. In Memoized version, table is filled on demand while in tabulated version, starting from the first entry, all entries are filled one by one. Unlike the tabulated version, all entries of the lookup table are not necessarily filled in memoized version. For example, memoized solution of LCS problem doesn’t necessarily fill all entries.


2) Optimal Substructure: A given problems has Optimal Substructure Property if optimal solution of the given problem can be obtained by using optimal solutions of its subproblems.
For example the shortest path problem has following optimal substructure property: If a node x lies in the shortest path from a source node u to destination node v then the shortest path from u to v is combination of shortest path from u to x and shortest path from x to v. The standard All Pair Shortest Path algorithms like Floyd–Warshall and Bellman–Ford are typical examples of Dynamic Programming.
On the other hand the Longest path problem doesn’t have the Optimal Substructure property. Here by Longest Path we mean longest simple path (path without cycle) between two nodes. Consider the following unweighted graph given in the CLRS book. There are two longest paths from q to t: q -> r ->t and q ->s->t. Unlike shortest paths, these longest paths do not have the optimal substructure property. For example, the longest path q->r->t is not a combination of longest path from q to r and longest path from r to t, because the longest path from q to r is q->s->t->r.

//LIC problem
int lis(int[] arr,int n, int max_ref){
	if(n==1) return 1;

	int res,max_ending_here = 1;

	for(int i=1;i<n;i++){
	     res = lis(arr,i,max_ref);
	     if(arr[i-1]<arr[n-1]&&res+1){
	     	max_ending_here = res+1;
	     }
	}
	if(max_ref<max_ending_here) max_ref = max_ending_here;

	return max_ending_here;
}

//Tabulation
* lis() returns the length of the longest increasing subsequence in 
    arr[] of size n */
int lis( int arr[], int n )
{
   int *lis, i, j, max = 0;
   lis = (int*) malloc ( sizeof( int ) * n );
 
   /* Initialize LIS values for all indexes */
   for ( i = 0; i < n; i++ )
      lis[i] = 1;
    
   /* Compute optimized LIS values in bottom up manner */
   for ( i = 1; i < n; i++ )
      for ( j = 0; j < i; j++ )
         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
            lis[i] = lis[j] + 1;
    
   /* Pick maximum of all LIS values */
   for ( i = 0; i < n; i++ )
      if ( max < lis[i] )
         max = lis[i];
 
   /* Free memory to avoid memory leak */
   free( lis );
 
   return max;
}



//LIS.cpp
#include <iostream>
using namespace std;



// A dynamic-programming solution to find the longest increasing subsequence
int lis_DP(int arr[], int n)
{
    if(n==1)
        return 1;

    int len = 1;

    // allocate memory to store longest subsequence ending at each index
    int *LIS_arr = new int[n];

    // allocate memory to store the index of previous index in the subsequence ending at each index
    int *p = new int[n];
    int lis_endIndex = 0; // index of the last element of the l.i.s.

    for(int i=0; i<n; ++i){
        LIS_arr[i] = 1;
        p[i] = -1;
    }

    for(int i=0; i<n; ++i)
        for(int j=0; j<i; ++j){
            if( (arr[j] < arr[i]) && (LIS_arr[i] < LIS_arr[j] + 1) ){
                LIS_arr[i] = LIS_arr[j] + 1;
                p[i] = j;
            }
        }
    }

    for(int i=0; i<n; ++i){
        if(LIS_arr[i] > len){
            len = LIS_arr[i];
            lis_endIndex = i;
        }
    }

    // print the longest increasing subsequence in reverse order
    while(lis_endIndex != -1){
        cout << arr[lis_endIndex] << " ";
        lis_endIndex = p[lis_endIndex];
    }
    cout << endl;

    // free the dynamically allocated memory for temporary arrays
    delete []LIS_arr;
    delete []p;

    // return the length of longest increasing subsequence
    return (len);
}