/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

/**
 * Trieda Ball vytvorí loptičku a jej pohyb.
 * @author alexm
 */
public class Ball implements ISkry {
    private Obrazok ball;
    private int smerX;
    private int smerY;
    private int posun;
    private int prehra;

    /**
     * Konštruktor inicializuje loptičku mení jej súradnice a zapína pohyb.
     */
    public Ball() {
        this.ball = new Obrazok ("pics\\ball.png");
        this.ball.zmenPolohu(550, 600); 
        this.ball.zobraz();
        this.posun = 5;
        this.smerX = this.posun;
        this.smerY = this.posun;
        this.prehra = 8;

    }
    
    /**
     * Metóda tik spolupracuje s manažérom a funguje ako timer ktorý sa stále vykonáva.
     */ 
    public void tik() {
        this.ball.posunVodorovne(this.smerX); 
        this.ball.posunZvisle(this.smerY);
        //lava 
        if (this.ball.getLavyHornyX() <= 0) { 
            this.smerX = this.posun;
            if (this.smerY == this.posun) {
                this.smerY = this.posun;
            } else {
                this.smerY = -this.posun;
            }
        }
        //prava 
        if (this.ball.getLavyHornyX() + this.ball.sirka() >= 1300) { 
            this.smerX = -this.posun;
            if (this.smerY == -this.posun) {
                this.smerY = -this.posun;
            } else {
                this.smerY = this.posun;
            }
        }
        //spodok potom vymazat podmienku a dat zivoty
        if (this.ball.getLavyHornyY() + this.ball.sirka() >= 800) {
            this.prehra = 0;
           
        }
        //vrch
        if (this.ball.getLavyHornyY() <= 0) {
            if (this.smerX == -this.posun) {
                this.smerX = -this.posun;
            } else {
                this.smerX = this.posun;
            }
            this.smerY = this.posun;
        }
        
    }
    
    /**
     * Metóda getLavyHornyX vráti hodnotu lavého horného X v int.
     * @return ball.getLavyHornyX integer.
     */
    public int getLavyHornyX() {
        return this.ball.getLavyHornyX();
    }
    
    /**
     * Metóda getLavyHornyY vráti hodnotu lavého horného Y v int.
     * @return ball.getLavyHornyY integer.
     */
    public int getLavyHornyY() {
        return this.ball.getLavyHornyY();
    }
    
    /**
     * Metóda zmenSmerX zmení smer po X-ovej osi.
     */
    public void zmenSmerX() {
        this.smerX *= -1;     
    }
    
    /**
     * Metóda zmenSmerY zmení smer po Y-ovej osi.
     */
    public void zmenSmerY() {
        this.smerY *= -1;
    }
    
    /**
     * Metóda getPrehra vráti hodnotu ktorá sa využíva pri podmienke a konci hry.
     * @return this.prehra, integer.
     */ 
    public int getPrehra() {
        return this.prehra;
    }
    
    /**
     * Metóda skry skryje loptičku.
     */
    public void skry() {
        this.ball.skry();
        this.ball = null;
    }
    
}
