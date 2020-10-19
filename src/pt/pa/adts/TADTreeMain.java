/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.pa.adts;



/**
 *
 * @author patricia.macedo
 */
public class TADTreeMain {

    /**

* @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedTree<String> myTree = new LinkedTree("Animal");
        Position<String> root = myTree.root();
        Position<String> posMamifero = myTree.insert(root, "Mamifero");
        Position<String> posAve = myTree.insert(root, "Ave");
        myTree.insert(posMamifero, "Cao");
        Position<String> posGato = myTree.insert(posMamifero, "Gato");
        myTree.insert(posMamifero, "Vaca");
        myTree.insert(posAve, "Papagaio");
        Position<String> posAguia = myTree.insert(posAve, "Aguia");
        myTree.insert(posAguia, "Aguia Real");
        System.out.println("TREE " + myTree);

        System.out.println("Elements: ");
        Iterable<Position<String>> elements = myTree.depthOrder();
        for (Position<String> pos : elements) {
            System.out.print(pos.element() + " ");
        }
        System.out.println();

        System.out.println("E externo " + myTree.isExternal(posAguia));
        System.out.println("");
        System.out.println("NUMERO DE ELEMENTOS " + myTree.size());
        System.out.println("ALTURA " + myTree.height());

        int count = 1;
        for (Position<String> pos : myTree.positions())
            System.out.println(count++ + " - " + pos.element());

        System.out.println("ToString");
        System.out.println(myTree);
    }
}