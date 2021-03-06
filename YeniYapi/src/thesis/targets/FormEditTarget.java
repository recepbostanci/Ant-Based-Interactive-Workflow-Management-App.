/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormEditTarget.java
 *
 * Created on Apr 26, 2012, 3:07:35 PM
 */
package thesis.targets;


import thesis.fileforms.Fonksiyon;
import thesis.jtree.*;
import thesis.tasks.*;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import org.jdom.output.XMLOutputter;
import thesis.tasks.PathProperty;


/**
 *
 * @author BSTNC
 */
public class FormEditTarget extends javax.swing.JInternalFrame {

    /** Creates new form FormEditTarget */
    public FormEditTarget() {

        initComponents();
        if (thesis.FormAna.XmlURL != null) {
            lblUyari.setText(thesis.FormAna.XmlURL + " file loaded !");
        } else {
            lblUyari.setText("Please load a xml file !");
            lblUyari.setForeground(Color.red);
        }
    }
    XmlTreeElement secilenElement;
    TreePath Yolum ;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUyari = new javax.swing.JLabel();
        btnViewTargetsTasks = new javax.swing.JButton();
        btnAddTask = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel4 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        JlstTasks = new javax.swing.JList();
        btnEditTask = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtXmlContent = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btnCreateFreeTask = new javax.swing.JButton();

        setClosable(true);
        setTitle("Edit Target");
        setPreferredSize(new java.awt.Dimension(1300, 600));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUyari.setFont(new java.awt.Font("Tahoma", 0, 13));
        lblUyari.setText("__");
        getContentPane().add(lblUyari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 430, -1));

        btnViewTargetsTasks.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnViewTargetsTasks.setText("Refresh");
        btnViewTargetsTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTargetsTasksActionPerformed(evt);
            }
        });
        getContentPane().add(btnViewTargetsTasks, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 190, 31));

        btnAddTask.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnAddTask.setText("ADD NEW TASK");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 190, 30));

        jTree1.setBorder(javax.swing.BorderFactory.createTitledBorder("Target Tree"));
        jTree1.setFont(new java.awt.Font("Tahoma", 0, 13));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane3.setViewportView(jTree1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 442, 210));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13));
        jLabel4.setText("__");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 430, -1));

        jDesktopPane1.setBorder(new javax.swing.border.MatteBorder(null));
        jDesktopPane1.setFont(new java.awt.Font("Tahoma", 0, 13));
        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 570, 610));

        JlstTasks.setBorder(javax.swing.BorderFactory.createTitledBorder("Select a Task to Add :"));
        JlstTasks.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        JlstTasks.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "jar", "javac", "fileset", "mkdir", "ftp", "delete", "manifestPathProperty", "exec", "sshexec", "scp" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(JlstTasks);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 190, 210));

        btnEditTask.setFont(new java.awt.Font("Tahoma", 0, 13));
        btnEditTask.setText("Edit Task");
        btnEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 200, 30));

        btnDeleteTask.setText("Delete Task");
        btnDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 210, 30));

        txtXmlContent.setColumns(20);
        txtXmlContent.setRows(5);
        jScrollPane2.setViewportView(txtXmlContent);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 650, 240));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 10, 610));

        jButton1.setText("MANUEL SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 640, 40));

        btnCreateFreeTask.setText("Create Free Task");
        btnCreateFreeTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFreeTaskActionPerformed(evt);
            }
        });
        getContentPane().add(btnCreateFreeTask, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 200, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
private void btnViewTargetsTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTargetsTasksActionPerformed
    try {
        AgactaGoster();
        xmlIcerikGoster();
    } catch (JDOMException ex) {
        
        Logger.getLogger(FormEditTarget.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_btnViewTargetsTasksActionPerformed
public void xmlIcerikGoster(){
        try {
            Fonksiyon sys = new Fonksiyon();
                        txtXmlContent.setText(sys.readFileContent(thesis.FormAna.XmlURL));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
}
private void btnEditTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTaskActionPerformed
// TODO add your handling code here:
    jDesktopPane1.removeAll();
    jDesktopPane1.updateUI();
    String control = secilenElement.getElement().getName().toString();
    ArayuzleriCagir(control, "edit");
}//GEN-LAST:event_btnEditTaskActionPerformed

private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
// TODO add your handling code here:
    if (JlstTasks.getSelectedIndex()>-1) {
        jDesktopPane1.removeAll();
        jDesktopPane1.updateUI();
        String control = JlstTasks.getSelectedValue().toString();
        ArayuzleriCagir(control, "add");
    }else JOptionPane.showMessageDialog(this, "Select a Type of Task ?");
    
    
}//GEN-LAST:event_btnAddTaskActionPerformed

private void btnDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTaskActionPerformed
// TODO add your handling code here:
        
            try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(thesis.FormAna.XmlURL);
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            // Target BUL
            Element target = null;
            List targetList = rootNode.getChildren("target");
            for (int i = 0; i < targetList.size(); i++) {
                if (((Element) targetList.get(i)).getAttributeValue("name").equals(((XmlTreeElement) Yolum.getPathComponent(1)).getElement().getAttributeValue("name"))) {
                    System.out.println("Target Bulundu en azından");
                    target = (Element) targetList.get(i);
                }
            }

            List l = null ;
            int silincekIndex = 0;
            for (int i = 2; i < Yolum.getPathCount(); i++) {
                System.out.println("FOR A GIRDIK RAHAT OL");
                l = target.getChildren();
                for (int j = 0; j < l.size(); j++) {
                    if (((Element) l.get(j)).getName().equals(((XmlTreeElement) Yolum.getPathComponent(i)).getElement().getName())) {
                        System.out.println("ESIT LAN");
                        target = (Element) l.get(j);
                        silincekIndex=j;
                        break;
                    }
                }
            }
            int sonuc = JOptionPane.showConfirmDialog(null, Yolum+" Task'ını Silmek İstiyor Musunuz ?", "Dikkat !", JOptionPane.YES_NO_CANCEL_OPTION);
                if (sonuc == 0) {
                    l.remove(silincekIndex);
                    JOptionPane.showMessageDialog(this, "Task Başarıyla Silindi !");
                }
            document.setRootElement(rootNode);
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document, new FileWriter(thesis.FormAna.XmlURL));
            AgactaGoster();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JDOMException ex) {
            ex.printStackTrace();
        }
}//GEN-LAST:event_btnDeleteTaskActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
            try {
            // TODO add your handling code here:
               
                String fileURL = thesis.FormAna.XmlURL;
                writeFile(fileURL,txtXmlContent.getText());
                JOptionPane.showMessageDialog(this, "Manuel Kayıt Başarıyla Gerçekleşti !");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
}//GEN-LAST:event_jButton1ActionPerformed

