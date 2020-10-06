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
            if (bebidas[i].getNome().equalsIgnoreCase(nome)) {
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

    public Cerveja[] criarArrayCerveja() throws IOException {
        Cerveja[] retorno = new Cerveja[lerQuantidadeLinhas()];

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
            line = br.readLine();
        }
        br.close();
        ordenarCervejaPorTeorAlcoolico(retorno);
        return retorno;
    }

    public Vinho[] criarArrayVinho() throws IOException {
        Vinho[] retorno = new Vinho[lerQuantidadeLinhas()];

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int cont = 0;
        while (line != null) {
            String[] separada = line.split("\\s\\*\\s");
            if (separada[0].equalsIgnoreCase("\uD83C\uDF77")) { // vinho
                Vinho vinho = new Vinho(separada[1], separada[2], separada[3], separada[4], Double.parseDouble(separada[5]));
                retorno[cont++] = vinho;
            }
            line = br.readLine();
        }
        br.close();
        ordenarVinhoPorTeorAlcoolico(retorno);
        return retorno;
    }

    public Cachaca[] criarArrayCachaca() throws IOException {
        Cachaca[] retorno = new Cachaca[lerQuantidadeLinhas()];

        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int cont = 0;
        while (line != null) {
            String[] separada = line.split("\\s\\*\\s");
            if (separada[0].equalsIgnoreCase("\uD83C\uDF78")) { // cachaça
                Cachaca cachaca = new Cachaca(separada[1], separada[2], separada[3], separada[4], Double.parseDouble(separada[5]));
                retorno[cont++] = cachaca;
            }
            line = br.readLine();
        }
        br.close();
        ordenarCachacaPorTeorAlcoolico(retorno);
        return retorno;
    }

    public void ordenarCervejaPorTeorAlcoolico(Cerveja[] cervejas) {
        int min = 0;
        for (Cerveja c : cervejas) {
            if (c != null) {
                for (int i = 0; i < cervejas.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < cervejas.length; j++)
                        if (cervejas[j] != null)
                            if (cervejas[j].getAlcool() < cervejas[min].getAlcool())
                                min = j;
                    Cerveja temp = cervejas[i];
                    cervejas[i] = cervejas[min];
                    cervejas[min] = temp;
                }
            }
        }
    }

    public void ordenarVinhoPorTeorAlcoolico(Vinho[] vinhos) {
        int min = 0;
        for (Vinho v : vinhos) {
            if (v != null) {
                for (int i = 0; i < vinhos.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < vinhos.length; j++)
                        if (vinhos[j] != null)
                            if (vinhos[j].getAlcool() < vinhos[min].getAlcool())
                                min = j;
                    Vinho temp = vinhos[i];
                    vinhos[i] = vinhos[min];
                    vinhos[min] = temp;
                }
            }
        }
    }

    public void ordenarCachacaPorTeorAlcoolico(Cachaca[] cachacas) {
        int min = 0;
        for (Cachaca c : cachacas) {
            if (c != null) {
                for (int i = 0; i < cachacas.length - 1; i++) {
                    min = i;
                    for (int j = i + 1; j < cachacas.length; j++)
                        if (cachacas[j] != null)
                            if (cachacas[j].getAlcool() < cachacas[min].getAlcool())
                                min = j;
                    Cachaca temp = cachacas[i];
                    cachacas[i] = cachacas[min];
                    cachacas[min] = temp;
                }
            }
        }
    }

    public int lerQuantidadeLinhas() {
        int linhas = 0;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            linhas = (int) br.lines().count();
            br.close();
            return linhas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }
}
