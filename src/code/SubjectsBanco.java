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

public class SubjectsBanco {

	public void insereSubjects(Connection conexao, Subjects Subjects) {
		PreparedStatement ps = null;
		String query = "INSERT INTO subjects (name, cod_subject, descripition, durations_id, teaching_plan, credits, grade_to_aprove_id)"
				+ "Values (?,?,?,?,?,?,?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1,  Subjects.name);
			ps.setInt(2, Subjects.cod_subject);
			ps.setString(3, Subjects.descripition);
			ps.setInt(4, Subjects.durations_id);
			ps.setString(5, Subjects.teaching_plan);
			ps.setInt(6, Subjects.credits);
			ps.setInt(7, Subjects.grade_to_aprove_id);
			ps.execute();
			System.out.println("Diciplina inserida com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public List<Subjects> listaSubjects(Connection conexao) {
		Statement st = null;
		String query = "SELECT * FROM student_management.subjects \r\n"
		+ " inner join durations on subjects.durations_id = durations.id \r\n"
		+ " inner join grades_to_aprove on subjects.grade_to_aprove_id = grades_to_aprove.id";
		
		
		List<Subjects> SubjectsList = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			Resultset rs = (Resultset) st.executeQuery(query);
			
			while(((ResultSet) rs).next()) {
				
				Subjects Subjects = new Subjects();
				Subjects.id = ((ResultSet) rs).getInt("id");
				Subjects.name = ((ResultSet) rs).getString("name");
				Subjects.cod_subject = ((ResultSet) rs).getInt("cod_subject");
				Subjects.descripition = ((ResultSet) rs).getString("descripition");
				Subjects.durations_id = ((ResultSet) rs).getInt("study_load");
				Subjects.teaching_plan = ((ResultSet) rs).getString("teaching_plan");
				Subjects.credits = ((ResultSet) rs).getInt("credits");
				Subjects.grade_to_aprove_id = ((ResultSet) rs).getInt("grades_to_aprove.grade_to_aprove");
				Subjects.durations = ((ResultSet) rs).getInt("durations.study_load");
				
	            SubjectsList.add(Subjects);
			}
			
			System.out.println(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return SubjectsList;
		}
	
	public Subjects findSubjects(Connection conexao, int id) {
	    Statement st = null;
	    String query = "SELECT * FROM users WHERE cod_person = " + id;
	    Subjects Subjects = new Subjects();

	    try {
	        st = conexao.createStatement();
	        ResultSet rs = st.executeQuery(query);

	        if (rs.next()) {
	        	Subjects.id = ((ResultSet) rs).getInt("id");
				Subjects.name = ((ResultSet) rs).getString("name");
				Subjects.cod_subject = ((ResultSet) rs).getInt("cod_subject");
				Subjects.descripition = ((ResultSet) rs).getString("description");
				Subjects.durations_id = ((ResultSet) rs).getInt("durations_id");
				Subjects.teaching_plan = ((ResultSet) rs).getString("teaching_plan");
				Subjects.credits = ((ResultSet) rs).getInt("credits");
				Subjects.grade_to_aprove_id = ((ResultSet) rs).getInt("credits");

	        }
	    } catch (Exception e) {
	        // TODO: handle exception
	    }
	    return Subjects;
	}
	
	public void updateSubjects(Connection conexao, Subjects Subjects) {
		PreparedStatement ps = null;
		String query = "UPDATE subjects SET name=?, cod_subject=?, descripition=?, durations_id=?, teaching_plan=?, credits=?, grade_to_aprove_id=? WHERE cod_subject="+ Subjects.cod_subject;
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setString(1,  Subjects.name);
			ps.setInt(2, Subjects.cod_subject);
			ps.setString(3, Subjects.descripition);
			ps.setInt(4, Subjects.durations_id);
			ps.setString(5, Subjects.teaching_plan);
			ps.setInt(6, Subjects.credits);
			ps.setInt(7, Subjects.grade_to_aprove_id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println(query);
	}
	
	public void removeSubjects(Connection conexao, int code) {
		
		int id1 = code ;
		PreparedStatement ps = null;
		String query = "DELETE FROM Subjects WHERE cod_subject = ? ";
		
		try {
			ps = conexao.prepareStatement(query);;
			ps.setInt(1, id1);
			ps.execute();
			JOptionPane.showMessageDialog(null, "Diciplina removida cocom sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}