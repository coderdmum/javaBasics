   

![image-20211222203051745](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211222203051745.png) 





## 面向对象（上）

**面向过程**，强调的 是功能行为，以函数为最小单位，考虑怎么做

**面向对象**，将功能封装进对 象，强调具备了功能的对象，以类/对象为最小单位，考虑谁来做。

**面向对象的三大特征**

 封装 (Encapsulation)

 继承 (Inheritance) 

多态 (Polymorphism)

**面向对象三大特征的说明**

答：面向对象有三大特点：封装、继承、多态。(如果要回答四个，可加上 抽象性 这一特点)

1.继承性：

继承是一种联结类的层次模型，并且允许和鼓励类的重用，它提供了一种明确表述共性的方法。对象的一个新类可以从现有的类中派生，这个过程称为类继承。新类继承了原始类的特性，新类称为原始类的派生类（子类），而原始类称为新类的基类（父类）。派生类可以从它的基类那里继承方法和实例变量，并且类可以修改或增加新的方法使之更适合特殊的需要。

2.封装性：

封装是把过程和数据包围起来，对数据的访问只能通过已定义的界面。面向对象计算始于这个基本概念，即现实世界可以被描绘成一系列完全自治、封装的对象，这些对象通过一个受保护的接口访问其他对象。

\3. 多态性：

多态性是指允许不同类的对象对同一消息作出响应。多态性包括参数化多态性和包含多态性。多态性语言具有灵活、抽象、行为共享、代码共享的优势，很好的解决了应用程序函数同名问题。

4.抽象性：

抽象就是忽略一个主题中与当前目标无关的那些方面，以便更充分地注意与当前目标有关的方面。抽象并不打算了解全部问题，而只是选择其中的一部分，暂时不用部分细节。抽象包括两个方面，一是过程抽象，二是数据抽象。

```
一、理解“万事万物皆对象”
* 1.在Java语言范畴中，我们都将功能、结构等封装到类中，通过类的实例化，来调用具体的功能结构
*     >Scanner,String等
*     >文件：File
*     >网络资源：URL
* 2.涉及到Java语言与前端Html、后端的数据库交互时，前后端的结构在Java层面交互时，都体现为类、对象。
*
*二、内存解析的说明
*1.引用类型的变量，只可能存储两类值：null  或  地址值（含变量的类型）
*
*三、匿名对象的使用
*1.理解：我们创建的对象，没有显式的赋给一个变量名。即为匿名对象
*2.特征：匿名对象只能调用一次。
```

### 对象的创建和使用：内存解析

**堆（Heap）**，此内存区域的唯一目的 就是**存放对象实例**，几乎所有的对象 实例都在这里分配内存。这一点在 Java虚拟机规范中的描述是：所有的 对象实例以及数组都要在堆上分配。

通常所说的**栈（Stack）**，是指虚拟机 栈。虚拟机栈用于**存储局部变量**等。 局部变量表存放了编译期可知长度的 各种基本数据类型（boolean、byte、 char 、 short 、 int 、 float 、 long 、 double）、对象引用（reference类型， 它不等同于对象本身，是对象在堆内 存的首地址）。 方法执行完，自动释 放。

**方法区（Method Area）**，用于存储**已 被虚拟机加载**的**类信息、常量、静态 变量、即时编译器编译后的代码等数 据**。

![对象的内存解析](D:\BaiduNetdiskDownload\javaweb\java\课件笔记源码资料\新建文件夹\1_课件\第1部分：Java基础编程\第1部分：Java基础编程\尚硅谷_宋红康_第4章_面向对象编程(上)\对象的内存解析.png)

### 方法的重载

```
法的重载（overload）  loading...
* 
* 1.定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。
*  
*  "两同一不同":同一个类、相同方法名
*            参数列表不同：参数个数不同，参数类型不同
* 
* 2. 举例：
*    Arrays类中重载的sort() / binarySearch()
* 
* 3.判断是否是重载：
*    跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系！
*    
* 4. 在通过对象调用方法时，如何确定某一个指定的方法：
*      方法名 ---> 参数列表
```

```
可变个数形参的方法
* 
* 1.jdk 5.0新增的内容
* 2.具体使用：
*   2.1 可变个数形参的格式：数据类型 ... 变量名
*   2.2 当调用可变个数形参的方法时，传入的参数个数可以是：0个，1个,2个，。。。
*   2.3 可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
*   2.4 可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载。换句话说，二者不能共存。
*   2.5 可变个数形参在方法的形参中，必须声明在末尾
*   2.6  可变个数形参在方法的形参中,最多只能声明一个可变形参。
```

### 方法的参数传递



问：当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递?

答：是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的

```
方法的形参的传递机制：值传递
* 
* 1.形参：方法定义时，声明的小括号内的参数
*   实参：方法调用时，实际传递给形参的数据
* 
* 2.值传递机制：
* 如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值。
* 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值。
```

```
关于变量的赋值：
* 
*  如果变量是基本数据类型，此时赋值的是变量所保存的数据值。
*  如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值。
```

### 封装性

```
面向对象的特征一：封装与隐藏     3W:what? why? how?
* 一、问题的引入：
*  当我们创建一个类的对象以后，我们可以通过"对象.属性"的方式，对对象的属性进行赋值。这里，赋值操作要受到
*  属性的数据类型和存储范围的制约。除此之外，没有其他制约条件。但是，在实际问题中，我们往往需要给属性赋值
*  加入额外的限制条件。这个条件就不能在属性声明时体现，我们只能通过方法进行限制条件的添加。（比如：setLegs()）
*  同时，我们需要避免用户再使用"对象.属性"的方式对属性进行赋值。则需要将属性声明为私有的(private).
*  -->此时，针对于属性就体现了封装性。
* 
* 二、封装性的体现：
* 我们将类的属性xxx私有化(private),同时，提供公共的(public)方法来获取(getXxx)和设置(setXxx)此属性的值
* 
*  拓展：封装性的体现：① 如上  ② 不对外暴露的私有的方法  ③ 单例模式   ...
*  
* 
* 三、封装性的体现，需要权限修饰符来配合。
* 1.Java规定的4种权限（从小到大排列）：private、缺省、protected 、public 
* 2.4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
* 3.具体的，4种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
*        修饰类的话，只能使用：缺省、public
* 4.不对外暴露私有的属性和方法
* 5.单例模式（将构造器私有化）
* 总结封装性：Java提供了4种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性的大小。
```

### 构造方法（构造器）

**构造器Constructor是否可被override**

答：构造器Constructor不能被继承，因此不能重写Override，但可以被重载Overload



```
类的结构之三：构造器（或构造方法、constructor）的使用
* construct：建设、建造。  construction:CCB    constructor:建设者
* 
* 一、构造器的作用：
* 1.创建对象
* 2.初始化对象的信息（创建对象时完成一些统一的工作，初始化）
* 
* 二、说明：
* 1.如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
* 2.定义构造器的格式：权限修饰符  类名(形参列表){}
* 3.一个类中定义的多个构造器，彼此构成重载
* 4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
* 5.一个类中，至少会有一个构造器。
```

```java
public class PersonTest {
   public static void main(String[] args) {
      //创建类的对象:new + 构造器
      Person p = new Person();
      p.eat();
      Person p1 = new Person("Tom");
      System.out.println(p1.name);
   }
}
class Person{
   //属性
   String name;
   int age;
   
   //构造器
   public Person(){
      System.out.println("Person().....");
   }
   
   public Person(String n){
      name = n;
      
   }
//
   public Person(String n,int a){
      name = n;
      age = a;
   } 
   //方法
   public void eat(){
      System.out.println("人吃饭");
   }
   public void study(){
      System.out.println("人可以学习");
   }
}
```



```
总结：属性赋值的先后顺序
* ① 默认初始化
* ② 显式初始化
* ③ 构造器中初始化
*
* ④ 通过"对象.方法" 或 "对象.属性"的方式，赋值
* 
* 以上操作的先后顺序：① - ② - ③ - ④  
```

```java
* JavaBean是一种Java语言写成的可重用组件。

   所谓JavaBean，是指符合如下标准的Java类：
      >类是公共的
      >有一个无参的公共的构造器
      >有属性，且有对应的get、set方法
 * 
 */
public class Customer {
   
   private int id;
   private String name;
   
   public Customer(){
      
   }
   
   public void setId(int i){
      id = i;
   }
   public int getId(){
      return id;
   }
   public void setName(String n){
      name = n;
   }
   public String getName(){
      return name;
   } 
}
```

### 四种权限修饰符

| 修饰符    | 类内部 | 同一个包 | 不同包的子类 | 同一个工程 |
| --------- | ------ | -------- | ------------ | :--------- |
| private   | Yes    |          |              |            |
| (缺省)    | Yes    | Yes      |              |            |
| protected | Yes    | Yes      | Yes          |            |
| public    | Yes    | Yes      | Yes          | Yes        |

对于class的权限修饰只可以用public和default(缺省)。 

1.  public类可以在任意地方被访问。 
2.  default类只可以被同一个包内部的类访问。

### 关键字this

```
* this关键字的使用：
* 1.this可以用来修饰、调用：属性、方法、构造器
* 
* 2.this修饰属性和方法：
*   this理解为：当前对象  或 当前正在创建的对象
* 
*  2.1  在类的方法中，我们可以使用"this.属性"或"this.方法"的方式，调用当前对象属性或方法。但是，
*   通常情况下，我们都选择省略"this."。特殊情况下，如果方法的形参和类的属性同名时，我们必须显式
*   的使用"this.变量"的方式，表明此变量是属性，而非形参。
* 
*  2.2 在类的构造器中，我们可以使用"this.属性"或"this.方法"的方式，调用当前正在创建的对象属性或方法。
*  但是，通常情况下，我们都选择省略"this."。特殊情况下，如果构造器的形参和类的属性同名时，我们必须显式
*   的使用"this.变量"的方式，表明此变量是属性，而非形参。
* 
* 3. this调用构造器
*    ① 我们在类的构造器中，可以显式的使用"this(形参列表)"方式，调用本类中指定的其他构造器
*    ② 构造器中不能通过"this(形参列表)"方式调用自己
*    ③ 如果一个类中有n个构造器，则最多有 n - 1构造器中使用了"this(形参列表)"
*    ④ 规定："this(形参列表)"必须声明在当前构造器的首行
*    ⑤ 构造器内部，最多只能声明一个"this(形参列表)"，用来调用其他的构造器
```

```java
public class PersonTest {
   public static void main(String[] args) {
      
      Person p1 = new Person();
      
      p1.setAge(1);
      System.out.println(p1.getAge());
      
      p1.eat();
      
      System.out.println();
      
      Person p2 = new Person("Jerry",20);
      System.out.println(p2.getAge());
      
   }
}

class Person{
   
   private String name;
   private int age;
   
   
   public Person(){
      
//    this.eat();
      String info = "Person初始化时，需要考虑如下的1,2,3,4...(共40行代码)";
      System.out.println(info);
   }
   
   public Person(String name){
      this();
      this.name = name;
      
   }
   
   public Person(int age){
      this();
      this.age = age;
      
   }
   
   public Person(String name,int age){
      this(age);
      this.name = name;
      //this.age = age;
      //Person初始化时，需要考虑如下的1,2,3,4...(共40行代码)
   }
   
   public void setName(String name){
      this.name = name;
   }
   public String getName(){
      return this.name;
   }
   public void setAge(int age){
      this.age = age;
   }
   public int getAge(){
      return this.age;
   }
   
   public void eat(){
      System.out.println("人吃饭");
      this.study();
   }
   public void study(){
      System.out.println("人学习");
   }
   
}
```



```
JAVAbean
* JavaBean是一种Java语言写成的可重用组件。

所谓JavaBean，是指符合如下标准的Java类：
   >类是公共的
   >有一个无参的公共的构造器
   >有属性，且有对应的get、set方法
```













## 面向对象（中）

### 继承性

```
面向对象的特征之二：继承性    why?

 * 
 * 一、继承性的好处：
 * 继承的出现减少了代码冗余，提高了代码的复用性。
 * 继承的出现，更有利于功能的扩展。
 *  继承的出现让类与类之间产生了关系，提供了多态的前提。
 * 
 * 二、继承性的格式： 
 * class A extends B{}
 * A:子类、派生类、subclass
 * B:父类、超类、基类、superclass
 * 2.1体现：一旦子类A继承父类B以后，子类A中就获取了父类B中声明的所有的属性和方法。
 
 * 子类不能直接访问父类中私有的(private)的成员变量和方法。
 * 特别的，父类中声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构。
 * 只有因为封装性的影响，使得子类不能直接调用父类的结构而已。
 * 2.2 子类继承父类以后，还可以声明自己特有的属性或方法：实现功能的拓展。
 * 子类和父类的关系，不同于子集和集合的关系。
 * extends：延展、扩展
  * 三、Java中关于继承性的规定：
 * 1.一个类可以被多个子类继承。
 * 2.Java中类的单继承性：一个类只能有一个父类
   ****JAVA中实现多继承的方法是--使用接口
 * 3.子父类是相对的概念。
 * 4.子类直接继承的父类，称为：直接父类。间接继承的父类称为：间接父类
 * 5.子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法
 * 
 * 四、 1. 如果我们没有显式的声明一个类的父类的话，则此类继承于java.lang.Object类
 * 2. 所有的java类（除java.lang.Object类之外）都直接或间接的继承于java.lang.Object类
 * 3. 意味着，所有的java类具有java.lang.Object类声明的功能。
```



### 重写

```
方法的重写(override / overwrite)
* 
* 1.重写：子类继承父类以后，可以对父类中同名同参数的方法，进行覆盖操作
* 
* 2.应用：重写以后，当创建子类对象以后，通过子类对象调用子父类中的同名同参数的方法时，实际执行的是子类重写父类的方法。
* 
* 3. 重写的规定：
*        方法的声明： 权限修饰符  返回值类型  方法名(形参列表) throws 异常的类型{
*                 //方法体
*              }
*        约定俗称：子类中的叫重写的方法，父类中的叫被重写的方法
*     ① 子类重写的方法的方法名和形参列表与父类被重写的方法的方法名和形参列表相同
*      ② 子类重写的方法的权限修饰符不小于父类被重写的方法的权限修饰符
*          >特殊情况：子类不能重写父类中声明为private权限的方法
*      ③ 返回值类型：
*          >父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型只能是void
*          >父类被重写的方法的返回值类型是A类型，则子类重写的方法的返回值类型可以是A类或A类的子类
*          >父类被重写的方法的返回值类型是基本数据类型(比如：double)，则子类重写的方法的返回值类型必须是相同的基本数据类型(必须也是double)
*     ④ 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型（具体放到异常处理时候讲）
*  **********************************************************************
*     子类和父类中的同名同参数的方法要么都声明为非static的（考虑重写），要么都声明为static的（不是重写）。   
*
* 面试题：区分方法的重载与重写
```

 面试题：区分方法的重载与重写



### 关键字super

```
 *
 * super关键字的使用
 * 1.super理解为：父类的
 * 2.super可以用来调用：属性、方法、构造器
 * 
 * 3.super的使用：调用属性和方法
 * 
 *   3.1 我们可以在子类的方法或构造器中。通过使用"super.属性"或"super.方法"的方式，显式的调用
 *   父类中声明的属性或方法。但是，通常情况下，我们习惯省略"super."
 *   3.2 特殊情况：当子类和父类中定义了同名的属性时，我们要想在子类中调用父类中声明的属性，则必须显式的
 *   使用"super.属性"的方式，表明调用的是父类中声明的属性。
 *   3.3 特殊情况：当子类重写了父类中的方法以后，我们想在子类的方法中调用父类中被重写的方法时，则必须显式的
 *   使用"super.方法"的方式，表明调用的是父类中被重写的方法。
 * 
 * 4.super调用构造器
 * 	 4.1  我们可以在子类的构造器中显式的使用"super(形参列表)"的方式，调用父类中声明的指定的构造器
 *   4.2 "super(形参列表)"的使用，必须声明在子类构造器的首行！
 *   4.3 我们在类的构造器中，针对于"this(形参列表)"或"super(形参列表)"只能二选一，不能同时出现
 *   4.4 在构造器的首行，没有显式的声明"this(形参列表)"或"super(形参列表)"，则默认调用的是父类中空参的构造器：super()
 *   4.5 在类的多个构造器中，至少有一个类的构造器中使用了"super(形参列表)"，调用父类中的构造器
 */
```

super和this的区别（个人理解）

super：可省，命名冲突时，直接找父类中的属性或方法，再往上（父类中）

this：可省，当命名冲突时，首先在当前类中找相关属性和方法再往上（父类中）

```java
public class Person {
	String name;
	int age;
	int id = 1001;//身份证号
	
	public Person(){
		System.out.println("我无处不在！");
	}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(String name,int age){
		this(name);
		this.age = age;
	}
	
	public void eat(){
		System.out.println("人：吃饭");
	}
	public void walk(){
		System.out.println("人：走路");
	}
}
```



```java
public class Student extends Person{
	
	String major;
	int id = 1002;//学号
	
	public Student(){
		super();
	}
	public Student(String major){
		super();
		this.major = major;
	}
	
	public Student(String name,int age,String major){
//		this.name = name;
//		this.age = age;
		super(name,age);
		this.major = major;
	}
	
	@Override
	public void eat() {
		System.out.println("学生：多吃有营养的食物");
	}
	
	public void study(){
		System.out.println("学生：学习知识");
		this.eat();
		super.eat();
		walk();
	}
	
	public void show(){
		System.out.println("name = " + name + ", age = " + age);
		System.out.println("id = " + this.id);
		System.out.println("id = " + super.id);
	}
}
```



```java
public class SuperTest {
	public static void main(String[] args) {
		
		Student s = new Student();
		s.show();
		
		System.out.println();
		
		s.study();
		
		Student s1 = new Student("Tom", 21, "IT");
		s1.show();
		
		System.out.println("************");
		Student s2 = new Student();
		
	}
}
```

### 子类对象实例化

