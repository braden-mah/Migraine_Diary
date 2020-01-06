import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.event.MouseEvent;

public class Main extends PApplet{
	DecimalFormat f = new DecimalFormat("00");
	boolean invalidEntry=false;
	Scanner s;
	String[] hours = new String[12];
	String[] minutes = new String[60];
	String[] daytimeList = {"am","pm"};
	String[] dayList = new String[31];
	String[] monthList = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	String[] yearList = new String[20];
	String[] rateList = new String[10];
	TextBar entry = new TextBar(this, 450, 300, 550, 330, 20);
	Button histBtn = new Button (this, 300, 400, 700, 475, 106, 144, 216, 124, 228, 255, "Migraine History", 30);
	Button recBtn = new Button (this, 300, 300, 700, 375, 106, 144, 216, 124, 228, 255, "Record a Migraine", 30);
	Button nextBtn = new Button (this, 900, 30, 975, 80, 255, 255, 255, 217, 217, 219, "Next", 20);
	Button backBtn = new Button (this, 25, 30, 100, 80, 255, 255, 255, 217, 217, 219, "Back", 20);
	Button homeBtn = new Button (this, 25, 30, 100, 80, 255, 255, 255, 217, 217, 219, "Home", 20);
	LoadButton loadBtn = new LoadButton(this, 65, 510, 140, 560, 255, 255, 255, 217, 217, 219, "Load", 20, 210, 30, 900, 475);
	SaveButton finishBtn = new SaveButton (this, 900, 30, 975, 80, 255, 255, 255, 217, 217, 219, "Finish", 20);
	ArrayList<Checkbox> checkboxes = new ArrayList<Checkbox>();
	ArrayList<String> dropDowns = new ArrayList<String>();
	ArrayList<TextEditor> textEditors = new ArrayList<TextEditor>();
	ArrayList<String> names = new ArrayList<String>();
	String[] names2;
	DropDown hour;
	DropDown hour2;
	DropDown minute;
	DropDown minute2;
	DropDown daytime;
	DropDown daytime2;
	DropDown day;
	DropDown month;
	DropDown year;
	DropDown rate;
	DropDown entries;
	TextEditor symptoms = new TextEditor(this, 200, 150, 775, 470, 20);
	TextEditor aura = new TextEditor(this, 200, 150, 775, 470, 20);
	TextEditor triggers = new TextEditor(this, 200, 150, 775, 470, 20);
	TextEditor medication = new TextEditor(this, 200, 150, 775, 470, 20);
	TextEditor extra = new TextEditor(this, 200, 150, 775, 470, 20);
	PImage pier;
	PImage sea;
	int state=1;
	int question=1;
	int counter=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	public void settings() {
		size(1000,700);
	}
	public void setup() {
		smooth();
		background(255);
		pier = loadImage("pier.jpg");
		sea = loadImage("sea.jpg");
		checkboxes.add(new Checkbox(this, 100, 250 ,130, 280, 255, 255, 255, 95, 175, 111, "Vomit", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 100, 300, 130, 330, 255, 255, 255, 95, 175, 111, "Headache", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 100, 350, 130, 380, 255, 255, 255, 95, 175, 111, "Nausea", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 100, 400, 130, 430, 255, 255, 255, 95, 175, 111, "Light Sensitivity", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 100, 450, 130, 480, 255, 255, 255, 95, 175, 111, "Noise Sensitivity", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 400, 250, 430, 280, 255, 255, 255, 95, 175, 111, "Giddiness", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 400, 300, 430, 330, 255, 255, 255, 95, 175, 111, "Confusion", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 400, 350, 430, 380, 255, 255, 255, 95, 175, 111, "Mood Changes", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 400, 400, 430, 430, 255, 255, 255, 95, 175, 111, "Diarrhea", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 400, 450, 430, 480, 255, 255, 255, 95, 175, 111, "Fatigue", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 700, 250, 730, 280, 255, 255, 255, 95, 175, 111, "Anxiety", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 700, 300, 730, 330, 255, 255, 255, 95, 175, 111, "Blurry Vision", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 700, 350, 730, 380, 255, 255, 255, 95, 175, 111, "Fever", 20, 15, 4));
		checkboxes.add(new Checkbox(this, 200, 250, 230, 280, 255, 255, 255, 95, 175, 111, "Stress", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 200, 300, 230, 330, 255, 255, 255, 95, 175, 111, "Anxiety", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 200, 350, 230, 380, 255, 255, 255, 95, 175, 111, "Abnormal Sleep Pattern", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 200, 400, 230, 430, 255, 255, 255, 95, 175, 111, "Menstruation", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 200, 450, 230, 480, 255, 255, 255, 95, 175, 111, "Bad Weather", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 700, 250, 730, 280, 255, 255, 255, 95, 175, 111, "Caffeine", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 700, 300, 730, 330, 255, 255, 255, 95, 175, 111, "Alcohol", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 700, 350, 730, 380, 255, 255, 255, 95, 175, 111, "Skipped Meal", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 700, 400, 730, 430, 255, 255, 255, 95, 175, 111, "Dehydration", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 700, 450, 730, 480, 255, 255, 255, 95, 175, 111, "Allergic Reaction", 20, 15, 6));
		checkboxes.add(new Checkbox(this, 700, 250, 730, 280, 255, 255, 255, 95, 175, 111, "Weakness", 20, 15, 8));
		checkboxes.add(new Checkbox(this, 700, 300, 730, 330, 255, 255, 255, 95, 175, 111, "Visual Disturbance", 20, 15, 8));
		checkboxes.add(new Checkbox(this, 200, 250 , 230, 280, 255, 255, 255, 95, 175, 111, "Head/Neck Tingle", 20, 15, 8));
		checkboxes.add(new Checkbox(this, 200, 300, 230, 330, 255, 255, 255, 95, 175, 111, "Tingle near eye", 20, 15, 8));
		checkboxes.add(new Checkbox(this, 200, 350, 230, 380, 255, 255, 255, 95, 175, 111, "Mood change", 20, 15, 8));
		checkboxes.add(new Checkbox(this, 200, 400, 230, 430, 255, 255, 255, 95, 175, 111, "Hunger", 20, 15, 8));
		checkboxes.add(new Checkbox(this, 200, 450, 230, 480, 255, 255, 255, 95, 175, 111, "Irritability", 20, 15, 8));
		for (int i=0; i<hours.length; i++) {
			hours[i]=Integer.toString(i+1);
		}
		for (int i=0; i<minutes.length; i++) {
			minutes[i]=f.format(i);
		}
		for (int i=1; i<=dayList.length; i++) {
			dayList[i-1]=f.format(i);
		}
		for (int i=0; i<yearList.length; i++) {
			yearList[i]=Integer.toString(i+2017);
		}
		for (int i=0; i<rateList.length; i++) {
			rateList[i]=Integer.toString(i+1);
		}
		hour= new DropDown (this, 175, 300, 100, 50, 30, 6, hours, 14);
		minute = new DropDown(this, 300, 300, 100, 50, 30, 10, minutes, 14);
		daytime = new DropDown(this, 425, 300, 50, 50, 30, 2, daytimeList, 14);
		hour2= new DropDown (this, 525, 300, 100, 50, 30, 6, hours, 14);
		minute2 = new DropDown(this, 650, 300, 100, 50, 30, 10, minutes, 14);
		daytime2 = new DropDown(this, 775, 300, 50, 50, 30, 2, daytimeList, 14);
		day = new DropDown(this, 467, 300, 75, 50, 30, 10, dayList, 14);
		month = new DropDown(this, 292, 300, 150, 50, 30, 6, monthList, 14);
		year = new DropDown (this, 567, 300, 100, 50, 30, 6, yearList, 14);
		rate = new DropDown (this, 467, 300, 75, 50, 30, 4, rateList, 14);
		
	}
	public void draw() {
		//System.out.println("MouseX: "+mouseX+" Mouse Y: "+mouseY);
		if (state==1) {
			image(pier,-78,0);
			textAlign(PConstants.CENTER);
			textSize(40);
			fill(0);
			text("Migraine Diary",500,200);
			histBtn.display();
			recBtn.display();
		}
		else if (state==2) {
			image(pier,-78,0);
			textSize(40);
			textAlign(PConstants.CENTER);
			fill(0);
			if (question!=12) {
				nextBtn.display();
			}
			else {
				finishBtn.display();
			}
			backBtn.display();
			if (question==1) {
				textSize(40);
				text("When was your migraine?",500,200);
				textSize(20);
				text("-",500,335);
				text(":",287.5f,335);
				text(":",637.5f,335);
				hour.display();
				minute.display();
				daytime.display();
				hour2.display();
				minute2.display();
				daytime2.display();
			}
			else if (question==2) {
				textSize(40);
				text("What day was your migraine?", 500, 200);
				day.display();
				month.display();
				year.display();
			}
			else if (question==3) {
				textSize(30);
				text("With 1 being mild and 10 being unbearable,\nhow severe was your migraine?", 500, 200);
				rate.display();
			}
			else if (question==4) {
				textSize(30);
				text("Check off the symptoms which you experienced.", 500, 200);
				for (Checkbox c: checkboxes) {
					if (c.getQuestion()==4) {
						c.display();
					}
				}
			}
			else if (question==5) {
				textSize(30);
				text("Please write down anything else important (symptoms):", 500, 125);
				symptoms.display();
			}
			else if (question==6) {
				textSize(30);
				text("Check off any triggers of your migraine", 500, 200);
				for (Checkbox c: checkboxes) {
					if (c.getQuestion()==6) {
						c.display();
					}
				}
			}
			else if (question==7) {
				textSize(30);
				text("Please write down anything else important (triggers):", 500, 125);
				triggers.display();
			}
			else if (question==8) {
				textSize(30);
				text("Did you feel it coming?", 500, 200);
				for (Checkbox c: checkboxes) {
					if (c.getQuestion()==8) {
						c.display();
					}
				}
			}
			else if (question==9) {
				textSize(30);
				text("Please write down anything else important (aura):", 500, 125);
				aura.display();
			}
			else if (question==10) {
				textSize(30);
				text("What did you do to relieve your migraine?", 500, 125);
				medication.display();
			}
			else if (question==11) {
				textSize(30);
				text("Please write down anything else:", 500, 125);
				extra.display();
			}
			else if (question==12) {
				textSize(30);
				text("You have finished logging your migraine. Please enter the name of this entry and click 'finish' to save.", 200, 125, 600, 225);
				entry.display();
				if (invalidEntry==true) {
					textSize(20);
					textAlign(PConstants.CENTER);
					text("You have already created a journal entry with this name!",500,400);
				}
			}
		}
		else if (state==3) {
			image(pier,-78,0);
			if (counter==0) {
				try {
					s=new Scanner(new File("names.txt"));
					while(s.hasNext()) {
						names.add(s.nextLine());
					}
					s.close();
					
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				names2=new String[names.size()];
				for (int i=0; i<names.size(); i++) {
					names2[i]=names.get(i);
				}
				entries = new DropDown(this,55,220,100,50,30,7,names2,14);
			}
			counter++;
			entries.display();
			loadBtn.display();
			loadBtn.displayText();
			homeBtn.display();
			textSize(20);
			text("Entry:",105,200);
			//System.out.println(names2.length);
		}
	}
	public void mousePressed() {
		if (state==1) {
			if (recBtn.getHover()==true) {
				state=2;
				question=1;
			}
			else if (histBtn.getHover()==true) {
				state=3;
			}
		}
		else if (state==2) {
			if (finishBtn.getHover()==true && question==12) {
				textEditors.add(symptoms);
				textEditors.add(triggers);
				textEditors.add(aura);
				textEditors.add(medication);
				textEditors.add(extra);
				dropDowns.add(hour.getChosen());
				dropDowns.add(minute.getChosen());
				dropDowns.add(daytime.getChosen());
				dropDowns.add(hour2.getChosen());
				dropDowns.add(minute2.getChosen());
				dropDowns.add(daytime2.getChosen());
				dropDowns.add(day.getChosen());
				dropDowns.add(month.getChosen());
				dropDowns.add(year.getChosen());
				dropDowns.add(rate.getChosen());
				File file = new File (entry.getText()+".txt");
				try {
					if (file.createNewFile()) {
						finishBtn.save(checkboxes, textEditors, dropDowns, entry.getText());
						state=1;
						nextBtn.setHover(false);
						invalidEntry=false;
					}
					else {
						invalidEntry=true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (nextBtn.getHover()==true && question!=12) {
				question+=1;
			}
			else if (backBtn.getHover()==true) {
				question-=1;
				if (question==0) {
					state=1;
					backBtn.setHover(false);
				}
			}
			if (question==1) {
				hour.mouseCmd();
				minute.mouseCmd();
				daytime.mouseCmd();
				hour2.mouseCmd();
				minute2.mouseCmd();
				daytime2.mouseCmd();
			}
			else if (question==2) {
				day.mouseCmd();
				month.mouseCmd();
				year.mouseCmd();
			}
			else if (question==3) {
				rate.mouseCmd();
			}
			else if (question==4) {
				for (Checkbox c: checkboxes) {
					if (c.getQuestion()==4) {
						c.mouseCmd();
					}
				}
			}
			else if (question==6) {
				for (Checkbox c: checkboxes) {
					if (c.getQuestion()==6) {
						c.mouseCmd();
					}
				}
			}
			else if (question==8) {
				for (Checkbox c: checkboxes) {
					if (c.getQuestion()==8) {
						c.mouseCmd();
					}
				}
			}
		}
		else if (state==3) {
			entries.mouseCmd();
			if (homeBtn.getHover()==true) {
				loadBtn.setDisplayText(false);
				state=1;
				counter=0;
			}
			//System.out.println(true);
			if (loadBtn.getHover()==true) {
				loadBtn.load(entries.getChosen());
			}
		}
	}
	public void mouseWheel(MouseEvent event) {
		 float e = event.getCount();
		 if (state==2) {
			 if (question==1) {
				 hour.wheelCmd(e);
				 minute.wheelCmd(e);
				 daytime.wheelCmd(e);
				 hour2.wheelCmd(e);
				 minute2.wheelCmd(e);
				 daytime2.wheelCmd(e);
			 }
			 else if (question==2) {
				 day.wheelCmd(e);
				 month.wheelCmd(e);
				 year.wheelCmd(e);
			 }
			 else if (question==3) {
				 rate.wheelCmd(e);
			 }
		 }
		 else if (state==3) {
			 entries.wheelCmd(e);
			 loadBtn.wheelCmd(e);
		 }
	}
	public void keyTyped() {
		char k = key;
		if (question==5) {
			symptoms.execute(k);
		}
		if (question==7) {
			triggers.execute(k);
		}
		if (question==9) {
			aura.execute(k);
		}
		if (question==10) {
			medication.execute(k);
		}
		if (question==11) {
			extra.execute(k);
		}
		if (question==12) {
			entry.execute(k);
		}
	}

}
