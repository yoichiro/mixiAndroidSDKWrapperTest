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

AndroidMockのインストール手順は、以下のドキュメントに従って行います。

[AndroidMockInEclipse-1.0.1.pdf](http://code.google.com/p/android-mock/downloads/detail?name=AndroidMockInEclipse-1.0.1.pdf)

## テストコードの実行

各インストールが完了すれば、Android Emuatorを使用してテストコードを実行することができるように
なります。実行は、mixiAndroidWrapperTestプロジェクトにて右クリックし、[Run As]->
[Android JUnit Test]を選択します。その後、Android Emulatorが起動し、自動的にテストコード
の実行が開始されます。実行結果は、EclipseのJUnitビューに表示されます。

## テストコードの記述

各テストクラスは、以下のクラスを継承したサブクラスとして実装します。

 jp.eisbahn.android.sdk.wrapper.AbstractTest

基本的なテストコードの記述方法は、JUnit3を使ったテストコードの記述方法と同じです。つまり、testで
始まるメソッドを定義することで、それがテストメソッドとして実行対象となります。AsbtractTestクラス
を継承していますので、assertEqualsメソッドなどの検証用メソッドを利用することが可能です。

AndroidMockを使ったモックオブジェクトの生成は、EasyMockと基本的に同様となります。たとえば、
以下のようなコードとなります。createMock、reply、そしてverifyといったEasyMockでの手順が
そのまま適用されます。

    GetPeopleCallbackHandler handler = new GetPeopleCallbackHandler(new MockContext());
    MixiContainer mixiContainer = AndroidMock.createMock(MixiContainer.class);
    mixiContainer.send("/people/@me/@self", handler);
    AndroidMock.replay(mixiContainer);
    PeopleProxyImpl target = new PeopleProxyImpl(mixiContainer);
    target.getMe(handler);
    AndroidMock.verify(mixiContainer);

原則として、mixiAndroidSDKWrapperプロジェクトにて何らかのコードに変更が生じた場合は、それに
対するテストコードをmixiAndroidSDKWrapperTestプロジェクトにて実装し、自動テストを実行可能とし、
リファクタリングの可能性を維持します。
