# Advanced-Bindings for JavaFX (8)

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

## How to Use

Gradle: 
```groovy
compile 'eu.lestard:advanced-bindings:0.1.0'
```

Maven:
```xml
<dependency>
    <groupId>eu.lestard</groupId>
    <artifactId>advanced-bindings</artifactId>
    <version>0.1.0</version>
</dependency>
```



## Links

[JavaDoc](https://lestard.github.io/advanced-bindings/javadoc/0.1.0/)
