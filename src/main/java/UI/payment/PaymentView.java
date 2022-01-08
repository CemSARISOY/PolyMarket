package UI.payment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; 
import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import Core.CartFacade;
import Core.LoginFacade;
import Core.PaymentFacade;
import Core.Product;
import Persist.Cart;
import UI.DeliveredView;
import UI.DeliveryView;  

public class PaymentView extends JFrame {

    private PaymentFacade paymentFacade = new PaymentFacade();
    JTextField cardNumberInput = new JTextField(); 
    JTextField cardDateInput = new JTextField(); 
    JTextField cardCodeInput = new JTextField(); 

    public PaymentView() { 
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));  
        content.add(initResume());
        content.add(initBankInfo());
        this.pack(); 
        this.setVisible(true);
    }

    public JPanel initResume() {
        JPanel resume = new JPanel(); 
        resume.setLayout(new GridLayout(1, 2));
        resume.setBorder(new LineBorder(Color.BLACK));

        // left side
        JPanel leftResume = new JPanel();
        leftResume.setBorder(new EmptyBorder(10, 10, 10, 10));
        leftResume.setLayout(new BoxLayout(leftResume, BoxLayout.Y_AXIS)); 

        JLabel resumeLabel = new JLabel("Résumé de votre commande : ");
        resumeLabel.setFont(new Font("Serif", Font.PLAIN, 16));  
        leftResume.add(resumeLabel);

        leftResume.add(new JLabel(" "));

        JLabel productLabel = new JLabel("Produit : NFT#789");
        productLabel.setFont(new Font("Serif", Font.PLAIN, 16));  
        leftResume.add(productLabel);

        JLabel priceLabel = new JLabel("Prix : 410 €");
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 16));  
        leftResume.add(priceLabel);

        // right side
        JPanel rightResume = new JPanel(); 
        rightResume.setBorder(new EmptyBorder(10,10,10,10));
        try { 
            ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("nft2.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
            JLabel productImage = new JLabel(image);  
            rightResume.add(productImage); 
        } catch (Exception e) {
            e.printStackTrace();
            rightResume.add(new JLabel("Image not found")); 
        }

        resume.add(leftResume);
        resume.add(rightResume);
        return resume;
    }

    public JPanel initBankInfo() {
        JPanel bankInfo = new JPanel(); 
        bankInfo.setLayout(new BoxLayout(bankInfo, BoxLayout.Y_AXIS));
        bankInfo.setBorder(new CompoundBorder(
            BorderFactory.createEmptyBorder(10, 0, 0, 0),
            new LineBorder(Color.BLACK)
        ));

        // type
        JPanel type = new JPanel();
        type.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        type.setBorder(new EmptyBorder(10,10,10,10));

        JLabel typeLabel = new JLabel("Type : ");
        typeLabel.setFont(new Font("Serif", Font.PLAIN, 16));  
        type.add(typeLabel);

        String[] methodsPayment = { "Carte", "Paypal" };

        JPanel cardInputs = initCardInputs();
        JPanel paypalInputs = initPaypalInputs();

        JComboBox<String> methodsPaymentList = new JComboBox<String>(methodsPayment);
        methodsPaymentList.setPreferredSize(new Dimension(150, 30));
        methodsPaymentList.addItemListener(new ItemListener () {

            @Override
            public void itemStateChanged(ItemEvent e) { 
                if (e.getItem() == methodsPayment[1]) { 
                    cardInputs.setVisible(false);
                    paypalInputs.setVisible(true);
                } 
                else { 
                    cardInputs.setVisible(true);
                    paypalInputs.setVisible(false);
                } 
            }
        });
        methodsPaymentList.setSelectedIndex(0); 
        type.add(methodsPaymentList);

        
        // validate button
        JPanel validate = new JPanel();
        validate.setLayout(new FlowLayout(FlowLayout.RIGHT));
        validate.setBorder(new EmptyBorder(15,10,10,10));

        JButton button = new JButton("Valider");
        button.setPreferredSize(new Dimension(100, 30)); 
        var this10 = this;
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Pair<Boolean, String> checks = checkCardFields(cardNumberInput.getText(), cardDateInput.getText(), cardCodeInput.getText());
                if (checks.left) {
                    CartFacade cart = CartFacade.getCartFacade(); 
                    paymentFacade.pay(cart, true);
                    JOptionPane.showOptionDialog(null, "Félicitations !\nVous pouvez désormais accéder au récapitulatif\nde votre achat via la rubrique \"Mes Commandes\"", "Paiement accepté", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);
                }
                else {
                    JOptionPane.showOptionDialog(null, "Attention !\nVous devez renseigner correctiement l'entreé\nsuivante : " + checks.right, "Paiement refusé", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, null, null);  
                }  
                if (checks.left) this10.dispose();
                for (Product p : CartFacade.getCartFacade().getItemsInCart()) {
                    new DeliveryView(p.getAuthor(), LoginFacade.getLoginFacade().getUser(), p); 
                }
            }
        });
        validate.add(button);

        // bank infos
        cardInputs.setVisible(true);
        paypalInputs.setVisible(false);

        bankInfo.add(type);
        bankInfo.add(cardInputs);
        bankInfo.add(paypalInputs);
        bankInfo.add(validate);

        return bankInfo;
    }

    public JPanel initCardInputs() {
        JPanel cardIputs = new JPanel();
        cardIputs.setLayout(new BoxLayout(cardIputs, BoxLayout.Y_AXIS));

        // card number
        JPanel cardNumber = new JPanel();
        cardNumber.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        cardNumber.setBorder(new EmptyBorder(15,10,10,10));

        JLabel cardNumberLabel = new JLabel("Numéro de carte : ");
        cardNumberLabel.setFont(new Font("Serif", Font.PLAIN, 16));  
        cardNumber.add(cardNumberLabel);

        cardNumberInput.setPreferredSize(new Dimension(250, 30)); 
        cardNumberInput.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent key) {} 
            public void keyReleased(KeyEvent key) {} 
            public void keyTyped(KeyEvent key) { 
                if (cardNumberInput.getText().length() >= 16) {
                    key.consume();
                }
            }
        });
        cardNumber.add(cardNumberInput); 

        // expiration date
        JPanel cardDate = new JPanel();
        cardDate.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        cardDate.setBorder(new EmptyBorder(15,10,10,10));

        JLabel cardDateLabel = new JLabel("Date d'expiration : ");
        cardDateLabel.setFont(new Font("Serif", Font.PLAIN, 16));  
        cardDate.add(cardDateLabel);

        cardDateInput.setPreferredSize(new Dimension(50, 30)); 
        cardDateInput.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent key) {  
                if (cardDateInput.getText().length() == 3 && key.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    cardDateInput.setText(cardDateInput.getText().substring(0, 2)); 
                }
                else if (cardDateInput.getText().length() == 2) {  
                    cardDateInput.setText(cardDateInput.getText() + "/");  
                }  
            }
          
            public void keyReleased(KeyEvent key) {} 
            public void keyTyped(KeyEvent key) { 
                if (cardDateInput.getText().length() >= 5) {
                    key.consume();
                }
            }
        });
        cardDate.add(cardDateInput); 

        // secret code
        JPanel cardCode = new JPanel();
        cardCode.setLayout(new FlowLayout(FlowLayout.LEFT)); 
        cardCode.setBorder(new EmptyBorder(15,10,10,10));

        JLabel cardCodeLabel = new JLabel("Code secret : ");
        cardCodeLabel.setFont(new Font("Serif", Font.PLAIN, 16));  
        cardCode.add(cardCodeLabel);

        cardCodeInput.setPreferredSize(new Dimension(50, 30)); 
        cardCodeInput.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent key) {} 
            public void keyReleased(KeyEvent key) {} 
            public void keyTyped(KeyEvent key) { 
                if (cardCodeInput.getText().length() >= 3) {
                    key.consume();
                }
            }
        });
        cardCode.add(cardCodeInput); 

        cardIputs.add(cardNumber);
        cardIputs.add(cardDate);
        cardIputs.add(cardCode);

        return cardIputs;
    }

    public JPanel initPaypalInputs() {
        JPanel paypalInputs = new JPanel();

        JLabel temp = new JLabel("La méthode de paiement via PayPal arrivera prochainement");
        paypalInputs.add(temp);

        return paypalInputs;
    }

    public Pair<Boolean, String> checkCardFields(String number, String date, String code) {
        if (number == null || number.length() != 16 || !isNumeric(number.substring(0,8)) || !isNumeric(number.substring(8,16))) 
            return new Pair<>(false, "numéro de carte");
        if (date == null || date.length() != 5 || !isNumeric(date.substring(0,2)) || !isNumeric(date.substring(3,5)))
            return new Pair<>(false, "date d'expiration");
        if (code == null || code.length() != 3 || !isNumeric(code))
            return new Pair<>(false, "code secret");
        return new Pair<>(true, "");
    }

    public static boolean isNumeric(String strNum) { 
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            System.out.println("trr");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new ProductsPayment();
    }
}
