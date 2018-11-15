/**
 * Java 11 を勉強するためのパッケージです。
 *
 * <h2>公式ページ</h2>
 *
 * <p>
 * <a href="https://openjdk.java.net/projects/jdk/11/">JDK 11 - OpenJDK</a><br>
 * </p>
 *
 * <h2>JEP</h2>
 *
 * <h3>181: Nest-Based Access Control</h3>
 *
 * <p>
 * 内部クラスから、その定義クラス（外部クラス）の private メソッドを呼び出す時の仕様が変更されています。
 * なお、プログラミング記述上の変化はありません。
 * </p>
 *
 * <h3>309: Dynamic Class-File Constants</h3>
 *
 * <p>
 * Constant Dynamic (condy) と呼ばれる機能です。
 * コンパイル時にはまだ確定していない値を、Constant Pool に格納できます。
 * ただし Java 11 では、システムプロパティの値を変更しないと使用できません。
 * </p>
 *
 * <h3>315: Improve Aarch64 Intrinsics</h3>
 *
 * <p>
 * Aarch64 に関して、三角関数の改善を行ったようです。
 * </p>
 *
 * <h3>318: Epsilon: A No-Op Garbage Collector</h3>
 *
 * <p>
 * イプシロン GC という、何もしない GC が実装されました。
 * 性能試験などで CG を計測範囲に入れたくない時や、
 * 実行後に JVM を終了するクライアントやサーバーレスなどで利用できるかもしれません。
 * </p>
 *
 * <h3>320: Remove the Java EE and CORBA Modules</h3>
 *
 * <p>
 * 以下のモジュールが削除されました。
 * </p>
 *
 * <ul>
 * <li>java.xml.ws</li>
 * <li>java.xml.bind</li>
 * <li>java.activation</li>
 * <li>java.xml.ws.annotation</li>
 * <li>java.corba</li>
 * <li>java.transaction</li>
 * <li>java.se.ee</li>
 * <li>jdk.xml.ws</li>
 * <li>jdk.xml.bind</li>
 * </ul>
 *
 * <p>
 * 削除されたモジュールは、今後、JakartaEE に移管されるようです。
 * </p>
 *
 * <h3>321: HTTP Client (Standard)</h3>
 *
 * <p>
 * HTTP Client API が正式に実装されました。
 * {@link jp.co.opst.nishimoto_satoshi.study_java11.java11.Jep321 Jep321} を参照してください。
 * </p>
 *
 * <h3>323: Local-Variable Syntax for Lambda Parameters</h3>
 *
 * <p>
 * ラムダ式の引数に var が使用できるようになりました。
 * 特にプログラミング上の利点はないようにみえますが、
 * var を記述すると、アノテーションが記述できるようです。
 * {@link jp.co.opst.nishimoto_satoshi.study_java11.java11.Jep323 Jep323} を参照してください。
 * </p>
 *
 * <h3>324: Key Agreement with Curve25519 and Curve448</h3>
 *
 * <p>
 * <a href="https://tools.ietf.org/html/rfc7748">RFC7748</a>の実装です。
 * 既存の Diffie-Hellman 方式よりも効果的で安全な鍵交換方式とのことです。
 * </p>
 *
 * <h3>327: Unicode 10</h3>
 *
 * <p>
 * Unicode 10.0 に対応しました。
 * </p>
 *
 * <h3>328: Flight Recorder</h3>
 *
 * <p>
 * Java Flight Recorder は、アプリケーションや JVM から各種情報を収集します。
 * Java Mission Control (JMC) を利用する際に使用されます。
 * </p>
 *
 * <h3>329: ChaCha20 and Poly1305 Cryptographic Algorithms</h3>
 *
 * <p>
 * <a href="https://tools.ietf.org/html/rfc7539">RFC7539</a>の実装です。
 * TLS の暗号方式である ChaCha20-Poly1305 が実装されました。
 * </p>
 *
 * <h3>330: Launch Single-File Source-Code Programs</h3>
 *
 * <p>
 * 1 つの Java ファイルで依存関係が完結していて、かつ main メソッドが実装されている場合、
 * その Java ファイルを Java コマンドで実行できるようになりました。
 * なお、JRE への依存は大丈夫のようです、
 * {@link jp.co.opst.nishimoto_satoshi.study_java11.java11.Jep330 Jep330} を参照してください。
 * </p>
 *
 * <h3>331: Low-Overhead Heap Profiling</h3>
 *
 * <p>
 * ヒープ割り当て状況の情報収集に関する機能のようです。
 * 実際に利用する時は、Java Flight Recorder を使用することになると思われます。
 * </p>
 *
 * <h3>332: Transport Layer Security (TLS) 1.3</h3>
 *
 * <p>
 * <a href="https://tools.ietf.org/html/rfc8446">RFC8446</a>の実装です。
 * </p>
 *
 * <h3>333: ZGC: A Scalable Low-Latency Garbage Collector (Experimental)</h3>
 *
 * <p>
 * ZGC という、低遅延の GC が試験的に実装されました。
 * 非常に大きいサイズのヒープを処理でき、停止時間は 10 ミリ秒以内ということです。
 * </p>
 *
 * <h3>335: Deprecate the Nashorn JavaScript Engine</h3>
 *
 * <p>
 * JavaScript エンジンである Nashorn が非推奨になりました。
 * 代替として、<a href = "https://github.com/graalvm/graaljs">GraalJS</a> の利用が提案されています。
 * </p>
 *
 * <h3>336: Deprecate the Pack200 Tools and API</h3>
 *
 * <p>
 * 圧縮スキーマのひとつである Pack200 の API が非推奨になりました。
 * </p>
 */
package jp.co.opst.nishimoto_satoshi.study_java11.java11;
