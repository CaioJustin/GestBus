package br.com;

import javax.swing.UIManager;

import br.com.view.JanelaPrincipal;


public class Main {

    public static void main(String[] args) {
        
                try {
            // Tenta configurar o Look and Feel Nimbus
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Se não conseguir configurar o Nimbus, usa o Look and Feel padrão do sistema
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        JanelaPrincipal window = new JanelaPrincipal();
        window.setVisible(true);

    }
}