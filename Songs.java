public class Songs {
    String title;
    int plays;

    public Songs( String title, int plays){
        this.title = title;
        this.plays = plays;
    }

    public String myString(){
        return this.title + " : " + this.plays + " plays";
    }
}
