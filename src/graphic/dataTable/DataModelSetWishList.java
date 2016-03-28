package graphic.dataTable;

import javax.swing.table.AbstractTableModel;

public class DataModelSetWishList extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private Object[][] data;
	private String[] title;

	// Constructeur
	public DataModelSetWishList(Object[][] data, String[] title) {
		this.data = data;
		this.title = title;
	}

	// Retourne le titre de la colonne � l'indice sp�cifi�
	public String getColumnName(int col) {
		return this.title[col];
	}

	// Retourne le nombre de colonnes
	public int getColumnCount() {
		return this.title.length;
	}

	// Retourne le nombre de lignes
	public int getRowCount() {
		return this.data.length;
	}

	// Retourne la valeur � l'emplacement sp�cifi�
	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	// D�finit la valeur � l'emplacement sp�cifi�
	public void setValueAt(Object value, int row, int col) {
		// On interdit la modification sur certaines colonnes !
		if (!this.getColumnName(col).equals("Acc�s"))
			this.data[row][col] = "Access";
	}

	// Retourne la classe de la donn�e de la colonne
	public Class<? extends Object> getColumnClass(int col) {
		return this.data[0][col].getClass();
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 0) {
			return false ;
		}
		return true;
	}
}
