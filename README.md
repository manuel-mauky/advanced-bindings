# Advanced-Bindings for JavaFX (8)

[![Build Status](https://travis-ci.org/lestard/advanced-bindings.svg?branch=master)](https://travis-ci.org/lestard/advanced-bindings)


**advanced-bindings** is a collection of useful helpers and custom binding implementations to simplify the
development of applications that are heavily based on JavaFX's Properties
and Bindings.

## Features

### MathBindings
`eu.lestard.advanced_bindings.api.MathBindings.*`

Contains Bindings for all methods of `java.lang.Math`

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

### NumberBindings

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

Example 2: **isInfinite**
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



### StringBindings

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


### CollectionBindings

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


## New Features?

If you have ideas for new custom bindings that could be added to the library feel free to add an [issue](../../issues).

## How to Use

Gradle:
```groovy
compile 'eu.lestard:advanced-bindings:0.4.0'
```

Maven:
```xml
<dependency>
    <groupId>eu.lestard</groupId>
    <artifactId>advanced-bindings</artifactId>
    <version>0.4.0</version>
</dependency>
```



## Links

[JavaDoc](https://lestard.github.io/advanced-bindings/javadoc/0.4.0/)
