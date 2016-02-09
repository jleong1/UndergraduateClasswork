/**
 * Write a description of class ArrayDelete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayDelete
{
    
   int capacity=10000;
   int [] arrayValues;
   int size=35;
   
   public ArrayDelete() {
       arrayValues= new int[capacity];
       for (int i=0;i<capacity;i++)
       arrayValues[i]=0;
    }
    
    public int findPosition(int value) {
        int j=0;
        while (j<size) 
        if (arrayValues[j]!=value)
        j++;
        else break;
        if (j==size) 
            return -1;
        else return j;
        }
    
    public void Delete( int position) {
        for (int j=position;j<=size-2;j++)
        arrayValues[j]=arrayValues[j+1];
        size--;
        if (size==0) System.out.println("array is empty ... no more Deletes ");
    }
    
    public void arrayInit(){
        
        /* initialize the array with some arbitrary values.  Here the array is initialized with 
         10,20,30,40,50,... etc */
        if (size >0)
            for (int i=0;i<size;i++)
            arrayValues[i]=10*i+10;
        else System.out.println("array is empty ... can't do Delete ");
    }
    
    public static void main (String[] args){
        long startTime,finishTime, elapsedTime;
        startTime = System.nanoTime();
        
        ArrayDelete ai=new ArrayDelete();
        ai.arrayInit();
        int position;
        int value= 70;
        position=ai.findPosition(value);
        
        if (position!=-1)
        ai.Delete(position);
        else System.out.println("Value not found in the array ... can't be deleted");
       finishTime=System.nanoTime();
       elapsedTime = finishTime-startTime;
    }
}

