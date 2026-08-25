/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Pessoa;
import UTIL.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class PessoaDAO {
    
    Connection conn;
    public PessoaDAO(){
        conn = new Conexao().conectar();
    }
    
    public Pessoa Salvar(Pessoa p ){
        String sql = "insert into Pessoa(nome,cpf) VALUES (?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){  
                p.setIdpessoa(rs.getInt(1));
            }else{
                p.setIdpessoa(-1);
            }
           
              JOptionPane.showMessageDialog(null, "Sucesso ao Salvar Dados");
               
              
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados");
           JOptionPane.showMessageDialog(null, e.getErrorCode());//, 
           JOptionPane.showMessageDialog(null, e.getMessage());
          
        }
        return p;
    }
    
    public int Atualizar(Pessoa p ){
        String sql = "UPDATE Pessoa SET nome = ?, cpf = ? WHERE idpessoa = ?";
        int verifc = 0;
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setInt(3, p.getIdpessoa());
            verifc  = stmt.executeUpdate();//retorna as linhas editadas, se nao fez nada retorna -1
            
              JOptionPane.showMessageDialog(null, "Sucesso ao Atualizar Dados");
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Erro ao Atualizar Dados");
        }
        return verifc;
    }
    public int excluir(Pessoa p){
        int verif = 0;

        try{
    
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM pessoa WHERE idpessoa = ?");
            stmt.setInt(1, p.getIdpessoa());
            verif = stmt.executeUpdate();

        }

        catch(SQLException ex){
    ex.printStackTrace();

        }

        return verif;
       
    }
    public Pessoa BuscarporId(int id){
         String sql = "SELECT * FROM Pessoa WHERE idpessoa = ?";
         Pessoa p = null;
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                p = mapear(rs);
            }
            
            //JOptionPane.showMessageDialog(null, "Sucesso ao buscar Dados");
            return p;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados");
           return null;
        }
    }
    public Pessoa Buscarporcpf(String cpf){
        
        String sql = "SELECT * FROM Pessoa WHERE cpf = ?";
         Pessoa p = null;
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                p = mapear(rs);
            }
            
           // JOptionPane.showMessageDialog(null, "Sucesso ao buscar Dados");
            return p;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados");
           return null;
        }
    }
    public List<Pessoa> getPessoas(String conteudo) {
    List<Pessoa> lstP = new ArrayList<>();
    ResultSet rs;
    try{
        PreparedStatement ppStmt = conn.prepareStatement
        ("SELECT * FROM pessoa WHERE nome LIKE ? OR cpf = ?");
        
        ppStmt.setString(1, conteudo + "%");
        ppStmt.setString(2, conteudo);
        rs = ppStmt.executeQuery();
        
        while(rs.next()){
            lstP.add(mapear(rs));
        }
    }
    catch(SQLException ex){
        ex.printStackTrace();
    }
    return lstP;
}
    private Pessoa mapear(ResultSet rs){
        Pessoa p = new Pessoa();
        try{
             p.setIdpessoa(rs.getInt("idpessoa"));
             p.setNome(rs.getString("nome"));
             p.setCpf(rs.getString("cpf"));
             return p;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao mapear Dados");
           return null;
        }
       
        
    }
}
