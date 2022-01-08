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
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.image.BufferedImage;
import java.io.File;

import Core.Auction;
import Core.AuctionFacade;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/**
* @generated
*/
public class AuctionView extends JFrame implements ActionListener {
    
   
    private JFrame detailledAuctionView = new JFrame();
    
    private JFrame createAuctionView;
    JLabel l;
    Image img;
    File imgFile;
    
    private JFrame auctionsView;
    private JTextField search = new JTextField();
    
    private AuctionFacade auctionFacade = AuctionFacade.getAuctionFacade();
    
    public AuctionView(){
        super("Auctions - menu");
        search.setPreferredSize(new Dimension(100,30));
        JButton button1 = new JButton("Auctions list");
        JButton button2 = new JButton("Create an auction");
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
        auctionsView = new JFrame("Auctions - list");

        List<Auction> auctions = auctionFacade.getAllAuctions();
        List<Auction> sortedAuctions = new ArrayList<>();
        if(!search.getText().equals("")){
            for(Auction a : auctions){
                if(a.getProduct().getName().contains(search.getText())) sortedAuctions.add(a);
            }
        }else{
            sortedAuctions = auctions;
        }


        Container c = auctionsView.getContentPane();
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
        for(Auction a : sortedAuctions){

            Container card = new Container();
            card.setLayout(new BorderLayout());
            card.add(new JLabel(a.getProduct().getName() + " : " + a.getHighestOffer()), BorderLayout.NORTH);
            JButtonAuction details = new JButtonAuction("See details", a.getId());
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
                //TODO: handle exception
            }
            
        }

        JScrollPane js = new JScrollPane(cbis);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        c.add(js);
        auctionsView.pack();
        auctionsView.setVisible(true);
    }

    private void createAuction(){
        createAuctionView = new JFrame("Auctions - create");
        Container c = createAuctionView.getContentPane();
        c.setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(128, 28, 86, 20);
        c.add(textField);
        textField.setColumns(10);
         
        JLabel lblName = new JLabel("Title");
        lblName.setBounds(65, 31, 46, 14);
        c.add(lblName);

        JLabel lblPhone = new JLabel("Starting Price");
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

        JLabel lblDate = new JLabel("Duration in days");
        lblDate.setBounds(65, 215, 46, 14);
        c.add(lblDate);
        
        JTextField textField_3 = new JTextField();
        textField_3.setBounds(128, 215, 86, 20);
        c.add(textField_3);
        textField_3.setColumns(10);

        JButton btnSubmit = new JButton("submit");
     
        btnSubmit.setBounds(150,310,100,40);
        c.add(btnSubmit);
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textArea_1.getText().isEmpty())||(imgFile == null)||(textField_3.getText().isEmpty()))
                    JOptionPane.showMessageDialog(null, "Data Missing");
                else {
                    int id = auctionFacade.createAuction(textField.getText(), Double.parseDouble(textField_1.getText()), textField_2.getText(), textArea_1.getText(), imgFile, Double.parseDouble(textField_3.getText()));
                    JOptionPane.showMessageDialog(null, "Product created with the ID of "+ id);
                    createAuctionView.setVisible(false);
                }      
            }
        });

        JButton btn = new JButton("Parcourir");
        
        btn.setBounds(65, 250, 89, 23);
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

        
         
    
        createAuctionView.setSize(400,400);
        createAuctionView.setVisible(true);
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
        Auction a = auctionFacade.getAuctionById(id);
        detailledAuctionView.setContentPane(new Container());
        detailledAuctionView.setTitle("Auctions - details of " + a.getProduct().getName());
        Container c = detailledAuctionView.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel(a.getProduct().getName()));


        JTextField textField_1 = new JTextField();
        c.add(textField_1);
        textField_1.setColumns(10);

        JButton jb = new JButton("Bid");
        jb.addActionListener( e -> {
            if(!textField_1.getText().isEmpty()) auctionFacade.participate(Double.parseDouble(textField_1.getText()));
        });
        c.add(jb);

        detailledAuctionView.pack();
        detailledAuctionView.setVisible(true);
    }
    
    /** Method called when user interact with the view
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonAuction jb;
        switch(e.getActionCommand()){
            case "Search":
                auctionsView.setVisible(false);
            case "Auctions list":
                createListView();
                break;
            case "Create an auction":
                createAuction();
                break;
            case "See details":
                jb = (JButtonAuction)e.getSource();
                viewDetails(jb.getId());
                break;
        }
        
    }

    class JButtonAuction extends JButton{

        private int id;
        
        public JButtonAuction(String name, int id){
            super(name);
            this.id = id;
        }

        public int getId(){ return id; }
    }
    
    public static void main(String[] args) {
        new AuctionView();
    }
}
