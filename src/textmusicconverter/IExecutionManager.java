package textmusicconverter;
import java.nio.file.Path;


public interface IExecutionManager {
    
    public abstract void generateAudio(String input, int initialInstrumentConfiguration, int initialBpmConfiguration);
    public abstract void playAudio();
    public abstract boolean saveAsFile(Path path);
    public abstract boolean isMusicReady();
    public abstract void setMusicReady(boolean musicReadyInput);
}
