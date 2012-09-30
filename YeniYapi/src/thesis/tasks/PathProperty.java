/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PathProperty.java
 *
 * Created on May 22, 2012, 4:04:59 PM
 */
package thesis.tasks;

import javax.swing.tree.TreePath;
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
 * @author BSTNC
 */
public class PathProperty extends javax.swing.JInternalFrame {

    /** Creates new form PathProperty */
    TreePath yolum;
    String islem;
    public PathProperty(TreePath yolum, String islem) {
        initComponents();
        
        initComponents();
        this.yolum = yolum;
        this.islem = islem;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtProName = new javax.swing.JTextField();
        txtLibPath = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Path Property for Manifest");
        setVisible(true);

        jLabel5.setText("Node Path :");

        jLabel7.setText("To do :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("!");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("!");

        jLabel1.setText("Name :");

        jLabel2.setText("Library Path :");

        jButton1.setText("Generate Property");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLibPath, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLibPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    AddEvent();
}//GEN-LAST:event_jButton1ActionPerformed

     public void AddEvent() {
         Element yenibebe = new Element("property");
         yenibebe.setAttribute("name",txtProName.getText());
         
         String jarfiles="";
         File folder = new File(txtLibPath.getText());
         File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                //jarfiles = listOfFiles[i].getName();
                if (listOfFiles[i].getName().endsWith(".jar") || listOfFiles[i].getName().endsWith(".JAR")) {
                    System.out.println(jarfiles);
                    jarfiles=jarfiles+" "+"lib/"+listOfFiles[i].getName();
                }
            }
        }
         yenibebe.setAttribute("value",jarfiles);

        try {

            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(thesis.FormAna.XmlURL);
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            // Target BUL
            Element target = null;
            List targetList = rootNode.getChildren("target");
            if (yolum.getPathCount() < 2) {
                rootNode.addContent("   "); // 3 space 
                rootNode.addContent(yenibebe);
                rootNode.addContent("\n");
            } else {
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
                target.addContent("   "); // 3 space 
                target.addContent(yenibebe);
                target.addContent("\n");
            }

            System.out.println("yenibebeb adı " + yenibebe.getName());

            document.setRootElement(rootNode);
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document, new FileWriter(thesis.FormAna.XmlURL));
            JOptionPane.showMessageDialog(this, "Ekleme Başarıyla Yapıldı !");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtLibPath;
    private javax.swing.JTextField txtProName;
    // End of variables declaration//GEN-END:variables
}
