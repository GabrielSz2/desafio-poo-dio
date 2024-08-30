package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
	
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String name) {
    	this.nome = name;
    }
    
    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
    
    public String toConteudosInscritos() {
            StringBuilder sb = new StringBuilder();
            sb.append("Conteúdos inscritos: \n");
            for (Conteudo ct : conteudosInscritos) {
                sb.append("- ").append(ct.getTitulo()).append(" \n");
            }
         
            if (conteudosInscritos.isEmpty()) {
            	sb.setLength(0);
            	sb.append("Conteudos inscritos: \n");
                sb.append("vazio! \n");
            }
            return sb.toString();
    }
    
    public String toConteudosConcluidos() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Conteúdos concluidos: \n");
        for (Conteudo ct : conteudosConcluidos) {
            sb.append("- ").append(ct.getTitulo()).append(" \n");
        }
        if (conteudosConcluidos.isEmpty()) {
        	sb.setLength(0);
        	sb.append("Conteudos concluidos: \n");
            sb.append("vazio! \n");
        }
       
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
