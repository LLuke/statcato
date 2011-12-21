/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.statcato;

import org.statcato.graph.StatcatoChartFrame;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A menu item for a chart frame.
 *
 * @author Margaret Yau
 * @version %I%, %G%
 * @see StatcatoChartFrame
 * @since 1.0
 */
public class StatcatoChartMenuItem extends JMenuItem {
    private StatcatoChartFrame frame;

    /**
     * Constructor.
     *
     * @param title chart title
     * @param frame StatcatoChartFrame instance
     */
    public StatcatoChartMenuItem(String title, StatcatoChartFrame frame) {
        super(title);
        this.frame = frame;
        addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               menuActionPerformed(e);
           }
        });
    }

    /**
     * Restores the frame associated with this menu item.
     *
     * @param e ActionEvent
     */
    public void menuActionPerformed(ActionEvent e) {
        frame.restore();
    }
}
