/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormCreateTarget.java
 *
 * Created on Apr 26, 2012, 3:07:19 PM
 */
package thesis.targets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author BSTNC
 */
public class FormCreateTarget extends javax.swing.JInternalFrame {

    /** Creates new form FormCreateTarget */
    public FormCreateTarget() {
        initComponents();
        if (thesis.FormAna.XmlURL != null) {
            lblUyari.setText(thesis.FormAna.XmlURL + " file loaded !");
        } else {
            lblUyari.setText("Please load a xml file !");
            lblUyari.setForeground(Color.red);
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

        jLabel1 = new javax.swing.JLabel();
        btnCreateTarget = new javax.swing.JButton();
        txtTargetName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDefault = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblUyari = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Create Target");
        setVisible(true);

        jLabel1.setText("Target Name :");

        btnCreateTarget.setText("Create");
        btnCreateTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTargetActionPerformed(evt);
            }
        });

        jLabel2.setText("Default :");

        jLabel3.setText("Description :");

        lblUyari.setText("!..");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblUyari))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDefault, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTargetName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCreateTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblUyari)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTargetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDefault, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addComponent(btnCreateTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCreateTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTargetActionPerformed
// TODO add your handling code here:
    try {
        // TODO add your handling code here:

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(thesis.FormAna.XmlURL);
        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        int id = 1;
        System.out.println("ID :::" + id);
        List TargetList = rootNode.getChildren("target");
        for (int i = 1; i < TargetList.size(); i++) {
            Element node = (Element) TargetList.get(i);
            Element OncekiNode = (Element) TargetList.get(i - 1);

            if (Integer.parseInt(node.getAttributeValue("id")) > Integer.parseInt(OncekiNode.getAttributeValue("id"))) {
                id = Integer.parseInt(node.getAttributeValue("id"));
            }
            System.out.println("ID :::" + id);
        }
        if (TargetList.size() == 1) {
            id = 2;
        }
        System.out.println("ID :::" + id);
        Element Target = new Element("target").setAttribute("name", txtTargetName.getText()).setAttribute("id", String.valueOf(id + 1));
        if (!txtDefault.getText().equals("")) {
            Target.setAttribute("default", txtDefault.getText());
        }
        if (!txtDescription.getText().equals("")) {
            Target.setAttribute("description", txtDescription.getText());
        }
        rootNode.addContent("\n");
        rootNode.addContent("   ");
        rootNode.addContent(Target);
        rootNode.addContent("\n");
        document.setRootElement(rootNode);
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(document, new FileWriter(thesis.FormAna.XmlURL));
        //txtCurrentPersoname.setText(txtPersonName.getText());
        JOptionPane.showMessageDialog(this, "Target Created !");
    } catch (JDOMException ex) {
        Logger.getLogger(FormCreateTarget.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(FormCreateTarget.class.getName()).log(Level.SEVERE, null, ex);
    }



}//GEN-LAST:event_btnCreateTargetActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateTarget;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblUyari;
    private javax.swing.JTextField txtDefault;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtTargetName;
    // End of variables declaration//GEN-END:variables
}
