/**
 * @author Isabel Urrego y Juliana Lalinde
 */
public class NuevaLista {

    private int size;
    private final int TAMANIO_INICIAL=10;
    private int [] lista;

    public NuevaLista() {
        lista= new int[TAMANIO_INICIAL];
        size=0;
    }

    public int size() {
        return size;
    }

    public void add (int elemento) {
        if(size==lista.length) {
            expandirLista();
        }
        lista[size]=elemento;
        size++;
    }

    public void add (int index, int elemento) {
        if(size==lista.length) {
            expandirLista();
        }
        for(int x=index; x<size-1; x++) {
            lista[x+1]=lista[x];
        }
        lista[index]=elemento;
        size++;
    }

    private void expandirLista() {
        int [] nuevo = new int [size*2];
        for(int x=0; x<size; x++) {
            nuevo[x]=lista[x];
        }
        lista=nuevo;
    }

    public int get (int index) {
        return lista[index];
    }

    public void del (int index) {
        for(int x=index; x<size-1; x++) {
            lista[x]=lista[x+1];
        }
        lista[size]=0;
        size--;
    }
}