/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.io.IOException;

/**
 * Trieda Hra reprezenzuje inicializaciu grafiky, manazera a obrazku ktory sa
 * vykreslí na konci hry.
 *
 * @author -Axl-
 */
public class Hra {

    private Grafika grafika;
    private Manazer manazerGrafiky;
    private Obrazok konecnyObrazok;

    /**
     * Konštruktor inicializuje vytvorenú grafiku, manažéra a prikáže manažérovi
     * spravovať objekty grafika a seba samého teda hru.
     *
     * @throws java.io.IOException aaa
     */
    public Hra() throws IOException {
        this.grafika = new Grafika();
        this.manazerGrafiky = new Manazer();
        this.manazerGrafiky.spravujObjekt(this.grafika);
        this.manazerGrafiky.spravujObjekt(this);
    }

    /**
     * Metóda tik spolupracuje s manažérom a funguje ako timer ktorý sa stále
     * vykonáva.
     */
    public void tik() {
        if (this.grafika.getStavHry() == 1) {
            this.konecnyObrazok = new Obrazok("pics\\vyhra.png");
            this.konecnyObrazok.zmenPolohu(650, 400);
            this.grafika.skry();
            this.konecnyObrazok.zobraz();
            this.grafika.koniecHry();
            this.manazerGrafiky.prestanSpravovatObjekt(this.grafika);
            this.grafika = null;

        }

        if (this.grafika.getStavHry() == 0) {
            this.konecnyObrazok = new Obrazok("pics\\prehra.png");
            this.konecnyObrazok.zmenPolohu(650, 400);
            this.grafika.skry();
            this.konecnyObrazok.zobraz();
            this.grafika.koniecHry();
            this.manazerGrafiky.prestanSpravovatObjekt(this.grafika);
            this.grafika = null;
        }
    }

    /**
     * Metóda zruš spolupracuje s manažérom a znamená že po slačení ESC sa
     * program vypne.
     */
    public void zrus() {
        System.exit(0);
    }

    /**
     * Metóda aktivuj spolupracuje s manažérom a využíva sa pri reštarte hry.
     *
     * @throws java.io.IOException aaa
     */
    public void aktivuj() throws IOException {
        this.konecnyObrazok.skry();
        this.konecnyObrazok = null;
        this.grafika = new Grafika();
        this.manazerGrafiky = new Manazer();
        this.manazerGrafiky.spravujObjekt(this.grafika);
        this.manazerGrafiky.spravujObjekt(this);
        Platno.dajPlatno();
    }
}
