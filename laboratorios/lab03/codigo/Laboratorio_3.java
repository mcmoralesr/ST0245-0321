import java.util.*;
import java.lang.IndexOutOfBoundsException;

/**
 *
 * @author (Maria Camila Morales Ríos)
 * 
 */
class Node{
    public int data;    
    public Node next;
    public Node(int data){
        next = null;
        this.data = data;

    }

}

public class Laboratorio_3{
    private Node first;
    private int size;

    /*  Desarrollen un método que reciba una lista y devuelva la multiplicación de
    todos los números introducidos en una lista. Como un ejemplo, para el arreglo
    [1,2,3,4], el método debe retornar 1*2*3*4 = 24. */
    /**
     * Este método retorna la multiplicación de todos los números en una lista
     * @recibe una lista
     * @retorna un entero
     */
    public static int multiply(List<Integer> list) {
        int mult = 1;
        for(int i = 0; i < list.size();i++){  
            mult = mult * list.get(i);
        }
        return mult;
    }

    /* Teniendo en cuenta lo anterior, implementen un método que reciba una lista e
    inserte un dato de modo similar a la función insertar al final de la lista. La diferencia
    es que ahora no se debe permitir insertar datos repetidos. Si un dato ya está
    almacenado, entonces la lista no varía, pero tampoco es un error. Llámelo
    SmartInsert(Lista l, int data).*/
    /**
     * Este método agrega un entero al final de la lista
     * @recibe una lista y un número entero
     * @retorna una cadena de caracteres
     */
    public static String  SmartInsert(List<Integer> list, int data){ 
        if(!list.contains(data)){ // el elemento no puede estar repetido
            list.add(data);
        }       
        return (Arrays.toString(list.toArray()));
    }

    /*  Teniendo en cuenta lo anterior, escriban un método que reciba una lista y
    calcule cuál es la posición óptima de la lista para colocar un pivote*/
    /**
     * Este método retorna la posición óptima de un pivote
     * @recibe una lista
     * @retorna un entero
     */
    public static int pivote (List <Integer> list){
        int first= 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        for(int i=0; i<list.size()-1; i++){
            if(i== 0){
                for(int j= 0; j<list.size(); j++){
                    second += list.get(j);
                } 
            } else{
                third += list.get(i-1);
                for(int k= i+1; k< list.size(); k++){
                    fourth += list.get(k);
                }
                if(Math.abs(third-fourth)<second){
                    first=i;
                    second= Math.abs(third-fourth);
                }
            }
        }
        return first;
    }
    /*Teniendo en cuenta lo anterior, elaboren un programa que reciba las neveras, en
    la forma en que están ordenadas en el almacén, y las solicitudes, según el orden
    en que llegaron, y que imprima qué neveras del almacén quedan asignadas a cada
    tienda. Utilice un método asi*/
    /**
     * Este método imprima las neveras del almacen que quedan en la tienda
     * @recibe una lista de neveras y una lista de solicitudes
     * @retorna una cadena de caracteres
     */

    public static void Ejercicio4(List<String> neveras,List<String> solicitudes){
        Queue<String> solicitud = new LinkedList();
        Stack<String> nevera = new Stack();
        Iterator itern = neveras.iterator();

        while(itern.hasNext()){
            nevera.push((String)itern.next());
        }
        Iterator iters = solicitudes.iterator();
        while(iters.hasNext()){

            solicitud.add((String)iters.next());

        }
        for(int i = nevera.size(); i >= 0; i--){

            String sol = solicitud.remove();
            System.out.print(sol);
            int k = i;
            int j = Integer.parseInt(sol.charAt(sol.length()-1) +" ");
            while(k > i-Integer.parseInt(sol.charAt(sol.length()-1) + " ")){

                if(nevera.size()>0){
                    System.out.print( " " + "( " + k + ", " + nevera.pop() + " )");
                    k--;
                }else{
                    return ;
                }
            }
            i = k+1;

        }
    }

    /**
     * Constructor
     */public Laboratorio_3(){
        size = 0;
        first = null;
    }

    /**
     * retorna un nodo en una posicion especifica de la lista
     * @recibe un indice
     * @retorna un nodo
     * @lanza un IndexOutOfBoundsException
     */private Node getNode(int index) throws IndexOutOfBoundsException {
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
     * @retorna el tamaño de la lista
     */public int size(){
        return this.size;
    }

    /**
     * @recibe un entero
     * @retorna un elemento en la posicion especificada de la lista
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return temp.data;
    }

    /**
     *  Inserta un dato en la posición index
     *  @recibe dos enteros, data e index
     */
    public void insert(int data, int index){
        Node nodo1 = new Node(data);

        if (index ==0){
            nodo1.next = first;
            first = nodo1;
        } else {
            Node temp = this.getNode(index - 1);
            nodo1.next = temp.next;
            temp.next = nodo1;
        }
        size++;
    }

    /**
     * Borra el dato en la posición index

     */
    public void remove(int index){
        if(index == 0){
            first = this.getNode(index + 1 );
        }else{
            Node temp = this.getNode(index -1);
            temp.next = this.getNode(index).next;
        }
        size --;
    } 

    /**
     *  Verifica si está un dato en la lista
     */
    public boolean contains(int data){
        Node currentnode = first;
        while (currentnode != null){
            if(currentnode.data == data) 
                return true;
            currentnode = currentnode.next;
        }
        return false;
    }

    public static void main(String[] args) {
        //lista enlazada

        Laboratorio_3 list = new Laboratorio_3();

        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);

        /*System.out.println(list.contains(0));
        list.remove(0);
        System.out.println(list.contains(0));
         */
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

        System.out.println(list.contains(3));
        list.remove(2);
        System.out.println(list.contains(3));
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        /*System.out.println(list.contains(4));
        list.remove(4);
        System.out.println(list.contains(4));*/

        LinkedList<Integer> linked = new LinkedList<>();
        linked.addAll(Arrays.asList(new Integer[] {1, 3, 5, 7}));

        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(new Integer[] {2, 4, 6, 8}));

        // Multiply

        System.out.println(multiply(linked));
        System.out.println(multiply(array));

        //SmartInsert
        System.out.println(" Insert 4 in " + Arrays.toString(linked.toArray()) + " : " +SmartInsert(linked,4));
        System.out.println("Insert 10 in " +  Arrays.toString(array.toArray()) + " : " +SmartInsert(array,10));

        //pivote
        System.out.println(pivote(array));
        //neveras
        LinkedList<String> nev1= new LinkedList<>();
        nev1.addAll(Arrays.asList(new String[] {"Samsung","LG", "Siemens","Haceb", "Electrolux"}));
        LinkedList<String> sol1 = new LinkedList<>();
        sol1.addAll(Arrays.asList(new String[] {"Falabella1","Ktronix2","Exito4","Jumbo3"}));

    }
}
