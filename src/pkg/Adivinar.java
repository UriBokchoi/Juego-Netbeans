package pkg;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.util.HashMap;
import java.util.Random;

public class Adivinar extends javax.swing.JFrame {

     private HashMap<String, Integer> preguntasRespuestas;
    private String preguntaActual;
        private ArrayList<String> preguntasRespondidas;
    private int respuestaCorrecta;
    private int intentosRestantes;
    private int preguntasTotales;
    private int intentosTotales;
    private int aciertos;
    private Random random;
    private boolean ayudaActivada;
     

    public Adivinar() {
      random = new Random();
        initComponents();
        inicializarPreguntas();
        preguntasRespondidas = new ArrayList<>();
        mostrarPreguntaAleatoria();
        intentosRestantes = 5;

        preguntasTotales = 3; 
        intentosTotales = 0;
        aciertos = 0;
        ayudaActivada = false;
    }

    private void inicializarPreguntas() {
        preguntasRespuestas = new HashMap<>();
        preguntasRespuestas.put("¿En qué año fue la Revolución Francesa?", 1789);
        preguntasRespuestas.put("¿En qué año fue la caída del Muro de Berlín?", 1989);
        preguntasRespuestas.put("¿En qué año se hundió el Titanic?", 1912);
        preguntasRespuestas.put("¿En qué año llegó el hombre a la luna?", 1969);
        preguntasRespuestas.put("¿En qué año empezó la Segunda Guerra Mundial?", 1939);
        
    }

    private void mostrarPreguntaAleatoria() {
        if (preguntasRespondidas.size() < preguntasRespuestas.size()) {
            Object[] preguntas = preguntasRespuestas.keySet().toArray();
            String nuevaPregunta;

            do {
                int indiceAleatorio = random.nextInt(preguntas.length);
                nuevaPregunta = (String) preguntas[indiceAleatorio];
            } while (preguntasRespondidas.contains(nuevaPregunta));

            preguntaActual = nuevaPregunta;
            respuestaCorrecta = preguntasRespuestas.get(preguntaActual);
            PreguntaLable1.setText(preguntaActual);
        } else {
            mostrarResultadoFinal();
        }
    }
    

   private void verificarRespuesta() {
    String respuestaUsuario = RespuestaTextField.getText();
        try {
            int respuestaUsuarioInt = Integer.parseInt(respuestaUsuario);
            intentosRestantes--;
            intentosTotales++;

            if (respuestaUsuarioInt == respuestaCorrecta) {
                JOptionPane.showMessageDialog(this, "¡Correcto!");
                aciertos++;
                preguntasRespondidas.add(preguntaActual); // Añadir pregunta a las respondidas
                siguientePregunta();
            } else {
                if (ayudaActivada) {  // Muestra la ayuda cuando está activada
                    if (respuestaUsuarioInt < respuestaCorrecta) {
                        JOptionPane.showMessageDialog(this, "La respuesta es mayor.");
                    } else {
                        JOptionPane.showMessageDialog(this, "La respuesta es menor.");
                    }
                }
                if (intentosRestantes > 0) {
                    JOptionPane.showMessageDialog(this, "Incorrecto. Te quedan " + intentosRestantes + " intentos.");
                } else {
                    JOptionPane.showMessageDialog(this, "No tienes más intentos. La respuesta era: " + respuestaCorrecta);
                    preguntasRespondidas.add(preguntaActual); 
                    siguientePregunta();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce un número válido.");
        }
    }


    private void siguientePregunta() {
          if (preguntasRespondidas.size() < preguntasTotales) {
            intentosRestantes = 5;
            mostrarPreguntaAleatoria();
        } else {
            mostrarResultadoFinal();
        }
        RespuestaTextField.setText(""); 
    }

     private void mostrarResultadoFinal() {
        int totalIntentosPosibles = preguntasTotales * 5;
        double porcentajeAciertos = (double) aciertos / totalIntentosPosibles * 100;
        JOptionPane.showMessageDialog(this, "Has respondido correctamente " + aciertos + " de " + preguntasTotales
                + " preguntas.\nHas usado " + intentosTotales + " intentos.\nPorcentaje de errores: " + porcentajeAciertos + "%");
        
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres reiniciar el juego?", "Reiniciar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            reiniciarJuego();
    }
     }
         private void reiniciarJuego() {
        preguntasRespondidas.clear();
        intentosRestantes = 5;
        intentosTotales = 0;
        aciertos = 0;
        mostrarPreguntaAleatoria();
    }
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        RespuestaTextField = new javax.swing.JTextField();
        VerificarBoton = new javax.swing.JButton();
        CambiarDeEventoBoton = new javax.swing.JButton();
        AyudaCheckBox1 = new javax.swing.JCheckBox();
        PreguntaLable1 = new java.awt.Label();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("jCheckBoxMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adivina un evento historico");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        VerificarBoton.setText("Verificar");
        VerificarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarBotonActionPerformed(evt);
            }
        });

        CambiarDeEventoBoton.setText("Siguiente evento");
        CambiarDeEventoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarDeEventoBotonActionPerformed(evt);
            }
        });

        AyudaCheckBox1.setText("Ayuda");
        AyudaCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyudaCheckBox1ActionPerformed(evt);
            }
        });

        PreguntaLable1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AyudaCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RespuestaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CambiarDeEventoBoton, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(VerificarBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(PreguntaLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(PreguntaLable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VerificarBoton)
                    .addComponent(RespuestaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CambiarDeEventoBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AyudaCheckBox1)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerificarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarBotonActionPerformed
    verificarRespuesta();    }//GEN-LAST:event_VerificarBotonActionPerformed

    private void CambiarDeEventoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarDeEventoBotonActionPerformed
         intentosRestantes = 5; mostrarPreguntaAleatoria();    }//GEN-LAST:event_CambiarDeEventoBotonActionPerformed

    private void AyudaCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyudaCheckBox1ActionPerformed
        ayudaActivada = AyudaCheckBox1.isSelected();    }//GEN-LAST:event_AyudaCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adivinar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AyudaCheckBox1;
    private javax.swing.JButton CambiarDeEventoBoton;
    private java.awt.Label PreguntaLable1;
    private javax.swing.JTextField RespuestaTextField;
    private javax.swing.JButton VerificarBoton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    // End of variables declaration//GEN-END:variables
}
