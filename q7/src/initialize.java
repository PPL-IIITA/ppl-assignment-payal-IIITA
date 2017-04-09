
/*INITIALIZES THE OBJECT ARRAYS*/
import java.io.*;
import static java.lang.Math.abs;
import java.util.*;



public class initialize extends q7 {
    /* 1st input:girl.txt 
          2nd input:boy.txt
          3rd input:essential.txt
          4th input:luxury.txt
          5th input:utility.txt
       */
    int gs,bs,es,us,ls;
    /**
     * constructor to read from files and initialize objects
     * @param args All command Line arguments
     * @param happy1 array containing happiness of couples
     * @param compat1 array containing compatibility of couples
     * @throws IOException 
     */
    public initialize(String [] args,int[] happy1,int[] compat1) throws IOException{
     
        
       Scanner gl= new Scanner(new FileReader("girl.txt"));
       Scanner bo =new Scanner(new FileReader("boy.txt"));
       Scanner eg =new Scanner(new FileReader("essential.txt"));
       Scanner lg =new Scanner(new FileReader("luxury.txt"));
       Scanner ug =new Scanner(new FileReader("utility.txt"));
       gs=gl.nextInt();bs=bo.nextInt();es=eg.nextInt();us=ug.nextInt();ls=lg.nextInt();
       for(int i=0;i<gs;i++){
               g[i]=new girl();
               g[i].name=gl.next();
               g[i].attractiveness=gl.nextInt();
               g[i].budget=gl.nextInt();
               g[i].intelligence=gl.nextInt();
               g[i].choice=gl.nextInt();
               g[i].property=gl.nextInt();
              
        }
       for(int i=0;i<bs;i++){
               b[i]=new boy();
               b[i].name=bo.next();
               b[i].attractiveness=bo.nextInt();
               b[i].intelligence=bo.nextInt();
               b[i].budget=bo.nextInt();
               
               b[i].attraction_require=bo.nextInt();
               b[i].property=bo.nextInt();
        }
       for(int i=0;i<es;i++){
               e[i]=new essential_gift();
               e[i].price=eg.nextInt();
               e[i].value=eg.nextInt();
        }
       for(int i=0;i<ls;i++){
               l[i]=new luxury_gift();
               l[i].price=lg.nextInt();
               l[i].value=lg.nextInt();
               l[i].difficulty=lg.nextInt();
               l[i].luxury_rating=lg.nextInt();
        }
       for(int i=0;i<us;i++){
               u[i]=new utility_gift();
               u[i].price=ug.nextInt();
               u[i].value=ug.nextInt();
               u[i].utility_value=ug.nextInt();
               u[i].utility_class=ug.nextInt();
        }
       
    
        for(int i=0;i<gs;i++)
            committed[i]=-1;
        
        
        
        //
        
        
    }
    /**
     * Function to make couples
     */
    public void pair_making(){
       
       // int n;
        relationship r=new relationship();
        for(int j=0;j<gs;j++){
          //  n=t;
            // pair making of jth girl
            int bindex=r.pair_making_by_girl(gs,bs,j,0);    
            committed[j]=bindex;
         
            if(bindex!=-1){
                
               // while(n-- >0 )
                b[bindex].gift_basket(g, gs, l, ls, e, es);
                
            }
           
            
            
        
        
        }
        
        for(int j=0;j<gs;j++){
            calculate_happiness(j);
          //  System.out.println(happy[j]+"  "+compat[j]);
        }
        
        
    }
    /**
     * 
     * @param j  index of couple  
     */
    public void calculate_happiness(int j){
        if(committed[j]!=-1){
                happy[j]=g[j].happiness+b[g[j].bfno].happiness;
                compat[j]=b[g[j].bfno].budget-g[j].budget+abs(b[g[j].bfno].attractiveness-g[j].attractiveness)+abs(b[g[j].bfno].intelligence-g[j].intelligence);
               // System.out.println("<"+happy[j]+","+compat[j]+">");
            }
            
            else{
                happy[j]=-99999;
                compat[j]=-99999;
            }
    }
    /**
     * 
     * @param gs  girl size
     * @param happy1 array containing happiness of couples
     * @param compat1 array containing compatibility of couples 
     */
    public void calculate_order_of_happiness(int gs,int happy1[],int compat1[]){
        int mi=-1,mj=-1;
        double max=-9999;
        for(int j=0;j<gs;j++){
            //happy1[j]=happy[j];
            if(happy[j]>max){
                mi=j;
                max=happy[j];
            }
            if(compat[j]>max){
                mj=j;
                max=compat[j];
            }
        }
        happy1[0]=mi;
        compat1[0]=mj;
        //System.out.print(happy1[0]);
        for(int i=1;i<=gs-1;i++){
            max=-9999;
            for(int j=0;j<gs;j++)
                if(happy[j]>=max && happy[j]<happy[happy1[i-1]]){
                    mi=j;
                    max=happy[j];
                }
            happy1[i]=mi;
            //System.out.print(happy1[i]);
                    
        }
       /* for(int i=1;i<=gs-1;i++){
            max=0;
            for(int j=0;j<gs;j++)
                if(compat[j]>=max && compat[j]<compat[compat1[i-1]]){
                    mj=j;
                    max=compat[j];
                }
            compat1[i]=mj;
           // System.out.print(compat1[i]+" ");
                    
        }*/
    }
    /**
     * 
     * @param c array containing details of relationships
     * @throws IOException 
     */
    public void createlog(int c[]) throws IOException{
        Date d=new Date();
        File file = new File("Log.txt");
        FileWriter writer = new FileWriter(file,true); 
        for(int i=0;i<gs;i++){
            
            if(c[i]!=-1){
                writer.write(d.toString() +" "+"committment "+g[i].name+" "+b[c[i]].name+" "+g[i].gift_price);
                writer.write(System.getProperty( "line.separator" ));
            
               // writer.write(+" ");
            }
        }
        writer.flush();
       writer.close();
    }
    /**
     * Function to create boy hash
     * @param gs girl size
     * @param bs boy size
     * @param gf  hash table
     */
    public void createboyhash(int gs,int bs,int gf[])
    {
        for(int i=0;i<bs;i++)
            gf[i]=-1;
        for(int i=0;i<gs;i++){
            if(g[i].status==1)
                gf[g[i].bfno]=i;
        }
    }
    /**
     * Function to create boy array
     * @param gs girl size
     * @param barray boy array
     * @return size of barray
     */
    public int createboyarray(int gs,int[][] barray)
    {
        int size=0;
        for(int i=0;i<gs;i++){
            if(committed[i]!=-1){
                size++;
                barray[i][0]=g[i].bfno;
                barray[i][1]=i;
            }
        }
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                if(barray[i][0]<barray[j][0]){
                    int temp1=barray[i][0];
                    barray[i][0]=barray[j][0];
                    barray[j][0]=temp1;
                    
                    int temp2=barray[i][1];
                    barray[i][1]=barray[j][1];
                    barray[j][1]=temp2;
                }
            
       // for(int i=0;i<size;i++)
         //   System.out.println(barray[i][0]+" "+barray[i][1]);
        return size;    
    }
    /**
     * FUNCTION TO FIND IN HASH TABLE
     * @param gf girlfriend array
     * @param bs boy size
     * @param ele element to find
     * @return 
     */
    int findinhash(int gf[],int bs,int ele)
    {
        if(ele<bs)
        return gf[ele];
        else return -1;
    }
    /**
     * BINARY SEARCH
     * @param l lower index
     * @param u upper index
     * @param array barray
     * @param ele element to search
     * @return  the gf index
     */
    int bsearch(int l,int u,int[][] array,int ele){
        //int index=-1;
        //int l=0,u=size-1;
        int x=-1;
        if(l<u){
            int mid=(l+u)/2;
           // System.out.println(array[mid][0]);
            if(array[mid][0]==ele)
                return array[mid][1];
            else if(array[mid][0]<ele){
                x=bsearch(mid+1,u,array,ele);
            }
            else{
               x=bsearch(l,mid,array,ele);
            }
                
        }
        return x;
    }
    
}
