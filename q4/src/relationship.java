
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * 
 * @author win 8.1
 */
public class relationship extends q4 {
    /**
     * Function to make pairs according to girl
     * @param gs  girl size
     * @param n  boy size
     * @param j girl index
     * @param st   starting index of boy
     * @return boy index
     */
    public int pair_making_by_girl(int gs,int n,int j,int st){ //boy b is according to girls choice
        //int j;
       // for(j=0;j<gs;j++){
        float max=0;
        int index=-1;
        switch(g[j].choice){
            case 1:for(int i=st;i<n;i++)
                    if(b[i].budget>=g[j].budget && b[i].attractiveness>max && b[i].status==0 && g[j].attractiveness>=b[i].attraction_require){
                        max=b[i].attractiveness;
                        index=i;
                      }
                    break;
            case 2:for(int i=st;i<n;i++)
                    if(b[i].budget>=g[j].budget && b[i].budget>max && b[i].status==0 && g[j].attractiveness>=b[i].attraction_require){
                        max=b[i].budget;
                        index=i;
                      }
                    break;
            case 3:for(int i=st;i<n;i++)
                    if(b[i].budget>=g[j].budget && b[i].intelligence>max && b[i].status==0 && g[j].attractiveness>=b[i].attraction_require){
                        max=b[i].intelligence;
                        index=i;
                      }
                    break;
        }
        if(index!=-1){
            g[j].status=1;
            b[index].status=1;
            g[j].bfname=b[index].name;
            g[j].bfno=index;
        
        
             // for addition in vector
        }
    return index;
    

    }
    /**
     * FUNCTION TO BREAKUP K COUPLES
     * @param k value of k
     * @param gs girl size
     * @param bs boy size 
     * @param happy1 array containing happiness of couples
     * @param compat1 array containing compatibility of couples
     * @throws IOException when log file not found
     */
    public void kbreakups(int k,int gs,int bs,int compat1[],int happy1[]) throws IOException{
        
        Date d=new Date();
        File file = new File("Log.txt");
        FileWriter writer = new FileWriter(file,true); 
        int m=0;
        for(int i=0;i<gs;i++){
            if(g[i].bfno!=-1)
                m++;
        }
        
        m=0;
        for(int i=gs-1;m<k && i>=0;i--){
           if(g[happy1[i]].status==1){
            g[happy1[i]].status=0;
            b[g[happy1[i]].bfno].status=0;
            committed[happy1[i]]=-1;
            m++;
            
            writer.write(d.toString() +" "+"breakup    "+g[happy1[i]].name+" "+b[g[happy1[i]].bfno].name+" "+g[happy1[i]].gift_price);
                writer.write(System.getProperty( "line.separator" ));
            int bindex=pair_making_by_girl(gs,bs,happy1[i],g[happy1[i]].bfno+1);
            committed[happy1[i]]=bindex;
            if(bindex!=-1){
            b[bindex].gift_basket(g, gs, l, 10, e, 15);
            writer.write(d.toString() +" "+"commitment "+g[happy1[i]].name+" "+b[g[happy1[i]].bfno].name+" "+g[happy1[i]].gift_price);
                writer.write(System.getProperty( "line.separator" ));
            }
          }
           
        }
        writer.flush();
       writer.close();
    }
}