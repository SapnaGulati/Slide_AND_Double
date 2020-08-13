

package slide_And_double;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.border.BevelBorder.RAISED;

public class Slide_And_Double implements KeyListener 
{
    JFrame jf=new JFrame();    
    JLabel[][] label = new JLabel[4][4];
    int val[][]=new int[4][4];
    int i,j,k,m;
    int score=0;
    JDesktopPane d=new JDesktopPane();
    ImageIcon icon=new ImageIcon("C:\\Users\\ADMIN\\Documents\\back1.jpg");
    JDesktopPane p=new JDesktopPane();
    JLabel b1=new JLabel();
    JLabel label1=new JLabel("Press Esc to Restart");
    JLabel ab=new JLabel();
    Random r=new Random();
    int return2or4(boolean b)
    {
        if(b)
            return 2;
        else
            return 4;
    }
    
    Slide_And_Double()
    {
        jf.setTitle("SLIDE NAND DOUBLE JUST 12");
        jf.setSize(405,480);
        jf.setLayout(null);
        jf.setLocation(650,250);
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Documents\\IMG-20190706-WA0014.jpg"));
        jf.setResizable(false);
        label1.setFont(new Font("ALGERIAN",1,16));
        label1.setForeground(Color.WHITE);
        label1.setBounds(200,415,200,30);
        scores();
        p.setBounds(0,0,400,400);
        p.setLayout(new GridLayout(4,4));
        p.setBackground(Color.LIGHT_GRAY);
        jf.add(p);
        d.setBounds(0,400,400,50);
        jf.add(label1);
        jf.add(b1);
        ab.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\back1.jpg"));
        ab.setBounds(0,350,400,50);
        d.add(ab);
        d.setLayout(new OverlayLayout(d));
        jf.add(d);
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                label[i][j]=new JLabel("",JLabel.CENTER);
                label[i][j].setFont(new Font("ALGERIAN",1,24));
                val[i][j]=0;
                label[i][j].setForeground(Color.WHITE);
                p.add(label[i][j]);
                label[i][j].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(8, 8, 6, 8, icon),new javax.swing.border.BevelBorder(RAISED)));
            }
        }
        jf.setVisible(true);
        jf.addKeyListener(this);
        val[Math.abs(r.nextInt() % 4)] [Math.abs(r.nextInt() % 4)] = return2or4(r.nextBoolean());
        display();
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
       new Slide_And_Double();
    }

    private void display() 
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                label[i][j].setText(str(val[i][j]));
                Color color=getBackground(label[i][j]);
                label[i][j].setForeground(color);
            }
	}
    }

    private String str(int a) 
    {
        if(a!=0)
            return Integer.toString(a);
        else
            return "";
    }

    @Override
    public void keyTyped(KeyEvent ke) 
    {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) 
    {
        int key=ke.getKeyCode();
        switch (key)
        {
            case KeyEvent.VK_UP :
                             checkSuccess();
                             if(!isEnd())
                                 moveUp();
                             else
                                 gameOver();
                             break;
            case KeyEvent.VK_DOWN:
                            checkSuccess();
                            if (!isEnd())
				moveDown();
                            else
				gameOver();
                            break;
            case KeyEvent.VK_RIGHT:
                            checkSuccess();
                            if (!isEnd())
				moveRight();
                            else
				gameOver();
                            break;
            case KeyEvent.VK_LEFT:
                            checkSuccess();
                            if (!isEnd())
				moveLeft();
                            else
				gameOver();
                            break;
            case KeyEvent.VK_ESCAPE:
                            jf.dispose();
                            new Slide_And_Double();
                            break;
        }       
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
        
    }

    private void checkSuccess()
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j]==4096 )
                {
                    jf.dispose();
                    JFrame p1=new JFrame();
                    p1.setLayout(null);
                    p1.setSize(400,400);
                    p1.setTitle("WINNER OF GAME");
                    p1.setLocation(650,250);
                    p1.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Documents\\IMG-20190706-WA0014.jpg"));
                    JLabel l=new JLabel("CONGRATULATIONS.... ",JLabel.LEADING);
                    JLabel l2=new JLabel("YOU GOT JUST 12.....",JLabel.LEADING);
                    JLabel l3=new JLabel("YOU WON THE GAME....",JLabel.LEADING);
                    l.setBounds(60,50,400,100);
                    l2.setBounds(60,100,400,100);
                    l3.setBounds(60,150,400,100);
                    l.setFont(new Font("ALGERIAN",1,26));
                    l2.setFont(new Font("ALGERIAN",1,26));
                    l3.setFont(new Font("ALGERIAN",1,26));
                    l.setForeground(Color.WHITE);
                    l2.setForeground(Color.WHITE);
                    l3.setForeground(Color.WHITE);
                    JLabel l1=new JLabel();
                    l1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\giphy.gif"));    
                    l1.setBounds(0,0,400,400);
                    JButton t=new JButton("REPLAY");
                    t.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae)
                        {
                            p1.dispose();
                            new Slide_And_Double();
                        }
                    });
                    t.setBounds(160,250,80,30);
                    t.setFont(new Font("ALGERIAN",1,16));
                    t.setBorder(BorderFactory.createBevelBorder(RAISED));
                    p1.add(l);
                    p1.add(l2);
                    p1.add(l3);
                    p1.add(t);
                    p1.add(l1);
                    p1.setVisible(true);
                }
            }
        }
    }

    private void moveUp() 
    {
        if(endUp())
            return;
        for(j=0;j<4;j++)
        {
            int[] stack=new int[4];
            int top=-1;
            for(i=3;i>=0;i--)
            {
                if(val[i][j] !=0)
                {
                    stack[++top]=val[i][j];
                    val[i][j]=0;
                }           
            }
            for(i=0;i<4;i++)
            {
                if(top>=0 && val[i][j]==0)
                {
                    val[i][j]=stack[top--];
                }
            }
        }
        mergeUp();
        generateNewElement();
        display();
    }

    private void gameOver() 
    {
        jf.dispose();
        JFrame frame=new JFrame();
        frame.setTitle("SLIDE NAND DOUBLE JUST 12");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocation(650,250);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ADMIN\\Documents\\IMG-20190706-WA0014.jpg"));
        JLabel label=new JLabel("GAME OVER");
        label.setFont(new Font("ALGERIAN",1,24));
        label.setBounds(120,100,160,50);
        JLabel la=new JLabel();
        la.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Documents\\a.gif"));
        la.setBounds(0,0,400,400);
        label.setForeground(Color.WHITE);
        JButton button=new JButton("Restart");
        button.setBorder(BorderFactory.createBevelBorder(RAISED));
        button.setBounds(160,250,60,30);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                frame.dispose();
                new Slide_And_Double();
            }
        });
        frame.add(label);
        frame.add(button);
        frame.add(la);
        frame.setVisible(true);
    }

    private void moveLeft() 
    {
        if(endLeft())
            return;
        for(i=0;i<4;i++)
        {
            int[] stack=new int[4];
            int top=-1;
            for(j=3;j>=0;j--)
            {
                if(val[i][j] !=0)
                {
                    stack[++top]=val[i][j];
                    val[i][j]=0;
                }           
            }
            for(j=0;j<4;j++)
            {
                if(top>=0 && val[i][j]==0)
                {
                    val[i][j]=stack[top--];
                }
            }
        }
        mergeLeft();
        generateNewElement();
        display();
    }

    private void moveRight() 
    {
        if(endRight())
            return;
        for(i=0;i<4;i++)
        {
            int[] stack=new int[4];
            int top=-1;
            for(j=0;j<4;j++)
            {
                if(val[i][j] !=0)
                {
                    stack[++top]=val[i][j];
                    val[i][j]=0;
                }           
            }
            for(j=3;j>=0;j--)
            {
                if(top>=0 && val[i][j]==0)
                {
                    val[i][j]=stack[top--];
                }
            }
        }
        mergeRight();
        generateNewElement();
        display();
    }

    private void moveDown() 
    {
        if(endDown())
            return;
        for(j=0;j<4;j++)
        {
            int[] stack=new int[4];
            int top=-1;
            for(i=0;i<4;i++)
            {
                if(val[i][j] !=0)
                {
                    stack[++top]=val[i][j];
                    val[i][j]=0;
                }           
            }
            for(i=3;i>=0;i--)
            {
                if(top>=0 && val[i][j]==0)
                {
                    val[i][j]=stack[top--];
                }
            }
        }
        mergeDown();
        generateNewElement();
        display();
    }

    public boolean isEnd() 
    {
        return endRight() && endDown() && endUp() && endLeft();
    }

    private boolean endRight() 
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j]==0)
                    return false;
            }
        }
        for(i=0;i<4;i++)
        {
            for(j=3;j>0;j--)
            {
                if(val[i][j]==val[i][j-1])
                    return false;
            }
        }
        return true;
    }

    private boolean endDown() 
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j]==0)
                    return false;
            }
        }
        for(i=3;i>0;i--)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j]==val[i-1][j])
                    return false;
            }
        }
        return true;
    }

    private boolean endUp() 
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j]==0)
                    return false;
            }
        }
        for(i=0;i<3;i++)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j]==val[i+1][j])
                    return false;
            }
        }
        return true;
    }

    private boolean endLeft() 
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j]==0)
                    return false;
            }
        }
        for(i=0;i<4;i++)
        {
            for(j=0;j<3;j++)
            {
                if(val[i][j]==val[i][j+1])
                    return false;
            }
        }
        return true;
    }
    
    private void mergeDown() 
    {
        for(j=0;j<4;j++)
        {
            for(i=3;i>0;i--)
            {
                if(val[i][j] == val[i-1][j])
                {
                    if(val[i][j] != 0 && val[i-1][j] != 0)
                    {
                        score+=2;
                        scores();
                    }
                    val[i][j]+= val[i-1][j];
                    k=i-1;
                    while(k>0)
                    {
                        val[k][j]=val[k-1][j];
                        k--;
                    }
                    val[0][j]=0;
                }
            }
        }
    }
    
    private void mergeUp() 
    {
        for(j=0;j<4;j++)
        {
            for(i=0;i<3;i++)
            {
                if(val[i][j] == val[i+1][j])
                {
                    if(val[i][j] != 0 && val[i+1][j] != 0)
                    {
                        score+=2;
                        scores();
                    }
                    val[i][j]+= val[i+1][j];
                    k=i+1;
                    while(k<3)
                    {
                        val[k][j]=val[k+1][j];
                        k++;
                    }
                    val[3][j]=0;
                }
            }
        }
    }

    private void generateNewElement() 
    {
        boolean zero=false;
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(val[i][j] == 0)
                    zero=true;
                break;
            }
        }
        int i1,i2;
        i1=Math.abs(r.nextInt() % 4);
        i2=Math.abs(r.nextInt() % 4);
        while(val[i1][i2] != 0)
        {
            i1=Math.abs(r.nextInt() % 4);
            i2=Math.abs(r.nextInt() % 4);
        }
        val[i1][i2]= return2or4(r.nextBoolean());
    }

    private void mergeLeft() 
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<3;j++)
            {
                if(val[i][j] == val[i][j+1])
                {
                    if(val[i][j] != 0 && val[i][j+1] !=0)
                    {
                        score+=2;
                        scores();
                    }
                    val[i][j]+= val[i][j+1];
                    k=j+1;
                    while(k<3)
                    {
                        val[i][k]=val[i][k+1];
                        k++;
                    }
                    val[i][3]=0;
                }
            }
        }
    }

    private void mergeRight() 
    {
        for(i=0;i<4;i++)
        {
            for(j=3;j>0;j--)
            {
                if(val[i][j] == val[i][j-1])
                {
                    if(val[i][j] != 0 && val[i][j-1] != 0)
                {
                    score+=2;
                    scores();
                }
                    val[i][j]+= val[i][j-1];
                    k=j-1;
                    while(k>0)
                    {
                        val[i][k]=val[i][k-1];
                        k--;
                    }
                    val[i][0]=0;
                }
            }
        }
    }
    
    private void scores()
    {
        b1.setText("SCORE : "+score);
        b1.setFont(new Font("ALGERIAN",1,18));
        b1.setForeground(Color.WHITE);
        b1.setBounds(10,415,150,30);
    }

    private Color getBackground(JLabel a) 
    {
        switch(a.getText())
        {
            case "2":       return new Color(255,105,180);
            case "4":       return new Color(255,127,80);
            case "8":       return new Color(30,144,255);
            case "16":      return new Color(204,0,255);
            case "32":      return new Color(139,0,139);
            case "64":      return new Color(255,51,102);
            case "128":     return new Color(255,0,0);
            case "256":     return new Color(51,51,255);
            case "512":     return new Color(220,20,67);
            case "1024":    return new Color(148,0,211);
            case "2048":    return new Color(255,0,255);
            case "4096":    return new Color(128,0,0);                                   
        }
        return Color.BLACK;
    }
}
