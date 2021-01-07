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
public class Nodo<T> {
    private T valor;
    private String clave;
    private LinkedList<Arbol> children;
    
    public Nodo(T content,String clav){
        this.valor=content;
        this.children=new LinkedList<>();
        clave=clav;
    }
    
    public void setValor(T val){
        valor=val;
    }
    public void setClave(String clav){
        clave=clav;
    }
    public T getValor(){
        return valor;
    }
    public String getClave(){
        return clave;
    }
    public void setHijos(LinkedList<Arbol> hijos){
        children = hijos;
    }
    public int getCantHijos(){
        return children.size();
    }
    public LinkedList<Arbol> getHijos(){
        return children;
    }
    
    public void AddHijo(Arbol<T> hijo){
        children.addLast(hijo);
    }
    
    
    
    
}
