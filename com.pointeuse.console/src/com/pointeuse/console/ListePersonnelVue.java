/**
 * 
 */
package com.pointeuse.console;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.pointeuse.jdbc.DaoH2;
import com.pointeuse.jdbc.Personnel;

/**
 * @author Pepe
 *
 */
public class ListePersonnelVue extends JFrame implements ActionListener {

	//Controle
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnModifier = new JButton("Modifier");
	private JButton btnSupprimer = new JButton("Supprimer");
	
	//Navigation
	private JButton btnPremier = new JButton("Premier");
	private JButton btnDernier = new JButton("Dernier");
	private JButton btnSuivant = new JButton("Suivant");
	private JButton btnPrecedent = new JButton("Precedent");
	private JLabel   lblNav = new JLabel("5 of 10");
	
	
	//formulaire
	private JLabel   lblMatricule = new JLabel("Matricule :");
	private JLabel   lblNom = new JLabel("Nom:");
	private JLabel   lblPrenom= new JLabel("Prenom:");
	
	private JTextField txtMatricule = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	
	//grille
	Vector<String> columnNames = new Vector<String>();
	
	JTable tblPersonnel = new JTable(new DefaultTableModel(new String[]{"MATRICULE","NOM","PRENOM"},5));
	
	private DaoH2 daoH2 = new DaoH2();
	
	/**
	 * 
	 */
	public ListePersonnelVue() {
		
	    Container ctnPane = getContentPane() ;	
	    ctnPane.setLayout( new BorderLayout() );	
		//permet de quitter le programme a la fermeture
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			/* (non-Javadoc)
			 * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				if (daoH2!=null) daoH2.disconnect();
				System.out.println("disconnect");
			}
		});
		setSize(400, 350);
		buildUI(ctnPane);
		daoH2.connect();
		configureListener();
		loadList();
		pack();
		setVisible(true);
		
	}

	
	private void loadList() {
		columnNames.add("MATRICULE");
		columnNames.add("NOM");
		columnNames.add("PRENOM");
	//	daoH2.loadData();
		
		List<Personnel> pers = daoH2.afficheListePersonnel();
		tblPersonnel.setModel(new PersonneTableModel(pers, columnNames));		
	}
	public void configureListener(){
		btnAjouter.addActionListener(this);
		btnModifier.addActionListener(this);
		btnSupprimer.addActionListener(this);
		
		btnPremier.addActionListener(this);
		btnPrecedent.addActionListener(this);
		btnSuivant.addActionListener(this);
		btnDernier.addActionListener(this);
		
		
	}
	public void buildUI(Container ctnPane)
	{
		JPanel pnlCtrl = new JPanel(new FlowLayout());
		pnlCtrl.add(btnAjouter);
		pnlCtrl.add(btnModifier);
		pnlCtrl.add(btnSupprimer);
		
		JPanel pnlNav = new JPanel(new FlowLayout());
		
			pnlNav.add(btnPremier);
			pnlNav.add(btnPrecedent);
			pnlNav.add(lblNav);
			pnlNav.add(btnSuivant);
			pnlNav.add(btnDernier);
			
		JScrollPane sclpTable = new JScrollPane(tblPersonnel);
		
		JPanel pnlTblNav = new JPanel(new BorderLayout());
		pnlTblNav.add(sclpTable,BorderLayout.NORTH);
		pnlTblNav.add(pnlNav,BorderLayout.SOUTH);
		
		JPanel pnlGrid = new JPanel(new BorderLayout());
		pnlGrid.add(pnlTblNav,BorderLayout.NORTH);
		pnlGrid.add(pnlCtrl,BorderLayout.SOUTH);
		
		
		JPanel pnlFrm = new JPanel(new GridLayout(3,2,10,10));
		
		pnlFrm.add(lblMatricule);
		pnlFrm.add(txtMatricule);
		
		pnlFrm.add(lblNom);
		pnlFrm.add(txtNom);
		pnlFrm.add(lblPrenom);
		pnlFrm.add(txtPrenom);
		
		JPanel pnl = new JPanel(new FlowLayout());
		pnl.setBorder(new TitledBorder("Information"));
		pnl.add(pnlFrm,FlowLayout.LEFT);
		ctnPane.add(pnlGrid,BorderLayout.CENTER);
		ctnPane.add(pnl,BorderLayout.EAST);
		
	}
	
	
	public static void main(String[] args) {
		
		// permet de lancer la vue principale dans un thread
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ListePersonnelVue ();
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnAjouter)){
			txtMatricule.requestFocus();
			
		}else if(e.getSource().equals(btnModifier)){
			
			txtMatricule.requestFocus();
		}else if(e.getSource().equals(btnSupprimer)){
		PersonneTableModel model =	(PersonneTableModel) tblPersonnel.getModel();
		model.removeRow();
			
		}else if(e.getSource().equals(btnPremier)){
			
		}else if(e.getSource().equals(btnPrecedent)){
			
		}else if(e.getSource().equals(btnSuivant)){
			
		}else if(e.getSource().equals(btnDernier)){
			
		}	
	}
}



class PersonneTableModel extends AbstractTableModel  
{
	List<Personnel> pers;
	Vector<String>  cols;

	public PersonneTableModel(List<Personnel> pers, Vector<String> cols)
	{
	 this.pers =pers;
	 this.cols=cols;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int column) {
		return cols.get(column);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {	
		return !true;
	}
	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Personnel personnel = pers.get(rowIndex);
		switch (columnIndex) {
		case 0:
			   personnel.setMatricule((String)aValue);
               break;			  
		case 1:
			personnel.setNom((String)aValue);
			  break;			  
		case 2:
			personnel.setPrenom((String)aValue);
			  break;				  
		}
	}
	@Override
	public int getColumnCount() {
		return cols.size();
	}
	@Override
	public int getRowCount() {
		
		return pers.size();
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		
		Personnel personnel =  pers.get(row);
		switch (col) {
		case 0:
                return personnel.getMatricule();			  
		case 1:
            return personnel.getNom();			  
		case 2:
            return personnel.getPrenom();			  
		}
		return personnel;
	}	
   public void removeRow(){    
	  	  pers.remove(5);
	  	  fireTableRowsDeleted(5, 5);
  }	
}
