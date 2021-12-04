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
class ListaResultados {
    private int count;
    private int max;
    private Resultado[] list;
    
    public ListaResultados(int max){
        this.max = max;
        count = 0;
        list = new Resultado[max];
    }
    public int getCant(){ return count;}
    public boolean agregarResultado(Resultado j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    
    public Resultado buscarResultado(String rut, int codigoAsignatura){
        for (int i = 0; i < count; i++) {
            if (list[i].getEstudiante().getRut().equals(rut) && list[i].getAsignatura().getCodigo()==codigoAsignatura){
                return list[i];
            }
        }
        return null;
    }
    
    public Resultado getResultadoI(int i){
        if (i<count) return list[i];
        return null;
    }
}
