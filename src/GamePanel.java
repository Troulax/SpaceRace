import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{

    static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 20;
    public static int UNIT_SIZE2 = 20;
    public static int UNIT_SIZE3 = 40;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 70;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    final int a[] = new int[GAME_UNITS];
    final int b[] = new int[GAME_UNITS];

    int bodyParts = 2;
    int meteorX,meteorA,meteor2x,meteor3x,meteor4x,meteor5x,meteor6x,meteor7x,meteor8x,meteor9x;
    int meteorY,meteorB,meteor2y,meteor3y,meteor4y,meteor5y,meteor6y,meteor7y,meteor8y,meteor9y;
    Sound sound = new Sound();
    int fuelX;
    int fuelY;
    int Score;
    int Crash;
    char direction = 'D';
    boolean  running = false;
    Timer timer;
    Random random;

    private BufferedImage img;
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newMeteor();
        newFuel();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Draw(g);
    }
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();

    }

    public void Draw(Graphics g) {



        if(running) {
			/*
		for(int i=0;i<SCREEN_WIDTH/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
		}
		*/
            g.setColor(Color.red);
            g.fillOval(fuelX, fuelY, UNIT_SIZE, UNIT_SIZE);



            g.setColor(Color.gray);
            g.fillOval(meteorX, meteorY, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.gray);
            g.fillOval(meteorA, meteorB, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.gray);
            g.fillOval(meteor2x, meteor2y, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.gray);
            g.fillOval(meteor3x, meteor3y, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.gray);
            g.fillOval(meteor4x, meteor4y, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.gray);
            g.fillOval(meteor5x, meteor5y, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.gray);
            g.fillOval(meteor6x, meteor6y, UNIT_SIZE, UNIT_SIZE);

            g.setColor(Color.gray);
            g.fillOval(meteor7x, meteor7y, UNIT_SIZE, UNIT_SIZE);
            g.setColor(Color.gray);
            g.fillOval(meteor8x, meteor8y, UNIT_SIZE, UNIT_SIZE);
            g.setColor(Color.gray);
            g.fillOval(meteor9x, meteor9y, UNIT_SIZE, UNIT_SIZE);




            for(int i=0; i<bodyParts;i++) {

                if(i==0) {
                    g.setColor(Color.black);
                    g.fillOval(x[i], y[i], UNIT_SIZE2, UNIT_SIZE3);
                }
                if(i==1) {
                    g.setColor(Color.white);
                    g.fillOval(x[i], y[i], UNIT_SIZE2, UNIT_SIZE3);
                }
            }
            g.setColor(Color.WHITE);
            g.setFont( new Font("Ink Free",Font.BOLD,40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+Score,(SCREEN_WIDTH - metrics.stringWidth("Score :"+Score))/2,g.getFont().getSize());

            g.setColor(Color.WHITE);
            g.setFont( new Font("Ink Free",Font.BOLD,30));
            g.drawString("Crash: "+Crash,((SCREEN_WIDTH - metrics.stringWidth("Crash :"+Crash))/2)+18,g.getFont().getSize()+50);


        }
        if(Score>5){
           GameWin(g);
        }
        //check if score under 0 call GameOver()
        if(Score<0) {
            GameOver(g);
        }
        switch (Score){
            case -1:
                playSE(0);
                break;
            case 5:
                playSE(3);
                break;
        }
        if(Score==-1){
            Score--;
        }
        if(Score==5){
            Score++;
        }
    }
    public void newMeteor(){
        meteorX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteorY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteorA = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteorB = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor2x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor2y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor3x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor3y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor4x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor4y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor5x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor5y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor6x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor6y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor7x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor7y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor8x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor8y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        meteor9x = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        meteor9y = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;


    }


    public void newFuel() {
        fuelX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        fuelY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move() {

        for(int i = bodyParts;i>0;i--) {
            y[i] = y[i-1];
            x[i] = x[i-1];
        }
        switch(direction) {

            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;

            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;

            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;

            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkScore() {
        if((x[0]==fuelX) && (y[0] == fuelY)) {
            Score++;
            playSE(1);
            newFuel();
            if(Score%2==0) {
                newMeteor();
            }}

    }

    public void checkCollisions() {
        //check if head touches top border
        if (y[0] < 0) {
            timer.start();
            running = true;
            direction = 'D';
            playSE(2);
            Crash++;
            if (Crash % 3 == 0)
                Score--;
        }
        //check if head touches right border
        if (x[0] >= SCREEN_WIDTH) {
            timer.start();
            running = true;
            direction = 'L';
            playSE(2);
            Crash++;
            if (Crash % 3 == 0)
                Score--;

        }
        //check if head touches left border
        if (x[0] < 0) {
            timer.start();
            running = true;
            direction = 'R';
            playSE(2);
            Crash++;
            if (Crash % 3 == 0)
                Score--;

        }
        //check if head touches bottom border
        if (y[0] >= SCREEN_HEIGHT) {
            timer.start();
            running = true;
            direction = 'U';
            playSE(2);
            Crash++;
            if (Crash % 3 == 0)
                Score--;

        }
        if (((x[0] == meteorX) && (y[0] == meteorY)) || ((x[0] == meteorA) && (y[0] == meteorB)) || ((x[0] == meteor2x) && (y[0] == meteor2y))
                || ((x[0] == meteor3x) && (y[0] == meteor3y)) || ((x[0] == meteor4x) && (y[0] == meteor4y))||((x[0] == meteor5x) && (y[0] == meteor5y))
        ||((x[0] == meteor6x) && (y[0] == meteor6y))||((x[0] == meteor7x) && (y[0] == meteor7y))||((x[0] == meteor8x) && (y[0] == meteor8y))||((x[0] == meteor9x) && (y[0] == meteor9y))) {
            Score = -1;
        }
    }


    public void GameWin(Graphics g){
        g.setColor(Color.green);
        g.setFont(new Font("Sans-Serif",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("YOU WON!!",(SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);
        g.setColor(Color.DARK_GRAY);
        g.setFont( new Font("Sans-Serif",Font.ITALIC,35));
        FontMetrics metric = getFontMetrics(g.getFont());
        g.drawString("Press (R) to to have another go!",(SCREEN_WIDTH - metric.stringWidth("Press (R) to have another go!"))/2,SCREEN_HEIGHT*3/5);
        running=false;
    }
    public void GameOver(Graphics g) {
        //Game over sound

        //Game Over Text
        g.setColor(Color.RED);
        g.setFont( new Font("Sans-Serif",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",(SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);
        g.setColor(Color.gray);
        g.setFont( new Font("Sans-Serif",Font.ITALIC,35));
        FontMetrics metric = getFontMetrics(g.getFont());
        g.drawString("Press (R) to restart",(SCREEN_WIDTH - metric.stringWidth("Press (R) to restart"))/2,SCREEN_HEIGHT*3/5);
        running = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkScore();
            checkCollisions();
        }
        repaint();
    }


    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    direction = 'U';
                    UNIT_SIZE2=15;
                    UNIT_SIZE3=30;
                    break;

                case KeyEvent.VK_DOWN:
                    direction = 'D';
                    UNIT_SIZE2=15;
                    UNIT_SIZE3=30;
                    break;

                case KeyEvent.VK_LEFT:
                    direction = 'L';
                    UNIT_SIZE2=30;
                    UNIT_SIZE3=15;
                    break;

                case KeyEvent.VK_RIGHT:
                    direction = 'R';
                    UNIT_SIZE2=30;
                    UNIT_SIZE3=15;
                    break;


                case KeyEvent.VK_R:
                    Score = 0;
                    Crash = 0;
                    newFuel();
                    newMeteor();
                    running = true;

            }

        }
    }



}