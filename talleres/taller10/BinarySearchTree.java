
public class BinarySearchTree {
    Node root ;
    public BinarySearchTree () {
        root = null ;
    }

    public boolean buscar(int n){
        return buscarAux(root, n);
    }

    private boolean buscarAux(Node nodo, int n){
        if(nodo == null){
            return false;
        }
        if(nodo.data == n){
            return true;
        }
        if(nodo.data > n){
            return buscarAux(nodo.left,n);
        }else{
            return buscarAux(nodo.right,n);
        }
    }

    public void insertar(int n) {
        if(root != null){
            insertarAux(root,n);
        }else{
            Node newNode = new Node(n);
            root = newNode;
        }
    }

    private void insertarAux(Node nodo, int n){
        Node act = nodo;
        if(n >= act.data && act.right==null){
            Node newNode = new Node(n);
            act.right = newNode;
        }else if(n < act.data && act.left==null){
            Node newNode = new Node(n);
            act.left = newNode;
        }else if(n >= act.data && act.right!=null){
            insertarAux(act.right,n);
        }else if(n < act.data && act.left!=null){
            insertarAux(act.left,n);
        }
    }

    public void borrar(int n) {
        if(root.data == n){
            Node newRoot = root.left;
            bsMaxRight(newRoot,root.right);
            root = newRoot;
        }else{
            borrarAux(root,n);
        }
    }

    private void bsMaxRight(Node root,Node derecho){
        if(root.right == null){
            root.right = derecho;
        }else{
            bsMaxRight(root.right,derecho);
        }
    }

    private void borrarAux(Node nodo, int n){
        if(n >= nodo.data){
            if(nodo.right.data == n){
                nodo.right = null;
            }else{
                borrarAux(nodo.right,n);
            }
        }else if(n < nodo.data){
            if(nodo.left.data == n){
                nodo.left = null;
            }else{
                borrarAux(nodo.left,n);
            }
        }
    }
}