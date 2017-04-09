
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class relationship extends q8 {
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
    
    
}