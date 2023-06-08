import java.util.*;

class Main {
  public static void main(String[] args) {
    
    //Scanner
    Scanner sc= new Scanner(System.in);
    System.out.println("What size do you want your grid to be");
    int gridSize=sc.nextInt();

    //lists for the grid and mineMaps
    
    int[][] grid = new int[gridSize][gridSize];
    boolean[][] mineMap = new boolean[gridSize][gridSize];
    String[][] dash =new String[gridSize][gridSize];
    
    //loop for makijng dashes
    for(int i=0;i<mineMap.length;i++)
    {
      for(int j=0;j<mineMap.length;j++){
        dash[i][j]="-";
        
      }
    }
   
    
    //place mines
    minePlacer(mineMap,gridSize);
    contactGrid(mineMap, grid);
    //printing contact grid------TEMP
    for(int i=0;i<mineMap.length;i++){
      for(int j=0;j<mineMap.length;j++){
        System.out.print(grid[i][j]);
      }
      System.out.println();
    } 
  }
  
  // Placing mine function
  public static void minePlacer(boolean[][] mineMap, int gridSize)
  {
    for(int i=0;i<gridSize;i++)
    {
      int rowIndex=(int)(Math.random() * gridSize);
      int columnIndex=(int)(Math.random() * gridSize);
      if(mineMap[rowIndex][columnIndex]) {
        i--;
      }
      mineMap[rowIndex][columnIndex] = true;
      
      
    }
    
    
  }
  //SHowing the bomb distance
  public static void contactGrid(boolean[][] arr, int[][] grid){
    //loop thru bomb grid
      for(int i=0;i<arr.length;i++)
      {
        for(int j=0;j<arr.length;j++)
        {
          int counter = 0;
          for(int k=-1;k<=1;k++)
          {
            //loop
            for(int l=-1;l<=1;l++)
            {
              //chaeck if its looping into array
              if(i+k>=0 && j+l>=0 && i+k<arr.length && l+j<arr.length){
            // looping to find distance
              if(arr[i+k][j+l])
              {
                //add to counter too see hdistance
                counter+=1;
              }
              }
              
            }
          }
          // set it
          grid[i][j]=counter;
        }
        
      }
      
    }
public static boolean isGameOver(String dash[][])
  {
    int counterDash=0;
    for(int i=0;i<dash.length;i++)
    {
      for(int j=0;j<dash.length;j++)
      {
      if (dash[i][j].equals("-"))
      {
        counterDash+=1;
      }
      }
    }

    if (counterDash == gridSize)
    {
      return true;
    }
    else{return false;}
    
  }

  public static void Run(int grid[][],boolean mineMap[][],String dash[][])
  {
    while (!isGameOver(dash)){
      Scanner sc= new Scanner(System.in);
      System.out.println("what do you want to press, row, column");
    }
  }
}
