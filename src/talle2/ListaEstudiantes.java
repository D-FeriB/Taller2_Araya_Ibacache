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
class ListaEstudiantes {
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
    /**
     * text es rut
     * @param text
     * @param text2
     * @return 
     */
    public boolean eliminarEstudiante(String text){
        int i = 0;
        while(i < count && !list[i].getRut().equals(text)) {
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
