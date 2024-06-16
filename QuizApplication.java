import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApplication {
    private static int currentQuestion = 0;
    private static int score = 0;
    private static Timer timer;
    private static final int TIME_LIMIT = 10; // Time limit for each question in seconds
    private static int timeLeft;

    private static String[][] questions = {
        {"What is the capital of France?", "Berlin", "Madrid", "Paris", "Lisbon", "2"},
        {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", "1"},
        // Add more questions as needed
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Application");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);

        loadQuestion(panel);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel questionLabel = new JLabel("Question");
        questionLabel.setBounds(10, 20, 380, 25);
        panel.add(questionLabel);

        ButtonGroup group = new ButtonGroup();
        JRadioButton option1 = new JRadioButton("Option 1");
        option1.setBounds(10, 50, 380, 25);
        panel.add(option1);
        group.add(option1);

        JRadioButton option2 = new JRadioButton("Option 2");
        option2.setBounds(10, 80, 380, 25);
        panel.add(option2);
        group.add(option2);

        JRadioButton option3 = new JRadioButton("Option 3");
        option3.setBounds(10, 110, 380, 25);
        panel.add(option3);
        group.add(option3);

        JRadioButton option4 = new JRadioButton("Option 4");
        option4.setBounds(10, 140, 380, 25);
        panel.add(option4);
        group.add(option4);

        JLabel timerLabel = new JLabel("Time left: 10");
        timerLabel.setBounds(10, 170, 380, 25);
        panel.add(timerLabel);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 200, 80, 25);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected()) {
                    checkAnswer(0);
                } else if (option2.isSelected()) {
                    checkAnswer(1);
                } else if (option3.isSelected()) {
                    checkAnswer(2);
                } else if (option4.isSelected()) {
                    checkAnswer(3);
                }
                loadNextQuestion(panel);
            }
        });

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft);
                if (timeLeft <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(panel, "Time's up! Moving to the next question.");
                    loadNextQuestion(panel);
                }
            }
        });
    }

    private static void loadQuestion(JPanel panel) {
        if (currentQuestion < questions.length) {
            JLabel questionLabel = (JLabel) panel.getComponent(0);
            questionLabel.setText(questions[currentQuestion][0]);

            JRadioButton option1 = (JRadioButton) panel.getComponent(1);
            option1.setText(questions[currentQuestion][1]);

            JRadioButton option2 = (JRadioButton) panel.getComponent(2);
            option2.setText(questions[currentQuestion][2]);

            JRadioButton option3 = (JRadioButton) panel.getComponent(3);
            option3.setText(questions[currentQuestion][3]);

            JRadioButton option4 = (JRadioButton) panel.getComponent(4);
            option4.setText(questions[currentQuestion][4]);

            timeLeft = TIME_LIMIT;
            timer.start();
        } else {
            showResult(panel);
        }
    }

    private static void loadNextQuestion(JPanel panel) {
        currentQuestion++;
        loadQuestion(panel);
    }

    private static void checkAnswer(int selectedOption) {
        int correctAnswer = Integer.parseInt(questions[currentQuestion][5]);
        if (selectedOption == correctAnswer) {
            score++;
        }
    }

    private static void showResult(JPanel panel) {
        JOptionPane.showMessageDialog(panel, "Quiz over! Your score is: " + score);
    }
}