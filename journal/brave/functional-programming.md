## Functional Programming

I won't delve into Clojure syntax and special tools, since that is
what the exercises are for. I will focus on the important concepts that
are related to using Clojure as a programming language. The most important

> Clojure is a functional programming language. Functions are the most important
> objects in Clojure's universe

This contrasts hard with common modern languages like Javascript, C++ or Java
itself. Those are object-oriented programming languages, and thus **objects**, i.e.
entities with properties and methods, are the center of the universe. The main
characteristics of functional programming are

> * Data structures are **immutable**. Once variables are bound, their values don't
>   change during program execution.
> * Expressions should be replaceable by their values, and still yield the same results.
>   This is called **referential transparency**.
> * Functions should be **pure**: same outputs for same inputs! This is closely related
>   to referential transparency.
> * Functions are **first class citizens**. Functions are like strings or numbers. Can be
>   passed around as arguments.
> * Lazy evaluation of expressions is a key for optimization

A functional approach should be declarative, rather than imperative. That is to say, it
should be read as a set of instructions to obtain a desired result. The details of the
implementation of each step should be abstracted as much as possible.

> The most important tool for functional programming is function composition.

Complexity of data transformation is translated to complexity of functions in Clojure.
To maintain scalability and readability of code, always use several small functions and
compose them to perform complex data transformations. That way, it is easy to reason about
the whole logic of the transformations.

## Iteration in functional programming

In functional programming, loops are rarely used! That is because loops can be modelled as
iterations over arrays. A loop is a mapping from an array to another array, or from an array
to another data structure. Consider the times you iterated an array of numberings for filtering
the even ones, or aggregated them to compute their sum.

> In functional programming you use **map** to transform operation from a type A to a type B, into
> operations from a list of elements of type A, to a list of elements of type B

Whenever you want to aggregate the elements of a list, like when you what to compute their sum, the
common functional pattern is to use **reduce**. This function needs a binary operation defined over
the elements of the list. Then aggregates the elements sequentially using this binary operation.

> IMPORTANT: Filtering in Clojure is the easiest thing! Just use **filter**, with a predicate
> function that evaluates a condition over an element of the list.