```
* 子类对象实例化的全过程
 * 
 * 1. 从结果上来看：（继承性）
 * 		子类继承父类以后，就获取了父类中声明的属性或方法。
 *      创建子类的对象，在堆空间中，就会加载所有父类中声明的属性。
 * 
 * 2. 从过程上来看：
 * 		当我们通过子类的构造器创建子类对象时，我们一定会直接或间接的调用其父类的构造器，进而调用父类的父类的构造器，...
 *    直到调用了java.lang.Object类中空参的构造器为止。正因为加载过所有的父类的结构，所以才可以看到内存中有
 *    父类中的结构，子类对象才可以考虑进行调用。
 *    
 *  
 * 明确：虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象。
 * 
```

<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211201141431679.png" alt="image-20211201141431679" style="zoom: 80%;" />

![image-20211203094150166](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211203094150166.png)

### 多态性（难理解）

```
*
 * 面向对象特征之三：多态性
 * 
 * 1.理解多态性：可以理解为一个事物的多种形态。
 * 2.何为多态性：
 *   对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 *   
 * 3. 多态的使用：虚拟方法调用
 *   有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。
 *   总结：编译，看左边；运行，看右边。
 *   
 * 4.多态性的使用前提：  ① 类的继承关系  ② 方法的重写
 * 
 * 5.对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）
```

```java
//多态性的使用举例一：
public class AnimalTest {
	
	public static void main(String[] args) {
		
		AnimalTest test = new AnimalTest();
		test.func(new Dog());//"狗吃骨头 汪！汪！汪！
		
		
		test.func(new Cat());//猫吃鱼，喵喵喵
	}
	
	public void func(Animal animal){//Animal animal = new Dog();
		animal.eat();
		animal.shout();
		
		if(animal instanceof Dog){
			Dog d = (Dog)animal;
			d.watchDoor();
		}
	}
	
//	public void func(Dog dog){
//		dog.eat();
//		dog.shout();
//	}
//	public void func(Cat cat){
//		cat.eat();
//		cat.shout();
//	}
}


class Animal{
	
	
	public void eat(){
		System.out.println("动物：进食");
	}
	
	public void shout(){
		System.out.println("动物：叫");
	}
	
	
}

class Dog extends Animal{
	public void eat(){
		System.out.println("狗吃骨头");
	}
	
	public void shout(){
		System.out.println("汪！汪！汪！");
	}
	
	public void watchDoor(){
		System.out.println("看门");
	}
}
class Cat extends Animal{
	public void eat(){
		System.out.println("猫吃鱼");
	}
	
	public void shout(){
		System.out.println("喵！喵！喵！");
	}
}

//举例二：

class Order{
	
	public void method(Object obj){
		
	}
}

//举例三：
class Driver{
	
	public void doData(Connection conn){//conn = new MySQlConnection(); / conn = new OracleConnection();
		//规范的步骤去操作数据
//		conn.method1();
//		conn.method2();
//		conn.method3();
		
	}
	
}
```



```
正常的方法调用
Person e = new Person();
e.getInfo();
Student e = new Student();
e.getInfo();
***虚拟方法调用(多态情况下)
子类中定义了与父类同名同参数的方法，在多态情况下，将此时父类的方法称为虚拟方法，父
类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译期是无法
确定的。
Person e = new Student();
e.getInfo(); //调用Student类的getInfo()方法
***编译时类型和运行时类型
编译时e为Person类型，而方法的调用是在运行时确定的，所以调用的是Student类
的getInfo()方法。——动态绑定
```

**多态是运行时行为**

虚拟方法调用

```java
import java.util.Random;

//面试题：多态是编译时行为还是运行时行为？
//证明如下：
class Animal  {
 
	protected void eat() {
		System.out.println("animal eat food");
	}
}

class Cat  extends Animal  {
 
	protected void eat() {
		System.out.println("cat eat fish");
	}
}

class Dog  extends Animal  {
 
	public void eat() {
		System.out.println("Dog eat bone");

	}

}

class Sheep  extends Animal  {
 

	public void eat() {
		System.out.println("Sheep eat grass");

	}

 
}

public class InterviewTest {

	public static Animal  getInstance(int key) {
		switch (key) {
		case 0:
			return new Cat ();
		case 1:
			return new Dog ();
		default:
			return new Sheep ();
		}

	}

	public static void main(String[] args) {
		int key = new Random().nextInt(3);

		System.out.println(key);

		Animal  animal = getInstance(key);
		
		animal.eat();
		 
	}

}
```

### 方法的重载与重写

1. 二者的定义细节：

   重载：**在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可**。

   重写：**子类继承父类以后，可以对父类中同名同参数的方法，进行覆盖操作**

2. 从编译和运行的角度看： 重载，是指允许存在多个同名方法，而这些方法的参数不同。编译器根据方法不 同的参数表，对同名方法的名称做修饰。对于编译器而言，这些同名方法就成了 不同的方法。它们的调用地址在编译期就绑定了。Java的重载是可以包括父类 和子类的，即子类可以重载父类的同名不同参数的方法。 

   所以：

   **对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法， 这称为“早绑定”或“静态绑定”；** 

   而**对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要调用的具体 方法，这称为“晚绑定”或“动态绑定”。** 

   引用一句Bruce Eckel的话：“不要犯傻，如果它不是晚绑定，它就不是多态。”



### 多态(向上转型)，向下转型

**instanceof关键字的使用**

```
//如何才能调用子类特有的属性和方法？
      //向下转型：使用强制类型转换符。
      Man m1 = (Man)p2;
      m1.earnMoney();
      m1.isSmoking = true;
      
      //使用强转时，可能出现ClassCastException的异常。
//    Woman w1 = (Woman)p2;
//    w1.goShopping();
      
      /*
       * instanceof关键字的使用
       * 
       * a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false。
       * 
       * 
       *  使用情境：为了避免在向下转型时出现ClassCastException的异常，我们在向下转型之前，先
       *  进行instanceof的判断，一旦返回true，就进行向下转型。如果返回false，不进行向下转型。
       *  
       *  如果 a instanceof A返回true,则 a instanceof B也返回true.
       *  其中，类B是类A的父类。
```

```
 * 1.若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，
 * 系统将不可能把父类里的方法转移到子类中：编译看左边，运行看右边
 * 
 * 2.对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，
 * 这个实例变量依然不可能覆盖父类中定义的实例变量：编译运行都看左边
```

### Object类的使用

```
* java.lang.Object类
 * 1.Object类是所有Java类的根父类
 * 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类 
 * 3.Object类中的功能(属性、方法)就具有通用性。
 * 	属性：无
 *  方法：equals() / toString() / getClass() /hashCode() / clone() / finalize()（垃圾回收机制的方法，一般不主动调）
 *     wait() 、 notify()、notifyAll()
 * 
 * 4. Object类只声明了一个空参的构造器
 * 
 * 面试题：
 * final、finally、finalize的区别？
```

### == 和equals()区别

```java

/*
 * 
 * 面试题： == 和 equals() 区别
 * 
 * 一、回顾 == 的使用：
 * == ：运算符
 * 1. 可以使用在基本数据类型变量和引用数据类型变量中
 * 2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *    如果比较的是引用数据类型变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 补充： == 符号使用时，必须保证符号左右两边的变量类型一致。
 * 
 * 二、equals()方法的使用：
 * 1. 是一个方法，而非运算符
 * 2. 只能适用于引用数据类型
 * 3. Object类中equals()的定义：
 *    public boolean equals(Object obj) {
	        return (this == obj);
	  }
 *    说明：Object类中定义的equals()和==的作用是相同的：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 
 * 4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是
 *    两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同。
 *    
 * 5. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们
 *    就需要对Object类中的equals()进行重写.
 *    重写的原则：比较两个对象的实体内容是否相同.
 */
public class EqualsTest {
	public static void main(String[] args) {
		
		//基本数据类型
		int i = 10;
		int j = 10;
		double d = 10.0;
		System.out.println(i == j);//true
		System.out.println(i == d);//true
		
		boolean b = true;
//		System.out.println(i == b);
		
		char c = 10;
		System.out.println(i == c);//true
		
		char c1 = 'A';
		char c2 = 65;
		System.out.println(c1 == c2);//true
		
		//引用类型：
		Customer cust1 = new Customer("Tom",21);
		Customer cust2 = new Customer("Tom",21);
		System.out.println(cust1 == cust2);//false
		
		String str1 = new String("atguigu");
		String str2 = new String("atguigu");
		System.out.println(str1 == str2);//false
		System.out.println("****************************");
		System.out.println(cust1.equals(cust2));//false--->true
		System.out.println(str1.equals(str2));//true
		
		Date date1 = new Date(32432525324L);
		Date date2 = new Date(32432525324L);
		System.out.println(date1.equals(date2));//true
		
		
	}
}

```

**重写equals()方法的原则**

```
对称性：如果x.equals(y)返回是“true” ，那么y.equals(x)也应该返回是 “true”。 

自反性：x.equals(x)必须返回是“true”。

传递性：如果x.equals(y)返回是“true” ，而且y.equals(z)返回是“true” ， 那么z.equals(x)也应该返回是“true”。 

一致性：如果x.equals(y)返回是“true” ，只要x和y内容一直不变，不管你 重复x.equals(y)多少次，返回都是“true”。 

任何情况下，x.equals(null)，永远返回是“false” ； x.equals(和x不同类型的对象)永远返回是“false”
```



### toString()

```
/*
 * Object类中toString()的使用：
 * 
 * 1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 * 
 * 2. Object类中toString()的定义：
 *   public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
     }
 * 
 * 3. 像String、Date、File、包装类等都重写了Object类中的toString()方法。
 *    使得在调用对象的toString()时，返回"实体内容"信息
 *    
 * 4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
 */
public class ToStringTest {
	public static void main(String[] args) {
		
		Customer cust1 = new Customer("Tom",21);
		System.out.println(cust1.toString());//com.atguigu.java1.Customer@15db9742-->Customer[name = Tom,age = 21]
		System.out.println(cust1);//com.atguigu.java1.Customer@15db9742-->Customer[name = Tom,age = 21]
		
		String str = new String("MM");
		System.out.println(str);//MM
		
		Date date = new Date(4534534534543L);
		System.out.println(date.toString());//Mon Sep 11 08:55:34 GMT+08:00 2113
		
	}
}

```

### final, finaly,,finalize

finally：是try-catch异常类中一定会执行的代码

finalize：是方法名

### 单元测试

![image-20211206090946241](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211206090946241.png)

### 包装类

```java
package com.coderm.basics.javaBasics.day05.wrapper;

import org.junit.Test;

/*
 * 包装类的使用:
 * 1.java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 * 
 * 2.掌握的：基本数据类型、包装类、String三者之间的相互转换
 * 
 * 
 * 
 */
public class WrapperTest {
   
   //String类型 --->基本数据类型、包装类：调用包装类的parseXxx(String s)
   @Test
   public void test5(){
      String str1 = "123";
      //错误的情况：
//    int num1 = (int)str1;
//    Integer in1 = (Integer)str1;
      //可能会报NumberFormatException
      int num2 = Integer.parseInt(str1);
      System.out.println(num2 + 1);
      
      String str2 = "true1";
      boolean b1 = Boolean.parseBoolean(str2);
      System.out.println(b1);
   }
   
   //基本数据类型、包装类--->String类型：调用String重载的valueOf(Xxx xxx)
   @Test
   public void test4(){
      
      int num1 = 10;
      //方式1：连接运算
      String str1 = num1 + "";
      //方式2：调用String的valueOf(Xxx xxx)
      float f1 = 12.3f;
      String str2 = String.valueOf(f1);//"12.3"
      
      Double d1 = new Double(12.4);
      String str3 = String.valueOf(d1);
      System.out.println(str2);
      System.out.println(str3);//"12.4"
      
   }
   
   /*
    * 基本数据类型《==》包装类JDK 5.0 新特性：自动装箱 与自动拆箱
    */
   @Test
   public void test3(){
//    int num1 = 10;
//    //基本数据类型-->包装类的对象
//    method(num1);
      
      //自动装箱：基本数据类型 --->包装类
      int num2 = 10;
      Integer in1 = num2;//自动装箱
      
      boolean b1 = true;
      Boolean b2 = b1;//自动装箱
      
      //自动拆箱：包装类--->基本数据类型
      System.out.println(in1.toString());
      
      int num3 = in1;//自动拆箱
      
   }
   
   public void method(Object obj){
      System.out.println(obj);
   }
   
   //包装类--->基本数据类型:调用包装类Xxx的xxxValue()
   @Test
   public void test2(){
      Integer in1 = new Integer(12);
      
      int i1 = in1.intValue();
      System.out.println(i1 + 1);
      
      
      Float f1 = new Float(12.3);
      float f2 = f1.floatValue();
      System.out.println(f2 + 1);
   }
   
   //基本数据类型 --->包装类：调用包装类的构造器
   @Test
   public void test1(){
      
      int num1 = 10;
//    System.out.println(num1.toString());
      Integer in1 = new Integer(num1);
      System.out.println(in1.toString());
      
      Integer in2 = new Integer("123");
      System.out.println(in2.toString());
      
      //报异常
//    Integer in3 = new Integer("123abc");
//    System.out.println(in3.toString());
      
      Float f1 = new Float(12.3f);
      Float f2 = new Float("12.3");
      System.out.println(f1);
      System.out.println(f2);
      
      Boolean b1 = new Boolean(true);
      Boolean b2 = new Boolean("TrUe");
      System.out.println(b2);
      Boolean b3 = new Boolean("true123");
      System.out.println(b3);//false
      
      
      Order order = new Order();
      System.out.println(order.isMale);//false
      System.out.println(order.isFemale);//null
   }
   
}

class Order{
   
   boolean isMale;
   Boolean isFemale;
}
```

```java
/*
 * 关于包装类使用的面试题
 * 
 * 
 */
public class InterviewTest {


   public void test1() {
      Object o1 = true ? new Integer(1) : new Double(2.0);
      System.out.println(o1);// 1.0

   }

   public void test2() {
      Object o2;
      if (true)
         o2 = new Integer(1);
      else
         o2 = new Double(2.0);
      System.out.println(o2);// 1

   }


   public void test3() {
      Integer i = new Integer(1);
      Integer j = new Integer(1);
      System.out.println(i == j);//false
      
      //Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
      //保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在
      //-128~127范围内时，可以直接使用数组中的元素，不用再去new了。目的：提高效率
      
      Integer m = 1;
      Integer n = 1;
      System.out.println(m == n);//true

      Integer x = 128;//相当于new了一个Integer对象
      Integer y = 128;//相当于new了一个Integer对象
      System.out.println(x == y);//false
   }

}
```



















## 面向对象（下）

### static

静态方法中，只能调用静态的方法或属性   

```
/*
 * static关键字的使用
 * 
 * 1.static:静态的
 * 2.static可以用来修饰：属性、方法、代码块、内部类
 * 
 * 3.使用static修饰属性：静态变量（或类变量）
 *        3.1 属性，按是否使用static修饰，又分为：静态属性  vs 非静态属性(实例变量)
 *           实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象中的
 *              非静态属性时，不会导致其他对象中同样的属性值的修改。
 *       静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致
 *              其他对象调用此静态变量时，是修改过了的。
 *        3.2 static修饰属性的其他说明：
 *           ① 静态变量随着类的加载而加载。可以通过"类.静态变量"的方式进行调用
 *          ② 静态变量的加载要早于对象的创建。
 *          ③ 由于类只会加载一次，则静态变量在内存中也只会存在一份：存在方法区的静态域中。
 *          
 *          ④     类变量    实例变量
 *          类     yes       no
 *          对象    yes       yes
 *          
 *      3.3 静态属性举例：System.out; Math.PI;
 * 
 * 4.使用static修饰方法：静态方法
 *        ① 随着类的加载而加载，可以通过"类.静态方法"的方式进行调用
 *        ②        静态方法   非静态方法
 *          类     yes       no
 *          对象    yes       yes
 *        ③ 静态方法中，只能调用静态的方法或属性
 *        非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
 * 
 * 5. static注意点：
 *    5.1 在静态的方法内，不能使用this关键字、super关键字
 *    5.2 关于静态属性和静态方法的使用，大家都从生命周期的角度去理解。
 *    
 * 6. 开发中，如何确定一个属性是否要声明为static的？
 *        > 属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
 *        > 类中的常量也常常声明为static
 * 
 *    开发中，如何确定一个方法是否要声明为static的？
 *     > 操作静态属性的方法，通常设置为static的
 *      > 工具类中的方法，习惯上声明为static的。 比如：Math、Arrays、Collections
 */
public class StaticTest {
   public static void main(String[] args) {
      
      Chinese.nation = "中国";
      
      
      Chinese c1 = new Chinese();
      c1.name = "姚明";
      c1.age = 40;
      c1.nation = "CHN";
      
      Chinese c2 = new Chinese();
      c2.name = "马龙";
      c2.age = 30;
      c2.nation = "CHINA";
      
      System.out.println(c1.nation);
      
      //编译不通过
//    Chinese.name = "张继科";
      
      
      c1.eat();
      
      Chinese.show();
      //编译不通过
//    Chinese.eat();
//    Chinese.info();
   }
}
//中国人
class Chinese{
   
   String name;
   int age;
   static String nation;
   
   
   public void eat(){
      System.out.println("中国人吃中餐");
      //调用非静态结构
      this.info();
      System.out.println("name :" +name);
      //调用静态结构
      walk();
      System.out.println("nation : " + nation);
   }
   
   public static void show(){
      System.out.println("我是一个中国人！");
      //不能调用非静态的结构
//    eat();
//    name = "Tom";
      //可以调用静态的结构
      System.out.println(Chinese.nation);
      walk();
   }
   
   public void info(){
      System.out.println("name :" + name +",age : " + age);
   }
   
   public static void walk(){
      
   }
}
```

![image-20211206100149251](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211206100149251.png)

### 单例（Singleton）设计模式

​        所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，**对 某个类只能存在一个对象实例**，并且该类只提供一个取得其对象实例的方法。 如果我们要让类在一个虚拟机中只能产生一个对象，我们首先**必须将类的构 造器的访问权限设置为private**，这样，就不能用new操作符在类的外部产生 类的对象了，但在类内部仍可以产生该类的对象。因为在类的外部开始还无 法得到类的对象，**只能调用该类的某个静态方法**以返回类内部创建的对象， 静态方法只能访问类中的静态成员变量，所以，指向类内部产生的**该类对象 的变量也必须定义成静态的**。

