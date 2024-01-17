# 株式会社COMPASS様 職能課題

## 起動手順

- docker, docker-composeのinstall

```
$ docker --version
Docker version 24.0.7
$ docker-compose --version
Docker Compose version 2.23.3
```

- makeコマンドの実行

```
$ make dev
# 略
```

- localhost:8080へアクセス(アプリケーションが正常に起動するまで数秒かかる場合があります。)

```
$ curl "http://localhost:8080/students?facilitator_id=1"
{"students":[{"id":1,"name":"あいだ","loginId":"alice","classroom":{"id":1,"name":"特待クラス1"}},{"id":2,"name":"いぐち","loginId":"bob","classroom":{"id":1,"name":"特待クラス1"}},{"id":3,"name":"うえだ","loginId":"charlie","classroom":{"id":1,"name":"特待クラス1"}}],"totalCount":3}
```

- dockerの停止

```
$ make stop
```

## アーキテクトの説明

### クラス設計について
DDDを意識したシステム構成とした上で、課題のエンドポイントにつきましては、複雑な検索条件を要求されることから、CQRSパターンを採用しました。  
採用意図としては、今後の開発で各種Entityの追加等が発生した場合でも、Repositoryパターンの阻害にならない構成とするためです。  

### テストコードについて
unit testとintegration testを分離し、unit testはクラス単位でテスト可能なパターン、integration testはDockerを用いたDBと接続し、APIとしての仕様を担保するテストパターンとして設計しました。  
今回の内容ではドメインロジックはほぼなく、検索条件に特化している機能であるため、integration testが充実した内容となっています。  
また、jacocoを導入し、テストのカバレッジを簡易に確認できる状態としております。  

### リファクタリング対象
開発時間の関係上、以下は省略いたしました。
 - エラーハンドリング
   - SpringBootのデフォルトのハンドリングに任せています。
   - 400エラーの際にユーザにパラメータエラーの詳細を通知するなど、利用者のための設計を考慮したいです。
   - SQLのリトライや
 - ログ
   - SpringBootのデフォルトのログとなっています。
   - ログ収集などを加味して検索性やトレーシングなどを意識したログ設計を実現したいです。
 - 各種メトリクス
   - 実運用を考慮する上で、エラーハンドリング等も絡めつつ、分析に必要なメトリクスの設計も考慮に入れたいです。
 - 可用性
   - limit, offsetを利用しており、ページングが進むほど性能が劣化します。
     - 検索条件等も加味して実現が簡単な手法を取りましたが、シーク法等のページングが負荷にならない設計も検討したいです。
   - 部分検索でLIKEを使用しており、レコード数が増えると性能が劣化します。
     - 全文INDEX等も検討できますが、日本語で正しい部分一致を実現するためにLIKEを利用しました。
     - 非機能要件によっては機能要件自体の見直しや、LIKEとは異なる部分一致実現手法を検討したいです。
   - idのauto incrementを脱却する
     - 課題のIFを見るにidはint型であったため、単純なPKの実現方法でauto incrementを採用しました。
     - auto incrementが抱える課題はよく議論されており、本システムでも採番に対して課題が発生する見込みがあれば、uuidやsnowflake等の採用を検討したいです。
