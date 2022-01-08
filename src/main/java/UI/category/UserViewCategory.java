package UI.category;

import java.awt.event.*;
import java.util.ArrayList; 
import javax.swing.*; 
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

import Core.Category;
import Core.CategoryFacade;
import UI.payment.UserViewPayment;
 
public class UserViewCategory extends JPanel {                                 
    
    private CategoryFacade categoryFacade = new CategoryFacade();
 
    public ArrayList<JButton> selectedCategories = new ArrayList<>();
    public String[] categories = {};  
    public ArrayList<JButton> buttons = new ArrayList<>(); 

    public UserViewCategory() {  
 
        JPanel labelContainer = new JPanel();
        JLabel topLabel = new JLabel("Voici la liste des catégories", SwingConstants.CENTER);
        topLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        labelContainer.add(topLabel); 
        
        JPanel liste = new JPanel();
        JScrollPane scroll = new JScrollPane(liste, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createEmptyBorder(20,0,0,0)); 
        liste.setLayout(new GridLayout(0,2));
        JPanel leftListe = new JPanel();
        leftListe.setLayout(new BoxLayout(leftListe, BoxLayout.Y_AXIS));
        JPanel rightListe = new JPanel();

        ArrayList<Category> categories = categoryFacade.getCateogries();
        rightListe.setLayout(new BoxLayout(rightListe, BoxLayout.Y_AXIS));
        for (Category category : categories) {
            JPanel cell = initCell(liste, category);
            liste.add(cell);
        } 

        JPanel validate = new JPanel();
        validate.setBorder(BorderFactory.createEmptyBorder(0,20,50,20));
        JButton button = new JButton("Valider"); 
        button.setPreferredSize(new Dimension(400,50));

        var this10 = this;
        button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) { 
                for (var button : buttons) {
                    button.setBackground(Color.WHITE);
                }     
                UserViewPayment topFrame = (UserViewPayment) SwingUtilities.getWindowAncestor(this10); 
                topFrame.initTab(topFrame.buttons[0].getText(), selectedCategories);
                String formattedCategories;
                if (selectedCategories.size() == 0) formattedCategories = "Aucun filtre n'a été appliqué";
                else {
                    formattedCategories = "Filtre(s) appliqué(s) : ";
                    int i = 0;
                    for (JButton sc : selectedCategories) {
                        formattedCategories += i != 0 ? ", " + sc.getText() : sc.getText();
                        i++;
                    }
                    formattedCategories.substring(0, formattedCategories.length() - 2); 
                } 
                // topFrame.products.initFilters(formattedCategories); // PRODUITS PAR CATEGORIES
                selectedCategories.clear();
            }

        });
 
        JButton add = new JButton("Ajouter"); 
        add.setPreferredSize(new Dimension(400,50));
        add.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) { 
                String m = JOptionPane.showInputDialog("Ajouter une nouvelle catégorie :");
                JDialog dialog;
                JLabel  message;
                if (m == null || m.isEmpty()) {
                    dialog =  new JDialog(new JFrame(), "Erreur");                            
                    message = new JLabel("<html><pre>Attention !\nVous devez rensigner un nom de catégorie valide</pre></html>"); 
                } 
                else {
                    Category category = new Category(0, m); 
                    categoryFacade.createCat(category); // UPDATE ON DB  
                    liste.add(initCell(liste, category));
                    dialog =  new JDialog(new JFrame(), "Message Administrateur");                            
                    message = new JLabel("<html><pre>Enregirstrement effectué !\n</pre></html>"); 
                }
                message.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                dialog.add(message);
                dialog.pack();
                dialog.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
                dialog.setResizable(false);
                dialog.setVisible(true);  
            }
        }); 

        validate.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        validate.add(add);
        validate.add(button);

 
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,50,100,50));
        this.add(labelContainer, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
        this.add(validate, BorderLayout.SOUTH);
        this.setVisible(true); 
    }  

    private JPanel initCell(JPanel liste, Category category) {
        
        JPanel cell = new JPanel();
        cell.setLayout(new BorderLayout()); 
        cell.setBorder(BorderFactory.createEmptyBorder(20,10,0,10));
        cell.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        
        JButton button = new JButton(category.getName()); 
        button.setBackground(Color.WHITE);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getBackground() == Color.WHITE) button.setBackground(Color.decode("#DCDCDC"));
                else button.setBackground(Color.WHITE);
                if (!selectedCategories.contains(button)) selectedCategories.add(button); 
                else selectedCategories.remove(button); 
            }
            
        }); 
        JPanel buttonContainer = new JPanel(); 
        buttonContainer.setLayout(new BorderLayout());
        buttonContainer.add(button);

        JPanel adminButtons = new JPanel();
        adminButtons.setLayout(new GridLayout(2,1));
        
        JButton edit = new JButton("Modifier");
        try { 
            ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("edit.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
            edit = new JButton(image); 
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            edit.setBackground(Color.WHITE); 
            edit.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(15,10,15,10)
            ));
            edit.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String m = JOptionPane.showInputDialog("Choissisez un nouveau nom pour cette catégorie :");
                    JDialog dialog;
                    JLabel  message;
                    if (m == null || m.isEmpty()) {
                        dialog =  new JDialog(new JFrame(), "Erreur");                            
                        message = new JLabel("<html><pre>Attention !\nVous devez rensigner un nom de catégorie valide</pre></html>"); 
                    } 
                    else {
                        category.setName(m);
                        categoryFacade.updateCategory(category); // UPDATE ON DB
                        button.setText(m);
                        dialog =  new JDialog(new JFrame(), "Message Administrateur");                            
                        message = new JLabel("<html><pre>Enregirstrement effectué !\n</pre></html>"); 
                    }
                    message.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                    dialog.add(message);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
                    dialog.setResizable(false);
                    dialog.setVisible(true);  
                } 
            }); 
        } 
        JButton delete = new JButton("Supprimer"); 
        try { 
            ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("delete.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
            delete = new JButton(image); 
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally { 
            delete.setBackground(Color.WHITE); 
            delete.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(30,10,30,10)
            ));
            delete.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) { 
                    int m = JOptionPane.showConfirmDialog( 
                        null,
                        "Attention\nEtes-vous sûr de vouloir supprimer cette catégorie ?",
                        "Avertissement",
                        JOptionPane.YES_NO_OPTION
                    ); 
                    if (m == 0) { //  YES OPTION
                        categoryFacade.deleteCat(category.getId()); // UPDATE ON DB// UPDATE ON DB
                        cell.setVisible(false);
                        liste.remove(cell);   
                    } 
                } 
            }); 
        } 
        adminButtons.add(edit);
        adminButtons.add(delete);

        buttons.add(button);  
        cell.add(buttonContainer, BorderLayout.CENTER);
        cell.add(adminButtons, BorderLayout.EAST); 

        return cell;
    }
}
