# What is Clojure?

Clojure is a Lisp-inspired programming language designed by Rich Hickey. Its compiler, transforms
clojure code into _Java bytecode_, which is executed in the _Java virtual Machine_ (JVM). As commented
in the Brave's book, clojure works kinda like this

> 1. The Clojure compiler (_clojure.jar_), transforms Clojure code into _Java bytecode_
> 2. The same process running the compiler executes the transformed bytecode in the JVM.

This already implies some things

* It should be possible to use native Java functions in clojure code (_Java interop_)
* Clojure takes advantage of the multiplatform nature of the JVM

> IMPORTANT: Clojure also targets Javascript (via _Clojurescript_), and Microsoft Common Language Runtime.
> This is cool! Since you can use Clojure for fullstack web development!

## The REPL

It stands for _Read Eval Print Loop_. As its name indicates, it is an interface for evaluating
Clojure expressions at runtime. It is one of the most important tools for clojure development.

I'm using IntelliJ as my preferred editor, since its Clojure extension (_Cursive_) is quite useful. One of
its main features is an _integrated REPL_.

> IMPORTANT: As a Clojure developer, it is fundamental to get a good grip on the REPL, since that
> allows you to prototype, debug, execute tests, and evaluate expressions in your code, among other
> useful things!
