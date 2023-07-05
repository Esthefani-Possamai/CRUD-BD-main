package code;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InterfaceCreateSubjects extends JFrame{
	
	private JPanel painel4;
	private JLabel lnamesubject;
	private JTextArea namesubject;
	
	private JLabel lcodesubject;
	private JTextArea codesubject;
	
	private JLabel ldescription;
	private JTextArea description;
	
	private JLabel lteachingplan;
	private JTextArea teachingplan;
	
	private JLabel lcredits;
	private JTextArea credits2;
	
	private JLabel ldurationsid;
	private JTextArea durationsid;
	
	private JLabel lgradetoaproveid;
	private JTextArea gradetoaproveid;
	
	private JButton cadsubject;
	private JButton voltar;
	
	private int minhaVariavel;
	private int code;
	
	Subjects subjects = null;
	
	public InterfaceCreateSubjects (int valor, int code) {
		minhaVariavel = valor;
		code = code;
		
		setSize(510, 415);
		if (minhaVariavel == 1) {
			setTitle("Inserir disciplina ");
		} else if (minhaVariavel == 2){
			setTitle("Atualizar disciplina");
			 Banco banco = new Banco();
			Connection conn = banco.getConexao();
			SubjectsBanco sBanco = new SubjectsBanco();
			subjects = sBanco.findSubjects(conn, code);

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
		Font fontelabels = new Font( "Poppins", Font.PLAIN, 14);
		Color borderColor = new Color (156, 185, 188); 
		Color background = new Color (242, 242, 242); 
		Color resultcolor = new Color (191, 107, 33);
		
		painel4 = new JPanel();
		painel4.setLayout(null);
		int borderWidth = 2; 
		Border matteBorder = BorderFactory.createMatteBorder(borderWidth, borderWidth, borderWidth, borderWidth, borderColor);
		
		if (minhaVariavel == 1) {
		Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Disciplinas");
		((TitledBorder) titledBorder).setTitleColor(borderColor);
		Border titledBorder4 = BorderFactory.createTitledBorder(matteBorder, "Criar disciplina");
		((TitledBorder) titledBorder4).setTitleColor(borderColor);
		painel4.setBorder(titledBorder4);
		((TitledBorder) titledBorder4).setTitleFont(fontelabels);

		}
		else if (minhaVariavel == 2){
			Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Disciplinas");
			((TitledBorder) titledBorder).setTitleColor(borderColor);
			Border titledBorder4 = BorderFactory.createTitledBorder(matteBorder, "Atualizar disciplina");
			((TitledBorder) titledBorder4).setTitleColor(borderColor);
			painel4.setBorder(titledBorder4);
			((TitledBorder) titledBorder4).setTitleFont(fontelabels);

		}
		painel4.setBounds(20,20,455,335);
		getContentPane().add(painel4);
		
		lnamesubject = new JLabel("Nome:");
		lnamesubject.setBounds(20,40,110,25);
		lnamesubject.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lnamesubject);
		namesubject = new JTextArea();
		namesubject.setBounds(140,40,280,25);
		painel4.add(namesubject);
		
		lcodesubject = new JLabel("Código:");
		lcodesubject.setBounds(20,75,110,25);
		lcodesubject.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lcodesubject);
		codesubject = new JTextArea();
		codesubject.setBounds(140,75,280,25);
		painel4.add(codesubject);
		
		ldescription = new JLabel("Descrição:");
		ldescription.setBounds(20,110,110,25);
		ldescription.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(ldescription);
		description = new JTextArea();
		description.setBounds(140,110,280,25);
		painel4.add(description);
		
		lteachingplan = new JLabel("Plano de ensino:");
		lteachingplan.setBounds(20,145,110,25);
		lteachingplan.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lteachingplan);
		teachingplan = new JTextArea();
		teachingplan.setBounds(140,145,280,25);
		painel4.add(teachingplan);
		
		lcredits = new JLabel("Créditos:");
		lcredits.setBounds(20,180,110,25);
		lcredits.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lcredits);
		credits2 = new JTextArea();
		credits2.setBounds(140,180,280,25);
		painel4.add(credits2);
		
		ldurationsid = new JLabel("ID Duração :");
		ldurationsid.setBounds(20,215,110,25);
		ldurationsid.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(ldurationsid);
		durationsid = new JTextArea();
		durationsid.setBounds(140,215,280,25);
		painel4.add(durationsid);
		
		lgradetoaproveid = new JLabel("ID Nota de aprovação:");
		lgradetoaproveid.setBounds(0,250,130,25);
		lgradetoaproveid.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lgradetoaproveid);
		gradetoaproveid = new JTextArea();
		gradetoaproveid.setBounds(140,250,280,25);
		painel4.add(gradetoaproveid);
		
		cadsubject = new JButton();
		if (minhaVariavel == 1) {
			cadsubject.setText("Criar disciplina");
		} else if (minhaVariavel == 2) {
			cadsubject.setText("Atualizar disciplina");
		}
		cadsubject.setHorizontalAlignment(SwingConstants.CENTER);
		cadsubject.setFont(fontelabels);
		cadsubject.setBounds(260, 285, 150, 25);
		cadsubject.setBackground(background);
		cadsubject.setForeground( resultcolor );
		Border customBorderButton = BorderFactory.createLineBorder(resultcolor, 2 );
		cadsubject.setBorder(customBorderButton);
		cadsubject.setFocusPainted(false);
		painel4.add(cadsubject);
		
		if (minhaVariavel == 2) {
			 namesubject.setText(subjects.name);
			 codesubject.setText(String.valueOf(subjects.cod_subject));
			description.setText(subjects.descripition);
			teachingplan.setText(subjects.teaching_plan);
			credits2.setText(String.valueOf(subjects.credits));
			durationsid.setText(String.valueOf(subjects.durations_id));
			gradetoaproveid.setText(String.valueOf(subjects.grade_to_aprove_id));
			codesubject.setEditable(false);
		}
		
		cadsubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = namesubject.getText();
				int cod_subject = Integer.parseInt(codesubject.getText());
				String descripition = description.getText();
				String teaching_plan = teachingplan.getText();
				int credits = Integer.parseInt(credits2.getText());
				int durations_id = Integer.parseInt(durationsid.getText());
				int  grade_to_aprove_id =  Integer.parseInt(gradetoaproveid.getText());
				
					if (minhaVariavel == 1) {
						Banco banco = new Banco();
						Connection conn = banco.getConexao();
						SubjectsBanco sBanco = new SubjectsBanco();
						Subjects subjects = new Subjects();
						
						subjects.name = name;
						subjects.cod_subject = cod_subject;
						subjects.descripition = descripition;
						subjects.teaching_plan = teaching_plan;
						subjects.credits = credits;
						subjects.durations_id = durations_id;
						subjects.grade_to_aprove_id = grade_to_aprove_id;
						sBanco.insereSubjects(conn, subjects);
						
					} else if (minhaVariavel == 2) {
						Banco banco = new Banco();
						Connection conn = banco.getConexao();
						SubjectsBanco sBanco = new SubjectsBanco();
						Subjects subjects = new Subjects();
						
						subjects.name = name;
						subjects.cod_subject = cod_subject;
						subjects.descripition = descripition;
						subjects.teaching_plan = teaching_plan;
						subjects.credits = credits;
						subjects.durations_id = durations_id;
						subjects.grade_to_aprove_id = grade_to_aprove_id;
						sBanco.updateSubjects(conn, subjects);
					}
			}
		});
		
		voltar = new JButton();
		voltar.setText("Voltar");
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setFont(fontelabels);
		voltar.setBounds(150, 285, 100, 25);
		voltar.setBackground(background);
		voltar.setForeground( resultcolor );
		voltar.setBorder(customBorderButton);
		voltar.setFocusPainted(false);
		painel4.add(voltar);
		
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Interface InterfaceCreateSubjects = new Interface();

	}

}
