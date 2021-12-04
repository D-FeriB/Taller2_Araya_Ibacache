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
public interface SistemaUCR {
    public boolean agregarEstudiante(String rut, String correo, int nivel, String contraseña);
    public boolean agregarAsignaturaObligatoria(int codigo, String nombre, int creditos, int nivel);
    public void asociarAsignaturaAsignaturaObligatoria(int codigoAsignatura, int codigoAsignaturaObligatoria);
    public void agregarAsignaturaOpcional(int codigo, String nombre, int creditos, int creditos_prerequisitos);
    public void agregarProfesor(String rut, String correo,String contraseña, int salario);
    public void asociarParaleloAsignaturaProfesor(int numero, int codigoAsignatura, String rutProfesor);
    public void logIn(String rut,String contraseña);
    public void InscribirAsignatura(String rut,int codigo);
    public String obtenerAsignaturasDisponibles(String rut);
    public String obtenerAsignaturasInscritas(String rut);
    public boolean eliminarAsignaturaInscrita(String rut, int codigo);
    public String obtenerParalelosProfesor(String rut);
    public String obtenerEstudiantesParalelo(int numero, int codigoAsignatura);
    public void ingresarNota(int codigoAsignatura, String rut, double nota);
    public void obtenerEgresados();
}
