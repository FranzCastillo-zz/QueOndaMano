package Posts.Multimedia;

import java.util.ArrayList;
import java.util.Date;

public class PostImagen extends PostMultimedia {
    private String formato;
    private int resolucion;

    public PostImagen(String formato, int resolucion, String url, int tamanio, String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        super(url, tamanio, autor, hashtags, fechaDePublicacion);
        this.formato = formato;
        this.resolucion = resolucion;
    }
    protected String getDetalles(){
        String detalles = "Detalles: " + this.getTamanio() + " KB, " + this.formato + ", " + this.resolucion + " mpx\n";
        return detalles;
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
        post += "(imagen) " + this.getURL() + "\n\n";
        post += ">>>>> Comentarios:\n";
        int i = 1;
        for (String comentario : this.getComentarios()) {
            post += "(" + i++ + ")\t" + comentario + "\n";
        }
        post += this.getDetalles();
        post += "-------------------------------------------------\n";
        return post;
    }
    public String play(){
        String play = "*se esta mostrando esta imagen (" + this.getURL() + ") con " + this.resolucion + " megapixeles de resolucion*";
        return play;
    }
}
