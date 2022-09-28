package textmusicconverter;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ExecutionManager implements IExecutionManager{
    private boolean musicReady = false;
    private final Player PLAYER = new Player();
    
    @Override
    public void generateAudio(String input, int initialInstrumentConfiguration, int initialBpmConfiguration){
        SoundHandler.initialize(initialInstrumentConfiguration, initialBpmConfiguration);
        InputParser.parseInput(input);
        setMusicReady(true);
    }
    
    @Override
    public void playAudio() {
        PLAYER.play(SoundHandler.generateAudioString());
    }
    
    @Override
    public boolean saveAsFile(Path path) {
        File outputFile = new File(path.toUri());
        Pattern pattern = new Pattern();
        pattern.add(SoundHandler.generateAudioString());

        try {
            MidiFileManager.savePatternToMidi(pattern, outputFile);
            return true;
        } catch (IOException error) {
            System.out.println("Erro ao salvar o arquivo. Detalhes abaixo");
            error.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean isMusicReady() {
        return musicReady;
    }
    
    @Override
    public void setMusicReady(boolean musicReadyInput) {
        musicReady = musicReadyInput;
    }
}