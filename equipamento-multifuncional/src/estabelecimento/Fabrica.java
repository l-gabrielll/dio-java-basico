package estabelecimento;

import equipamentos.copiadora.Copiadora;
import equipamentos.copiadora.Xerox;
import equipamentos.digitalizadora.Digitalizadora;
import equipamentos.digitalizadora.Scanner;
import equipamentos.impressora.Deskjet;
import equipamentos.impressora.Impressora;
import equipamentos.impressora.Laserjet;
import equipamentos.multifuncional.EquipamentoMultifuncional;

public class Fabrica {
    public static void main(String[] args) {
        Impressora impressora = new Deskjet();
        impressora.imprimir();
        
        impressora = new Laserjet();
        impressora.imprimir();

        Digitalizadora digitalizadora = new Scanner();
        digitalizadora.digitalizar();

        Copiadora copiadora = new Xerox();
        copiadora.copiar();

        EquipamentoMultifuncional em = new EquipamentoMultifuncional();
        em.copiar();
        em.digitalizar();
        em.imprimir();

        copiadora = em;
        copiadora.copiar();

        digitalizadora = em;
        digitalizadora.digitalizar();

        impressora = em;
        impressora.imprimir();
    }
}
