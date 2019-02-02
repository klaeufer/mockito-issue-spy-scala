[![Build Status](https://travis-ci.org/klaeufer/mockito-issue-spy-scala.svg?branch=master)](https://travis-ci.org/klaeufer/mockito-issue-spy-scala)

# Overview

Example of Mockito issue involving an interaction between genericity
and inheritance in Scala.

```
trait A[+E] { def m(): E }
class B extends A[Int] { def m() = -1 }

val s = spy(new B)
verify(s, never).m() // <-- fails with NPE in m() above
```

# How to run

```
sbt "testOnly SimpleTest"
```