

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<pessoa> studants = new ArrayList<pessoa>();
    public static void main(String[] args) {

        boolean exit = true;
        while (exit){
            System.out.println("Seleciona a opção");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Sair");
            int option = scanner.nextInt();
            switch (option){
                case 1 :
                    addStudant(studants);
                    break;
                case 2 :
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudant(studants, nameToFind);
                    break;
                case 3 :
                    removeStudant();
                    break;
                case 4 :
                    editStudant();
                    break;


                case 5 :
                    exit = false;
                    break;
            }
        }
    }
//exclução de cadastro
    private static void removeStudant(){
        System.out.println("Qual o nome que deseja remover?");
        String name = scanner.next();
        Integer position = findStudant(studants, name);
        if(position != null){
            studants.remove(position.intValue());
        }
    }
//editor de sobreposição de nome
    private static void editStudant(){
        System.out.println("Qual o nome que deseja editar?");
        String name = scanner.next();
        Integer position = findStudant(studants, name);
        if(position != null){
            pessoa p1 = studants.get(position.intValue());
            System.out.println("Qual é o novo nome?");
            name = scanner.next();
            //studants.get(position.intValue()).name = name;
            p1.name = name;
        }
    }


    //cadastro estudante
    private static void addStudant(List<pessoa> studants){
        pessoa studant = new pessoa();
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================================");
        System.out.println("Digite o nome completo do estudante");
        studant.name = scanner.next();
        System.out.println("Sexo da pessoa cadastrada?");
        studant.sexo = scanner.next();
        System.out.println("idade do estudante?");
        studant.idade = scanner.nextInt();
        studants.add(studant);
        System.out.println("===================================");
        System.out.println("Obrigado por seu cadastro." );
        System.out.println("Nome "+ studant.name);
        System.out.println("Sexo: "+ studant.sexo);
        System.out.println("Idade: "+studant.idade);
        System.out.println("===================================");
    }
//busca por nome
    private static Integer findStudant(List<pessoa> studants, String studantName) {
        Integer position = null;
        for(int count = 0; count < studants.size(); count++){
            pessoa student = studants.get(count);
            if(student.name.equals(studantName)){
                position = count;
                System.out.println("===================================");
                System.out.println("Encontrei o " + studantName  );
                System.out.println("===================================");
            }
        }
        return position;
    }
}
