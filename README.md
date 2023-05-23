# Folio: A Page Replacement Algorithm Simulator

This program is a Page Replacement Algorithm Simulator developed by 3 third-year Computer Science students (FMS STUDIOS) as a group project for CMSC 125. It is also built using Java language and the GUI is constructed using Netbeans IDE.
## Acknowledgements

 - [Retro Funk 20.03.2022 1714](https://freesound.org/people/sonically_sound/sounds/624874/) by [sonically_sound](https://freesound.org/people/sonically_sound/)


## Deployment

1. (Preferably) Install the latest version of Java SDK and Java JRE. 
2. In your console of choice, change directory to the folder where the `.jar` file or `.exe` file named Folio is located. 
3. Run the the program using the commands listed below depending if you use the `.jar` file or the `.exe` file (Windows).

### Jar File Execution
1. For other OS with Java installed, type the following: `java -jar Folio.jar`

### Exe File (Windows users only)
1. Simply type the following: `start Folio.exe`

###
You can also run the jar and/or exe files by simply opening either of the files.


## Test Case File Format

1. You can import a `.txt` file to extract inputs for the different CPU Scheduling Algorithms
2. format should be the following: where the `Frame` is the number of page frames. `Algorithm` is the acronym of the page replacement algorithm chosen. The following valid acronyms and their meaning are given below;
- FIFO - first in, first out
- LRU - least recenrtly used
- OPT - optimal page replacement
- SC - second chance
- ESC - enhanced second chance
- MFU - most frequently used
- LFU - least frequently used

Lastly, the `Page_Reference` is the reference string which gives the pages to simulate. Numbers should be any number from 0 to 10, inclusive.

Example:
```
Frames: 4
Algorithm: LRU
Page_Reference: 7 0 1 2 0 3 0 4 2 3 0 3 2 3
```

## Authors

- [@FrancisEspina](https://github.com/FrancisEspina)
- [@shannaurelle](https://github.com/shannaurelle)
- [@KianventeR](https://github.com/KianventeR)


## Dependencies

The program requires:

- [JDK 16.0.1](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)
- [iTextPDF](https://github.com/itext/itextpdf/releases?after=5.5.13.2)
