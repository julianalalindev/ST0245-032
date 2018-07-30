
/**
 * Laboratorio 1
 * Juliana Lalinde e Isabel Urrego
 * 30/07
 */
public class lab01
{

	//Punto 1.1
    public static int punto11 (int n){
        if(n==0 || n==1){
            return 1;
        }else{
            return punto11(n-1)+punto11(n-2);
    	}
	}
 
	//Punto 2.1

	public int triangle(int rows) {
 	 	if(rows==0){
   		 return 0;
  		}	else {
   		 return rows+triangle(rows-1);
  		}
	}

	public int sumDigits(int n) {
  		if(n<10){
    		return n;
  		}else{
    		return n%10+ sumDigits(n/10);
  		}
	}

	public int powerN(int base, int n) {
  		if(n==0){
    		return 1;
  		}else if(n==1){
    		return base;
  		}else{
    		return base* powerN(base,n-1);
  		}
	}

	public String changePi(String str) {
    	if (str.length() < 2){
      		return str;
    	}else if (str.substring(0, 2).equals("pi")){
      		return "3.14" + changePi(str.substring(2));
    	}else{
      		return str.charAt(0) + changePi(str.substring(1));
    	}

	}

	public String noX(String str) {
    	if (str.length() == 0){
      		return "";
    	} else if(str.charAt(0)=='x'){
      		return noX(str.substring(1));
    	}else{
      		return str.charAt(0)+noX(str.substring(1));
    	}
	}
}
