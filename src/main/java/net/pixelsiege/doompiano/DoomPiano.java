package net.pixelsiege.doompiano;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;

import net.pixelsiege.midi.MidiInput;
import net.sourceforge.mochadoom.game.Keys;

public class DoomPiano extends MidiInput {

	public DoomPiano(MidiDevice dev) throws Exception {
		super(dev);
	}
	
	@Override
	public void send(MidiMessage message, long timeStamp) {
		if (message instanceof ShortMessage) {
			ShortMessage smsg = (ShortMessage) message;
			
			int key = smsg.getData1();
			key = Note2Key(key);
					
			if (key != -1 && smsg.getCommand() == ShortMessage.NOTE_ON){
				PianoHandler.PostKey(key, true);
				if (key == 157){
					PianoHandler.PostKey(Keys.KEY_ENTER, true);
				}
			}
					
			if (key != -1 && smsg.getCommand() == ShortMessage.NOTE_OFF){
				PianoHandler.PostKey(key, false);
				if (key == 157){
					PianoHandler.PostKey(Keys.KEY_ENTER, false);
				}
			}
		} 
	}
	
	@Override
	public void controlChange(int arg0, int arg1, int arg2, long arg3) {
		// stub
	}

	@Override
	public void noteOff(int arg0, int arg1, int arg2, long arg3) {
		// stub
	}

	@Override
	public void noteOn(int arg0, int arg1, int arg2, long arg3) {
		// stub
	}

	private int Note2Key(int key){
		int note = key%12;
		// 0 1  2 3  4 5 6  7 8  9 10 11
		// C C# D D# E F F# G G# A A# B ";
				
		if (note == 0) return 97;	//strafe left (a)
		if (note == 1) return Keys.KEY_LEFTARROW;	//turn left
		if (note == 2) return Keys.KEY_DOWNARROW;	//backwards
		if (note == 3) return Keys.KEY_RIGHTARROW;	//turn right
		if (note == 4) return 100;	//strafe right (d)
		if (note == 5) return Keys.KEY_UPARROW;	//forward
		
		if (note == 6) return '1' + 0;	//0
		if (note == 7) return '1' + 1;	//1
		if (note == 8) return '1' + 2;	//2
		if (note == 9) return '1' + 3;	//3
		
		if (note == 10) return 157;	//fire (Ctrl)
		if (note == 11) return 32;	//use ( )
		
		return -1;
	}
	
}
