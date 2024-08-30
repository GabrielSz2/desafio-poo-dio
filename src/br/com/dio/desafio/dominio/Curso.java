package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    public Curso() {
    }
    
    public Curso(String nome, String descricao, int cargaHoraria) {
    	setTitulo(nome);
    	setDescricao(descricao);
    	setCargaHoraria(cargaHoraria);
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
    	return XP_PADRAO * cargaHoraria;
    }
    
    @Override
    public String toString() {
        return  '{'
        		+ "Curso: "
        		+ getTitulo() 
        		+ ", "
        		+ getDescricao() 
        		+ ", carga horaria = " 
        		+ cargaHoraria
        		+ "H"
        		+ '}';
    }
}
