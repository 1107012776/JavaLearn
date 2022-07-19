# JavaLearn
Java开发学习笔记


## 基础知识

### String to Integer
```java
Integer a = Integer.parseInt("2");
```
### Integer to String
```java
//方法一:Integer类的静态方法toString()
Integer a = 2;
String str = Integer.toString(a)

//方法二:Integer类的成员方法toString()
Integer a = 2;
String str = a.toString();

//方法三:String类的静态方法valueOf()
Integer a = 2;
String str = String.valueOf(a);
```

