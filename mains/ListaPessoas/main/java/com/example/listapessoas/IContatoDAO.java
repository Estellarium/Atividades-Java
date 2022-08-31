package com.example.listapessoas;

import java.util.List;

public interface IContatoDAO {

    public boolean salvarContato(Contato contato);
    public boolean atualizar(Contato contato);
    public boolean deletar(Contato contato);
    public List<Contato> listar();
}
