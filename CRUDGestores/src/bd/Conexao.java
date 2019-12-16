package bd;

import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import classes.Gestor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Conexao {
	
	private String url = "jdbc:postgresql://localhost/Gestao";
	private String usuario = "postgres";
	private String senha = "3128";
	private Connection conn;
        
	public Conexao() {
		conectar();
	}
	
	public void conectar() {
			try 
	        {
				Class.forName("org.postgresql.Driver");
	        } 
	        catch (ClassNotFoundException e1) 
			{
				e1.printStackTrace();
			}		
	        Properties prop = new Properties();
	        prop.setProperty("password", this.senha);
	        prop.setProperty("user", this.usuario);
            try
            {
				this.conn = DriverManager.getConnection(this.url, prop);
                                
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
                
            }
	}
	
	public Connection getConnection() 
	{
		return this.conn;
	}
	
    public void inserirGestor(String nome, String matricula, String dataNascimento, String setor) 
    {
		try 
		{
	        PreparedStatement ps = this.conn.prepareStatement("INSERT INTO gestores (nome, matricula, dataNascimento, setor) VALUES (?, ?, ?, ?);");
	        ps.setString(1, nome);
	        ps.setString(2, matricula);
	      	ps.setString(3, dataNascimento);
	      	ps.setString(4, setor);
	        ps.executeUpdate();
	        ps.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
    public ArrayList<Gestor> getGestores() throws SQLException 
    {
		try 
		{
		        PreparedStatement ps = this.conn.prepareStatement("SELECT nome,matricula,dataNascimento,setor FROM gestores;");
		        ResultSet rs=ps.executeQuery();
                
                ArrayList<Gestor> gestores=new ArrayList<Gestor>();
                boolean x=false;
                while(rs.next()){
                    x=true;
                    Gestor gestor = new Gestor();
                    gestor.setNome(rs.getString(1));
                    gestor.setMatricula(rs.getString(2));
                    gestor.setDataNascimento(rs.getString(3));
                    gestor.setSetor(rs.getString(4));
                    gestores.add(gestor);
                }
                if(x)
                    return gestores;
                else
                    return null;
                } catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
                catch(NullPointerException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                return null;
	}
	
	public void removerGestor (String matricula)
	{
		try{
			PreparedStatement ps = this.conn.prepareStatement("DELETE  FROM gestores WHERE matricula=? ;");
			ps.setString(1,matricula);
            ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
        
        
    public void alteraGestor(String matricula, Gestor atualizacao) {
            try {
                PreparedStatement ps=this.conn.prepareStatement("UPDATE gestores SET nome = ?, matricula = ?, dataNascimento = ?, setor = ? WHERE matricula = ?;");
                ps.setString(1, atualizacao.getNome());
                ps.setString(2, atualizacao.getMatricula());
                ps.setString(3, atualizacao.getDataNascimento());
                ps.setString(4, atualizacao.getSetor() );
                ps.setString(5, matricula);
                
            } catch (SQLException ex) {
            	JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        
    }

    public boolean jaExiste(String matricula) {
            try {
	                PreparedStatement ps=this.conn.prepareStatement("SELECT count(matricula) FROM gestores WHERE matricula = ?;");
	                ps.setString(1, matricula);
	                ResultSet rs=ps.executeQuery();
	                boolean x=false;
	                if(rs.getInt(1)>1) {
	                	x=true;
	                }
	                return x;
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        
        return false;
    }
    
    
     
}