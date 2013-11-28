package net.pixelsiege.doompiano;

import static net.sourceforge.mochadoom.data.Limits.MAXEVENTS;

import javax.sound.midi.MidiDevice;

import net.pixelsiege.midi.MidiDevices;
import net.pixelsiege.midi.devices.MidiController;
import net.sourceforge.mochadoom.doom.event_t;
import net.sourceforge.mochadoom.doom.evtype_t;

public class PianoHandler {

	private static DoomPiano piano;
	
	public static boolean initPiano(String deviceName){
	
		MidiDevice device = MidiDevices.getInputDevice(deviceName);
		
		if (device == null){
			return false;
		}
		
		try {
			piano = new DoomPiano(device);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public static void cleanPiano(){
		
		if (piano != null){
			piano.close();
			System.out.println("PIANO: cleaned up piano.");
		}else{
			System.out.println("PIANO: not dirty.");
		}
	}

	//Doom Event Queue
	
    public static event_t[] events = new event_t[MAXEVENTS];
    public static int eventhead = 0;
    public static int eventtail = 0;

    public static void PostEvent(event_t ev) {
        events[eventhead] = ev;
        eventhead = (++eventhead) & (MAXEVENTS - 1);
    }
    
    public static void PostKey(int keycode, boolean down){
    	event_t ev = new event_t();
    	
    	if (down){
    		ev.type = evtype_t.ev_keydown;
    	}else{
    		ev.type = evtype_t.ev_keyup;	
    	}
    	
    	ev.data1 = keycode;
    	
    	PostEvent(ev);
    }
}
