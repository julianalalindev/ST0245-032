

public class Fecha {
    

    private final int dia;
    private final int mes;
    private final int ano;

    public Fecha(int dia ,int mes , int ano) {
        this.dia= dia;
        this.mes = mes;
        this.ano= ano;

    }

    public int dia() {
        return dia;
    }

    public int mes() {
        return mes;
    }


    public int ano() {
        return ano;
    }


    public int comparar(Fecha otra) {
       int fecha= ano*10000+mes*100+dia;
       int fecha2= otra.ano()*10000+otra.mes()*100+otra.dia();
       
       if(fecha>fecha2){
           return 1;
        }else if(fecha==fecha2){
            return 0;
        }else{
            return -1;
        }
       
    }


    public String toString() {
        return dia+"/"+mes+"/"+ano;
        
    }
}