import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Posts.Post;

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
        prnt("2. Mostrar posts por fecha");
        prnt("3. Mostrar posts por hashtag (#)");
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
        while(true){
            prnt("Ingrese el texto de su publicacion: (Max 20 caracteres)");
            String mensaje = scan.nextLine();
            if(mensaje.length() <= 20 && mensaje.length() > 0){
                return mensaje;
            }else{
                this.mostrarOpcionInvalida();
            }
        }
    }
    public ArrayList<String> pedirHashtags(){
        boolean ingresoValido = false;
        int opcion = -1;
        while(!ingresoValido){
            prnt("Desea agregar hashtags a su publicacion?");
            prnt("1. Si");
            prnt("2. No");
            try{
                opcion = scan.nextInt();
                scan.nextLine();
                ingresoValido = true;
            }catch(Exception e){
                scan.next();
                mostrarOpcionInvalida();
            }
        }
        if(opcion == 1){
            while(true){
                ingresoValido = true;
                prnt("Ingrese los #'s de su publicacion: (Ej. #Publicacion, #Like)");
                String ingreso = scan.nextLine();
                ArrayList<String> hashtags = new ArrayList<>(Arrays.asList(ingreso.trim().split("\\s*,\\s*") ));
                for (String hashtag : hashtags) {
                    if(!hashtag.startsWith("#")){
                        ingresoValido = false;
                    }   
                }
                if(!ingresoValido){
                    prnt("Al menos uno de los ingresos no contenia '#'. Pruebe de nuevo.");
                }else{
                    return hashtags;
                }
            }        
        }
        return null;
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
    }
    public void mostrarPublicado(){
        prnt("Se ha publicado con exito!");
    }
    public String pedirEmoticon(){
        prnt("Ingrese el emoticon de su publicacion: ");
        return scan.nextLine();
    }
    public void MostrarPost(Post post){
        prnt(post.getPost());
    }
    public String pedirFormato(){
        String ingreso = "";
        boolean ingresoValido = false;
        while(!ingresoValido){
            prnt("Ingrese el formato de su imagen (.JPG, .PNG, etc.)");
            ingreso = scan.nextLine().toUpperCase();
            if(!ingreso.startsWith(".")){
                prnt("Asegurese de haber colocado el '.' antes de su extension");
            }else{
                ingresoValido = true;
            }
        }
        return ingreso;
    }
    public int pedirResolucion(){
        boolean ingresoValido = false;
        int opcion = -1;
        while(!ingresoValido){
            prnt("Desea especificar la resolucion de su imagen?");
            prnt("1. Si");
            prnt("2. No");
            try{
                opcion = scan.nextInt();
                scan.nextLine();
                ingresoValido = true;
            }catch(Exception e){
                scan.next();
                mostrarOpcionInvalida();
            }
        }

        if(opcion == 1){
            while(true){
                try{
                    prnt("Ingrese el numero de megapixeles de su imagen (solo el numero)");
                    int resolucion = scan.nextInt();
                    scan.nextLine();
                    return resolucion;
                }catch(Exception e){
                    scan.next();
                    prnt("Ingreso una resolucion invalida. Pruebe de nuevo");
                }
            }
        }else{
            return 2;
        }
    }
    public String pedirURL(){
        while(true){
            prnt("Ingrese el URL de su imagen: (https://...");
            String ingreso = scan.nextLine();
            if(ingreso.startsWith("https://")){
                return ingreso;
            }else{
                prnt("Ha ingresado un link invalido. Verifique que inicie con 'https://' y pruebe de nuevo.");
            }
        }
    }
    public int pedirTamanio(){
        boolean ingresoValido = false;
        int opcion = -1;
        while(!ingresoValido){
            prnt("Desea especificar el tamanio de su imagen?");
            prnt("1. Si");
            prnt("2. No");
            try{
                opcion = scan.nextInt();
                scan.nextLine();
                ingresoValido = true;
            }catch(Exception e){
                scan.next();
                mostrarOpcionInvalida();
            }
        }
        if(opcion == 1){
            while(true){
                prnt("Ingrese el tamanio de su imagen en kilobytes (kb): (Solo el numero)");
                try{
                    int tamanio = scan.nextInt();
                    scan.nextLine();
                    return tamanio;
                }catch(Exception e){
                    scan.next();
                    mostrarOpcionInvalida();
                }
            }
        }else{
            return 120;
        }
    }
    public int pedirFrameRate(){
        boolean ingresoValido = false;
        int opcion = -1;
        while(!ingresoValido){
            prnt("Desea especificar el Frame Rate de su video?");
            prnt("1. Si");
            prnt("2. No");
            try{
                opcion = scan.nextInt();
                scan.nextLine();
                ingresoValido = true;
            }catch(Exception e){
                scan.next();
                mostrarOpcionInvalida();
            }
        }
        if(opcion == 1){
            while(true){
                prnt("Ingrese el Frame Rate de su video en Frames Per Second (fps): (Solo el numero)");
                try{
                    int tamanio = scan.nextInt();
                    scan.nextLine();
                    return tamanio;
                }catch(Exception e){
                    scan.next();
                    mostrarOpcionInvalida();
                }
            }
        }else{
            return 60;
        }
    }
    public double pedirSampleRate(){
        boolean ingresoValido = false;
        int opcion = -1;
        while(!ingresoValido){
            prnt("Desea especificar el Sample Rate de su audio?");
            prnt("1. Si");
            prnt("2. No");
            try{
                opcion = scan.nextInt();
                scan.nextLine();
                ingresoValido = true;
            }catch(Exception e){
                scan.next();
                mostrarOpcionInvalida();
            }
        }

        if(opcion == 1){
            while(true){
                try{
                    prnt("Ingrese el numero de kGHz de su audio (solo el numero)");
                    int sampleRate = scan.nextInt();
                    scan.nextLine();
                    return sampleRate;
                }catch(Exception e){
                    scan.next();
                    prnt("Ingreso una resolucion invalida. Pruebe de nuevo");
                }
            }
        }else{
            return 44.1;
        }
    }
    public int pedirBitDepth(){
        boolean ingresoValido = false;
        int opcion = -1;
        while(!ingresoValido){
            prnt("Desea especificar el Bit Depth de su audio?");
            prnt("1. Si");
            prnt("2. No");
            try{
                opcion = scan.nextInt();
                scan.nextLine();
                ingresoValido = true;
            }catch(Exception e){
                scan.next();
                mostrarOpcionInvalida();
            }
        }

        if(opcion == 1){
            while(true){
                try{
                    prnt("Ingrese el Bit Depth de su audio (solo el numero)");
                    int sampleRate = scan.nextInt();
                    scan.nextLine();
                    return sampleRate;
                }catch(Exception e){
                    scan.next();
                    prnt("Ingreso un bit depth invalido. Pruebe de nuevo");
                }
            }
        }else{
            return 16;
        }
    }
    public void mostrarEncabezado(int i, Post post){
        prnt(i + ") " + post.getEncabezado());
    }
    public int mostrarSeleccionarPost(int i){
        while(true){
            try{
                prnt("Que post desea ver? Seleccione un numero entre 1 y " + i);
                int ingreso = scan.nextInt();
                scan.nextLine();
                if(ingreso > 0 && ingreso <= i){
                    return ingreso;
                }else{
                    mostrarOpcionInvalida();
                }
            }catch(Exception e){
                scan.next();
                mostrarOpcionInvalida();
            }
        }
    }
    public String pedirHashtagFiltrado(){
        while(true){
            prnt("Ingrese el # que desea buscar: (Ej. #Publicacion, #Like)");
            String ingreso = scan.nextLine();
            if(ingreso.startsWith("#")){
                return ingreso;
            }else{
                mostrarOpcionInvalida();
            }
        }
    }
    public void mostrarNoHayResultados(){
        prnt("No hay resultados para esta filtracion.");
    }
}