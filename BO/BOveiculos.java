/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.DAOveiculos;
import MODEL.Pessoa;
import MODEL.Veiculo;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class BOveiculos {
    DAOveiculos dao = new DAOveiculos();
   public void Salvar(Veiculo v ){
       dao.Salvar(v);
   }
   public void Atualizar(Veiculo v){
       dao.Atualizar(v);
   }
   public void Excluir(int id){
       dao.excluir(id);
  }
   public Veiculo buscarporplaca(String placa){
       return dao.buscarporplaca(placa);
   }
   public Veiculo buscarporid(int id){
       return  dao.buscarporid(id);
   }
   public List<Veiculo> VeiculoporPessoa(String cpf){
       return dao.VeiculoporPessoa(cpf);
   }
   public List<Veiculo> getVeiculoModelo(String conteudo){
       return dao.getVeiculoModelo(conteudo);
   }
   public List<Veiculo> getVeiculoPlaca(String conteudo){
       return dao.getVeiculoPlaca(conteudo);
   }
}
