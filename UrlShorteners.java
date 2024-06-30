import java.util.HashMap;
import java.util.Random;
import java.util.*;

class UrlShorteners {
    public static void main(String args[]){
        UrlShortener urlShortener = new UrlShortener();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter long URl:");
        String longUrl=sc.nextLine();
        String shortUrl=urlShortener.shortenUrl(longUrl);
        System.out.println("Shorten URL:"+shortUrl);
        System.out.println("Long URL:"+urlShortener.LongenUrl(shortUrl));
        
    }
}
public class UrlShortener {
    private HashMap<String, String> keyMap;
    private HashMap<String, String> valueMap;
    private char[] chars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private Random rando;
    private int keyLength;
    public UrlShortener(){
        this.keyMap=new HashMap<String, String>();
        this.valueMap=new HashMap<String, String>();
        this.rando= new Random();
        this.keyLength=7;
    }
    public UrlShortener(int keyLength){
        this.keyMap=new HashMap<String, String>();
        this.valueMap=new HashMap<String, String>();
        this.rando= new Random();
        this.keyLength=keyLength;
    }
    public String shortenUrl(String longUrl){
        String key=generateKey();
        keyMap.put(key, longUrl);
        valueMap.put(longUrl, key);
        return "http://smol.url/"+key;
    }
    public String LongenUrl(String shortUrl){
        String key=shortUrl.substring("http://smol.url/".length());
        String longUrl=keyMap.get(key);
        return longUrl;
    }
    private String generateKey(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<keyLength;i++)
        sb.append(chars[rando.nextInt(chars.length)]);
        return sb.toString();
        
    }
}

