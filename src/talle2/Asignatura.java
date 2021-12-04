/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talle2;

/**
 *
 * @author ibaca
 */
public class Asignatura {
    private int codigo;
    private String nombre;
    private int creditos;
    private ListaParalelos paralelos;
    
    public Asignatura(int c, String n, int cr){
        codigo=c;
        nombre=n;
        creditos=cr;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public ListaParalelos getParalelos() {
        return paralelos;
    }

    public void setParalelos(ListaParalelos paralelos) {
        this.paralelos = paralelos;
    }
    
    
}
