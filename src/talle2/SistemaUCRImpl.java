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
public class SistemaUCRImpl implements SistemaUCR{

    private ListaEstudiantes estudiantes;
    private ListaAsignaturas asignaturas;
    private ListaProfesores profesores;
    
    @Override
    public boolean agregarEstudiante(String rut, String correo, int nivel, String contraseña) {
        return estudiantes.agregarEstudiante(new Estudiante(rut, correo, nivel, contraseña));
    }

    @Override
    public boolean agregarAsignaturaObligatoria(int codigo, String nombre, int creditos, int nivel) {
        Asignatura a = new AsignaturaObligatoria(nivel, codigo, nombre, creditos);
        return asignaturas.agregarAsignatura(a);
    }

    @Override
    public void asociarAsignaturaAsignaturaObligatoria(int codigoAsignatura, int codigoAsignaturaObligatoria) {
        Asignatura a = asignaturas.buscarAsignatura(codigoAsignaturaObligatoria);
        Asignatura b = asignaturas.buscarAsignatura(codigoAsignatura);
        if (a!=null && b!=null){
            if (a instanceof AsignaturaObligatoria){
                AsignaturaObligatoria ob = (AsignaturaObligatoria) a;
                ob.getRequisitos().agregarAsignatura(b);
            }
            else{
                throw new NullPointerException("La asignatura ingresada no es obligatoria.");
            }
        }
        else{
            throw new NullPointerException("Una o ambas asignaturas no existen.");
        }
    }

    @Override
    public void agregarAsignaturaOpcional(int codigo, String nombre, int creditos, int creditos_prerequisitos) {
        Asignatura a = new AsignaturaOpcional(creditos_prerequisitos, codigo, nombre, creditos);
        asignaturas.agregarAsignatura(a);
    }

    @Override
    public void agregarProfesor(String rut, String correo, String contraseña, int salario) {
        profesores.agregarProfesor(new Profesor(rut, correo, contraseña, salario));
    }

    @Override
    public void asociarParaleloAsignaturaProfesor(int numero, int codigoAsignatura, String rutProfesor) {
        Asignatura a = asignaturas.buscarAsignatura(codigoAsignatura);
        Profesor p = profesores.buscarProfesor(rutProfesor);
        if (a!=null && p!=null){
            Paralelo pa = new Paralelo(numero);
            pa.setAsignatura(a);
            pa.setProfe(p);
            a.getParalelos().agregarParalelo(pa);
            p.getParalelos().agregarParalelo(pa);
        }
        else{
            throw new NullPointerException("Error de nulidad.");
        }
    }

    @Override
    public boolean logIn(String rut, String contraseña) {
        Estudiante e = estudiantes.buscarEstudiante(rut);
        if (e!=null){
            if (e.getContraseña().equals(contraseña)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            throw new NullPointerException("El estudiant enoe xistE");
        }
    }

    @Override
    public void InscribirAsignatura(String rut, int codigo) {
        Estudiante e = estudiantes.buscarEstudiante(rut);
        Asignatura a = asignaturas.buscarAsignatura(codigo);
        if (e!=null && a!=null){
            int creditosInscritos = e.getCreditosUtilizados();
            if ((a.getCreditos()+creditosInscritos)>40){
                throw new NullPointerException("El estudiante no tiene creditos suficiente.");
            }
            else{
                if (a instanceof AsignaturaOpcional){
                    int creaditosTotales = e.getCreditosTotales();
                    AsignaturaOpcional op = (AsignaturaOpcional) a;
                    if (op.getCreditosPrerequisitos()>creaditosTotales){
                        throw new NullPointerException("El estudiante no tiene creditos cursados suficiente.");
                    }
                    else{
                        e.getInscritas().agregarAsignatura(a);
                    }
                }
                else{
                    AsignaturaObligatoria ob = (AsignaturaObligatoria) a;
                    int count = ob.getRequisitos().getCant();
                    for (int i = 0; i < e.getResultados().getCant(); i++) {
                        Asignatura esta = e.getResultados().getResultadoI(i).getAsignatura();
                        if (ob.getRequisitos().estaAca(esta.getCodigo())){
                            count--;
                        }
                    }
                    if (count==0){
                        e.getInscritas().agregarAsignatura(a);
                    }
                    else{
                        throw new NullPointerException("El estudiante no cumple las asignaturas requisitos");
                    }
                }
            }
        }
        else{
            throw new NullPointerException("El estudiante o asignatura no xistE");
        }
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
