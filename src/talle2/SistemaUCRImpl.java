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
    public String logIn(String rut, String contraseña) {
        Estudiante e = estudiantes.buscarEstudiante(rut);
        if (e!=null){
            if (e.getContraseña().equals(contraseña)){
                return rut+","+"estudiante";
            }
            else{
                throw new NullPointerException("La contraseña del estudiante es incorrecta");
            }
        }
        else{
            Profesor p = profesores.buscarProfesor(rut);
            if (p!=null){
                if (p.getContra().equals(contraseña)){
                    return rut+","+"profesor";
                }
                else{
                    throw new NullPointerException("La contraseña del estudiante es incorrecta");
                }
            }
            else{
                throw new NullPointerException("El rut no está asociado a nadie.");
            }
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
        Estudiante e = estudiantes.buscarEstudiante(rut);
        if (e!=null){
            String text = "";
            for (int i = 0; i < asignaturas.getCant(); i++) {
                if (asignaturas.getAsignaturaI(i) instanceof AsignaturaObligatoria){
                    AsignaturaObligatoria ob = (AsignaturaObligatoria) asignaturas.getAsignaturaI(i);
                    if (ob.getNivel() == e.getNivel()){
                        boolean exito = true;
                        for (int j = 0; j < ob.getParalelos().getCant(); j++) {
                            Paralelo par = ob.getParalelos().getParaleloI(j);
                            if (par.getEstudiantes().getCant()>=100){
                                exito = false;
                            }
                        }
                        if (exito){
                            text+= "\t"+ob.getNombre()+": "+ob.getCodigo()+"\n";
                        }
                    }
                }
            }
            if (text.equals("")){
                return "No existen paralelos por tomar.";
            }
            return text;
        }
        else{
            throw new NullPointerException("El estudiante no existe");
        }
    }

    @Override
    public String obtenerAsignaturasInscritas(String rut) {
        Estudiante e = estudiantes.buscarEstudiante(rut);
        if (e!=null){
            String text = "";
            for (int i = 0; i < e.getInscritas().getCant(); i++) {
                text+= e.getInscritas().getAsignaturaI(i).getNombre()+": "+e.getInscritas().getAsignaturaI(i).getCodigo()+"\n";
            }
            return text;
        }
        else{
            throw new NullPointerException("El estudiante no existe");
        }
    }

    @Override
    public boolean eliminarAsignaturaInscrita(String rut, int codigo) {
        Estudiante e = estudiantes.buscarEstudiante(rut);
        if (e!=null){
            return e.getInscritas().eliminarAsignatura(codigo);
        }
        else{
            throw new NullPointerException("El estudiante no existe");
        }
    }

    @Override
    public String obtenerParalelosProfesor(String rut) {
        Profesor p = profesores.buscarProfesor(rut);
        if (p!=null){
            String text = "";
            for (int i = 0; i < p.getParalelos().getCant(); i++) {
                text+= p.getParalelos().getParaleloI(i).getAsignatura().getNombre()+": N°"+p.getParalelos().getParaleloI(i).getNumero()+"\n";
            }
            return text;
        }
        else{
            throw new NullPointerException("El profesor no existe");
        }
    }

    @Override
    public String obtenerEstudiantesParalelo(int numero, int codigoAsignatura) {
        Asignatura a = asignaturas.buscarAsignatura(codigoAsignatura);
        if (a!=null){
            Paralelo p = a.getParalelos().buscarParalelo(numero);
            if (p!=null){
                String text = "";
                for (int i = 0; i < p.getEstudiantes().getCant(); i++) {
                    text+=p.getEstudiantes().getEstudianteI(i).getRut()+" "+p.getEstudiantes().getEstudianteI(i).getCorreo()+"\n";
                }
                return text;
            }
            else{
                throw new NullPointerException("El paralelo no existe");
            }
        }
        else{
            throw new NullPointerException("La asignatura no existe");
        }
    }

    @Override
    public void ingresarNota(int codigoAsignatura, String rut, double nota) {
        Asignatura a = asignaturas.buscarAsignatura(codigoAsignatura);
        if (a != null){
            Estudiante e = estudiantes.buscarEstudiante(rut);
            if (e!=null){
                Resultado r = new Resultado(nota);
                r.setAsignatura(a);
                r.setEstudiante(e);
                e.getResultados().agregarResultado(r);
            }
            else{
                throw new NullPointerException("El estudiante no existe");
            }
        }
        else{
            throw new NullPointerException("La asignatura no existe");
        }
    }

    @Override
    public String obtenerEgresados() {
        String text = "";
        int total = 0;
        for (int x = 0; x < asignaturas.getCant(); x++) {
            if (asignaturas.getAsignaturaI(x) instanceof AsignaturaObligatoria){
                total++;
            }
        }
        for (int i = 0; i < estudiantes.getCant(); i++) {
            int count = 0;
            Estudiante e = estudiantes.getEstudianteI(i);
            for (int j = 0; j < e.getResultados().getCant(); j++) {
                Resultado r = e.getResultados().getResultadoI(j);
                if (r.getNota()>=3.95){
                    count++;
                }
            }
            if (count==total){
                text+=e.getRut()+"\n";
            }
        }
        return text;
    }

    @Override
    public String mostrarParalelos(int codigo) {
        Asignatura a = asignaturas.buscarAsignatura(codigo);
        String text = "";
        if (a!=null){
            for (int i = 0; i < a.getParalelos().getCant(); i++) {
                Paralelo p = a.getParalelos().getParaleloI(i);
                int cupo = 40-p.getEstudiantes().getCant();
                text+="Paralelo "+p.getNumero()+", cupo "+cupo+" restantes\n";
            }
            return text;
        }
        else{
            throw new NullPointerException("La asignatura no existe");
        }
    }

    @Override
    public void inscribirParalelo(String rut, int codigo, int paralelo) {
        Estudiante e = estudiantes.buscarEstudiante(rut);
        Asignatura a = asignaturas.buscarAsignatura(codigo);
        if (a!=null && e!=null){
            Paralelo p = a.getParalelos().buscarParalelo(paralelo);
            if (p!=null){
                if (!p.getEstudiantes().agregarEstudiante(e)){
                    throw new NullPointerException("Paralelo lleno!");
                }
            }
            else{
                throw new NullPointerException("Paralelo no existe");
            }
        }
        else{
            throw new NullPointerException("Asignatura o estudiante no existe");
        }
    }
    
}
