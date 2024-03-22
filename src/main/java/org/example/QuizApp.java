package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame {
    private JLabel question;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup buttonGroup;
    private JButton next;
    private int currentQuestion = 0;
    private int totalScore = 0;
    private String [][] listQuestions = {
            {"What is the capital of Ukraine?","Kyiv","London","Paris","Berlin", "Kyiv"},
            {"What is the capital of Germany?","Kyiv","London","Paris","Berlin", "Berlin"},
            {"What is the capital of France?","Kyiv","London","Paris","Berlin", "Paris"}
    };
    private void displayQuestion(int index){
        question.setText(listQuestions[index][0]);
        option1.setText(listQuestions[index][1]);
        option2.setText(listQuestions[index][2]);
        option3.setText(listQuestions[index][3]);
        option4.setText(listQuestions[index][4]);
        buttonGroup.clearSelection();
    }
    public QuizApp(){
        setTitle("QUIZ");
        setSize(400,300);
        setLayout(new BorderLayout());

        question = new JLabel();
        add(question,BorderLayout.NORTH);

        JPanel panelOptions = new JPanel(new GridLayout(4,1));
        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();
        buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);
        panelOptions.add(option1);
        panelOptions.add(option2);
        panelOptions.add(option3);
        panelOptions.add(option4);
        add(panelOptions, BorderLayout.CENTER);

        next = new JButton("next");
        add(next,BorderLayout.SOUTH);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = checkAnswer();
                currentQuestion++;
                if(result){
                    JOptionPane.showMessageDialog(QuizApp.this,"Correct!");
                    totalScore++;
                }
                else {
                    JOptionPane.showMessageDialog(QuizApp.this,"Incorrect!");
                }
                if(currentQuestion == listQuestions.length){
                    JOptionPane.showMessageDialog(QuizApp.this,"Results = "+totalScore);
                    System.exit(0);
                }
                displayQuestion(currentQuestion);
            }
        });
        displayQuestion(currentQuestion);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    private boolean checkAnswer(){
        if(option1.isSelected() && option1.getText().equals(listQuestions[currentQuestion][5])){
            return true;
        }
        if (option2.isSelected() && option2.getText().equals(listQuestions[currentQuestion][5])) {
            return true;
        }
        if (option3.isSelected() && option3.getText().equals(listQuestions[currentQuestion][5])) {
            return true;
        }
        if (option4.isSelected() && option4.getText().equals(listQuestions[currentQuestion][5])) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        new QuizApp();
    }
}