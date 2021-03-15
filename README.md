# MVVMアーキテクチャ学習用Repository

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
### Kapt
`Kapt`と呼ばれるプラグイン。`kotlin-annotation-processing tools`の略でアノテーション(先頭が@ではじまるもの)を使ってコードを自動生成できるようになる。Androidでは下記を`build.gradle`に追加することで使用できる。
```
apply plugin: 'kotlin-kapt'
```

  
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