import processing.core.PApplet;
import processing.core.PConstants;

public class TextBar extends TextEditor{
	int counter=0;
	String text2="";
	public TextBar(PApplet p, int x1, int y1, int x2, int y2, int tSize) {
		super(p,x1,y1,x2,y2,tSize);
	}
	public void display() {
		super.checkBlinker();
		parent.stroke(0);
		parent.fill(255);
		parent.rect(x1,y1,x2-x1,y2-y1);
		parent.textSize(tSize);
		parent.textAlign(PConstants.LEFT);
		parent.fill(0);
		if (parent.textWidth(text2+"l")+parent.textWidth(blinker)>x2-x1) {
			counter+=1;
		}
		text2=(text.substring(counter,text.length()));
		parent.text(text2,x1,y2-10);
	}
	public void execute(char c) {
		if (c==PConstants.BACKSPACE||c==PConstants.DELETE) {
			text=text.substring(0 ,PApplet.max(0, text.length()-1));
			counter-=1;
			if (counter<0) {
				counter=0;
			}
		}
		else if (c>=' ') {
			text+=c;
		}
	}
}
