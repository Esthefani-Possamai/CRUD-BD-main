package code;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

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
	
	public InterfaceCreateSubjects (int valor, int code) {
		minhaVariavel = valor;
		code = code;
		setSize(900,700);
		if (minhaVariavel == 1) {
			
			setTitle("Inserir usuário ");
		} else {
			setTitle("Inserir disciplina");

		}
		// Obtém o painel de conteúdo do JFrame
        Container contentPane = getContentPane();
        // Define a cor de fundo do painel de conteúdo
        contentPane.setBackground(new Color(242, 242, 242));
		setLayout(null);
		//setBackground(getColorModel(255,69,0));
		setLocationRelativeTo(null);
		componentesCriar();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void componentesCriar () {
		Font fontetitle = new Font( "Poppins", Font.PLAIN, 16);
		Font fontelabels = new Font( "Poppins", Font.PLAIN, 14);
		Color borderColor = new Color (156, 185, 188); // Cor verde em RGB
		Color background = new Color (242, 242, 242); //Cor areia de fundo
		Color resultcolor = new Color (191, 107, 33);
		
		painel4 = new JPanel();
		painel4.setLayout(null);
		int borderWidth = 2; // Espessura da borda em pixels
		Border matteBorder = BorderFactory.createMatteBorder(borderWidth, borderWidth, borderWidth, borderWidth, borderColor);
		
		if (minhaVariavel == 1) {
		Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Usuários");
		((TitledBorder) titledBorder).setTitleColor(borderColor);
		Border titledBorder4 = BorderFactory.createTitledBorder(matteBorder, "Criar usuário");
		((TitledBorder) titledBorder4).setTitleColor(borderColor);
		painel4.setBorder(titledBorder4);
		((TitledBorder) titledBorder4).setTitleFont(fontelabels);

		}
		else {
			Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Disciplinas");
			((TitledBorder) titledBorder).setTitleColor(borderColor);
			Border titledBorder4 = BorderFactory.createTitledBorder(matteBorder, "Criar disciplina");
			((TitledBorder) titledBorder4).setTitleColor(borderColor);
			painel4.setBorder(titledBorder4);
			((TitledBorder) titledBorder4).setTitleFont(fontelabels);

		}
		painel4.setBounds(20,20,500,500);
		getContentPane().add(painel4);
		
		lnamesubject = new JLabel("Nome:");
		lnamesubject.setBounds(20,40,100,25);
		lnamesubject.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lnamesubject);
		namesubject = new JTextArea();
		namesubject.setBounds(120,40,250,25);
		painel4.add(namesubject);
		
		lcodesubject = new JLabel("Código:");
		lcodesubject.setBounds(20,75,100,25);
		lcodesubject.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lcodesubject);
		codesubject = new JTextArea();
		codesubject.setBounds(120,75,250,25);
		painel4.add(codesubject);
		
		ldescription = new JLabel("Descrição:");
		ldescription.setBounds(20,110,100,25);
		ldescription.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(ldescription);
		description = new JTextArea();
		description.setBounds(120,110,250,25);
		painel4.add(description);
		
		lteachingplan = new JLabel("Plano de ensino:");
		lteachingplan.setBounds(0,145,100,25);
		lteachingplan.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lteachingplan);
		teachingplan = new JTextArea();
		teachingplan.setBounds(120,145,250,25);
		painel4.add(teachingplan);
		
		lcredits = new JLabel("Créditos:");
		lcredits.setBounds(20,180,100,25);
		lcredits.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lcredits);
		credits2 = new JTextArea();
		credits2.setBounds(120,180,250,25);
		painel4.add(credits2);
		
		ldurationsid = new JLabel("ID da duração :");
		ldurationsid.setBounds(0,215,100,25);
		ldurationsid.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(ldurationsid);
		durationsid = new JTextArea();
		durationsid.setBounds(120,215,250,25);
		painel4.add(durationsid);
		
		lgradetoaproveid = new JLabel("ID da gradetoaproveid de aprovação:");
		lgradetoaproveid.setBounds(0,275,150,25);
		lgradetoaproveid.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lgradetoaproveid);
		gradetoaproveid = new JTextArea();
		gradetoaproveid.setBounds(120,275,250,25);
		painel4.add(gradetoaproveid);
		
		cadsubject = new JButton();
		if (minhaVariavel == 1) {
			cadsubject.setText("Criar disciplina");
		} else if (minhaVariavel == 2) {
			cadsubject.setText("Atualizar disciplina");
		}
		cadsubject.setHorizontalAlignment(SwingConstants.CENTER);
		cadsubject.setFont(fontelabels);
		cadsubject.setBounds(180, 290, 150, 25);
		cadsubject.setBackground(background);
		cadsubject.setForeground( resultcolor );
		Border customBorderButton = BorderFactory.createLineBorder(resultcolor, 2 );
		cadsubject.setBorder(customBorderButton);
		cadsubject.setFocusPainted(false);
		painel4.add(cadsubject);
		
		cadsubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Nenhum campo pode estar vazio para atualizar ou criar um usuário
				String name = namesubject.getText();
				int cod_subject = Integer.parseInt(codesubject.getText());
				String descripition = description.getText();
				String teaching_plan = teachingplan.getText();
				int credits = Integer.parseInt(credits2.getText());
				int durations_id = Integer.parseInt(durationsid.getText());
				int  grade_to_aprove_id =  Integer.parseInt(gradetoaproveid.getText());
				
		
				
				
					if (minhaVariavel == 1) {
						//PARA ADICIONAR NOVA DISCIPLINA
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
						//PARA ATUALIZAR DISCIPLINA
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
		voltar.setBounds(60, 290, 100, 25);
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
