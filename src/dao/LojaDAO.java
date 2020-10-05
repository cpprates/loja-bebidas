package dao;

import exception.ProductNotFoundException;
import model.Bebida;
import model.Cachaca;
import model.Cerveja;
import model.Vinho;

import java.io.*;

public class LojaDAO {

    private final String fileName = "./src/relatorios/relatorioProdutos.txt";

    public boolean cadastrar(Bebida bebida) throws IOException, ProductNotFoundException {
        if (bebida == null) {
            throw new ProductNotFoundException();
        }

        File f = new File(fileName);
        FileWriter fw = new FileWriter(f, true);

        if (bebida instanceof Cerveja)
            fw.write(((Cerveja) bebida).toString());
        if (bebida instanceof Vinho)
            fw.write(((Vinho) bebida).toString());
        if (bebida instanceof Cachaca)
            fw.write(((Cachaca) bebida).toString());
        fw.write("\n");
        fw.close();

        return true;

    }

    public String buscarTodos() throws IOException {
        String retorno = "";
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line != null) {
            retorno += "\n" + line;
            line = br.readLine();
        }
        br.close();
        return retorno;
    }

    public boolean remover(String nome) throws IOException {
        Bebida[] bebidas = criarArray();
        boolean encontrou = false;
        for (int i = 0; i < bebidas.length; i++) {
            if (bebidas[i].getEstilo().equalsIgnoreCase(nome)) {
                bebidas[i] = null;
                encontrou = true;
                break;
            }
        }
        if (encontrou) {
            atualizarDocumento(bebidas);
            return true;
        }
        return false;
    }

    public boolean atualizar(String nome, String informacao, int opcao) throws IOException {
        Bebida[] bebidas = criarArray();
        boolean encontrou = false;
        for (int i = 0; i < bebidas.length; i++) {
            if (bebidas[i].getEstilo().equalsIgnoreCase(nome)) {
                switch (opcao) {
                    case 1:
                        bebidas[i].setNome(informacao);
                        encontrou = true;
                        break;
                    case 2:
                        bebidas[i].setEstilo(informacao);
                        encontrou = true;
                        break;
                    case 3:
                        if (bebidas[i] instanceof Cerveja) {
                            ((Cerveja) bebidas[i]).setIbu(Double.parseDouble(informacao));
                            encontrou = true;
                            break;
                        }
                        if (bebidas[i] instanceof Cachaca) {
                            ((Cachaca) bebidas[i]).setCana(informacao);
                            encontrou = true;
                            break;
                        }
                        if (bebidas[i] instanceof Vinho) {
                            ((Vinho) bebidas[i]).setUva(informacao);
                            encontrou = true;
                            break;
                        }
                        break;
                    case 4:
                        if (bebidas[i] instanceof Cerveja) {
                            ((Cerveja) bebidas[i]).setCor(informacao);
                            encontrou = true;
                            break;
                        }
                        if (bebidas[i] instanceof Cachaca) {
                            ((Cachaca) bebidas[i]).setBarril(informacao);
                            encontrou = true;
                            break;
                        }
                        if (bebidas[i] instanceof Vinho) {
                            ((Vinho) bebidas[i]).setBarril(informacao);
                            encontrou = true;
                            break;
                        }
                        break;
                    case 5:
                        if (bebidas[i] instanceof Cerveja) {
                            ((Cerveja) bebidas[i]).setAlcool(Double.parseDouble(informacao));
                            encontrou = true;
                            break;
                        }
                        if (bebidas[i] instanceof Cachaca) {
                            ((Cachaca) bebidas[i]).setAlcool(Double.parseDouble(informacao));
                            encontrou = true;
                            break;
                        }
                        if (bebidas[i] instanceof Vinho) {
                            ((Vinho) bebidas[i]).setAlcool(Double.parseDouble(informacao));
                            encontrou = true;
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if (encontrou) {
            atualizarDocumento(bebidas);
            return true;
        }
        return false;
    }

    public void atualizarDocumento(Bebida[] bebidas) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);

        for (Bebida bebida : bebidas) {
            if (bebida != null) {
                cadastrar(bebida);
            }
        }
        fw.close();
    }

    public Bebida[] criarArray() throws IOException {
        Bebida[] retorno = new Bebida[lerQuantidadeLinhas()];

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int cont = 0;
        while (line != null) {
            String[] separada = line.split("\\s\\*\\s");
            if (separada[0].equalsIgnoreCase("\uD83C\uDF7A")) { // cerveja
                Cerveja cerveja = new Cerveja(separada[1], separada[2], Double.parseDouble(separada[3]), separada[4], Double.parseDouble(separada[5]));
                retorno[cont++] = cerveja;
            }
            if (separada[0].equalsIgnoreCase("\uD83C\uDF78")) { // cachaça
                Cachaca cachaca = new Cachaca(separada[1], separada[2], separada[3], separada[4], Double.parseDouble(separada[5]));
                retorno[cont++] = cachaca;
            }
            if (separada[0].equalsIgnoreCase("\uD83C\uDF77")) { // vinho
                Vinho vinho = new Vinho(separada[1], separada[2], separada[3], separada[4], Double.parseDouble(separada[5]));
                retorno[cont++] = vinho;
            }
            line = br.readLine();
        }
        br.close();
        return retorno;
    }

    public int lerQuantidadeLinhas() throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        int linhas = (int) br.lines().count();
        br.close();
        return linhas;
    }
}
