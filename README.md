# DoomPiano-Midi #
##play Doom with you MidiController##

DoomPiano-Midi is a fork of Mochadoom [https://github.com/jendave/mochadoom](https://github.com/jendave/mochadoom) that's a cleaned up version of the original hosted on [http://mochadoom.sourceforge.net](http://mochadoom.sourceforge.net)

##what is it##
DoomPiano-Midi was inspired by the [DoomPiano (youtube)](https://www.youtube.com/watch?v=LoOzVAYSqzw). A project where an old piano was wired up to act as a keyboard to play doom.
It was brought to live by: David Hayward, Sos Sosowski, George Buckenham and Ricky Haggett ([Source: Gamasutra](http://www.gamasutra.com/view/news/200427/))

##how to run##
1. either download the release or build the jar from source.
2. use the commandline parameter -piano "Controllername" to specify you midi controller
3. keys are mapped in each octave (Note C - B)

example:
doompiano-midi.jar -piano "nanoKEY"

##keymap##

- C: Strafe Left
- C#: Turn Left
- D: Backward
- D#: Turn Right
- E: Strafe Right
- F: Forward
- F#: Weapon 0
- G: Weapon 1
- G#: Weapon 2
- A: Weapon 3
- B: Fire
- B#: Use