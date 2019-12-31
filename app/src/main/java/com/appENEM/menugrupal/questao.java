package com.appENEM.menugrupal;

public class questao {
    private String pergunta;
    private StringBuilder texto;
    private String comentario;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private Integer res;
    private Integer id;

    public String getAdional() {
        return Adional;
    }

    public void setAdional(String adional) {
        Adional = adional;
    }

    private String Adional;

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public StringBuilder getTexto() {
        return texto;
    }

    public void setTexto(StringBuilder texto) {
        this.texto = texto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public questao(String pergunta, StringBuilder texto, String comentario, String a, String b, String c, String d, String adional, String e, Integer res, Integer id) {
        A = a;
        B = b;
        C = c;
        D = d;
        Adional = adional;
        E = e;
        this.id = id;
        this.pergunta = pergunta;
        this.texto = texto;
        this.comentario = comentario;
        this.res = res;
    }

    @Override
    public String toString() {
        return "questao{" +
                "pergunta='" + pergunta + '\'' +
                ", texto=" + texto +
                ", comentario='" + comentario + '\'' +
                ", res=" + res +
                ", id=" + id +
                '}';
    }
}
