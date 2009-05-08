package editor;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import editor.util.AlternativeRemover;
import editor.util.ChoiceFinder;
import editor.util.ChoiceRemover;
import editor.util.Substituter;
import editor.util.TagSelector;
import editor.util.TextAdder;
import editor.util.TagSelector.Line;

public class VersionedDocument 
{
	private AbstractVersionedObject doc;
	private TreeSet<String> selectedTags = new TreeSet<String>();
	private Collection<Line> selectedLines;

	public VersionedDocument()
	{
		this.doc = new VersionedObject("");
		setSelectedLines();
	}

	public void setDocument(AbstractVersionedObject doc)
	{
		this.doc = doc;
	}

	public Choice getChoice(int caretPosition) 
	{
		ChoiceFinder cf = new ChoiceFinder();
		doc.visit(cf);
		return cf.getChoice();
	}

	public Collection<Set<String>> getDimensions() 
	{
		Dimension d = new Dimension(doc);
		return d.getDimensions();
	}

	public Collection<Line> getLines() 
	{
		return selectedLines;
	}

	public void addText(int pos, String text) 
	{
		Line found = null;
		int p = pos;
		for (Line line : selectedLines)
		{
			if (pos >= line.getStartPos() && pos <= line.getEndPos())
			{
				found = line;
				break;
			}
			else
			{
				p -= line.getText().length();
			}
		}

		if (found != null && found.getVersionedObject() instanceof VersionedObject)
		{
			VersionedObject v = (VersionedObject)found.getVersionedObject();
			String str = v.getValue().substring(0, p) + text + v.getValue().substring(p);
			v.setValue(str);
		}	
		setSelectedLines();
	}

	public void removeText(int pos, int length) 
	{
		Line found = null;
		int p = pos;
		for (Line line : selectedLines)
		{
			if (pos >= line.getStartPos() && pos <= line.getEndPos())
			{
				found = line;
				break;
			}
			else
			{
				p -= line.getText().length();
			}
		}

		if (found != null && found.getVersionedObject() instanceof VersionedObject)
		{
			VersionedObject v = (VersionedObject)found.getVersionedObject();
			String str = v.getValue().substring(0, p) + v.getValue().substring(p+length);
			v.setValue(str);
		}	
		setSelectedLines();
	}

	public void createChoice(int pos, String tag) 
	{
		AbstractVersionedObject v = findVersionedObjectFromPos(pos);
		AbstractVersionedObject parent = v.getParentObject(); 
		
		Choice c = new Choice();
		c.addAlternative(new Label(tag), v);
		
		if (parent == null)
		{
			doc = c;
		}
		else
		{
			Substituter s = new Substituter(v, c);
			doc = doc.transform(s);
		}
		setSelectedLines();
	}

	public void removeChoice(int pos)
	{
		ChoiceRemover cr = new ChoiceRemover(pos);	
		doc = doc.transform(cr);
	}

	public boolean addAlternative(int pos, String tag, String text)
	{
		AbstractVersionedObject v = findVersionedObjectFromPos(pos);
		
		if (v.getParentObject() instanceof Choice)
		{
			Choice c = (Choice)v.getParentObject();
			c.addAlternative(new Label(tag), new VersionedObject(text));
			setSelectedLines();
			return true;
		}
		
		return false;
	}

	public void removeAlternative(int pos)
	{
		AlternativeRemover ar = new AlternativeRemover(pos);		
		doc = doc.transform(ar);
	}

	public void select(String tag)
	{
		selectedTags.add(tag);
		setSelectedLines();
	}
	
	public void unselect(Set<String> dim)
	{
		selectedTags.removeAll(dim);
		setSelectedLines();
	}
	
	private void setSelectedLines() 
	{
		TagSelector ts = new TagSelector(selectedTags);
		doc.visit(ts);
		selectedLines = ts.getLines();
	}

	public Collection<String> getSelectedTags() 
	{
		return selectedTags;
	}
	
	private AbstractVersionedObject findVersionedObjectFromPos(int pos)
	{
		for (Line line : selectedLines)
		{
			if (pos >= line.getStartPos() && pos <= line.getEndPos())
			{
				return line.getVersionedObject();
			}
		}

		return null;
	}
}
