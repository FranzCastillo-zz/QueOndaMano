package Posts;

import java.util.ArrayList;
import java.util.Date;

public class PostTexto extends Post{
    private String mensaje;

    public PostTexto(String mensaje, String autor, Date fechaDePublicacion){
        super(autor, fechaDePublicacion);
        this.mensaje = mensaje;
    }
    public PostTexto(String mensaje, ArrayList<String> hashtags, String autor, Date fechaDePublicacion){
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
        post += "Likes: " + this.getLikes() + "\n";
        post += "(texto) " + this.mensaje + "\n\n";
        post += ">>>>> Comentarios:\n";
        int i = 1;
        for (String comentario : this.getComentarios()) {
            post += "(" + i++ + ")\t" + comentario + "\n";
        }
        return post;
    }
}
