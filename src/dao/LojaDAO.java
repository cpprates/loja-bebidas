package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import exception.ProductNotFoundException;
import model.Bebida;
import model.Cachaca;
import model.Cerveja;
import model.Vinho;

public class LojaDAO {

    private final String fileName = "./src/relatorios/relatorioProdutos.txt";

    public boolean cadastrar(Bebida bebida) throws IOException, ProductNotFoundException {
        if (bebida == null) {
            throw new ProductNotFoundException();
        }
        
        File f = new File(fileName);
        FileWriter fr = new FileWriter(f);
        fr.write("\n******************************");
        fr.write("\n");
        if (bebida instanceof Cerveja)
            fr.write(((Cerveja) bebida).toString());
        if (bebida instanceof Vinho)
            fr.write(((Vinho) bebida).toString());
        if (bebida instanceof Cachaca)
            fr.write(((Cachaca) bebida).toString());
        fr.write("\n");
        fr.write("\n******************************");
        fr.close();

        return true;

    }

    public String buscarTodos() throws IOException {
        String retorno = "";
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line != null) {
            retorno += line;
            line = br.readLine();
        }
        br.close();
        return retorno;
    }

    public boolean remover(String nome) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        String[] separada = line.split(":\\s");

        while (line != null) {

            if (separada[1].equalsIgnoreCase(nome)) {
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f);
                fw.write("EXCLUIDO");
                fw.close();
                return true;
            }
            line = br.readLine();
        }
        br.close();
        return false;
    }

    public boolean atualizar(String nome, String informacao) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        String[] separada = line.split(":\\s");

        while (line != null) {

            if (separada[1].equalsIgnoreCase(nome)) {
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f);
                fw.write(informacao);
                fw.close();
                return true;
            }
            line = br.readLine();
        }
        br.close();
        return false;
    }
}
