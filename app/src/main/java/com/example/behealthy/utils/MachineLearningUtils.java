package com.example.behealthy.utils;

import android.content.Context;
import org.tensorflow.lite.Interpreter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MachineLearningUtils {

    private Interpreter tflite;

    public MachineLearningUtils(Context context) {
        try {
            tflite = new Interpreter(loadModelFile(context));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MappedByteBuffer loadModelFile(Context context) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(context.getFilesDir() + "/mood_prediction_model.tflite");
        FileChannel fileChannel = fileInputStream.getChannel();
        long startOffset = 0;
        long declaredLength = fileChannel.size();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public float predictMood(float heartRate, float oxygenLevel, float pulseRate, float sleepPattern) {
        float[][] input = new float[1][4];
        input[0][0] = heartRate;
        input[0][1] = oxygenLevel;
        input[0][2] = pulseRate;
        input[0][3] = sleepPattern;

        float[][] output = new float[1][1];
        tflite.run(input, output);

        return output[0][0];
    }
}
