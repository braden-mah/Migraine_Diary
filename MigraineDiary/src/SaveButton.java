import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

public class SaveButton extends Button {
	private FileWriter f;
	private PrintWriter p;
	public SaveButton(PApplet p, int x1, int y1, int x2, int y2, int r, int g, int b, int hr, int hg, int hb, String text, int size) {
		super(p, x1,  y1, x2, y2, r, g, b, hr, hg, hb, text, size);
	}
	public void save(ArrayList<Checkbox> c, ArrayList<TextEditor> t, ArrayList<String> d, String entry){
		try {
			f = new FileWriter(entry+".txt");
			f.write("Day:\n");
			f.write("\n");
			f.write(d.get(6)+" "+d.get(7)+" "+d.get(8)+"\n");
			f.write("\n");
			f.write("Time:\n");
			f.write("\n");
			f.write(d.get(0)+":"+d.get(1)+" "+d.get(2)+" - "+d.get(3)+":"+d.get(4)+" "+d.get(5)+"\n");
			f.write("\n");
			f.write("Severity:\n");
			f.write("\n");
			f.write(d.get(9)+"\n");
			f.write("\n");
			f.write("Symptoms:\n");
			f.write("\n");
			for (Checkbox b: c) {
				if (b.getQuestion()==4) {
					if (b.getFilled()=='x') {
						f.write(b.getName()+"\n");
					}
				}
			}
			f.write("\n");
			f.write("Extra Symptom Info:\n");
			f.write("\n");
			f.write(t.get(0).getText()+"\n");
			f.write("\n");
			f.write("Triggers:\n");
			f.write("\n");
			for (Checkbox b: c) {
				if (b.getQuestion()==6) {
					if (b.getFilled()=='x') {
						f.write(b.getName()+"\n");
					}
				}
			}
			f.write("\n");
			f.write("Extra Trigger Info:\n");
			f.write("\n");
			f.write(t.get(1).getText()+"\n");
			f.write("\n");
			f.write("Aura:\n");
			f.write("\n");
			for (Checkbox b: c) {
				if (b.getQuestion()==8) {
					if (b.getFilled()=='x') {
						f.write(b.getName()+"\n");
					}
				}
			}
			f.write("\n");
			f.write("Extra Aura Info:\n");
			f.write("\n");
			f.write(t.get(2).getText()+"\n");
			f.write("\n");
			f.write("Medications:\n");
			f.write("\n");
			f.write(t.get(3).getText()+"\n");
			f.write("\n");
			f.write("Additional Information:\n");
			f.write("\n");
			f.write(t.get(4).getText()+"\n");
			f.close();
			f=new FileWriter("names.txt",true);
			f.write(entry+"\n");
			f.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
