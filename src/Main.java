import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	
        Curso curso1 = new Curso("java basic (Curso)", "descrição do curso java basic...", 8);
        Curso curso2 = new Curso("java script basic (Curso)", "descrição do curso javaScript basic...", 4);
        
        Mentoria mentoria = new Mentoria("java basic (mentoria)", "descrição java basic mentoria...", 
        		LocalDate.now().format(formatter));

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer...");
        bootcamp.addConteudo(curso1);
        bootcamp.addConteudo(curso2);
        bootcamp.addConteudo(mentoria);
        
        Dev devCamila = new Dev("Camila");
        
        System.out.println("Dev "+ devCamila.getNome() + ": \n");
        
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println(devCamila.toConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("---");
        System.out.println(devCamila.toConteudosInscritos());
        System.out.println(devCamila.toConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("\n-------------------------");

        Dev devJoao = new Dev("Joao");
        System.out.println("Dev "+ devJoao.getNome() + ": \n");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println(devJoao.toConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("---");
        System.out.println(devJoao.toConteudosInscritos());
        System.out.println(devJoao.toConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

    }    
}
