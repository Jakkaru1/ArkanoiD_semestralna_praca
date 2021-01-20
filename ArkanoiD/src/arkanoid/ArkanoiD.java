/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import java.io.IOException;

/**
 * Trieda ArkanoiD predstavuje main celeho programu a vytvára plátno a hru.
 *
 * @author -Axl-
 */
public class ArkanoiD {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Platno.dajPlatno();
        Hra hra = new Hra();

    }

}
