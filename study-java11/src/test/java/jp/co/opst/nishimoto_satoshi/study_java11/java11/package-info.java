/**
 * Java 11 を勉強するためのパッケージです。
 *
 * <h2>公式ページ</h2>
 *
 * <p>
 * <a href="https://openjdk.java.net/projects/jdk/11/">JDK 11 - OpenJDK</a><br>
 * </p>
 *
 * <h2>機能</h2>
 *
 * <h3>181: Nest-Based Access Control</h3>
 *
 * <p>
 * 内部クラスからその定義クラス（外部クラス）の private メソッドを呼び出す時の JVM 仕様が変更されています。
 * なお、プログラミング記述上の変化はありません。
 * </p>
 *
 * <h3>309: Dynamic Class-File Constants</h3>
 *
 * <p>
 * Constant Dynamic (condy) と呼ばれる機能です。
 * コンパイル時にはまだ確定していない値を Constant Pool に格納できます、
 * ただし、Java 11 では、システムプロパティの値を変更しないと使用できません。
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
 * イプシロンという、何もしない GC が実装されました。
 * 性能試験などで CG を考慮したくない時や、
 * 実行後に JVM を終了するクライアントやサーバーレスなどで利用できるかもしれません。
 * </p>
 *
 * <h3>320: Remove the Java EE and CORBA Modules</h3>
 *
 * <p>
 * 以下のモジュールが削除されます。
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
 * 削除されたモジュールは今後、JakartaEE で開発される模様です。
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
 * <a href="https://tools.ietf.org/html/rfc7748">RFC7748</a>の実装だそうです。
 * </p>
 *
 * <h3>327: Unicode 10</h3>
 *
 * <p>
 * Unicode 10.0 に対応されました。
 * </p>
 *
 * <h3>328: Flight Recorder</h3>
 *
 * <p>
 * Java Flight Recorderは、アプリケーションや JVM から各種情報を収集します。
 * Java Mission Control (JMC) を利用する際に使用されます。
 * </p>
 *
 * <h3>329: ChaCha20 and Poly1305 Cryptographic Algorithms</h3>
 *
 * <p>
 * <a href="https://tools.ietf.org/html/rfc7539">RFC7539</a>の実装だそうです。
 * </p>
 *
 * <h3>330: Launch Single-File Source-Code Programs</h3>
 *
 * <p>
 * 1 つの Java ファイルで依存関係が完結していて、かつ main メソッドが実装されている場合、
 * その Java ファイルを Java コマンドで実行することができます。
 * JRE のインポートは大丈夫のようです、
 * {@link jp.co.opst.nishimoto_satoshi.study_java11.java11.Jep330 Jep330} を参照してください。
 * </p>
 *
 * <h3>331: Low-Overhead Heap Profiling</h3>
 *
 * <h3>332: Transport Layer Security (TLS) 1.3</h3>
 *
 * <h3>333: ZGC: A Scalable Low-Latency Garbage Collector (Experimental)</h3>
 *
 * <h3>335: Deprecate the Nashorn JavaScript Engine</h3>
 *
 * <h3>336: Deprecate the Pack200 Tools and API</h3>
 */
package jp.co.opst.nishimoto_satoshi.study_java11.java11;
