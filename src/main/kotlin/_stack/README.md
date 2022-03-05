Looks like having an interface that defines a generic type parameter causes weird consequences in kotlin. I need to look into it in future. For now, I just do what this book does; but unfortunately, this part of book is full of bugs.

###I found out what the big mistake was. Looks like when you have a class that has a name like the objects in the java standard library, the compiler will have a hard time resolving the ambiguity issue and winds up throwing an error like "Stack class cannot be resolved".
This problem was solved when I changed the name of the class from "Stack" to "HojatStack".