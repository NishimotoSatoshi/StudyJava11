/**
 * Java 10 を勉強するためのパッケージです。
 *
 * <h2>公式ページ</h2>
 *
 * <p>
 * <a href="https://openjdk.java.net/projects/jdk/10/">JDK 10 - OpenJDK</a><br>
 * </p>
 *
 * <h2>JEP</h2>
 *
 * <h3>286: Local-Variable Type Inference</h3>
 *
 * <p>
 * ローカル変数の宣言時に <code>var</code> を記述することで、
 * 宣言する変数の型を省略することが可能になりました。
 * ただし、初期値によって型が推論可能である必要があります。
 * {@link jp.co.opst.nishimoto_satoshi.study_java11.java10.Jep286 Jep286} を参照してください。
 * </p>
 *
 * <h3>296: Consolidate the JDK Forest into a Single Repository</h3>
 *
 * <p>
 * JDK リポジトリが 1 つにまとめられたようです。
 * </p>
 *
 * <h3>304: Garbage-Collector Interface</h3>
 *
 * <p>
 * GC インターフェースが導入されました。
 * これにより、新しい GC の導入が容易になったようです。
 * </p>
 *
 * <h3>307: Parallel Full GC for G1</h3>
 *
 * <p>
 * G1 GC において、フル GC が高速化のために並列化されました。
 * </p>
 *
 * <h3>310: Application Class-Data Sharing</h3>
 *
 * <p>
 * ブートストラップ・クラスローダで使用されていたクラスデータ共有 (CDS) が拡張され、
 * カスタム・クラスローダ等でも使用可能になりました。
 * これにより、JVM プロセス起動の高速化、および複数の JVM プロセス起動時のフットプリント削減が見込めます。
 * </p>
 *
 * <h3>312: Thread-Local Handshakes</h3>
 *
 * <p>
 * グローバル VM セーフポイントを実行せずに、スレッド上でコールバックを実行可能になったようです。
 * これによってスレッド操作が改善するようです。
 * </p>
 *
 * <h3>313: Remove the Native-Header Generation Tool (javah)</h3>
 *
 * <p>
 * javac コマンドの改善により、不要となった javah コマンドが削除されました。
 * </p>
 *
 * <h3>314: Additional Unicode Language-Tag Extensions</h3>
 *
 * <p>
 * <a href="http://www.rfc-editor.org/rfc/bcp/bcp47.txt">BCP47</a>の実装です。
 * 以下の Unicode 言語タグがサポートされました。
 * </p>
 *
 * <ul>
 * <li>cu : 通貨タイプ</li>
 * <li>fw : 週の開始></li>
 * <li>rg : リージョン・オーバーライド</li>
 * <li>tz : タイムゾーン</li>
 * </ul>
 *
 * <h3>316: Heap Allocation on Alternative Memory Devices</h3>
 *
 * <p>
 * Java オブジェクト・ヒープを、代替メモリ・デバイスに割り当てられるようになりました。
 * 低価格・大容量の代替メモリをオブジェクト・ヒープに使用することで、
 * 大量のオブジェクトを高速に扱うことが可能になります。
 * </p>
 *
 * <h3>317: Experimental Java-Based JIT Compiler</h3>
 *
 * <p>
 * Java ベース JIT コンパイラ Graal を、
 * Linux/x64 プラットフォームで実験的に JIT コンパイラとして使用できるようになりました。
 * </p>
 *
 * <h3>319: Root Certificates</h3>
 *
 * <p>
 * JDK でルート認証局 (CA) 証明書のデフォルトセットが提供されるようになりました。
 * </p>
 *
 * <h3>322: Time-Based Release Versioning</h3>
 *
 * <p>
 * Java のバージョンアップがタイムベースになりました。
 * またそれによりバージョン番号のルールが変わりました。
 * </p>
 */
package jp.co.opst.nishimoto_satoshi.study_java11.java10;
