package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Core.Notification;
import Core.NotificationFacade;
import Core.User;
import Core.UserFacade;
import Persist.AbstractFactoryDao;
import Persist.NotificationDao;
import Persist.NotificationDaoMySQL;
import Persist.ProductDaoMySql;
import Persist.UserDaoMySQL;

public class NotificationListView extends AbstractTableModel {

	private static List<Notification> notifList;
	private static JFrame frame;
	private static JTable table;
	private static JButton button, viewButton;
	NotificationFacade notificationFacade = new NotificationFacade(
			new NotificationDaoMySQL(AbstractFactoryDao.getFactory("mysql")));

	private final String[] columnNames = new String[] { "Read", "Type", "Description" };
	private final Class[] columnClass = new Class[] { String.class, String.class, String.class };

	public NotificationListView(User user) {
		List<Notification> notifList1 = new ArrayList<>();

		for (Notification notificaton : this.notificationFacade.getNotificationsOfUser(user)) {
			notifList1.add(notificaton);
		}

		this.notifList = notifList1;

		frame = new JFrame();
		frame.setSize(new Dimension(800, 400));
		table = new JTable(this);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		button = new JButton("Remove");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// check for selected row first
				if (table.getSelectedRow() != -1) {
					int confirmed = JOptionPane.showConfirmDialog(null,
							"Are you sure you want to delete this notification ? \n"
									+ notifList.get(table.getSelectedRow()).toString(),
							"Delete Notification Message Box", JOptionPane.YES_NO_OPTION);
					if (confirmed == JOptionPane.YES_OPTION) {
						// remove selected row from the model
						removeRow(table.getSelectedRow());

						JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
					}
				}
			}
		});

		viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// check for selected row first
				if (table.getSelectedRow() != -1) {

					viewRow(table.getSelectedRow());

				}
			}
		});

		frame.add(viewButton, BorderLayout.EAST);

		frame.add(button, BorderLayout.WEST);

		frame.setVisible(true);

	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return columnClass[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return notifList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Notification row = notifList.get(rowIndex);
		if (0 == columnIndex) {
			if (row.getIsRead() == false) {
				return "Unread";
			}
			return "Opened";

		}

		else if (1 == columnIndex) {
			return row.getType();
		} else if (2 == columnIndex) {
			return row.getDescription();
		}
		return null;
	}

	public void removeRow(int row) {

		notificationFacade.deleteNotification(notifList.get(row).getId());
		notifList.remove(row);

		fireTableRowsDeleted(row, row);
	}

	public void viewRow(int row) {

		enable(false);
		new NotificationDetailedView(notifList.get(row), this);
		update(row);
	}

	private void update(int row) {
		this.notificationFacade.markAsRead(notifList.get(row));
		setValueAt(true, row, 0);

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Notification row = notifList.get(rowIndex);
		if (0 == columnIndex) {
			row.setIsRead((Boolean) aValue);
		}
		fireTableCellUpdated(rowIndex, columnIndex);

	}
	
	public void bringToFg() {
		frame.toFront();
	}

	public void enable(boolean bool) {
		frame.setEnabled(bool);
		button.setEnabled(bool);
		viewButton.setEnabled(bool);
		table.setEnabled(bool);
	}

	public static void main(String[] args) {
		AbstractFactoryDao abstractFactoryDao = AbstractFactoryDao.getFactory("mysql");
		UserDaoMySQL userDaoMySql = new UserDaoMySQL(abstractFactoryDao);
		User user = userDaoMySql.getUserById(2);
		NotificationListView view = new NotificationListView(user);

	}
}
