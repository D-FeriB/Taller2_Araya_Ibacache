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
public class AsignaturaObligatoria extends Asignatura{
    private int nivel;
    private ListaAsignaturas requisitos;

    public AsignaturaObligatoria(int nivel, int c, String n, int cr) {
        super(c, n, cr);
        this.nivel = nivel;
        requisitos = new ListaAsignaturas(100);
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ListaAsignaturas getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(ListaAsignaturas requisitos) {
        this.requisitos = requisitos;
    }

   
}
