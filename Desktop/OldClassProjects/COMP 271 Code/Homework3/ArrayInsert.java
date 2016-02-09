
/**
 * Write a description of class ArrayInsert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayInsert
{
    
   int capacity=10000;
   int [] arrayValues;
   int size=35;
   
   public ArrayInsert() {
       arrayValues= new int[capacity];
       for (int i=0;i<capacity;i++)
       arrayValues[i]=0;
    }
    
    public int findPosition(int value) {
        int j=0;
        while (j<size && arrayValues[j]<=value)
        j++;
        return j;
        }
    
    public void insert(int value, int position) {
        for (int j=size-1;j>=position;j--)
        arrayValues[j+1]=arrayValues[j];
        arrayValues[position]=value;
        size++;
        if (size==capacity) System.out.println("array limit reached ... no more inserts ");
    }
    
    public void arrayInit(){
        
        /* initialize the array with some arbitrary values.  Here the array is initialized with 
         10,20,30,40,50,... etc */
        if (size < capacity)
            for (int i=0;i<size;i++)
            arrayValues[i]=10*i+10;
        else System.out.println("array resizing needed ... can't do insert ");
    }
    
    public static void main (String[] args){
        
        ArrayInsert ai=new ArrayInsert();
        ai.arrayInit();
        int newVal= 189;
        ai.insert(newVal,ai.findPosition(newVal));
        newVal=7000;
        ai.insert(newVal,ai.findPosition(newVal));
        newVal=5;
        ai.insert(newVal,ai.findPosition(newVal));
        
    }
        
       
}
