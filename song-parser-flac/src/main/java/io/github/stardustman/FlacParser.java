package io.github.stardustman;
import com.chenshuyi.demo.ParserManager;
import com.chenshuyi.demo.Song;
import com.chenshuyi.demo.Parser;

import java.util.Arrays;

public class FlacParser implements Parser {

    public final byte[] FORMAT = "FLAC".getBytes();
    public final int FORMAT_LENGTH = FORMAT.length;


    static {
         try {
             ParserManager.registerParser(new io.github.stardustman.FlacParser());
         } catch (Exception e){
             throw new RuntimeException("Can't register parser!");
         }
    }

    @Override
    public Song parse(byte[] data) throws Exception {
        if (!isDataCompatible(data)) {
            throw new Exception("data format is wrong.");
        }
        return new Song("Evan Call","flac","《镰仓殿的13人》",132L);
    }

    private boolean isDataCompatible(byte[] data){
        byte[] format = Arrays.copyOfRange(data,0,FORMAT_LENGTH);
        return Arrays.equals(format,FORMAT);
    }
}
