package org.ui;


import org.program.InputHandler;
import org.program.Program;

import java.sql.SQLException;

public class UI {
    public void run() throws SQLException {
        InputHandler inp = new InputHandler();
        Program program = new Program();

        while (true) {
            System.out.println(
                    "Vad vill du göra?\n1. Söka efter skådespelare\n2. Registrera skådespelare\n3. Redigera skådespelare\n4. Ta bort skådespelare\n5. Sök fram filmer utifrån skådespelare\n6. Avsluta programmet");

            switch (inp.getIntInput()) {
                case 1:
                    program.findAnActor();
                    break;
                case 2:
                    program.addAnActor();
                    break;
                case 3:
                    program.updateActorNames();
                    break;
                case 4:
                    program.deleteAnActor();
                    break;
                case 5:
                    program.findFilmsForActor();
                    break;
                case 6:
                    System.out.println("Programmet avslutas");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Felaktig inmatning");
                    break;

            }

        }
    }

}