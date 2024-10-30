//Example 3: HelloNameDialog.java
package lab1;
import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Le Dong Canh Phu - 20225755 - Please enter your name:");
        JOptionPane.showMessageDialog(null, "Toi ten la Le Dong Canh Phu -20225755 - Hi " + result + "!");
        System.exit(0);
    }
}
