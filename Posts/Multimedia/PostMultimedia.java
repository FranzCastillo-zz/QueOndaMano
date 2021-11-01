package Posts.Multimedia;

import Posts.Post;
import java.util.ArrayList;
import java.util.Date;

public abstract class PostMultimedia extends Post{
    private String url;
    private int tamanio;
    public PostMultimedia(String url, int tamanio, String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        super(autor, hashtags, fechaDePublicacion);
        this.url = url;
        this.tamanio = tamanio;
    }
    protected String getURL(){
        return this.url;
    }
    protected int getTamanio(){
        return this.tamanio;
    }
    abstract public String play();
    abstract protected String getDetalles();
}