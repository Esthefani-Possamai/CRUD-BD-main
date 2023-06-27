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

public class UserHasClassBanco {
	
	public void insereUsers(Connection conexao, UserHasClass userHasClass) {
		PreparedStatement ps = null;
		String query = "INSERT INTO users_has_classes (users_id, classes_id)"
				+ "Values (?,?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1,  userHasClass.users_id);
			ps.setInt(2, userHasClass.classes_id);

			ps.execute();
			System.out.println("usuario inserido com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public List<Users> listausers(Connection conexao, int id) {
		Statement st = null;
		String query = "select users.* from classes \r\n"
				+ "join users_has_classes on users_has_classes.classes_id = classes.id \r\n"
				+ "join users on users_has_classes.users_id = users.id where classes.id ="+id;
		
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
	
	public void removeUsersForClass (Connection conexao, int id_user, int id_class) {
		PreparedStatement ps = null;
		String query = "DELETE FROM users_has_classes WHERE users_id="+id_user+" and classes_id ="+id_class;
		
		try {
			ps = conexao.prepareStatement(query);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuário removido com sucesso da turma");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
