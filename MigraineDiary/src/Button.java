import processing.core.PApplet;
import processing.core.PConstants;

public class Button extends PApplet{
	protected PApplet parent;
	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;
	protected int r;
	protected int g;
	protected int b;
	protected int hr;
	protected int hg;
	protected int hb;
	protected int size;
	protected boolean hover=false;
	protected String text;
	public Button(PApplet p, int x1, int y1, int x2, int y2, int r, int g, int b, int hr, int hg, int hb, String text, int size) {
		parent=p;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.r=r;
		this.g=g;
		this.b=b;
		this.hr=hr;
		this.hg=hg;
		this.hb=hb;
		this.text=text;
		this.size=size;
	}
	public void display() {
		checkHover();
		if (hover==false) {
			parent.fill(r,g,b);
		}
		else {
			parent.fill(hr, hg, hb);
		}
		parent.stroke(0);
		parent.rect(x1, y1, x2-x1, y2-y1);
		parent.fill(0);
		parent.textAlign(PConstants.CENTER);
		parent.textSize(size);
		parent.text(text, (x1+x2)/2, ((y1+y2)/2)+10);
	}
	public void checkHover() {
		if (parent.mouseX>=x1 && parent.mouseX<=x2 && parent.mouseY>=y1 && parent.mouseY<=y2) {
			hover=true;
		}
		else {
			hover=false;
		}
	}
	public boolean getHover() {
		return hover;
	}
	public void setHover(boolean bool) {
		hover=false;
	}
}
