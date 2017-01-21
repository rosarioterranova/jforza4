package forza4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Info extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			Info dialog = new Info();
			dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Info() {
		setTitle("Informazioni");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Info.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setBounds(550, 250, 250, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblProgettatoDa = new JLabel("Progettato da: Rosario Terranova");
		lblProgettatoDa.setBounds(10, 82, 224, 14);
		contentPanel.add(lblProgettatoDa);
		
		JLabel lblVersione = new JLabel("Versione: 0.6.2");
		lblVersione.setBounds(10, 107, 214, 14);
		contentPanel.add(lblVersione);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Info.class.getResource("/immagini/icon.png")));
			label.setBounds(94, 11, 62, 60);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(Info.class.getResource("/immagini/512px-Copyleft.svg.png")));
				buttonPane.add(label);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
