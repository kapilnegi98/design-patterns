Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers.
 Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.


  Use the Chain of Responsibility pattern when your program is expected to process different kinds of requests in
   various ways, but the exact types of requests and their sequences are unknown beforehand.

  Use the pattern when it’s essential to execute several handlers in a particular order.

  Use the CoR pattern when the set of handlers and their order are supposed to change at runtime.

  If you provide setters for a reference field inside the handler classes,
   you’ll be able to insert, remove or reorder handlers dynamically.


   PROS:
    You can control the order of request handling.
    Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform operations.
    Open/Closed Principle. You can introduce new handlers into the app without breaking the existing client code.

    Cons:
     Some requests may end up unhandled.


Can be used to design ATM
https://www.digitalocean.com/community/tutorials/chain-of-responsibility-design-pattern-in-java
