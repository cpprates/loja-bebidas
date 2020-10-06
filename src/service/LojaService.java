package service;

import dao.LojaDAO;
import model.Bebida;
import model.Cachaca;
import model.Cerveja;
import model.Vinho;

import java.io.IOException;

public class LojaService {

    private final LojaDAO lojaDAO;

    public LojaService(LojaDAO lojaDAO) {
        this.lojaDAO = lojaDAO;
    }

    public boolean cadastrar(Bebida bebida) throws Exception {
        return lojaDAO.cadastrar(bebida);
    }

    public boolean remover(String nome) throws Exception {
        return lojaDAO.remover(nome);
    }

    public boolean atualizar(String nome, String informacao, int opcao) throws Exception {
        return lojaDAO.atualizar(nome, informacao, opcao);
    }

    public String buscarTodos() throws Exception {
        return lojaDAO.buscarTodos();
    }

    public String buscarCervejas() {
        String retorno = "";
        try {
            for (Cerveja c : lojaDAO.criarArrayCerveja()) {
                if (c != null)
                    retorno += "\n" + c.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public String buscarCachacas() {
        String retorno = "";
        try {
            for (Cachaca c : lojaDAO.criarArrayCachaca()) {
                if (c != null)
                    retorno += "\n" + c.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public String buscarVinhos() {
        String retorno = "";
        try {
            for (Vinho v : lojaDAO.criarArrayVinho()) {
                if (v != null)
                    retorno += "\n" + v.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }

}
