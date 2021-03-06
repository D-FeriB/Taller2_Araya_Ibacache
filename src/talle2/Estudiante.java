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
class Estudiante {
    private String rut;
    private String correo;
    private String contraseña;
    private int nivel;
    private ListaAsignaturas inscritas;
    private ListaResultados resultados;
    
    public Estudiante(String r, String c, int n, String con){
        rut=r;
        correo=c;
        nivel=n;
        contraseña=con;
        inscritas = new ListaAsignaturas(100);
        resultados = new ListaResultados(100);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ListaAsignaturas getInscritas() {
        return inscritas;
    }

    public void setInscritas(ListaAsignaturas inscritas) {
        this.inscritas = inscritas;
    }

    public ListaResultados getResultados() {
        return resultados;
    }

    public void setResultados(ListaResultados resultados) {
        this.resultados = resultados;
    }
    
    public int getCreditosUtilizados(){
        int suma = 0;
        for (int i = 0; i < inscritas.getCant(); i++) {
            suma += inscritas.getAsignaturaI(i).getCreditos();
        }
        return suma;
    }
    
    public int getCreditosTotales(){
        int suma = 0;
        for (int i = 0; i < resultados.getCant(); i++) {
            suma += resultados.getResultadoI(i).getAsignatura().getCreditos();
        }
        return suma;
    }
    
}
