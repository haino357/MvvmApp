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