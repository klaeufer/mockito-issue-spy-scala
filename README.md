[![Build Status](https://travis-ci.org/klaeufer/mockito-issue-spy-scala.svg?branch=master)](https://travis-ci.org/klaeufer/mockito-issue-spy-scala)

# Overview

Example of Mockito issue involving an interaction between genericity
and subtyping in Scala on Linux.

```
trait A[+E] { def m(): E }
class B extends A[Int] { def m() = -1 }

val s = spy(new B)
verify(s, never).m() // <-- on Linux fails with NPE in m() above
```

# How to run

```
sbt "testOnly SimpleTest"
```