```java
* 单例设计模式：
* 1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。
* 
* 2. 如何实现？
*   饿汉式  vs 懒汉式
* 
* 3. 区分饿汉式 和 懒汉式
*   饿汉式：   
*      坏处：对象加载时间过长。
*      好处：饿汉式是线程安全的
*   
*   懒汉式：好处：延迟对象的创建。
*       目前的写法坏处：线程不安全。--->到多线程内容时，再修改
```

**单例模式的优点：** 由于单例模式只生成一个实例，减少了系统性能开销，当一个对象的 产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可 以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方 式来解决。

**应用场景：**

- **网站的计数器**，一般也是单例模式实现，否则难以同步。
-  **应用程序的日志应用**，一般都使用单例模式实现，这一般是由于共享的日志 文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。 
-  **数据库连接池**的设计一般也是采用单例模式，因为数据库连接是一种数据库 资源。
-  项目中，**读取配置文件的类**，一般也只有一个对象。没有必要每次使用配置 文件数据，都生成一个对象去读取。
-  **Application** 也是单例的典型应用 
-  Windows的**Task Manager (任务管理器)**就是很典型的单例模式 
-  Windows的**Recycle Bin (回收站**)也是典型的单例应用。在整个系统运行过程 中，回收站一直维护着仅有的一个实例

#### 饿汉式

开始就将对象造好

```java
class Singleton {
   // 1.私有化构造器
   private Singleton() {
   }
   // 2.内部提供一个当前类的实例
       // 4.此实例也必须静态化
   private static Singleton single = new Singleton();
   // 3.提供公共的静态的方法，返回当前类的对象
   public static Singleton getInstance() {
      return single;
   }
}
```

#### 懒汉式

加载时再造对象

```java
class Singleton {
   // 1.私有化构造器
   private Singleton() {
   }
   // 2.内部提供一个当前类的实例
       // 4.此实例也必须静态化
   private static Singleton single;
   // 3.提供公共的静态的方法，返回当前类的对象
   public static Singleton getInstance() {
      if(single == null) {
         single = new Singleton();
      }
      return single;
   }
}
```

### **main()方法**

```
* main()方法的使用说明：
* 1. main()方法作为程序的入口
* 2. main()方法也是一个普通的静态方法
* 3. main()方法可以作为我们与控制台交互的方式。（之前：使用Scanner）
```

### 代码块

```java
* 类的成员之四：代码块（或初始化块）
* 
* 1. 代码块的作用：用来初始化类、对象
* 2. 代码块如果有修饰的话，只能使用static.
* 3. 分类：静态代码块  vs 非静态代码块
* 
* 4. 静态代码块
*     >内部可以有输出语句
*     >随着类的加载而执行,而且只执行一次
*     >作用：初始化类的信息
*     >如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
*     >静态代码块的执行要优先于非静态代码块的执行
*     >静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构
* 
* 5. 非静态代码块
*     >内部可以有输出语句
*     >随着对象的创建而执行
*     >每创建一个对象，就执行一次非静态代码块
*     >作用：可以在创建对象时，对对象的属性等进行初始化
*     >如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
*     >非静态代码块内可以调用静态的属性、静态的方法，或非静态的属性、非静态的方法
* 
*/
public class BlockTest {
	public static void main(String[] args) {
		
		String desc = Person.desc;
		System.out.println(desc);
		
		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p1.age);
		
		Person.info();
	}
}


class Person{
	//属性
	String name;
	
	int age;

	static String desc = "我是一个人";
	
	//构造器
	public Person(){
		
	}
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	//非static的代码块
	{
		System.out.println("hello, block - 2");
	}
	{
		System.out.println("hello, block - 1");
		//调用非静态结构
		age = 1;
		eat();
		//调用静态结构
		desc = "我是一个爱学习的人1";
		info();
	}
	//static的代码块
	static{
		System.out.println("hello,static block-2");
	}
	static{
		System.out.println("hello,static block-1");
		//调用静态结构
		desc = "我是一个爱学习的人";
		info();
		//不可以调用非静态结构
//		eat();
//		name = "Tom";
	}
	
	//方法
	public void eat(){
		System.out.println("吃饭");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public static void info(){
		System.out.println("我是一个快乐的人！");
	}
	
}
```

由父及子，静态先行

```
/*
 * 对属性可以赋值的位置：
 * ①默认初始化
 * ②显式初始化/⑤在代码块中赋值
 * ③构造器中初始化
 * ④有了对象以后，可以通过"对象.属性"或"对象.方法"的方式，进行赋值
 * 
 * 
 * 执行的先后顺序：① - ② / ⑤ - ③ - ④
 */


public class OrderTest {
   public static void main(String[] args) {
      Order order = new Order();
      System.out.println(order.orderId);
   }
}

class Order{
   int orderId = 3;
   {
      orderId = 4;
   }
}
```

### final关键字

```
* final:最终的
* 
* 1. final可以用来修饰的结构：类、方法、变量
* 
* 2. final 用来修饰一个类:此类不能被其他类所继承。
*          比如：String类、System类、StringBuffer类
* 
* 3. final 用来修饰方法：表明此方法不可以被重写
*        比如：Object类中getClass();
* 
* 4. final 用来修饰变量：此时的"变量"就称为是一个常量
*      4.1 final修饰属性：可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
*     4.2 final修饰局部变量：
*           尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参。一旦赋值
*           以后，就只能在方法体内使用此形参，但不能进行重新赋值。
*           
*  static final 用来修饰属性：全局常量
```

###  抽象类和抽象方法

随着继承层次中一个个新子类的定义，类变得越来越具体，而父类则更一般，更通用。类的设计应该保证父类和子类能够共享特征。有时将一个父类设计得非常抽象，以至于它没有具体的实例，这样的类叫做**抽象类**。

```
* abstract关键字的使用
* 1.abstract:抽象的
* 2.abstract可以用来修饰的结构：类、方法
* 
* 3. abstract修饰类：抽象类
*     > 此类不能实例化
*      > 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
*      > 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作
* 
* 
* 4. abstract修饰方法：抽象方法
*     > 抽象方法只有方法的声明，没有方法体
*     > 包含抽象方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的。
*      > 若子类重写了父类中的所有的抽象方法后，此子类方可实例化
*        若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰
```

```java
* abstract使用上的注意点：
* 1.abstract不能用来修饰：属性、构造器等结构
* 
* 2.abstract不能用来修饰私有方法、静态方法、final的方法、final的类
```

**为什么抽象类不可以使用final关键字声明？**

抽象类都会提供抽象类的子类，让子类对象实例化，完成相关的操作

但final不可以继承和重写

```java
public class AbstractTest {
   public static void main(String[] args) {
   
      //一旦Person类抽象了，就不可实例化
//    Person p1 = new Person();
//    p1.eat();
      
   }
}

abstract class Creature{
   public abstract void breath();
}

abstract class Person extends Creature{
   String name;
   int age;
   
   public Person(){
      
   }
   public Person(String name,int age){
      this.name = name;
      this.age = age;
   }
   
   //不是抽象方法：
// public void eat(){
//    
// }
   //抽象方法
   public abstract void eat();
   
   public void walk(){
      System.out.println("人走路");
   }
   
   
}

class Student extends Person{
   
   public Student(String name,int age){
      super(name,age);
   }
   public Student(){
   }
   
   public void eat(){
      System.out.println("学生多吃有营养的食物");
   }

   @Override
   public void breath() {
      System.out.println("学生应该呼吸新鲜的没有雾霾的空气");
   }
}
```

### 抽象类的匿名子类的使用

```java
public class Num {

}

abstract class Creature{
	public abstract void breath();
}

abstract class Person extends Creature{
	String name;
	int age;
	
	public Person(){
		
	}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	//不是抽象方法
//	public void eat(){
//		System.out.println("人吃饭");
//	}
	
	//抽象方法
	public abstract void eat();
	
	public void walk(){
		System.out.println("人走路");
	}
}

class Student extends Person{
	public Student(String name,int age){
		super(name,age);
	}
	public Student(){

	}
	public void eat(){
		System.out.println("学生应该多吃有营养的。");
	}
	@Override
	public void breath() {
		System.out.println("学生应该呼吸新鲜的无雾霾空气");
	}
}
```



```java
/*
 * 抽象类的匿名子类
 * 
 */
public class PersonTest {
   
   public static void main(String[] args) {
      
      method(new Student());//匿名对象
      
      Worker worker = new Worker();
      method1(worker);//非匿名的类非匿名的对象
      
      method1(new Worker());//非匿名的类匿名的对象
      
      System.out.println("********************");
      
      //创建了一匿名子类的对象：p
      Person p = new Person(){

         @Override
         public void eat() {
            System.out.println("吃东西");
         }

         @Override
         public void breath() {
            System.out.println("好好呼吸");
         }
         
      };
      
      method1(p);
      System.out.println("********************");
      //创建匿名子类的匿名对象
      method1(new Person(){
         @Override
         public void eat() {
            System.out.println("吃好吃东西");
         }

         @Override
         public void breath() {
            System.out.println("好好呼吸新鲜空气");
         }
      });
   }
   
   
   public static void method1(Person p){
      p.eat();
      p.breath();
   }
   
   public static void method(Student s){
      
   }
}

class Worker extends Person{

   @Override
   public void eat() {
   }

   @Override
   public void breath() {
   }
   
}
```

### 多态的应用：模板方法设计模式(TemplateMethod)

**抽象类体现的就是一种模板模式的设计**，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

解决的问题：当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
 换句话说，**在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽象出来，供不同子类实现。这就是一种模板模式。**

```java
//抽象类的应用：模板方法的设计模式
public class TemplateMethodTest {

   public static void main(String[] args) {
      BankTemplateMethod btm = new DrawMoney();
      btm.process();

      BankTemplateMethod btm2 = new ManageMoney();
      btm2.process();
   }
}
abstract class BankTemplateMethod {
   // 具体方法
   public void takeNumber() {
      System.out.println("取号排队");
   }

   public abstract void transact(); // 办理具体的业务 //钩子方法

   public void evaluate() {
      System.out.println("反馈评分");
   }

   // 模板方法，把基本操作组合到一起，子类一般不能重写
   public final void process() {
      this.takeNumber();

      this.transact();// 像个钩子，具体执行时，挂哪个子类，就执行哪个子类的实现代码

      this.evaluate();
   }
}

class DrawMoney extends BankTemplateMethod {
   public void transact() {
      System.out.println("我要取款！！！");
   }
}

class ManageMoney extends BankTemplateMethod {
   public void transact() {
      System.out.println("我要理财！我这里有2000万美元!!");
   }
}
```

### 接口(interface)

一方面，有时必须从几个类中派生出一个子类，继承它们所有的属性和方法。但是，Java 不支持多重继承。有了接口，就可以得到多重继承的效果。

另一方面，有时必须从几个类中抽取出一些共同的行为特征，而它们之间又没有 is-a 的关系，仅仅是具有相同的行为特征而已。例如：鼠标、键盘、打印机、扫描仪、摄像头、充电器、MP3 机、手机、数码相机、移动硬盘等都支持 USB 连接。

接口就是规范，定义的是一组规则，体现了现实世界中“如果你是/要…则必须能…”的思想。**继承是一个"是不是"的关系，而接口实现则是"能不能"的关系。**

**接口的本质是契约，标准，规范**，就像我们的法律一样。制定好后大家都要遵守。

```
/* 接口(interface)是抽象方法和常量值定义的集合。
 * 接口的特点：
 * 用 interface 来定义。
 * 接口中的所有成员变量都默认是由 public static final 修饰的。
 * 接口中的所有抽象方法都默认是由 public abstract 修饰的。
 * 接口中没有构造器。
 * 接口采用多继承机制。
 */
```

```
/*
 * 接口的使用
 * 1.接口使用interface来定义
 * 2.Java中，接口和类是并列的两个结构
 * 3.如何定义接口：定义接口中的成员
 *        
 *        3.1 JDK7及以前：只能定义全局常量和抽象方法
 *           >全局常量：public static final的.但是书写时，可以省略不写
 *           >抽象方法：public abstract的
 *           
 *        3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）
 * 
 * 4. 接口中不能定义构造器的！意味着接口不可以实例化
 * 
 * 5. Java开发中，接口通过让类去实现(implements)的方式来使用.
 *    如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
 *    如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 *    
 * 6. Java类可以实现多个接口   --->弥补了Java单继承性的局限性
 *   格式：class AA extends BB implements CC,DD,EE
 *   
 * 7. 接口与接口之间可以继承，而且可以多继承
 * 
 * *******************************
 * 8. 接口的具体使用，体现多态性
 * 9. 接口，实际上可以看做是一种规范
 * 
 * 面试题：抽象类与接口有哪些异同？
 * 
 */
```



```java
/*
 * 接口的使用
 * 1.接口使用上也满足多态性
 * 2.接口，实际上就是定义了一种规范
 * 3.开发中，体会面向接口编程！
 * 
 */
public class USBTest {
   public static void main(String[] args) {
      
      Computer com = new Computer();
      //1.创建了接口的非匿名实现类的非匿名对象
      Flash flash = new Flash();
      com.transferData(flash);
      
      //2. 创建了接口的非匿名实现类的匿名对象
      com.transferData(new Printer());
      
      //3. 创建了接口的匿名实现类的非匿名对象
      USB phone = new USB(){

         @Override
         public void start() {
            System.out.println("手机开始工作");
         }

         @Override
         public void stop() {
            System.out.println("手机结束工作");
         }
      };
      com.transferData(phone);
      
      
      //4. 创建了接口的匿名实现类的匿名对象
      
      com.transferData(new USB(){
         @Override
         public void start() {
            System.out.println("mp3开始工作");
         }

         @Override
         public void stop() {
            System.out.println("mp3结束工作");
         }
      });
   }
}

class Computer{
   public void transferData(USB usb){//USB usb = new Flash();
      usb.start();
      System.out.println("具体传输数据的细节");
      usb.stop();
   }
}

interface USB{
   //常量：定义了长、宽、最大最小的传输速度等
   
   void start();
   
   void stop();
   
}

class Flash implements USB{

   @Override
   public void start() {
      System.out.println("U盘开启工作");
   }

   @Override
   public void stop() {
      System.out.println("U盘结束工作");
   }
   
}

class Printer implements USB{
   @Override
   public void start() {
      System.out.println("打印机开启工作");
   }

   @Override
   public void stop() {
      System.out.println("打印机结束工作");
   }
   
}
```

### 代理模式-设计模式

代理模式是 Java 开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。

