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
    
    public Arbol(Nodo<T> rootNode){//Constructor tradicional
        this.root=rootNode;
    }
    public Arbol(String ruta){//Funcion que crea un arbol a partir de un directorio sin subdirectorios(sin carpetas) solo con archivos
        //Escaneo de la carpta para obtener el peso de esta y el nombre para crear el respectivo nodo
        root=null;
    }
    
    public Arbol<T> crearArbolDir(String ruta){//Funcion recursiva que va creando el arbol final que contiene la info todos los subdirectorios
        
        //Pseudocodigo
        /*si no tiene subdirectorios devuelvo la info del directorio
        caso contrario hago la llamada recursiva y voy armando el arbol
        
        
        */
        return null;
    }
    
    public  Nodo<T> getRoot(){
        return root;
    }
    public void setRoot( Nodo<T> raiz){
        root=raiz;
    }
    
    public boolean isLeaf(){
        return root.getHijos().size()==0;
    }

    public void vaciarArbol(){
        root=null;
    }    
    public int getCanHijos(){
        return root.getCantHijos();
    }
    
    
    
    public int getTam(Arbol<Integer> ab){//Funcion que me devuelve el tamaño/peso del arbol
        //Hay que realizar la forma recursiva para obtener de todos los hijos
        return ab.getRoot().getValor();
    }
    
    public Arbol<T> buscarNodo(Arbol<T> nodo){//Funcion que busca y retorna un nodo usando la etiqueta del nodo como parametor de busqueda
        return null;
    }
    public void AddHijoEsp(Arbol<T> busq,Arbol<T> nodo){//Funcion que agrega hijo a un arbol/subarbol especifco
        buscarNodo(busq).getRoot().AddHijo(nodo);   
    }
    public void AddHijo(Arbol<T> hijo){//Agrega hijo al arbol actual
        root.AddHijo(hijo);
    }
    
    
    
}
