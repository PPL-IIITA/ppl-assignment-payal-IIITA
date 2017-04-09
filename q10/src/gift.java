
 class gift {
    int price,value;
    /**
     * 
     * @param b boy object array
     * @param g girl object array
     * @param gs girl size
     * @param l luxury gift object array
     * @param ls luxury gift size
     * @param e essential gift object array
     * @param es  essential gift size
     */
    public void gift_basket(boy b[],girl g[],int gs,luxury_gift l[],int ls,essential_gift e[],int es){
        /* gifts array sorted in asc order*/
               // System.out.println("4");

        for(int i=0;i<gs;i++){
            if(g[i].status==1){
                int balance=b[g[i].bfno].budget;
                
                    for(int j=0;j<es;j++){
                        if(balance>0){
                        balance-=e[i].price;
                        g[i].gift_price+=e[i].price;
                        g[i].gift_value+=e[i].value;
                    }
                        else break;
                   
                }
            }
        }
        
            
        
    }
}
