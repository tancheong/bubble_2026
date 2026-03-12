package test01;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {
    private JLabel backGroundMap;
    private Player player;

    public BubbleFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        super.setTitle("버블버블 게임");
        setSize(1000, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backGroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
        setContentPane(backGroundMap);

        player = new Player();
    }

    private void setInitLayout() {
        setLayout(null);
        setResizable(false); // 창 크기 고정
        setLocationRelativeTo(null); // 화면 정중앙 배치(프레임)

        backGroundMap.add(player);

        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 방향키 코드를 Player의 이동 메서드로 연결
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        player.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.right();
                        break;
                    case KeyEvent.VK_UP:
                        player.up();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    // 테스트 코드
    public static void main(String[] args) {
        new BubbleFrame();
    }

} // end of class
