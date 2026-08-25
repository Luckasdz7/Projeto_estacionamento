/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.PessoaDAO;
import MODEL.Pessoa;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class BOpessoa {
    PessoaDAO dao = new PessoaDAO();
    public Pessoa Salvar(Pessoa p ){
        return dao.Salvar(p);
    }
    public int Atualizar(Pessoa p ){
         return dao.Atualizar(p);
    }
    public int Excluir(Pessoa p  ){
        return  dao.excluir(p);
    }
    public Pessoa BuscarporId(int id ){
        return dao.BuscarporId(id);
    }
    public Pessoa Buscarporcpf(String cpf){
       return dao.Buscarporcpf(cpf);
    }
    public List<Pessoa> getPessoas(String conteudo){
        return dao.getPessoas(conteudo);
    }
}
