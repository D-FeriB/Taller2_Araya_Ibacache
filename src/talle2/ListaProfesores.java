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
class ListaProfesores {
    private int count;
    private int max;
    private Profesor[] list;
    
    public ListaProfesores(int max){
        this.max = max;
        count = 0;
        list = new Profesor[max];
    }
    public int getCant(){ return count;}
    public boolean agregarProfesor(Profesor j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    
    public Profesor buscarProfesor(String rut){
        for (int i = 0; i < count; i++) {
            if (list[i].getRut().equals(rut) ){
                return list[i];
            }
        }
        return null;
    }
    
    public Profesor getProfesorI(int i){
        if (i<count) return list[i];
        return null;
    }
}
