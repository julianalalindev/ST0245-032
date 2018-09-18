import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada

public class LinkedListMauricio {
    private Node first;
    private int size;

    public LinkedListMauricio()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {
        Node temp= getNode(index-1);
        Node newNode = new Node(data);
        newNode.next= temp.next;
        temp.next= newNode;
        size++;
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(size!= 0){
            if(index==0){
                Node temp= first.next;
                first= temp;
            }else if(index== size-1){
                Node temp=getNode(index-1);
                temp.next= null;
            }else{
            Node temp= getNode(index-1);
            Node removed= getNode(index);
            temp.next=removed.next;
            size--;
        }
        }

    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)

    {
        Node temp=first;
        while(temp.next!= null){
            if(data== temp.data){
                return true;
            }
            temp= temp.next;
        }
        return false;
    }

}
