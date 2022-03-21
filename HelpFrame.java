package view;

import java.awt.Font;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;

public class HelpFrame extends JDialog implements HyperlinkListener {

	private static final long serialVersionUID = 1L;
	private JEditorPane editor ;
	
	public HelpFrame() throws Exception {			
			File file = new File("./resource/manuel.html");
			String url = "file:///"+file.getCanonicalPath();
			editor = new JEditorPane(new URL(url));
			editor.setEditable(false);
			editor.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 14));
			editor.addHyperlinkListener(this);
			this.setBounds(300,50,750,600);
			//this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setTitle("Manuel DES");
			this.setResizable(false);
			this.getContentPane().add(new JScrollPane(editor));			
	}
	
	private void getPage(String adresse){
		try{
			URL url = new URL(adresse);
			editor.setPage(url);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Impossible d'ouvrir la page", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {		
		 HyperlinkEvent.EventType type = e.getEventType();
	      if (type == HyperlinkEvent.EventType.ACTIVATED) getPage(e.getURL().toExternalForm());
	}
	
	/*public static void main(String[] arg) throws Exception{
		new HelpFrame().setVisible(true);
	}*/
}
