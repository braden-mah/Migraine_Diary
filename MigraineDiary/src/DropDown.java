import processing.core.PApplet;
import processing.core.PConstants;

public class DropDown {
	private PApplet parent;
	private int x1, y1, length, height, height2, slots, scroll, size;
	private String[] list;
	private String chosen;
	private boolean drop=false;
	public DropDown(PApplet p, int x1, int y1, int length, int height, int height2, int slots, String[] list, int size) {
		this.x1=x1;
		this.y1=y1;
		this.length=length;
		this.height=height;
		this.height2=height2;
		this.list=list;
		this.slots=slots;
		this.size=size;
		parent=p;
		try {
			chosen=list[0];
		}
		catch(ArrayIndexOutOfBoundsException e){
			chosen="";
		}
	}
	public void display() {
		parent.stroke(0);
		parent.fill(255);
		parent.rect(x1,y1,length,height);
		parent.textSize(size);
		parent.fill(0);
		parent.text(chosen,(x1+x1+length)/2,(y1+y1+height)/2+5);
		if (drop==true) {
			if (list.length>=slots) {
				for (int i=0; i<slots; i++) {
					parent.fill(255);
					parent.rect(x1,y1+height+(height2*i),length,height2);
					parent.textAlign(PConstants.CENTER);
					parent.textSize(14);
					parent.fill(0);
					parent.text(list[i+scroll],(x1+(length+x1))/2,y1+(height2/2)+5+height+(height2*i));
				}
			}
			else {
				for (int i=0; i<list.length; i++) {
					parent.fill(255);
					parent.rect(x1,y1+height+(height2*i),length,height2);
					parent.textAlign(PConstants.CENTER);
					parent.textSize(14);
					parent.fill(0);
					parent.text(list[i],(x1+(length+x1))/2,y1+(height2/2)+5+height+(height2*i));
				}
			}
		}
	}
	public boolean checkClick() {
		if (parent.mouseX>=x1 && parent.mouseX<=x1+length && parent.mouseY>=y1 && parent.mouseY<=y1+height) {
			return true;
		}
		else {
			return false;
		}
	}
	public void update() {
		if (parent.mouseX>=x1 && parent.mouseX<=x1+length) {
			if (list.length>=slots) {
				for (int i=1; i<=slots; i++) {
					if (parent.mouseY>=y1+height+(height2*(i-1)) && parent.mouseY<=y1+height+height2+(height2*(i-1))) {
						chosen=(list[i-1+scroll]);
					}
				}
			}
			else if (list.length<slots) {
				for (int i=1; i<=list.length; i++) {
					if (parent.mouseY>=y1+height+(height2*(i-1)) && parent.mouseY<=y1+height+height2+(height2*(i-1))) {
						chosen=(list[i-1+scroll]);
					}
				}
			}
		}
	}
	public boolean checkScroll() {
		if (drop==true && parent.mouseX>=x1 && parent.mouseX<=x1+length && parent.mouseY>=y1 && parent.mouseY<=y1+height+(height2*slots)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean getDrop() {
		return drop;
	}
	public void setDrop() {
		if (drop==false) {
			drop=true;
		}
		else if (drop==true) {
			drop=false;
		}
	}
	public void scroll(float i) {
		scroll+=i;
		if (scroll<0) {
			scroll=0;
		}
		if (scroll>list.length-slots) {
			scroll-=1;
		}
	}
	public void mouseCmd() {
		if (checkClick()==true) {
			setDrop();
		}
		if (getDrop()==true) {
			update();
		}
	}
	public void wheelCmd(float e) {
		if (checkScroll()==true) {
			if(e==1.0f||e==-1.0f) {
				scroll(e);
			}
		}
	}
	public String getChosen() {
		return chosen;
	}
}
