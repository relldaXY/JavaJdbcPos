package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Conexao {
	Connection c = null;
	Statement stmt = null;
	
	public void conectarComBD(String nomeBD , String senha){
		try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+nomeBD+"","postgres", senha);
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Conexão realizada com sucesso");
	}
	
	public DefaultTableModel mostrarOsCadastrados(){
		
		
		String colunas [] = {"id", "name","age","address","salary"};
		DefaultTableModel modeloCadastro = new DefaultTableModel(null, colunas);
		String dados [] = new String[5];
		String sql = "select * from pari";
		java.sql.PreparedStatement pst;
		System.out.println("Aqui");
		try{	
			pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				dados[0]= rs.getString("id");
				dados[1]= rs.getString("name");
				dados[2]= rs.getString("age");
				dados[3]= rs.getString("address");
				dados[4]= rs.getString("salary");
				
				modeloCadastro.addRow(dados);
		}
		
		return modeloCadastro;
		
		}catch(SQLException e){
			e.printStackTrace();
			
			return null;
		}
	}
	
	
	
	public void criarTabela(String nomeDaTabela){
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        String sql = "CREATE TABLE"+" "+nomeDaTabela+" "+
                     "(ID SERIAL PRIMARY KEY  NOT NULL," +
                     " NAME           TEXT    NOT NULL, " +
                     " AGE            INT     NOT NULL, " +
                     " ADDRESS        CHAR(50), " +
                     " SALARY         REAL)";
        try {
			stmt.executeUpdate(sql);
			stmt.close();
	        c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println("Table created successfully");
	}
	
	public void inserirNaTabela(String nomeDaTabela, String nome, int idade, String cidade, float salario){
		try {
			stmt = c.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        String sql = "INSERT INTO "+nomeDaTabela+" (ID,NAME,AGE,ADDRESS,SALARY) "
              + "VALUES ( DEFAULT,'"+nome+"',"+ idade +", '"+cidade+"', "+salario+" );";
        try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

        try {
			stmt.close();
			//c.commit();
	        c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        System.out.println("Records created successfully");	
	}
	
	public void selectionTable(String tabela){
		try{
		stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tabela + ";" );
        while (rs.next()) {
           int id = rs.getInt("id");
           String  name = rs.getString("name");
           int age  = rs.getInt("age");
           String  address = rs.getString("address");
           float salary = rs.getFloat("salary");
           System.out.println( "ID = " + id );
           System.out.println( "NAME = " + name );
           System.out.println( "AGE = " + age );
           System.out.println( "ADDRESS = " + address );
           System.out.println( "SALARY = " + salary );
           System.out.println();
        }
        rs.close();
        stmt.close();
        c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("Operation done successfully");
	}
	
	public void updateTable(){
		try{
		stmt = c.createStatement();
        String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
        stmt.executeUpdate(sql);     
        stmt.close();
        c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
public void delete(){
		try{
		stmt = c.createStatement();
        String sql = "DELETE FROM COMPANY where id = 2;";
        stmt.executeUpdate(sql);     
        stmt.close();
        c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
}




