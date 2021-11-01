import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Vista {
    private Scanner scan;
    public Vista(){
        scan = new Scanner(System.in);
    }
    private void prnt(String texto){
        System.out.println(texto);
    }

    public void bienvenida(){
        prnt("Bienvenido a QueOndaMano!");
    }
    public void mostrarOpcionInvalida(){
        prnt("Ha ingresado una opcion invalida. Pruebe de nuevo");
    }
    public int mostrarMenuPrincipal(){
        prnt("Que desea hacer?");
        prnt("1. Publicar");
        prnt("2. Filtrar por fecha");
        prnt("3. Filtrar por hashtag (#)");
        prnt("4. Salir");
        try{
            int opcion = scan.nextInt();
            scan.nextLine();
            return opcion;
        }catch(Exception e){
            scan.next();
            return -1;
        }
    }
    public int mostrarMenuTipoPost(){
        prnt("Que tipo de post desea publicar?");
        prnt("1. Texto");
        prnt("2. Emoticon");
        prnt("3. Imagen");
        prnt("4. Video");
        prnt("5. Audio");
        try{
            int opcion = scan.nextInt();
            scan.nextLine();
            return opcion;
        }catch(Exception e){
            scan.next();
            return -1;
        }
    }
    public String pedirMensaje(){
        prnt("Ingrese el texto de su publicacion:");
        return scan.nextLine();
    }
    public int incluirHashtags(){
        prnt("Desea agregar hashtags a su publicacion?");
        prnt("1. Si");
        prnt("2. No");
        try{
            int opcion = scan.nextInt();
            scan.nextLine();
            return opcion;
        }catch(Exception e){
            scan.next();
            return -1;
        }
    }
    public ArrayList<String> pedirHashtags(){
        prnt("Ingrese los #'s de su publicacion: (Ej. #Publicacion, #Like)");
        String ingreso = scan.nextLine();
        ArrayList<String> hashtags = new ArrayList<>(Arrays.asList(ingreso.trim().split("\\s*,\\s*") ));
        return hashtags;
    }
    public String pedirAutor(){
        prnt("Que nombre de usuario desea que apareza en la publicacion?");
        return scan.nextLine();
    }
    public Date pedirFechaDePublicacion(){
        boolean ingresoValido = false;
        Date temp = null;
        while(!ingresoValido){
            prnt("Ingrese la fecha de publicacion (dd/MM/yyyy)");
            String fecha = scan.next();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            try{
                temp = formato.parse(fecha);
                ingresoValido = true;
            }catch(Exception e){
                mostrarOpcionInvalida();
            }
        }
        return temp;
        /*int anio = -1;
        int mes = -1;
        int dia = -1;
        int temp = -1;
        boolean ingresoValido = false;
        
        //Dia
        prnt("Ingrese el dia de publicacion: ");
        ingresoValido = false;
        while(!ingresoValido){
            try{
                temp = scan.nextInt();
                scan.nextLine();
                if(temp > 0 && temp <= 31){
                    dia = temp;
                    ingresoValido = true;
                }else{
                    mostrarOpcionInvalida();
                }
            }catch(Exception e){
                scan.next();           
            }
        }
        //MES
        prnt("Ingrese el mes de publicacion: (1-12)");
        ingresoValido = false;
        while(!ingresoValido){
            try{
                temp = scan.nextInt();
                scan.nextLine();
                if(temp > 0 && temp <= 12){
                    mes = temp;
                    ingresoValido = true;
                }else{
                    mostrarOpcionInvalida();
                }
            }catch(Exception e){
                scan.next();           
            }
        }
        //ANIO
        prnt("Ingrese el anio de publicacion:");
        while(!ingresoValido){
            try{
                temp = scan.nextInt();
                scan.nextLine();
                if(temp > 1900 && temp <= 2021){
                    anio = temp;
                    ingresoValido = true;
                }else{
                    mostrarOpcionInvalida();
                }
            }catch(Exception e){
                scan.next();           
            }
        }
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);*/
    }
    public void mostrarPublicado(){
        prnt("Se ha publicado con exito!");
    }
    public String pedirEmoticon(){
        prnt("Ingrese el emoticon de su publicacion: ");
        return scan.nextLine();
    }
}
