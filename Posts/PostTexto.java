package Posts;

import java.util.ArrayList;
import java.util.Date;

public class PostTexto extends Post{
    private String mensaje;

    public PostTexto(String mensaje, String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        super(autor, hashtags, fechaDePublicacion);
        this.mensaje = mensaje;
    }
    public String getPost(){
        String post = "";
        post += "-------------------------------------------------\n";
        post += this.getAutor() + " publico el " + this.getFechaDePublicacion() + "\n";
        post += "Hashtags: ";
        for (String hashtag : this.getHashtags()) {
            post += hashtag + " ";
        }
        post += "\n";
        post += "Likes: " + this.getLikes() + "\n\n";
        post += "(texto) " + this.mensaje + "\n\n";
        post += ">>>>> Comentarios:\n";
        int i = 1;
        for (String comentario : this.getComentarios()) {
            post += "(" + i++ + ")\t" + comentario + "\n";
        }
        post += "-------------------------------------------------\n";
        return post;
    }
    public String getEncabezado(){
        String encabezado = "(Texto) De " + this.getAutor() + ". Publicdo el: " + this.getFechaDePublicacion();
        return encabezado;
    }
    public String play(){
        String texto = "(texto) " + this.mensaje + "\n\n";
        return texto;
    }
}
