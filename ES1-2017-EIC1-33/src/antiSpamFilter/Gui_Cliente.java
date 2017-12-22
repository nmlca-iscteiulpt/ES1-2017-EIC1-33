package antiSpamFilter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

public class Gui_Cliente {
	private JFrame frame;
	private JPanel panelup;
	private JPanel panelcenter;
	private JPanel paneldown;
	private JButton brules;
	private JButton bspam;
	private JButton bham;
	private JTextArea textrules;
	private JTextArea textspam;
	private JTextArea textham;
	private JList<String> boxleftmanual;
	private JTextArea boxrightmanual;
	private JList<String> boxleftauto;
	private JList<String> boxrightauto;
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	private JScrollPane scroll3;
	private JScrollPane scroll4;
	private JLabel text1;
	private JLabel text2;
	private JLabel text3;
	private JTextPane FP1 = new JTextPane();
	private JTextPane FN1 = new JTextPane();
	private JTextPane FP2 = new JTextPane();
	private JTextPane FN2 = new JTextPane();
	private DefaultListModel<String> model1 = new DefaultListModel<>();
	private DefaultListModel<String> model3 = new DefaultListModel<>();
	private JButton avaliar;
	private JButton gravarconfmanual;
	private JButton gerarconfauto;
	private JButton gravarconfauto;
	private static ArrayList<String> lrules = new ArrayList<String>();
	private static ArrayList<String> paths = new ArrayList<String>();
	private ReadFiles r;
	private Manual_Configuration mc;
	
