import processing.core.PApplet;
import processing.core.PConstants;

public class TextEditor {
	protected PApplet parent;
	protected int x1, y1, x2, y2, counter=0, tSize;
	protected String text="";
	protected String blinker="";
	public TextEditor(PApplet p, int x1, int y1, int x2, int y2, int tSize) {
		parent=p;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.tSize=tSize;
	}
	public void display() {
		checkBlinker();
		parent.stroke(0);
		parent.noFill();
		parent.rect(x1,y1,x2-x1,y2-y1);
		parent.textSize(tSize);
		parent.textAlign(PConstants.LEFT);
		parent.text(text+blinker, x1, y1, x2-x1, y2-y1);
	}
	public void checkBlinker() {
		counter+=1;
		if (counter<=30) {
			blinker="";
		}
		else {
			blinker="_";
		}
		if (counter==60) {
			counter=0;
		}
	}
	public void execute(char c) {
		if (c==PConstants.BACKSPACE||c==PConstants.DELETE) {
			text=text.substring(0 ,PApplet.max(0, text.length()-1));
		}
		else if (c==PConstants.ENTER) {
			text+="\n";
		}
		else if (c>=' ') {
			text+=c;
		}
	}
	public String getText() {
		return text;
	}
}
