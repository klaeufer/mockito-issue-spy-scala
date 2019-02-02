[![Build Status](https://travis-ci.org/klaeufer/mockito-issue-spy-scala.svg?branch=master)](https://travis-ci.org/klaeufer/mockito-issue-spy-scala)

# Overview

Example of Mockito issue involving an interaction between genericity
and subtyping in Scala on Linux.

```
trait A[+E] { def m(): E }
class B extends A[Int] { def m() = -1 }

val s = spy(new B)
verify(s, never).m() // <-- on Linux this fails with NPE in m() above
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