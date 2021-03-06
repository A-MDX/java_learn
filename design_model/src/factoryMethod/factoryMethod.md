
## 1.普通工厂模式

建立一个工厂类，对实现了同一接口的一些类进行实例的创建。

+ 一个统一的接口
+ 几个具体实现类
+ 一个工厂方法，根据传入参数不同，可以自行返回不同实例。

## 2.多个工厂模式

在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。

+ 在工厂里面多放几个工厂。
+ 只需要更改一下工厂类。

## 3.静态工厂方法模式

将上面的2.多个工厂模式里的方法改为静态的，不需要创建实例。

+ 这个似乎用的比较多。

## 总结

工厂模式适合：

+ 凡是出现了大量产品需要被创建，并且拥有共同的接口时，可以通过工厂方法模式进行创建。
+ 一般静态工厂方法模式用的比较多。
