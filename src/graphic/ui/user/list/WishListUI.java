package graphic.ui.user.list;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import common.Application;
import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.list.FacadeManageWishList;

/**
 * this is the view for a wishList
 * needs in communication id_wishlist as parameter
 * @author loicd_000
 *
 */
public class WishListUI extends AbstractUI {
	private JButton backUser = new JButton();
	private JButton backWishLists = new JButton();
	private JLabel wishListLabel = new JLabel();
	private JLabel wishListTotalPriceLabel = new JLabel();
	private JTable table = new JTable();
    private JPanel tablePanel = new JPanel(); 

	private FacadeManageWishList facadeList = new FacadeManageWishList(); 

	
	public WishListUI(UIMessage communication, Application app) {
		super(communication, app);
		int IDWishList = (int)this.communication.getElement("id_wishlist");
		this.facadeList.createAndGetWishList(IDWishList);
		
		this.panel.setLayout(null);


		// user button
		this.backUser.setText("Back to User");
		this.backUser.setBounds(2 , 2, 150, 23);
		this.panel.add(backUser);
		this.backUser.addActionListener(this);
		
		// wish lists button
		this.backWishLists.setText("Back to WishLists");
		this.backWishLists.setBounds(160 , 2, 150, 23);
		this.panel.add(backWishLists);
		this.backWishLists.addActionListener(this);

		this.wishListLabel.setText("WishList : " + this.facadeList.getNameWishList());
		this.wishListLabel.setBounds(2, 30, 300, 23);
		this.panel.add(wishListLabel);

		this.wishListTotalPriceLabel.setText("Total Price  : " + this.facadeList.getTotalPriceWishList() + " �");
		this.wishListTotalPriceLabel.setBounds(200, 470, 300, 23);
		this.panel.add(wishListTotalPriceLabel);

		
		//Table : 
		int nbOfRow = this.facadeList.createAndGetWishList(IDWishList).count();
		int nbOfColumn = 4; // the name, the quantity and the unitPrice
		String[] title = { "Product Name", "Quantity", "Price", "ID", "Remove"};
		Object[][] data = new Object[nbOfRow][nbOfColumn];
		
		int j = 0;
		for(Iterator<String> i = this.facadeList.getListIDProduct().iterator() ; i.hasNext(); ) {
		    String key = i.next();
		    ProductWishList product = this.facadeList.createAndGetWishList(IDWishList).getElementByKey(key);
		    Object[] newLine = {product.getName() , product.getQuantity() , "" +product.getUnitPrice() + " �", product.getIDProduct(), "Remove product"}; 
			data[j] = newLine;
			j ++;
		}
		
	    this.tablePanel.setBounds(2, 60, 600, 400);
	    this.tablePanel.setLayout(new BorderLayout());
	    //prepare the JTable
		TableModel dataModel = new DataModelSetWishList(data, title);
		this.table.setModel(dataModel);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		this.panel.add(this.tablePanel);	
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int column = target.getSelectedColumn();
					if (column == 4) {
						deteteProductActionPerformed((int) table.getValueAt(row, 3));
					}
				}
			}
		});
	}
	

	/**
	 * This method is an equivalent to actionPerformed, but delete a wishlist
	 * and refresh the page
	 * 
	 * @author loicd_000
	 * @param IDWishlist
	 *            - int : IDWishList to delete
	 */
	public void deteteProductActionPerformed(int IDProduct) {
		try {
			this.facadeList.removeProductToWishList(IDProduct);;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			this.communication.shareElement("id_wishlist", this.facadeList.getIDWishList());
			this.update("wishList");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand().equals("Back to User")) {
			//System.out.println("UserUI - actionPerformed - case user");
			try {
				this.update("user");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 

		
		else if (arg0.getActionCommand().equals("Back to WishLists")) {
			try {
				this.update("wishLists");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			System.err.println("Button action not catch.");
		}
	}


	@Override
	public void update(String transition) {
		// TODO Auto-generated method stub
		
	}

}
