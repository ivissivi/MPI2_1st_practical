package com.example.firstpractical;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AudioFragment extends Fragment implements View.OnClickListener {

    View mView;
    Button recordButton;
    private ListView listView;
    private RecordingPlayer[] recordingsList;

    private MediaRecorder recorder = null;
    private MediaPlayer player = null;
    int btnClickCount = 0;

    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private String AudioSavePath = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_audio, container, false);
        recordButton = (Button) mView.findViewById(R.id.record_audio_btn);
        recordButton.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View view) {
        if(checkPermissions() == true) {
            switch (view.getId()) {
                case R.id.record_audio_btn:
                    if (btnClickCount == 0) {
                        try {
                            createAudioFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Log.d("tag", "Url of image: " + AudioSavePath);
                        mediaRecorder = new MediaRecorder();
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                        mediaRecorder.setOutputFile(AudioSavePath);

                        try {
                            mediaRecorder.prepare();
                            mediaRecorder.start();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getActivity().getApplicationContext(), "Recording...", Toast.LENGTH_SHORT).show();
                        btnClickCount++;
                    } else if (btnClickCount == 1) {
                        mediaRecorder.stop();
                        mediaRecorder.release();
                        Toast.makeText(getActivity().getApplicationContext(), "Stopped recording", Toast.LENGTH_SHORT).show();
                        btnClickCount = 0;
                    }
                    break;
            }
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[] {
                        Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 1);
            }
    }

    private boolean checkPermissions() {
        int first = ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        int second = ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return first == PackageManager.PERMISSION_GRANTED && second == PackageManager.PERMISSION_GRANTED;
    }

    private File createAudioFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String audioFileName = "MP3_G04_PW01_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        File audio = File.createTempFile(
                audioFileName,
                ".mp3",
                storageDir
        );
        AudioSavePath = audio.getAbsolutePath();
        return audio;
    }
}