private void btnCreateFreeTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFreeTaskActionPerformed
// TODO add your handling code here:
    FreeTask mt = new FreeTask(Yolum);
    jDesktopPane1.add(mt);
}//GEN-LAST:event_btnCreateFreeTaskActionPerformed
public static void writeFile(String filename, String text) throws IOException {
    FileOutputStream fos = null;
    try {
        fos = new FileOutputStream(filename);
        fos.write(text.getBytes("ISO-8859-1"));
    } catch (IOException e) {
        close(fos);
        throw e;
    }
}
public static void close(Closeable closeable) {
    try {
        closeable.close();
    } catch(IOException ignored) {
    }
}
//    public org.w3c.dom.Document convertToDOM(org.jdom.Document jdomDoc)
//            throws JDOMException {
//
//        DOMOutputter outputter = new DOMOutputter();
//        return outputter.output(jdomDoc);
//    }

    public void AgactaGoster() throws JDOMException {
        try {
            XmlTreeModel2 model = new XmlTreeModel2();
            Document document = null;
            try {
                SAXBuilder builder = new SAXBuilder();
                File xmlFile = new File(thesis.FormAna.XmlURL);
                document = (Document) builder.build(xmlFile);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

            //model.setDocument(convertToDOM(document));
            model.setMev(GETMevzuBahisTarget());
            model.setDocument(document);
            jTree1.setModel(model);
            jTree1.setShowsRootHandles(true);
            jTree1.setEditable(false);
            jTree1.addTreeSelectionListener(new TreeSelectionListener() {

                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    Object lpc = e.getPath().getLastPathComponent();
                    if (lpc instanceof XmlTreeElement) {
                        if (((XmlTreeElement) lpc).getElement().getName().equals("target")) {
                            jLabel4.setText("Target Name:"+((XmlTreeElement) lpc).getElement().getAttributeValue("name"));
                        }else jLabel4.setText("");
                        //jLabel4.setText(((XmlTreeElement) lpc).getElement().getName());
                        Yolum = jTree1.getSelectionPath();
                        secilenElement = (XmlTreeElement) lpc;
//                        jDesktopPane1.removeAll();
//                        jDesktopPane1.updateUI();
                        ////INTERNAL JFRAME'LER OLSTURULACAK
//                        Jar a = new Jar();
//                        jDesktopPane1.add(a);
//                        jDesktopPane1.setVisible(true);
                        if (secilenElement.getElement().getName().equals("target")||secilenElement.getElement().getName().equals("project")) {
                            btnDeleteTask.show(false);
                            btnEditTask.show(false);
                        }else{
                            btnDeleteTask.show(true);
                            btnEditTask.show(true);
                        }
                    }
                }
            });
            setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ID'ye ait bir target bulunamadı !");
            //txtTargetID.setText("");
            jTree1.removeAll();
            jTree1.updateUI();
        }

    }


