
import static java.lang.Math.abs;
import java.util.Random;

/**
 * 
 * GENERIC CLaSS
 * @param <T>  type of the object sent
 */
public class randomk<T> {
    /**
     * 
     * @param t object of generic data type
     * @param ar array to sort
     * @param size  size of array
     */
    public void sort(T[] t,int ar[],int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(ar[j]<ar[j+1]){
                    int temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                    
                    T temp1=t[j];
                    t[j]=t[j+1];
                    t[j+1]=temp1;
                }
            }
        }
        
    }
    /**
     * 
     * @param m 
     * @return random no from 0 to m
     */
    public int rk(int m){
        Random r=new Random();
        int k=abs(r.nextInt())%m;
       return k;
    }
}
