# MVVMアーキテクチャ学習用Repository

## 現在の環境設定
- Android Studio Arctic Fox | 2020.3.1
- Android Gradle plugin Version:7.0.3
- Gradle Version:7.0.2
- Kotlin Version:1.4.20

## 学習中
- Android Architecture Components
- LiveData
- DataBinding
- Kotlin Coroutine
- 

## 学習予定


## MVVM(Model-View-ViewModel)設計
- Repositoryパターン
- 


## 依存関係

## Gradle
GradleはJava環境におけるビルドシステムのことで、パッケージの導入やバージョン管理の際に用いる。
- Windows版AndroidStudioで説明を記載
  - File>Project Structureを押下する(Ctrl+Alt+Shift+s)ことで開かれる`Project Structure`で`Project`を押下すると下記が表示される。
  - 下記から必要なバージョンに変更する  
<img src="Picture/Project%20Structure設定画面.png" width="600">
  
- 変更後は`build.gradle`が指定のバージョンに変更される

### Kapt
`Kapt`と呼ばれるプラグイン。`kotlin-annotation-processing tools`の略でアノテーション(先頭が@ではじまるもの)を使ってコードを自動生成できるようになる。Androidでは下記を`build.gradle`に追加することで使用できる。
```
apply plugin: 'kotlin-kapt'
```
### Moshi
MoshiはSquare社が開発した軽量なJsonパーサーライブラリ。Json形式のデータを読み込んで、Java Objectに変換してくれる。
これがないとアプリ側でAPIで叩いてきた結果を扱うことが困難になる。
類似ライブラリに`Gson`がある。
```
// moshi
def moshi_version = "1.11.0"
implementation "com.squareup.moshi:moshi:$moshi_version"
implementation "com.squareup.moshi:moshi-kotlin:$moshi_version""
```
[Moshiドキュメント](https://github.com/square/moshi)

  
## AndroidのBackキーを無効にする
方法は下記3通り
1. dispatchKeyEventを使用してBackキーのハンドリングを行う
2. onBackPressedを使用する
3. callbackを利用して無効化する  
  

1.dispatchKeyEventを使用してBackキーのハンドリングを行う
 →dispatchKeyEventでBackキー押下時にreturn trueを返すことで実装できる。

 ```Java
 @Override
public boolean dispatchKeyEvent(KeyEvent) {
    if (event.getAction() == KeyEvent.ACTION_DOWN) {
        switch (event.getKeyCode()) {
            // Backキーの押下時の処理
            case KeyEvent.KEYCODE_BACK:
                // ダイアログ表示等の処理を行いたい場合はここに記述
                // 親クラスのdispatchKeyEvent()を呼び出さずにtrueを返すことで、
                // Backキーを無効にする
                return true;
        }
    }
    return super.dispatchKeyEvent(event);
}
 ```

2.onBackPressedを使用する
 →`Activity#onBackPressed()`の中を空にすることで戻るキーが無効化される。 

 ```kotlin
 override fun onBackPressed() {
     //中身を空にすることで戻るキーが無効化される。
 }
 ```

3.callbackを利用して無効化する。

 ```kotlin
 val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
     // 
 }
 ```
 ・FragmentでのBackKeyの無効化方法

 ## Single Activity
ひとつのActivityのライフサイクル内でFragmentを活用して画面を作る。

## レイアウト
xmlで現在日時の表示する  
`TextClock`タグを利用する。
```xml
<TextClock
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginBottom="10dp"
    android:textSize="60sp"
    android:timeZone="Asia/Tokyo"
    android:format24Hour="yyyy/MM/dd HH:mm:ss"
    android:format12Hour="yyyy/MM/dd HH:mm:ss" />
```
`android:timeZone="Asia/Tokyo"`：タイムゾーンを設定する
`android:format24Hour="HH:mm:ss"`24時間形式で表示する
`android:format12Hour="HH:mm:ss"`12時間形式で表示する

参考サイト
- [Android TextClock:デジタル時計を表示する](https://www.programing-style.com/android/android-api/textclock/)

## YouTubeAPI
AndroidアプリでYouTubeを利用する場合使用する。  
### [YouTubePlayerFragment](https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerFragment?hl=ja)
基本的には上記の`YouTubePlayerFragment`を利用することが多そう。

## プロジェクト管理ファイル
Gradleのバージョン変更に伴い`.idea`ファイル内の変更点
- compiler.xml
- gradle.xml
- misc.xml
- vcs.xml
- codeStyleConfig.xml
- Project.xml
- Project_Default.xml