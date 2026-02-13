You have: Initial experience E
          n monsters
          Each monster has:
          power[i] → minimum experience needed
          bonus[i] → experience gained after defeating
          You can fight monsters in any order.
Goal: Defeat maximum number of monsters

  import java.util.*;
class Main{
  static class Monster{
    int power;
    int bonus;
    Monster(int power,int bonus){
      this.power=power;
      this.bonus=bonus;
    }
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt(); //no of monsters
    int experience=sc.nextInt(); //Initial Experience

    Monster[] monsters=new Monster[n];
    for(int i=0;i<n;i++){
      int power=sc.nextInt();
      int bonus=sc.nextInt();
      monsters[i]=new Monster(power,bonus);
    }

    //Sort by increasing power
    Arrays.sort(monsters,(a,b)->a.power-b.power);

    int count=0;
    for(int i=0;i<n;i++){
      if(experience>=monsters[i].power){
        experience+=monsters[i].bonus;
        count++;
      }else{
        break;
      }
    }
    System.out.println(count);
  }
}

Time Complexity
Sorting → O(n log n)
Traversal → O(n)
Overall → O(n log n)


    
    
    
