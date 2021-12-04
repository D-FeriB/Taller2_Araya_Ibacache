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
public class SistemaUCRImpl implements SistemaUCR{

    private ListaEstudiantes estudiantes;
    
    @Override
    public boolean agregarEstudiante(String rut, String correo, int nivel, String contraseña) {
        
    }

    @Override
    public boolean agregarAsignaturaObligatoria(int codigo, String nombre, int creditos, int nivel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asociarAsignaturaAsignaturaObligatoria(int codigoAsignatura, int codigoAsignaturaObligatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarAsignaturaOpcional(int codigo, String nombre, int creditos, int creditos_prerequisitos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarProfesor(String rut, String correo, String contraseña, int salario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asociarParaleloAsignaturaProfesor(int numero, int codigoAsignatura, String rutProfesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logIn(String rut, String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void InscribirAsignatura(String rut, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerAsignaturasDisponibles(String rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerAsignaturasInscritas(String rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarAsignaturaInscrita(String rut, int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerParalelosProfesor(String rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerEstudiantesParalelo(int numero, int codigoAsignatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarNota(int codigoAsignatura, String rut, double nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obtenerEgresados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
