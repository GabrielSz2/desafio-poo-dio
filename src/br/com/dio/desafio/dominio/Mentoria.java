package br.com.dio.desafio.dominio;

public class Mentoria extends Conteudo{

    private String data;

    public Mentoria() {
    }
    
    public Mentoria(String nome, String descricao, String date) {
    	setTitulo(nome);
    	setDescricao(descricao);
    	setData(date);
    }

    public String getData() {
        return data;
    }

    public void setData(String string) {
        this.data = string;
    }
    
    @Override
    public double calcularXp() {
    	return XP_PADRAO + 20d;
    }

    @Override
    public String toString() {
        return  "Mentoria: {" 
        		+ getTitulo() 
        		+ ", " 
        		+ getDescricao() 
        		+ ", data = " 
        		+ data 
        		+  '}';
    }
}
