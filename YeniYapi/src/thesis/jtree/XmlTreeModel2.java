/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis.jtree;

import java.util.List;
import java.util.Vector;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.jdom.*;
import org.jdom.Element;

/**
 *
 * @author BSTNC
 */
public class XmlTreeModel2 implements TreeModel {

//    private Document document;
    private Element mev;

    public Element getMev() {
        return mev;
    }

    public void setMev(Element mev) {
        this.mev = mev;
    }
    Vector<TreeModelListener> listeners = new Vector<TreeModelListener>();
    
//    public Document getDocument() {
//        return document;
//    }

    public void setDocument(Document document) {
//        this.document = document;
        TreeModelEvent evt = new TreeModelEvent(this, new TreePath(getRoot()));
        
        for (TreeModelListener listener : listeners) {
            listener.treeStructureChanged(evt);
        }
    }
    
    @Override
    public Object getRoot() {
        //return  document.getRootElement();
        return new XmlTreeElement(getMev());
    }

    @Override
    public Object getChild(Object parent, int index) {
        		if (parent instanceof XmlTreeElement) {
			Vector<Element> elements = getChildElements(((XmlTreeElement)parent).getElement());
			return new XmlTreeElement(elements.get(index)) ;
		}
		else {
			return null;
		}
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof XmlTreeElement) {
			Vector<Element> elements = getChildElements( ((XmlTreeElement)parent).getElement());
			return elements.size();
		}
		return 0;
    }

    @Override
    public boolean isLeaf(Object Obj) {
        		if (Obj instanceof XmlTreeElement) {
			Element element = ((XmlTreeElement)Obj).getElement();
			Vector<Element> elements = getChildElements(element);
			return elements.size()==0;
		}
		else {
			return true;
		}
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof XmlTreeElement && child instanceof XmlTreeElement) {
			Element pElement = ((XmlTreeElement)parent).getElement();
			Element cElement = ((XmlTreeElement)child).getElement();
			if (cElement.getParentElement()!= pElement) {
				return -1;
			}
			Vector<Element> elements = getChildElements(pElement);
			return elements.indexOf(cElement);
		}
		return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        if (!listeners.contains(l)) {
			listeners.add(l);
		}
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }
    private Vector<Element> getChildElements(Element el) {
		Vector<Element> Velements = new Vector<Element>();
		List<Element> list = el.getChildren();
		for (int i=0 ; i<list.size(); i++) {
			if (list.get(i).getClass() == Element.class) {
				Velements.add(list.get(i));
			}
		}
		return Velements;
	}
}
