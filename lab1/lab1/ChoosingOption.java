package lab1;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main (String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Le Dong Canh Phu - 20225755 - Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "Le Dong Canh Phu 20225755 - You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}
// If the user choose "Cancel", the program will return "No".
/*  
// Define custom options
Object[] options = {"I do", "I don't", "Cancel"};
        
// Show option dialog with custom options
int option = JOptionPane.showOptionDialog(null, 
    "Le Dong Canh Phu - 20225755 - Do you want to change to the first class ticket?", 
    "Choose an option", 
    JOptionPane.YES_NO_OPTION, 
    JOptionPane.QUESTION_MESSAGE, 
    null, 
    options, 
    options[0]); */