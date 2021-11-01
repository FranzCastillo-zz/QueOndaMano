import Posts.*;
import Posts.Multimedia.PostImagen;

import java.util.ArrayList;
import java.util.Date;

public class QueOndaMano {
    private Vista v;
    private ArrayList<Post> posts;
    public QueOndaMano(){
        v = new Vista();
        posts = new ArrayList<>();
    }
    public void ejecutar(){
        v.bienvenida();
        while(true){
            boolean opcionValida = false;
            while(!opcionValida){
                int opcion = v.mostrarMenuPrincipal();
                switch(opcion){
                    case 1: // PUBLICAR
                        hacerPost();
                        opcionValida = true;
                    break;
                    case 2: // FILTRAR POR FECHA
                    break;
                    case 3: // FILTRAR POR #
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

    private boolean incluirHashtags(){
        while(true){
            int incluirHashtags = v.incluirHashtags();
            switch(incluirHashtags){
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    v.mostrarOpcionInvalida();
                break;
            }
        }
    }
    private void hacerPost(){
        boolean opcionValida = false;
            while(!opcionValida){
                int opcion = v.mostrarMenuTipoPost();
                String autor;
                Date fechaDePublicacion;
                ArrayList<String> hashtags = new ArrayList<>();
                switch(opcion){
                    case 1: // Texto
                        String mensaje = v.pedirMensaje();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        if(incluirHashtags()){
                            hashtags = v.pedirHashtags();
                        }
                        posts.add(new PostTexto(mensaje, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                    break;
                    case 2: // Emoticon
                        String emoticon = v.pedirEmoticon();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        if(incluirHashtags()){
                            hashtags = v.pedirHashtags();
                        }
                        posts.add(new PostEmoticon(emoticon, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                    break;
                    case 3: // Imagen
                        String formato = v.pedirFormato();
                        int resolucion = v.pedirResolucion();
                        String url = v.pedirURL();
                        int tamanio = v.pedirTamanio();
                        autor = v.pedirAutor();
                        fechaDePublicacion = v.pedirFechaDePublicacion();
                        if(incluirHashtags()){
                            hashtags = v.pedirHashtags();
                        }
                        posts.add(new PostImagen(formato, resolucion, url, tamanio, autor, hashtags, fechaDePublicacion));
                        opcionValida = true;
                        v.mostrarPublicado();
                        v.MostrarPost(posts.get(0));
                    break;
                    case 4: // Video
                    break;
                    case 5: // Audio
                    break;
                    default:
                        v.mostrarOpcionInvalida();
                    break;
                }
            }
    }
}
