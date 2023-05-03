import java.util.*;
public class Set3 {

	public static void main(String[] args) {
		        
		        int [][] towers= {{1,2,5},{2,1,7},{3,1,9}};
		        int radius=2;
		        
		        int maxQty=-1;
		        int[] maxCd= {Integer.MAX_VALUE,Integer.MAX_VALUE};
		        
		        for(int x=0;x<=50;x++) {
		        	for(int y=0;y<=50;y++) {
		        		int quality=0;
		        		
		        		for(int[] i:towers) {
		        			double distance=Math.sqrt(Math.pow(x-i[0],2)+ Math.pow(y-i[1],2));
		        			if(distance<=radius) {
		        				quality+=i[2]/(1+distance);
		        				
		        						}
		        					}
		        		if(quality>maxQty) {
		        			maxQty=quality;
		        			maxCd[0]=x;
		        			maxCd[1]=y;
		        		}
		        		else if(quality==maxQty) {
		        			if( x < maxCd[0] ||  x == maxCd[0] && y < maxCd[1]) {
		        				maxCd[0]=x;
		        				maxCd[1]=y;
		        			}
		        		}
		         
		           }
		       }
		        System.out.println("Coordinate with maximum quality: "+Arrays.toString(maxCd));
		        
		      
		    }
}
