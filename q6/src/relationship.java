
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;




public class relationship extends q6 {
    /**
     * 
     * @param gs  girl size
     * @param n  boy size
     * @param gindex  girl index
     * @param st starting index of boy
     * @return boyfriend index
     */
    public int pair_making_by_girl(int gs,int n,int gindex,int st){ //boy b is according to girls choice
        //int j;
       // for(j=0;j<gs;j++){
        if(g[gindex].status==1)
            return -1;
        float max=0;
        int index=-1;
        switch(g[gindex].choice){
            case 1:for(int i=st;i<n;i++)
                    if(b[i].budget>=g[gindex].budget && b[i].attractiveness>max && b[i].status==0 && g[gindex].attractiveness>=b[i].attraction_require){
                        max=b[i].attractiveness;
                        index=i;
                      }
                    break;
            case 2:for(int i=st;i<n;i++)
                    if(b[i].budget>=g[gindex].budget && b[i].budget>max && b[i].status==0 && g[gindex].attractiveness>=b[i].attraction_require){
                        max=b[i].budget;
                        index=i;
                      }
                    break;
            case 3:for(int i=st;i<n;i++)
                    if(b[i].budget>=g[gindex].budget && b[i].intelligence>max && b[i].status==0 && g[gindex].attractiveness>=b[i].attraction_require){
                        max=b[i].intelligence;
                        index=i;
                      }
                    break;
        }
        if(index!=-1){
            g[gindex].status=1;
            b[index].status=1;
            g[gindex].bfname=b[index].name;
            g[gindex].bfno=index;
        
        
             // for addition in vector
        }
    return index;
    

    }
    /**
     * 
     * @param gs  girl size
     * @param bs  boy size
     * @param bindex  boy index
     * @return  girl index
     */
    public int pair_making_by_boy(int gs,int bs,int bindex){
        if(b[bindex].status==1)
            return -1;
        int gindex=-1,max=-99999;
        for(int i=0;i<gs;i++){
            if(g[i].attractiveness>max && g[i].status==0 ){
                gindex=i;
                max=g[i].attractiveness;
            }
        }
        if(gindex!=-1){
            g[gindex].bfname=b[bindex].name;
            g[gindex].status=1;
            b[bindex].status=1;
            g[gindex].bfno=bindex;
        }
        return gindex;
    }
    /**
     * Function to find k happiest couples
     * @param k value of k
     * @param gs girl size
     * @param happy1 array containing happiness of couples
     * @param compat1 array containing compatibility of couples
     */
    public void khappiest(int k,int happy1[],int compat1[],int gs){
        int m=0;
        for(int i=0;i<gs;i++){
            if(happy[i]!=-99999)
                m++;
        // System.out.println(happy[i]);   
        }
        //System.out.println("\n");
        for(int i=0;i<k;i++)
            System.out.println("<"+g[happy1[i]].name+","+b[g[happy1[i]].bfno].name+">");
        
    }
    /**
     * Function to breakup couples with happiness less than t
     * @param t value of t
     * @param gs girl size
     * @param bs boy size
     * @throws IOException 
     */
    public void kbreakups(int t,int gs,int bs) throws IOException{
        Date d=new Date();
        File file = new File("Log.txt");
        FileWriter writer = new FileWriter(file,true); 
        int m=0;
        for(int i=0;i<gs;i++){
            if(g[i].bfno!=-1)
                m++;
        }
        
        m=0;
        for(int i=0;i<gs;i++){
           if(g[i].status==1 && happy[i]<t){
            g[i].status=0;
            b[g[i].bfno].status=0;
            committed[i]=-1;
            b[g[i].bfno].budget= b[g[i].bfno].bbalance;
            g[i].gift_price=0;
            g[i].gift_value=0;
            writer.write(d.toString() +" "+"breakup     "+g[i].name+" "+b[g[i].bfno].name);
            writer.write(System.getProperty( "line.separator" ));
           // m++;
            int bindex=pair_making_by_girl(gs,bs,i,g[i].bfno+1);
            committed[i]=bindex;
            
            if(bindex!=-1){
                b[bindex].gift_basket(g, gs, l, 10, e, 15);
                writer.write(d.toString() +" "+"committment "+g[i].name+" "+b[g[i].bfno].name+" "+g[i].gift_price);
                writer.write(System.getProperty( "line.separator" ));
                
            }
            
          }
           
           
        }
        writer.flush();
       writer.close();
    }
}