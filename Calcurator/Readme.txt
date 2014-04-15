
■機能

  電卓


■使用方法

  Calculatorに文字列の式を渡す
  計算可能な表記については、以下を参照
    - com.tryflysky.expression.model
       Number
       Operator
       Parentheses


■仕様

  int型で計算した結果を返す
  全角、半角どちらにも対応
  「÷、×」などの記号にも対応
  「一、弐」なども計算可能（十、拾は不可。一〇は可）


■構成

  ①ParenthesesRemover    -> 括弧内のみ計算して、括弧の無い式を返す
  ②OneOperatorCalculator -> 指定された演算子のみ計算した式を返す
  ③AllOperatorCalculator -> 加減乗除の演算子全てを計算した答えを返す

  Calculator -> ①で括弧を外した後に③を実行して答えを返す


■FAQ

  - 指数や8,16進数への対応は？
     ->予定はありません

  - なぜReadmeが.txtなの？
    ->GitHubを使い始める前に作成したものをそのまま利用しているからです

