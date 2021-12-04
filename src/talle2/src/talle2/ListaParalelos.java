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
    private Paralelo[] list;
    
    public ListaParalelos(int max){
        this.max = max;
        count = 0;
        list = new Paralelo[max];
    }
    public int getCant(){ return count;}
    public boolean agregarParalelo(Paralelo j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    
    public Paralelo buscarParalelo(int numero){
        for (int i = 0; i < count; i++) {
            if (list[i].getNumero()==numero){
                return list[i];
            }
        }
        return null;
    }
    
    public Paralelo getParaleloI(int i){
        if (i<count) return list[i];
        return null;
    }
}
