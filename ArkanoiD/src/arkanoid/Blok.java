/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

/**
 * Trieda Blok vytvorí hracie bloky na plátno.
 *
 * @author -Axl-
 */
public class Blok extends Obrazok {

    private Obrazok[][] poleBlokov;

    /**
     * Konštruktor inicializuje pole blokov a zavolá metódu ostatnej
     * inicializacie.
     */
    public Blok() {
        //poleBlokov = new Obrazok[3][7];
        this.ini();
    }

    /**
     * Metóda ini slúži na inicializáciu a nakreslenie blokov na hracie pole.
     */
    public void ini() {
        this.poleBlokov = new Obrazok[3][7];
        int xBloku = 100;
        int yBloku = 50;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                this.poleBlokov[i][j] = new Obrazok("pics\\one.png");
                this.poleBlokov[i][j].zmenPolohu(xBloku, yBloku);
                this.poleBlokov[i][j].zobraz();
                xBloku += 185;
            }
            xBloku = 100;
            yBloku += 80;

        }
        // Kedze nemam vektory tieto dva bloky by ta lopta nikdy neznicila
        this.poleBlokov[0][2].zmenSuradnice(-100, -100);
        this.poleBlokov[0][6].zmenSuradnice(-100, -100);
    }

    /**
     * Metoda getPoleBlokov vrati pole blokov.
     *
     * @return poleBlokov Obrazok[][].
     */
    public Obrazok[][] getPoleBlokov() {
        return this.poleBlokov;
    }

    /**
     * Metóda zmenSuradnice zmeni suradnice bloku.
     *
     * @param x integer, y integer. Suradnice.
     * @param y
     */
    public void zmenSuradnice(int x, int y) {
        this.poleBlokov[x][y].zmenSuradnice(x, y);
    }

    /**
     * Metóda getLavyHornyX vrati hodnotu laveho horneho X.
     *
     * @param x integer, y integer. Suradnice.
     * @param y
     * @return poleBlokov[x][y].lavyHornyX integer.
     */
    public int getLavyHornyX(int x, int y) {
        return this.poleBlokov[x][y].lavyHornyX;
    }

    /**
     * Metóda getLavyHornyY vrati hodnotu laveho horneho Y.
     *
     * @param x integer, y integer. Suradnice.
     * @param y
     * @return this.poleBlokov[x][y].lavyHornyY integer.
     */
    public int getLavyHornyY(int x, int y) {
        return this.poleBlokov[x][y].lavyHornyY;
    }

}
