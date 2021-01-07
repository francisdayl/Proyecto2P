/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

/**
 *
 * @author F. Lopez
 */
public class Arbol<T> {
    Nodo<T> root;
    
    public Arbol(Nodo<T> rootNode){
        this.root=rootNode;
    }
    
    public boolean isLeaf(){
        return root.getHijos().size()==0;
    }
    
    public void setRoot( Nodo<T> raiz){
         root=raiz;
    }
    public void vaciarArbol(){
        root=null;
    }
    
}
