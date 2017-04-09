
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class relationship extends q10 {
    /**
     * 
     * @param gs  girl size
     * @param n  boy size
     * @param gindex  girl index
     * @param st starting index of boy
     * @return boyfriend index
     */
    public int pair_making_by_girl(int gs,int n,int gindex,int st){ //boy b is according to girls choice
        int i;
       // for(j=0;j<gs;j++){
        
        for(i=0;i<st;i++){
            if(b[i].status==0){
                //System.out.println(i);
                g[gindex].status=1;
                b[i].status=1;
                g[gindex].bfname=b[i].name;
                g[gindex].bfno=i;
                committed[gindex]=i;
                
                break;
            }
        }
        
    return i;
    

    }
    /**
     * 
     * @param gs  girl size
     * @param bs  boy size
     * @param bindex  boy index
     * @param st starting index 
     * @return  girl index
     */
    public int pair_making_by_boy(int gs,int bs,int bindex,int st){
       int i;
       // for(j=0;j<gs;j++){
        if(b[bindex].status==1)
            return -1;
        for(i=0;i<st;i++){
            if(g[i].status==0){
                //System.out.println(i);
                g[i].status=1;
                b[bindex].status=1;
                g[i].bfname=b[bindex].name;
                g[i].bfno=bindex;
                committed[i]=bindex;
                
                break;
            }
        }
        
    return i;
    }
    
    
}