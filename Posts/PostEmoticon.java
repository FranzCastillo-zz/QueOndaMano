package Posts;

import java.util.ArrayList;
import java.util.Date;

public class PostEmoticon extends Post{
    private String emoticon;

    public PostEmoticon(String emoticon, String autor, Date fechaDePublicacion){
        super(autor, fechaDePublicacion);
        this.emoticon = emoticon;
    }
    public PostEmoticon(String mensaje, ArrayList<String> hashtags, String autor, Date fechaDePublicacion){
        super(autor, hashtags, fechaDePublicacion);
        this.emoticon = mensaje;
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
        post += "(emoticon) " + this.emoticon + "\n\n";
        post += ">>>>> Comentarios:\n";
        int i = 1;
        for (String comentario : this.getComentarios()) {
            post += "(" + i++ + ")\t" + comentario + "\n";
        }
        return post;
    }
}
