package UI;
 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import Core.User;
import Core.UserFacade;
import Persist.AbstractFactoryDao;
import Persist.UserDaoMySQL;
 
public class UserListView extends AbstractTableModel
{
    private static  List<User> userList;
    UserFacade userFacade = new UserFacade(null);
     
    private final String[] columnNames = new String[] {
            "Firstname", "Lastname", "Nickname","Email","Password","Date of birth"
    };
    private final Class[] columnClass = new Class[] {
        String.class, String.class,String.class,String.class,String.class,Date.class
    };
 
    public UserListView()
    {
    	List<User> userList1 = new ArrayList<>();
        for (User user : this.userFacade.getAllUser())
            userList1.add(user);
        this.userList = userList1;
        
        JFrame frame = new JFrame();
     	frame.setSize(new Dimension(800, 400));
        JTable table = new JTable(this);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane,BorderLayout.CENTER);
        
        JButton button = new JButton("Remove");
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
              // check for selected row first
              if(table.getSelectedRow() != -1) {
            	  int confirmed = JOptionPane.showConfirmDialog(null, 
            		        "Are you sure you want to delete this user ? \n" +userList.get(table.getSelectedRow()).toString() , "Delete User Message Box",
            		        JOptionPane.YES_NO_OPTION);
            	  if (confirmed == JOptionPane.YES_OPTION) {
                 // remove selected row from the model
                 removeRow(table.getSelectedRow());
                 
                 JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
            	  }
              }
           }
        });

        

      
        frame.add(button,BorderLayout.SOUTH);
   
        frame.setVisible(true);
       
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return userList.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        User row = userList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getFirstname();
        }
        else if(1 == columnIndex) {
            return row.getLastname();
        }
        else if(2 == columnIndex) {
            return row.getNickname();
        }
        else if(3 == columnIndex) {
            return row.getEmail();
        }
        else if(4 == columnIndex) {
            return row.getPassword();
        }
        else if(5 == columnIndex) {
            return row.getDob();
        }

        return null;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        User row = userList.get(rowIndex);
        if(0 == columnIndex) {
            row.setFirstname((String) 	aValue);
        }
        else if(1 == columnIndex) {
            row.setLastname((String) aValue);
        }
        else if(2 == columnIndex) {
            row.setNickname((String) aValue);
        }
        else if(3 == columnIndex) {
        	 row.setEmail((String) aValue);
        }
        else if(4 == columnIndex) {
        	 row.setPassword((String) aValue);
        }
        userFacade.modifyUser(row.getId(), row.getFirstname(), row.getLastname(),row.getNickname(),row.getEmail(), row.getPassword(), new Date(row.getDob().getTime()));
  
    }
    
    public void removeRow(int row) {
    
    	 userFacade.deletUser(userList.get(row).getId());
    	 userList.remove(row);
       
        fireTableRowsDeleted(row, row);
    }
    
    public static void main(String[] args) {
		UserListView view = new UserListView();
		
	  
	}

   
 
}