	public Gui_Cliente() {
		frame = new JFrame("Filter Spam");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void addFrameContent() {
		
		///  *********** painel de cima com o rules.cf, spam.log e ham.log ***********
		
		panelup = new JPanel();
		panelup.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		text1 = new JLabel("PATH rules.cf");
		textrules = new JTextArea();
		textrules.setEditable(false);
		textrules.setPreferredSize(new Dimension(200, 20));
		
		brules = new JButton("PATH");
		brules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				int returnName = chooser.showOpenDialog(null);
				String path;

				if (returnName == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					if (f != null && f.getName().equals("rules.cf")) { // Make sure the user didn't choose a wrong directory.

						path = f.getAbsolutePath();//get the absolute path to selected file
						textrules.setText(path);
						paths.add(0, path);
						ReadFiles.lerFicheiros();
						for(int i = 0; i < lrules.size();i++) {
							model1.addElement("" + i + ". " + lrules.get(i));
						}
					} else {
						JOptionPane.showMessageDialog(frame, "Selecione um ficheiro com a extensão .cf");
					}
				}  
			}
		});
		
		panel1.add(text1);
		panel1.add(textrules);
		panel1.add(brules);
		panelup.add(panel1, BorderLayout.NORTH);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		text2 = new JLabel("PATH spam.log");
		textspam = new JTextArea();
		textspam.setEditable(false);
		textspam.setPreferredSize(new Dimension(200, 20));
		
		bspam = new JButton("PATH");
		bspam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				int returnName = chooser.showOpenDialog(null);
				String path;

				if (returnName == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					if (f != null && f.getName().equals("spam.log") ) { // Make sure the user didn't choose a directory.

						path = f.getAbsolutePath();//get the absolute path to selected file
						textspam.setText(path);
						paths.add(1, path);
						ReadFiles.lerFicheiros();
					} else {
						JOptionPane.showMessageDialog(frame, "Selecione um ficheiro com a extensão .log");
					}
				}    
			}
		});
		
		panel2.add(text2);
		panel2.add(textspam);
		panel2.add(bspam);
		panelup.add(panel2, BorderLayout.CENTER);
		
	
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		text3 = new JLabel("PATH ham.log");
		textham = new JTextArea();
		textham.setEditable(false);
		textham.setPreferredSize(new Dimension(200, 20));
		
		bham = new JButton("PATH");
		bham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				int returnName = chooser.showOpenDialog(null);
				String path;

				if (returnName == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					if (f != null && f.getName().equals("ham.log")) { // Make sure the user didn't choose a directory.

						path = f.getAbsolutePath();//get the absolute path to selected file
						//below line to test the file chooser
						//System.out.println(path);
						textham.setText(path);
						paths.add(2, path);
						ReadFiles.lerFicheiros();
					} else {
						JOptionPane.showMessageDialog(frame, "Selecione um ficheiro com a extensão .log");
					}
				}  
			}
		});
		
		panel3.add(text3);
		panel3.add(textham);
		panel3.add(bham);
		panelup.add(panel3, BorderLayout.SOUTH);
		
		frame.add(panelup,BorderLayout.NORTH);
		
	//  ****************** painel do meio com a configuração manual  *********************
		
		panelcenter = new JPanel();
		panelcenter.setLayout(new BorderLayout());
		
		JPanel panelleft = new JPanel();
		panelleft.setLayout(new GridLayout(1, 0));
		boxleftmanual = new JList<>(model1);
		lrules = ReadFiles.getRules();
		for(int i = 0; i < lrules.size();i++) {
			model1.addElement("" + i + ". " + lrules.get(i));
		}
		
		boxrightmanual = new JTextArea();
		int[] valores_manual = new int[335];
		for (int i=0;i>335;i++){
			valores_manual[i]=mc.getValores()[i];
		}
		for(int i=0; i<335; i++){
			boxrightmanual.append(i + "->"+valores_manual[i]+"\n");
		}
		boxrightmanual.setEditable(true);
		
		scroll1 = new JScrollPane(boxleftmanual);
		scroll2 = new JScrollPane(boxrightmanual);	
		panelleft.add(scroll1);
		panelleft.add(scroll2);
		panelcenter.add(panelleft);
		
		JPanel panelright1 = new JPanel();
		panelright1.setLayout(new BoxLayout(panelright1, 1));
		
		AvaliarManual a = new AvaliarManual(this);
		avaliar = new JButton("Avaliar Configuração");
		avaliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.avaliar();
			}		
		});
		
		GravarManual gm = new GravarManual(this);
		gravarconfmanual = new JButton("Gravar Configuração");
		gravarconfmanual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.gravar();
			}		
		});
		
		avaliar.setPreferredSize(new Dimension (200, 40));
		gravarconfmanual.setPreferredSize(new Dimension (200, 40));
		panelright1.add(Box.createRigidArea(new Dimension(60,100)));
		panelright1.add(avaliar);
		panelright1.add(Box.createRigidArea(new Dimension(60,50)));
		panelright1.add(gravarconfmanual);
		panelright1.add(Box.createRigidArea(new Dimension(0,20)));
		FP1.setText("FP :");
		FP1.setEditable(false);
		panelright1.add(FP1);
		panelright1.add(Box.createRigidArea(new Dimension(0,10)));
		FN1.setText("FN :");
		FN1.setEditable(false);
		panelright1.add(FN1);
		
		panelcenter.add(panelright1, BorderLayout.EAST);
		panelcenter.setPreferredSize(new Dimension(500, 100));

		frame.add(panelcenter,BorderLayout.CENTER);
		
		
	//  ****************** painel de baixo com a configuração automática *********************
		
		
		paneldown = new JPanel();
		paneldown.setLayout(new BorderLayout());
		
		JPanel panelleftup = new JPanel();
		panelleftup.setLayout(new GridLayout(1, 0));
		boxleftauto = new JList<>(model1);
		boxrightauto = new JList<>(model3);
		scroll3 = new JScrollPane(boxleftauto);
		scroll4 = new JScrollPane(boxrightauto);
		panelleftup.add(scroll3);
		panelleftup.add(scroll4);
		
		JPanel panelright = new JPanel();
		panelright.setLayout(new BoxLayout(panelright, 1));
		
		gerarconfauto = new JButton("Gerar Configuração Auto");
		IniciarAuto ia = new IniciarAuto(this);
		gerarconfauto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model3.clear();
				ia.start();
			}		
		});
		gravarconfauto = new JButton("Gravar Configuração");
		GravarAuto ga = new GravarAuto(this);
		AvaliarAuto aa = new AvaliarAuto(this);
		gravarconfauto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ga.gravar();
				aa.avaliarAuto();
			}		
		});
		
		gravarconfauto.setPreferredSize(new Dimension (200, 40));
		gerarconfauto.setPreferredSize(new Dimension (200, 40));
		panelright.add(Box.createRigidArea(new Dimension(60,100)));
		panelright.add(gerarconfauto);
		panelright.add(Box.createRigidArea(new Dimension(60,50)));
		panelright.add(gravarconfauto);
		
		panelright.add(Box.createRigidArea(new Dimension(0,20)));
		FP2.setText("FP :");
		FP2.setEditable(false);
		panelright.add(FP2);
		panelright.add(Box.createRigidArea(new Dimension(0,10)));
		FN2.setText("FN :");
		FN2.setEditable(false);
		panelright.add(FN2);
		
		paneldown.add(panelleftup);
		paneldown.add(panelright, BorderLayout.EAST);
		paneldown.setPreferredSize(new Dimension(500, 300));
		 
		frame.add(paneldown, BorderLayout.SOUTH);
		
	}

	public JTextArea getBoxrightmanual() {
		return boxrightmanual;
	}

	public JTextPane getFP1() {
		return FP1;
	}

	public void setFP1(JTextPane fP1) {
		FP1 = fP1;
	}

	public JTextPane getFN1() {
		return FN1;
	}

	public void setFN1(JTextPane fN1) {
		FN1 = fN1;
	}

	public JTextPane getFP2() {
		return FP2;
	}

	public void setFP2(JTextPane fP2) {
		FP2 = fP2;
	}

	public JTextPane getFN2() {
		return FN2;
	}

	public void setFN2(JTextPane fN2) {
		FN2 = fN2;
	}
	
	public static ArrayList<String> getPaths() {
		return paths;
	}
	
	public void setBoxrightauto(JList<String> boxrightauto) {
		this.boxrightauto = boxrightauto;
	}
	
	public DefaultListModel<String> getModel3() {
		return model3;
	}

	public static void main(String[] args) {
		Gui_Cliente j = new Gui_Cliente();
	}

}
