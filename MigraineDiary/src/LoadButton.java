import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PConstants;

public class LoadButton extends Button{
	private int bx1,bx2,by1,by2;
	private boolean displayText;
	private Scanner s;
	private float textHeight=0;
	private String text2="";
	private int scroll=0;
	private ArrayList<String> text= new ArrayList<String>();
	public LoadButton(PApplet p, int x1, int y1, int x2, int y2, int r, int g, int b, int hr, int hg, int hb, String text, int size, int bx1, int by1, int bx2, int by2) {
		super(p, x1,  y1, x2, y2, r, g, b, hr, hg, hb, text, size);
		this.bx1=bx1;
		this.bx2=bx2;
		this.by1=by1;
		this.by2=by2;
	}
	public void load(String entry) {
		displayText=true;
		try {
			s = new Scanner (new File(entry+".txt"));
			while (s.hasNext()) {
				text.add(s.nextLine());
			}
			displayText=true;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
	
		}
	}
	public void displayText() {
		if (displayText==true) {
			parent.stroke(0);
			parent.noFill();
			parent.rect(bx1,by1,bx2-bx1,by2-by1);
			parent.textAlign(PConstants.LEFT);
			System.out.println(scroll);
			for (int i=scroll; i<text.size(); i++) {
				if (textHeight<by2-by1) {
					text2+=text.get(i)+"\n";
					textHeight+=30;
				}
			}
			textHeight=0;
			parent.text(text2,bx1,by1,bx2-bx1,by2-by1);
			text2="";
			parent.textAlign(PConstants.CENTER);
		}
	}
	public boolean checkScroll() {
		if (parent.mouseX>=bx1 && parent.mouseX<=bx2 && parent.mouseY>=by1 && parent.mouseY<=by2 && displayText==true) {
			return true;
		}
		else {
			return false;
		}
	}
	public void wheelCmd(float e) {
		if (checkScroll()==true) {
			if(e==1.0f||e==-1.0f) {
				scroll(e);
			}
		}
	}
	public void scroll(float i) {
		scroll+=i;
		if (scroll<0) {
			scroll=0;
		}
		if (scroll>text.size()) {
			scroll-=1;
		}
	}
	public void setDisplayText(boolean bool) {
		displayText=bool;
	}

}
