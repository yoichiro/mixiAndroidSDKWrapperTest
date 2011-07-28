# mixiAndroidSDKWrapperTest

このプロジェクトは、mixi API SDK for Android(TM) をより便利に利用できるように機能拡張を行う
ためのプロジェクトである「mixiAndroidSDKWrapper」のテストプロジェクトです。

mixiAndroidSDKWrapperの品質は、それを利用する多くのアプリケーションの品質に直結する問題となり
ます。本プロジェクトでは、mixiAndroidSDKWrapperが提供する各種機能について、単体テストレベルでの
動作確認コードが実装されます。mixiAndroidSDKWrapperに対して追加や修正を行った場合は、原則的に
本プロジェクトに対しても何らかの影響が発生します。つまり、それはテストコードの追加を意味するでしょう。

## インストール

mixiAndroidSDKWrapperTestを利用可能にするには、以下の手順を行います。

 * mixi API SDK for Android(TM)のインストール
 * mixiAndroidSDKWrapperのインストール
 * mixiAndroidSDKWrapperTestのインストール
 * AndroidMockのインストール

### mixi API SDK for Android(TM)のインストール

最初にmixi Developer Centerにて配布されているmixi API SDK for Android(TM)をダウンロード
し、その後インストールします。mixi API SDK for Android(TM)は、以下の場所から最新版を入手しま
す。

[SDKダウンロード](http://developer.mixi.co.jp/appli/spec/android/download/)

ダウンロード後、Eclipseのワークスペースディレクトリ内でzipファイルを展開します。そして、Eclipse
を起動し、[File]->[Import...]->[General]->[Existing projects into Workspace]を選択
し、先ほど展開したmixiAndroidSDKディレクトリを選択してインポートします。

### mixiAndroidSDKWrapperのインストール

以下のGitHubリポジトリから、mixiAndroidSDKWrapperを入手します。

[mixiAndroidSDKWrapper](https://github.com/yoichiro/mixiAndroidSDKWrapper)

mixiAndroidWrapperの配置場所は、先ほど展開したmixi API SDK for Android(TM)と同じ場所が
良いでしょう。そして、Eclipseを起動し、[File]->[Import...]->[General]->
[Existing projects into Workspace]を選択し、mixiAndroidSDKWrapper
ディレクトリを選択してインポートします。

もしmixi API SDK for Android(TM)と同じディレクトリに配置しなかった場合は、
mixiAndroidSDKWrapperディレクトリにあるdefault.propertiesファイルについて、以下の修正を
行う必要があります。

    android.library.reference.1=[mixiAndroidSDKディレクトリのパス]

この記述により、mixi API SDK for Android(TM)とmixiAndroidSDKWrapperとが関連づけられま
す。

### mixiAndroidSDKWrapperTestのインストール

以下のGitHubリポジトリから、mixiAndroidSDKWrapperTestを入手します。

[mixiAndroidSDKWrapperTest](https://github.com/yoichiro/mixiAndroidSDKWrapperTest)

入手したmixiAndroidWrapperTestの配置先は、先ほど配置したmixiAndroidSDKWrapperと
同じ場所が良いでしょう。そしてEclipseを起動し、[File]->[Import...]->[General]->
[Existing projects into Workspace]を選択し、mixiAndroidSDKWrapperTest
ディレクトリを選択してインポートします。

もしmixiAndroidSDKWrapperと同じディレクトリに展開しなかった場合は、
mixiAndroidSDKWrapperTestディレクトリにあるdefault.propertiesファイルについて、以下の
修正を行う必要があります。

    android.library.reference.1=[mixiAndroidSDKWrapperディレクトリのパス]

この記述により、mixiAndroidSDKWrapperとmixiAndroidSDKWrapperTestとが関連づけられま
す。

### AndroidMockのインストール

mixiAndroidSDKWrapperTestは、AndroidMockを利用しています。

[Android Mock - A Mocking Framework for the Dalvik VM](http://code.google.com/p/android-mock/)

Under construction...