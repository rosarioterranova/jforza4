package forza4;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

public class Tavoliere {
	private Forza4 gioco = new Forza4();
	private JFrame frmJforza;
	private boolean vincita = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {			//crea una coda degli ActionListener ad ogni loro metodo invocato
			public void run() {
				try {
					Tavoliere window = new Tavoliere();
					window.frmJforza.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();			//stampa su console il tipo di errore riportato
				}
			}
		});
	}

	public Tavoliere() {
		initialize();
	}

	private void initialize() {
		//Creazione Frame
		frmJforza = new JFrame();
		frmJforza.setResizable(false);
		frmJforza.setTitle("jForza4");
		frmJforza.setIconImage(Toolkit.getDefaultToolkit().getImage(Tavoliere.class.getResource("/immagini/icon.png")));
		frmJforza.setBounds(400, 50, 600, 650);
		frmJforza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJforza.getContentPane().setLayout(null);
		
		// Creazione Tavoliere
		final JLabel tavoliere = new JLabel("");
		tavoliere.setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/tavoliere.png")));
		tavoliere.setBounds(41, 146, 500, 434);
		frmJforza.getContentPane().add(tavoliere);
		tavoliere.setEnabled(false);
		
		//Creazione e Settaggi Pezzi
		final JLabel pezziRossi[]= new JLabel[42];				//crea un array di JLabel
		for (int i=0; i<pezziRossi.length;i++){
			pezziRossi[i]= new JLabel("");						//crea le istance di JLabel
			int [] coordinataX ={52,52,52,52,52,52,122,122,122,122,122,122,192,192,192,192,192,192,262,262,262,262,262,262,332,332,332,332,332,332,402,402,402,402,402,402,472,472,472,472,472,472};
			int [] coordinataY ={502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,};
			pezziRossi [i].setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/pezzoRosso.png")));
			pezziRossi [i].setBounds(coordinataX[i], coordinataY[i], 62, 65);
			frmJforza.getContentPane().add(pezziRossi [i]);			//inserisce i pezzi nel frame
			pezziRossi[i].setEnabled(false);
		}				
		
		final JLabel pezziVerdi[]= new JLabel[42];
		for (int i=0; i<pezziVerdi.length;i++){
			pezziVerdi[i]= new JLabel("");
			int [] coordinataX ={52,52,52,52,52,52,122,122,122,122,122,122,192,192,192,192,192,192,262,262,262,262,262,262,332,332,332,332,332,332,402,402,402,402,402,402,472,472,472,472,472,472}; //continuare coordinate
			int [] coordinataY ={502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,502,432,360,290,220,150,};
			pezziVerdi [i].setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/pezzoVerde.png")));
			pezziVerdi [i].setBounds(coordinataX[i], coordinataY[i], 62, 65);
			frmJforza.getContentPane().add(pezziVerdi [i]);
			pezziVerdi[i].setEnabled(false);
		}

		//Creazione e Settaggi Frecce
		final JLabel frecce[]= new JLabel[7];
		for (int i=0; i<frecce.length;i++){
				frecce[i]=new JLabel("");
				frecce[i].setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/arrow.png")));
				int [] coordinata = {56,131,198,268,338,408,477};
				frecce[i].setBounds(coordinata[i], 93, 48, 50);
				frmJforza.getContentPane().add(frecce[i]);
				frecce[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				frecce[i].setEnabled(false);
				frecce[i].setVisible(false);
			}
		
		frecce[0].addMouseListener(new MouseAdapter() {					//mette un ascoltatore alla prima frecce
			public void mouseClicked(MouseEvent arg0) {
				gioco.inserisciPezzoRosso(1);
	            if (gioco.controllaPezzo(5,0)==1){pezziRossi[0].setVisible(true);pezziRossi[0].setEnabled(true);}		//ogni volta che si inserisce un pezzo, si fanno
	            if (gioco.controllaPezzo(4,0)==1){pezziRossi[1].setVisible(true);pezziRossi[1].setEnabled(true);}		//dei controlli (grazie all'AcionListener)
	            if (gioco.controllaPezzo(3,0)==1){pezziRossi[2].setVisible(true);pezziRossi[2].setEnabled(true);}		//per vedere qual è il nuovo pezzoinserito,
	            if (gioco.controllaPezzo(2,0)==1){pezziRossi[3].setVisible(true);pezziRossi[3].setEnabled(true);}		//e se ne prendono le coordinate
	            if (gioco.controllaPezzo(1,0)==1){pezziRossi[4].setVisible(true);pezziRossi[4].setEnabled(true);}		//per visualizzare il pezzo specifico
	            if (gioco.controllaPezzo(0,0)==1){pezziRossi[5].setVisible(true);pezziRossi[5].setEnabled(true);}
	            if (gioco.controlloVincita()==true){
	            	JOptionPane.showMessageDialog(null,"Complimenti, hai vinto! :)","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)						//in caso di vincita le frecce scompaiono in modo da non poterle ricliccare
			             frecce[i].setVisible(false);
	            	}
	            else{
		            gioco.inserisciPezzoVerde(gioco.IA());			//dopo la nostra azione, avviene quella della IA
		            if (vincita == false){
		            	if (gioco.controllaPezzo(5,0)==2){pezziVerdi[0].setVisible(true);pezziVerdi[0].setEnabled(true);}
		            	if (gioco.controllaPezzo(4,0)==2){pezziVerdi[1].setVisible(true);pezziVerdi[1].setEnabled(true);}
		            	if (gioco.controllaPezzo(3,0)==2){pezziVerdi[2].setVisible(true);pezziVerdi[2].setEnabled(true);}
		            	if (gioco.controllaPezzo(2,0)==2){pezziVerdi[3].setVisible(true);pezziVerdi[3].setEnabled(true);}
		            	if (gioco.controllaPezzo(1,0)==2){pezziVerdi[4].setVisible(true);pezziVerdi[4].setEnabled(true);}
		            	if (gioco.controllaPezzo(0,0)==2){pezziVerdi[5].setVisible(true);pezziVerdi[5].setEnabled(true);}
		            	if (gioco.controllaPezzo(5,1)==2){pezziVerdi[6].setVisible(true);pezziVerdi[6].setEnabled(true);}
			            if (gioco.controllaPezzo(4,1)==2){pezziVerdi[7].setVisible(true);pezziVerdi[7].setEnabled(true);}
			            if (gioco.controllaPezzo(3,1)==2){pezziVerdi[8].setVisible(true);pezziVerdi[8].setEnabled(true);}
			            if (gioco.controllaPezzo(2,1)==2){pezziVerdi[9].setVisible(true);pezziVerdi[9].setEnabled(true);}
			            if (gioco.controllaPezzo(1,1)==2){pezziVerdi[10].setVisible(true);pezziVerdi[10].setEnabled(true);}
			            if (gioco.controllaPezzo(0,1)==2){pezziVerdi[11].setVisible(true);pezziVerdi[11].setEnabled(true);}
			            if (gioco.controllaPezzo(5,2)==2){pezziVerdi[12].setVisible(true);pezziVerdi[12].setEnabled(true);}
			            if (gioco.controllaPezzo(4,2)==2){pezziVerdi[13].setVisible(true);pezziVerdi[13].setEnabled(true);}
			            if (gioco.controllaPezzo(3,2)==2){pezziVerdi[14].setVisible(true);pezziVerdi[14].setEnabled(true);}
			            if (gioco.controllaPezzo(2,2)==2){pezziVerdi[15].setVisible(true);pezziVerdi[15].setEnabled(true);}
			            if (gioco.controllaPezzo(1,2)==2){pezziVerdi[16].setVisible(true);pezziVerdi[16].setEnabled(true);}
			            if (gioco.controllaPezzo(0,2)==2){pezziVerdi[17].setVisible(true);pezziVerdi[17].setEnabled(true);}
			            if (gioco.controllaPezzo(5,3)==2){pezziVerdi[18].setVisible(true);pezziVerdi[18].setEnabled(true);}
			            if (gioco.controllaPezzo(4,3)==2){pezziVerdi[19].setVisible(true);pezziVerdi[19].setEnabled(true);}
			            if (gioco.controllaPezzo(3,3)==2){pezziVerdi[20].setVisible(true);pezziVerdi[20].setEnabled(true);}
			            if (gioco.controllaPezzo(2,3)==2){pezziVerdi[21].setVisible(true);pezziVerdi[21].setEnabled(true);}
			            if (gioco.controllaPezzo(1,3)==2){pezziVerdi[22].setVisible(true);pezziVerdi[22].setEnabled(true);}
			            if (gioco.controllaPezzo(0,3)==2){pezziVerdi[23].setVisible(true);pezziVerdi[23].setEnabled(true);}
			            if (gioco.controllaPezzo(5,4)==2){pezziVerdi[24].setVisible(true);pezziVerdi[24].setEnabled(true);}
			            if (gioco.controllaPezzo(4,4)==2){pezziVerdi[25].setVisible(true);pezziVerdi[25].setEnabled(true);}
			            if (gioco.controllaPezzo(3,4)==2){pezziVerdi[26].setVisible(true);pezziVerdi[26].setEnabled(true);}
			            if (gioco.controllaPezzo(2,4)==2){pezziVerdi[27].setVisible(true);pezziVerdi[27].setEnabled(true);}
			            if (gioco.controllaPezzo(1,4)==2){pezziVerdi[28].setVisible(true);pezziVerdi[28].setEnabled(true);}
			            if (gioco.controllaPezzo(0,4)==2){pezziVerdi[29].setVisible(true);pezziVerdi[29].setEnabled(true);}
			            if (gioco.controllaPezzo(5,5)==2){pezziVerdi[30].setVisible(true);pezziVerdi[30].setEnabled(true);}
			            if (gioco.controllaPezzo(4,5)==2){pezziVerdi[31].setVisible(true);pezziVerdi[31].setEnabled(true);}
			            if (gioco.controllaPezzo(3,5)==2){pezziVerdi[32].setVisible(true);pezziVerdi[32].setEnabled(true);}
			            if (gioco.controllaPezzo(2,5)==2){pezziVerdi[33].setVisible(true);pezziVerdi[33].setEnabled(true);}
			            if (gioco.controllaPezzo(1,5)==2){pezziVerdi[34].setVisible(true);pezziVerdi[34].setEnabled(true);}
			            if (gioco.controllaPezzo(0,5)==2){pezziVerdi[35].setVisible(true);pezziVerdi[35].setEnabled(true);}
			            if (gioco.controllaPezzo(5,6)==2){pezziVerdi[36].setVisible(true);pezziVerdi[36].setEnabled(true);}
			            if (gioco.controllaPezzo(4,6)==2){pezziVerdi[37].setVisible(true);pezziVerdi[37].setEnabled(true);}
			            if (gioco.controllaPezzo(3,6)==2){pezziVerdi[38].setVisible(true);pezziVerdi[38].setEnabled(true);}
			            if (gioco.controllaPezzo(2,6)==2){pezziVerdi[39].setVisible(true);pezziVerdi[39].setEnabled(true);}
			            if (gioco.controllaPezzo(1,6)==2){pezziVerdi[40].setVisible(true);pezziVerdi[40].setEnabled(true);}
			            if (gioco.controllaPezzo(0,6)==2){pezziVerdi[41].setVisible(true);pezziVerdi[41].setEnabled(true);}
		            }
	            }
	            if (gioco.controlloVincitaPC()==true){
	            	JOptionPane.showMessageDialog(null,"Peccato, hai perso :(","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}
			}
		});
		
		frecce[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				gioco.inserisciPezzoRosso(2);
	            if (gioco.controllaPezzo(5,1)==1){pezziRossi[6].setVisible(true);pezziRossi[6].setEnabled(true);}
	            if (gioco.controllaPezzo(4,1)==1){pezziRossi[7].setVisible(true);pezziRossi[7].setEnabled(true);}
	            if (gioco.controllaPezzo(3,1)==1){pezziRossi[8].setVisible(true);pezziRossi[8].setEnabled(true);}
	            if (gioco.controllaPezzo(2,1)==1){pezziRossi[9].setVisible(true);pezziRossi[9].setEnabled(true);}
	            if (gioco.controllaPezzo(1,1)==1){pezziRossi[10].setVisible(true);pezziRossi[10].setEnabled(true);}
	            if (gioco.controllaPezzo(0,1)==1){pezziRossi[11].setVisible(true);pezziRossi[11].setEnabled(true);}
	            if (gioco.controlloVincita()==true){
	            	JOptionPane.showMessageDialog(null,"Complimenti, hai vinto! :)","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
	            	for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}
	            else{
		            gioco.inserisciPezzoVerde(gioco.IA());
		            if (vincita == false){
		            	if (gioco.controllaPezzo(5,0)==2){pezziVerdi[0].setVisible(true);pezziVerdi[0].setEnabled(true);}
		            	if (gioco.controllaPezzo(4,0)==2){pezziVerdi[1].setVisible(true);pezziVerdi[1].setEnabled(true);}
		            	if (gioco.controllaPezzo(3,0)==2){pezziVerdi[2].setVisible(true);pezziVerdi[2].setEnabled(true);}
		            	if (gioco.controllaPezzo(2,0)==2){pezziVerdi[3].setVisible(true);pezziVerdi[3].setEnabled(true);}
		            	if (gioco.controllaPezzo(1,0)==2){pezziVerdi[4].setVisible(true);pezziVerdi[4].setEnabled(true);}
		            	if (gioco.controllaPezzo(0,0)==2){pezziVerdi[5].setVisible(true);pezziVerdi[5].setEnabled(true);}
		            	if (gioco.controllaPezzo(5,1)==2){pezziVerdi[6].setVisible(true);pezziVerdi[6].setEnabled(true);}
			            if (gioco.controllaPezzo(4,1)==2){pezziVerdi[7].setVisible(true);pezziVerdi[7].setEnabled(true);}
			            if (gioco.controllaPezzo(3,1)==2){pezziVerdi[8].setVisible(true);pezziVerdi[8].setEnabled(true);}
			            if (gioco.controllaPezzo(2,1)==2){pezziVerdi[9].setVisible(true);pezziVerdi[9].setEnabled(true);}
			            if (gioco.controllaPezzo(1,1)==2){pezziVerdi[10].setVisible(true);pezziVerdi[10].setEnabled(true);}
			            if (gioco.controllaPezzo(0,1)==2){pezziVerdi[11].setVisible(true);pezziVerdi[11].setEnabled(true);}
			            if (gioco.controllaPezzo(5,2)==2){pezziVerdi[12].setVisible(true);pezziVerdi[12].setEnabled(true);}
			            if (gioco.controllaPezzo(4,2)==2){pezziVerdi[13].setVisible(true);pezziVerdi[13].setEnabled(true);}
			            if (gioco.controllaPezzo(3,2)==2){pezziVerdi[14].setVisible(true);pezziVerdi[14].setEnabled(true);}
			            if (gioco.controllaPezzo(2,2)==2){pezziVerdi[15].setVisible(true);pezziVerdi[15].setEnabled(true);}
			            if (gioco.controllaPezzo(1,2)==2){pezziVerdi[16].setVisible(true);pezziVerdi[16].setEnabled(true);}
			            if (gioco.controllaPezzo(0,2)==2){pezziVerdi[17].setVisible(true);pezziVerdi[17].setEnabled(true);}
			            if (gioco.controllaPezzo(5,3)==2){pezziVerdi[18].setVisible(true);pezziVerdi[18].setEnabled(true);}
			            if (gioco.controllaPezzo(4,3)==2){pezziVerdi[19].setVisible(true);pezziVerdi[19].setEnabled(true);}
			            if (gioco.controllaPezzo(3,3)==2){pezziVerdi[20].setVisible(true);pezziVerdi[20].setEnabled(true);}
			            if (gioco.controllaPezzo(2,3)==2){pezziVerdi[21].setVisible(true);pezziVerdi[21].setEnabled(true);}
			            if (gioco.controllaPezzo(1,3)==2){pezziVerdi[22].setVisible(true);pezziVerdi[22].setEnabled(true);}
			            if (gioco.controllaPezzo(0,3)==2){pezziVerdi[23].setVisible(true);pezziVerdi[23].setEnabled(true);}
			            if (gioco.controllaPezzo(5,4)==2){pezziVerdi[24].setVisible(true);pezziVerdi[24].setEnabled(true);}
			            if (gioco.controllaPezzo(4,4)==2){pezziVerdi[25].setVisible(true);pezziVerdi[25].setEnabled(true);}
			            if (gioco.controllaPezzo(3,4)==2){pezziVerdi[26].setVisible(true);pezziVerdi[26].setEnabled(true);}
			            if (gioco.controllaPezzo(2,4)==2){pezziVerdi[27].setVisible(true);pezziVerdi[27].setEnabled(true);}
			            if (gioco.controllaPezzo(1,4)==2){pezziVerdi[28].setVisible(true);pezziVerdi[28].setEnabled(true);}
			            if (gioco.controllaPezzo(0,4)==2){pezziVerdi[29].setVisible(true);pezziVerdi[29].setEnabled(true);}
			            if (gioco.controllaPezzo(5,5)==2){pezziVerdi[30].setVisible(true);pezziVerdi[30].setEnabled(true);}
			            if (gioco.controllaPezzo(4,5)==2){pezziVerdi[31].setVisible(true);pezziVerdi[31].setEnabled(true);}
			            if (gioco.controllaPezzo(3,5)==2){pezziVerdi[32].setVisible(true);pezziVerdi[32].setEnabled(true);}
			            if (gioco.controllaPezzo(2,5)==2){pezziVerdi[33].setVisible(true);pezziVerdi[33].setEnabled(true);}
			            if (gioco.controllaPezzo(1,5)==2){pezziVerdi[34].setVisible(true);pezziVerdi[34].setEnabled(true);}
			            if (gioco.controllaPezzo(0,5)==2){pezziVerdi[35].setVisible(true);pezziVerdi[35].setEnabled(true);}
			            if (gioco.controllaPezzo(5,6)==2){pezziVerdi[36].setVisible(true);pezziVerdi[36].setEnabled(true);}
			            if (gioco.controllaPezzo(4,6)==2){pezziVerdi[37].setVisible(true);pezziVerdi[37].setEnabled(true);}
			            if (gioco.controllaPezzo(3,6)==2){pezziVerdi[38].setVisible(true);pezziVerdi[38].setEnabled(true);}
			            if (gioco.controllaPezzo(2,6)==2){pezziVerdi[39].setVisible(true);pezziVerdi[39].setEnabled(true);}
			            if (gioco.controllaPezzo(1,6)==2){pezziVerdi[40].setVisible(true);pezziVerdi[40].setEnabled(true);}
			            if (gioco.controllaPezzo(0,6)==2){pezziVerdi[41].setVisible(true);pezziVerdi[41].setEnabled(true);}
		            }	
	            }
	            if (gioco.controlloVincitaPC()==true){
	            	JOptionPane.showMessageDialog(null,"Peccato, hai perso :(","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}	            
			}
		});		
		
		frecce[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				gioco.inserisciPezzoRosso(3);
	            if (gioco.controllaPezzo(5,2)==1){pezziRossi[12].setVisible(true);pezziRossi[12].setEnabled(true);}
	            if (gioco.controllaPezzo(4,2)==1){pezziRossi[13].setVisible(true);pezziRossi[13].setEnabled(true);}
	            if (gioco.controllaPezzo(3,2)==1){pezziRossi[14].setVisible(true);pezziRossi[14].setEnabled(true);}
	            if (gioco.controllaPezzo(2,2)==1){pezziRossi[15].setVisible(true);pezziRossi[15].setEnabled(true);}
	            if (gioco.controllaPezzo(1,2)==1){pezziRossi[16].setVisible(true);pezziRossi[16].setEnabled(true);}
	            if (gioco.controllaPezzo(0,2)==1){pezziRossi[17].setVisible(true);pezziRossi[17].setEnabled(true);}
	            if (gioco.controlloVincita()==true){
	            	JOptionPane.showMessageDialog(null,"Complimenti, hai vinto! :)","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
	            	for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}
	            else{
		            gioco.inserisciPezzoVerde(gioco.IA());
		            if (vincita == false){
		            	if (gioco.controllaPezzo(5,0)==2){pezziVerdi[0].setVisible(true);pezziVerdi[0].setEnabled(true);}
		            	if (gioco.controllaPezzo(4,0)==2){pezziVerdi[1].setVisible(true);pezziVerdi[1].setEnabled(true);}
		            	if (gioco.controllaPezzo(3,0)==2){pezziVerdi[2].setVisible(true);pezziVerdi[2].setEnabled(true);}
		            	if (gioco.controllaPezzo(2,0)==2){pezziVerdi[3].setVisible(true);pezziVerdi[3].setEnabled(true);}
		            	if (gioco.controllaPezzo(1,0)==2){pezziVerdi[4].setVisible(true);pezziVerdi[4].setEnabled(true);}
		            	if (gioco.controllaPezzo(0,0)==2){pezziVerdi[5].setVisible(true);pezziVerdi[5].setEnabled(true);}
		            	if (gioco.controllaPezzo(5,1)==2){pezziVerdi[6].setVisible(true);pezziVerdi[6].setEnabled(true);}
			            if (gioco.controllaPezzo(4,1)==2){pezziVerdi[7].setVisible(true);pezziVerdi[7].setEnabled(true);}
			            if (gioco.controllaPezzo(3,1)==2){pezziVerdi[8].setVisible(true);pezziVerdi[8].setEnabled(true);}
			            if (gioco.controllaPezzo(2,1)==2){pezziVerdi[9].setVisible(true);pezziVerdi[9].setEnabled(true);}
			            if (gioco.controllaPezzo(1,1)==2){pezziVerdi[10].setVisible(true);pezziVerdi[10].setEnabled(true);}
			            if (gioco.controllaPezzo(0,1)==2){pezziVerdi[11].setVisible(true);pezziVerdi[11].setEnabled(true);}
			            if (gioco.controllaPezzo(5,2)==2){pezziVerdi[12].setVisible(true);pezziVerdi[12].setEnabled(true);}
			            if (gioco.controllaPezzo(4,2)==2){pezziVerdi[13].setVisible(true);pezziVerdi[13].setEnabled(true);}
			            if (gioco.controllaPezzo(3,2)==2){pezziVerdi[14].setVisible(true);pezziVerdi[14].setEnabled(true);}
			            if (gioco.controllaPezzo(2,2)==2){pezziVerdi[15].setVisible(true);pezziVerdi[15].setEnabled(true);}
			            if (gioco.controllaPezzo(1,2)==2){pezziVerdi[16].setVisible(true);pezziVerdi[16].setEnabled(true);}
			            if (gioco.controllaPezzo(0,2)==2){pezziVerdi[17].setVisible(true);pezziVerdi[17].setEnabled(true);}
			            if (gioco.controllaPezzo(5,3)==2){pezziVerdi[18].setVisible(true);pezziVerdi[18].setEnabled(true);}
			            if (gioco.controllaPezzo(4,3)==2){pezziVerdi[19].setVisible(true);pezziVerdi[19].setEnabled(true);}
			            if (gioco.controllaPezzo(3,3)==2){pezziVerdi[20].setVisible(true);pezziVerdi[20].setEnabled(true);}
			            if (gioco.controllaPezzo(2,3)==2){pezziVerdi[21].setVisible(true);pezziVerdi[21].setEnabled(true);}
			            if (gioco.controllaPezzo(1,3)==2){pezziVerdi[22].setVisible(true);pezziVerdi[22].setEnabled(true);}
			            if (gioco.controllaPezzo(0,3)==2){pezziVerdi[23].setVisible(true);pezziVerdi[23].setEnabled(true);}
			            if (gioco.controllaPezzo(5,4)==2){pezziVerdi[24].setVisible(true);pezziVerdi[24].setEnabled(true);}
			            if (gioco.controllaPezzo(4,4)==2){pezziVerdi[25].setVisible(true);pezziVerdi[25].setEnabled(true);}
			            if (gioco.controllaPezzo(3,4)==2){pezziVerdi[26].setVisible(true);pezziVerdi[26].setEnabled(true);}
			            if (gioco.controllaPezzo(2,4)==2){pezziVerdi[27].setVisible(true);pezziVerdi[27].setEnabled(true);}
			            if (gioco.controllaPezzo(1,4)==2){pezziVerdi[28].setVisible(true);pezziVerdi[28].setEnabled(true);}
			            if (gioco.controllaPezzo(0,4)==2){pezziVerdi[29].setVisible(true);pezziVerdi[29].setEnabled(true);}
			            if (gioco.controllaPezzo(5,5)==2){pezziVerdi[30].setVisible(true);pezziVerdi[30].setEnabled(true);}
			            if (gioco.controllaPezzo(4,5)==2){pezziVerdi[31].setVisible(true);pezziVerdi[31].setEnabled(true);}
			            if (gioco.controllaPezzo(3,5)==2){pezziVerdi[32].setVisible(true);pezziVerdi[32].setEnabled(true);}
			            if (gioco.controllaPezzo(2,5)==2){pezziVerdi[33].setVisible(true);pezziVerdi[33].setEnabled(true);}
			            if (gioco.controllaPezzo(1,5)==2){pezziVerdi[34].setVisible(true);pezziVerdi[34].setEnabled(true);}
			            if (gioco.controllaPezzo(0,5)==2){pezziVerdi[35].setVisible(true);pezziVerdi[35].setEnabled(true);}
			            if (gioco.controllaPezzo(5,6)==2){pezziVerdi[36].setVisible(true);pezziVerdi[36].setEnabled(true);}
			            if (gioco.controllaPezzo(4,6)==2){pezziVerdi[37].setVisible(true);pezziVerdi[37].setEnabled(true);}
			            if (gioco.controllaPezzo(3,6)==2){pezziVerdi[38].setVisible(true);pezziVerdi[38].setEnabled(true);}
			            if (gioco.controllaPezzo(2,6)==2){pezziVerdi[39].setVisible(true);pezziVerdi[39].setEnabled(true);}
			            if (gioco.controllaPezzo(1,6)==2){pezziVerdi[40].setVisible(true);pezziVerdi[40].setEnabled(true);}
			            if (gioco.controllaPezzo(0,6)==2){pezziVerdi[41].setVisible(true);pezziVerdi[41].setEnabled(true);}
		            }
	            }
	            if (gioco.controlloVincitaPC()==true){
	            	JOptionPane.showMessageDialog(null,"Peccato, hai perso :(","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}	            
			}
		});	
		
		frecce[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				gioco.inserisciPezzoRosso(4);
	            if (gioco.controllaPezzo(5,3)==1){pezziRossi[18].setVisible(true);pezziRossi[18].setEnabled(true);}
	            if (gioco.controllaPezzo(4,3)==1){pezziRossi[19].setVisible(true);pezziRossi[19].setEnabled(true);}
	            if (gioco.controllaPezzo(3,3)==1){pezziRossi[20].setVisible(true);pezziRossi[20].setEnabled(true);}
	            if (gioco.controllaPezzo(2,3)==1){pezziRossi[21].setVisible(true);pezziRossi[21].setEnabled(true);}
	            if (gioco.controllaPezzo(1,3)==1){pezziRossi[22].setVisible(true);pezziRossi[22].setEnabled(true);}
	            if (gioco.controllaPezzo(0,3)==1){pezziRossi[23].setVisible(true);pezziRossi[23].setEnabled(true);}
	            if (gioco.controlloVincita()==true){
	            	JOptionPane.showMessageDialog(null,"Complimenti, hai vinto! :)","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
	            	for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}
	            else{
		            gioco.inserisciPezzoVerde(gioco.IA());
		            if (vincita == false){
		            	if (gioco.controllaPezzo(5,0)==2){pezziVerdi[0].setVisible(true);pezziVerdi[0].setEnabled(true);}
		            	if (gioco.controllaPezzo(4,0)==2){pezziVerdi[1].setVisible(true);pezziVerdi[1].setEnabled(true);}
		            	if (gioco.controllaPezzo(3,0)==2){pezziVerdi[2].setVisible(true);pezziVerdi[2].setEnabled(true);}
		            	if (gioco.controllaPezzo(2,0)==2){pezziVerdi[3].setVisible(true);pezziVerdi[3].setEnabled(true);}
		            	if (gioco.controllaPezzo(1,0)==2){pezziVerdi[4].setVisible(true);pezziVerdi[4].setEnabled(true);}
		            	if (gioco.controllaPezzo(0,0)==2){pezziVerdi[5].setVisible(true);pezziVerdi[5].setEnabled(true);}
		            	if (gioco.controllaPezzo(5,1)==2){pezziVerdi[6].setVisible(true);pezziVerdi[6].setEnabled(true);}
			            if (gioco.controllaPezzo(4,1)==2){pezziVerdi[7].setVisible(true);pezziVerdi[7].setEnabled(true);}
			            if (gioco.controllaPezzo(3,1)==2){pezziVerdi[8].setVisible(true);pezziVerdi[8].setEnabled(true);}
			            if (gioco.controllaPezzo(2,1)==2){pezziVerdi[9].setVisible(true);pezziVerdi[9].setEnabled(true);}
			            if (gioco.controllaPezzo(1,1)==2){pezziVerdi[10].setVisible(true);pezziVerdi[10].setEnabled(true);}
			            if (gioco.controllaPezzo(0,1)==2){pezziVerdi[11].setVisible(true);pezziVerdi[11].setEnabled(true);}
			            if (gioco.controllaPezzo(5,2)==2){pezziVerdi[12].setVisible(true);pezziVerdi[12].setEnabled(true);}
			            if (gioco.controllaPezzo(4,2)==2){pezziVerdi[13].setVisible(true);pezziVerdi[13].setEnabled(true);}
			            if (gioco.controllaPezzo(3,2)==2){pezziVerdi[14].setVisible(true);pezziVerdi[14].setEnabled(true);}
			            if (gioco.controllaPezzo(2,2)==2){pezziVerdi[15].setVisible(true);pezziVerdi[15].setEnabled(true);}
			            if (gioco.controllaPezzo(1,2)==2){pezziVerdi[16].setVisible(true);pezziVerdi[16].setEnabled(true);}
			            if (gioco.controllaPezzo(0,2)==2){pezziVerdi[17].setVisible(true);pezziVerdi[17].setEnabled(true);}
			            if (gioco.controllaPezzo(5,3)==2){pezziVerdi[18].setVisible(true);pezziVerdi[18].setEnabled(true);}
			            if (gioco.controllaPezzo(4,3)==2){pezziVerdi[19].setVisible(true);pezziVerdi[19].setEnabled(true);}
			            if (gioco.controllaPezzo(3,3)==2){pezziVerdi[20].setVisible(true);pezziVerdi[20].setEnabled(true);}
			            if (gioco.controllaPezzo(2,3)==2){pezziVerdi[21].setVisible(true);pezziVerdi[21].setEnabled(true);}
			            if (gioco.controllaPezzo(1,3)==2){pezziVerdi[22].setVisible(true);pezziVerdi[22].setEnabled(true);}
			            if (gioco.controllaPezzo(0,3)==2){pezziVerdi[23].setVisible(true);pezziVerdi[23].setEnabled(true);}
			            if (gioco.controllaPezzo(5,4)==2){pezziVerdi[24].setVisible(true);pezziVerdi[24].setEnabled(true);}
			            if (gioco.controllaPezzo(4,4)==2){pezziVerdi[25].setVisible(true);pezziVerdi[25].setEnabled(true);}
			            if (gioco.controllaPezzo(3,4)==2){pezziVerdi[26].setVisible(true);pezziVerdi[26].setEnabled(true);}
			            if (gioco.controllaPezzo(2,4)==2){pezziVerdi[27].setVisible(true);pezziVerdi[27].setEnabled(true);}
			            if (gioco.controllaPezzo(1,4)==2){pezziVerdi[28].setVisible(true);pezziVerdi[28].setEnabled(true);}
			            if (gioco.controllaPezzo(0,4)==2){pezziVerdi[29].setVisible(true);pezziVerdi[29].setEnabled(true);}
			            if (gioco.controllaPezzo(5,5)==2){pezziVerdi[30].setVisible(true);pezziVerdi[30].setEnabled(true);}
			            if (gioco.controllaPezzo(4,5)==2){pezziVerdi[31].setVisible(true);pezziVerdi[31].setEnabled(true);}
			            if (gioco.controllaPezzo(3,5)==2){pezziVerdi[32].setVisible(true);pezziVerdi[32].setEnabled(true);}
			            if (gioco.controllaPezzo(2,5)==2){pezziVerdi[33].setVisible(true);pezziVerdi[33].setEnabled(true);}
			            if (gioco.controllaPezzo(1,5)==2){pezziVerdi[34].setVisible(true);pezziVerdi[34].setEnabled(true);}
			            if (gioco.controllaPezzo(0,5)==2){pezziVerdi[35].setVisible(true);pezziVerdi[35].setEnabled(true);}
			            if (gioco.controllaPezzo(5,6)==2){pezziVerdi[36].setVisible(true);pezziVerdi[36].setEnabled(true);}
			            if (gioco.controllaPezzo(4,6)==2){pezziVerdi[37].setVisible(true);pezziVerdi[37].setEnabled(true);}
			            if (gioco.controllaPezzo(3,6)==2){pezziVerdi[38].setVisible(true);pezziVerdi[38].setEnabled(true);}
			            if (gioco.controllaPezzo(2,6)==2){pezziVerdi[39].setVisible(true);pezziVerdi[39].setEnabled(true);}
			            if (gioco.controllaPezzo(1,6)==2){pezziVerdi[40].setVisible(true);pezziVerdi[40].setEnabled(true);}
			            if (gioco.controllaPezzo(0,6)==2){pezziVerdi[41].setVisible(true);pezziVerdi[41].setEnabled(true);}
		            }	
	            }
	            if (gioco.controlloVincitaPC()==true){
	            	JOptionPane.showMessageDialog(null,"Peccato, hai perso :(","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}	            
			}
		});	
		
		frecce[4].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				gioco.inserisciPezzoRosso(5);
	            if (gioco.controllaPezzo(5,4)==1){pezziRossi[24].setVisible(true);pezziRossi[24].setEnabled(true);}
	            if (gioco.controllaPezzo(4,4)==1){pezziRossi[25].setVisible(true);pezziRossi[25].setEnabled(true);}
	            if (gioco.controllaPezzo(3,4)==1){pezziRossi[26].setVisible(true);pezziRossi[26].setEnabled(true);}
	            if (gioco.controllaPezzo(2,4)==1){pezziRossi[27].setVisible(true);pezziRossi[27].setEnabled(true);}
	            if (gioco.controllaPezzo(1,4)==1){pezziRossi[28].setVisible(true);pezziRossi[28].setEnabled(true);}
	            if (gioco.controllaPezzo(0,4)==1){pezziRossi[29].setVisible(true);pezziRossi[29].setEnabled(true);}
	            if (gioco.controlloVincita()==true){
	            	JOptionPane.showMessageDialog(null,"Complimenti, hai vinto! :)","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
	            	for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}
	            else{
		            gioco.inserisciPezzoVerde(gioco.IA());
		            if (vincita == false){
		            	if (gioco.controllaPezzo(5,0)==2){pezziVerdi[0].setVisible(true);pezziVerdi[0].setEnabled(true);}
		            	if (gioco.controllaPezzo(4,0)==2){pezziVerdi[1].setVisible(true);pezziVerdi[1].setEnabled(true);}
		            	if (gioco.controllaPezzo(3,0)==2){pezziVerdi[2].setVisible(true);pezziVerdi[2].setEnabled(true);}
		            	if (gioco.controllaPezzo(2,0)==2){pezziVerdi[3].setVisible(true);pezziVerdi[3].setEnabled(true);}
		            	if (gioco.controllaPezzo(1,0)==2){pezziVerdi[4].setVisible(true);pezziVerdi[4].setEnabled(true);}
		            	if (gioco.controllaPezzo(0,0)==2){pezziVerdi[5].setVisible(true);pezziVerdi[5].setEnabled(true);}
		            	if (gioco.controllaPezzo(5,1)==2){pezziVerdi[6].setVisible(true);pezziVerdi[6].setEnabled(true);}
			            if (gioco.controllaPezzo(4,1)==2){pezziVerdi[7].setVisible(true);pezziVerdi[7].setEnabled(true);}
			            if (gioco.controllaPezzo(3,1)==2){pezziVerdi[8].setVisible(true);pezziVerdi[8].setEnabled(true);}
			            if (gioco.controllaPezzo(2,1)==2){pezziVerdi[9].setVisible(true);pezziVerdi[9].setEnabled(true);}
			            if (gioco.controllaPezzo(1,1)==2){pezziVerdi[10].setVisible(true);pezziVerdi[10].setEnabled(true);}
			            if (gioco.controllaPezzo(0,1)==2){pezziVerdi[11].setVisible(true);pezziVerdi[11].setEnabled(true);}
			            if (gioco.controllaPezzo(5,2)==2){pezziVerdi[12].setVisible(true);pezziVerdi[12].setEnabled(true);}
			            if (gioco.controllaPezzo(4,2)==2){pezziVerdi[13].setVisible(true);pezziVerdi[13].setEnabled(true);}
			            if (gioco.controllaPezzo(3,2)==2){pezziVerdi[14].setVisible(true);pezziVerdi[14].setEnabled(true);}
			            if (gioco.controllaPezzo(2,2)==2){pezziVerdi[15].setVisible(true);pezziVerdi[15].setEnabled(true);}
			            if (gioco.controllaPezzo(1,2)==2){pezziVerdi[16].setVisible(true);pezziVerdi[16].setEnabled(true);}
			            if (gioco.controllaPezzo(0,2)==2){pezziVerdi[17].setVisible(true);pezziVerdi[17].setEnabled(true);}
			            if (gioco.controllaPezzo(5,3)==2){pezziVerdi[18].setVisible(true);pezziVerdi[18].setEnabled(true);}
			            if (gioco.controllaPezzo(4,3)==2){pezziVerdi[19].setVisible(true);pezziVerdi[19].setEnabled(true);}
			            if (gioco.controllaPezzo(3,3)==2){pezziVerdi[20].setVisible(true);pezziVerdi[20].setEnabled(true);}
			            if (gioco.controllaPezzo(2,3)==2){pezziVerdi[21].setVisible(true);pezziVerdi[21].setEnabled(true);}
			            if (gioco.controllaPezzo(1,3)==2){pezziVerdi[22].setVisible(true);pezziVerdi[22].setEnabled(true);}
			            if (gioco.controllaPezzo(0,3)==2){pezziVerdi[23].setVisible(true);pezziVerdi[23].setEnabled(true);}
			            if (gioco.controllaPezzo(5,4)==2){pezziVerdi[24].setVisible(true);pezziVerdi[24].setEnabled(true);}
			            if (gioco.controllaPezzo(4,4)==2){pezziVerdi[25].setVisible(true);pezziVerdi[25].setEnabled(true);}
			            if (gioco.controllaPezzo(3,4)==2){pezziVerdi[26].setVisible(true);pezziVerdi[26].setEnabled(true);}
			            if (gioco.controllaPezzo(2,4)==2){pezziVerdi[27].setVisible(true);pezziVerdi[27].setEnabled(true);}
			            if (gioco.controllaPezzo(1,4)==2){pezziVerdi[28].setVisible(true);pezziVerdi[28].setEnabled(true);}
			            if (gioco.controllaPezzo(0,4)==2){pezziVerdi[29].setVisible(true);pezziVerdi[29].setEnabled(true);}
			            if (gioco.controllaPezzo(5,5)==2){pezziVerdi[30].setVisible(true);pezziVerdi[30].setEnabled(true);}
			            if (gioco.controllaPezzo(4,5)==2){pezziVerdi[31].setVisible(true);pezziVerdi[31].setEnabled(true);}
			            if (gioco.controllaPezzo(3,5)==2){pezziVerdi[32].setVisible(true);pezziVerdi[32].setEnabled(true);}
			            if (gioco.controllaPezzo(2,5)==2){pezziVerdi[33].setVisible(true);pezziVerdi[33].setEnabled(true);}
			            if (gioco.controllaPezzo(1,5)==2){pezziVerdi[34].setVisible(true);pezziVerdi[34].setEnabled(true);}
			            if (gioco.controllaPezzo(0,5)==2){pezziVerdi[35].setVisible(true);pezziVerdi[35].setEnabled(true);}
			            if (gioco.controllaPezzo(5,6)==2){pezziVerdi[36].setVisible(true);pezziVerdi[36].setEnabled(true);}
			            if (gioco.controllaPezzo(4,6)==2){pezziVerdi[37].setVisible(true);pezziVerdi[37].setEnabled(true);}
			            if (gioco.controllaPezzo(3,6)==2){pezziVerdi[38].setVisible(true);pezziVerdi[38].setEnabled(true);}
			            if (gioco.controllaPezzo(2,6)==2){pezziVerdi[39].setVisible(true);pezziVerdi[39].setEnabled(true);}
			            if (gioco.controllaPezzo(1,6)==2){pezziVerdi[40].setVisible(true);pezziVerdi[40].setEnabled(true);}
			            if (gioco.controllaPezzo(0,6)==2){pezziVerdi[41].setVisible(true);pezziVerdi[41].setEnabled(true);}
		            }
	            }
	            if (gioco.controlloVincitaPC()==true){
	            	JOptionPane.showMessageDialog(null,"Peccato, hai perso :(","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}	            
			}
		});	
		
		frecce[5].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				gioco.inserisciPezzoRosso(6);
	            if (gioco.controllaPezzo(5,5)==1){pezziRossi[30].setVisible(true);pezziRossi[30].setEnabled(true);}
	            if (gioco.controllaPezzo(4,5)==1){pezziRossi[31].setVisible(true);pezziRossi[31].setEnabled(true);}
	            if (gioco.controllaPezzo(3,5)==1){pezziRossi[32].setVisible(true);pezziRossi[32].setEnabled(true);}
	            if (gioco.controllaPezzo(2,5)==1){pezziRossi[33].setVisible(true);pezziRossi[33].setEnabled(true);}
	            if (gioco.controllaPezzo(1,5)==1){pezziRossi[34].setVisible(true);pezziRossi[34].setEnabled(true);}
	            if (gioco.controllaPezzo(0,5)==1){pezziRossi[35].setVisible(true);pezziRossi[35].setEnabled(true);}
	            if (gioco.controlloVincita()==true){
	            	JOptionPane.showMessageDialog(null,"Complimenti, hai vinto! :)","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
	            	for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}
	            else{
		            gioco.inserisciPezzoVerde(gioco.IA());
		            if (vincita == false){
		            	if (gioco.controllaPezzo(5,0)==2){pezziVerdi[0].setVisible(true);pezziVerdi[0].setEnabled(true);}
		            	if (gioco.controllaPezzo(4,0)==2){pezziVerdi[1].setVisible(true);pezziVerdi[1].setEnabled(true);}
		            	if (gioco.controllaPezzo(3,0)==2){pezziVerdi[2].setVisible(true);pezziVerdi[2].setEnabled(true);}
		            	if (gioco.controllaPezzo(2,0)==2){pezziVerdi[3].setVisible(true);pezziVerdi[3].setEnabled(true);}
		            	if (gioco.controllaPezzo(1,0)==2){pezziVerdi[4].setVisible(true);pezziVerdi[4].setEnabled(true);}
		            	if (gioco.controllaPezzo(0,0)==2){pezziVerdi[5].setVisible(true);pezziVerdi[5].setEnabled(true);}
		            	if (gioco.controllaPezzo(5,1)==2){pezziVerdi[6].setVisible(true);pezziVerdi[6].setEnabled(true);}
			            if (gioco.controllaPezzo(4,1)==2){pezziVerdi[7].setVisible(true);pezziVerdi[7].setEnabled(true);}
			            if (gioco.controllaPezzo(3,1)==2){pezziVerdi[8].setVisible(true);pezziVerdi[8].setEnabled(true);}
			            if (gioco.controllaPezzo(2,1)==2){pezziVerdi[9].setVisible(true);pezziVerdi[9].setEnabled(true);}
			            if (gioco.controllaPezzo(1,1)==2){pezziVerdi[10].setVisible(true);pezziVerdi[10].setEnabled(true);}
			            if (gioco.controllaPezzo(0,1)==2){pezziVerdi[11].setVisible(true);pezziVerdi[11].setEnabled(true);}
			            if (gioco.controllaPezzo(5,2)==2){pezziVerdi[12].setVisible(true);pezziVerdi[12].setEnabled(true);}
			            if (gioco.controllaPezzo(4,2)==2){pezziVerdi[13].setVisible(true);pezziVerdi[13].setEnabled(true);}
			            if (gioco.controllaPezzo(3,2)==2){pezziVerdi[14].setVisible(true);pezziVerdi[14].setEnabled(true);}
			            if (gioco.controllaPezzo(2,2)==2){pezziVerdi[15].setVisible(true);pezziVerdi[15].setEnabled(true);}
			            if (gioco.controllaPezzo(1,2)==2){pezziVerdi[16].setVisible(true);pezziVerdi[16].setEnabled(true);}
			            if (gioco.controllaPezzo(0,2)==2){pezziVerdi[17].setVisible(true);pezziVerdi[17].setEnabled(true);}
			            if (gioco.controllaPezzo(5,3)==2){pezziVerdi[18].setVisible(true);pezziVerdi[18].setEnabled(true);}
			            if (gioco.controllaPezzo(4,3)==2){pezziVerdi[19].setVisible(true);pezziVerdi[19].setEnabled(true);}
			            if (gioco.controllaPezzo(3,3)==2){pezziVerdi[20].setVisible(true);pezziVerdi[20].setEnabled(true);}
			            if (gioco.controllaPezzo(2,3)==2){pezziVerdi[21].setVisible(true);pezziVerdi[21].setEnabled(true);}
			            if (gioco.controllaPezzo(1,3)==2){pezziVerdi[22].setVisible(true);pezziVerdi[22].setEnabled(true);}
			            if (gioco.controllaPezzo(0,3)==2){pezziVerdi[23].setVisible(true);pezziVerdi[23].setEnabled(true);}
			            if (gioco.controllaPezzo(5,4)==2){pezziVerdi[24].setVisible(true);pezziVerdi[24].setEnabled(true);}
			            if (gioco.controllaPezzo(4,4)==2){pezziVerdi[25].setVisible(true);pezziVerdi[25].setEnabled(true);}
			            if (gioco.controllaPezzo(3,4)==2){pezziVerdi[26].setVisible(true);pezziVerdi[26].setEnabled(true);}
			            if (gioco.controllaPezzo(2,4)==2){pezziVerdi[27].setVisible(true);pezziVerdi[27].setEnabled(true);}
			            if (gioco.controllaPezzo(1,4)==2){pezziVerdi[28].setVisible(true);pezziVerdi[28].setEnabled(true);}
			            if (gioco.controllaPezzo(0,4)==2){pezziVerdi[29].setVisible(true);pezziVerdi[29].setEnabled(true);}
			            if (gioco.controllaPezzo(5,5)==2){pezziVerdi[30].setVisible(true);pezziVerdi[30].setEnabled(true);}
			            if (gioco.controllaPezzo(4,5)==2){pezziVerdi[31].setVisible(true);pezziVerdi[31].setEnabled(true);}
			            if (gioco.controllaPezzo(3,5)==2){pezziVerdi[32].setVisible(true);pezziVerdi[32].setEnabled(true);}
			            if (gioco.controllaPezzo(2,5)==2){pezziVerdi[33].setVisible(true);pezziVerdi[33].setEnabled(true);}
			            if (gioco.controllaPezzo(1,5)==2){pezziVerdi[34].setVisible(true);pezziVerdi[34].setEnabled(true);}
			            if (gioco.controllaPezzo(0,5)==2){pezziVerdi[35].setVisible(true);pezziVerdi[35].setEnabled(true);}
			            if (gioco.controllaPezzo(5,6)==2){pezziVerdi[36].setVisible(true);pezziVerdi[36].setEnabled(true);}
			            if (gioco.controllaPezzo(4,6)==2){pezziVerdi[37].setVisible(true);pezziVerdi[37].setEnabled(true);}
			            if (gioco.controllaPezzo(3,6)==2){pezziVerdi[38].setVisible(true);pezziVerdi[38].setEnabled(true);}
			            if (gioco.controllaPezzo(2,6)==2){pezziVerdi[39].setVisible(true);pezziVerdi[39].setEnabled(true);}
			            if (gioco.controllaPezzo(1,6)==2){pezziVerdi[40].setVisible(true);pezziVerdi[40].setEnabled(true);}
			            if (gioco.controllaPezzo(0,6)==2){pezziVerdi[41].setVisible(true);pezziVerdi[41].setEnabled(true);}
		            }
	            }
	            if (gioco.controlloVincitaPC()==true){
	            	JOptionPane.showMessageDialog(null,"Peccato, hai perso :(","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}	            
			}
		});		
		
		frecce[6].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				gioco.inserisciPezzoRosso(7);
	            if (gioco.controllaPezzo(5,6)==1){pezziRossi[36].setVisible(true);pezziRossi[36].setEnabled(true);}
	            if (gioco.controllaPezzo(4,6)==1){pezziRossi[37].setVisible(true);pezziRossi[37].setEnabled(true);}
	            if (gioco.controllaPezzo(3,6)==1){pezziRossi[38].setVisible(true);pezziRossi[38].setEnabled(true);}
	            if (gioco.controllaPezzo(2,6)==1){pezziRossi[39].setVisible(true);pezziRossi[39].setEnabled(true);}
	            if (gioco.controllaPezzo(1,6)==1){pezziRossi[40].setVisible(true);pezziRossi[40].setEnabled(true);}
	            if (gioco.controllaPezzo(0,6)==1){pezziRossi[41].setVisible(true);pezziRossi[41].setEnabled(true);}
	            if (gioco.controlloVincita()==true){
	            	JOptionPane.showMessageDialog(null,"Complimenti, hai vinto! :)","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
	            	for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}
	            else{
		            gioco.inserisciPezzoVerde(gioco.IA());
		            if (vincita == false){
		            	if (gioco.controllaPezzo(5,0)==2){pezziVerdi[0].setVisible(true);pezziVerdi[0].setEnabled(true);}
		            	if (gioco.controllaPezzo(4,0)==2){pezziVerdi[1].setVisible(true);pezziVerdi[1].setEnabled(true);}
		            	if (gioco.controllaPezzo(3,0)==2){pezziVerdi[2].setVisible(true);pezziVerdi[2].setEnabled(true);}
		            	if (gioco.controllaPezzo(2,0)==2){pezziVerdi[3].setVisible(true);pezziVerdi[3].setEnabled(true);}
		            	if (gioco.controllaPezzo(1,0)==2){pezziVerdi[4].setVisible(true);pezziVerdi[4].setEnabled(true);}
		            	if (gioco.controllaPezzo(0,0)==2){pezziVerdi[5].setVisible(true);pezziVerdi[5].setEnabled(true);}
		            	if (gioco.controllaPezzo(5,1)==2){pezziVerdi[6].setVisible(true);pezziVerdi[6].setEnabled(true);}
			            if (gioco.controllaPezzo(4,1)==2){pezziVerdi[7].setVisible(true);pezziVerdi[7].setEnabled(true);}
			            if (gioco.controllaPezzo(3,1)==2){pezziVerdi[8].setVisible(true);pezziVerdi[8].setEnabled(true);}
			            if (gioco.controllaPezzo(2,1)==2){pezziVerdi[9].setVisible(true);pezziVerdi[9].setEnabled(true);}
			            if (gioco.controllaPezzo(1,1)==2){pezziVerdi[10].setVisible(true);pezziVerdi[10].setEnabled(true);}
			            if (gioco.controllaPezzo(0,1)==2){pezziVerdi[11].setVisible(true);pezziVerdi[11].setEnabled(true);}
			            if (gioco.controllaPezzo(5,2)==2){pezziVerdi[12].setVisible(true);pezziVerdi[12].setEnabled(true);}
			            if (gioco.controllaPezzo(4,2)==2){pezziVerdi[13].setVisible(true);pezziVerdi[13].setEnabled(true);}
			            if (gioco.controllaPezzo(3,2)==2){pezziVerdi[14].setVisible(true);pezziVerdi[14].setEnabled(true);}
			            if (gioco.controllaPezzo(2,2)==2){pezziVerdi[15].setVisible(true);pezziVerdi[15].setEnabled(true);}
			            if (gioco.controllaPezzo(1,2)==2){pezziVerdi[16].setVisible(true);pezziVerdi[16].setEnabled(true);}
			            if (gioco.controllaPezzo(0,2)==2){pezziVerdi[17].setVisible(true);pezziVerdi[17].setEnabled(true);}
			            if (gioco.controllaPezzo(5,3)==2){pezziVerdi[18].setVisible(true);pezziVerdi[18].setEnabled(true);}
			            if (gioco.controllaPezzo(4,3)==2){pezziVerdi[19].setVisible(true);pezziVerdi[19].setEnabled(true);}
			            if (gioco.controllaPezzo(3,3)==2){pezziVerdi[20].setVisible(true);pezziVerdi[20].setEnabled(true);}
			            if (gioco.controllaPezzo(2,3)==2){pezziVerdi[21].setVisible(true);pezziVerdi[21].setEnabled(true);}
			            if (gioco.controllaPezzo(1,3)==2){pezziVerdi[22].setVisible(true);pezziVerdi[22].setEnabled(true);}
			            if (gioco.controllaPezzo(0,3)==2){pezziVerdi[23].setVisible(true);pezziVerdi[23].setEnabled(true);}
			            if (gioco.controllaPezzo(5,4)==2){pezziVerdi[24].setVisible(true);pezziVerdi[24].setEnabled(true);}
			            if (gioco.controllaPezzo(4,4)==2){pezziVerdi[25].setVisible(true);pezziVerdi[25].setEnabled(true);}
			            if (gioco.controllaPezzo(3,4)==2){pezziVerdi[26].setVisible(true);pezziVerdi[26].setEnabled(true);}
			            if (gioco.controllaPezzo(2,4)==2){pezziVerdi[27].setVisible(true);pezziVerdi[27].setEnabled(true);}
			            if (gioco.controllaPezzo(1,4)==2){pezziVerdi[28].setVisible(true);pezziVerdi[28].setEnabled(true);}
			            if (gioco.controllaPezzo(0,4)==2){pezziVerdi[29].setVisible(true);pezziVerdi[29].setEnabled(true);}
			            if (gioco.controllaPezzo(5,5)==2){pezziVerdi[30].setVisible(true);pezziVerdi[30].setEnabled(true);}
			            if (gioco.controllaPezzo(4,5)==2){pezziVerdi[31].setVisible(true);pezziVerdi[31].setEnabled(true);}
			            if (gioco.controllaPezzo(3,5)==2){pezziVerdi[32].setVisible(true);pezziVerdi[32].setEnabled(true);}
			            if (gioco.controllaPezzo(2,5)==2){pezziVerdi[33].setVisible(true);pezziVerdi[33].setEnabled(true);}
			            if (gioco.controllaPezzo(1,5)==2){pezziVerdi[34].setVisible(true);pezziVerdi[34].setEnabled(true);}
			            if (gioco.controllaPezzo(0,5)==2){pezziVerdi[35].setVisible(true);pezziVerdi[35].setEnabled(true);}
			            if (gioco.controllaPezzo(5,6)==2){pezziVerdi[36].setVisible(true);pezziVerdi[36].setEnabled(true);}
			            if (gioco.controllaPezzo(4,6)==2){pezziVerdi[37].setVisible(true);pezziVerdi[37].setEnabled(true);}
			            if (gioco.controllaPezzo(3,6)==2){pezziVerdi[38].setVisible(true);pezziVerdi[38].setEnabled(true);}
			            if (gioco.controllaPezzo(2,6)==2){pezziVerdi[39].setVisible(true);pezziVerdi[39].setEnabled(true);}
			            if (gioco.controllaPezzo(1,6)==2){pezziVerdi[40].setVisible(true);pezziVerdi[40].setEnabled(true);}
			            if (gioco.controllaPezzo(0,6)==2){pezziVerdi[41].setVisible(true);pezziVerdi[41].setEnabled(true);}
		            }	
	            }
	            if (gioco.controlloVincitaPC()==true){
	            	JOptionPane.showMessageDialog(null,"Peccato, hai perso :(","Ehi tu",JOptionPane.PLAIN_MESSAGE);
	            	vincita = true;
			        for(int i=0; i<7; i++)
			             frecce[i].setVisible(false);
	            	}	            
			}
		});			

		//Creazione Varie parti Grafiche
		final JLabel lblGiocatore = new JLabel("Giocatore");
		lblGiocatore.setFont(new Font("Aharoni", Font.PLAIN, 18));
		lblGiocatore.setBounds(41, 11, 95, 14);
		frmJforza.getContentPane().add(lblGiocatore);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBounds(41, 29, 95, 44);
		frmJforza.getContentPane().add(panel);
		
		JLabel lblpezzoGioc = new JLabel("");
		panel.add(lblpezzoGioc);
		lblpezzoGioc.setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/pezzoRosso.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(441, 29, 95, 44);
		frmJforza.getContentPane().add(panel_1);
		
		JLabel lblpezzoPC = new JLabel("");
		panel_1.add(lblpezzoPC);
		lblpezzoPC.setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/pezzoVerde.png")));
		
		JLabel lblComputer = new JLabel("Computer");
		lblComputer.setFont(new Font("Aharoni", Font.PLAIN, 18));
		lblComputer.setBounds(441, 11, 95, 14);
		frmJforza.getContentPane().add(lblComputer);
		
		JLabel titolo = new JLabel("");
		titolo.setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/jforza4.png")));
		titolo.setBounds(196, 0, 195, 84);
		frmJforza.getContentPane().add(titolo);

		//Barra dei menu
		JMenuBar menuBar = new JMenuBar();
		frmJforza.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNuonaPartita = new JMenuItem("Nuova Partita");
		mntmNuonaPartita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        gioco.azzeraTavoliere();
		        tavoliere.setEnabled(true);
		        for(int i=0; i<7; i++){
		             frecce[i].setEnabled(true);
		             frecce[i].setVisible(true);
		        }
		         for(int i=0; i<42; i++){
		            pezziRossi[i].setVisible(false);
		         	pezziVerdi[i].setVisible(false);
		         	}
		         vincita=false;
		         }
			});
		mntmNuonaPartita.setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/Play-128.png")));
		mntmNuonaPartita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNuonaPartita);
		
		JMenuItem mntmEsci = new JMenuItem("Esci");
		mntmEsci.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmEsci.setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/Gnome-Application-Exit-64.png")));
		mntmEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mnFile.add(mntmEsci);
		
		JMenu menu = new JMenu("?");
		menuBar.add(menu);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mntmInfo.setIcon(new ImageIcon(Tavoliere.class.getResource("/immagini/info-128.png")));
		mntmInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info dialog = new Info();
				dialog.setVisible(true);
			}
		});
		menu.add(mntmInfo);
	}
}