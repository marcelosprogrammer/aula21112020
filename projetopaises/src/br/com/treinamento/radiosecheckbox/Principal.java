package br.com.treinamento.radiosecheckbox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

/**
 * 
 * @author marcelo da silva
 * @version 1.0 de 14-11-2020
 *
 */
public class Principal extends JFrame {

	// adicionando checkbox ::::::::::
	JCheckBox primeiro = new JCheckBox("Primeiro");
	JCheckBox segundo = new JCheckBox("Segundo");

	// radiobuttons ::::::::::
	JRadioButton floripa = new JRadioButton("Floripa");
	JRadioButton palhoca = new JRadioButton("Palhoça");
	JRadioButton saojose = new JRadioButton("São José");

	// agrupador para os radioButtons ::::::::
	ButtonGroup grupoRadio = new ButtonGroup();
	
	
	//adicionando um JComboBox
	JComboBox combopaises;
	

	public Principal() {

		// Cria os Elementos ::::::::
		this.Elements();

		setTitle("Paises");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setSize(500, 500);
		setVisible(true);

	}

	public static void main(String args[]) {
		new Principal();
	}

	public void Elements() {
		
		//criando a lista de paises para o JComboBox
		String[] paises = new String[10];
		paises[0] = "Chile";
		paises[1] = "Bolivia";
		paises[2] = "Venezuela";
		paises[3] = "França";
		paises[4] = "EUA";
		paises[5] = "Brasil";
		paises[6] = "Colombia";
		paises[7] = "Amapa";
		paises[8] = "China";
		paises[9] = "Russia";
		
		
		combopaises = new JComboBox(paises);
		
		combopaises.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JOptionPane.showMessageDialog(null, e.getItemSelectable().getSelectedObjects().toString());
				
			}
		});
		
		Icon bandeiraBrasil = new ImageIcon("bandeiras/brasil.png");
		JLabel lbandBrasil = new JLabel("", bandeiraBrasil, SwingConstants.LEFT);

		Icon bandeiraBolivia = new ImageIcon("bandeiras/bolivia.png");
		JLabel lbandBolivia = new JLabel("", bandeiraBolivia, SwingConstants.LEFT);

		Icon bandeiraArgentina = new ImageIcon("bandeiras/argentina.png");
		JLabel lbandArgentina = new JLabel("", bandeiraArgentina, SwingConstants.LEFT);

		Checks csk = new Checks();
		primeiro.addItemListener(csk);
		segundo.addItemListener(csk);
		
		//adicionando o evento aos RadioButtons
		Radios radios = new Radios();
		
		
		floripa.addItemListener(radios);
		palhoca.addItemListener(radios);
		saojose.addItemListener(radios);

		// trabalhando com RadioButton e ButtonGroup
		grupoRadio.add(floripa);
		grupoRadio.add(palhoca);
		grupoRadio.add(saojose);

		add(lbandBrasil);
		add(lbandBolivia);
		add(lbandArgentina);
		add(primeiro);
		add(segundo);

		// adicionando os radios e nãoo agrupador grupoRadio
		add(floripa);
		add(palhoca);
		add(saojose);
		add(combopaises);

	}

	private class Checks implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {

			if (arg0.getSource() == primeiro) {
				primeiro.isSelected();
			}

			if (arg0.getSource() == segundo) {
				segundo.isSelected();
			}

		}

	}

	private class Radios implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			
			if (arg0.getSource() == floripa) {
				JOptionPane.showMessageDialog(null, "Bem vindo a Florianópolis!");
			}
			
			if (arg0.getSource() == palhoca) {
				JOptionPane.showMessageDialog(null, "Bem vindo a Palhoça!");
			}
			
			if (arg0.getSource() == saojose) {
				JOptionPane.showMessageDialog(null, "Bem vindo a São José!");
			}
		}

	}

}
