
/**
 * Write a description of class taller03 here.
 * 
 * Juliana Lalinde e Isabel Urrego
 * @version (a version number or a date)
 */
public class taller03
{
    //Punto1
    private static void torresDeHannoiAux(int n, String origen, String intermedio, String destino) {
        if(n==1){
            System.out.println("Mover el disco de la torre "+origen+" a la torre "+destino);
                   
        }else{
            torresDeHannoiAux(n-1,origen,destino,intermedio);
            torresDeHannoiAux(1,origen,intermedio,destino);
            torresDeHannoiAux(n-1,intermedio,origen,destino);
        }
    }

    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, "origen","intermedia","destino");
    }

    //Punto2
    public static void permu(String s) {
       permuAux("", s);
    }
    
    private static void permuAux(String base, String s){
        if(s.length()==0){
            System.out.println(base);
            System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(base));
        }else{
            for(int x=0; x<s.length(); x++) {
                permuAux(base+s.charAt(x),s.substring(0,x)+s.substring(x+1));
            }
        }
    }
}
