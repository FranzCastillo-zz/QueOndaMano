import Posts.*;
import Posts.Multimedia.PostImagen;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class QueOndaMano {
    private Vista v;
    private ArrayList<Post> posts;
    private ArrayList<Post> paraMostrar;
    public QueOndaMano(){
        v = new Vista();
        posts = new ArrayList<>();
        paraMostrar = new ArrayList<>();
    }
    public void ejecutar(){
        v.bienvenida();
        while(true){
            boolean opcionValida = false;
            int i = -1;
            int postSeleccionado = -1;
            Post postActual = null;
            while(!opcionValida){
                int opcion = v.mostrarMenuPrincipal();
                switch(opcion){
                    case 1: // PUBLICAR
                        hacerPost();
                        opcionValida = true;
                    break;
                    case 2: // FILTRAR POR FECHA
                        paraMostrar = filtrarPorFecha();
                        if(!paraMostrar.isEmpty()){
                            i = 1;
                            for (Post post : paraMostrar) {
                                v.mostrarEncabezado(i++, post);
                            }
                            postSeleccionado = v.mostrarSeleccionarPost(paraMostrar.size()) - 1;
                            postActual = paraMostrar.get(postSeleccionado);
                            v.MostrarPost(postActual); //FALTA AGREGAR EL "PLAY, LIKE Y COMENTAR"
                            interactuar(postActual);
                        }else{
                            v.mostrarNoHayResultados();
                        }
                        opcionValida = true; 
                    break;
                    case 3: // FILTRAR POR #
                        paraMostrar = filtrarPorHashtag();
                        if(!paraMostrar.isEmpty()){
                            i = 1;
                            for (Post post : paraMostrar) {
                                v.mostrarEncabezado(i++, post);
                            }
                            postSeleccionado = v.mostrarSeleccionarPost(paraMostrar.size()) - 1;
                            postActual = paraMostrar.get(postSeleccionado);
                            v.MostrarPost(postActual); //FALTA AGREGAR EL "PLAY, LIKE Y COMENTAR"
                            interactuar(postActual);
                        }else{
                            v.mostrarNoHayResultados();
                        }
                        opcionValida = true;
                    break;
                    case 4: // SALIR
                        System.exit(1);
                    break;
                    default:
                        v.mostrarOpcionInvalida();
                    break;
                }
            }
        }
    }
    private void hacerPost(){
        boolean opcionValida = false;
            while(!opcionValida){
                int opcion = v.mostrarMenuTipoPost();
                String autor;
                Date fechaDePublicacion;
                String url;
                int tamanio;
                ArrayList<String> hashtags = new ArrayList<>();
                switch(opcion){
                    case 1: // Texto
                        String mensaje = v.pedirMensaje();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        hashtags = v.pedirHashtags();
                        posts.add(new PostTexto(mensaje, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                    break;
                    case 2: // Emoticon
                        String emoticon = v.pedirEmoticon();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        hashtags = v.pedirHashtags();
                        posts.add(new PostEmoticon(emoticon, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                    break;
                    case 3: // Imagen
                        url = v.pedirURL();    
                        String formato = v.pedirFormato();
                        int resolucion = v.pedirResolucion();
                        tamanio = v.pedirTamanio();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        hashtags = v.pedirHashtags();
                        posts.add(new PostImagen(formato, resolucion, url, tamanio, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                    break;
                    case 4: // Video
                        int frameRate = v.pedirFrameRate();
                        url = v.pedirURL();
                        tamanio = v.pedirTamanio();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        hashtags = v.pedirHashtags();
                        posts.add(new Posts.Multimedia.PostVideo(frameRate, url, tamanio, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                    break;
                    case 5: // Audio
                        double sampleRate = v.pedirSampleRate();
                        int bitDepth = v.pedirBitDepth();
                        url = v.pedirURL();
                        tamanio = v.pedirTamanio();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        hashtags = v.pedirHashtags();
                        posts.add(new Posts.Multimedia.PostAudio(sampleRate, bitDepth, url, tamanio, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                    break;
                    default:
                        v.mostrarOpcionInvalida();
                    break;
                }
            }
    }
    private ArrayList<Post> filtrarPorFecha(){
        ArrayList<Post> mostrar = new ArrayList<>();
        Date paraBuscar = v.pedirFechaDePublicacion();
        //CONVIERTE EL DATE EN STRING
        LocalDate localDate = paraBuscar.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String fecha = localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear();
        for (Posts.Post post : posts) {
            if(post.getFechaDePublicacion().equals(fecha)){
                mostrar.add(post);
            }
        }
        return mostrar;
    }
    private ArrayList<Post> filtrarPorHashtag(){
        ArrayList<Post> mostrar = new ArrayList<>();
        String hasthagParaFiltrar = v.pedirHashtagFiltrado();
        for (Post post : posts) {
            boolean ingreso = false;
            for (String hashtag : post.getHashtags()) {
                if(!ingreso){ //SI AUN NO HA INGRESADO
                    if(hashtag.equals(hasthagParaFiltrar)){
                        mostrar.add(post);
                        ingreso = true;
                    }
                }
            }
        }
        return mostrar;
    }
    private void interactuar(Post post){
        boolean regresar = false;
        int opcion = -1;
        while(!regresar){
            opcion = v.mostrarMenuInteractuar();
            switch(opcion){
                case 1: //REPRODUCIR
                    v.reproducir(post);
                break;
                case 2: //Like
                    post.like();
                    v.like();
                    v.MostrarPost(post);
                break;
                case 3: //comentar
                    String comentario = v.comentar();
                    post.comentar(comentario);
                    v.MostrarPost(post);
                break;
                case 4: //regresar
                    regresar = true;
                break;
            }
        }
    }
}