//   
    private Element GETMevzuBahisTarget() {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(thesis.FormAna.XmlURL);



            org.jdom.Document document = (org.jdom.Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            return rootNode;
//            List targetList = rootNode.getChildren("target");
//
//            for (int i = 0; i < targetList.size(); i++) {
//                Element birtarget = (Element) targetList.get(i);
//                if (birtarget.getAttributeValue("ID").equals(txtTargetID.getText())) {
//                    System.out.println(birtarget.getAttributeValue("ID") + "" + birtarget.getName());
//                    return birtarget;
//                }
//
//            }

        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "ID'ye ait bir target bulunamadı !");
//            txtTargetID.setText("");
        }
        return null;
    }
    private void ArayuzleriCagir(String control, String islem){
        int icntrl=0;
        if (control.equals("jar")) {
            icntrl=1;
        }
        if (control.equals("javac")) {
            icntrl=2;
        }
        if (control.equals("mkdir")) {
            icntrl=3;
        }
        if (control.equals("fileset")) {
            icntrl=4;
        }
        if (control.equals("ftp")) {
            icntrl=5;
        }
        if (control.equals("manifestPathProperty")) {
            icntrl=6;
        }
        if (control.equals("exec")) {
            icntrl=7;
        }
        if (control.equals("sshexec")) {
            icntrl=8;
        }
        if (control.equals("scp")) {
            icntrl=9;
        }

     
    System.out.print(control);
    switch (icntrl) {
        case 1:
            System.out.println("Jar task Choosed");
            Jar a = new Jar(Yolum,islem);
            a.setVisible(true);
            jDesktopPane1.add(a);
            jDesktopPane1.setVisible(true);
            break;
        case 2:
            System.out.println("Javac task Choosed");
            Javac b = new Javac(Yolum, islem);
            b.setVisible(true);
            jDesktopPane1.add(b);
            jDesktopPane1.setVisible(true);
            break;
        case 3:
            System.out.println("Mkdir task Choosed");
            Mkdir c = new Mkdir();
            c.setVisible(true);
            jDesktopPane1.add(c);
            break;
       case 4:
            System.out.println("Fileset task Choosed");
            Fileset f = new Fileset(Yolum, islem);
            f.setVisible(true);
            jDesktopPane1.add(f);
            break;
       case 5:
            System.out.println("Fileset task Choosed");
            Ftp Ftp = new Ftp(Yolum, islem);
            Ftp.setVisible(true);
            jDesktopPane1.add(Ftp);
            break;
       case 6:
            System.out.println("manifest path property task Choosed");
            PathProperty  pp= new PathProperty(Yolum, islem);
            pp.setVisible(true);
            jDesktopPane1.add(pp);
            break;
       case 7:
            System.out.println("manifest path property task Choosed");
            Exec  ex= new Exec(Yolum);
            ex.setVisible(true);
            jDesktopPane1.add(ex);
            break;
       case 8:
            System.out.println("sshexec path property task Choosed");
            sshexec  ex1= new sshexec(Yolum,islem);
            ex1.setVisible(true);
            jDesktopPane1.add(ex1);
            break;
       case 9:
            System.out.println("scp path property task Choosed");
            scp  sc= new scp(Yolum,islem);
            sc.setVisible(true);
            jDesktopPane1.add(sc);
            break;
        default:
            throw new IllegalArgumentException();
    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList JlstTasks;
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnCreateFreeTask;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JButton btnEditTask;
    private javax.swing.JButton btnViewTargetsTasks;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblUyari;
    private javax.swing.JTextArea txtXmlContent;
    // End of variables declaration//GEN-END:variables
}