![img](https://img-blog.csdnimg.cn/img_convert/6be3acfe541841343c9338f669a58d0c.png)

```java
/*
 * 接口的应用：代理模式
 * 
 */
public class StaticProxyTest {

	public static void main(String[] args) {
		Proxy s = new Proxy(new RealStar());
		s.confer();
		s.signContract();
		s.bookTicket();
		s.sing();
		s.collectMoney();
	}
}

interface Star {
	void confer();// 面谈

	void signContract();// 签合同

	void bookTicket();// 订票

	void sing();// 唱歌

	void collectMoney();// 收钱
}
//被代理类
class RealStar implements Star {

	public void confer() {
	}

	public void signContract() {
	}

	public void bookTicket() {
	}

	public void sing() {
		System.out.println("明星：歌唱~~~");
	}

	public void collectMoney() {
	}
}

//代理类
class Proxy implements Star {
	private Star real;

	public Proxy(Star real) {
		this.real = real;
	}

	public void confer() {
		System.out.println("经纪人面谈");
	}

	public void signContract() {
		System.out.println("经纪人签合同");
	}

	public void bookTicket() {
		System.out.println("经纪人订票");
	}

	public void sing() {
		real.sing();
	}

	public void collectMoney() {
		System.out.println("经纪人收钱");
	}
}
```

**应用场景：**

- 安全代理：屏蔽对真实角色的直接访问。
- 远程代理：通过代理类处理远程方法调用（RMI）
- 延迟加载：先加载轻量级的代理对象，真正需要再加载真实对象

**分类**

- 静态代理（静态定义代理类）
- 动态代理（动态生成代理类）   
  - JDK 自带的动态代理，需要反射等知识

### 工厂模式

**工厂模式：实现了创建者与调用者的分离，即将创建对象的具体过程屏蔽隔离 起来，达到提高灵活性的目的**。 

其实设计模式和面向对象设计原则都是为了使得开发项目更加容易扩展和维 护，解决方式就是一个“分工”。



##### 面向对象的设计原则

（总共六个）：这里说几个和工厂模式相关的

**OCP（开闭原则，Open-Closed Principle）  一个软件的实体应当对扩展开放，对修改关闭。**

**DIP（依赖倒转原则，Dependence Inversion Principle）  要针对接口编程，不要针对实现编程**。 如果 A 中关联 B，那么尽量使得 B 实现某个接口，然后 A 与接口发生关系， 不与 B 实现类发生关联关系。 依赖倒置的潜台词是：**面向抽象编程，解耦调用和被调用者。**

**LOD（迪米特法则，Law Of Demeter）只与你直接的朋友通信，而避免和陌生人通信。** 要求尽量的封装，尽量的独立，尽量的使用低级别的访问修饰符。这是封装 特性的典型体现。

无工厂模式

```java
interface Car{
	void run();
}
class Audi implements Car{
	public void run() {
		System.out.println("奥迪在跑");
	}
}
class BYD implements Car{
	public void run() {
		System.out.println("比亚迪在跑");
	}
}
public class Client01 {
	public static void main(String[] args) {
		Car a = new Audi();
		Car b = new BYD();
		a.run();
		b.run();
	}
}
```



##### 工厂模式的分类：

- 简单工厂模式：用来生产同一等级结构中的任意产品。（对于增加新的产品， 需要修改已有代码） 

缺点：对于增加新产品，不修改代码的话，是无法扩展的。违反了开闭原则（对 扩展开放；对修改封闭）。

```java
interface Car {
   void run();
}
class Audi implements Car {
   public void run() {
      System.out.println("奥迪在跑");
   }
}
class BYD implements Car {
   public void run() {
      System.out.println("比亚迪在跑");
   }
}
//工厂类
class CarFactory {
   //方式一
   public static Car getCar(String type) {
      if ("奥迪".equals(type)) {
         return new Audi();
      } else if ("比亚迪".equals(type)) {
         return new BYD();
      } else {
         return null;
      }
   }
//方式二
// public static Car getAudi() {
// return new Audi();
// }
//
// public static Car getByd() {
// return new BYD();
// }
}
public class Client02 {
   public static void main(String[] args) {
      Car a = CarFactory.getCar("奥迪");
      a.run();
      Car b = CarFactory.getCar("比亚迪");
      b.run();
   }
}
```

- 工厂方法模式：用来生产同一等级结构中的固定产品。（支持增加任意产品） 

```java
interface Car{
   void run();
}
//两个实现类
class Audi implements Car{
   public void run() {
      System.out.println("奥迪在跑");
   }
}
class BYD implements Car{
   public void run() {
      System.out.println("比亚迪在跑");
   }
}
//工厂接口
interface Factory{
   Car getCar();
}
//两个工厂类
class AudiFactory implements Factory{
   public Audi getCar(){
      return new Audi();
   }
}
class BydFactory implements Factory{
   public BYD getCar(){
      return new BYD();
   }
}
public class Client {
   public static void main(String[] args) {
      Car a = new AudiFactory().getCar();
      Car b = new BydFactory().getCar();
      a.run();
      b.run();
   }
}
```

- 抽象工厂模式：用来生产不同产品族的全部产品。（对于增加新的产品，无 能为力；支持增加产品族

​        抽象工厂模式和工厂方法模式的区别就在于需要创建对象的复杂程度上。而且 抽象工厂模式是三个里面最为抽象、最具一般性的。 抽象工厂模式的用意为：给客户端提供一个接口，可以创建多个产品族中的产品 对象。

### 接口和抽象类之间的对比

<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211216162643551.png" alt="image-20211216162643551" style="zoom:80%;" />

### Java 8 中关于接口的改进

Java 8 中，你可以为接口添加静态方法和默认方法。从技术角度来说，这是完全合法的，只是它看起来违反了接口作为一个抽象定义的理念。

**静态方法：**

使用 static 关键字修饰。可以通过接口直接调用静态方法，并执行其方法体。我们经常在相互一起使用的类中使用静态方法。你可以在标准库中找到像 Collection/Collections 或者 Path/Paths 这样成对的接口和类。

**默认方法：**

默认方法使用 default 关键字修饰。可以通过实现类对象来调用。我们在已有的接口中提供新方法的同时，还保持了与旧版本代码的兼容性。比如：java 8 API 中对 Collection、List、Comparator 等接口提供了丰富的默认方法。



interface 类

```java
public interface CompareA {
   
   //静态方法
   public static void method1(){
      System.out.println("CompareA:北京");
   }
   //默认方法
   public default void method2(){
      System.out.println("CompareA：上海");
   }
   
   default void method3(){
      System.out.println("CompareA：上海");
   }
}
```

```java
public interface CompareB {
   
   default void method3(){
      System.out.println("CompareB：上海");
   }
   
}
```

SubClassTest 类

```java
public class SubClassTest {
   
   public static void main(String[] args) {
      SubClass s = new SubClass();
      
//    s.method1();
//    SubClass.method1();
      //知识点1：接口中定义的静态方法，只能通过接口来调用。
      CompareA.method1();
      //知识点2：通过实现类的对象，可以调用接口中的默认方法。
      //如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
      s.method2();
      //知识点3：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，
      //那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->类优先原则
      //知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
      //那么在实现类没有重写此方法的情况下，报错。-->接口冲突。
      //这就需要我们必须在实现类中重写此方法
      s.method3();
      
   }
   
}

class SubClass extends SuperClass implements CompareA,CompareB{
   
   public void method2(){
      System.out.println("SubClass：上海");
   }
   
   public void method3(){
      System.out.println("SubClass：深圳");
   }
   
   //知识点5：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
   public void myMethod(){
      method3();//调用自己定义的重写的方法
      super.method3();//调用的是父类中声明的
      //调用接口中的默认方法
      CompareA.super.method3();
      CompareB.super.method3();
   }
}
```

SuperClass 类

```java
public class SuperClass {
   
   public void method3(){
      System.out.println("SuperClass:北京");
   }
   
}
```

1. 知识点1：接口中定义的静态方法，只能通过接口来调用。
2. 知识点2：通过实现类的对象，可以调用接口中的默认方法。如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
3. 知识点3：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->类优先原则
4. 知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法的情况下，报错。-->接口冲突。这就需要我们必须在实现类中重写此方法
5. 知识点5：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法

### 内部类

当一个事物的内部，还有一个部分需要一个完整的结构进行描述，而这个内部的完整的结构又只为外部事物提供服务，那么整个内部的完整结构最好使用内部类。

 

```
* 类的内部成员之五：内部类
* 1. Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类
* 
* 2.内部类的分类：成员内部类（静态、非静态）  vs 局部内部类(方法内、代码块内、构造器内)
* 
* 3.成员内部类：
*     一方面，作为外部类的成员：
*        >调用外部类的结构
*        >可以被static修饰
*        >可以被4种不同的权限修饰
* 
*     另一方面，作为一个类：
*        > 类内可以定义属性、方法、构造器等
*        > 可以被final修饰，表示此类不能被继承。言外之意，不使用final，就可以被继承
*        > 可以被abstract修饰
* 
* 
* 4.关注如下的3个问题
*   4.1 如何实例化成员内部类的对象
      
*   4.2 如何在成员内部类中区分调用外部类的结构
*   4.3 开发中局部内部类的使用  见《InnerClassTest1.java》
* 
```

```java
public class InnerClassTest {
   public static void main(String[] args) {
      
      //创建Dog实例(静态的成员内部类):4.1
      Person.Dog dog = new Person.Dog();
      dog.show();
      //创建Bird实例(非静态的成员内部类):
//    Person.Bird bird = new Person.Bird();//错误的
      Person p = new Person();
      Person.Bird bird = p.new Bird();
      bird.sing();
      
      System.out.println();
      
      bird.display("黄鹂");
      
   }
}


class Person{
   
   String name = "小明";
   int age;
   
   public void eat(){
      System.out.println("人：吃饭");
   }
   
   
   //静态成员内部类
   static class Dog{
      String name;
      int age;
      
      public void show(){
         System.out.println("卡拉是条狗");
//       eat();
      }
      
   }
   //非静态成员内部类
   class Bird{
      String name = "杜鹃";
      
      public Bird(){
         
      }
      
      public void sing(){
         System.out.println("我是一只小小鸟");
         Person.this.eat();//调用外部类的非静态属性
         eat();
         System.out.println(age);
      }
      
      public void display(String name){
         System.out.println(name);//方法的形参
         System.out.println(this.name);//内部类的属性
         System.out.println(Person.this.name);//外部类的属性
      }
   }

   public void method(){
      //局部内部类
      class AA{
         
      }
   }
   
   {
      //局部内部类
      class BB{
         
      }
   }
    
   public Person(){
      //局部内部类
      class CC{
         
      }
   }  
}
```

总结：成员内部类和局部内部类，在编译之后，都会生成字节码文件

格式：成员内部类：外部类$内部类名.class

​            局部内部类：外部类$数字 内部类名.class

```
/*
 * 在局部内部类的方法中（比如：show）如果调用局部内部类所声明的方法(比如：method)中的局部变量(比如：num)的话,
 * 要求此局部变量声明为final的。
 * 
 * jdk 7及之前版本：要求此局部变量显式的声明为final的
 * jdk 8及之后的版本：可以省略final的声明
 * 
 */
```









## 异常处理

异常：在Java语言中，将程序执行中发生的不正常情况称为“异常” 。 (开发过程中的语法错误和逻辑错误不是异常)

**Error**：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源 耗尽等严重情况。比如：StackOverflowError（堆溢出）和OOM（栈溢出）。一般不编写针对性 的代码进行处理。 

**Exception:** 其它因编程错误或偶然的外在因素导致的一般性问题，可以使 用针对性的代码进行处理。例如： 

- 空指针访问 
- 试图读取不存在的文件 
- 网络连接中断 
- 数组角标越界



### 异常体系结构

```
* 一、异常体系结构
* 
* java.lang.Throwable
*     |-----java.lang.Error:一般不编写针对性的代码进行处理。
*     |-----java.lang.Exception:可以进行异常的处理
*        |------编译时异常(checked)
*              |-----IOException
*                 |-----FileNotFoundException
*              |-----ClassNotFoundException
*        |------运行时异常(unchecked,RuntimeException)
*              |-----NullPointerException     空指针异常
*              |-----ArrayIndexOutOfBoundsException     数组角标越界
*              |-----ClassCastException      类型转换异常
*              |-----NumberFormatException        数值转换异常
*              |-----InputMismatchException       输入不匹配异常
*              |-----ArithmeticException          数学计算异常
* 面试题：常见的异常都有哪些？举例说明
*/
```

<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211224120537081.png" alt="image-20211224120537081" style="zoom: 50%;" />

编译时异常：执行javac..exe命令时，可能出现的移异常

运行时异常：执行Java.exe命令时，出翔的异常

### try-catch-finally

```java
/*
 * 一、异常的处理：抓抛模型
 * 
 * 过程一："抛"：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象。
 *           并将此对象抛出。
 *           一旦抛出对象以后，其后的代码就不再执行。
 *        
 *        关于异常对象的产生：① 系统自动生成的异常对象
 *                  ② 手动的生成一个异常对象，并抛出（throw）
 * 
 * 过程二："抓"：可以理解为异常的处理方式：① try-catch-finally  ② throws
 * 
 * 
 * 二、try-catch-finally的使用
 * 
 * try{
 *        //可能出现异常的代码
 * 
 * }catch(异常类型1 变量名1){
 *        //处理异常的方式1
 * }catch(异常类型2 变量名2){
 *        //处理异常的方式2
 * }catch(异常类型3 变量名3){
 *        //处理异常的方式3
 * }
 * ....
 * finally{
 *        //一定会执行的代码
 * }
 * 
 * 说明：
 * 1. finally是可选的。
 * 2. 使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象
 *    的类型，去catch中进行匹配
 * 3. 一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理。一旦处理完成，就跳出当前的
 *    try-catch结构（在没有写finally的情况）。继续执行其后的代码
 * 4. catch中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓。
 *    catch中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面。否则，报错
 * 5. 常用的异常对象处理的方式： ① String  getMessage()    ② printStackTrace()
 * 6. 在try结构中声明的变量，再出了try结构以后，就不能再被调用
 * 7. try-catch-finally结构可以嵌套
 * 
 * 体会1：使用try-catch-finally处理编译时异常，是得程序在编译时就不再报错，但是运行时仍可能报错。
 *     相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。
 *     
 * 体会2：开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally了。
 *      针对于编译时异常，我们说一定要考虑异常的处理。
 */
public class ExceptionTest1 {
   
   
   @Test
   public void test2(){
      try{
         File file = new File("hello.txt");
         FileInputStream fis = new FileInputStream(file);
         
         int data = fis.read();
         while(data != -1){
            System.out.print((char)data);
            data = fis.read();
         }
         
         fis.close();
      }catch(FileNotFoundException e){
         e.printStackTrace();
      }catch(IOException e){
         e.printStackTrace();
      }
   }
   
   @Test
   public void test1(){
      
      String str = "123";
      str = "abc";
      int num = 0;
      try{
         num = Integer.parseInt(str);
         
         System.out.println("hello-----1");
      }catch(NumberFormatException e){
//       System.out.println("出现数值转换异常了，不要着急....");
         //String getMessage():
//       System.out.println(e.getMessage());
         //printStackTrace():
         e.printStackTrace();
      }catch(NullPointerException e){
         System.out.println("出现空指针异常了，不要着急....");
      }catch(Exception e){
         System.out.println("出现异常了，不要着急....");
         
      }
      System.out.println(num);
      
      System.out.println("hello-----2");
   }
   
}
```

```
/*
 * try-catch-finally中finally的使用：
 * 
 * 
 * 1.finally是可选的
 * 
 * 2.finally中声明的是一定会被执行的代码。即使catch中又出现异常了，try中有return语句，catch中有
 * return语句等情况。
 * 
 * 3.像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源的
 *   释放。此时的资源释放，就需要声明在finally中。
 * 
```



### throws + 异常类型

```java
/*
 * 异常处理的方式二：throws + 异常类型
 * 
 * 1. "throws + 异常类型"写在方法的声明处。指明此方法执行时，可能会抛出的异常类型。
 *     一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常
 *     类型时，就会被抛出。异常代码后续的代码，就不再执行！
 *     
 * 2. 体会：try-catch-finally:真正的将异常给处理掉了。
 *        throws的方式只是将异常抛给了方法的调用者。  并没有真正将异常处理掉。  
 * 
 * 3. 开发中如何选择使用try-catch-finally 还是使用throws？
 *   3.1 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果
 *       子类重写的方法中有异常，必须使用try-catch-finally方式处理。
 *   3.2 执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。我们建议这几个方法使用throws
 *       的方式进行处理。而执行的方法a可以考虑使用try-catch-finally方式进行处理。
 * 
 */
public class ExceptionTest2 {
   
   
   public static void main(String[] args){
      try{
         method2();
         
      }catch(IOException e){
         e.printStackTrace();
      }
      
//    method3();
      
   }
   
   
   public static void method3(){
      try {
         method2();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   
   public static void method2() throws IOException{
      method1();
   }
   
   
   public static void method1() throws FileNotFoundException,IOException{
      File file = new File("hello1.txt");
      FileInputStream fis = new FileInputStream(file);
      
      int data = fis.read();
      while(data != -1){
         System.out.print((char)data);
         data = fis.read();
      }
      
      fis.close();
      
      System.out.println("hahaha!");
   }
 
}
```

​     

**开发中如何选择使用try-catch-finally 还是使用throws？**

3.1 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果子类重写的方法中有异常，必须使用try-catch-finally方式处理。

3.2 执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。我们建议这几个方法使用throws的方式进行处理。而执行的方法a可以考虑使用try-catch-finally方式进行处理。



### 手动抛出异常(throw)

```java
public class StudentTest {
   
   public static void main(String[] args) {
      try {
         Student s = new Student();
         s.regist(-1001);
         System.out.println(s);
      } catch (Exception e) {
//       e.printStackTrace();
         System.out.println(e.getMessage());
      }
   }
   
}


class Student{
   
   private int id;
   
   public void regist(int id) throws Exception {
      if(id > 0){
         this.id = id;
      }else{
//       System.out.println("您输入的数据非法！");
         //手动抛出异常对象
//       throw new RuntimeException("您输入的数据非法！");
//       throw new Exception("您输入的数据非法！");
         throw new MyException("不能输入负数");
         //错误的
//       throw new String("不能输入负数");
      }
      
   }

   @Override
   public String toString() {
      return "Student [id=" + id + "]";
   }
}
```



### 自定义异常类

```java
/*
 * 如何自定义异常类？
 * 1. 继承于现有的异常结构：RuntimeException 、Exception
 * 2. 提供全局常量：serialVersionUID 序列号 
 * 3. 提供重载的构造器
 * 
 */
public class MyException extends Exception{
   
   static final long serialVersionUID = -7034897193246939L;
   
   public MyException(){
      
   }
   
   public MyException(String msg){
      super(msg);
   }
}
```



### throw和throws

**throw是语句抛出一个异常。

语法：throw (异常对象);
     throw e;

**throws是方法可能抛出异常的声明**。(用在声明方法时，表示该方法可能要抛出异常)
语法：[(修饰符)](返回值类型)(方法名)([参数列表])[throws(异常类)]{......}
      public void doA(int a) throws Exception1,Exception3{......}



throw语句用在方法体内，表示抛出异常，由方法体内的语句处理。
throws语句用在方法声明后面，表示再抛出异常，由该方法的调用者来处理。

 

throws主要是声明这个方法会抛出这种类型的异常，使它的调用者知道要捕获这个异常。
throw是具体向外抛异常的动作，所以它是抛出一个异常实例。

 

throws说明你有那个可能，倾向。
throw的话，那就是你把那个倾向变成真实的了。

 

同时：
1、throws出现在方法函数头；而throw出现在函数体。
2、throws表示出现异常的一种可能性，并不一定会发生这些异常；throw则是抛出了异常，执行throw则一定抛出了某种异常。
3、两者都是消极处理异常的方式（这里的消极并不是说这种方式不好），只是抛出或者可能抛出异常，但是不会由函数去处理异常，真正的处理异常由函数的上层调用处理。



throw:生成一个异常对象，并抛出。使用在方法内部 <-> 自动抛出异常对象

throws:处理异常的方式。使用在方法声明处的末尾<->try-catch-finally

“上游排污，下游治污”

## 多线程



### 基本概念

------

内存结构

![image-20211225150858971](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211225150858971.png)



**程序(program)**是为完成特定任务、用某种语言编写的一组指令的集合。即**指一 段静态的代码，静态对象**。



**进程(process)**是程序的一次执行过程，或是**正在运行的一个程序**。是一个动态 的过程：有它自身的产生、存在和消亡的过程。——生命周期 

- 如：运行中的QQ，运行中的MP3播放器

- 程序是静态的，进程是动态的 

- **进程作为资源分配的单位，**系统在运行时会为每个进程分配不同的内存区



**线程(thread)**，进程可进一步细化为线程，是一个程序内部的一条执行路径。 

- 若一个进程同一时间并行执行多个线程，就是支持多线程的 

- **线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器(pc)**，线程切换的开 销小

- 一个进程中的多个线程共享相同的内存单元/内存地址空间

- 它们从同一堆中分配对象，可以 访问相同的变量和对象。这就使得线程间通信更简便、高效。但多个线程操作共享的系统资 源可能就会带来**安全的隐患。**



**一个Java应用程序java.exe，其实至少有三个线程：main()主线程，gc() 垃圾回收线程，异常处理线程。当然如果发生异常，会影响主线程。**



**并行与并发** 

- 并行：多个CPU同时执行多个任务。比如：多个人同时做不同的事。 

- 并发：一个CPU(采用时间片)同时执行多个任务。比如：秒杀、多个人做同一件事。

### 线程的创建和使用

------

#### 方式一：继承于Thread类

```java
/**
 * 多线程的创建，方式一：继承于Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * 3. 创建Thread类的子类的对象
 * 4. 通过此对象调用start()
 * <p>
 * 例子：遍历100以内的所有的偶数
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2. 重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类的子类的对象
        MyThread t1 = new MyThread();

        //4.通过此对象调用start():①启动当前线程 ② 调用当前线程的run()
        t1.start();
        //问题一：我们不能通过直接调用run()的方式启动线程。
//        t1.run();

        //问题二：再启动一个线程，遍历100以内的偶数。不可以还让已经start()的线程去执行。会报IllegalThreadStateException
//        t1.start();
        //我们需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();


        //如下操作仍然是在main线程中执行的。
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***********main()************");
            }
        }
    }

}
```



##### **Thread类的有关方法**

- void start(): 启动线程，并执行对象的run()方法 

- run(): 线程在被调度时执行的操作 String getName(): 返回线程的名称 

- void setName(String name):设置该线程名称 

- static Thread currentThread(): 返回当前线程。在Thread子类中就 是this，通常用于主线程和Runnable实现类
- static void yield()：线程让步

​      暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程

​      若队列中没有同优先级的线程，忽略此方法

- join() ：当某个程序执行流中调用其他线程的 join() 方法时，调用线程将 被阻塞，直到 join() 方法加入的 join 线程执行完为止
- stop(): 强制线程生命期结束，不推荐使用
- boolean isAlive()：返回boolean，判断线程是否还活着

```
/**
 * 测试Thread中的常用方法：
 * 1. start():启动当前线程；调用当前线程的run()
 * 2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread():静态方法，返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6. yield():释放当前cpu的执行权
 * 7. join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才
 *           结束阻塞状态。
 * 8. stop():已过时。当执行此方法时，强制结束当前线程。
 * 9. sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前
 *                          线程是阻塞状态。
 * 10. isAlive():判断当前线程是否存活
 *
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5  -->默认优先级
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *
 *   说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下
 *   被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 *
```

​    

#### 方式二：实现Runnable接口

```java
/**
 * 创建多线程的方式二：实现Runnable接口
 * 1. 创建一个实现了Runnable接口的类
 * 2. 实现类去实现Runnable中的抽象方法：run()
 * 3. 创建实现类的对象
 * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5. 通过Thread类的对象调用start()
 *
 *
 * 比较创建线程的两种方式。
 * 开发中：优先选择：实现Runnable接口的方式
 * 原因：1. 实现的方式没有类的单继承性的局限性
 *      2. 实现的方式更适合来处理多个线程有共享数据的情况。
 *
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
 */
//1. 创建一个实现了Runnable接口的类
class MThread implements Runnable{

    //2. 实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3. 创建实现类的对象
        MThread mThread = new MThread();
        //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        t1.setName("线程1");
        //5. 通过Thread类的对象调用start():① 启动线程 ②调用当前线程的run()-->调用了Runnable类型的target的run()
        t1.start();

        //再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(mThread);
        t2.setName("线程2");
        t2.start();
    }

}
```



#### 两种方式对比

比较创建线程的两种方式。

开发中：优先选择：实现Runnable接口的方式

原因：1. 实现的方式没有类的单继承性的局限性

​            2.实现的方式更适合来处理多个线程有共享数据的情况。


联系：public class Thread implements Runnable

相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。

### 线程的生命周期

------

**JDK中用Thread.State类定义了线程的几种状态**

要想实现多线程，必须在主线程中创建新的线程对象。Java语言使用Thread类 及其子类的对象来表示线程，**在它的一个完整的生命周期中通常要经历如下的五 种状态：**

- **新建**： 当一个Thread类或其子类的对象被声明并创建时，新生的线程对象处于新建 状态

- **就绪**：处于新建状态的线程被start()后，将进入线程队列等待CPU时间片，此时它已 具备了运行的条件，只是没分配到CPU资源

- **运行**：当就绪的线程被调度并获得CPU资源时,便进入运行状态， run()方法定义了线 程的操作和功能

- **阻塞**：在某种特殊情况下，被人为挂起或执行输入输出操作时，让出 CPU 并临时中 止自己的执行，进入阻塞状态

- **死亡：**线程完成了它的全部工作或线程被提前强制性地中止或出现异常导致结束



<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211225151521338.png" alt="image-20211225151521338" style="zoom: 67%;" />

### 线程的同步

------

##### 方式一：同步代码块

```java
** 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 * 1.问题：卖票过程中，出现了重票、错票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时，其他
 *            线程才可以开始操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。
 *
 *
*4.在Java中，我们通过同步机制，来解决线程的安全问题。
*
*  方式一：同步代码块
*
*   synchronized(同步监视器){
*      //需要被同步的代码
*
*   }
*  说明：1.操作共享数据的代码，即为需要被同步的代码。  -->不能包含代码多了，也不能包含代码少了。
*       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
*       3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
*          要求：多个线程必须要共用同一把锁。
*
*       补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
*  方式二：同步方法。
*     如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的。
*
*
*  5.同步的方式，解决了线程的安全问题。---好处
*    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。 ---局限性

class Window1 implements Runnable{

    private int ticket = 100;
//    Object obj = new Object();
//    Dog dog = new Dog();
    @Override
    public void run() {
//        Object obj = new Object();
        while(true){
            synchronized (Window2.class){//Class clazz = Window2.class,Window2.class只会加载一次

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);


                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}


class Dog{

}
```

**说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。**



##### 方式二：同步方法

```java
/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 *
 *  关于同步方法的总结：
 *  1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *  2. 非静态的同步方法，同步监视器是：this
 *     静态的同步方法，同步监视器是：当前类本身
 */


class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();
        }
    }

    private synchronized void show(){//同步监视器：this
        //synchronized (this){

            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

                ticket--;
            }
        //}
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
```

```java
/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 */
class Window4 extends Thread {


    private static int ticket = 100;

    @Override
    public void run() {

        while (true) {

            show();
        }

    }
    private static synchronized void show(){//同步监视器：Window4.class
        //private synchronized void show(){ //同步监视器：t1,t2,t3。此种解决方式是错误的
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
```

### 死锁

- 不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃 自己需要的同步资源，就形成了线程的死锁
- 出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于 阻塞状态，无法继续

**解决方法**

- 专门的算法、原则 

- 尽量减少同步资源的定义 

- 尽量避免嵌套同步

```java
**
 * 演示线程的死锁问题
 *
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，
 * 都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 *
 * 2.说明：
 * 1）出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 * 2）我们使用同步时，要避免出现死锁。
 *
 //死锁的演示
class A {
	public synchronized void foo(B b) { //同步监视器：A类的对象：a
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 进入了A实例的foo方法"); // ①
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException ex) {
//			ex.printStackTrace();
//		}
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 企图调用B实例的last方法"); // ③
		b.last();
	}

	public synchronized void last() {//同步监视器：A类的对象：a
		System.out.println("进入了A类的last方法内部");
	}
}

class B {
	public synchronized void bar(A a) {//同步监视器：b
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 进入了B实例的bar方法"); // ②
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException ex) {
//			ex.printStackTrace();
//		}
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 企图调用A实例的last方法"); // ④
		a.last();
	}

	public synchronized void last() {//同步监视器：b
		System.out.println("进入了B类的last方法内部");
	}
}

public class DeadLock implements Runnable {
	A a = new A();
	B b = new B();

	public void init() {
		Thread.currentThread().setName("主线程");
		// 调用a对象的foo方法
		a.foo(b);
		System.out.println("进入了主线程之后");
	}

	public void run() {
		Thread.currentThread().setName("副线程");
		// 调用b对象的bar方法
		b.bar(a);
		System.out.println("进入了副线程之后");
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		new Thread(dl).start();


		dl.init();
	}
}
```

### 线程安全

------

#### 1. 使用同步机制将单例模式中的懒汉式改写为线程安全的

```java
/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author shkstart
 * @create 2019-02-15 下午 2:50
 */
public class BankTest {

}

class Bank{

    private Bank(){}

    private static Bank instance = null;

    public static Bank getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if(instance == null){

            synchronized (Bank.class) {
                if(instance == null){

                    instance = new Bank();
                }

            }
        }
        return instance;
    }

}
```

#### 2.线程安全问题的方式三：Lock锁

```java
/**
 * 解决线程安全问题的方式三：Lock锁  --- JDK5.0新增
 *
 * 1. 面试题：synchronized 与 Lock的异同？
 *   相同：二者都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 *
 *  面试题：如何解决线程安全问题？有几种方式
 */
class Window implements Runnable{

    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{

                //2.调用锁定方法lock()
                lock.lock();

                if(ticket > 0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
```



### synchronized 与 Lock 的对比（同步监视器）

1. Lock是显式锁（手动开启和关闭锁，别忘记关闭锁），synchronized是 隐式锁，出了作用域自动释放 
2. Lock只有代码块锁，synchronized有代码块锁和方法锁 
3. 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有 更好的扩展性（提供更多的子类）

优先使用顺序： Lock->同步代码块（已经进入了方法体，分配了相应资源） -> 同步方法 （在方法体之外）

### 线程的通信

------

```java
* 线程通信的例子：使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 *    否则，会出现IllegalMonitorStateException异常
 * 3.wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中。
 *
 * 面试题：sleep() 和 wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep() , Object类中声明wait()
 *          2）调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
 *          3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。
 */
class Number implements Runnable{
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {

        while(true){

            synchronized (obj) {

                obj.notify();

                if(number <= 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }

        }

    }
}


public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
```



### **面试题：sleep() 和 wait()的异同？**

 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep() , Object类中声明wait()
 *          2）调用的要求不同：sleep()可以在任何需要的场景下调用。 wait()必须使用在同步代码块或同步方法中
 *          3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁。



### 生产者消费者

```java
/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程的安全问题？同步机制,有三种方法
 * 4. 是否涉及线程的通信？是
 */
class Clerk{

    private int productCount = 0;
    //生产产品
    public synchronized void produceProduct() {

        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");

            notify();

        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    //消费产品
    public synchronized void consumeProduct() {
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;

            notify();
        }else{
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始生产产品.....");

        while(true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }

    }
}

class Consumer extends Thread{//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ":开始消费产品.....");

        while(true){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();

    }
}
```



### jdk5.0新增线程创建方式

------

#### 创建线程的方式三：实现Callable接口

```java
* 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增
 *
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1. call()可以有返回值的。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 */
//1.创建一个实现Callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}


public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
```

#### 新增方式二：使用线程池

```java
/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *
 * 面试题：创建多线程有几种方式？四种！
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i <= 100;i++){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadPool {

    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();


        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
        service.execute(new NumberThread1());//适合适用于Runnable

//        service.submit(Callable callable);//适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }

}
```









## JAVA常用类



### String类

------

- String类：代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作 为此类的实例实现。
- String是一个final类，代表不可变的字符序列。
- 字符串是常量，用双引号引起来表示。它们的值在创建之后不能更改。
- String对象的字符内容是存储在一个字符数组value[]中的。



##### String的使用

```java
/**
 * String的使用
 */
public class StringTest {

     /*
    String:字符串，使用一对""引起来表示。
    1.String声明为final的，不可被继承
    2.String实现了Serializable(可序列化)接口：表示字符串是支持序列化的。
            实现了Comparable接口：表示String可以比较大小
    3.String内部定义了final char[] value用于存储字符串数据 
    4.String:代表不可变的字符序列。简称：不可变性。
        体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
             2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
             3. 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
    5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6.字符串常量池中是不会存储相同内容的字符串的。
     */
    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1 == s2);//比较s1和s2的地址值

        System.out.println(s1);//hello
        System.out.println(s2);//abc

        System.out.println("*****************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);

        System.out.println("*****************");

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc

    }
    
    /*
    String的实例化方式：
    方式一：通过字面量定义的方式
    方式二：通过new + 构造器的方式

     面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
            两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"

     */
    @Test
    public void test2(){
        //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式:此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

        System.out.println("***********************");
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true

        p1.name = "Jerry";
        System.out.println(p2.name);//Tom
    }


     @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true


    }
    /*
    结论：
    1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
    2.只要其中有一个是变量，结果就在堆中。
    3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test4(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final String s4 = "javaEE";//s4:常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true

    }
}
```



**面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？**
       两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"



##### **String类的常用方法**

```
替换：
String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
匹配:
boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
切片：
String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
```

```
boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

注：indexOf和lastIndexOf方法如果未找到都是返回-1
```

```
int length()：返回字符串的长度： return value.length
char charAt(int index)： 返回某索引处的字符return value[index]
boolean isEmpty()：判断是否是空字符串：return value.length == 0
String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
String trim()：返回字符串的副本，忽略前导空白和尾部空白
boolean equals(Object obj)：比较字符串的内容是否相同
boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
int compareTo(String anotherString)：比较两个字符串的大小
String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
```



#####  **String 与基本数据类型、包装类之间的转换。**

```java
/*
    复习：
    String 与基本数据类型、包装类之间的转换。

    String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)

     */
    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str1 == str3);//false
    }
```



##### String 与 char[]之间的转换

```java
/*
String 与 char[]之间的转换

String --> char[]:调用String的toCharArray()
char[] --> String:调用String的构造器
 */
@Test
public void test2(){
    String str1 = "abc123";  //题目： a21cb3

    char[] charArray = str1.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
        System.out.println(charArray[i]);
    }

    char[] arr = new char[]{'h','e','l','l','o'};
    String str2 = new String(arr);
    System.out.println(str2);
}
```



##### String 与 byte[]之间的转换

```java
/*
String 与 byte[](字节数组)之间的转换
编码：String --> byte[]:调用String的getBytes()
解码：byte[] --> String:调用String的构造器

编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂）

说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
 */
@Test
public void test3() throws UnsupportedEncodingException {
    String str1 = "abc123中国";
    byte[] bytes = str1.getBytes();//使用默认的字符集，进行编码。
    System.out.println(Arrays.toString(bytes));

    byte[] gbks = str1.getBytes("gbk");//使用gbk字符集进行编码。
    System.out.println(Arrays.toString(gbks));

    System.out.println("******************");

    String str2 = new String(bytes);//使用默认的字符集，进行解码。
    System.out.println(str2);

    String str3 = new String(gbks);
    System.out.println(str3);//出现乱码。原因：编码集和解码集不一致！

    String str4 = new String(gbks, "gbk");
    System.out.println(str4);//没有出现乱码。原因：编码集和解码集一致！

}
```



##### StringBufferBuild

**String、StringBuffer、StringBuilder三者的异同？**

```java
/*
    String、StringBuffer、StringBuilder三者的异同？
    String:不可变的字符序列；底层使用char[]存储
    StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
    StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储

    源码分析：
    String str = new String();//char[] value = new char[0];
    String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组。
    System.out.println(sb1.length());//
    sb1.append('a');//value[0] = 'a';
    sb1.append('b');//value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];

    //问题1. System.out.println(sb2.length());//3
    //问题2. 扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
             默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中。

            指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)


     */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0
    }

}
```



**StringBuffer的常用方法**

```java
/*
    StringBuffer的常用方法：
StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转
public int indexOf(String str)
public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
public int length()
public char charAt(int n )
public void setCharAt(int n ,char ch)

        总结：
        增：append(xxx)
        删：delete(int start,int end)
        改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
        查：charAt(int n )
        插：insert(int offset, xxx)
        长度：length();
        *遍历：for() + charAt() / toString()
     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
//        s1.delete(2,4);
//        s1.replace(2,4,"hello");
//        s1.insert(2,false);
//        s1.reverse();
        String s2 = s1.substring(1, 3);
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s2);
    }
```



**对比String、StringBuffer、StringBuilder三者的效率：**
从高到低排列：StringBuilder > StringBuffer > String



##### String习题



**1.将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”**

```java
方式一：转换为char[]
 */
public String reverse(String str,int startIndex,int endIndex){

    if(str != null){
        char[] arr = str.toCharArray();
        for(int x = startIndex,y = endIndex;x < y;x++,y--){
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        return new String(arr);
    }
    return null;
}

//方式二：使用String的拼接
public String reverse1(String str,int startIndex,int endIndex){
    if(str != null){
        //第1部分
        String reverseStr = str.substring(0,startIndex);
        //第2部分
        for(int i = endIndex;i >= startIndex;i--){
            reverseStr += str.charAt(i);
        }
        //第3部分
        reverseStr += str.substring(endIndex + 1);

        return reverseStr;

    }
    return null;
}
//方式三：使用StringBuffer/StringBuilder替换String
public String reverse2(String str,int startIndex,int endIndex){
    if(str != null){
        StringBuilder builder = new StringBuilder(str.length());

        //第1部分
        builder.append(str.substring(0,startIndex));
        //第2部分
        for(int i = endIndex;i >= startIndex;i--){

            builder.append(str.charAt(i));
        }
        //第3部分
        builder.append(str.substring(endIndex + 1));

        return builder.toString();
    }
    return null;

}
```



**2.获取一个字符串在另一个字符串中出现的次数。**
  比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数

```java
public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){
            //方式一：
//            while((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            //方式二：对方式一的改进
            while((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }

            return count;
        }else{
            return 0;
        }
    }

    @Test
    public void testGetCount(){
        String mainStr = "abkkcadkabkebfkaabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }
}
```

 

3. **获取两个字符串中最大相同子串。**比如：
str1 = "abcwerthelloyuiodefabcdef";str2 = "cvhellobnm"
提示：将短的那个串进行长度依次递减的子串与较长的串比较。

```java
//前提：两个字符串中只有一个最大相同子串
    public String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length())? str1 : str2;
            String minStr = (str1.length() < str2.length())? str1 : str2;
            int length = minStr.length();

            for(int i = 0;i < length;i++){
                for(int x = 0,y = length - i;y <= length;x++,y++){
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }

                }
            }

        }
        return null;
    }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
//                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }

        return null;
    }

    @Test
    public void testGetMaxSameString(){
        String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";
        String[] maxSameStrings = getMaxSameString1(str1, str2);
        System.out.println(Arrays.toString(maxSameStrings));

    }
```

### date类

------

##### System类中的currentTimeMillis()

```java
//1.System类中的currentTimeMillis()
@Test
public void test1(){
    long time = System.currentTimeMillis();
    //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
    //称为时间戳
    System.out.println(time);
}
```



##### java.util.Date类

```java
/**
 * JDK 8之前日期和时间的API测试
 */
public class DateTimeTest {

    /*
    java.util.Date类
           |---java.sql.Date类

    1.两个构造器的使用
        >构造器一：Date()：创建一个对应当前时间的Date对象
        >构造器二：创建指定毫秒数的Date对象
    2.两个方法的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数。（时间戳）

    3. java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sat Feb 16 16:35:31 GMT+08:00 2019

        System.out.println(date1.getTime());//1550306204104

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(155030620410L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3);//1971-02-13

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        Date date4 = new java.sql.Date(2343243242323L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }
}
```



##### **SimpleDateFormat**

```java
/*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期 --->字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2.SimpleDateFormat的实例化

     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "19-12-18 上午11:43";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2019-02-18 11:48:27
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = sdf1.parse("2020-02-18 11:48:27");
        System.out.println(date2);
    }
```



##### Calendar日历类(抽象类）的使用

```java
/*
    Calendar日历类(抽象类）的使用

     */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);//这个月第几天
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//这一年的第几天

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
```



##### jdk 8中日期时间API的测试



```
//偏移量
Date date1 = new Date(2020 - 1900,9 - 1,8);
System.out.println(date1);//Tue Sep 08 00:00:00 GMT+08:00 2020
```



**LocalDate、LocalTime、LocalDateTime 的使用**

```java
/*
LocalDate、LocalTime、LocalDateTime 的使用
说明：
    1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
    2.类似于Calendar
 */
@Test
public void test1(){
    //now():获取当前的日期、时间、日期+时间
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();
    LocalDateTime localDateTime = LocalDateTime.now();

    System.out.println(localDate);
    System.out.println(localTime);
    System.out.println(localDateTime);

    //of():设置指定的年、月、日、时、分、秒。没有偏移量
    LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
    System.out.println(localDateTime1);


    //getXxx()：获取相关的属性
    System.out.println(localDateTime.getDayOfMonth());
    System.out.println(localDateTime.getDayOfWeek());
    System.out.println(localDateTime.getMonth());
    System.out.println(localDateTime.getMonthValue());
    System.out.println(localDateTime.getMinute());

    //体现不可变性
    //withXxx():设置相关的属性
    LocalDate localDate1 = localDate.withDayOfMonth(22);
    System.out.println(localDate);
    System.out.println(localDate1);


    LocalDateTime localDateTime2 = localDateTime.withHour(4);
    System.out.println(localDateTime);
    System.out.println(localDateTime2);

    //不可变性
    LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
    System.out.println(localDateTime);
    System.out.println(localDateTime3);

    LocalDateTime localDateTime4 = localDateTime.minusDays(6);
    System.out.println(localDateTime);
    System.out.println(localDateTime4);
}
```



**Instant（瞬时）**

```java
/*
Instant的使用
类似于 java.util.Date类

 */
@Test
public void test2(){
    //now():获取本初子午线对应的标准时间
    Instant instant = Instant.now();
    System.out.println(instant);//2019-02-18T07:29:41.719Z

    //添加时间的偏移量
    OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
    System.out.println(offsetDateTime);//2019-02-18T15:32:50.611+08:00

    //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
    long milli = instant.toEpochMilli();
    System.out.println(milli);

    //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
    Instant instant1 = Instant.ofEpochMilli(1550475314878L);
    System.out.println(instant1);
}
```



**DateTimeFormatter:格式化或解析日期、时间**

```java
 /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat

     */

    @Test
    public void test3(){
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2019-02-18T15:42:18.797

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2019年2月18日 下午03时47分16秒


//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2019-2-18


//       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2019-02-18 03:52:09

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);

    }
```





### java比较器（Comparable接口与Comparator）

------

一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
          如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
二、Comparable接口与Comparator的使用的对比：
   Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
   Comparator接口属于临时性的比较。

```java
/*
    Comparable接口的使用举例：  自然排序
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
    2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
    3. 重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数，
        如果当前对象this小于形参对象obj，则返回负整数，
        如果当前对象this等于形参对象obj，则返回零。
    4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
       在compareTo(obj)方法中指明如何排序
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        //
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    Comparator接口的使用：定制排序
    1.背景：
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
    或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
    那么可以考虑使用 Comparator 的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
    如果方法返回正整数，则表示o1大于o2；
    如果返回0，表示相等；
    返回负整数，表示o1小于o2。

     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr,new Comparator(){

            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof  String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test4(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }
   

    
```



**goods类**

```java
public class Goods implements  Comparable{

    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式:按照价格从低到高排序,再按照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
//        System.out.println("**************");
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
               return -this.name.compareTo(goods.name);
            }
            //方式二：
//           return Double.compare(this.price,goods.price);
        }
//        return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }
    
    
    
    
}
```



### 其他常用类的使用

#### 1.System

```java
public void test1() {
    String javaVersion = System.getProperty("java.version");
    System.out.println("java的version:" + javaVersion);

    String javaHome = System.getProperty("java.home");
    System.out.println("java的home:" + javaHome);

    String osName = System.getProperty("os.name");
    System.out.println("os的name:" + osName);

    String osVersion = System.getProperty("os.version");
    System.out.println("os的version:" + osVersion);

    String userName = System.getProperty("user.name");
    System.out.println("user的name:" + userName);

    String userHome = System.getProperty("user.home");
    System.out.println("user的home:" + userHome);

    String userDir = System.getProperty("user.dir");
    System.out.println("user的dir:" + userDir);

}
```



#### 2.Math

<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211227225045703.png" alt="image-20211227225045703" style="float:left" width="500" height="202"/>



#### 3.BigInteger 和 BigDecimal

- java.math包的BigInteger可以表示不可变的任意精度的整数。BigInteger 提供 所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。 另外，BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、 位操作以及一些其他操作。

<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20211227225623896.png" alt="image-20211227225623896" style="float:left" width="500" height="230" />

- 一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中， 要求数字精度比较高，故用到java.math.BigDecimal类。

```java
 @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
//         System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));

    }
```





## 枚举类



- 类的对象只有有限个，确定的。

- 当需要定义一组常量时，强烈建议使用枚举类

- 若枚举只有一个对象, 则可以作为一种单例模式的实现方式。



#### **自定义枚举类**

```java
/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 *
 * 三、Enum类中的常用方法：
 *    values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *    valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *    toString()：返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 *   情况一：实现接口，在enum类中实现抽象方法
 *   情况二：让枚举类的对象分别实现接口中的抽象方法
 */
public class SeasonTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

    }

}
//自定义枚举类
class Season{
    //1.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象：public static final的
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    //4.其他诉求1：提供toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
```



#### **使用enum关键字枚举类**

- **values()方法**：返回枚举类型的对象数组。该方法可以很方便地遍历所有的 枚举值。

- **valueOf(String str)**：可以把一个字符串转为对应的枚举类对象。要求字符 串必须是枚举类对象的“名字”。如不是，会有运行时异常： IllegalArgumentException。

- **toString()**：返回当前枚举类对象常量的名称

```java
/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 * 三个方法values()方法，valueOf(String str)，toString()
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString():返回枚举类对象的名称
        System.out.println(summer.toString());

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("****************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for(int i = 0;i < values.length;i++){
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("****************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        Season1 winter = Season1.valueOf("WINTER");
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
        winter.show();
    }
}

interface Info{
    void show();
}

//使用enum关键字枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值

    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
//    //4.其他诉求1：提供toString()
//
//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }


//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}
```



## 注解

- 从 JDK 5.0 开始, Java 增加了对元数据(MetaData) 的支持, 也就是 Annotation(注解)
- Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加 载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。代 码分析工具、开发工具和部署工具可以通过这些补充信息进行验证 或者进行部署。
- Annotation 可以像修饰符一样被使用, 可用于修饰包,类, 构造器, 方 法, 成员变量, 参数, 局部变量的声明, 这些信息被保存在 Annotation  的 “name=value” 对中。

**一定程度上 可以说：框架 = 注解 + 反射 + 设计模式**



```java
/**
 * 注解的使用
 *
 * 1. 理解Annotation:
 * ① jdk 5.0 新增的功能
 *
 * ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation,
 * 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 *
 * ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android
 * 中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 * 代码和XML配置等。
 *
 * 2. Annocation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
     @Override: 限定重写父类方法, 该注解只能用于方法
     @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
     @SuppressWarnings: 抑制编译器警告

  * 示例三：跟踪代码依赖性，实现替代配置文件功能
  *
  * 3. 如何自定义注解：参照@SuppressWarnings定义
      * ① 注解声明为：@interface
      * ② 内部定义成员，通常使用value表示
      * ③ 可以指定成员的默认值，使用default定义
      * ④ 如果自定义注解没有成员，表明是一个标识作用。

     如果注解有成员，在使用注解时，需要指明成员的值。
     自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
     自定义注解通过都会指明两个元注解：Retention、Target

     4. jdk 提供的4种元注解
       元注解：对现有的注解进行解释说明的注解
     Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
            只有声明为RUNTIME生命周期的注解，才能通过反射获取。
     Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素
     *******出现的频率较低*******
     Documented:表示所修饰的注解在被javadoc解析时，保留下来。
     Inherited:被它修饰的 Annotation 将具有继承性。

     5.通过反射获取注解信息 ---到反射内容时系统讲解

     6. jdk 8 中注解的新特性：可重复注解、类型注解

     6.1 可重复注解：① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
                    ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。

     6.2 类型注解：
     ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
     ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。

      *
 * @author shkstart
 * @create 2019 上午 11:37
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

        Date date = new Date(2020, 10, 11);
        System.out.println(date);

        @SuppressWarnings("unused")
        int num = 10;

//        System.out.println(num);

        @SuppressWarnings({ "unused", "rawtypes" })
        ArrayList list = new ArrayList();
    }

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(int i = 0;i < annotations.length;i++){
            System.out.println(annotations[i]);
        }
    }
}


//jdk 8之前的写法：
//@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value="hi")})
@MyAnnotation(value="hi")
@MyAnnotation(value="abc")
class Person{
    private String name;
    private int age;

    public Person() {
    }
    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

class Student extends Person implements Info{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    public void show() {

    }
}

class Generic<@MyAnnotation T>{

    public void show() throws @MyAnnotation RuntimeException{

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }

    
}
```



#### 自定义注解

```java
/**
3. 如何自定义注解：参照@SuppressWarnings定义
      * ① 注解声明为：@interface
      * ② 内部定义成员，通常使用value表示
      * ③ 可以指定成员的默认值，使用default定义
      * ④ 如果自定义注解没有成员，表明是一个标识作用。

     如果注解有成员，在使用注解时，需要指明成员的值。
     自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
     自定义注解通过都会指明两个元注解：Retention、Target
*/

@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {

    String value() default "hello";
}
```





## 集合



#### 集合框架

```java
/**
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *       比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用
 *
 * @author shkstart
 * @create 2019 下午 4:08
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        //add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size():获取添加的元素的个数
        System.out.println(coll.size());//4

        //addAll(Collection coll1):将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size());//6
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());

    }

}
```



#### Collection接口中声明的方法



**add(Object e):将元素e添加到集合coll中**

**size():获取添加的元素的个数**

**clear():清空集合元素**

**isEmpty():判断当前集合是否为空**



**1.contains(Object obj):判断当前集合中是否包含obj**

**2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。**

**3.remove(Object obj):从当前集合中移除obj元素。**

**4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。**

**5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合**

**6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。**

**7.hashCode():返回当前对象的哈希值**

**8.集合 --->数组：toArray()**

   **拓展：数组 --->集合:调用Arrays类的静态方法asList()**

**9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试**



```java
/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */
public class CollectionTest {


    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
//        Person p = new Person("Jerry",20);
//        coll.add(p);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        //1.contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()。
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
//        System.out.println(coll.contains(p));//true
        System.out.println(coll.contains(new Person("Jerry",20)));//false -->true

        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1 = Arrays.asList(123,4567);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2(){
        //3.remove(Object obj):从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.remove(1234);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);


    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry",20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));


    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试

    }
}
```





#### 迭代器Iterator

**集合元素的遍历操作，使用迭代器Iterator接口**

```java
/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 * 默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
//        for(int i = 0;i < coll.size();i++){
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        ////hasNext():判断是否还有下一个元素
        while(iterator.hasNext()){
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){

        Collection coll = ne	w ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //错误方式一：
//        Iterator iterator = coll.iterator();
//        while((iterator.next()) != null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }


    }

    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    // 再调用remove都会报IllegalStateException。
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
//            iterator.remove();
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
//                iterator.remove();
            }

        }
        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
```



#### foreach循环

```java
/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 */
public class ForTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器。
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //for(数组元素的类型 局部变量 : 数组对象)
        for(int i : arr){
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3(){

        String[] arr = new String[]{"MM","MM","MM"};

//        //方式一：普通for赋值
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for(String s : arr){
            s = "GG";
        }

        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }


    }
}
```



#### List接口



**List接口中的常用方法**



**void add(int index, Object ele):在index位置插入ele元素**
**boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来**
**Object get(int index):获取指定index位置的元素**
**int indexOf(Object obj):返回obj在集合中首次出现的位置**
**int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置**
**Object remove(int index):移除指定index位置的元素，并返回此元素**
**Object set(int index, Object ele):设置指定index位置的元素为ele**
**List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合**

```java
/**
 * 1. List接口框架
 *
 *    |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。  -->“动态”数组,替换原有的数组
 *              |----ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
 *              |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 *              |----Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 *
 *
 *   2. ArrayList的源码分析：
 *   2.1 jdk 7情况下
 *      ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *      list.add(123);//elementData[0] = new Integer(123);
 *      ...
 *      list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
 *      默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *      结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *   2.2 jdk 8中ArrayList的变化：
 *      ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没有创建长度为10的数组
 *
 *      list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
 *      ...
 *      后续的添加和扩容操作与jdk 7 无异。
 *   2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
 *            的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 *
 *  3. LinkedList的源码分析：
 *      LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);//将123封装到Node中，创建了Node对象。
 *
 *      其中，Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
             E item;
             Node<E> next;
             Node<E> prev;

             Node(Node<E> prev, E element, Node<E> next) {
             this.item = element;
             this.next = next;
             this.prev = prev;
             }
         }
 *
 *   4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
 *      在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 *  面试题：ArrayList、LinkedList、Vector三者的异同？
 *  同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *  不同：见上
 *
 *
 *
 *   5. List接口中的常用方法
 *
 * @author shkstart
 * @create 2019 上午 11:39
 */
public class ListTest {

    /*
void add(int index, Object ele):在index位置插入ele元素
boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
Object get(int index):获取指定index位置的元素
int indexOf(Object obj):返回obj在集合中首次出现的位置
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
Object remove(int index):移除指定index位置的元素，并返回此元素
Object set(int index, Object ele):设置指定index位置的元素为ele
List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

总结：常用方法
增：add(Object obj)
删：remove(int index) / remove(Object obj)
改：set(int index, Object ele)
查：get(int index)
插：add(int index, Object ele)
长度：size()
遍历：① Iterator迭代器方式
     ② 增强for循环
     ③ 普通的循环

     */
    
    
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
//        list.add(list1);
        System.out.println(list.size());//9

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));

    }
    
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置。如果不存在，返回-1.
        int index = list.indexOf(4567);
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置。如果不存在，返回-1.
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间的子集合
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);


    }
    
    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***************");

        //方式二：增强for循环
        for(Object obj : list){
            System.out.println(obj);
        }

        System.out.println("***************");

        //方式三：普通for循环
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

}
```



####  Set接口

 

```java
/**
 * 1. Set接口的框架：
 *
 * |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *              |----HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
 *                  |----LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
 *                                      对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
 *              |----TreeSet：可以按照添加对象的指定属性，进行排序，底层红黑树。
 *
 *
 *  1. Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 *
 *  2. 要求：向Set(主要指：HashSet、LinkedHashSet)中添加的数据，其所在的类一定要重写hashCode()和equals()
 *     要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 *      重写两个方法的小技巧：对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 *
 *
 * @author shkstart
 * @create 2019 下午 3:40
 */
public class SetTest {
    /*
    一、Set：存储无序的、不可重复的数据
    以HashSet为例说明：
    1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的。

    2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true.即：相同的元素只能添加一个。

    二、添加元素的过程：以HashSet为例：
        我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
        此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置），判断
        数组此位置上是否已经有元素：
            如果此位置上没有其他元素，则元素a添加成功。 --->情况1
            如果此位置上有其他元素b(或以链表形式存在的多个元素），则比较元素a与元素b的hash值：
                如果hash值不相同，则元素a添加成功。--->情况2
                如果hash值相同，进而需要调用元素a所在类的equals()方法：
                       equals()返回true,元素a添加失败
                       equals()返回false,则元素a添加成功。--->情况2

        对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储。
        jdk 7 :元素a放到数组中，指向原来的元素。
        jdk 8 :原来的元素在数组中，指向元素a
        总结：七上八下

        HashSet底层：数组+链表的结构。

     */

    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个
    //数据和后一个数据。
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
```



**treeSet**

```java
public class TreeSetTest {

    /*
    1.向TreeSet中添加的数据，要求是相同类的对象。
    2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）


    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

            //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
```

1. 集合Collection中存储的如果是自定义类的对象，需要自定义类重写哪个方法？为什么？

equals()方法。 contains() /remove()/retainsAll() ….

List：equals()方法

Set：(HashSet、LinkedHashSet为例)：equals()、hashCode()

   (TreeSet为例)：Comparable：compareTo(Object obj)

​                      Comparator：compare(Object o1,Object o2)

2. ArrayList,LinkedList,Vector三者的相同点与不同点？【面试题】

List  Map Set

```java
//练习：在List内去除重复数字值，要求尽量简单
public static List duplicateList(List list) {
    HashSet set = new HashSet();
    set.addAll(list);
    return new ArrayList(set);
}
@Test
public void test2(){
    List list = new ArrayList();
    list.add(new Integer(1));
    list.add(new Integer(2));
    list.add(new Integer(2));
    list.add(new Integer(4));
    list.add(new Integer(4));
    List list2 = duplicateList(list);
    for (Object integer : list2) {
        System.out.println(integer);
    }
}
```



#### map接口

```java
/**
 * 一、Map的实现类的结构：
 *  |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 *         |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
 *              |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                      对于频繁的遍历操作，此类执行效率高于HashMap。
 *         |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                      底层使用红黑树
 *         |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *              |----Properties:常用来处理配置文件。key和value都是String类型
 *
 *
 *      HashMap的底层：数组+链表  （jdk7及之前）
 *                    数组+链表+红黑树 （jdk 8）
 *
 *
 *  面试题：
 *  1. HashMap的底层实现原理？
 *  2. HashMap 和 Hashtable的异同？
 *  3. CurrentHashMap 与 Hashtable的异同？（暂时不讲）
 *
 *  二、Map结构的理解：
 *    Map中的key:无序的、不可重复的，使用Set存储所有的key  ---> key所在的类要重写equals()和hashCode() （以HashMap为例）
 *    Map中的value:无序的、可重复的，使用Collection存储所有的value --->value所在的类要重写equals()
 *    一个键值对：key-value构成了一个Entry对象。
 *    Map中的entry:无序的、不可重复的，使用Set存储所有的entry
 *
 *  三、HashMap的底层实现原理？以jdk7为例说明：
 *      HashMap map = new HashMap():
 *      在实例化以后，底层创建了长度是16的一维数组Entry[] table。
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1):
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
 *      如果此位置上的数据为空，此时的key1-value1添加成功。 ----情况1
 *      如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据
 *      的哈希值：
 *              如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。----情况2
 *              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
 *                      如果equals()返回false:此时key1-value1添加成功。----情况3
 *                      如果equals()返回true:使用value1替换value2。
 *
 *       补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *      在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *      jdk8 相较于jdk7在底层实现方面的不同：
 *      1. new HashMap():底层没有创建一个长度为16的数组
 *      2. jdk 8底层的数组是：Node[],而非Entry[]
 *      3. 首次调用put()方法时，底层创建长度为16的数组
 *      4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *         4.1 形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
           4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *      threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 *  四、LinkedHashMap的底层实现原理（了解）
 *      源码中：
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
             Entry<K,V> before, after;//能够记录添加的元素的先后顺序
             Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
             }
         }
 *
 *
 *   五、Map中定义的方法：
 添加、删除、修改操作：
 Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 void putAll(Map m):将m中的所有key-value对存放到当前map中
 Object remove(Object key)：移除指定key的key-value对，并返回value
 void clear()：清空当前map中的所有数据
 元素查询的操作：
 Object get(Object key)：获取指定key对应的value
 boolean containsKey(Object key)：是否包含指定的key
 boolean containsValue(Object value)：是否包含指定的value
 int size()：返回map中key-value对的个数
 boolean isEmpty()：判断当前map是否为空
 boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 元视图操作的方法：
 Set keySet()：返回所有key构成的Set集合
 Collection values()：返回所有value构成的Collection集合
 Set entrySet()：返回所有key-value对构成的Set集合

 *总结：常用方法：
 * 添加：put(Object key,Object value)
 * 删除：remove(Object key)
 * 修改：put(Object key,Object value)
 * 查询：get(Object key)
 * 长度：size()
 * 遍历：keySet() / values() / entrySet() 
 */
public class MapTest {

    /*
 元视图操作的方法：
 Set keySet()：返回所有key构成的Set集合
 Collection values()：返回所有value构成的Collection集合
 Set entrySet()：返回所有key-value对构成的Set集合

     */


    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
        }
        System.out.println();
        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println();
        //遍历所有的key-value
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
        System.out.println();
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);

        }

    }


    /*
 元素查询的操作：
 Object get(Object key)：获取指定key对应的value
 boolean containsKey(Object key)：是否包含指定的key
 boolean containsValue(Object value)：是否包含指定的value
 int size()：返回map中key-value对的个数
 boolean isEmpty()：判断当前map是否为空
 boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        // Object get(Object key)
        System.out.println(map.get(45));
        //containsKey(Object key)
        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);

        isExist = map.containsValue(123);
        System.out.println(isExist);

        map.clear();

        System.out.println(map.isEmpty());

    }

    /*
     添加、删除、修改操作：
 Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 void putAll(Map m):将m中的所有key-value对存放到当前map中
 Object remove(Object key)：移除指定key的key-value对，并返回value
 void clear()：清空当前map中的所有数据
     */
    @Test
    public void test3(){
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        //修改
        map.put("AA",87);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);

        System.out.println(map);

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        //clear()
        map.clear();//与map = null操作不同
        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void test2(){
        Map map = new HashMap();
        map = new LinkedHashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);
    }


    @Test
    public void test1(){
        Map map = new HashMap();
//        map = new Hashtable();
        map.put(null,123);

    }
```



##### HashMap的底层实现原理？

```
三、HashMap的底层实现原理？以jdk7为例说明：
*      HashMap map = new HashMap():
*      在实例化以后，底层创建了长度是16的一维数组Entry[] table。
*      ...可能已经执行过多次put...
*      map.put(key1,value1):
*      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中的存放位置。
*      如果此位置上的数据为空，此时的key1-value1添加成功。 ----情况1
*      如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据
*      的哈希值：
*              如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。----情况2
*              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
*                      如果equals()返回false:此时key1-value1添加成功。----情况3
*                      如果equals()返回true:使用value1替换value2。
*
*       补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
*
*      在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
*
*      jdk8 相较于jdk7在底层实现方面的不同：
*      1. new HashMap():底层没有创建一个长度为16的数组
*      2. jdk 8底层的数组是：Node[],而非Entry[]
*      3. 首次调用put()方法时，底层创建长度为16的数组
*      4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
*         4.1 形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
          4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。
*
*      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
*      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
*      threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
*      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
*      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
*
```



##### TreeMap（排序）

```java
public class TreeMapTest {

    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序 、定制排序
    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配！");
            }
        });
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
    }


}
```

User.java

```java
//按照姓名从大到小排列,年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
//            return -this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age,user.age);
            }
        }else{
            throw new RuntimeException("输入的类型不匹配");
        }

    }
```



##### properties

```java
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args)  {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
```



##### Collections工具类

```java
/**
 * Collections:操作Collection、Map的工具类
 *
 * 面试题：Collection 和 Collections的区别？
 
 * java.util.Collection 是一个 集合接口。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口    的意义是为各种具体的集合提供了最大化的统一操作方式。
 *java.util.Collections 是一个包装类。它包含有各种有关集合操作的 静态多态方法。此类 不能实例化，就像一 个工具类，服务于Java的Collection框架。
 
 * @author shkstart
 * @create 2019 下午 4:19
 */
public class CollectionsTest {

/*
reverse(List)：反转 List 中元素的顺序
shuffle(List)：对 List 集合元素进行随机排序
sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
Object min(Collection)
Object min(Collection，Comparator)
int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
void copy(List dest,List src)：将src中的内容复制到dest中
boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值

 */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        //报异常：IndexOutOfBoundsException("Source does not fit in dest")
//        List dest = new ArrayList();
//        Collections.copy(dest,list);
        //正确的：
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//list.size();
        Collections.copy(dest,list);

        System.out.println(dest);


        /*
        Collections 类中提供了多个 synchronizedXxx() 方法，
        该方法可使将指定集合包装成线程同步的集合，从而可以解决
        多线程并发访问集合时的线程安全问题

         */
        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);


    }

    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,1,2);
        int frequency = Collections.frequency(list, 123);

        System.out.println(list);
        System.out.println(frequency);

    }

}
```































## 泛型

------

​        所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类 型或者是某个方法的返回值及参数类型。这个类型参数将在使用时（例如， 继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实 际的类型参数，也称为类型实参）。



#### 在集合中使用泛型

```java
/**
 *
 * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *  总结：
 *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *  ② 在实例化集合类时，可以指明具体的泛型类型
 *  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *    比如：add(E e)  --->实例化以后：add(Integer e)
 *  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest1.java
 */
public class GenericTest {


    //在集合中使用泛型之前的情况：
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);

        }

    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
       ArrayList<Integer> list =  new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一：
//        for(Integer score : list){
//            //避免了强转操作
//            int stuScore = score;
//
//            System.out.println(stuScore);
//
//        }
        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
//        Map<String,Integer> map = new HashMap<String,Integer>();
        //jdk7新特性：类型推断
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }

    }


}
```





#### 自定义泛型结构



1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如： 

2. 泛型类的构造器如下：public GenericClass(){}。 而下面是错误的：public GenericClass(){} 
3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。 
4. .泛型不同的引用不能相互赋值。 >尽管在编译时ArrayList和ArrayList是两种类型，但是，在运行时只有 一个ArrayList被加载到JVM中。 
5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价 于Object。经验：泛型要使用一路都用。要不用，一路都不要用。 
6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
7.  jdk1.7，泛型的简化操作：ArrayList flist = new ArrayList<>(); 
8.  泛型的指定中不能使用基本数据类型，可以使用包装类替换



```java
/**
 * 自定义泛型类
 */
public class Order<T> {

    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderT;

    public Order(){
        //编译不通过
//        T[] arr = new T[10];
        //编译通过
        T[] arr = (T[]) new Object[10];
    }

    public Order(String orderName,int orderId,T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //如下的三个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
    //静态方法中不能使用类的泛型。
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    public void show(){
        //编译不通过
//        try{
//
//
//        }catch(T t){
//
//        }

    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E>  List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }
}
```



**GenericTest1.java**

```java
/** 如何自定义泛型结构：泛型类、泛型接口；泛型方法。
 *
 * 1. 关于自定义泛型类、泛型接口：
 *
 *
 *
 * @author shkstart
 * @create 2019 上午 11:09
 */
public class GenericTest1 {

    @Test
    public void test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");

        order1.setOrderT("AA:hello");

    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }

    @Test
    public void test3(){

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //泛型不同的引用不能相互赋值。
//        list1 = list2;

        Person p1 = null;
        Person p2 = null;
        p1 = p2;


    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型。
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
```



**SubOrder.java**

```java
public class SubOrder extends Order<Integer> {//SubOrder:不是泛型类


    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }


}
```



**SubOrder1.java**

```java
public class SubOrder1<T> extends Order<T> {//SubOrder1<T>:仍然是泛型类
}
```







#### 泛型在继承方面的体现

```java
/**
 * 1. 泛型在继承方面的体现
 */
public class GenericTest {

    /*
    1. 泛型在继承方面的体现

      虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。

       补充：类A是类B的父类，A<G> 是 B<G> 的父类

     */
    @Test
    public void test1(){

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        //编译不通过
//        Date date = new Date();
//        str = date;
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
//        list1 = list2;
        /*
        反证法：
        假设list1 = list2;
           list1.add(123);导致混入非String的数据。出错。

         */

        show(list1);
        show1(list2);

    }



    public void show1(List<String> list){

    }

    public void show(List<Object> list){

    }

    @Test
    public void test2(){

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();

    }
```



#### 通配符的使用

```java
/*
    2. 通配符的使用
       通配符：?

       类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
     */

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过
//        print(list1);
//        print(list2);


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
//        list.add("DD");
//        list.add('?');

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object。
        Object o = list.get(0);
        System.out.println(o);


    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用。
        ? extends A:
                G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类

        ? super A:
                G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类

     */
    @Test
    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过
//        Person obj = list2.get(0);

        //写入数据：
        //编译不通过
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());

    }
```







## IO流

------



#### File类

```java
/**
 * File类的使用
 *
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *    并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
 */
public class FileTest {
    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
     windows:\\
     unix:/
     */
    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//相对于当前module
        File file2 =  new File("D:\\workspace_idea1\\JavaSenior\\day08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2：
        File file3 = new File("D:\\workspace_idea1","JavaSenior");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    /*
public String getAbsolutePath()：获取绝对路径
public String getPath() ：获取路径
public String getName() ：获取名称
public String getParent()：获取上层文件目录路径。若无，返回null
public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
public long lastModified() ：获取最后一次的修改时间，毫秒值

如下的两个方法适用于文件目录：
public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组


     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
    @Test
    public void test3(){
        File file = new File("D:\\workspace_idea1\\JavaSenior");

        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }

    }
    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
     比如：file1.renameTo(file2)为例：
        要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);

    }
    /*
public boolean isDirectory()：判断是否是文件目录
public boolean isFile() ：判断是否是文件
public boolean exists() ：判断是否存在
public boolean canRead() ：判断是否可读
public boolean canWrite() ：判断是否可写
public boolean isHidden() ：判断是否隐藏

     */
    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("d:\\io");
        file2 = new File("d:\\io1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }
    /*
    创建硬盘中对应的文件或文件目录
public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建

    删除磁盘中的文件或文件目录
public boolean delete()：删除文件或者文件夹
    删除注意事项：Java中的删除不走回收站。

     */
    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }


    }
    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("d:\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("D:\\io\\io1\\io4");
        file3 = new File("D:\\io\\io1");
        System.out.println(file3.delete());
    }
}
```



**练习**

```java
@Test
public void test1() throws IOException {
    File file = new File("D:\\io\\io1\\hello.txt");
    //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
    File destFile = new File(file.getParent(),"haha.txt");
    boolean newFile = destFile.createNewFile();
    if(newFile){
        System.out.println("创建成功！");
    }
}
```

```java
/**
 * 课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 */
public class FindJPGFileTest {

   @Test
   public void test1(){
      File srcFile = new File("d:\\code");
      
      String[] fileNames = srcFile.list();
      for(String fileName : fileNames){
         if(fileName.endsWith(".jpg")){
            System.out.println(fileName);
         }
      }
   }
   @Test
   public void test2(){
      File srcFile = new File("d:\\code");
      
      File[] listFiles = srcFile.listFiles();
      for(File file : listFiles){
         if(file.getName().endsWith(".jpg")){
            System.out.println(file.getAbsolutePath());
         }
      }
   }
   /*
    * File类提供了两个文件过滤器方法
    * public String[] list(FilenameFilter filter)
    * public File[] listFiles(FileFilter filter)

    */
   @Test
   public void test3(){
      File srcFile = new File("d:\\code");
      
      File[] subFiles = srcFile.listFiles(new FilenameFilter() {
         
         @Override
         public boolean accept(File dir, String name) {
            return name.endsWith(".jpg");
         }
      });
      
      for(File file : subFiles){
         System.out.println(file.getAbsolutePath());
      }
   }
   
}
```

```java
/**
 * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
   拓展1：并计算指定目录占用空间的大小
   拓展2：删除指定文件目录及其下的所有文件
 */
public class ListFilesTest {

   public static void main(String[] args) {
      // 递归:文件目录
      /** 打印出指定目录所有文件名称，包括子文件目录中的文件 */

      // 1.创建目录对象
      File dir = new File("E:\\teach\\01_javaSE\\_尚硅谷Java编程语言\\3_软件");

      // 2.打印目录的子文件
      printSubFile(dir);
   }

   public static void printSubFile(File dir) {
      // 打印目录的子文件
      File[] subfiles = dir.listFiles();

      for (File f : subfiles) {
         if (f.isDirectory()) {// 文件目录
            printSubFile(f);
         } else {// 文件
            System.out.println(f.getAbsolutePath());
         }

      }
   }

   // 方式二：循环实现
   // 列出file目录的下级内容，仅列出一级的话
   // 使用File类的String[] list()比较简单
   public void listSubFiles(File file) {
      if (file.isDirectory()) {
         String[] all = file.list();
         for (String s : all) {
            System.out.println(s);
         }
      } else {
         System.out.println(file + "是文件！");
      }
   }

   // 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
   // 建议使用File类的File[] listFiles()
   public void listAllSubFiles(File file) {
      if (file.isFile()) {
         System.out.println(file);
      } else {
         File[] all = file.listFiles();
         // 如果all[i]是文件，直接打印
         // 如果all[i]是目录，接着再获取它的下一级
         for (File f : all) {
            listAllSubFiles(f);// 递归调用：自己调用自己就叫递归
         }
      }
   }

   // 拓展1：求指定目录所在空间的大小
   // 求任意一个目录的总大小
   public long getDirectorySize(File file) {
      // file是文件，那么直接返回file.length()
      // file是目录，把它的下一级的所有大小加起来就是它的总大小
      long size = 0;
      if (file.isFile()) {
         size += file.length();
      } else {
         File[] all = file.listFiles();// 获取file的下一级
         // 累加all[i]的大小
         for (File f : all) {
            size += getDirectorySize(f);// f的大小;
         }
      }
      return size;
   }

   // 拓展2：删除指定的目录
   public void deleteDirectory(File file) {
      // 如果file是文件，直接delete
      // 如果file是目录，先把它的下一级干掉，然后删除自己
      if (file.isDirectory()) {
         File[] all = file.listFiles();
         // 循环删除的是file的下一级
         for (File f : all) {// f代表file的每一个下级
            deleteDirectory(f);
         }
      }
      // 删除自己
      file.delete();
   }

}
```



#### 流的分类

 

![image-20220124111210136](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220124111210136.png)

```
* 一、流的分类：
* 1.操作数据单位：字节流、字符流
* 2.数据的流向：输入流、输出流
* 3.流的角色：节点流、处理流
```



#### IO流体系



![image-20220124113820911](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220124113820911.png)

```
* 二、流的体系结构
* 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
* InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
* OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
* Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
* Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
*
```

---------



#### 节点流（fileReader/FileWriter）

```java
/*
    将hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException。

     */
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");//相较于当前Module
            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fr.read();
//        }

            //方式二：语法上针对于方式一的修改
            int data;
            while((data = fr.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
//            try {
//                if(fr != null)
//                    fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //或
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
//对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader1()  {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FileReader流的实例化
            fr = new FileReader(file);

            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                //方式一：
                //错误的写法
//                for(int i = 0;i < cbuf.length;i++){
//                    System.out.print(cbuf[i]);
//                }
                //正确的写法
//                for(int i = 0;i < len;i++){
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                //错误的写法,对应着方式一的错误的写法
//                String str = new String(cbuf);
//                System.out.print(str);
                //正确的写法
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容

     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,false);

            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if(fw != null){

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //不能使用字符流来处理图片等字节数据
//            File srcFile = new File("爱情与友情.jpg");
//            File destFile = new File("爱情与友情1.jpg");


            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);


            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源    
            //方式一：
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally{
//                try {
//                    if(fr != null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式二：
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
```

​          

#### 节点流（FileInputStream/FileOutputStream）

```java
**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 */
public class FileInputOutputStreamTest {

    //使用字节流FileInputStream处理文本文件，可能出现乱码。
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1. 造文件
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while((len = fis.read(buffer)) != -1){

                String str = new String(buffer,0,len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                //4.关闭资源
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream()  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情2.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\Administrator\\Desktop\\01-视频.avi";
        String destPath = "C:\\Users\\Administrator\\Desktop\\02-视频.avi";


//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

        copyFile(srcPath,destPath);


        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//618

    }

}
```



#### 缓冲流（BufferedInputStream/BufferedOutputStream）

```java

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3. 处理流，就是“套接”在已有的流的基础上。
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() throws FileNotFoundException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情3.jpg");
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);

//                bos.flush();//刷新缓冲区

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }



    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\Administrator\\Desktop\\01-视频.avi";
        String destPath = "C:\\Users\\Administrator\\Desktop\\03-视频.avi";


        copyFileWithBuffered(srcPath,destPath);


        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));//618 - 176
    }


    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制

     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            //方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
```



#### 转换流（InputStreamReader/OutputStreamWriter）

```java
/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *   InputStreamReader：将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3. 解码：字节、字节数组  --->字符数组、字符串
 *    编码：字符数组、字符串 ---> 字节、字节数组
 *
 *
 * 4.字符集
 *ASCII：美国标准信息交换码。
    用一个字节的7位可以表示。
 ISO8859-1：拉丁码表。欧洲码表
    用一个字节的8位表示。
 GB2312：中国的中文编码表。最多两个字节编码所有字符
 GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 */
public class InputStreamReaderTest {

    /*
    此时处理异常的话，仍然应该使用try-catch-finally
    InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("dbcp.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");//使用系统默认的字符集

        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.print(str);
        }

        isr.close();

    }

    /*
    此时处理异常的话，仍然应该使用try-catch-finally

    综合使用InputStreamReader和OutputStreamWriter
     */
    @Test
    public void test2() throws Exception {
        //1.造文件、造流
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        //2.读写过程
        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        //3.关闭资源
        isr.close();
        osw.close();


    }
```



#### 标准的输入输出流

```java
/*
1.标准的输入、输出流
1.1
System.in:标准的输入流，默认从键盘输入
System.out:标准的输出流，默认从控制台输出
1.2
System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。

1.3练习：
从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
直至当输入“e”或者“exit”时，退出程序。

方法一：使用Scanner实现，调用next()返回一个字符串
方法二：使用System.in实现。System.in  --->  转换流 ---> BufferedReader的readLine()

 */
public static void main(String[] args) {
    BufferedReader br = null;
    try {
        InputStreamReader isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        while (true) {
            System.out.println("请输入字符串：");
            String data = br.readLine();
            if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                System.out.println("程序结束");
                break;
            }

            String upperCase = data.toUpperCase();
            System.out.println(upperCase);

        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
```



#### 打印流

```java
/*
2. 打印流：PrintStream 和PrintWriter

2.1 提供了一系列重载的print() 和 println()
2.2 练习：
 */

@Test
public void test2() {
    PrintStream ps = null;
    try {
        FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
        // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
        ps = new PrintStream(fos, true);
        if (ps != null) {// 把标准输出流(控制台输出)改成文件
            System.setOut(ps);
        }


        for (int i = 0; i <= 255; i++) { // 输出ASCII字符
            System.out.print((char) i);
            if (i % 50 == 0) { // 每50个数据一行
                System.out.println(); // 换行
            }
        }


    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (ps != null) {
            ps.close();
        }
    }

}
```



#### 数据流

```java
/*
3. 数据流
3.1 DataInputStream 和 DataOutputStream
3.2 作用：用于读取或写出基本数据类型的变量或字符串

练习：将内存中的字符串、基本数据类型的变量写出到文件中。

注意：处理异常的话，仍然应该使用try-catch-finally.
 */
@Test
public void test3() throws IOException {
    //1.
    DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
    //2.
    dos.writeUTF("刘建辰");
    dos.flush();//刷新操作，将内存中的数据写入文件
    dos.writeInt(23);
    dos.flush();
    dos.writeBoolean(true);
    dos.flush();
    //3.
    dos.close();


}
/*
将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。

注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！

 */
@Test
public void test4() throws IOException {
    //1.
    DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
    //2.
    String name = dis.readUTF();
    int age = dis.readInt();
    boolean isMale = dis.readBoolean();

    System.out.println("name = " + name);
    System.out.println("age = " + age);
    System.out.println("isMale = " + isMale);

    //3.
    dis.close();

}
```



#### 对象流（ObjectInputStream/OjbectOutputSteam）

用于**存储和读取基本数据类型数据或对象的处理流**。它的强大之处就是可 以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。



**对象序列化机制**允许把内存中的Java对象转换成平台无关的二进制流，从 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传 输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原 来的Java对象



```
ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
```



```java
/**
 * 对象流的使用
 * 1.ObjectInputStream 和 ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 3.要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *
 * 4.序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种
 * 二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 * 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;

        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("王铭",23));
            oos.flush();

            oos.writeObject(new Person("张学良",23,1001,new Account(5000)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                //3.
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
```



```java
/**
 * Person需要满足如下的要求，方可序列化
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性
 *   也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 *
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 *
 * @author shkstart
 * @create 2019 上午 10:38
 */
public class Person implements Serializable{

    public static final long serialVersionUID = 475463534532L;

    private String name;
    private int age;
    private int id;
    private Account acct;

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, int id, Account acct) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.acct = acct;
        
        
   //.....get，set，tuString
       
       
}

class Account implements Serializable{
    public static final long serialVersionUID = 4754534532L;
    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {

        this.balance = balance;
    }
}
```





#### 随机存取文件流(RandomAccessFile)



```java
/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * @author shkstart
 * @create 2019 上午 11:18
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("爱情与友情.jpg"),"r");
            raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"),"rw");
            //2.
            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());//

        raf1.close();

    }
    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len)) ;
        }
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();

        //思考：将StringBuilder替换为ByteArrayOutputStream
    }
}
```



#### Path、Paths、Files



<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220129172151257.png" alt="image-20220129172151257" style="zoom:80%;" />

<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220129172224774.png" alt="image-20220129172224774" style="zoom:80%;" />

<img src="C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220129172258647.png" alt="image-20220129172258647" style="zoom:80%;" />



**可以导入包import org.apache.commons.io.FileUtils;**





```JAVA
/**
 * 1. jdk 7.0 时，引入了 Path、Paths、Files三个类。
 * 2.此三个类声明在：java.nio.file包下。
 * 3.Path可以看做是java.io.File类的升级版本。也可以表示文件或文件目录，与平台无关
 * <p>
 * 4.如何实例化Path:使用Paths.
 * static Path get(String first, String … more) : 用于将多个字符串串连成路径
 * static Path get(URI uri): 返回指定uri对应的Path路径
 *
 * @author shkstart
 * @create 2019 下午 2:44
 */
public class PathTest {

    //如何使用Paths实例化Path
    @Test
    public void test1() {
        Path path1 = Paths.get("d:\\nio\\hello.txt");//new File(String filepath)

        Path path2 = Paths.get("d:\\", "nio\\hello.txt");//new File(String parent,String filename);

        System.out.println(path1);
        System.out.println(path2);

        Path path3 = Paths.get("d:\\", "nio");
        System.out.println(path3);
    }

    //Path中的常用方法
    @Test
    public void test2() {
        Path path1 = Paths.get("d:\\", "nio\\nio1\\nio2\\hello.txt");
        Path path2 = Paths.get("hello.txt");

//    String toString() ： 返回调用 Path 对象的字符串表示形式
        System.out.println(path1);

//    boolean startsWith(String path) : 判断是否以 path 路径开始
        System.out.println(path1.startsWith("d:\\nio"));
//    boolean endsWith(String path) : 判断是否以 path 路径结束
        System.out.println(path1.endsWith("hello.txt"));
//    boolean isAbsolute() : 判断是否是绝对路径
        System.out.println(path1.isAbsolute() + "~");
        System.out.println(path2.isAbsolute() + "~");
//    Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
        System.out.println(path1.getParent());
        System.out.println(path2.getParent());
//    Path getRoot() ：返回调用 Path 对象的根路径
        System.out.println(path1.getRoot());
        System.out.println(path2.getRoot());
//    Path getFileName() : 返回与调用 Path 对象关联的文件名
        System.out.println(path1.getFileName() + "~");
        System.out.println(path2.getFileName() + "~");
//    int getNameCount() : 返回Path 根目录后面元素的数量
//    Path getName(int idx) : 返回指定索引位置 idx 的路径名称
        for (int i = 0; i < path1.getNameCount(); i++) {
            System.out.println(path1.getName(i) + "*****");
        }

//    Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
        System.out.println(path1.toAbsolutePath());
        System.out.println(path2.toAbsolutePath());
//    Path resolve(Path p) :合并两个路径，返回合并后的路径对应的Path对象
        Path path3 = Paths.get("d:\\", "nio");
        Path path4 = Paths.get("nioo\\hi.txt");
        path3 = path3.resolve(path4);
        System.out.println(path3);

//    File toFile(): 将Path转化为File类的对象
        File file = path1.toFile();//Path--->File的转换

        Path newPath = file.toPath();//File--->Path的转换

    }


}
```

```JAVA
public class FilesTest {

   @Test
   public void test1() throws IOException{
      Path path1 = Paths.get("d:\\nio", "hello.txt");
      Path path2 = Paths.get("atguigu.txt");
      
//    Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
      //要想复制成功，要求path1对应的物理上的文件存在。path1对应的文件没有要求。
//    Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
      
//    Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
      //要想执行成功，要求path对应的物理上的文件目录不存在。一旦存在，抛出异常。
      Path path3 = Paths.get("d:\\nio\\nio1");
//    Files.createDirectory(path3);
      
//    Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件
      //要想执行成功，要求path对应的物理上的文件不存在。一旦存在，抛出异常。
      Path path4 = Paths.get("d:\\nio\\hi.txt");
//    Files.createFile(path4);
      
//    void delete(Path path) : 删除一个文件/目录，如果不存在，执行报错
//    Files.delete(path4);
      
//    void deleteIfExists(Path path) : Path对应的文件/目录如果存在，执行删除.如果不存在，正常执行结束
      Files.deleteIfExists(path3);
      
//    Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置
      //要想执行成功，src对应的物理上的文件需要存在，dest对应的文件没有要求。
//    Files.move(path1, path2, StandardCopyOption.ATOMIC_MOVE);
      
//    long size(Path path) : 返回 path 指定文件的大小
      long size = Files.size(path2);
      System.out.println(size);

   }

   @Test
   public void test2() throws IOException{
      Path path1 = Paths.get("d:\\nio", "hello.txt");
      Path path2 = Paths.get("atguigu.txt");
//    boolean exists(Path path, LinkOption … opts) : 判断文件是否存在
      System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));

//    boolean isDirectory(Path path, LinkOption … opts) : 判断是否是目录
      //不要求此path对应的物理文件存在。
      System.out.println(Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));

//    boolean isRegularFile(Path path, LinkOption … opts) : 判断是否是文件

//    boolean isHidden(Path path) : 判断是否是隐藏文件
      //要求此path对应的物理上的文件需要存在。才可判断是否隐藏。否则，抛异常。
//    System.out.println(Files.isHidden(path1));

//    boolean isReadable(Path path) : 判断文件是否可读
      System.out.println(Files.isReadable(path1));
//    boolean isWritable(Path path) : 判断文件是否可写
      System.out.println(Files.isWritable(path1));
//    boolean notExists(Path path, LinkOption … opts) : 判断文件是否不存在
      System.out.println(Files.notExists(path1, LinkOption.NOFOLLOW_LINKS));
   }

   /**
    * StandardOpenOption.READ:表示对应的Channel是可读的。
    * StandardOpenOption.WRITE：表示对应的Channel是可写的。
    * StandardOpenOption.CREATE：如果要写出的文件不存在，则创建。如果存在，忽略
    * StandardOpenOption.CREATE_NEW：如果要写出的文件不存在，则创建。如果存在，抛异常
    *
    * @author shkstart 邮箱：shkstart@126.com
    * @throws IOException
    */
   @Test
   public void test3() throws IOException{
      Path path1 = Paths.get("d:\\nio", "hello.txt");

//    InputStream newInputStream(Path path, OpenOption…how):获取 InputStream 对象
      InputStream inputStream = Files.newInputStream(path1, StandardOpenOption.READ);

//    OutputStream newOutputStream(Path path, OpenOption…how) : 获取 OutputStream 对象
      OutputStream outputStream = Files.newOutputStream(path1, StandardOpenOption.WRITE,StandardOpenOption.CREATE);


//    SeekableByteChannel newByteChannel(Path path, OpenOption…how) : 获取与指定文件的连接，how 指定打开方式。
      SeekableByteChannel channel = Files.newByteChannel(path1, StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

//    DirectoryStream<Path>  newDirectoryStream(Path path) : 打开 path 指定的目录
      Path path2 = Paths.get("e:\\teach");
      DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path2);
      Iterator<Path> iterator = directoryStream.iterator();
      while(iterator.hasNext()){
         System.out.println(iterator.next());
      }


   }
}
```



## 网络编程

**网络编程的目的：** 直接或间接地通过网络协议与其它计算机实现数据交换，进行通讯。

**网络编程中有两个主要的问题**： 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用 

​                                                       找到主机后如何可靠高效地进行数据传输



![image-20220130150051295](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220130150051295.png)



```java
/**
 * 一、网络编程中有两个主要的问题：
 * 1.如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 2.找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素：
 * 1.对应问题一：IP和端口号
 * 2.对应问题二：提供网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 *
 *
 * 三、通信要素一：IP和端口号
 *
 * 1. IP:唯一的标识 Internet 上的计算机（通信实体）
 * 2. 在Java中使用InetAddress类代表IP
 * 3. IP分类：IPv4 和 IPv6 ; 万维网 和 局域网
 * 4. 域名:   www.baidu.com   www.mi.com  www.sina.com  www.jd.com
 *            www.vip.com
 * 5. 本地回路地址：127.0.0.1 对应着：localhost
 *
 * 6. 如何实例化InetAddress:两个方法：getByName(String host) 、 getLocalHost()
 *        两个常用方法：getHostName() / getHostAddress()
 *
 * 7. 端口号：正在计算机上运行的进程。
 * 要求：不同的进程有不同的端口号
 * 范围：被规定为一个 16 位的整数 0~65535。
 *
 * 8. 端口号与IP地址的组合得出一个网络套接字：Socket
 * @author shkstart
 * @create 2019 下午 2:30
 */
public class InetAddressTest {

    public static void main(String[] args) {

        try {
            //File file = new File("hello.txt");
            InetAddress inet1 = InetAddress.getByName("192.168.10.14");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            //获取本地ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);

            //getHostName()
            System.out.println(inet2.getHostName());
            //getHostAddress()
            System.out.println(inet2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }


}
```



#### tcp三次握手

![image-20220130160913804](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220130160913804.png)



#### tcp四次握手

![image-20220130161015337](C:\Users\86178\AppData\Roaming\Typora\typora-user-images\image-20220130161015337.png)





#### TCP的网络编程



**例子1：客户端发送信息给服务端，服务端将数据显示在控制台上**

```java
/**
 * 实现TCP的网络编程
 * 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client()  {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("192.168.14.100");
            socket = new Socket(inet,8899);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            os.write("你好，我是客户端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }
    //服务端
    @Test
    public void server()  {

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8899);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();

            //不建议这样写，可能会有乱码
//        byte[] buffer = new byte[1024];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
            //4.读取输入流中的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

            System.out.println("收到了来自于：" + socket.getInetAddress().getHostAddress() + "的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                //5.关闭资源
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
```



**例题2：客户端发送文件给服务端，服务端将文件保存在本地。**

```java
/**
 *
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 */
public class TCPTest2 {

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //5.
        fis.close();
        os.close();
        socket.close();
    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("beauty1.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //6.
        fos.close();
        is.close();
        socket.close();
        ss.close();

    }
}
```



**例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。**

```java
**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 * 并关闭相应的连接。
 */
public class TCPTest3 {

    /*
        这里涉及到的异常，应该使用try-catch-finally处理
         */
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //5.接收来自于服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bufferr = new byte[20];
        int len1;
        while((len1 = is.read(buffer)) != -1){
            baos.write(buffer,0,len1);
        }

        System.out.println(baos.toString());

        //6.
        fis.close();
        os.close();
        socket.close();
        baos.close();
    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket ss = new ServerSocket(9090);
        //2.
        Socket socket = ss.accept();
        //3.
        InputStream is = socket.getInputStream();
        //4.
        FileOutputStream fos = new FileOutputStream(new File("beauty2.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("图片传输完成");

        //6.服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，照片我已收到，非常漂亮！".getBytes());

        //7.
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();

    }
}
```





#### UDP协议的网络编程

- 类 DatagramSocket 和 DatagramPacket 实现了基于 UDP 协议网络程序。

- UDP数据报通过数据报套接字 DatagramSocket 发送和接收，系统不保证 UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。 

- DatagramPacket 对象封装了UDP数据报，在数据报中包含了发送端的IP 地址和端口号以及接收端的IP地址和端口号。 

- UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和 接收方的连接。如同发快递包裹一样。

```java
/**
 * UDPd协议的网络编程
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();



        String str = "我是UDP方式发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);

        socket.close();

    }
    //接收端
    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
```





#### URL网络编程

```java
/**
 * URL网络编程
 * 1.URL:统一资源定位符，对应着互联网的某一资源地址
 * 2.格式：
 *  http://localhost:8080/examples/beauty.jpg?username=Tom
 *  协议   主机名    端口号  资源地址           参数列表
 */
public class URLTest {

    public static void main(String[] args) {

        try {

            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");

//            public String getProtocol(  )     获取该URL的协议名
            System.out.println(url.getProtocol());
//            public String getHost(  )           获取该URL的主机名
            System.out.println(url.getHost());
//            public String getPort(  )            获取该URL的端口号
            System.out.println(url.getPort());
//            public String getPath(  )           获取该URL的文件路径
            System.out.println(url.getPath());
//            public String getFile(  )             获取该URL的文件名
            System.out.println(url.getFile());
//            public String getQuery(   )        获取该URL的查询名
            System.out.println(url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
```



```java
public class URLTest1 {

    public static void main(String[] args) {

        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg");

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("day10\\beauty3.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
    }
}
```

