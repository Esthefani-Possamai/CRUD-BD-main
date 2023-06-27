package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

public class UsersBanco {

	public void insereUsers(Connection conexao, Users users) {
		PreparedStatement ps = null;
		String query = "INSERT INTO users (name, cod_person, email, fone_number, cpf, spaces_id)"
				+ "Values (?,?,?,?,?,?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1,  users.name);
			ps.setInt(2, users.cod_person);
			ps.setString(3, users.email);
			ps.setString(4, users.fone_number);
			ps.setString(5, users.cpf);
			ps.setInt(6, users.spaces_id);
			ps.execute();
			System.out.println("usuario inserido com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public List<Users> listausers(Connection conexao) {
		Statement st = null;
		String query = "SELECT * FROM users";
		List<Users> userList = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			Resultset rs = (Resultset) st.executeQuery(query);
			
			while(((ResultSet) rs).next()) {
				
				Users users = new Users();
				users.id = ((ResultSet) rs).getInt("id");
				users.name = ((ResultSet) rs).getString("name");
				users.cod_person = ((ResultSet) rs).getInt("cod_person");
				users.email = ((ResultSet) rs).getString("email");
				users.fone_number = ((ResultSet) rs).getString("fone_number");
				users.cpf = ((ResultSet) rs).getString("cpf");
				users.spaces_id = ((ResultSet) rs).getInt("spaces_id");
				
	            userList.add(users);
			}
			
			System.out.println(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return userList;
		}
	
	public Users findUsers(Connection conexao, int id) {
	    Statement st = null;
	    String query = "SELECT * FROM users WHERE cod_person = " + id;
	    Users users = new Users();

	    try {
	        st = conexao.createStatement();
	        ResultSet rs = st.executeQuery(query);

	        if (rs.next()) {
	            users.id = rs.getInt("id");
	            users.name = rs.getString("name");
	            users.cod_person = rs.getInt("cod_person");
	            users.email = rs.getString("email");
	            users.fone_number = rs.getString("fone_number");
	            users.cpf = rs.getString("cpf");
	            users.spaces_id = rs.getInt("spaces_id");

	        }
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	    return users;
	}
	
	public void updateUsers(Connection conexao, Users users) {
		PreparedStatement ps = null;
		String query = "UPDATE users SET name=?, cod_person=?, email=?, fone_number=?, cpf=?, spaces_id=? WHERE cod_person="+users.cod_person;
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1,  users.name);
			ps.setInt(2, users.cod_person);
			ps.setString(3, users.email);
			ps.setString(4, users.fone_number);
			ps.setString(5, users.cpf);
			ps.setInt(6, users.spaces_id);
			ps.execute();
			System.out.println("usuario inserido com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(query);
	}
	
	public void removeUsers (Connection conexao, int codigo) {
		PreparedStatement ps = null;
		String query = "DELETE FROM users WHERE cod_person = ? ";
		
		try {
			ps = conexao.prepareStatement(query);;
			ps.setInt(1, codigo);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	

}
