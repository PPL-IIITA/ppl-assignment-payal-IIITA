/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class relationship extends q5 {
    /**
     * Function to make pairs according to girl
     * @param gs  girl size
     * @param n  boy size
     * @param gindex girl index
     * @param st   starting index of boy
     * @return boy index
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
     * Function to make pairs according to boy
     * @param gs  girl size
     * @param bs  boy size
     * @param bindex girl index
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
     * FUNCTION TO FIND K HAPPIEST COUPLES
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
     * FUNCTION TO BREAKUP K COUPLES
     * @param k value of k
     * @param gs girl size
     * @param bs boy size 
     * @param happy1 array containing happiness of couples
     * @param compat1 array containing compatibility of couples
     * @throws IOException when log file not found
     */
    public void kbreakups(int k,int gs,int bs,int compat1[],int happy1[]){
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
            int bindex=pair_making_by_girl(gs,bs,happy1[i],g[happy1[i]].bfno+1);
            committed[happy1[i]]=bindex;
            if(bindex!=-1)
            b[bindex].gift_basket(g, gs, l, 10, e, 15);
            
          }
           
        }
    }
}