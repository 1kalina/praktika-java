/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author sviatik-fedora
 */
package ex01;

import java.io.OutputStream;
import java.io.PrintStream;
import ex07.WindowTask1;

public class Main {
    public static void run(WindowTask1 window) {
        // Перенаправлення виводу в JTextArea
        PrintStream printStream = new PrintStream(new TextAreaOutputStream(window.getTextArea()));
        System.setOut(printStream);
        System.setErr(printStream);
        
        System.out.println("OS is running. GitHub is configured. Netbeans is up.");
    }
}

class TextAreaOutputStream extends OutputStream {
    private final javax.swing.JTextArea textArea;

    public TextAreaOutputStream(javax.swing.JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) {
        textArea.append(String.valueOf((char) b));
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
