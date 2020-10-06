package app;

import dao.LojaDAO;
import model.Cachaca;
import model.Cerveja;
import model.Vinho;
import service.LojaService;

public class Principal {
    public static void main(String[] args) {
        LojaDAO lojaDAO = new LojaDAO();
        LojaService lojaService = new LojaService(lojaDAO);

        apresentacao();
        int opcao;

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1)\uD83C\uDD95Cadastrar\n2)\uD83D\uDEABRemover\n3)\uD83D\uDCD1Listar\n4)\uD83C\uDFAFModificar\n5)\uD83C\uDF7AListar Cervejas\n6)\uD83C\uDF77Vinho\n7)\uD83C\uDF78Cachaça\n0)\uD83D\uDEAASair");
            opcao = Teclado.leInt();

            switch (opcao) {
                case 1: // Cadastrar
                    imprimeOpcoes();
                    int op = Teclado.leInt();

                    switch (op) {
                        case 1:
                            if (cadastrarCerveja(lojaService))
                                System.out.println("Cerveja cadastrada com sucesso");
                            else
                                System.out.println("Não foi possível cadastrar bebida");
                            break;
                        case 2:
                            if (cadastrarVinho(lojaService))
                                System.out.println("Vinho cadastrado com sucesso");
                            else
                                System.out.println("Não foi possível cadastrar bebida");
                            break;
                        case 3:
                            if (cadastrarCachaca(lojaService))
                                System.out.println("Cachaça cadastrada com sucesso");
                            else
                                System.out.println("Não foi possível cadastrar bebida");
                            break;
                    }
                    break;
                case 2: // Remover
                    System.out.println("Digite o estilo do produto:");
                    String nome = Teclado.leString();
                    try {
                        if (lojaService.remover(nome))
                            System.out.println(nome + " removido com sucesso");
                        else
                            System.out.println("Erro! Produto não encontrado");
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3: // Listar
                    try {
                        System.out.println(lojaService.buscarTodos());
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4: // Modificar
                    String nome1 = Teclado.leString("Digite o nome da bebida:");
                    String informacao = Teclado.leString("Atualizar para:");
                    imprimeOpcoesDeAtualizacao();
                    int elemento = Teclado.leInt();
                    try {
                        if (lojaService.atualizar(nome1, informacao, elemento))
                            System.out.println(nome1 + " atualizado com sucesso");
                        else
                            System.out.println("Erro! Não foi possível atualizar Bebida");
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 5: // Listar Cervejas
                    imprimirCervejas(lojaService);
                    break;
                case 6: // Listar Vinhos
                    imprimirVinho(lojaService);
                    break;
                case 7: // Listar Cachaças
                    imprimirCachacas(lojaService);
                    break;
            }
        }

        while (opcao != 0);
        System.out.println("Saindo...\uD83D\uDE80\nMuito obrigada por usar o sistema\uD83D\uDC4B");
    }

    public static void imprimirCervejas(LojaService lojaService) {
        System.out.println(lojaService.buscarCervejas());
    }

    public static void imprimirCachacas(LojaService lojaService) {
        System.out.println(lojaService.buscarCachacas());
    }

    public static void imprimirVinho(LojaService lojaService) {
        System.out.println(lojaService.buscarVinhos());
    }


    public static void apresentacao() {
        System.out.println("****Bem-vinda a Loja de Bebidas****");
        System.out.println("Aqui tu pode manipular 3 tipos de bebidas: \uD83C\uDF7A Cerveja | 🍷 Vinho | \uD83C\uDF78 Cachaça");
    }

    public static boolean cadastrarCerveja(LojaService lojaService) {
        System.out.println("Nome da cerveja:");
        String nome = Teclado.leString();
        System.out.println("Estilo:");
        String estilo = Teclado.leString();
        System.out.println("Amargor (IBU)");
        double ibu = Teclado.leDouble();
        System.out.println("Cor da cerveja:");
        String cor = Teclado.leString();
        System.out.println("Álcool (%):");
        double alcool = Teclado.leDouble();

        Cerveja cerveja = new Cerveja(nome, estilo, ibu, cor, alcool);
        try {
            return lojaService.cadastrar(cerveja);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean cadastrarVinho(LojaService lojaService) {
        System.out.println("Nome do vinho:");
        String nome = Teclado.leString();
        System.out.println("Estilo:");
        String estilo = Teclado.leString();
        System.out.println("Tipo de uva do vinho:");
        String uva = Teclado.leString();
        System.out.println("Tipo de barril do vinho:");
        String barril = Teclado.leString();
        System.out.println("Álcool (%):");
        double alcool = Teclado.leDouble();

        Vinho vinho = new Vinho(nome, estilo, uva, barril, alcool);
        try {
            return lojaService.cadastrar(vinho);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean cadastrarCachaca(LojaService lojaService) {
        System.out.println("Nome da cachaca:");
        String nome = Teclado.leString();
        System.out.println("Estilo:");
        String estilo = Teclado.leString();
        System.out.println("Tipo de cana-de-acucar da cachaca:");
        String cana = Teclado.leString();
        System.out.println("Tipo de barril da cachaca:");
        String barril = Teclado.leString();
        System.out.println("Álcool (%):");
        double alcool = Teclado.leDouble();

        Cachaca cachaca = new Cachaca(nome, estilo, cana, barril, alcool);
        try {
            return lojaService.cadastrar(cachaca);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void imprimeOpcoes() {
        System.out.println("1. Cerveja | 2. Vinho | 3. Cahcaça");
    }

    public static void imprimeOpcoesDeAtualizacao() {
        System.out.println("1. Nome | 2. Estilo | 3. IBU/Uva/Cana | 4. Cor/Barril/Barril | 5. Álcool (%)");
    }

}