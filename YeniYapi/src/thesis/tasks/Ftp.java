/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Ftp.java
 *
 * Created on May 6, 2012, 5:44:01 PM
 */
package thesis.tasks;

import javax.swing.tree.TreePath;
import thesis.jtree.XmlTreeElement;
import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.tree.TreePath;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
/**
 *
 * @author BSTNC
 */
public class Ftp extends javax.swing.JInternalFrame {

    /** Creates new form Ftp */
    TreePath yolum;
    String islem;
    public Ftp(TreePath yolum, String islem) {
        initComponents();
        this.yolum = yolum;
        this.islem = islem;
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
            String server = target.getAttributeValue("server");
            String remotedir = target.getAttributeValue("remotedir");
            String userid = target.getAttributeValue("userid");
            String password = target.getAttributeValue("password");
            txtPass.setText(password);
            txtUserId.setText(userid);
            txtRemoteDir.setText(remotedir);
            txtServer.setText(server);
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     private void AddEvent() {
        try {
            Element yeniElement = new Element("ftp");

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
            yeniElement.setAttribute("server", txtServer.getText());
            if (!txtRemoteDir.getText().equals("")) {
                yeniElement.setAttribute("remotedir", txtRemoteDir.getText());
            }
            if (!txtUserId.getText().equals("")) {
                yeniElement.setAttribute("userid", txtUserId.getText());
            }
            if (!txtPass.getText().equals("")) {
                yeniElement.setAttribute("password", txtPass.getText());
            }
            target.addContent("\n");
            target.addContent("   "); // 3 space 
            target.addContent(yeniElement);
            target.addContent("\n");
            document.setRootElement(rootNode);
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document, new FileWriter(thesis.FormAna.XmlURL));
            JOptionPane.showMessageDialog(this, "Ekleme Başarıyla Yapıldı !");
        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void EditEvent() {
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
            target.setAttribute("server", txtServer.getText());
            if (!txtRemoteDir.getText().equals("")) {
                target.setAttribute("remotedir", txtRemoteDir.getText());
            }
            if (!txtUserId.getText().equals("")) {
                target.setAttribute("userid", txtUserId.getText());
            }
            if (!txtPass.getText().equals("")) {
                target.setAttribute("password", txtPass.getText());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        txtRemoteDir = new javax.swing.JTextField();
        txtUserId = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        btnGenerateTask = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Ftp Task");
        setVisible(true);

        jLabel1.setText("Server :");

        jLabel2.setText("Remote Dir :");

        jLabel3.setText("User Id :");

        jLabel4.setText("Password :");

        btnGenerateTask.setText("Generate Ftp Task");
        btnGenerateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTaskActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("!");

        jLabel7.setText("To do :");

        jLabel5.setText("Node Path :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGenerateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtRemoteDir, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRemoteDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGenerateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTaskActionPerformed
// TODO add your handling code here:
    if (islem.equals("add")) {
        AddEvent();
    } else {
        EditEvent();
    }
}//GEN-LAST:event_btnGenerateTaskActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtRemoteDir;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
