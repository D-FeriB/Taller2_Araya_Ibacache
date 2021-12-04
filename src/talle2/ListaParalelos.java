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
class ListaParalelos {
    private int count;
    private int max;
    private Estudiante[] list;
    
    public ListaEstudiantes(int max){
        this.max = max;
        count = 0;
        list = new Estudiante[max];
    }
    public int getCant(){ return count;}
    public boolean agregarEstudiante(Estudiante j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    
    public Estudiante buscarEstudiante(String nombreUsuario){
        for (int i = 0; i < count; i++) {
            if (list[i].getRut().equals(nombreUsuario)){
                return list[i];
            }
        }
        return null;
    }
    
    public Estudiante getEstudianteI(int i){
        if (i<count) return list[i];
        return null;
    }
}
