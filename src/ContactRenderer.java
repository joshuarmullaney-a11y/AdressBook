import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import java.awt.Component;

public class ContactRenderer extends DefaultListCellRenderer {

	public ContactRenderer() {

	}

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);

		Contact c = (Contact) value;
		setText(c.getFirstName() + " " + c.getLastName());
		return this;

	}

}