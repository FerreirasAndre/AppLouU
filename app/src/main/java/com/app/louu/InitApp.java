package com.app.louu;
import java.util.ArrayList;

abstract public class InitApp {
    private ArrayList<String> palavras = new ArrayList();

    public ArrayList<String> getPalavras() {
        return palavras;
    }

    public void setPalavras(ArrayList<String> palavras) {
        this.palavras = palavras;
    }
}
