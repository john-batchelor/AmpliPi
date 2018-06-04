package AppPackage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;

public class MainClass 
{
    FileInputStream FIS; 
    BufferedInputStream BIS;
    public static Mixer mixer;
    public static Clip clip;
    public boolean isPlaying = false;
    public boolean isPaused = false;
    public boolean resume = false;
    public int mode;
    public boolean disablePlay = false;
    
    public Player player;
    
    public long pauseLocation;
    public long songTotalLength;
    public String fileLocation;
    public int toggleShuffle = 1; 
    public static String playlist[];
    public static boolean toggleLoop = false;
    
    //public static String playlist[] = readFile();
    public int i = 0;
    
    MainClass()
    {
        
        //setError("Hello");
        try
        {
            //playlist = readFile();
            
            
        }
        catch (NullPointerException npe)
        {
            setError("There are no songs in the library");
        }
        
        
        
        /*if(playlist.length == 0)
        {
            setError("There are no songs in the library");
        }*/
    }
    
    public int getI()
    {
        return i;
    }
    
    public boolean setLoop()
    {
        toggleLoop = !toggleLoop;
        System.out.println(toggleLoop);
        return toggleLoop;
    }
    
    public int settoggleShuffle()
    {
        if(toggleShuffle == 1)
        {
            shuffleArray(playlist);
            toggleShuffle = 0;
        }
        
        return toggleShuffle;
    }
    
