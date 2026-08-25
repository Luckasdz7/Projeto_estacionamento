/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Pessoa;
import MODEL.Veiculo;
import UTIL.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class DAOveiculos {
    
    Connection conn;
    public DAOveiculos(){
        conn = new Conexao().conectar();
    }
    public void Salvar(Veiculo v ){
        String sql = "insert into Veiculo(modelo,marca,placa,ano,idpessoa) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getMarca());
            stmt.setString(3, v.getPlaca());
            stmt.setInt(4, v.getAno());
             stmt.setInt(5, v.getPessoa().getIdpessoa());
            stmt.execute();
              JOptionPane.showMessageDialog(null, "Sucesso ao Salvar Dados");
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao Salvar Dados");
        }
    }
    
    public void Atualizar(Veiculo v ){
        String sql = "UPDATE Veiculo SET modelo = ? ,marca= ? ,placa = ? ,ano = ? ,idpessoa = ? WHERE idveiculo = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getMarca());
            stmt.setString(3, v.getPlaca());
            stmt.setInt(4, v.getAno());
             stmt.setInt(5, v.getPessoa().getIdpessoa());
             stmt.setInt(6, v.getIdveiculo());
            stmt.execute();
              JOptionPane.showMessageDialog(null, "Sucesso ao Atualizar Dados");
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao Atualizar Dados");
        }
    }
    public void excluir(int id){
        String sql ="DELETE FROM Veiculo WHERE idveiculo = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Sucesso ao excluir Dados");
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao excluir Dados");
        }
    }
    
    public Veiculo buscarporid(int id){
    
        Veiculo v= null;
        String sql ="SELECT * FROM Veiculo WHERE idveiculo = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                v = mapear(rs);
            }
            JOptionPane.showMessageDialog(null, "Sucesso ao BUSCAR Dados");
            return v;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao BUSCAR Dados");
           return null;
        }
    
    }
    
    public Veiculo buscarporplaca(String placa){
    
        Veiculo v= null;
        String sql ="SELECT * FROM Veiculo WHERE placa = ? ";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                v = mapear(rs);
            }
            JOptionPane.showMessageDialog(null, "Sucesso ao BUSCAR Dados");
            return v;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao BUSCAR Dados");
           return null;
        }
    }
    
    public  List<Veiculo> VeiculoporPessoa(String cpf){
    
        List<Veiculo> lista = new ArrayList<>();
        String sql ="SELECT * FROM Veiculo JOIN Pessoa ON Veiculo.idpessoa = Pessoa.idpessoa WHERE Pessoa.cpf = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                lista.add(mapear(rs));
            }
            JOptionPane.showMessageDialog(null, "Sucesso ao BUSCAR Dados");
            return lista;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao BUSCAR Dados");
           return null;
        }
    }
    
       public List<Veiculo> getVeiculoModelo(String conteudo) {
    List<Veiculo> lstP = new ArrayList<>();
    ResultSet rs;
    try{
        PreparedStatement ppStmt = conn.prepareStatement
        ("SELECT * FROM Veiculo WHERE modelo LIKE ? ");
        //SELECT * FROM pessoa WHERE placa LIKE ?
        
        ppStmt.setString(1, conteudo + "%");
       
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
      public  List<Veiculo> getVeiculoPlaca(String conteudo) {
    List<Veiculo> lstP = new ArrayList<>();
    ResultSet rs;
    try{
        PreparedStatement ppStmt = conn.prepareStatement
        ("SELECT * FROM Veiculo WHERE placa LIKE ?");
        
        
        ppStmt.setString(1, conteudo + "%");
       
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
    
    
    private Veiculo mapear(ResultSet rs){
        Veiculo v = new Veiculo();
        
        Pessoa p;
        try{
            PessoaDAO dao = new PessoaDAO();
             v.setIdveiculo(rs.getInt("idveiculo"));
             v.setModelo(rs.getString("modelo"));
             v.setMarca(rs.getString("marca"));
             v.setPlaca(rs.getString("placa"));
             v.setAno(rs.getInt("ano"));
             
             int idpessoa = rs.getInt("idpessoa");
             p = dao.BuscarporId(idpessoa);
             v.setPessoa(p);
            
             return v;
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro ao mapear Dados");
           JOptionPane.showMessageDialog(null, e.getMessage());
           return null;
        }
       
        
    }
}
