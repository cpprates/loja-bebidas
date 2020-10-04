package app;

import java.util.Scanner;

import dao.LojaDAO;
import model.Cachaca;
import model.Cerveja;
import model.Vinho;
import service.LojaService;

public class Principal {
    public static void main(String[] args) {
        // LojaDAO lojaDAO = new LojaDAO();
        // LojaService lojaService = new LojaService(lojaDAO);

        apresentacao();

    }

    public static void apresentacao() {
        System.out.println("****Bem-vinda a Loja de Bebidas****");
        System.out.println("Aqui tu pode manipular 3 tipos de bebidas:\n1) Cerveja\n2) Vinho\n3) Cachaca");
        System.out.println("É possível cadastrar, remover, listar e modificar esses produtos.");
    }

    public static boolean cadastrarCerveja(LojaService lojaService) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome da cerveja:");
        String nome = scanner.nextLine();
        System.out.println("Estilo:");
        String estilo = scanner.nextLine();
        System.out.println("Tipo de malte da cerveja:");
        String malte = scanner.nextLine();
        System.out.println("Tipo de fermento da cerveja:");
        String fermento = scanner.nextLine();
        System.out.println("Tipo de lúpulo da cerveja:");
        String lupulo = scanner.nextLine();
        scanner.close();

        Cerveja cerveja = new Cerveja(nome, estilo, malte, fermento, lupulo);
        return lojaService.cadastrar(cerveja);
    }

    public static boolean cadastrarVinho(LojaService lojaService) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do vinho:");
        String nome = scanner.nextLine();
        System.out.println("Estilo:");
        String estilo = scanner.nextLine();
        System.out.println("Tipo de uva do vinho:");
        String uva = scanner.nextLine();
        System.out.println("Tipo de barril do vinho:");
        String barril = scanner.nextLine();
        scanner.close();

        Vinho vinho = new Vinho(nome, estilo, uva, barril);
        return lojaService.cadastrar(vinho);
    }

    public static boolean cadastrarCachaca(LojaService lojaService) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome da cachaca:");
        String nome = scanner.nextLine();
        System.out.println("Estilo:");
        String estilo = scanner.nextLine();
        System.out.println("Tipo de cana-de-acucar da cachaca:");
        String cana = scanner.nextLine();
        System.out.println("Tipo de barril da cachaca:");
        String barril = scanner.nextLine();
        scanner.close();

        Cachaca cachaca = new Cachaca(nome, estilo, cana, barril);
        return lojaService.cadastrar(cachaca);
    }

}