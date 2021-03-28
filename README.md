# Range

## Simple Range
```java

for (var i : Range.of(1, 5)) {
    System.out.println(i);
}

```

```
1
2
3
4
5
```

## Range with a step
```java
for (var i : Range.of(1, 5, 2)) {
    System.out.println(i);
}
```

```
1
3
5
```