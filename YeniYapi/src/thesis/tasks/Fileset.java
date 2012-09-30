/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Filleset.java
 *
 * Created on May 5, 2012, 1:06:54 AM
 */
package thesis.tasks;

import thesis.jtree.XmlTreeElement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author MCT
 */
public class Fileset extends javax.swing.JInternalFrame {

    TreePath yolum;
    String islem;

    /** Creates new form Filleset */
    public Fileset(TreePath yolum, String islem) {
        this.yolum = yolum;
        this.islem = islem;
        initComponents();
        jLabel6.setText(yolum.toString());
        jLabel8.setText(islem);
        if (islem.equals("edit")) {
            Onyukleme();
        }
        

    }

    private void Onyukleme() {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(thesis.FormAna.XmlURL);
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            // Target BUL
            Element target = null;
            List targetList = rootNode.getChildren("target");
            for (int i = 0; i < targetList.size(); i++) {
                if (((Element) targetList.get(i)).getAttributeValue("name").equals(((XmlTreeElement) yolum.getPathComponent(1)).getElement().getAttributeValue("name"))) {
                    System.out.println("Target Bulundu en azından");
                    target = (Element) targetList.get(i);
                }
            }


            for (int i = 2; i < yolum.getPathCount(); i++) {
                System.out.println("FOR A GIRDIK RAHAT OL");
                List l = target.getChildren();
                for (int j = 0; j < l.size(); j++) {
                    if (((Element) l.get(j)).getName().equals(((XmlTreeElement) yolum.getPathComponent(i)).getElement().getName())) {
                        System.out.println("ESIT LAN");
                        target = (Element) l.get(j);
                        break;
                    }
                }
            }
            String dir = target.getAttributeValue("dir");
            String excludes = target.getAttributeValue("excludes");
            String includes = target.getAttributeValue("includes");
            jdirtext.setText(dir);
            jinctext.setText(includes);
            jexctext.setText(excludes);
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void AddEvent() {

        Element yeniElement = new Element("fileset").setAttribute("dir", jdirtext.getText());
        yeniElement.addContent("\n");
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(thesis.FormAna.XmlURL);
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            // Target BUL
            Element target = null;
            List targetList = rootNode.getChildren();
            for (int i = 0; i < targetList.size(); i++) {
                if (((Element) targetList.get(i)).getAttributeValue("id").equals(((XmlTreeElement) yolum.getPathComponent(1)).getElement().getAttributeValue("id"))) {
                    System.out.println("Target Bulundu en azından");
                    target = (Element) targetList.get(i);
                }
            }


            for (int i = 2; i < yolum.getPathCount(); i++) {
                System.out.println("FOR A GIRDIK RAHAT OL");
                List l = target.getChildren();
                for (int j = 0; j < l.size(); j++) {
                    if (((Element) l.get(j)).getName().equals(((XmlTreeElement) yolum.getPathComponent(i)).getElement().getName())) {
                        System.out.println("ESIT LAN");
                        target = (Element) l.get(j);
                        break;
                    }
                }
            }
            if (!jinctext.getText().equals("")) {
                yeniElement.setAttribute("includes", jinctext.getText());
            }
            if (!jexctext.getText().equals("")) {
                yeniElement.setAttribute("excludes", jexctext.getText());
            }
            target.addContent("\n");
            target.addContent("   "); // 3 space 
            target.addContent(yeniElement);
            target.addContent("\n");
            document.setRootElement(rootNode);
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document, new FileWriter(thesis.FormAna.XmlURL));
            JOptionPane.showMessageDialog(this, "Ekleme Başarıyla Yapıldı !");
        } catch (Exception e) {
        }


    }

    public void EditEvent() {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(thesis.FormAna.XmlURL);
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            // Target BUL
            Element target = null;
            List targetList = rootNode.getChildren("target");
            for (int i = 0; i < targetList.size(); i++) {
                if (((Element) targetList.get(i)).getAttributeValue("name").equals(((XmlTreeElement) yolum.getPathComponent(1)).getElement().getAttributeValue("name"))) {
                    System.out.println("Target Bulundu en azından");
                    target = (Element) targetList.get(i);
                }
            }


            for (int i = 2; i < yolum.getPathCount(); i++) {
                System.out.println("FOR A GIRDIK RAHAT OL");
                List l = target.getChildren();
                for (int j = 0; j < l.size(); j++) {
                    if (((Element) l.get(j)).getName().equals(((XmlTreeElement) yolum.getPathComponent(i)).getElement().getName())) {
                        System.out.println("ESIT LAN");
                        target = (Element) l.get(j);
                        break;
                    }
                }
            }

            target.setAttribute("dir", jdirtext.getText());
            if (!jinctext.getText().equals("")) {
                target.setAttribute("includes", jinctext.getText().toString());
            }
            if (!jexctext.getText().equals("")) {
                target.setAttribute("excludes", jexctext.getText().toString());
            }

            document.setRootElement(rootNode);
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document, new FileWriter(thesis.FormAna.XmlURL));
            JOptionPane.showMessageDialog(this, "Güncelleme Başarıyla Yapıldı !");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jexctext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jinctext = new javax.swing.JTextField();
        jdirtext = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Fileset Task");

        jButton1.setText("Generate FileSet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Excludes  :");

        jLabel2.setText("Includes  :");

        jLabel1.setText("Dir           :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("!");

        jLabel7.setText("To do :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("!");

        jLabel5.setText("Node Path :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jexctext)
                            .addComponent(jinctext)
                            .addComponent(jdirtext, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jdirtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jinctext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jexctext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (islem.equals("add")) {
        AddEvent();
    } else {
        EditEvent();
    }

}//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jdirtext;
    private javax.swing.JTextField jexctext;
    private javax.swing.JTextField jinctext;
    // End of variables declaration//GEN-END:variables
}
