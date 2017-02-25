/**
 * 
 * <h> class containing details of boy </h>
 * <p>contains attributes of boys<p>
 * <p>contains a function to prepare a gift basket</p>
 */



public class boy {
    String name;
    int attractiveness,budget,intelligence,attraction_require;
    int property; // 1.miser 2.generous 3.geek
    int status;//0 single 1.committed
    double happiness;
    /**
     * constructor initializing all boys to status single and happiness 0
     * 
     */
    public boy(){
        status=0;
        happiness=0;
    }
    /**
     * Function to prepare gift basket
     * @param g the object array of class girl
     * @param gs no of girls
     * @param l the object array of class luxury_gift
     * @param ls no of luxury gifts
     * @param e the object array of class essential_gift
     * @param es no of essential gifts
     */
    public void gift_basket(girl g[],int gs,luxury_gift l[],int ls,essential_gift e[],int es){
        /* gifts array sorted in asc order*/
        int index=-1,i,j;
        int balance,value=0;
        for( i=0;i<gs;i++)
            if(g[i].status==1 && g[i].bfname==name)
                index=i;
        switch(property){
            case 1:
                balance=g[index].budget;
                i=0;
                while(balance>0 && i<es){
                    balance-=e[i].price;
                    value+=e[i++].value;
                }
                i=0;
                while(balance>0 ){
                    
                    balance-=l[i].price;
                    value+=(2*l[i++].value);
                    
                }
                g[index].gift_value=value;
                g[index].gift_price=g[index].budget-balance;
                happiness=budget-(g[index].budget-balance);
                g[index].calculate_happiness();
                break;
            case 2:
                balance=budget;
                i=ls-1;
                while(i>=0 && balance-l[i].price>=0){
                    balance-=l[i].price;
                    value+=(2*l[i--].value);
                }
                i=es-1;
                while(i>=0 && balance-e[i].price>=0){
                    balance-=e[i].price;
                    value+=(e[i--].value);
                }
                g[index].gift_value=value;
                g[index].gift_price=budget-balance;
                happiness=g[index].calculate_happiness();
                break;
            case 3:
                balance=g[index].budget;
                i=0;
                while(balance>0 && i<es){
                    balance-=e[i].price;
                    value+=e[i++].value;
                }
                i=0;
                if(l[0].price+ g[index].budget-balance <= budget){
                    
                    balance-=l[0].price;
                    value+=(2*l[0].value);
                }
                g[index].gift_value=value;
                g[index].gift_price=g[index].budget-balance;
                happiness=g[index].intelligence;
                g[index].calculate_happiness();
                break;
                
        }
        
            
        
    }
    
     
}
