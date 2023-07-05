package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class InterfaceRead extends JFrame{
	
	private JButton voltar;
	private int minhaVariavel;
	
	public InterfaceRead (int valor) {
		minhaVariavel = valor;
		setSize(900,500);
		
		if (minhaVariavel == 1) {
			setTitle("Listar usuários");
		}else if (minhaVariavel == 2) {
			setTitle("Listar disciplinas");
		}else {
			setTitle("Listar usuários de uma turma");
		}
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(242, 242, 242));
		setLayout(null);
		setLocationRelativeTo(null);
		componentesCriar();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
    
    private void componentesCriar () {
    	Font fontetitle = new Font( "Poppins", Font.PLAIN, 16);
		Color background = new Color (242, 242, 242); 
		Color resultcolor = new Color (191, 107, 33);
    	Color borderColor = new Color (156, 185, 188); 
    	Font fontelabels = new Font( "Poppins", Font.PLAIN, 14);
    	int borderWidth = 2;
		Border matteBorder = BorderFactory.createMatteBorder(borderWidth, borderWidth, borderWidth, borderWidth, borderColor);
		
		if (minhaVariavel == 1 || minhaVariavel == 3) {
			Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Usuários");
		}else {
			Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Disciplinas");
		}
		
    	JPanel painel5 = new JPanel();
		painel5.setLayout(new BorderLayout());
		painel5.setBounds(20,60,845,385);
		getContentPane().add(painel5);
		
		if (minhaVariavel == 1) {
			Banco banco = new Banco();
			Connection conn = banco.getConexao();
			UsersBanco uBanco = new UsersBanco();
			
			List<Users> userList = uBanco.listausers(conn);
			
	    	DefaultTableModel modelo = new DefaultTableModel();
	    	JTable tabela = new JTable(modelo);
	    	
	    	modelo.addColumn("ID");
	    	modelo.addColumn("Nome");
	    	modelo.addColumn("Código");
	    	modelo.addColumn("Email");
	    	modelo.addColumn("Telefone");
	    	modelo.addColumn("CPF");
	    	modelo.addColumn("Endereço");
			for (Users user : userList) {
	    	modelo.addRow(new Object[]{user.id, user.name, user.cod_person, user.email, user.fone_number, user.cpf, user.spaces_id});
			}
	    	JScrollPane scrollPane = new JScrollPane(tabela);
	    	painel5.add(scrollPane, BorderLayout.CENTER);
			
		}else if (minhaVariavel == 2){
			Banco banco = new Banco();
			Connection conn = banco.getConexao();
			SubjectsBanco sBanco = new SubjectsBanco();
			
			List<Subjects> SubjectsList = sBanco.listaSubjects(conn);
			
	    	DefaultTableModel modelo = new DefaultTableModel();
	    	JTable tabela = new JTable(modelo);
	    	
	    	modelo.addColumn("ID");
	    	modelo.addColumn("Nome");
	    	modelo.addColumn("Código");
	    	modelo.addColumn("Descrição");
	    	modelo.addColumn("Duração(hrs)");
	    	modelo.addColumn("Professor");
	    	modelo.addColumn("Creditos");
	    	modelo.addColumn("Grade para aprovação");
			for (Subjects subjects : SubjectsList) {
	    	modelo.addRow(new Object[]{subjects.id, subjects.name, subjects.cod_subject, subjects.descripition, subjects.durations_id, subjects.teaching_plan, subjects.credits, subjects.grade_to_aprove_id});
			}
	    	JScrollPane scrollPane = new JScrollPane(tabela);
	    	painel5.add(scrollPane, BorderLayout.CENTER);
		}
    	
    	voltar = new JButton();
		voltar.setText("Voltar");
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setFont(fontelabels);
		voltar.setBounds(20, 20, 100, 25);
		voltar.setBackground(background);
		voltar.setForeground( resultcolor );
		Border customBorderButton = BorderFactory.createLineBorder(resultcolor, 2 );
		voltar.setBorder(customBorderButton);
		voltar.setFocusPainted(false);
		getContentPane().add(voltar);
		painel5.setVisible(true);
		
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
    }

	public static void main(String[] args) {
		 Interface InterfaceReadUsers = new Interface();

	}

}
