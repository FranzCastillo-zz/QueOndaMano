package Posts.Multimedia;

import java.util.ArrayList;
import java.util.Date;

public class PostVideo extends PostMultimedia {
    private int frameRate;

    public PostVideo(int frameRate, String url, int tamanio, String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        super(url, tamanio, autor, hashtags, fechaDePublicacion);
        this.frameRate = frameRate;
    }
    protected String getDetalles(){
        String detalles = "Detalles: " + this.getTamanio() + " KB, Frame Rate:" + this.frameRate + "\n";
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
        post += "(video) " + this.getURL() + "\n\n";
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
        String play = "*se esta reproduciendo este video (" + this.getURL() + ") a " + this.frameRate + " fps*";
        return play;
    }
}
