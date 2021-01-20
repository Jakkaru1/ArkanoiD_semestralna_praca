/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

/**
 * Trieda Bumper vytvorí bumper a umožní jeho posuvanie vlavo a vpravo.
 *
 * @author -Axl-
 */
public class Bumper implements ISkry {

    private Obrazok bump;
    private boolean smerVlavo;
    private boolean smerVpravo;

    /**
     * Konštruktor zobrazuje bumper, vyberá obrázok zo suboru a mení jeho
     * polohu.
     */
    public Bumper() {
        this.bump = new Obrazok("pics\\bumper.png");
        this.bump.zmenPolohu(600, 700);
        this.bump.zobraz();
    }

    /**
     * Metóda posunVpravo posunie bumper vpravo.
     */
    public void posunVpravo() {
        if (this.smerVpravo) {
            this.bump.posunVodorovne(20);
        }
    }

    /**
     * Metóda posunVlavo posunie bumper vlavo.
     */
    public void posunVlavo() {
        if (this.smerVlavo) {
            this.bump.posunVodorovne(-20);
        }

    }

    /**
     * Metóda tik spolupracuje s manažérom a funguje ako timer ktorý sa stále
     * vykonáva.
     */
    public void tik() {
        if (this.bump.getLavyHornyX() <= 0) {
            this.smerVlavo = false;
        } else {
            this.smerVlavo = true;
        }

        if (this.bump.getLavyHornyX() + this.bump.sirka() >= 1300) {
            this.smerVpravo = false;
        } else {
            this.smerVpravo = true;
        }
    }

    /**
     * Metóda getLavyHornyX vrati hodnotu X.
     *
     * @return bump.getLavyHornyX integer.
     */
    public int getLavyHornyX() {
        return this.bump.getLavyHornyX();
    }

    /**
     * Metóda getLavyHornyY vrati hodnotu Y.
     *
     * @return bump.getLavyHornyY integer.
     */
    public int getLavyHornyY() {
        return this.bump.getLavyHornyY();
    }

    /**
     * Metóda getSirka vrati sirku bumpera.
     *
     * @return bump.sirka integer.
     */
    public int getSirka() {
        return this.bump.sirka();
    }

    /**
     * Metóda getVyska vrati vysku bumpera.
     *
     * @return bump.vyska integer.
     */
    public int getVyska() {
        return this.bump.vyska();
    }

    /**
     * Metóda skry skryje bumper.
     */
    public void skry() {
        this.bump.skry();
        this.bump = null;
    }
}
