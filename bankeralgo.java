
package bankersalgorithm;
class banker
{
  int n=5;
  int m=3;
  int need[][] = new int[n][m];
  int safeSequence[] = new int[n];
  int [][]max;
  int [][]allocation;
  int []available;
  void intializeValue()
  {
      allocation = new int[][] 
      {
          {0,1,0},
          {2,0,0},
          {3,0,2},
          {2,1,1},
          {0,0,2}  
      };//must give semicolon
      max = new int[][]
      {
          {7,5,3},
          {3,2,2},
          {9,0,2},
          {2,2,2},
          {4,5,3}
      };//semicolon
      available = new int[]
      {
          3,3,2
      };
  }
  void Safe()
  {
      int count =0;
      boolean visited[] = new boolean[n];
      for(int i=0;i<n;i++)
      {
          visited[i] = false;
      }
      int work[]  = new int[m];
      for(int i=0;i<m;i++)
      {
          work[i] = available[i];
      }
      while(count<n)
      {
          boolean flag = false;
          for(int i=0;i<n;i++)
          {
              if(visited[i]==false)
              {
                  int j;
                  for(j=0;j<m;j++)
                  {
                      if(need[i][j]>work[j])
                      {
                          break;
                      }
                  }
                  if(j==m)
                  {
                      safeSequence[count++] = i;
                      visited[i] = true;
                      flag = true;
                      for(j=0;j<m;j++)
                      {
                          work[j] = work[j] + allocation[i][j];
                      }
                  }
              }
          }
          if(flag==false)
          {
              break;
          }
      }
      if(count<n)
      {
          System.out.println("this system is unsafe");
      }
      else
      {
          System.out.println("the safe sequence is");
          for(int i=0;i<n;i++)
          {
              System.out.println("p"+safeSequence[i]);
          }
      }
  }
  void calculateNeed()
  {
      for(int i=0;i<n;i++)
      {
          for(int j=0;j<m;j++)
          {
              need[i][j] = max[i][j]-allocation[i][j];
          }
      }
  }
  
}

public class BankersAlgorithm {

   
    public static void main(String[] args) {
      
        int i,j,k;
        banker b = new banker();
        b.intializeValue();
        b.calculateNeed();
        b.Safe();
    }
    
}
