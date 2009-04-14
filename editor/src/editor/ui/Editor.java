package editor.ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import editor.AbstractVersionedObject;

public class Editor extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JEditorPane e1 = new JEditorPane();
	private final JEditorPane e2 = new JEditorPane();
	private JPanel dimPanel = null;
	private DocumentAdapter da;
	
	public Editor(DocumentAdapter da)
	{
		this.da = da;
	}
	
	private class RBLChecked implements ActionListener
	{
		DocumentAdapter da;
		String tag;
		Set<String> dim;
		
		public RBLChecked(DocumentAdapter da, String tag, Set<String> dim)
		{
			this.da = da;
			this.tag = tag;
			this.dim = dim;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			da.unselect(dim);
			da.select(tag);
		}
	}
	
	public void setDimesionList(Collection<Set<String>> dimensions) {
		dimPanel = new JPanel();
		BoxLayout layout = new BoxLayout(dimPanel, BoxLayout.Y_AXIS);
		dimPanel.setLayout(layout);
		
		for (Set<String> d : dimensions)
		{
			JPanel p = new JPanel();
			p.add(new JLabel("Dimension"));
			ButtonGroup g = new ButtonGroup();
			for (String t : d)
			{
				JRadioButton r = new JRadioButton(t);
				TreeSet<String> d2 = new TreeSet<String>();
				d2.addAll(d);
				d2.remove(t);
				r.addActionListener(new RBLChecked(da, t, d2));
				g.add(r);
				p.add(r);
			}
			dimPanel.add(p);
		}
	}

	public void setBottomText(String structuredText) {
		e2.setText(structuredText);
	}

	public void setTopDoc(AbstractVersionedObject doc) {
		da.setDocument(doc, e1);
		da.setText();
		e1.addMouseListener(da);
	}

	public void showit()
	{
		BoxLayout layout  = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
		getContentPane().setLayout(layout);
		
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(2,1));
		
		e1.setFont(new Font("Monospaced", 12, 12));
		e2.setFont(new Font("Monospaced", 12, 12));
		
		JScrollPane sp1 = new JScrollPane(e1);
		JScrollPane sp2 = new JScrollPane(e2);

		inner.add(sp1);
		inner.add(sp2);
		
		add(dimPanel);
		add(inner);
		
		setSize(new java.awt.Dimension(700,550));
		setVisible(true);
	}
}
