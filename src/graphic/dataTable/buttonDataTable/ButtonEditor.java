package graphic.dataTable.buttonDataTable;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ButtonEditor extends DefaultCellEditor {
	private static final long serialVersionUID = 1L;
	protected JButton button;
	private ButtonListener bListener = new ButtonListener();

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(bListener);
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

		System.out.println("getTableCellEditorComponent");
		
		// On affecte le num�ro de ligne au listener
		bListener.setRow(row);
		
		// Idem pour le num�ro de colonne
		bListener.setColumn(column);
		
		// On passe aussi le tableau en param�tre pour des actions potentielles
		bListener.setTable(table);

		// On r�affecte le libell� au bouton
		button.setText((value == null) ? "" : value.toString());
		
		// On renvoie le bouton
		return button;
	}
  
}