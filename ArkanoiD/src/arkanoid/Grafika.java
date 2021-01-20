/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Trieda Grafika vytvorí celú grafiku hry.
 *
 * @author alexm
 */
public class Grafika implements ISkry {

    private Bumper bumper;
    private Ball ball;
    private Manazer manazeris;
    private Blok blok;
    private Obrazok[][] poleBlokov;
    private int skore;
    private int sucetBlokov;
    private int stavHry;

    /**
     *
     * @throws IOException aaa
     */
    public Grafika() throws IOException {
        this.blok = new Blok();
        this.poleBlokov = this.blok.getPoleBlokov();
        this.bumper = new Bumper();
        this.ball = new Ball();
        this.manazeris = new Manazer();
        this.manazeris.spravujObjekt(this.bumper);
        this.manazeris.spravujObjekt(this.ball);
        this.sucetBlokov = 2;
        this.nacitaj();
        this.stavHry = 2;

    }

    /**
     * Metóda getStavHry vrati hodnotu stavu hry.
     *
     * @return stavHry integer.
     */
    public int getStavHry() {
        return this.stavHry;
    }

    /**
     * Metóda tik spolupracuje s manažérom a funguje ako timer ktorý sa stále
     * vykonáva.
     *
     * @throws java.io.FileNotFoundException aaa
     */
    public void tik() throws FileNotFoundException {

        if (this.sucetBlokov == 21) {
            this.zapis();
            this.stavHry = 1;
        } else {
            if (this.ball.getLavyHornyY() + 50 >= this.bumper.getLavyHornyY() && this.ball.getLavyHornyX() <= this.bumper.getLavyHornyX() + 200 && this.ball.getLavyHornyX() + 50 >= this.bumper.getLavyHornyX()) {
                this.ball.zmenSmerY();
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 7; j++) {
                    if (this.poleBlokov[i][j] != null) {
                        if ((this.ball.getLavyHornyY() <= this.poleBlokov[i][j].getLavyHornyY() + 50) && (this.ball.getLavyHornyY() + 50 >= this.poleBlokov[i][j].getLavyHornyY())) { // kontrola vlavo vpravo
                            if ((this.ball.getLavyHornyX() == this.poleBlokov[i][j].getLavyHornyX() + 100)) {
                                //naraz z prava do bloku
                                this.ball.zmenSmerX();
                                this.poleBlokov[i][j].zmenSuradnice(-100, -100);
                                this.skore += 100;
                                this.sucetBlokov++;
                                System.out.println(this.skore);
                                System.out.println(this.sucetBlokov);
                            }
                            if ((this.ball.getLavyHornyX() + 50 == this.poleBlokov[i][j].getLavyHornyX())) {
                                //naraz z lava do bloku
                                this.ball.zmenSmerX();
                                this.poleBlokov[i][j].zmenSuradnice(-100, -100);
                                this.skore += 100;
                                this.sucetBlokov++;
                                System.out.println(this.skore);
                                System.out.println(this.sucetBlokov);
                            }
                        }

                        if ((this.ball.getLavyHornyX() <= this.poleBlokov[i][j].getLavyHornyX() + 100) && (this.ball.getLavyHornyX() + 50 >= this.poleBlokov[i][j].getLavyHornyX())) { // kontrola hore dole
                            if (this.ball.getLavyHornyY() == this.poleBlokov[i][j].getLavyHornyY() + 50) {
                                //naraz z dolu do bloku
                                this.ball.zmenSmerY();
                                this.poleBlokov[i][j].zmenSuradnice(-100, -100);
                                this.skore += 100;
                                this.sucetBlokov++;
                                System.out.println(this.skore);
                                System.out.println(this.sucetBlokov);
                            }
                            if (this.ball.getLavyHornyY() + 50 == this.poleBlokov[i][j].getLavyHornyY()) {
                                //naraz z z hora do bloku
                                this.ball.zmenSmerY();
                                this.poleBlokov[i][j].zmenSuradnice(-100, -100);
                                this.skore += 100;
                                this.sucetBlokov++;
                                System.out.println(this.skore);
                                System.out.println(this.sucetBlokov);
                            }
                        }
                    }

                }
            }
            if (this.ball.getPrehra() == 0) {
                this.zapis();
                this.stavHry = 0;
            }
        }

    }

    /**
     * Metóda koniecHry prikazuje manažérovi aby prestal spravovat objekty
     * bumper a ball a priradí im null.
     */
    public void koniecHry() {
        this.manazeris.prestanSpravovatObjekt(this.bumper);
        this.manazeris.prestanSpravovatObjekt(this.ball);
        this.bumper = null;
        this.ball = null;
    }

    /**
     * Metóda nacitaj načítava skóre zo súboru.
     *
     * @throws java.io.IOException aaa
     */
    public void nacitaj() throws IOException {
        try {
            File subor = new File("skore.txt");
            Scanner citac = new Scanner(subor);
            while (citac.hasNextLine()) {
                this.skore = citac.nextInt();
            }
            citac.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metóda zapis zapisuje skóre do súboru.
     *
     * @throws java.io.FileNotFoundException aaa
     */
    public void zapis() throws FileNotFoundException {
        try {
            File subor = new File("skore.txt");
            PrintWriter zapisovac = new PrintWriter(subor);
            zapisovac.println(this.skore);
            zapisovac.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metóda skry skryje ball, bumper a všetky bloky.
     */
    public void skry() {
        this.ball.skry();
        this.bumper.skry();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                this.poleBlokov[i][j].skry();
                this.poleBlokov[i][j] = null;
            }
        }
    }

}
