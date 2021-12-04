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
class Paralelo {
    private int numero;
    private Asignatura asignatura;
    private Profesor profe;
    private ListaEstudiantes estudiantes;
    
    public Paralelo(int numero){
        this.numero = numero;
        asignatura = null;
        profe = null;
        estudiantes = new ListaEstudiantes(100);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Profesor getProfe() {
        return profe;
    }

    public void setProfe(Profesor profe) {
        this.profe = profe;
    }

    public ListaEstudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ListaEstudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
