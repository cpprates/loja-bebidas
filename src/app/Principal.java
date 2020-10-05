package app;

import dao.LojaDAO;
import model.Cachaca;
import model.Cerveja;
import model.Vinho;
import service.LojaService;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        LojaDAO lojaDAO = new LojaDAO();
        LojaService lojaService = new LojaService(lojaDAO);
        Scanner scanner = new Scanner(System.in);

        apresentacao();
        int opcao = 0;
        while (opcao < 1 || opcao > 5) {
            System.out.println("O que deseja fazer?");
            opcao = Integer.parseInt(scanner.nextLine());
        }

        while (opcao != 5) {

            if (opcao == 1) { // Cadastrar
                int op = 0;
                while (op < 1 || op > 3) {
                    imprimeOpcoes();
                    op = Integer.parseInt(scanner.nextLine());
                }
                switch (op) {
                    case 1:
                        try {
                            if (cadastrarCerveja(lojaService)) {
                                System.out.println("Cerveja cadastrada com sucesso");
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    case 2:
                        try {
                            if (cadastrarVinho(lojaService)) {
                                System.out.println("Vinho cadastrado com sucesso");
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    case 3:
                        try {
                            if (cadastrarCachaca(lojaService)) {
                                System.out.println("Cachaça cadastrada com sucesso");
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    default:
                        break;
                }

            }

            if (opcao == 2) { // Remover
                System.out.println("Digite o nome do produto:");
                String nome = scanner.nextLine();
                try {
                    if (lojaService.remover(nome))
                        System.out.println(nome + " removido com sucesso");
                    else
                        System.out.println("Erro! Produto não encontrado");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (opcao == 3) { // Listar
                try {
                    System.out.println(lojaService.buscarTodos());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (opcao == 4) { // Modificar
                String nome = scanner.nextLine();
                String informacao = scanner.nextLine();
                imprimeOpcoesDeAtualizacao();
                int elemento = scanner.nextInt();
                try {
                    if (lojaService.atualizar(nome, informacao, elemento)) {
                        System.out.println(nome + " atualizado com sucesso");
                        break;
                    }
                    System.out.println("Erro! Não foi possível atualizar Bebida");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\n1)\uD83C\uDD95Cadastrar\n2)\uD83D\uDEABRemover\n3)\uD83D\uDCD1Listar\n4)\uD83C\uDFAFModificar\n5)\uD83D\uDEAASair");
            opcao = scanner.nextInt();
            while (opcao < 1 || opcao > 5) {
                opcao = Integer.parseInt(scanner.nextLine());
            }
        }
        scanner.close();
        System.out.println("Saindo...\uD83D\uDE80\nMuito obrigada por usar o sistema\uD83D\uDC4B");
    }

    public static void apresentacao() {
        System.out.println("****Bem-vinda a Loja de Bebidas****");
        System.out.println("Aqui tu pode manipular 3 tipos de bebidas: 1)\uD83C\uDF7A Cerveja | 2)🍷 Vinho | 3)\uD83C\uDF78 Cachaça");
        System.out.println("É possível\n1)\uD83C\uDD95Cadastrar\n2)\uD83D\uDEABRemover\n3)\uD83D\uDCD1Listar\n4)\uD83C\uDFAFModificar\n5)\uD83D\uDEAASair");
//        System.out.println("O que deseja fazer?");
    }

    public static boolean cadastrarCerveja(LojaService lojaService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome da cerveja:");
        String nome = sc.nextLine();
        System.out.println("Estilo:");
        String estilo = sc.nextLine();
        System.out.println("Amargor (IBU)");
        double ibu = Double.parseDouble(sc.nextLine());
        System.out.println("Cor da cerveja:");
        String cor = sc.nextLine();
        System.out.println("Álcool (%):");
        double alcool = Double.parseDouble(sc.nextLine());
        sc.close();

        Cerveja cerveja = new Cerveja(nome, estilo, ibu, cor, alcool);
        return lojaService.cadastrar(cerveja);
    }

    public static boolean cadastrarVinho(LojaService lojaService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do vinho:");
        String nome = sc.nextLine();
        System.out.println("Estilo:");
        String estilo = sc.nextLine();
        System.out.println("Tipo de uva do vinho:");
        String uva = sc.nextLine();
        System.out.println("Tipo de barril do vinho:");
        String barril = sc.nextLine();
        System.out.println("Álcool (%):");
        double alcool = Double.parseDouble(sc.nextLine());
        sc.close();

        Vinho vinho = new Vinho(nome, estilo, uva, barril, alcool);
        return lojaService.cadastrar(vinho);
    }

    public static boolean cadastrarCachaca(LojaService lojaService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome da cachaca:");
        String nome = sc.nextLine();
        System.out.println("Estilo:");
        String estilo = sc.nextLine();
        System.out.println("Tipo de cana-de-acucar da cachaca:");
        String cana = sc.nextLine();
        System.out.println("Tipo de barril da cachaca:");
        String barril = sc.nextLine();
        System.out.println("Álcool (%):");
        double alcool = Double.parseDouble(sc.nextLine());
        sc.close();

        Cachaca cachaca = new Cachaca(nome, estilo, cana, barril, alcool);
        return lojaService.cadastrar(cachaca);
    }

    public static void imprimeOpcoes() {
        System.out.println("1. Cerveja | 2. Vinho | 3. Cahcaça");
    }

    public static void imprimeOpcoesDeAtualizacao() {
        System.out.println("1. Nome | 2. Estilo | 3. IBU/Uva/Cana | 4. Cor/Barril/Barril | 5. Álcool (%)");
    }

}