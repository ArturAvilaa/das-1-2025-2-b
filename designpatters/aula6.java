package br.univille.singleton;

public class Singleton {
    //parace com uma variável global
    private static Singleton instance;
    private String segredo;

    public String getSegredo() {
        return segredo;
    }
    public void setSegredo(String segredo) {
        this.segredo = segredo;
    }
    private Singleton(){
        System.out.println("Singleon: Construtor");
    }
    public static Singleton getInstance(){
        System.out.println("Singleon: getInstance");
        if (instance == null){
            System.out.println("Singleon: NEW");
            instance = new Singleton();
        }
        return instance;
    }
}
