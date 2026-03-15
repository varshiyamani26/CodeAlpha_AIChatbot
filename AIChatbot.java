import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AIChatbot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField userInput;
    JButton sendButton;

    public AIChatbot() {
        setTitle("AI Chatbot");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        userInput = new JTextField();
        sendButton = new JButton("Send");

        sendButton.addActionListener(this);

        setLayout(new BorderLayout());
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(userInput, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);

        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String input = userInput.getText().toLowerCase();
        chatArea.append("You: " + input + "\n");

        String response;

        if(input.contains("hello") || input.contains("hi")) {
            response = "Hello! How can I help you?";
        }
        else if(input.contains("how are you")) {
            response = "I am fine. Thanks for asking!";
        }
        else if(input.contains("your name")) {
            response = "I am a Java AI Chatbot.";
        }
        else if(input.contains("help")) {
            response = "You can ask me about greeting or my name.";
        }
        else if(input.contains("bye")) {
            response = "Goodbye! Have a nice day.";
        }
        else {
            response = "Sorry, I didn't understand.";
        }

        chatArea.append("Bot: " + response + "\n");
        userInput.setText("");
    }

    public static void main(String[] args) {
        new AIChatbot();
    }
}