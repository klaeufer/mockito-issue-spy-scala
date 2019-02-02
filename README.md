[![Build Status](https://travis-ci.org/klaeufer/mockito-issue-spy-scala.svg?branch=master)](https://travis-ci.org/klaeufer/mockito-issue-spy-scala)

# Overview

Reported as https://github.com/mockito/mockito/issues/1605

Example of spying on implementation of generic trait in Scala resulting in an NPE.


```
trait A[+E] { def m(): E }
class B extends A[Int] { def m() = -1 }

val s = spy(new B)
verify(s, never).m() // <-- on Linux this fails with NPE in m() above
```

The error goes away when removing the implementation relationship between B and A or making A nongeneric.

The error also goes away when creating and applying a thunk in the method body:

```
  def m() = (() => -1)()
```

# Environment

- Oracle Java 11
- Scala 2.12.x
- sbt 1.2.x
- Mockito 2.x

# How to run

```
sbt "testOnly SimpleTest"
```
