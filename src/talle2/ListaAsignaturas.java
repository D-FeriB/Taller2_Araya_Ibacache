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
class ListaAsignaturas {
    private int count;
    private int max;
    private Asignatura[] list;
    
    public ListaAsignaturas(int max){
        this.max = max;
        count = 0;
        list = new Asignatura[max];
    }
    public int getCant(){ return count;}
    public boolean agregarAsignatura(Asignatura j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    
    public Asignatura buscarAsignatura(int codigo){
        for (int i = 0; i < count; i++) {
            if (list[i].getCodigo()==codigo){
                return list[i];
            }
        }
        return null;
    }
    
    public Asignatura getAsignaturaI(int i){
        if (i<count) return list[i];
        return null;
    }
    
    public boolean estaAca(int codigo){
        for (int i = 0; i < count; i++) {
            if (list[i].getCodigo()==codigo){
                return true;
            }
        }
        return false;
    }
   
    public boolean eliminarAsignatura(int text){
        int i = 0;
        while(i < count && list[i].getCodigo()!=text) {
            i++;
        }
        
        if(i == count) {
            //No esta la partida en la lista
            return false;
        }
        else {
            //Corrimiento
            for(int k = i; k < count-1; k++) {
                list[k]=list[k+1];
            }
            count--;
            return true;
        }
    }
}
