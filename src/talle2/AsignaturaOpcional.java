/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talle2;

/**
 *
 * @author jhona
 */
public class AsignaturaOpcional extends Asignatura{
    
    private int creditosPrerequisitos;
    
    public AsignaturaOpcional(int creditosPrerequisitos, int c, String n, int cr) {
        super(c, n, cr);
        this.creditosPrerequisitos = creditosPrerequisitos;
    }

    public int getCreditosPrerequisitos() {
        return creditosPrerequisitos;
    }

    public void setCreditosPrerequisitos(int creditosPrerequisitos) {
        this.creditosPrerequisitos = creditosPrerequisitos;
    }
    
    
    
}
