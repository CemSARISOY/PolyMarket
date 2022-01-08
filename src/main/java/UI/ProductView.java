package UI;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter; 
import java.awt.image.BufferedImage;
import java.io.File;

import Core.LoginFacade;
import Core.Product;
import Core.ProductFacade;
import UI.payment.UserViewPayment;

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
    JLabel lUpdate;
    Image imgUpdate;
    File imgFileUpdate;
    
   
    private JFrame deleteProductView;
    
   
    private JFrame detailledProductView = new JFrame();
    
   
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Container createListView(){
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
        Container cbis = new Container();
        
        cbis.setLayout(new BorderLayout());
        Container header = new Container();
        header.setLayout(new FlowLayout());
        header.add(search);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        header.add(searchButton);
        cbis.add(header, BorderLayout.NORTH);

        Container center = new Container();
        cbis.add(center, BorderLayout.CENTER);
        center.setLayout(new WrapLayout());
        for(Product p : sortedProducts){

            Container card = new Container();
            card.setLayout(new BorderLayout());
            card.add(new JLabel(p.getName() + " : " + p.getPrice()), BorderLayout.NORTH);
            JButtonProduct details = new JButtonProduct("Voir les détails", p.getId());
            details.addActionListener(this); 
            card.add(details, BorderLayout.SOUTH);
            BufferedImage picture;
            try {
                picture = ImageIO.read(new File("src/main/java/UI/product.png"));
                JLabel picLabel = new JLabel(new ImageIcon(picture));
                card.add(picLabel, BorderLayout.CENTER);
                center.add(card);
            } catch (Exception e) {
                e.printStackTrace(); 
            } 
        }

        JScrollPane js = new JScrollPane(cbis);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        c.add(js); 
        return c;
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
     
        btnSubmit.setBounds(150,310,100,40);
        c.add(btnSubmit);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||(imgFile == null))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    int id = productFacade.createProduct(textField.getText(), Double.parseDouble(textField_1.getText()), textField_2.getText(), textArea_1.getText(), imgFile );
                    JOptionPane.showMessageDialog(null, "Product created with the ID of "+ id);
                    createProductView.setVisible(false);
                }      
            }
        });

        JButton btn = new JButton("Parcourir");
        
        btn.setBounds(65, 215, 89, 23);
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

    private void viewDetails(int id){
        Product p = productFacade.getProductById(id);
        detailledProductView.setContentPane(new Container());
        detailledProductView.setTitle("Product - Détails de " + p.getName());
        Container c = detailledProductView.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel(p.getName()));
        JButtonProduct jb = new JButtonProduct("Supprimer", p.getId());
        jb.addActionListener(this);
        JButtonProduct jb2 = new JButtonProduct("Modifier", p.getId());
        jb2.addActionListener(this);
        JButtonProduct jb3 = new JButtonProduct("Like", p.getId());
        jb2.addActionListener(this);
        
        JButtonProduct jb4 = new JButtonProduct("Ajouter au panier", p.getId());
        jb4.addActionListener(e -> {
            productFacade.addToCart(p); 
        });

        c.add(jb);
        c.add(jb2);
        c.add(jb3);
        c.add(jb4);

        detailledProductView.pack();
        detailledProductView.setVisible(true);
        
    }

    private void deleteProduct(int id){
        deleteProductView = new JFrame();
        Container c = deleteProductView.getContentPane();
        c.setLayout(new BorderLayout());
        JButton jbNon = new JButton("Non");
        jbNon.addActionListener( e -> {
            deleteProductView.setVisible(false);
        });
        

        JButton jbOui = new JButton("Oui");
        jbOui.addActionListener( e -> {
            productFacade.deleteProduct(id);
            deleteProductView.setVisible(false);
            detailledProductView.setVisible(false);
            productList.setVisible(false);
            createListView();
        });

        Container center = new Container();
        center.setLayout(new FlowLayout());
        center.add(jbOui);
        center.add(jbNon);

        JLabel texte = new JLabel("Voulez vous supprimer le produit " + id + " ?");
        c.add(texte, BorderLayout.NORTH);
        c.add(center, BorderLayout.CENTER);

        deleteProductView.pack();
        deleteProductView.setVisible(true);
    }

    private void updateProduct(int id){
        Product p = productFacade.getProductById(id);
        updateProductView = new JFrame("Product - Update " + p.getName());
        Container c = updateProductView.getContentPane();
        c.setLayout(null);


        JTextField textField = new JTextField();
        textField.setText(p.getName());
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
        textField_1.setText(p.getPrice()+ "");
        textField_1.setBounds(128, 65, 86, 20);
        c.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblEmailId = new JLabel("NFT Proof");
        lblEmailId.setBounds(65, 115, 46, 14);
        c.add(lblEmailId);
        JTextField textField_2 = new JTextField();
        textField_2.setText(p.getToken());
        textField_2.setBounds(128, 112, 247, 17);
        c.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblAddress = new JLabel("Body");
        lblAddress.setBounds(65, 162, 46, 14);
        c.add(lblAddress);
                
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setText(p.getBody());
        textArea_1.setBounds(126, 157, 212, 40);
        textArea_1.setLineWrap(true);
        textArea_1.setWrapStyleWord(true);
        c.add(textArea_1);

        JButton btnSubmit = new JButton("submit");
     
        btnSubmit.setBounds(150,310,100,40);
        c.add(btnSubmit);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||(imgFileUpdate == null))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    productFacade.updateProduct(id, textField.getText(), Double.parseDouble(textField_1.getText()), textField_2.getText(), textArea_1.getText(), imgFileUpdate );
                    JOptionPane.showMessageDialog(null, "Product of id "+ id + " was successfully updated");
                    updateProductView.setVisible(false);
                }      
            }
        });

        JButton btn = new JButton("Parcourir");
        btn.setBounds(65, 215, 89, 23);
        lUpdate = new JLabel();
        lUpdate.setBounds(10,10,365,290);
        imgFileUpdate = new File(p.getContent());
        lUpdate.setIcon(resizeUpdate(p.getContent()));
        ImageIcon imgPath = new ImageIcon(p.getContent());
        imgUpdate = imgPath.getImage();

        c.add(btn);
        c.add(lUpdate);
        
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
                    lUpdate.setIcon(resize(path));
                    imgFileUpdate = new File(path);
                    ImageIcon imgPath = new ImageIcon(path);
                    imgUpdate = imgPath.getImage();
                }
            }
        });

        updateProductView.setSize(400,400);
        updateProductView.setVisible(true);
    }

    public ImageIcon resizeUpdate(String imgPath){
        ImageIcon path = new ImageIcon(imgPath);
        Image img = path.getImage();
        Image newImg = img.getScaledInstance(lUpdate.getWidth(), lUpdate.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    /** Method called when user interact with the view
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonProduct jb;
        switch(e.getActionCommand()){
            case "Supprimer":
                jb = (JButtonProduct)e.getSource();
                deleteProduct(jb.getId());
                break;
            case "Modifier":
                jb = (JButtonProduct)e.getSource();
                updateProduct(jb.getId());
                break;
            case "Search":
                productList.setVisible(false);
            case "Liste des produits":
                createListView();
                break;
            case "Ajouter un produit":
                createProduct();    
                break;
            case "Voir les détails":
                jb = (JButtonProduct)e.getSource();
                viewDetails(jb.getId());
                break;
            case "Like":
                break;
            
        }
        
    }

    class JButtonProduct extends JButton{

        private int id;
        
        public JButtonProduct(String name, int id){
            super(name);
            this.id = id;
        }

        public int getId(){ return id; }
    }

    public static void main(String[] args) {
        new ProductView();
    }
}
