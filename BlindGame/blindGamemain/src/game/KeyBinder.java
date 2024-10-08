package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class KeyBinder {

	public static void setupKeyBindings(JButton buttonA, JButton buttonS, JButton buttonD, JButton buttonW) {
        // Associe a tecla 'A' ao botão "Aa"
        buttonA.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed A"), "aKey");
        buttonA.getActionMap().put("aKey", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                buttonA.doClick();
            }
        });

        // Associe a tecla 'S' ao botão "Ss"
        buttonS.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed S"), "sKey");
        buttonS.getActionMap().put("sKey", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                buttonS.doClick();
            }
        });

       
        buttonD.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed D"), "dKey");
        buttonD.getActionMap().put("dKey", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                buttonD.doClick();
            }
        });

        
        buttonW.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed W"), "wKey");
        buttonW.getActionMap().put("wKey", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                buttonW.doClick();
            }
        });
    }
	
}
