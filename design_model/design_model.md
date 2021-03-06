
# 设计模式

> 从网上看到一篇厉害的博客 [点击前往](http://blog.csdn.net/zhangerqing/article/details/8194653)
> <br/>开始学习**设计模式**，都学了这么就的`java`了，今天才开始学这个重要的。

## 概念

设计模式：

+ 是一套被反复使用，多数人知晓，经过分类编目的，代码设计经验的总结；
+ 使用这个是为了：可重用，容易被他人理解，保证可靠性；

## 一、分类

总体分为三大类：

+ 创建型模式，共五种：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。
+ 结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。
+ 行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

## 二、设计模式六大原则

#### 1.开闭原则（Open Close Principle）

**对扩展开放，对修改关闭**

+ 程序拓展的时候，不能修改原有的代码，实现一个热插拔的效果；

#### 2.里氏代换原则（Liskov Substitution Principle）

+ 任何基类可以出现的地方，子类一定可以出现；
+ LSP是继承复用的基石，只有当衍生类可以替换掉基类，软件的功能不受影响时，基类才能真正复用，而衍生类也能够在基类的基础上增加新的行为。

#### 3、依赖倒转原则（Dependence Inversion Principle）

+ 针对接口编程，依赖抽象而非具体。

#### 4、接口隔离原则（Interface Segregation Principle）

+ 使用多个隔离的接口，比使用单个接口好！
+ 降低依赖，降低耦合！

#### 5、迪米特法则（最少知道原则）（Demeter Principle）

+ 一个实体应该尽量少的与其他实体之间发生相互作用，使得功能模块项目独立。

#### 6、合成复用原则（Composite Reuse Principle）

+ 尽可能使用合成/聚合的方式，而不是使用继承。

## 三、java中的23种设计模式

具体代码具体分析，直接去包里面看。



