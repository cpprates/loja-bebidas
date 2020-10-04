package service;

import dao.LojaDAO;
import model.Bebida;

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

    public boolean atualizar(String nome, String informacao) throws Exception {
        return lojaDAO.atualizar(nome, informacao);
    }

    public String buscarTodos() throws Exception {
        return lojaDAO.buscarTodos();
    }

}
