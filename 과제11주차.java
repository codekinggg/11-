import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class abc extends JFrame {

    private JTextField wordInputField;
    private JButton openButton;
    private JButton closeButton;
    private JButton exitButton;

    public abc() {
        setTitle("Swing Frame Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 버튼 생성 및 이벤트 처리
        openButton = new JButton("열기");
        closeButton = new JButton("닫기");
        exitButton = new JButton("나가기");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "열기 버튼이 클릭되었습니다.");
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "닫기 버튼이 클릭되었습니다.");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(closeButton);
        buttonPanel.add(exitButton);

        // 텍스트 필드 생성
        wordInputField = new JTextField(20);

        // 랜덤 위치에 '*' 출력
        JPanel centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Random random = new Random();
                for (int i = 0; i < 10; i++) {
                    int x = random.nextInt(getWidth());
                    int y = random.nextInt(getHeight());
                    g.drawString("*", x, y);
                }
            }
        };

        add(buttonPanel, BorderLayout.NORTH);
        add(wordInputField, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        abc frame = new abc();
    }
}
