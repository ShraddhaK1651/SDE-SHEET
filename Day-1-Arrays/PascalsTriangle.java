Q]Given an integer numRows, return the first numRows of Pascal's triangle.

  class Solution{
        public List<List<Integer>>generate(int numrows){
          List<List<Integer>>Triangle=new ArrayList<>();
          for(int i=1;i<=numrows;i++){
            List<Integer>temp=new ArrayList<>();
              for(int j=1;j<=i;j++){
                list.add(generateRow(i-1,j-1));
              }
            Triangle.add(list)
          }
          return Triangle;
        }
  public int generateRow(int n,int r){
    int res=1;
    for(int i=0;i<r;i++){
      res=res*(n-i);
      res=res/(i+1);
    }
    return res;
  }
}
          
