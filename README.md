# Caliper Sample App for Java Sensor

ログインとログアウトの SessionEvent を送信するサンプルアプリケーションです。

イベントの送信処理は src/main/java/imsglobal/caliper/CaliperSession.java に記述されています。

## 実行方法

CaliperSession.java の ENDPOINT や API_KEY を各自の環境に合わせた値に書き換えてください。

コマンドプロンプト等から下記のコマンドを実行してください。

    mvn package
    target\bin\tomcat.bat

ポート8888でTomcatが起動しますので、Webブラウザ等から下記のアドレスにアクセスしてください。

    http://localhost:8888/login.jsp

画面上のLogin/Logoutボタンを押すと SessionEvent が送信されます。


## References

Caliper Analytics v1 Final Specification

- [Caliper Analytics v1 Best Practice Guide](http://www.imsglobal.org/caliper/caliperv1p0/ims-caliper-analytics-best-practice-guide)
- [Caliper Analytics v1 Implementation Guide](http://www.imsglobal.org/caliper/caliperv1p0/ims-caliper-analytics-implementation-guide)
- [Caliper Analtyics v1 Conformance Guide](http://www.imsglobal.org/caliper/caliperv1p0/ims-caliper-analytics-conformance-and-certification-guide-v10)
- [Sensor APIs](http://www.imsglobal.org/caliper-analytics-v1-public-repos-sensor-apis)

