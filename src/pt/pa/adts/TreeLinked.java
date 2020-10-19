package pt.pa.adts;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author patricia.macedo
 * @param <E> type of elements of the tree
 */
public class TreeLinked<E> implements Tree<E> {

    //** TreeNode implemented as a inner class at the end **/
    
    private TreeNode root; 

    public TreeLinked() {
     this.root=null;
    }
   
    public TreeLinked(E root) {
        this.root = new TreeNode(root);
    }

    @Override
    public int size() {
        throw new NotImplementedException();
    }


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public E replace(Position<E> position, E e) throws InvalidPositionException {
        TreeNode node = checkPosition(position);
        E replacedElem= node.element;
        node.element= e;
        return replacedElem;
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        return root;

    }

    @Override
    public Position<E> parent(Position<E> position) throws InvalidPositionException, BoundaryViolationException {
        TreeNode node = checkPosition(position);
        return node.parent;

    }

    @Override
    public Iterable<Position<E>> children(Position<E> position) throws InvalidPositionException {
        TreeNode node = checkPosition(position);
        ArrayList<Position<E>> list = new ArrayList<>();
        for (Position<E> pos : node.children) {
            list.add(pos);
        }
        return list;
    }

    @Override
    public boolean isInternal(Position<E> position) throws InvalidPositionException {
        TreeNode aux = checkPosition(position);
        return !aux.children.isEmpty() && aux != this.root;
    }

    @Override
    public boolean isExternal(Position<E> position) throws InvalidPositionException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isRoot(Position<E> position) throws InvalidPositionException {
        throw new NotImplementedException();
    }


    @Override
    public Position<E> insert(Position<E> parent, E elem)
            throws BoundaryViolationException, InvalidPositionException {

        TreeNode aux = checkPosition(parent);
        return insert(parent, elem, aux.children.size());
    }

    @Override
    public E remove(Position<E> position) throws InvalidPositionException {
        throw new NotImplementedException();
    }

    @Override
    public int height() {
        throw new NotImplementedException();
    }

    @Override
    public Position<E> insert(Position<E> parent, E elem, int order)
            throws BoundaryViolationException, InvalidPositionException {
        TreeNode aux = checkPosition(parent);
        if (order < 0 || order > aux.children.size()) {
            throw new BoundaryViolationException("Fora de limites");
        }
        TreeNode node = new TreeNode(elem,aux);
        node.children.add(order, node);
        return node;

    }

    /*
        auxiliary method to check if Position is valid and cast to a treeNode
     */
    private TreeNode checkPosition(Position<E> position)
            throws InvalidPositionException {
        if (position == null) {
            throw new InvalidPositionException();
        }

        try {
            TreeNode treeNode = (TreeNode) position;
            if (treeNode.children == null) {
                throw new InvalidPositionException("The position is invalid");
            }
            return treeNode;
        } catch (ClassCastException e) {
            throw new InvalidPositionException();
        }
    }

        @Override
    public Iterable<Position<E>> positions() {
        throw new NotImplementedException();
    }

    /** auxiliary recursive method for elements() method**/

    private void elements(Position<E> position, ArrayList<E> lista) {

        lista.add(lista.size(), position.element()); // visit (position) primeiro, pre-order
        for (Position<E> w : children(position)) {
            elements(w, lista);
        }

    }

    @Override
    public Iterable<E> elements() {
        ArrayList<E> lista = new ArrayList<>();
        if (!isEmpty()) {
            elements(root, lista);
        }
        return lista;
    }

    private String toStringPreOrder(Position<E> position) {
        String str = position.element().toString(); // visit (position)
        for (Position<E> w : children(position)) {
            str += "," + toStringPreOrder(w);
        }
        return str;
    }

    public String toString() {
        String str = "";
        if (!isEmpty()) {
            str = toStringPreOrderLevels(root, 1);
        }

        return str;
    }

    /* auxiliary method to write Tree, using preorder aproach */

    private String toStringPreOrderLevels(Position<E> position, int level) {
        String str = position.element().toString(); // visit (position)
        for (Position<E> w : children(position)) {
            str += "\n" + printLevel(level) + toStringPreOrderLevels(w, level + 1);
        }
        return str;
    }

    /** auxiliary method to format a level of the tree*/

    private String printLevel(int level) {
        String str = "";
        for (int i = 0; i < level; i++) {
            str += "  ";
        }
        return str + "-";
    }

    /**
     *  inner class - represent a node of a tree. Each node have a list of children, that can be empty.
     */
    private class TreeNode implements Position<E> {

        private E element;  // element stored at this node
        private TreeNode parent;  // adjacent node
        private List<TreeNode> children;  // children nodes

        TreeNode(E element) {
            this.element = element;
            parent = null;
            children = new ArrayList<>();
        }

        TreeNode(E element, TreeNode parent) {
            this.element = element;
            this.parent = parent;
            this.children = new ArrayList<>();
        }

        public E element() {
            if (element == null) {
                throw new InvalidPositionException();
            }
            return element;
        }
    }

}
