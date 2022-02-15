## 民族查询接口

```
http://127.0.0.1:5443/dict/nation
```

## 专业代码搜索

研究生 -> 哲学 -> 哲学 -> 哲学类

```bash
http://127.0.0.1:5444/dict/major?level=1  # 一级 例子：研究生
http://127.0.0.1:5444/dict/major?level=3&code_value2=B  # 二级 例子：哲学
http://127.0.0.1:5444/dict/major?level=5&code_value2=B01  # 三级 例子：哲学
http://127.0.0.1:5444/dict/major?level=7&code_value2=B0101  # 一级 例子：哲学类
```

## 行业代码

```bash
http://127.0.0.1:5444/dict/industry?level=1
http://127.0.0.1:5444/dict/industry?level=3&code_value2=P
http://127.0.0.1:5444/dict/industry?level=4&code_value2=P83
```

## 职工(工种)代码

```bash
http://127.0.0.1:5444/dict/career?level=4
http://127.0.0.1:5444/dict/career?level=7&code_value2=P
http://127.0.0.1:5444/dict/career?level=9&code_value2=P83
```

