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
class Profesor {
    private String rut;
    private String corre;
    private String contra;
    private int salario;
    private ListaParalelos paralelos;

    public Profesor(String rut, String corre, String contra, int salario) {
        this.rut = rut;
        this.corre = corre;
        this.contra = contra;
        this.salario = salario;
        this.paralelos = new ListaParalelos(100);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorre() {
        return corre;
    }

    public void setCorre(String corre) {
        this.corre = corre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public ListaParalelos getParalelos() {
        return paralelos;
    }
    
    
    
}
