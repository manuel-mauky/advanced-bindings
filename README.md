# Advanced-Bindings for JavaFX (8)

[![Build Status](https://travis-ci.org/lestard/advanced-bindings.svg?branch=master)](https://travis-ci.org/lestard/advanced-bindings)


**advanced-bindings** is a collection of useful helpers and custom binding implementations to simplify the
development of applications that are heavily based on JavaFX's Properties
and Bindings.



## New Features?

If you have ideas for new custom bindings that could be added to the library feel free to add an [issue](../../issues).


## Links

[JavaDoc](https://lestard.github.io/advanced-bindings/javadoc/0.4.0/)


##<a name="dependencies"></a> Maven Dependencies

**Advanced-Bindings** releases are available in the Maven Central Repository.
You can use it like this:

### Stable release

#### Gradle:
```groovy
compile 'eu.lestard:advanced-bindings:0.4.0'
```

#### Maven:
```xml
<dependency>
    <groupId>eu.lestard</groupId>
    <artifactId>advanced-bindings</artifactId>
    <version>0.4.0</version>
</dependency>
```


### Current Development version (Snapshot)

The development version is published automatically to the Sonatype Snapshot repository.

#### Gradle
```groovy
repositories {
    maven {
        url "https://oss.sonatype.org/content/repositories/snapshots/"
    }
}

dependencies {
    compile 'eu.lestard:advanced-bindings:0.5.0-SNAPSHOT'
}
```

#### Maven

```xml
<dependency>
    <groupId>eu.lestard</groupId>
    <artifactId>advanced-bindings</artifactId>
    <version>0.5.0-SNAPSHOT</version>
</dependency>
```




## Features

### [MathBindings](https://lestard.github.io/advanced-bindings/javadoc/0.4.0/eu/lestard/advanced_bindings/api/MathBindings.html)
`eu.lestard.advanced_bindings.api.MathBindings.*`

Contains Bindings for all methods of [java.lang.Math](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)

Example:

```java
@Test
public void testPow(){

    DoubleProperty a = new SimpleDoubleProperty(3);
    DoubleProperty b = new SimpleDoubleProperty(2);

    final DoubleBinding pow = MathBindings.pow(a, b);

    // 3^2 = 9
    assertThat(pow).hasValue(9.0);

    a.set(5);
    b.set(3);

    // 5^3 = 125
    assertThat(pow).hasValue(125.0);
}
```

### [NumberBindings](https://lestard.github.io/advanced-bindings/javadoc/0.4.0/eu/lestard/advanced_bindings/api/NumberBindings.html)


Example: **safeDevide**
A binding to express a division like [Bindings.divide](https://docs.oracle.com/javase/8/javafx/api/javafx/beans/binding/Bindings.html#divide-javafx.beans.value.ObservableNumberValue-javafx.beans.value.ObservableNumberValue-) with the difference that **no**
`ArithmeticException` will be thrown when a division by zero happens. Instead a default value of `0` is used (or another value defined by the user).

This can be useful because with the standard divide binding you can run into problems when defining something like this:

```java
IntegerProperty a = new SimpleIntegerProperty();
IntegerProperty b = new SimpleIntegerProperty();

NumberBinding result = Bindings
  .when(b.isEqualTo(0))
  .then(0)
  .otherwise(a.divide(b));
```

This won't work as expected and will throw an `ArithmeticException` because the expression `a.divide(b)`
is evaluated independently from the `b.isEqualTo(0)` condition.

With Advanced-Bindings you can write this instead:

```java
IntegerProperty a = new SimpleIntegerProperty();
IntegerProperty b = new SimpleIntegerProperty();

IntegerBinding result = NumberBindings.divideSafe(a,b);
```

This won't throw an `ArithmenticException` even when `b` has a value of `0`.
While this is "wrong" from a mathematical point of view it can simplify the development
of bindings based applications a lot, for example when `b` is bound to a Slider that
has an initial value of `0`.


Example: **isNaN**

```java
@Test
public void testIsNan(){
    DoubleProperty a = new SimpleDoubleProperty();
    DoubleProperty b = new SimpleDoubleProperty();

    final DoubleBinding quotient = a.divide(b);
    BooleanBinding nan = NumberBindings.isNaN(quotient);


    a.set(2);
    b.set(4);

    assertThat(nan).isFalse();


    a.set(0);
    b.set(0);

    assertThat(nan).isTrue();
}

```

Example: **isInfinite**
```java
@Test
public void testIsInfinite(){
    DoubleProperty a = new SimpleDoubleProperty();
    DoubleProperty b = new SimpleDoubleProperty();

    DoubleBinding product =  a.multiply(b);

    BooleanBinding infinite = NumberBindings.isInfinite(product);


    a.set(2);
    b.set(4);

    assertThat(infinite).isFalse();

    b.set(Double.MAX_VALUE);

    assertThat(infinite).isTrue();
}
```

### [StringBindings](https://lestard.github.io/advanced-bindings/javadoc/0.4.0/eu/lestard/advanced_bindings/api/StringBindings.html)

Example: **RegExp**

```java
@Test
public void testMatches(){
    StringProperty text = new SimpleStringProperty();

    String pattern = "[0-9]*";  // only numbers are allowed

    BooleanBinding matches = StringBindings.matches(text, pattern);


    text.set("19");

    assertThat(matches).isTrue();


    text.set("no number");

    assertThat(matches).isFalse();
}
```


### [CollectionBindings](https://lestard.github.io/advanced-bindings/javadoc/0.4.0/eu/lestard/advanced_bindings/api/CollectionBindings.html)

Example: **Sum** of all integers in an observable list

```java
@Test
public void testSum(){
    ObservableList<Integer> numbers = FXCollections.observableArrayList();

    NumberBinding sum = CollectionBindings.sum(numbers);


    numbers.addAll(1, 2, 3, 5, 8, 13, 21);

    assertThat(sum).hasValue(53.0);

    numbers.add(34);

    assertThat(sum).hasValue(87.0);
}

```

### [SwitchBindings](https://lestard.github.io/advanced-bindings/javadoc/0.4.0/eu/lestard/advanced_bindings/api/SwitchBindings.html)

In JavaFX there are standard methods to create IF-THEN-ELSE bindings.
But there is no way to create something like a `switch` for use cases
where there are a lot of cases.

Advanced-Bindings has a builder to create switch like bindings:

```java
IntegerProperty base = new SimpleIntegerProperty();

ObservableValue<String> result = switchBinding(base, String.class)
      .bindCase(1, i -> "one")
      .bindCase(3, i -> "three")
      .bindCase(10, i -> "ten")
      .bindDefault(() -> "nothing")
      .build();
```

There are two differences to the normal `switch` statement of Java:
- While the standard `switch` statement has a limitation to numbers, Strings and Enums.
Only those types can be used as control variable. There is no such limitation for the Switch binding.
Every type that has a properly overwritten `equals` method can be used.
- There is no "fall-through" and therefore no `break` is needed.
