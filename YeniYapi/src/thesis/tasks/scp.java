/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * scp.java
 *
 * Created on Jun 23, 2012, 2:27:00 PM
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
import javax.swing.tree.TreePath;

/**
 *
 * @author BSTNC
 */
public class scp extends javax.swing.JInternalFrame {

    /** Creates new form scp */
    TreePath yolum;
    String islem;
    public scp(TreePath yolum,String islem) {
        initComponents();
        this.yolum = yolum;
        this.islem = islem;
        jLabel8.setText(yolum.toString());
        jLabel9.setText(islem);
        if (islem.equals("edit")) {
            Onyukleme();
        }
    }

     private void Onyukleme(){
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
            String D = target.getAttributeValue("file");
            String B = target.getAttributeValue("todir");

            txtFile.setText(D);
            txtToLocalDir.setText(B);

        } catch (JDOMException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
     private void AddEvent() {
        try {
            Element yeniElement = new Element("sshexec");

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
            yeniElement.setAttribute("file", txtFile.getText());
            if (!txtToLocalDir.getText().equals("")) {
                yeniElement.setAttribute("todir", txtToLocalDir.getText());
            }
           
            yeniElement.setAttribute("trust", "true");
            yeniElement.setAttribute("verbose", "true");
            yeniElement.setAttribute("sftp", "true");
            yeniElement.setAttribute("failonerror", "true");
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
           target.setAttribute("file", txtFile.getText());
            if (!txtToLocalDir.getText().equals("")) {
                target.setAttribute("todir", txtToLocalDir.getText());
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

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFile = new javax.swing.JTextField();
        txtToLocalDir = new javax.swing.JTextField();
        btnGenerateTask = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Scp Task - Remote to Local File Transfer");
        setVisible(true);

        jLabel6.setText("Node Path :");

        jLabel7.setText("To do :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("!");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("!");

        jLabel1.setText("Remote File :");

        jLabel5.setText("To My Local Directory :");

        btnGenerateTask.setText("Generate Task");
        btnGenerateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTaskActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setText("ex : RemoteUsername:Password@192.168.1.3://ClientLog.txt");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setText("ex : /myWorkSpace/");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnGenerateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtToLocalDir, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtToLocalDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(btnGenerateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtFile;
    private javax.swing.JTextField txtToLocalDir;
    // End of variables declaration//GEN-END:variables
}
