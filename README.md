# KMM-example
example of a cross-platform mobile app with Kotlin Multiplatform Mobile (KMM).

### KMM Folder Structure

This is an example of the folder structure in a Kotlin Multiplatform Mobile (KMM) project.

- **shared**: Contains shared code and resources.
  - **src**: Shared Kotlin code.
      - **commonMain**: Shared Kotlin code.
        - **Platform.kt**: expect class Platform()
        - **greeting.kt**: fun greeting(): String
        - **Encryption.kt**: fun encryptAes(): String
        - **Hanoi.kt**: fun setDiskNum(): Int, fun getTotalStepNum(): Int, fun getDiskDistribution(step: Int): Array<MutableList<Int>>
      - **androidMain**
        - **Platform.kt**: actual class Platform()
      - **iosMain**
        - **Platform.kt**: actual class Platform()


Three examples on android(left) and iOS(right).
### Home
<p float="left">
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/android_home.png" width="162" height="351"/>
&nbsp;
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/ios_home.png" width="162" height="351"/>
</p>



### 1.OS version
<p float="left">
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/android_os_version.png" width="162" height="351"/>
&nbsp;
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/ios_os_version.png" width="162" height="351"/>
</p>




### 2.AES encryption
<p float="left">
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/android_aes_encryption.png" width="162" height="351"/>
&nbsp;
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/ios_aes_encryption.png" width="162" height="351"/>
</p>





### 3.Hanoi tower
<p float="left">
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/android_hanoi_tower.png" width="421" height="194"/>
&nbsp;
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/ios_hanoi_tower.png" width="421" height="194"/>
</p>

<p float="left">
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/android_hanoi_tower.gif" width="421" height="194"/>
&nbsp;
  <img src="https://github.com/rKaiProgramer/KMM-example/blob/main/assets/screenshots/ios_hanoi_tower.gif" width="421" height="194"/>
</p>
