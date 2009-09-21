package editor.model;

import java.util.ArrayList;

public class Dim extends Obj
{
	String name;
	final ArrayList<String> tags;
	Obj obj;
	int selectedAltIdx = 0;
	final ArrayList<Choice> choices;
	
	public Dim()
	{
		this("???");
	}
	
	public Dim(String name)
	{
		this.name = name;
		this.choices = new ArrayList<Choice>();
		this.tags = new ArrayList<String>();
	}

	public void addChoice(Choice c)
	{
		choices.add(c);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public ArrayList<String> getTags()
	{
		return tags;
	}
	
	public int getSelectedAltIdx()
	{
		return selectedAltIdx;
	}
	
	public void getSelectedAltIdx(int idx)
	{
		selectedAltIdx = idx;
	}

	@Override
	public String debugGetText()
	{
		return "Dim<"+name+">[]";
	}

	@Override
	public int addAt(int pos, Obj obj)
	{
		return pos;
	}

	public void removeSelectedAlternatives()
	{
		for (Choice c : choices)
		{
			c.remove(selectedAltIdx);
		}
	}

	public int addAlternative()
	{
		String tag = "tag" + tags.size();
		tags.add(tag);
		selectedAltIdx = tags.size() - 1;
		
		for (Choice c : choices)
		{
			c.addAlternativeAtEnd(new Part(c, ' '));
		}
		
		return selectedAltIdx;
	}
	
	@Override public int size()
	{
		return obj.size();
	}

	public void select(String tag)
	{
		selectedAltIdx = tags.indexOf(tag);
	}
}
