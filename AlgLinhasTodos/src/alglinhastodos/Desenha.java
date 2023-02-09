/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alglinhastodos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AlunoBCC
 */
public class Desenha extends JFrame implements Runnable{
    private int option =1;

    public Desenha() {
        
        new Thread(this).start();
        this.setTitle("Algoritmos de Linhas Retas - Todos");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void paint(Graphics g){
        
        switch(option){
            case 1:
        desenhaAnalitico(g);
        break;
            case 2:
        desenhaDDA(g);
        break;
            case 3:
        desenhaBres(g);
        break;
        }
    }
         
       private void desenhaBres(Graphics g){
        g.drawString("Bresenham", 50, 50);
        // g.setColor(Color.red);
        AlgBres(g,50,50,250,250);
        g.setColor(Color.blue);
        AlgBres(g,50,50,250,50);
        g.setColor(Color.green);
        AlgBres(g,50,50,50,250);
        g.setColor(Color.gray);
        AlgBres(g,50,50,250,150);
        g.setColor(Color.yellow);
        AlgBres(g,50,50,150,250);
       }

    
     private void desenhaAnalitico(Graphics g){
        g.drawString("Analitico", 50, 50);
        // g.setColor(Color.red);
        AlgAnalitic(g,50,50,250,250);
        g.setColor(Color.blue);
        AlgAnalitic(g,50,50,250,50);
        g.setColor(Color.green);
        AlgAnalitic(g,50,50,50,250);
        g.setColor(Color.gray);
        AlgAnalitic(g,50,50,250,150);
        g.setColor(Color.yellow);
        AlgAnalitic(g,50,50,150,250);
     }
      private void desenhaDDA(Graphics g){
        g.drawString("Analitico", 50, 50);
        // g.setColor(Color.red);
        algDDA(g,50,50,250,250);
        g.setColor(Color.blue);
        algDDA(g,50,50,250,50);
        g.setColor(Color.green);
        algDDA(g,50,50,50,250);
        g.setColor(Color.gray);
        algDDA(g,50,50,250,150);
        g.setColor(Color.yellow);
        algDDA(g,50,50,150,250);
     }

    public void algDDA(Graphics g, int xi, int yi, int xf, int yf){
    int steps, dx, dy;
    float x=xi, y=yi, incX, incY;
    
    dx=xf-xi;
    dy=yf-yi;
    
    if (Math.abs(dx)>Math.abs(dy)){
        steps = Math.abs(dx); 
        incX = 1; 
        incY=(float) dy/dx;
    }
    else{
    steps = Math.abs(dy); 
    incY = 1; 
    incX=(float) dx/dy;
    }
    
    System.out.println(steps + "-" + dx + "-" + dy+ "-"+"-" +incX+ incY);    
    for (int i=0;i<steps;i++){
        x = x + incX;
        y = y+ incY;
       putPixel(g, Math.round(x), Math.round(y)); 
    } 
    }   
    public void AlgAnalitic(Graphics g, int xi, int yi, int xf, int yf) {
        float m, b, dy, dx;
        int x,y;
        dy=(yf-yi);
        dx=(xf - xi);
        
        m=dy/dx;
        b=yi-m*xi;
        
        for(x=xi; x<xf; x++){
        
            y=(int)(m*x+b);
        
            putPixel(g,x,y);
        }
    }
   private void AlgBres(Graphics g, int xi, int yi, int xf, int yf){
        int x=xi, y=yi, dy=yf-yi, dx=xf-xi, dec=0;
        
        if(dy <= dx){
            
            while(true){
            putPixel(g,x,y);
            if(x==xf)break;
            x++;
            dec += dy;
            if(dec >= dx){y++; dec -= dx;}
            }
        }else{
            while(true){
            putPixel(g,x,y);
            if(y==yf)break;
            y++;
            dec += dx;
            if(dec >= dy){x++; dec -= dy;}
            
            }
        }
    }

    public void putPixel(Graphics g, int x, int y){
        g.drawLine(x, y, x, y);
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(3000);
                option++; if(option>3) option = 0;
                repaint();
            } catch (InterruptedException ex) {
                
            }
        }
    }

    
}
