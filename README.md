# MPI2_1st_practical
## Pictures fragment
### Displaying pictures
Images that were taken by the user are being displayed in a slider view and are being cycled through automatically. Right after the image is captured, the thumbnail changes to the most recent image, that was captured by the user

<p align="center">
  <img src="preview/picture1.png?raw=true" />
  <img src="preview/picture2.png?raw=true" />
</p>

### Capturing images
For image capturing there is a “TAKE AN IMAGE” button. Images are saved to internal storage and uploaded to Firebase. If everything goes right, a toast message of “Upload successful” appears and the image can be located in the Firebase storage.

<p align="center">
  <img src="preview/picture3.png?raw=true" />
  <img src="preview/picture4.png?raw=true" />
</p>

## Audio fragment
### Displaying recordings
Recordings that were recorded by the user are displayed in a list view. Each item contains the full name of the file from storage. File name is generated randomly by adding the current time in milliseconds to the string of the file name.

<p align="center">
  <img src="preview/picture5.png?raw=true" />
</p>

For audio recording there is a “RECORD AUDIO” button. To start recording, the use must simply click it once and in order to stop the recording user must click the button again. Recordings are saved to internal storage of the device under /Music.

<p align="center">
  <img src="preview/picture6.png?raw=true" />
  <img src="preview/picture7.png?raw=true" />
</p>

## Firebase
### Firebase Cloud Storage
Images that are captured by the user are uploaded to the database under “uploads”.

<p align="center">
  <img src="preview/picture9.png?raw=true" />
</p>

### Firebase Realtime Database
Image URLs are uploaded to a realtime database under uploads.

<p align="center">
  <img src="preview/picture10.png?raw=true" />
</p>

### Firebase Analytics
Buttons that are clicked by the user are logged in the Firebase analytics and grouped by the event name.

<p align="center">
  <img src="preview/picture11.png?raw=true" />
</p>
