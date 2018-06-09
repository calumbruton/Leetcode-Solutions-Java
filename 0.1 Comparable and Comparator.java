import java.util.*;

// Java program for implementation of QuickSort
class Pig implements Comparable<Pig>
{
    String name;
    int weight;
    
    
    public Pig(String name, int weight){
        this.weight = weight;
        this.name = name;
    }
    
    public String toString(){
        return this.name + " is " + this.weight + " pounds. ";
    }
    
    public boolean equals(Object obj){
        if (obj instanceof Pig) {
            Pig other = (Pig) obj;
            return (this.name.equals(other.name)) && (this.weight == other.weight);
        } else {
            return false;
        }
    }
    
    public int hashCode(){
        return name.hashCode()*31;
    }
    
    //To sort by implementing Comparable
    public int compareTo(Pig x){
        return x.weight - this.weight;
    }
    
    /*Comparator for sorting the list by Pig Name*/
    public static Comparator<Pig> pigNameComparator = new Comparator<Pig>() {

	public int compare(Pig p1, Pig p2) {
	   String PigName1 = p1.name.toUpperCase();
	   String PigName2 = p2.name.toUpperCase();

	   //ascending order
	   return PigName1.compareTo(PigName2);
    }};

}


public class Test{
    
    // Driver program
    public static void main(String args[])
    {
        Pig joe = new Pig("joe", 25);
        Pig joeCopy = new Pig("joe", 25);
        Pig bob = new Pig("Bobby", 8);
        Pig dig = new Pig("Diggy", 12);
        Pig will = new Pig("Willy", 20);

        Set<Pig> hashy = new HashSet<Pig>();
        hashy.add(joe); 
        hashy.add(joeCopy);
        //hashy.forEach(piggy -> System.out.println(piggy));
        //System.out.println(hashy.size());
        
        List<Pig> listy = new ArrayList<Pig>();
        listy.add(joe);
        listy.add(bob);
        listy.add(dig);
        listy.add(will);
        
        //sort using compareTo() of pig class implementing Comparable
        Collections.sort(listy);
        listy.forEach(piggy -> System.out.println(piggy));
        
        //sort using a comparator
        Collections.sort(listy, Pig.pigNameComparator);
        
        listy.forEach(piggy -> System.out.println(piggy));
    }
}