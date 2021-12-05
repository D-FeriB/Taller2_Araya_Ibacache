/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author ibaca
 */
public class Talle2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        SistemaUCR sys = new SistemaUCRImpl();
        lectura(sys);
        String[] sesion = logIn(sys);
        String rut = sesion[0];
        String tipo = sesion[1];
        System.out.println("Introduzca la fecha con formato dd/mm/yyyy");
        Scanner sc = new Scanner(System.in);
        String fechaS = sc.nextLine();
        Date fecha = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date iInicio = df.parse("08/03/2021");
        Date fInicio = df.parse("02/05/2021");
        Date iMedio = df.parse("03/05/2021");
        Date fMedio = df.parse("11/07/2021");
        Date iFinal = df.parse("12/07/2021");
        Date fFinal = df.parse("25/07/2021");
        Date cierre = df.parse("26/07/2021");
        try {
            fecha = df.parse(fechaS);
        } catch (Exception e) {
            System.out.println("Ingreso incorrecto de la fecha. En la próxima siga el formato!");
            System.out.println("Fecha automaticamente establecida como 09/03/2021");
            fecha = df.parse("09/03/2021");
        }
        finally{
            if (fecha.before(iInicio)){
                System.out.println("Fecha incorrecta");
            }
            else{
                if ((fecha.after(iInicio) || fecha.equals(iInicio)) && (fecha.before(fInicio) || fecha.equals(fInicio))){
                    if ("estudiante".equals(tipo)){
                        try {
                            System.out.println("Opciones");
                            System.out.println("1) Inscripción de asignaturas");
                            System.out.println("2) Eliminación de asignaturas");
                            System.out.println("3) Salir");
                            System.out.print("[ ]: ");
                            int opcion = Integer.parseInt(sc.nextLine());
                            while (opcion<1 || opcion<2){
                                System.out.println("Ingrese una opción correcta");
                                System.out.println("Opciones");
                                System.out.println("1) Inscripción de asignaturas");
                                System.out.println("2) Eliminación de asignaturas");
                                System.out.print("[ ]: ");
                            }
                            while(true){
                                if (opcion==1){
                                    System.out.println("Asignaturas Disponibles");
                                    System.out.println(sys.obtenerAsignaturasDisponibles(rut));
                                    System.out.println("Ingrese codigo de asignatura:");
                                    int codigo = Integer.parseInt(sc.nextLine());
                                    System.out.println(sys.mostrarParalelos(codigo));
                                    System.out.println("Ingrese paralelo de asignatura:");
                                    int paralelo = Integer.parseInt(sc.nextLine());
                                    try {
                                       sys.InscribirAsignatura(rut, codigo);
                                       sys.inscribirParalelo(rut,codigo,paralelo);
                                    } catch (Exception e) {
                                       System.out.println(e.getMessage());
                                    }
                                }
                                if (opcion==2){
                                    System.out.println(sys.obtenerAsignaturasInscritas(rut));
                                    System.out.println("Ingresa codigo de asignatura:");
                                    int codigo = Integer.parseInt(sc.nextLine());
                                    sys.eliminarAsignaturaInscrita(rut, codigo);
                                }
                                else{
                                    System.out.println("Salir");
                                    break;
                                }
                                System.out.println("Opciones");
                                System.out.println("1) Inscripción de asignaturas");
                                System.out.println("2) Eliminación de asignaturas");
                                System.out.println("3) Salir");
                                System.out.print("[ ]: ");
                                opcion = Integer.parseInt(sc.nextLine());
                            }
                            
                            
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else{
                        try {
                            System.out.println("Opciones");
                            System.out.println("1) Chequeo de alumnos");
                            System.out.println("2) Salir");
                            System.out.print("[ ]: ");
                            int opcion = Integer.parseInt(sc.nextLine());
                            while (opcion<1 || opcion<2){
                                System.out.println("Ingrese una opción correcta");
                                System.out.println("Opciones");
                                System.out.println("1) Chequeo de alumnos");
                                System.out.println("2) Salir");
                                System.out.print("[ ]: ");
                            }
                            while(true){
                                if (opcion==1){
                                    System.out.println(sys.obtenerParalelosProfesor(rut));
                                    System.out.println("Ingrese codigo de asignatura");
                                    int codigo = Integer.parseInt(sc.nextLine());
                                    System.out.println("Ingrese numero de paralelo");
                                    int numero = Integer.parseInt(sc.nextLine());
                                    System.out.println(sys.obtenerEstudiantesParalelo(numero, codigo));
                                }
                                else{
                                    System.out.println("Salir");
                                    break;
                                }
                                System.out.println("Opciones");
                                System.out.println("1) Chequeo de alumnos");
                                System.out.println("2) Salir");
                                System.out.print("[ ]: ");
                                opcion = Integer.parseInt(sc.nextLine());
                            }
                            
                            
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                else{
                    if ((fecha.after(iMedio) || fecha.equals(iMedio)) && (fecha.before(fMedio) || fecha.equals(fMedio))){
                        if ("profesor".equals(tipo)){
                            System.out.println("No hay acciones disponibles");
                        }
                        else{
                            try {
                                System.out.println("Opciones");
                                System.out.println("1) Eliminación de asignaturas");
                                System.out.println("2) Salir");
                                System.out.print("[ ]: ");
                                int opcion = Integer.parseInt(sc.nextLine());
                                while (opcion<1 || opcion<2){
                                    System.out.println("Ingrese una opción correcta");
                                    System.out.println("Opciones");
                                    System.out.println("1) Eliminación de asignaturas");
                                    System.out.println("2) Salir");
                                    System.out.print("[ ]: ");
                                }
                                while(true){
                                    if (opcion==1){
                                        System.out.println(sys.obtenerAsignaturasInscritas(rut));
                                        System.out.println("Ingresa codigo de asignatura:");
                                        int codigo = Integer.parseInt(sc.nextLine());
                                        sys.eliminarAsignaturaInscrita(rut, codigo);
                                    }
                                    else{
                                        System.out.println("Salir");
                                        break;
                                    }
                                    System.out.println("Opciones");
                                    System.out.println("1) Eliminación de asignaturas");
                                    System.out.println("2) Salir");
                                    System.out.print("[ ]: ");
                                    opcion = Integer.parseInt(sc.nextLine());
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    else{
                        if ((fecha.after(iFinal) || fecha.equals(iFinal)) && (fecha.before(fFinal) || fecha.equals(fFinal))){
                            if ("estudiante".equals(tipo)){
                            System.out.println("No hay acciones disponibles");
                            }
                            else{
                                try {
                                    System.out.println("Opciones");
                                    System.out.println("1) Ingreso nota final");
                                    System.out.println("2) Salir");
                                    System.out.print("[ ]: ");
                                    int opcion = Integer.parseInt(sc.nextLine());
                                    while (opcion<1 || opcion<2){
                                        System.out.println("Ingrese una opción correcta");
                                        System.out.println("Opciones");
                                        System.out.println("1) Ingreso nota final");
                                        System.out.println("2) Salir");
                                        System.out.print("[ ]: ");
                                    }
                                    while(true){
                                        if (opcion==1){
                                            System.out.println("Ingrese codigo de asignatura: ");
                                            int codigo = Integer.parseInt(sc.nextLine());
                                            System.out.println("Ingrese rut estudiante:");
                                            String rutA = sc.nextLine();
                                            System.out.println("Ingrese nota: ");
                                            Double nota = Double.parseDouble(sc.nextLine());
                                            sys.ingresarNota(codigo, rutA, nota);
                                        }
                                        else{
                                            System.out.println("Salir");
                                            break;
                                        }
                                        System.out.println("Opciones");
                                        System.out.println("1) Ingreso nota final");
                                        System.out.println("2) Salir");
                                        System.out.print("[ ]: ");
                                        opcion = Integer.parseInt(sc.nextLine());
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }else{
                            System.out.println("Disfruta tus vacaciones!");
                        }
                    }
                }
                
            }
            
        }
    }

    private static void lectura(SistemaUCR sys) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("asignaturas.txt"));
        while(scan.hasNextLine()){
            String [] partes = scan.nextLine().split(",");
            int codigo = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            int creditos = Integer.parseInt(partes[2]);
            String modo = partes[3];
            int nivel = Integer.parseInt(partes[4]);
            if (modo.equals("obligatoria")){
                sys.agregarAsignaturaObligatoria(codigo, nombre, creditos, nivel);
                int cant = Integer.parseInt(partes[5]);
                for (int i = 0; i < cant; i++) {
                    int code = Integer.parseInt(partes[6+i]);
                    try {
                        sys.asociarAsignaturaAsignaturaObligatoria(code, codigo);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else{
                int crepre = Integer.parseInt(partes[5]);
                sys.agregarAsignaturaOpcional(codigo, nombre, creditos, crepre);
            }
        }
        scan.close();
        scan = new Scanner(new File("profesores.txt"));
        while(scan.hasNextLine()){
            String [] partes = scan.nextLine().split(",");
            String rut = partes[0];
            String correo = partes[1];
            String contraseña = partes[2];
            int salario = Integer.parseInt(partes[3]);
            sys.agregarProfesor(rut, correo, contraseña, salario);
        }
        scan.close();
        scan = new Scanner(new File("estudiantes.txt"));
        while (scan.hasNextLine()){
            String [] partes = scan.nextLine().split(",");
            String rut = partes[0];
            String correo = partes[1];
            int nivel = Integer.parseInt(partes[2]);
            String contraseña = partes[3];
            if (!sys.agregarEstudiante(rut, correo, nivel, contraseña)){
                System.out.println("Error ingresando a "+rut);
                return;
            }
            else{
                int cantAsig = Integer.parseInt(scan.nextLine());
                for (int i = 0; i < cantAsig; i++) {
                    String linea = scan.nextLine();
                    String [] parts = linea.split(",");
                    int codigo = Integer.parseInt(parts[0]);
                    double nota = Double.parseDouble(partes[1]);
                    try {
                        sys.ingresarNota(codigo, rut, nota);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                int cantIns = Integer.parseInt(scan.nextLine());
                for (int i = 0; i < cantAsig; i++) {
                    int codigoInsc = Integer.parseInt(scan.nextLine());
                    try{
                        sys.InscribirAsignatura(rut, codigoInsc);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        scan.close();
        scan = new Scanner(new File("paralelos.txt"));
        while(scan.hasNextLine()){
            String [] partes = scan.nextLine().split(",");
            String rut = partes[2];
            int numero = Integer.parseInt(partes[0]);
            int codigo = Integer.parseInt(partes[1]);
            try {
                sys.asociarParaleloAsignaturaProfesor(numero, codigo, rut);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String[] logIn(SistemaUCR sys) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese su RUT:");
        String rut = scan.nextLine();
        System.out.println("Ingrese su password:");
        String pass = scan.nextLine();
        while (true){
            try{
                String text = sys.logIn(rut, pass);
                return text.split(",");
            }
            catch(Exception e){
                System.out.println("Error!");
                System.out.println("Ingrese su RUT:");
                rut = scan.nextLine();
                System.out.println("Ingrese su password:");
                pass = scan.nextLine();
            }
        }
    }
      
       
}
