import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import java.awt.Component;

public class ContactListRenderer extends DefaultListCellRenderer {

	public ContactListRenderer() {

	}

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);

		ContactList c = (ContactList) value;
		setText(c.getListName());
		return this;

	}

}
