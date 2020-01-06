import processing.core.PApplet;

public class Checkbox extends Button{
	private int offset;
	private boolean filled=false;
	private int question;
	public Checkbox(PApplet p, int x1, int y1, int x2, int y2, int r, int g, int b, int hr, int hg, int hb, String text,
			int size, int offset, int question) {
		super(p, x1, y1, x2, y2, r, g, b, hr, hg, hb, text, size);
		this.offset=offset;
		this.question=question;
	}
	public void display() {
		super.checkHover();
		parent.textAlign(LEFT);
		parent.stroke(0);
		if (filled==false){
			parent.fill(r,g,b);
		}
		else {
			parent.fill(hr,hg,hb);
		}
		parent.rect(x1,y1,x2-x1,y2-y1);
		parent.fill(0);
		parent.textSize(size);
		parent.text(text,x2+offset, ((y1+y2)/2)+10);
	}
	public void mouseCmd() {
		if (hover==true) {
			if (filled==false) {
				filled=true;
			}
			else {
				filled=false;
			}
		}
	}
	public int getQuestion() {
		return question;
	}
	public String getName() {
		return text;
	}
	public char getFilled() {
		if (filled==true) {
			return 'x';
		}
		else {
			return 'o';
		}
	}

}
