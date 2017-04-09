/**
 * 
 * GENERIC CLaSS
 * @param <T>  type of the object sent
 */
public class generic_class<T> {
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
    
}