    // swaps array elements i and j
    public static void exchange(String[] a, int i, int j) 
    {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // returns a random integer between 0 and n-1
    public static int uniform(int n) 
    {
        return (int) (Math.random() * n);
    }

    // take as input an array of strings and rearrange them in random order
    public static void shuffleArray(String[] a) 
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);   // between i and n-1
            exchange(a, i, r);
        }
    }

    // take as input an array of strings and print them out to standard output
    /*public static void show(String[] a) 
    {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }*/
    
    public int getMode()
    {
        //mode = 0;
        return mode;
    }
    
    public int setMode(int input)
    {
        switch(input)
        {
            case 1:
                mode = input;
            case 2:
                mode = input;
            default:
                mode = 0;
        }
        
        return mode;
    }
    
    public void Stop()
    {
        if(player != null)
        {
            disablePlay = false;
            player.close();
            pauseLocation = 0;
            songTotalLength = 0;
            isPlaying = false;
        }
    }
    
    public void Pause()
    {
        if(player != null)
        {
            try 
            {
                disablePlay = false;
                pauseLocation = FIS.available();
                player.close();
                isPlaying = false;
                isPaused = true;
                resume = false;
                //setMode(2);
                
            }
            catch (IOException ex) 
            {
                
            }
        }
    }
    
    public void getSpeakers()
    {
        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        
        for (Mixer.Info info : mixInfos) {
            System.out.println(info.getName());
        }
    }
    
    
    public void Resume() throws FileNotFoundException, LineUnavailableException 
    {
        if(disablePlay == false)
        {
        try 
        {
           
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            
            disablePlay = true;
            
            player = new Player(BIS);
            isPlaying = true;
            resume = true;
            
            
            
            FIS.skip(songTotalLength - pauseLocation);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread()
        {
            @Override
            public void run()
            {
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } .start();
        
    }
    }
    
    public void Play(String path) 
    {
        if(disablePlay == false)
        {
        try {
            
           System.out.println(playlist.length);
           String song;
           resume = true;
           disablePlay = true;
           
          
            song = playlist[i];
           
            System.out.println(song);
            
            File songName = new File(song);
            String title = songName.getName();
            MP3PlayerGUI.Display.setText(title);
            
             
            
            FIS = new FileInputStream(song);
            BIS = new BufferedInputStream(FIS);
            
            FIS.available();
            player = new Player(BIS);
            
            songTotalLength = FIS.available();
            fileLocation = song + "";
            
          
            
        } catch (FileNotFoundException ex) {
            
            setError("File Not Found");
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException | IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new Thread()
        {
            @Override
            public void run()
            {
                try 
                {
                    player.play();
                    
                    if(player.isComplete())
                    {
                        
                            isPlaying = false;
                            disablePlay = false;
                            if(toggleLoop == false)
                            {
                                i++;
                            }
                            
                            Play(playlist[i]);
                            
                    }
                } 
                catch (JavaLayerException ex) 
                {
                    Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } .start();
    }
    }
    
    public static Collection<String> files = new ArrayList<>();
    
    public static String[] listFilesAndFilesSubDirectories(String directoryName)
    {
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList)
	{
            if (file.isFile())
	    {
		String[] okFileExtensions = new String[] {"mp3"};
		for(String extension : okFileExtensions)
		{
			if(file.getName().toLowerCase().endsWith(extension))
			{
				files.add(file.getAbsolutePath());
                                writeToFile(file.getAbsolutePath());
			}
		}
            } 
	    else if (file.isDirectory())
	    {
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
        return files.toArray(new String[]{});
    }
    
    
    
    
   /* public static String shuffle()
    {
        
	String songs[];
        songs = readFile();
                
	int noOfSongs = songs.length;
	
        generateRandom(noOfSongs);
        
        int n = generateRandom(noOfSongs);
        String song = songs[n];	
        return song;
    }*/
    
    /*public static String inOrder()
    {
        String songs[];
        songs = readFile();
        String song = "";
        //int nextSongNumber = nextSong(song);
       
        
        //song = songs[i];
        
        return song;
    }*/
    
    
    public static String chooseSong()
    {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3","mpeg3", "wav", "WAV");
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(null);
        String myFile = chooser.getSelectedFile().getAbsolutePath();
        
        listFilesAndFilesSubDirectories(myFile);
        return myFile;   
           
    }
    public static Collection<String> songs = new ArrayList();
    
    public static String[] shuffledSongs()
    {
        readFile();
        shuffleArray(playlist);
        
        return playlist;
        
    }
    
    public int setI(int input, int nav)
    {
        if(nav == 0) // previous song
        {
            if(i == 0) //if song is the first song
            {
                i=playlist.length-1; //set i to the last song in array
            }
            else
            {
                i = i + input; //i = i + -1 
            }
        }
        else //next
            if(i == playlist.length-1) //if song is he last song in array
            {
                i = 0; //set i to the first song in array
            }
            else
            {
                i = i+input; //i = i + 1
            }
            
        
        System.out.println(i);
        return i; 
    }
    
    public static String[] readFile()
    {
        try
        {
            File file = new File("songs.txt");
            
            if(!file.exists())
            {
                setError("There are no songs in your library.");
                chooseSong();
            }
            
            else
            {// Create a file reader
                FileReader fr = new FileReader(file);

            // Create a buffered reader
            BufferedReader br = new BufferedReader(fr);
            
            
            
            // Read and display lines from file
            String song;
            
            if(br.readLine() == null)
            {
                setError("There are no songs in your library");
                chooseSong();
                playlist = readFile();
            }
            
            while((song = br.readLine()) != null)
            {
		songs.add(song);
        	
            }
            
            fr.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: " + e);
            setError("Error: " + e);
        }
        
        
        playlist = songs.toArray(new String[]{});
        
        return songs.toArray(new String[]{});
    }
    
    //playlist[] = readFile(); 
    
    public static void writeToFile(String fileName)
    {
        try
	{
		File file = new File("songs2.txt");	
		FileWriter fw = new FileWriter(file, true);
		
		BufferedWriter bw = new BufferedWriter(fw);

		
			bw.write(fileName + " \r\n");
		

		bw.close();
		
	}
	
	catch(Exception e)
	{
		System.out.println("Exception: " + e);
	}
	
    }
    /*
    public static int generateRandom(int noOfSongs)
    {
        Random rand = new Random();
        int  n = rand.nextInt(noOfSongs) + 0;
        return n;
    }*/
    
    public static String setError(String message)
    {
        //MP3PlayerGUI.JOptionPanel.showMessageDialog(frame, message);
        JOptionPane.showMessageDialog(null, message, "Ooops!", JOptionPane.INFORMATION_MESSAGE);
        /*MP3PlayerGUI.errorPanel.setVisible(true);
        MP3PlayerGUI.errorMessage.setText(message);*/
        return message;
    }
    
    /*
    public static boolean isEmpty(String array[])
    {
        boolean empty = false;
        if(array.length == 0)
        {
            empty = true;
            setError("There are no files in the library");
        }
        
        return empty;
    }*/
}
