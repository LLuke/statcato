/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.statcato.graph;

import javax.swing.*;
import java.awt.image.BufferedImage;

import org.jfree.chart.JFreeChart;

/**
 * Utilities for graph generation and manipulation.
 * 
 * @author  Margaret Yau
 * @version %I%, %G%
 * @see org.jfree.chart
 * @since 1.0
 */
public class GraphUtils {
    public static Icon createGraphImageLabel(JFreeChart plot) {
        BufferedImage image = plot.createBufferedImage(400, 300);
        return new ImageIcon(image);
    } 
}
