/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thesis.jtree;

import java.util.List;
import org.jdom.Element;
import org.jdom.Text;

/**
 *
 * @author BSTNC
 */
public class XmlTreeElement {
    Element element;
	public XmlTreeElement(Element element) {
		this.element = element;
	}
	public Element getElement() {
		return element;
	}
	public String toString() {
		return element.getName();
	}
        public String getText() {
		List list = element.getChildren();
		for (int i=0 ; i<list.size() ; i++) {
			if (list.get(i) instanceof Text) {
				return ((Text)list.get(i)).getValue();
			}
		}
		return "";
	}
    
}
