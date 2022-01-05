package UI;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.image.BufferedImage;
import java.io.File;

import Core.Product;
import Core.ProductFacade;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProductView extends JFrame implements ActionListener {
    
    
    private JFrame createProductView;
    JLabel l;
    Image img;
    File imgFile;
  
    private JFrame updateProductView;
    
   
    private JFrame deleteProductView;
    
   
    private JFrame detailledProductView;
    
   
    private JFrame productList;
    private JTextField search = new JTextField();
    
   
    private ProductFacade productFacade = ProductFacade.getProductFacade();
    
    public ProductView(){
        super("Products - menu");
        search.setPreferredSize(new Dimension(100,30));
        JButton button1 = new JButton("Liste des produits");
        JButton button2 = new JButton("Ajouter un produit");
        button1.addActionListener(this);
        button2.addActionListener(this);
        Container c =  this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(button1);
        c.add(button2);
        this.pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createListView(){
        this.productList = new JFrame("Product - list");


        List<Product> products = productFacade.getProducts();
        List<Product> sortedProducts = new ArrayList<>();
        if(!search.getText().equals("")){
            for(Product p : products){
                if(p.getName().contains(search.getText())) sortedProducts.add(p);
            }
        }else{
            sortedProducts = products;
        }

        Container c = productList.getContentPane();
        c.setLayout(new BorderLayout());
        Container header = new Container();
        header.setLayout(new FlowLayout());
        header.add(search);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        header.add(searchButton);
        c.add(header, BorderLayout.NORTH);

        Container center = new Container();
        c.add(center, BorderLayout.CENTER);
        center.setLayout(new FlowLayout());
        for(Product p : sortedProducts){

            Container card = new Container();
            card.setLayout(new BorderLayout());
            card.add(new JLabel(p.getName() + " : " + p.getPrice()), BorderLayout.SOUTH);
            BufferedImage picture;
            try {
                picture = ImageIO.read(new File("src/main/java/UI/product.png"));
                JLabel picLabel = new JLabel(new ImageIcon(picture));
                card.add(picLabel, BorderLayout.CENTER);
                center.add(card);
            } catch (Exception e) {
                e.printStackTrace();
                //TODO: handle exception
            }
            
        }
        productList.pack();
        productList.setVisible(true);
    }

    private void createProduct(){
        createProductView = new JFrame("Product - create");
        Container c = createProductView.getContentPane();
        c.setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(128, 28, 86, 20);
        c.add(textField);
        textField.setColumns(10);
         
        JLabel lblName = new JLabel("Title");
        lblName.setBounds(65, 31, 46, 14);
        c.add(lblName);

        JLabel lblPhone = new JLabel("Price");
        lblPhone.setBounds(65, 68, 46, 14);
        c.add(lblPhone);
        
        JTextField textField_1 = new JTextField();
        textField_1.setBounds(128, 65, 86, 20);
        c.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblEmailId = new JLabel("NFT Proof");
        lblEmailId.setBounds(65, 115, 46, 14);
        c.add(lblEmailId);
        
        JTextField textField_2 = new JTextField();
        textField_2.setBounds(128, 112, 247, 17);
        c.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblAddress = new JLabel("Body");
        lblAddress.setBounds(65, 162, 46, 14);
        c.add(lblAddress);
                
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(126, 157, 212, 40);
        textArea_1.setLineWrap(true);
        textArea_1.setWrapStyleWord(true);
        c.add(textArea_1);

        JButton btnSubmit = new JButton("submit");
     
        btnSubmit.setBounds(65, 215, 89, 23);
        c.add(btnSubmit);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||(imgFile == null))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    int id = productFacade.createProduct(textField.getText(), Double.parseDouble(textField_1.getText()), textField_2.getText(), textArea_1.getText(), imgFile );
                    JOptionPane.showMessageDialog(null, "Product created with the ID of "+ id);
                }      
            }
        });

        JButton btn = new JButton("Parcourir");
        btn.setBounds(150,310,100,40);
        l = new JLabel();
        l.setBounds(10,10,365,290);
        c.add(btn);
        c.add(l);
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filtrer les fichiers
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png");
                file.addChoosableFileFilter(filter);
                int res = file.showSaveDialog(null);
                //si l'utilisateur clique sur enregistrer dans Jfilechooser
                if(res == JFileChooser.APPROVE_OPTION){
                    File selFile = file.getSelectedFile();
                    String path = selFile.getAbsolutePath();
                    l.setIcon(resize(path));
                    imgFile = new File(path);
                    ImageIcon imgPath = new ImageIcon(path);
                    img = imgPath.getImage();
                }
            }
        });

        
         
    
        createProductView.setSize(400,400);
        createProductView.setVisible(true);

    }
     
    // Méthode pour redimensionner l'image avec la même taille du Jlabel
    public ImageIcon resize(String imgPath){
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    /** Method called when user interact with the view
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Search":
                productList.setVisible(false);
            case "Liste des produits":
                createListView();
                break;
            case "Ajouter un produit":
                createProduct();    
                break;
        }
        
    }

    public static void main(String[] args) {
        new ProductView();
    }
}
